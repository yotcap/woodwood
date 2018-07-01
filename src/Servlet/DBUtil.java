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
	//��������
	public void initJDBC() throws ClassNotFoundException {
		//����MYSQL JDBC��������
		
			Class.forName("com.mysql.jdbc.Driver");
			bInited = true;
			System.out.println("Success loading Mysql Driver!");
	}
	//�������ݿ�
	public Connection getConnection() throws ClassNotFoundException,
	SQLException{
		
		if(!bInited){
			initJDBC();
			
		}
		
		//����URLΪ jdbc:mysql//��������ַ/���ݿ���
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/outpro","root","1234566");
		return conn;//������Դ
	}
	
	//�û�����������  
	public int logSuccess(String userName,String password,String action){
		
		int returnValue = 0;//����id��ʼ��Ϊ0
		String sql=null;
		Connection conn = null;//�ƿ�
		Statement stmt = null;
		ResultSet rs = null;
		if ("logCompany".equals(action)) {//��ҵ SELECT * FROM
			 sql=String.format("select * from user_com");
		} else if("logStudent".equals(action)){//ѧ��
			 sql=String.format("select * from user_stu");
		 }else{//����
			 return returnValue;
		 }
		
		
		try{
			
			conn = getConnection();//�������ݿ�
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);//��ȡ����
			
			while(rs.next()){//��������
				
				String userNameInDB = rs.getString("username");//ȡ��username
				String passwordInDB = rs.getString("password");//ȡ��password
				
				if(userNameInDB.equals(userName) &&passwordInDB.equals(password)){
					//�ȶԳɹ������Ϊtrue������
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
 
	//ע����Ϣд�룬�ɹ����� true ʧ�ܷ��� false
 public boolean registeredSuccess(String userName,String password,String email,String action){
	 
	 boolean returnValue = false;
	 boolean returnValue_1 = true;
	 String sql=null;
	 String sql_1=null;
	 ResultSet rs = null;
	 Connection conn = null;
	 Statement stmt = null;
	 
	// �ж��û�����
	 if ("regCompany".equals(action)) {//��ҵ 
		 sql=String.format("insert into user_com(username,password,email)values(?,?,?)");
		 sql_1=String.format("select * from user_stu");
	 }
	 else if("regStudent".equals(action)){//ѧ��
		 sql=String.format("insert into user_stu(username,password,email)values(?,?,?)"); 
		 sql_1=String.format("select * from user_stu");
		 
	 }
	 
	 		 
	 try{
		 
		 conn = getConnection();
		 stmt = conn.createStatement();
		 rs = stmt.executeQuery(sql_1);//��ȡ����
		 while(rs.next()){//��������
				
				String userNameInDB = rs.getString("username");//ȡ��username
				
				if(userNameInDB.equals(userName) ){
					//�ȶԳɹ������Ϊfalse
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
 //��������
 public boolean setInfor(resume uInforStudent,String publicUname,String action){
	 
	 boolean returnValue = true;
	 boolean returnValue_1 = false;
	 String sql=null;
	 String sql_1=null;
	 String sql_2=null;
	 ResultSet rs = null;
	 Connection conn = null;
	 Statement stmt = null;
	
	// �ж��û�����
	 if ("regCompany".equals(action)) {//��ҵ 
		 sql=String.format("select * from resume");
		 sql_1=String.format("insert into resume(username,name,sex,phone,address,brithday,graduationtime,email,income,introduction)values(?,?,?,?,?,?,?,?,?,?)");
		 sql_2=String.format("update resume set name = ?,sex=?,phone=?,address=?,brithday=?,graduationtime=?,email=?,income=?,introduction=? where username = ?");
	 }
	 else if("uInforStudent".equals(action)){//ѧ��
		 sql=String.format("select * from resume");
		 sql_1=String.format("insert into resume(username,name,sex,phone,address,brithday,graduationtime,email,income,introduction)values(?,?,?,?,?,?,?,?,?,?)");
		 sql_2=String.format("update resume set name = ?,sex=?,phone=?,address=?,brithday=?,graduationtime=?,email=?,income=?,introduction=? where username = ?");
		 
	 }else{//����
		 return false;
	 }
	 
	 try{
		 
		 conn = getConnection();
		 stmt = conn.createStatement();
		 rs = stmt.executeQuery(sql);//��ȡ����
		 while(rs.next()){//��������
				
				String userNameInDB = rs.getString("username");//ȡ��username
				
				if(userNameInDB.equals(publicUname) ){
					//�ȶԳɹ������Ϊfalse
					returnValue_1 = true;
					
					break;
				}else{
					continue;
				}
		 }
		 
		 if(returnValue_1){//�м���  ����
			
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
					
		 }else{//û�м���  �¼���
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
 
 
 
 //��ȡ������Ϣ
 public resume resumeShow(String userName,String publicUtype){
	resume backInfo=new resume();
	String sql=null;
	Connection conn = null;//�ƿ�
	Statement stmt = null;
	ResultSet rs = null;
		 sql=String.format("select * from resume"); 

		try{
			
			conn = getConnection();//�������ݿ�
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);//��ȡ����
			
			while(rs.next()){//��������
				
				String userNameInDB = rs.getString("username");//ȡ��username
							
				if(userNameInDB.equals(userName)){
					//�����Ϣ					
					backInfo.setName(rs.getString("name"));//����
					backInfo.setSex(rs.getString("sex"));//�Ա�
					backInfo.setPhone(rs.getString("phone"));//�绰
					backInfo.setAddress(rs.getString("address"));//�绰
					backInfo.setBrithday(rs.getString("brithday"));//�绰
					backInfo.setGraduationtime(rs.getString("graduationtime"));//�绰
					backInfo.setEmail(rs.getString("email"));//�绰
					backInfo.setIncome(rs.getString("income"));//�绰
					backInfo.setIntroduction(rs.getString("introduction"));//�绰
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
 //�����������ݿ�
 public boolean setInforposts(posts uInforposts){
	 boolean flog=false;
	 String sql=String.format("insert into posts(username,title,content,time,type)values(?,?,?,?,?)");
		Connection conn = null;//�ƿ�
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
 //��ҳ
 public void getPosts(HttpServletRequest request,HttpServletResponse response) 
		 throws ServletException,IOException, MessagingException{
	 //String sql=String.format("select * from posts");
	 String sql=String.format("select * from posts order by id desc");
	 
		Connection conn = null;//�ƿ�
		Statement stmt = null;
		ResultSet rs = null;
		// ʵ����List����
		List<posts> list = new ArrayList<posts>();
		
try{
			
			conn = getConnection();//�������ݿ�
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);//��ȡ����
			
			while(rs.next()){//��������
				posts postsInfo=new posts();
				postsInfo.setID(rs.getInt("id"));//�û���
				postsInfo.setFuser(rs.getString("username"));//�û���
				postsInfo.setTitle(rs.getString("title"));//��Ŀ
				postsInfo.setContent(rs.getString("content"));//����
				postsInfo.setTime(rs.getString("time"));//ʱ��
				postsInfo.setUsertype(rs.getString("type"));//����
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
 
 //��������չʾ
 public void postsShow(HttpServletRequest request,HttpServletResponse response,String publicUname) 
		 throws ServletException,IOException, MessagingException{
	 //String sql=String.format("select * from posts");
	 String sql=String.format("select * from posts order by id desc");
		Connection conn = null;//�ƿ�
		Statement stmt = null;
		ResultSet rs = null;
		// ʵ����List����
		List<posts> list = new ArrayList<posts>();
		
try{
			
			conn = getConnection();//�������ݿ�
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);//��ȡ����
			
			while(rs.next()){//��������
					if(publicUname.equals(rs.getString("username"))){
						posts postsInfo=new posts();
						postsInfo.setFuser(rs.getString("username"));//�û���
						postsInfo.setTitle(rs.getString("title"));//��Ŀ
						postsInfo.setContent(rs.getString("content"));//����
						postsInfo.setTime(rs.getString("time"));//ʱ��
						postsInfo.setUsertype(rs.getString("type"));//����
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
//д����
 public boolean insetMessage(Mass messageInfor){
	 boolean flog=false;
	 String sql=String.format("insert into massage(touser,content,formuser)values(?,?,?)");
		Connection conn = null;//�ƿ�
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
//��������
public void messageShow(HttpServletRequest request,HttpServletResponse response,String publicUname) 
		 throws ServletException,IOException, MessagingException{
	 //String sql=String.format("select * from posts");
	 String sql=String.format("select * from massage order by id desc");
		Connection conn = null;//�ƿ�
		Statement stmt = null;
		ResultSet rs = null;
		// ʵ����List����
		List<Mass> list = new ArrayList<Mass>();
		
try{
			
			conn = getConnection();//�������ݿ�
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);//��ȡ����
			
			while(rs.next()){//��������
				if(publicUname.equals(rs.getString("touser"))){
						Mass messInfo=new Mass();
						messInfo.setToUsername(rs.getString("touser"));//������
						messInfo.setContent(rs.getString("content"));//����
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
//��ȡ��˾��Ϣ
public void inforShow(HttpServletRequest request,HttpServletResponse response,String publicUname) 
		 throws ServletException,IOException, MessagingException{
	Infor backInfor=new Infor();
	String sql=null;
	Connection conn = null;//�ƿ�
	Statement stmt = null;
	ResultSet rs = null;
	sql=String.format("select * from information");
	

		try{
			
			conn = getConnection();//�������ݿ�
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);//��ȡ����
			
			while(rs.next()){//��������
				
				String userNameInDB = rs.getString("username");//ȡ��username
							
				if(userNameInDB.equals(publicUname)){
					//�����Ϣ					
					backInfor.setName(rs.getString("name"));//����
					backInfor.setPhone(rs.getString("phone"));//�绰
					backInfor.setAddress(rs.getString("address"));//��ַ
					backInfor.setEmail(rs.getString("email"));//����
					backInfor.setIntroduction(rs.getString("introduction"));//���
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
//��ҵ��Ϣ����
public boolean setInforCompany(Infor uInfor,String publicUname){
	 
	 boolean returnValue = true;
	 boolean returnValue_1 = false;
	 String sql=null;
	 String sql_1=null;
	 String sql_2=null;
	 ResultSet rs = null;
	 Connection conn = null;
	 Statement stmt = null;
	
	// �ж��û�����
	 
		 sql=String.format("select * from information");
		 sql_1=String.format("insert into information(username,name,phone,address,email,introduction)values(?,?,?,?,?,?)");
		 sql_2=String.format("update information set name = ?,phone=?,address=?,email=?,introduction=? where username = ?");
	 
	 try{
		 
		 conn = getConnection();
		 stmt = conn.createStatement();
		 rs = stmt.executeQuery(sql);//��ȡ����
		 while(rs.next()){//��������
				
				String userNameInDB = rs.getString("username");//ȡ��username
				
				if(userNameInDB.equals(publicUname) ){
					//�ȶԳɹ������Ϊfalse
					returnValue_1 = true;
					
					break;
				}else{
					continue;
				}
		 }
		 
		 if(returnValue_1){//��Ϣ  ����
			
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
					
		 }else{//û����Ϣ  �¼���
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
	 
	Connection conn = null;//�ƿ�
	Statement stmt = null;
	ResultSet rs = null;
	
	
	try{
		
		conn = getConnection();//�������ݿ�
		
		stmt = conn.createStatement();
		
		rs = stmt.executeQuery(sql);//��ȡ����
		
		while(rs.next()){//��������
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