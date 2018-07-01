package Servlet; 
import java.io.IOException;
import java.sql.*;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javaclass.resume;
import javaclass.posts;
import javaclass.Infor;
import javaclass.Mass;
import java.util.ArrayList;
import java.util.List;
public class DBUtil { 
	boolean bInited = false;
	//加载驱动
	public void initJDBC() throws ClassNotFoundException {
		//加载MYSQL JDBC驱动程序
		
			Class.forName("com.mysql.jdbc.Driver");
			bInited = true;
			System.out.println("Success loading Mysql Driver!");
	}
	//连接数据库
	public Connection getConnection() throws ClassNotFoundException,
	SQLException{
		
		if(!bInited){
			initJDBC();
			
		}
		
		//连接URL为 jdbc:mysql//服务器地址/数据库名
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/outpro","root","1234566");
		return conn;//返回资源
	}
	
	//用户名和密码检测  
	public int logSuccess(String userName,String password,String action){
		
		int returnValue = 0;//返回id初始化为0
		String sql=null;
		Connection conn = null;//制空
		Statement stmt = null;
		ResultSet rs = null;
		if ("logCompany".equals(action)) {//企业 SELECT * FROM
			 sql=String.format("select * from user_com");
		} else if("logStudent".equals(action)){//学生
			 sql=String.format("select * from user_stu");
		 }else{//错误
			 return returnValue;
		 }
		
		
		try{
			
			conn = getConnection();//连接数据库
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);//获取数据
			
			while(rs.next()){//遍历数据
				
				String userNameInDB = rs.getString("username");//取出username
				String passwordInDB = rs.getString("password");//取出password
				
				if(userNameInDB.equals(userName) &&passwordInDB.equals(password)){
					//比对成功，标记为true并返回
					returnValue = rs.getInt("id");
					
					break;
				}else{
					continue;
				}
			}
			
			if(rs != null)
	         {
	             rs.close();
	         }
	         if(stmt!=null)
	         {
	        	 stmt.close();
	         }
	         if(conn!=null)
	         {
	             conn.close();
	         } 
	         return returnValue;
		}catch (ClassNotFoundException e) {
			return returnValue;
		}catch (SQLException e) {
			return returnValue;
		}
 
 }
 
	//注册信息写入，成功返回 true 失败返回 false
 public boolean registeredSuccess(String userName,String password,String email,String action){
	 
	 boolean returnValue = false;
	 boolean returnValue_1 = true;
	 String sql=null;
	 String sql_1=null;
	 ResultSet rs = null;
	 Connection conn = null;
	 Statement stmt = null;
	 
	// 判断用户类型
	 if ("regCompany".equals(action)) {//企业 
		 sql=String.format("insert into user_com(username,password,email)values(?,?,?)");
		 sql_1=String.format("select * from user_stu");
	 }
	 else if("regStudent".equals(action)){//学生
		 sql=String.format("insert into user_stu(username,password,email)values(?,?,?)"); 
		 sql_1=String.format("select * from user_stu");
		 
	 }
	 
	 		 
	 try{
		 
		 conn = getConnection();
		 stmt = conn.createStatement();
		 rs = stmt.executeQuery(sql_1);//获取数据
		 while(rs.next()){//遍历数据
				
				String userNameInDB = rs.getString("username");//取出username
				
				if(userNameInDB.equals(userName) ){
					//比对成功，标记为false
					returnValue_1 = false;
					break;
				}else{
					continue;
				}
		 }
		 if(returnValue_1){
			 PreparedStatement ps =conn.prepareStatement(sql);
			 	ps.setString(1,userName);
				ps.setString(2,password);
				ps.setString(3,email);
				int row=ps.executeUpdate();
				if(row>0){
					returnValue=true;
				} 
				if(ps != null)
		        {
		        	ps.close();
		        }
		 }
	 	
		 if(stmt!=null)
	        {
	       	 rs.close();
	        }
        if(stmt!=null)
        {
       	 stmt.close();
        }
        if(conn!=null)
        {
            conn.close();
        }
		return returnValue;
	 }catch(Exception e){
		return false;
		}
 }
 //建立简历
 public boolean setInfor(resume uInforStudent,String publicUname,String action){
	 
	 boolean returnValue = true;
	 boolean returnValue_1 = false;
	 String sql=null;
	 String sql_1=null;
	 String sql_2=null;
	 ResultSet rs = null;
	 Connection conn = null;
	 Statement stmt = null;
	
	// 判断用户类型
	 if ("regCompany".equals(action)) {//企业 
		 sql=String.format("select * from resume");
		 sql_1=String.format("insert into resume(username,name,sex,phone,address,brithday,graduationtime,email,income,introduction)values(?,?,?,?,?,?,?,?,?,?)");
		 sql_2=String.format("update resume set name = ?,sex=?,phone=?,address=?,brithday=?,graduationtime=?,email=?,income=?,introduction=? where username = ?");
	 }
	 else if("uInforStudent".equals(action)){//学生
		 sql=String.format("select * from resume");
		 sql_1=String.format("insert into resume(username,name,sex,phone,address,brithday,graduationtime,email,income,introduction)values(?,?,?,?,?,?,?,?,?,?)");
		 sql_2=String.format("update resume set name = ?,sex=?,phone=?,address=?,brithday=?,graduationtime=?,email=?,income=?,introduction=? where username = ?");
		 
	 }else{//错误
		 return false;
	 }
	 
	 try{
		 
		 conn = getConnection();
		 stmt = conn.createStatement();
		 rs = stmt.executeQuery(sql);//获取数据
		 while(rs.next()){//遍历数据
				
				String userNameInDB = rs.getString("username");//取出username
				
				if(userNameInDB.equals(publicUname) ){
					//比对成功，标记为false
					returnValue_1 = true;
					
					break;
				}else{
					continue;
				}
		 }
		 
		 if(returnValue_1){//有简历  更新
			
			 PreparedStatement ps =conn.prepareStatement(sql_2);
			 
			 	ps.setString(1,uInforStudent.getName());
				ps.setString(2,uInforStudent.getSex());
				ps.setString(3,uInforStudent.getPhone());
				ps.setString(4,uInforStudent.getAddress());
				ps.setString(5,uInforStudent.getBrithday());
				ps.setString(6,uInforStudent.getGraduationtime());
				ps.setString(7,uInforStudent.getEmail());
				ps.setString(8,uInforStudent.getIncome());
				ps.setString(9,uInforStudent.getIntroduction());
				ps.setString(10,publicUname);
				int row=ps.executeUpdate();
				if(row>0){
					returnValue=true;
				} 
				if(ps != null)
		        {
		        	ps.close();
		        }
					
		 }else{//没有简历  新加入
			 PreparedStatement ps =conn.prepareStatement(sql_1);
			 	ps.setString(1,publicUname);
			 	ps.setString(2,uInforStudent.getName());
				ps.setString(3,uInforStudent.getSex());
				ps.setString(4,uInforStudent.getPhone());
				ps.setString(5,uInforStudent.getAddress());
				ps.setString(6,uInforStudent.getBrithday());
				ps.setString(7,uInforStudent.getGraduationtime());
				ps.setString(8,uInforStudent.getEmail());
				ps.setString(9,uInforStudent.getIncome());
				ps.setString(10,uInforStudent.getIntroduction());
				int row=ps.executeUpdate();
				if(row>0){
					returnValue=true;
				} 
				if(ps != null)
		        {
		        	ps.close();
		        }
		 }
	 	
		 if(stmt!=null)
	        {
	       	 rs.close();
	        }
        if(stmt!=null)
        {
       	 stmt.close();
        }
        if(conn!=null)
        {
            conn.close();
        } 
		 
		return returnValue;
	 }catch(Exception e){
		return false;
		}
	
 }
 
 
 
 //获取简历信息
 public resume resumeShow(String userName,String publicUtype){
	resume backInfo=new resume();
	String sql=null;
	Connection conn = null;//制空
	Statement stmt = null;
	ResultSet rs = null;
		 sql=String.format("select * from resume"); 

		try{
			
			conn = getConnection();//连接数据库
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);//获取数据
			
			while(rs.next()){//遍历数据
				
				String userNameInDB = rs.getString("username");//取出username
							
				if(userNameInDB.equals(userName)){
					//获得信息					
					backInfo.setName(rs.getString("name"));//姓名
					backInfo.setSex(rs.getString("sex"));//性别
					backInfo.setPhone(rs.getString("phone"));//电话
					backInfo.setAddress(rs.getString("address"));//电话
					backInfo.setBrithday(rs.getString("brithday"));//电话
					backInfo.setGraduationtime(rs.getString("graduationtime"));//电话
					backInfo.setEmail(rs.getString("email"));//电话
					backInfo.setIncome(rs.getString("income"));//电话
					backInfo.setIntroduction(rs.getString("introduction"));//电话
					break;
				}else{
					continue;
				}
			}
			if(rs != null)
	         {
	             rs.close();
	         }
	         if(stmt!=null)
	         {
	        	 stmt.close();
	         }
	         if(conn!=null)
	         {
	             conn.close();
	         } 
	         return backInfo;
		}catch (ClassNotFoundException e) {
			return backInfo;
		}catch (SQLException e) {
			return backInfo;
		}
		
	 
 }
 //发帖存入数据库
 public boolean setInforposts(posts uInforposts){
	 boolean flog=false;
	 String sql=String.format("insert into posts(username,title,content,time,type)values(?,?,?,?,?)");
		Connection conn = null;//制空
		Statement stmt = null;
		
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setString(1,uInforposts.getFuser());
			ps.setString(2,uInforposts.getTitle());
			ps.setString(3,uInforposts.getContent());
			ps.setString(4,uInforposts.getTime());
			ps.setString(5,uInforposts.getUsertype());
			int row=ps.executeUpdate();
			
					if(row>0){
						flog=true;
					} 
					if(ps != null)
			        {
			        	ps.close();
			        }
			 
		 	
			 
	        if(stmt!=null)
	        {
	       	 stmt.close();
	        }
	        if(conn!=null)
	        {
	            conn.close();
	        }
	        
			return flog;
		 }catch(Exception e){
			return false;
			}

 }
 //首页
 public void getPosts(HttpServletRequest request,HttpServletResponse response) 
		 throws ServletException,IOException, MessagingException{
	 //String sql=String.format("select * from posts");
	 String sql=String.format("select * from posts order by id desc");
	 
		Connection conn = null;//制空
		Statement stmt = null;
		ResultSet rs = null;
		// 实例化List对象
		List<posts> list = new ArrayList<posts>();
		
try{
			
			conn = getConnection();//连接数据库
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);//获取数据
			
			while(rs.next()){//遍历数据
				posts postsInfo=new posts();
				postsInfo.setID(rs.getInt("id"));//用户名
				postsInfo.setFuser(rs.getString("username"));//用户名
				postsInfo.setTitle(rs.getString("title"));//题目
				postsInfo.setContent(rs.getString("content"));//内容
				postsInfo.setTime(rs.getString("time"));//时间
				postsInfo.setUsertype(rs.getString("type"));//类型
				list.add(postsInfo);
				}
			request.setAttribute("list", list);
			if(rs != null)
	         {
	             rs.close();
	         }
	         if(stmt!=null)
	         {
	        	 stmt.close();
	         }
	         if(conn!=null)
	         {
	             conn.close();
	         } 
	         
		}catch (ClassNotFoundException e) {
			
		}catch (SQLException e) {
			
		}	
