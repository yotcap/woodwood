package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.net.URLDecoder;
import javax.mail.MessagingException;
import javax.servlet.ServletConfig; 
import javax.servlet.ServletException; 
import javax.servlet.ServletRequest; 
import javax.servlet.ServletResponse; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import javaclass.Mail;
import javaclass.resume;
import javaclass.posts;
import javaclass.Infor;
import javaclass.Mass;
public class UserServlet implements javax.servlet.Servlet{ 
	public String publicUname="王二";
	public String publicUtype="student";
	public String othername="";
	public void doPost(HttpServletRequest request,HttpServletResponse response) 
			 throws ServletException,IOException, MessagingException{
			String action = request.getParameter("action");
			
			if ("regCompany".equals(action)||"regStudent".equals(action)) {
				//用户注册
				this.regUser(request,response,action);
			} else if("logCompany".equals(action)||"logStudent".equals(action)){
				//用户登录
				this.logUser(request, response,action);
			}else if("uInforStudent".equals(action)){
				this.uInfor(request, response,action);	
			}else if("uInforCompany".equals(action)){
				this.uInforCompany(request, response);	
			}else if("Poststudent".equals(action)){
				this.Posts(request, response);
			}else if("Postcompany".equals(action)){
				this.Posts(request, response);
			}else if("index".equals(action)){
				this.Index(request,response);
			}else if("user".equals(action)){
				this.userPage(request,response);
			}else if("userCompany".equals(action)){
				this.userCompany(request,response);
			}else if("othershow".equals(action)){
				this.otherShow(request, response);
			}else if("Postmessage".equals(action)){
				this.Postmessage(request, response);
			}
	}
	//留言
	public void Postmessage(HttpServletRequest request,HttpServletResponse response) 
			 throws ServletException,IOException, MessagingException{
		DBUtil db = new DBUtil();//构建数据库对象
		String messageContent=request.getParameter("messageContent");
		Mass messageInfor=new Mass();
		messageInfor.setToUsername(othername);
		messageInfor.setContent(messageContent);
		messageInfor.setFromUsername(publicUname);
		boolean flog=db.insetMessage(messageInfor);
		if(flog){
			request.getSession().setAttribute("logerror","留言成功");//用Session保存用户名   
			 response.sendRedirect("error.jsp");
		}else{
			request.getSession().setAttribute("logerror","留言失败");//用Session保存用户名   
			 response.sendRedirect("error.jsp");
		}
	}
	//转化成int
	public static int toInt(String strNum ){
		  Integer integer = new Integer(strNum);
		  return integer.parseInt(strNum);
		 } 
	//查看别人的信息
	public void otherShow(HttpServletRequest request,HttpServletResponse response) 
			 throws ServletException,IOException, MessagingException{
		String theType = request.getParameter("theType");
		//int  theID =Integer.parseInt(request.getParameter("theID"));
		int theID = toInt(request.getParameter("theID"));
		DBUtil db = new DBUtil();//构建数据库对象
		//得到要查看的人
		String foundUsername=db.foundUser(theID);
		othername=foundUsername;
		//查看的基本信息
		if("company".equals(theType)){//查看企业
			request.getSession().setAttribute("othername",foundUsername);//用Session保存用户名   
			request.getSession().setAttribute("othertype",theType);
			db.inforShow(request,response,foundUsername);
			 db.postsShow(request,response,foundUsername);//发帖
			  response.sendRedirect("page/public/user.jsp");
		 }else if("student".equals(theType)){//查看个人
			 request.getSession().setAttribute("othername",foundUsername);//用Session保存用户名   
			request.getSession().setAttribute("othertype",theType);
			 resume info=db.resumeShow(foundUsername,publicUtype);
			 request.getSession().setAttribute("info",info);
			 db.postsShow(request,response,foundUsername);//发帖
			  response.sendRedirect("page/public/user.jsp");
		 }
		
		
	}
		//公司信息更改
		public void uInforCompany(HttpServletRequest request,HttpServletResponse response) 
				 throws ServletException,IOException, MessagingException{
			 DBUtil db = new DBUtil();//构建数据库对象
			 Infor uInfor=new Infor();
			 uInfor.setName(request.getParameter("uName"));//名字
			 uInfor.setPhone(request.getParameter("uPhone")); //电话
			 uInfor.setAddress(request.getParameter("uPlace")); //地址
			 uInfor.setEmail(request.getParameter("uEmail")); //email
			uInfor.setIntroduction(request.getParameter("text")); //简介
			boolean flog=db.setInforCompany(uInfor,publicUname);
			//boolean isOkPosts=db.getPosts(request,response,publicUname);
			
			if(flog){
				 request.getSession().setAttribute("info",uInfor);
				 //request.setAttribute("info", info);
				 response.sendRedirect("page/c/uInfo.jsp");
			}else{
				request.getSession().setAttribute("logerror","信息更改失败");
				 response.sendRedirect("error.jsp");
			}
		}
		
