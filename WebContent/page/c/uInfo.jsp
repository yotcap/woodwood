<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="javaclass.Infor" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>untitle</title>
<style type="text/css">
body{
	width:820px;
	height: 500px;
	background:#C96;
	overflow-x:hidden;
	}
.clear{clear:both;}
.content{
	width:700px;
	margin:50px 0px 0px 50px;
	}
.titleBasic{
	padding-bottom:20px;
	border-bottom:2px solid #CCC;
	}
.titleBasic span{ font-size:22px;color:#FFF;}

.uAll{margin-left:50px;font-size:20px;}
.uName{margin-top:50px;}
.uPhone{margin-top:30px;padding-left:38px;}
.uPlace{margin-top:30px;padding-left:18px;}
.uMail{margin-top:30px;padding-left:37px;}

.btnSubmit{margin:80px 0px 20px 550px;}
.btnSubmit input{
	width:120px; 
	height:40px;
	border:none;
	outline:none;
	cursor: pointer;
	padding: 10px 0;
	font-size:18px;
	background:#CCC;
	}
.btnSubmit input:hover{
	color:#FFF;
	background:#993;
	transition: 0.3s all;
	-webkit-transition: 0.3s all;
	-moz-transition: 0.3s all;
	-o-transition: 0.3s all;
	}
.txtForm{
	width:700px;
	margin:50px 0px 100px 50px;
	}
.txt{
	margin-left:5px;
	margin-top: 3em;
	font-family:"Arial","Microsoft YaHei","黑体","宋体",sans-serif;
	font-size:16px;
	}
.note{  
	top:490px;
	left:70px;
	position:absolute;
	line-height:20px;
	padding:3px 5px;  
	}  
</style>
</head>
	
<body>
<%
// 获取个人信息
//resume info = (resume)request.getAttribute("info");

Infor infor = (Infor)session.getAttribute("info");

%>
	<div class="content">
        	<div class="titleBasic"><span>基本信息</span></div>
            <div class="uAll uName"><font color="#CCCCCC">公司名称：</font><span><%=infor.getName() %></span></div>
            <div class="uAll uPhone"><font color="#CCCCCC">电话：</font><span><%=infor.getPhone() %></span></div>
            <div class="uAll uPlace"><font color="#CCCCCC">所在地：</font><span><%=infor.getAddress()%></span></div>
            <div class="uAll uMail"><font color="#CCCCCC">邮箱：</font><span><%=infor.getEmail()%></span></div>
	</div>
    <div class="txtForm">
    	<form name="txtForm">
        	<div class="titleBasic"><span>公司简介</span></div>
        	<textarea name="text" class="txt" cols="85" rows="20"><%=infor.getIntroduction()%></textarea>
            <div class="btnSubmit">
    			<a href="uInfor_show.jsp" target="mainFrame"><input type="button" value="修改信息" /> </a>
    		</div>
        </form>
    </div>
    
</body>
</html>