request.getRequestDispatcher("index.jsp").forward(request, response);
 }
 
 //个人帖子展示
 public void postsShow(HttpServletRequest request,HttpServletResponse response,String publicUname) 
		 throws ServletException,IOException, MessagingException{
	 //String sql=String.format("select * from posts");
	 String sql=String.format("select * from posts order by id desc");
		Connection conn = null;//制空
		Statement stmt = null;
		ResultSet rs = null;
		// 实例化List对象
		List<posts> list = new ArrayList<posts>();
		
try{
			
			conn = getConnection();//连接数据库
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);//获取数据
			
			while(rs.next()){//遍历数据
					if(publicUname.equals(rs.getString("username"))){
						posts postsInfo=new posts();
						postsInfo.setFuser(rs.getString("username"));//用户名
						postsInfo.setTitle(rs.getString("title"));//题目
						postsInfo.setContent(rs.getString("content"));//内容
						postsInfo.setTime(rs.getString("time"));//时间
						postsInfo.setUsertype(rs.getString("type"));//类型
						list.add(postsInfo);
					}
				}
			request.getSession().setAttribute("posts",list); 
			if(rs != null)
	         {
	             rs.close();
	         }
	         if(stmt!=null)
	         {
	        	 stmt.close();
	         }
	         if(conn!=null)
	         {
	             conn.close();
	         } 
	         
		}catch (ClassNotFoundException e) {
			
		}catch (SQLException e) {
			
		}	
 }