	//进入个人主页
	public void userPage(HttpServletRequest request,HttpServletResponse response) 
			 throws ServletException,IOException, MessagingException{
		DBUtil db = new DBUtil();//构建数据库对象
		resume info=db.resumeShow(publicUname,publicUtype);
		 request.getSession().setAttribute("info",info);
		 db.postsShow(request,response,publicUname);//发帖
		 db.messageShow(request,response,publicUname);//留言
		  response.sendRedirect("page/p/user.jsp");
	}
	//进入企业主页
		public void userCompany(HttpServletRequest request,HttpServletResponse response) 
				 throws ServletException,IOException, MessagingException{
			DBUtil db = new DBUtil();//构建数据库对象
			db.inforShow(request,response,publicUname);
			 db.postsShow(request,response,publicUname);//发帖
			 db.messageShow(request,response,publicUname);//留言
			  response.sendRedirect("page/c/user.jsp");
		}
	
	//首页
	public void Index(HttpServletRequest request,HttpServletResponse response) 
			 throws ServletException,IOException, MessagingException{
		DBUtil db = new DBUtil();//构建数据库对象
		db.getPosts(request,response);
	}
	//用户信息
	public void uInfor(HttpServletRequest request,HttpServletResponse response,String action) 
			 throws ServletException,IOException, MessagingException{
		 DBUtil db = new DBUtil();//构建数据库对象
		resume uInforStudent=new resume();
		uInforStudent.setName(request.getParameter("uName"));//名字
		uInforStudent.setSex(request.getParameter("uMale")); //性别
		uInforStudent.setPhone(request.getParameter("uPhone")); //电话
		uInforStudent.setAddress(request.getParameter("uPlace")); //地址
		uInforStudent.setBrithday(request.getParameter("uBrisDay")); //生日
		uInforStudent.setGraduationtime(request.getParameter("uGraDay")); //毕业日期
		uInforStudent.setEmail(request.getParameter("uEmail")); //email
		uInforStudent.setIncome(request.getParameter("uMoney")); //收入
		uInforStudent.setIntroduction(request.getParameter("text")); //简介
		boolean flog=db.setInfor(uInforStudent,publicUname,action);
		//boolean isOkPosts=db.getPosts(request,response,publicUname);
		
		if(flog){
			 request.getSession().setAttribute("info",uInforStudent);
			 //request.setAttribute("info", info);
			 response.sendRedirect("page/p/uInfor.jsp");
		}else{
			request.getSession().setAttribute("logerror","信息更改失败");
			 response.sendRedirect("error.jsp");
		}
	}
	
	
	//用户注册
	public void regUser(HttpServletRequest request,HttpServletResponse response,String action) 
			 throws ServletException,IOException, MessagingException{
		String userName = request.getParameter("username");//取得用户名
		 String password = request.getParameter("password");//取得密码
		 String email = request.getParameter("email");//取得email
	
		 DBUtil db = new DBUtil();//构建数据库对象
		 
				 boolean canLogin = db.registeredSuccess(userName, password,email,action);
				 if(canLogin){//根据数据库写入情况，跳转页面
					 Mail mail = new Mail();//邮件对象
					 mail.Mail(email);
				 response.sendRedirect("log.jsp");
				 }else{
					 request.getSession().setAttribute("logerror","失败");   
					 response.sendRedirect("error.jsp");
				 }
		
	}
	//用户登录
	public void logUser(HttpServletRequest request,HttpServletResponse response,String action) 
			 throws ServletException,IOException, MessagingException{
		String userName = request.getParameter("username");//取得用户名
		 String password = request.getParameter("password");//取得密码
		 DBUtil db = new DBUtil();//构建数据库对象
		 
		 int canLogin = db.logSuccess(userName, password,action);
		 if(canLogin>0){//根据登陆情况，跳转页面
			 publicUname=userName;
			 if("logCompany".equals(action)){
				 publicUtype="company";
				 request.getSession().setAttribute("username",userName);//用Session保存用户名   
				 request.getSession().setAttribute("type",publicUtype); 
				 db.inforShow(request,response,publicUname);
				 db.postsShow(request,response,publicUname);//发帖
				 db.messageShow(request,response,publicUname);//留言
				 //request.getSession().setAttribute("info",info); //个人信息
				 //request.setAttribute("info", info);
				// request.getRequestDispatcher("page/user.jsp").forward(request,response);
				 response.sendRedirect("page/c/user.jsp");
			 }else if("logStudent".equals(action)){
				 publicUtype="student";
				 request.getSession().setAttribute("username",userName);//用Session保存用户名   
				 request.getSession().setAttribute("type",publicUtype); 
				 resume info=db.resumeShow(userName,publicUtype);
				 db.postsShow(request,response,publicUname);//发帖
				 db.messageShow(request,response,publicUname);//留言
				 request.getSession().setAttribute("info",info); //个人信息
				 //request.setAttribute("info", info);
				// request.getRequestDispatcher("page/user.jsp").forward(request,response);
				 response.sendRedirect("page/p/user.jsp");
			 }
			 
		 }else{
		request.getSession().setAttribute("logerror","登录失败，请重新登录");
		 response.sendRedirect("error.jsp");
		 }
	}
	//发帖
	public void Posts(HttpServletRequest request,HttpServletResponse response) 
			 throws ServletException,IOException, MessagingException{
		DBUtil db = new DBUtil();//构建数据库对象
		posts uInforposts=new posts();
		//java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		java.util.Date currentTime = new java.util.Date();//得到当前系统时间 
		//String str_date1 = formatter.format(currentTime); //将日期时间格式化  
		String str_date2 = currentTime.toString(); //将Date型日期时间转换成字符串形式 
		uInforposts.setTitle(request.getParameter("title"));//标题
		uInforposts.setContent(request.getParameter("content"));//内容
		uInforposts.setFuser(publicUname); //用户名
		uInforposts.setUsertype(publicUtype); //用户类型
		uInforposts.setTime(str_date2); //时间
		boolean flog=db.setInforposts(uInforposts);
		if(flog){
			db.postsShow(request,response,publicUname);
			if("student".equals(publicUtype)){
				response.sendRedirect("page/p/uPosts.jsp");
			}else if("company".equals(publicUtype)){
				response.sendRedirect("page/c/uPosts.jsp");
			}
			 
		}else{
			request.getSession().setAttribute("logerror","发帖失败");
			 response.sendRedirect("error.jsp");
		}
		
		
	}
	
	 public void destroy() { 
	 }
	 
	 public ServletConfig getServletConfig() {
	  return null;
	 }
	 
	 public String getServletInfo() {
	  return null;
	 }
	 
	 public void init(ServletConfig arg0) throws ServletException {  
	 }
	 
	 public void service(ServletRequest request, ServletResponse response)
	   throws ServletException, IOException {
	  HttpServletRequest rq = (HttpServletRequest)request;
	  HttpServletResponse rs = (HttpServletResponse) response;
	  try {
		doPost(rq,rs);
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 }
	 
	}
