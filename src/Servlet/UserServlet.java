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
	public String publicUname="����";
	public String publicUtype="student";
	public String othername="";
	public void doPost(HttpServletRequest request,HttpServletResponse response) 
			 throws ServletException,IOException, MessagingException{
			String action = request.getParameter("action");
			
			if ("regCompany".equals(action)||"regStudent".equals(action)) {
				//�û�ע��
				this.regUser(request,response,action);
			} else if("logCompany".equals(action)||"logStudent".equals(action)){
				//�û���¼
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
	//����
	public void Postmessage(HttpServletRequest request,HttpServletResponse response) 
			 throws ServletException,IOException, MessagingException{
		DBUtil db = new DBUtil();//�������ݿ����
		String messageContent=request.getParameter("messageContent");
		Mass messageInfor=new Mass();
		messageInfor.setToUsername(othername);
		messageInfor.setContent(messageContent);
		messageInfor.setFromUsername(publicUname);
		boolean flog=db.insetMessage(messageInfor);
		if(flog){
			request.getSession().setAttribute("logerror","���Գɹ�");//��Session�����û���   
			 response.sendRedirect("error.jsp");
		}else{
			request.getSession().setAttribute("logerror","����ʧ��");//��Session�����û���   
			 response.sendRedirect("error.jsp");
		}
	}
	//ת����int
	public static int toInt(String strNum ){
		  Integer integer = new Integer(strNum);
		  return integer.parseInt(strNum);
		 } 
	//�鿴���˵���Ϣ
	public void otherShow(HttpServletRequest request,HttpServletResponse response) 
			 throws ServletException,IOException, MessagingException{
		String theType = request.getParameter("theType");
		//int  theID =Integer.parseInt(request.getParameter("theID"));
		int theID = toInt(request.getParameter("theID"));
		DBUtil db = new DBUtil();//�������ݿ����
		//�õ�Ҫ�鿴����
		String foundUsername=db.foundUser(theID);
		othername=foundUsername;
		//�鿴�Ļ�����Ϣ
		if("company".equals(theType)){//�鿴��ҵ
			request.getSession().setAttribute("othername",foundUsername);//��Session�����û���   
			request.getSession().setAttribute("othertype",theType);
			db.inforShow(request,response,foundUsername);
			 db.postsShow(request,response,foundUsername);//����
			  response.sendRedirect("page/public/user.jsp");
		 }else if("student".equals(theType)){//�鿴����
			 request.getSession().setAttribute("othername",foundUsername);//��Session�����û���   
			request.getSession().setAttribute("othertype",theType);
			 resume info=db.resumeShow(foundUsername,publicUtype);
			 request.getSession().setAttribute("info",info);
			 db.postsShow(request,response,foundUsername);//����
			  response.sendRedirect("page/public/user.jsp");
		 }
		
		
	}
		//��˾��Ϣ����
		public void uInforCompany(HttpServletRequest request,HttpServletResponse response) 
				 throws ServletException,IOException, MessagingException{
			 DBUtil db = new DBUtil();//�������ݿ����
			 Infor uInfor=new Infor();
			 uInfor.setName(request.getParameter("uName"));//����
			 uInfor.setPhone(request.getParameter("uPhone")); //�绰
			 uInfor.setAddress(request.getParameter("uPlace")); //��ַ
			 uInfor.setEmail(request.getParameter("uEmail")); //email
			uInfor.setIntroduction(request.getParameter("text")); //���
			boolean flog=db.setInforCompany(uInfor,publicUname);
			//boolean isOkPosts=db.getPosts(request,response,publicUname);
			
			if(flog){
				 request.getSession().setAttribute("info",uInfor);
				 //request.setAttribute("info", info);
				 response.sendRedirect("page/c/uInfo.jsp");
			}else{
				request.getSession().setAttribute("logerror","��Ϣ����ʧ��");
				 response.sendRedirect("error.jsp");
			}
		}
		
	//���������ҳ
	public void userPage(HttpServletRequest request,HttpServletResponse response) 
			 throws ServletException,IOException, MessagingException{
		DBUtil db = new DBUtil();//�������ݿ����
		resume info=db.resumeShow(publicUname,publicUtype);
		 request.getSession().setAttribute("info",info);
		 db.postsShow(request,response,publicUname);//����
		 db.messageShow(request,response,publicUname);//����
		  response.sendRedirect("page/p/user.jsp");
	}
	//������ҵ��ҳ
		public void userCompany(HttpServletRequest request,HttpServletResponse response) 
				 throws ServletException,IOException, MessagingException{
			DBUtil db = new DBUtil();//�������ݿ����
			db.inforShow(request,response,publicUname);
			 db.postsShow(request,response,publicUname);//����
			 db.messageShow(request,response,publicUname);//����
			  response.sendRedirect("page/c/user.jsp");
		}
	
	//��ҳ
	public void Index(HttpServletRequest request,HttpServletResponse response) 
			 throws ServletException,IOException, MessagingException{
		DBUtil db = new DBUtil();//�������ݿ����
		db.getPosts(request,response);
	}
	//�û���Ϣ
	public void uInfor(HttpServletRequest request,HttpServletResponse response,String action) 
			 throws ServletException,IOException, MessagingException{
		 DBUtil db = new DBUtil();//�������ݿ����
		resume uInforStudent=new resume();
		uInforStudent.setName(request.getParameter("uName"));//����
		uInforStudent.setSex(request.getParameter("uMale")); //�Ա�
		uInforStudent.setPhone(request.getParameter("uPhone")); //�绰
		uInforStudent.setAddress(request.getParameter("uPlace")); //��ַ
		uInforStudent.setBrithday(request.getParameter("uBrisDay")); //����
		uInforStudent.setGraduationtime(request.getParameter("uGraDay")); //��ҵ����
		uInforStudent.setEmail(request.getParameter("uEmail")); //email
		uInforStudent.setIncome(request.getParameter("uMoney")); //����
		uInforStudent.setIntroduction(request.getParameter("text")); //���
		boolean flog=db.setInfor(uInforStudent,publicUname,action);
		//boolean isOkPosts=db.getPosts(request,response,publicUname);
		
		if(flog){
			 request.getSession().setAttribute("info",uInforStudent);
			 //request.setAttribute("info", info);
			 response.sendRedirect("page/p/uInfor.jsp");
		}else{
			request.getSession().setAttribute("logerror","��Ϣ����ʧ��");
			 response.sendRedirect("error.jsp");
		}
	}
	
	
	//�û�ע��
	public void regUser(HttpServletRequest request,HttpServletResponse response,String action) 
			 throws ServletException,IOException, MessagingException{
		String userName = request.getParameter("username");//ȡ���û���
		 String password = request.getParameter("password");//ȡ������
		 String email = request.getParameter("email");//ȡ��email
	
		 DBUtil db = new DBUtil();//�������ݿ����
		 
				 boolean canLogin = db.registeredSuccess(userName, password,email,action);
				 if(canLogin){//�������ݿ�д���������תҳ��
					 Mail mail = new Mail();//�ʼ�����
					 mail.Mail(email);
				 response.sendRedirect("log.jsp");
				 }else{
					 request.getSession().setAttribute("logerror","ʧ��");   
					 response.sendRedirect("error.jsp");
				 }
		
	}
	//�û���¼
	public void logUser(HttpServletRequest request,HttpServletResponse response,String action) 
			 throws ServletException,IOException, MessagingException{
		String userName = request.getParameter("username");//ȡ���û���
		 String password = request.getParameter("password");//ȡ������
		 DBUtil db = new DBUtil();//�������ݿ����
		 
		 int canLogin = db.logSuccess(userName, password,action);
		 if(canLogin>0){//���ݵ�½�������תҳ��
			 publicUname=userName;
			 if("logCompany".equals(action)){
				 publicUtype="company";
				 request.getSession().setAttribute("username",userName);//��Session�����û���   
				 request.getSession().setAttribute("type",publicUtype); 
				 db.inforShow(request,response,publicUname);
				 db.postsShow(request,response,publicUname);//����
				 db.messageShow(request,response,publicUname);//����
				 //request.getSession().setAttribute("info",info); //������Ϣ
				 //request.setAttribute("info", info);
				// request.getRequestDispatcher("page/user.jsp").forward(request,response);
				 response.sendRedirect("page/c/user.jsp");
			 }else if("logStudent".equals(action)){
				 publicUtype="student";
				 request.getSession().setAttribute("username",userName);//��Session�����û���   
				 request.getSession().setAttribute("type",publicUtype); 
				 resume info=db.resumeShow(userName,publicUtype);
				 db.postsShow(request,response,publicUname);//����
				 db.messageShow(request,response,publicUname);//����
				 request.getSession().setAttribute("info",info); //������Ϣ
				 //request.setAttribute("info", info);
				// request.getRequestDispatcher("page/user.jsp").forward(request,response);
				 response.sendRedirect("page/p/user.jsp");
			 }
			 
		 }else{
		request.getSession().setAttribute("logerror","��¼ʧ�ܣ������µ�¼");
		 response.sendRedirect("error.jsp");
		 }
	}
	//����
	public void Posts(HttpServletRequest request,HttpServletResponse response) 
			 throws ServletException,IOException, MessagingException{
		DBUtil db = new DBUtil();//�������ݿ����
		posts uInforposts=new posts();
		//java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		java.util.Date currentTime = new java.util.Date();//�õ���ǰϵͳʱ�� 
		//String str_date1 = formatter.format(currentTime); //������ʱ���ʽ��  
		String str_date2 = currentTime.toString(); //��Date������ʱ��ת�����ַ�����ʽ 
		uInforposts.setTitle(request.getParameter("title"));//����
		uInforposts.setContent(request.getParameter("content"));//����
		uInforposts.setFuser(publicUname); //�û���
		uInforposts.setUsertype(publicUtype); //�û�����
		uInforposts.setTime(str_date2); //ʱ��
		boolean flog=db.setInforposts(uInforposts);
		if(flog){
			db.postsShow(request,response,publicUname);
			if("student".equals(publicUtype)){
				response.sendRedirect("page/p/uPosts.jsp");
			}else if("company".equals(publicUtype)){
				response.sendRedirect("page/c/uPosts.jsp");
			}
			 
		}else{
			request.getSession().setAttribute("logerror","����ʧ��");
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