//写留言
 public boolean insetMessage(Mass messageInfor){
	 boolean flog=false;
	 String sql=String.format("insert into massage(touser,content,formuser)values(?,?,?)");
		Connection conn = null;//制空
		Statement stmt = null;
		
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setString(1,messageInfor.getToUsername());
			ps.setString(2,messageInfor.getContent());
			ps.setString(3,messageInfor.getFromUsername());
			int row=ps.executeUpdate();
			
					if(row>0){
						flog=true;
					} 
					if(ps != null)
			        {
			        	ps.close();
			        }
			 
		 	
			 
	        if(stmt!=null)
	        {
	       	 stmt.close();
	        }
	        if(conn!=null)
	        {
	            conn.close();
	        }
	        
			return flog;
		 }catch(Exception e){
			return false;
			}	 
 }
//个人留言
public void messageShow(HttpServletRequest request,HttpServletResponse response,String publicUname) 
		 throws ServletException,IOException, MessagingException{
	 //String sql=String.format("select * from posts");
	 String sql=String.format("select * from massage order by id desc");
		Connection conn = null;//制空
		Statement stmt = null;
		ResultSet rs = null;
		// 实例化List对象
		List<Mass> list = new ArrayList<Mass>();
		
try{
			
			conn = getConnection();//连接数据库
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);//获取数据
			
			while(rs.next()){//遍历数据
				if(publicUname.equals(rs.getString("touser"))){
						Mass messInfo=new Mass();
						messInfo.setToUsername(rs.getString("touser"));//收信人
						messInfo.setContent(rs.getString("content"));//内容
						messInfo.setFromUsername(rs.getString("formuser"));
						list.add(messInfo);
					}
			}
			request.getSession().setAttribute("message",list); 
			if(rs != null)
	         {
	             rs.close();
	         }
	         if(stmt!=null)
	         {
	        	 stmt.close();
	         }
	         if(conn!=null)
	         {
	             conn.close();
	         } 
	         
		}catch (ClassNotFoundException e) {
			
		}catch (SQLException e) {
			
		}	
}
//获取公司信息
public void inforShow(HttpServletRequest request,HttpServletResponse response,String publicUname) 
		 throws ServletException,IOException, MessagingException{
	Infor backInfor=new Infor();
	String sql=null;
	Connection conn = null;//制空
	Statement stmt = null;
	ResultSet rs = null;
	sql=String.format("select * from information");
	

		try{
			
			conn = getConnection();//连接数据库
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);//获取数据
			
			while(rs.next()){//遍历数据
				
				String userNameInDB = rs.getString("username");//取出username
							
				if(userNameInDB.equals(publicUname)){
					//获得信息					
					backInfor.setName(rs.getString("name"));//名称
					backInfor.setPhone(rs.getString("phone"));//电话
					backInfor.setAddress(rs.getString("address"));//地址
					backInfor.setEmail(rs.getString("email"));//邮箱
					backInfor.setIntroduction(rs.getString("introduction"));//简介
					break;
				}else{
					continue;
				}
			}
			request.getSession().setAttribute("info",backInfor);
			if(rs != null)
	         {
	             rs.close();
	         }
	         if(stmt!=null)
	         {
	        	 stmt.close();
	         }
	         if(conn!=null)
	         {
	             conn.close();
	         } 
	        
		}catch (ClassNotFoundException e) {
			
		}catch (SQLException e) {
			
		}
		
	 
}
//企业信息更改
public boolean setInforCompany(Infor uInfor,String publicUname){
	 
	 boolean returnValue = true;
	 boolean returnValue_1 = false;
	 String sql=null;
	 String sql_1=null;
	 String sql_2=null;
	 ResultSet rs = null;
	 Connection conn = null;
	 Statement stmt = null;
	
	// 判断用户类型
	 
		 sql=String.format("select * from information");
		 sql_1=String.format("insert into information(username,name,phone,address,email,introduction)values(?,?,?,?,?,?)");
		 sql_2=String.format("update information set name = ?,phone=?,address=?,email=?,introduction=? where username = ?");
	 
	 try{
		 
		 conn = getConnection();
		 stmt = conn.createStatement();
		 rs = stmt.executeQuery(sql);//获取数据
		 while(rs.next()){//遍历数据
				
				String userNameInDB = rs.getString("username");//取出username
				
				if(userNameInDB.equals(publicUname) ){
					//比对成功，标记为false
					returnValue_1 = true;
					
					break;
				}else{
					continue;
				}
		 }
		 
		 if(returnValue_1){//信息  更新
			
			 PreparedStatement ps =conn.prepareStatement(sql_2);
			 
			 	ps.setString(1,uInfor.getName());
				ps.setString(2,uInfor.getPhone());
				ps.setString(3,uInfor.getAddress());
				ps.setString(4,uInfor.getEmail());
				ps.setString(5,uInfor.getIntroduction());
				ps.setString(6,publicUname);
				int row=ps.executeUpdate();
				if(row>0){
					returnValue=true;
				} 
				if(ps != null)
		        {
		        	ps.close();
		        }
					
		 }else{//没有信息  新加入
			 PreparedStatement ps =conn.prepareStatement(sql_1);
			 	ps.setString(1,publicUname);
			 	ps.setString(2,uInfor.getName());
				ps.setString(3,uInfor.getPhone());
				ps.setString(4,uInfor.getAddress());
				ps.setString(5,uInfor.getEmail());
				ps.setString(6,uInfor.getIntroduction());
				int row=ps.executeUpdate();
				if(row>0){
					returnValue=true;
				} 
				if(ps != null)
		        {
		        	ps.close();
		        }
		 }
	 	
		 if(stmt!=null)
	        {
	       	 rs.close();
	        }
       if(stmt!=null)
       {
      	 stmt.close();
       }
       if(conn!=null)
       {
           conn.close();
       } 
		 
		return returnValue;
	 }catch(Exception e){
		return false;
		}
	
}
public String foundUser(int ID){
	String userName = null;
	String sql=String.format("select * from posts order by id desc");
	 
	Connection conn = null;//制空
	Statement stmt = null;
	ResultSet rs = null;
	
	
	try{
		
		conn = getConnection();//连接数据库
		
		stmt = conn.createStatement();
		
		rs = stmt.executeQuery(sql);//获取数据
		
		while(rs.next()){//遍历数据
				if(ID==rs.getInt("id")){
					userName=rs.getString("username");
					break;
				}
			}
		
		if(rs != null)
         {
             rs.close();
         }
         if(stmt!=null)
         {
        	 stmt.close();
         }
         if(conn!=null)
         {
             conn.close();
         } 
         
	}catch (ClassNotFoundException e) {
		
	}catch (SQLException e) {
		
	}	
	return userName;
}
 
}