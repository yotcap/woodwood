<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="javax.servlet.http.*,java.util.*"%>
 <% Calendar cd=Calendar.getInstance(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>userPage</title>
<link rel="stylesheet" type="text/css" href="../../css/user.css"/>
<link rel="stylesheet" type="text/css" href="../../css/webmain.css"/>
<script type="text/javascript" src="../../js/jquery-1.7.min.js"></script>
<script type="text/javascript" src="../../js/main.js"></script>
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
	<div class="bottomBack">
    	
    	<div class="containerHeader">
        	<div class="headerHome">
        		<span><a href="#">WebCap</a></span>
            </div>
            <nav class="mainMenu" id="menu">
            	<ul>
                	<li><a href="../../UserServlet?action=index">Home</a></li>
                    <li><a href="#">Student</a></li>
                    <li><a href="#">Company</a></li>
                    <li><a href="#">About us</a></li>
                </ul>
            </nav>
        </div>
        
        
        <div class="mainPart">
        	<div class="topColumn">
            	<span class="topUserName">
            	<%if(cd.get(Calendar.AM_PM)==Calendar.AM) {%>
					上午好!
				<%}else{ %>
					下午好!
				<% }%>
            	</span>
                
            </div>
            <div class="leftColumn">
            	<div class="userAvatar">
                	<img src="../../img/avtar.png" />
                </div>
                <div class="userTab">
                	<% if("company".equals(session.getAttribute("othertype"))){%>
                	<a href="uInfo.jsp" target="mainFrame">
                	<%} else{%>
                	<a href="uInfor.jsp" target="mainFrame">
                	<%} %>
                	<div><%=session.getAttribute("othername") %></div></a>
                    <a href="uPosts.jsp" target="mainFrame"><div>他的帖子</div></a>
                    <a href="uMessage.jsp" target="mainFrame"><div>给他留言</div></a>
                </div>
            </div>
            <div class="mainColumn">
            
            	<iframe <% if("company".equals(session.getAttribute("othertype"))){%>
                	src="uInfo.jsp"
                	<%} else{%>
                	src="uInfor.jsp"
                	<%} %>
            	 scrolling="auto" name="mainFrame" class="inforFrame"  allowTransparency="true">
                	
                </iframe>
            </div>
        </div>
        
        
        
        
        <div class="copy-rights">
        	<p>Copyright &copy; 2017.Company name All rights reserved.Powered by <a href="http://www.sobaho.com">www.sobaho.com</a></p>
        </div> 
    </div>
</body>
</html>
