<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@ page import="javaclass.posts"%>
<%@ page import="java.net.URLEncoder"%> 
   <% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>
<base href="<%=basePath%>">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WebCap</title>
<link rel="stylesheet" type="text/css" href="css/webmain.css"/>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/jquery-1.7.min.js"></script>
<script>
$(function() {
	// 悬浮窗口
	$(".yb_conct").hover(function() {
		$(".yb_conct").css("right", "5px");
		$(".yb_bar .yb_ercode").css('height', '200px');
	}, function() {
		$(".yb_conct").css("right", "-97px");
		$(".yb_bar .yb_ercode").css('height', '53px');
	});
	// 返回顶部
	$(".yb_top").click(function() {
		$("html,body").animate({
			'scrollTop': '0px'
		}, 300)
	});
});


</script>
</head>
	
<body>
<%
		boolean islog=false;
		String userType="";
      if(session.getAttribute("username") ==null){
         islog=false;
        }else{
        islog=true;
        	if("company".equals(session.getAttribute("type"))){
        		userType="company";
        	}else if("student".equals(session.getAttribute("type"))){
        		userType="student";
        	}
       }
%>
	<div class="bottomBack">
        <div class="yb_conct">
        	<div class="yb_bar">
            	<ul>
                      <li class="yb_top">返回顶部</li>
                      <li class="yb_login">
                      
                      	<%
                      	if(islog){
                      		%>
                      		<p><%=session.getAttribute("username")%></p>
                      	<%	
                      	}else{
                      		%>
                      		<a target="_blank" href="log.jsp">
                      		登录
                      		</a>
                      	<%	
                      	}
                      	%></li>
                      <li class="yb_QQ">
                        <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=1050376641&site=qq&menu=yes" title="即刻发送您的需求">在线咨询</a>
                      </li>
                      <li class="yb_ercode" style="height:53px;">微信二维码 <br>
                        <img class="hd_qr" src="img/weixin.jpg" width="110" alt="关注你附近"> </li>
    			</ul>
            </div>
        </div>      
    	<div class="containerHeader">
        	<div class="headerHome">
        		<span>WebCap</span>
            </div>
            <nav class="mainMenu" id="menu">
            	<ul>
                	<li><a href="#">Home</a></li>
                	<li><%if("student".equals(userType)){%>
                	<a href="UserServlet?action=user">Student</a>
                	<% }else{%>
                	<a href="#">Student</a>
                	<%} %>
                    </li>
                    <li>
                    <%if("company".equals(userType)){%>
                	<a href="UserServlet?action=userCompany">Company</a>
                	<% }else{%>
                	<a href="#">Company</a>
                	<%} %>
                    </li>
                    <li><a href="#">About us</a></li>
                </ul>
            </nav>
        </div>
		<div class="mainBack" id="mainBack"> 
		    
			<%
				// 获取图书信息集合
					List<posts> list = (List<posts>)request.getAttribute("list");
					// 判断集合是否有效
					int num=0;
					if(list == null || list.size() < 1){
						out.print("没有数据！");
					}else{
						// 遍历图书集合中的数据
						for(posts book : list){
							num++;
							if(num%2==1){
			%>
				<div  style="background:rgba(214, 214, 214,0.8);width:auto;	height:300px;	margin-top:7px;">
	            	<div  style="width:390px;height:300px;float:left;"><!--头像 -->
	                	<img src="img/p/<%=num%4%>.jpg" style="width:100%;	height:100%;" />
	                </div>
	                
	                <div  style="width:706px;height:40px;float:left;border-bottom:#999 solid 2px;text-align:center;font-size:18px;font-weight:bold;"><!--标题 -->
	                	<span style="display:block;	margin-top:10px;"><%=book.getTitle()%></span>
	                </div>
	                
	                <div  style="float:left;width:706px;height:230px;border-bottom:#999  dotted 2px;"><!--帖子 -->
	                	<div style="margin-top:10px;margin-left:15px;font-size:18px;">
	                		<%=book.getContent()%>
	                	</div>
	                </div>
	                
	                <div  style="float:left;width:706px;height:25px;padding-top:5px;color:#888;font-size:14px;"><!--信息 -->
	                	<div style="margin-right:20px;float:right;">
	                    	发帖人：<span style="color:#000;">
	                    	<%if(book.getFuser().equals(session.getAttribute("username"))){%>
	        					<a href="#">
	        				<%}else{ %>
	        				<a href="UserServlet?action=othershow&theType=<%=book.getUsertype()%>&theID=<%=book.getID()%>">
	        				<% }%>             	
	                    	<%=book.getUsertype()%>&nbsp;&nbsp;<%=book.getFuser()%>
	                    	</a>
	                    	</span>&nbsp;&nbsp;&nbsp;
	                        发帖时间：<span  style="color:#000;"><%=book.getTime()%></span>
	                    </div>	
	                </div>
            </div>
           <%}else if(num%2==0){ %>
            <div  style="background:rgba(214, 214, 214,0.8);width:auto;	height:300px;	margin-top:7px;">
	            	<div  style="width:390px;height:300px;float:right;"><!--头像 -->
	                	<img src="img/p/<%=num%4%>.jpg" style="width:100%;	height:100%;" />
	                </div>
	                
	                <div  style="width:706px;height:40px;float:left;border-bottom:#999 solid 2px;text-align:center;font-size:18px;font-weight:bold;"><!--标题 -->
	                	<span style="display:block;	margin-top:10px;"><%=book.getTitle()%></span>
	                </div>
	                
	                <div  style="float:left;width:706px;height:230px;border-bottom:#999  dotted 2px;"><!--帖子 -->
	                	<div style="margin-top:10px;margin-left:15px;font-size:18px;">
	                		<%=book.getContent()%>
	                	</div>
	                </div>
	                
	                <div  style="float:left;width:706px;height:25px;padding-top:5px;color:#888;font-size:14px;"><!--信息 -->
	                	<div style="margin-right:20px;float:right;">
	                    	发帖人：<span style="color:#000;">
	                    	<%if(book.getFuser().equals(session.getAttribute("username"))){%>
	        					<a href="#">
	        				<%}else{ %>
	        				<a href="UserServlet?action=othershow&theType=<%=book.getUsertype()%>&theID=<%=book.getID()%>">
	        				<% }%>             	
	                    	<%=book.getUsertype()%>&nbsp;&nbsp;<%=book.getFuser()%>
	                    	</a>
	                    	</span>&nbsp;&nbsp;&nbsp;
	                        发帖时间：<span  style="color:#000;"><%=book.getTime()%></span>
	                    </div>	
	                </div>
            </div>
					
			<%}
					}
				}
			%>
	   
		</div>
        <div class="copy-rights">
        	<p>Copyright &copy; 2017.Company name All rights reserved.Powered by <a href="http://www.sobaho.com">www.sobaho.com</a></p>
        </div>
	</div>
</body>
</html>
