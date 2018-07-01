<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="javaclass.resume" %>
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
.mainIn input{
	width:150px;
	padding: 5px 5px 5px 5px;
	color:#C30;
	font-size: 18px;
	outline: none;
	background: url(../img/adm.png) no-repeat 10px 15px;
	border: none;
	font-weight: 100;
	border-bottom: 1px solid#484856;
	margin-top: 2em;
	}
.uName{margin-left:80px;float:left;}
.uMale{margin-left:360px;}
.uGraDay{margin-left:340px;}
.uBrisDay{margin-left:50px;float:left;}
.uResPlace{margin-left:350px;}
.uIncome{margin-left:330px;}
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
// 获取图书信息集合
//resume info = (resume)request.getAttribute("info");

resume info = (resume)session.getAttribute("info");
// 判断集合是否有效
%>
	<div class="content">
    	<form name="basicForm">
        	<div class="titleBasic"><span>基本信息</span></div>
            <div class="uName mainIn">姓名：<input type="text" name="uName" value="<%=info.getName()%>"/></div>
            <div class="uMale mainIn">性别：<input type="text" name="uMale" value="<%=info.getSex()%>"/></div>
            <div class="both"></div>
            <div class="uName mainIn">手机：<input type="text" name="uPhone" value="<%=info.getPhone()%>"/></div>
            <div class="uResPlace mainIn">居住地：<input type="text" name="uPlace" value="<%=info.getAddress()%>"/></div>
            <div class="both"></div>
            <div class="uBrisDay mainIn">出生日期：<input type="text" name="uBrisDay" value="<%=info.getBrithday()%>" /></div>
            <div class="uGraDay mainIn">毕业日期：<input type="text" name="uGraDay" value="<%=info.getGraduationtime()%>"/></div>
            <div class="both"></div>
            <div class="uName mainIn">邮箱：<input type="text" name="uEmail" value="<%=info.getEmail()%>"/></div>
            <div class="uIncome mainIn">目前年收入：<input type="text" name="uMoney" value="<%=info.getIncome()%>"/>万元</div>

        </form>
	</div>
    <div class="txtForm">
    	<form name="txtForm">
        	<div class="titleBasic"><span>个人简介</span></div>
        	<textarea name="text" class="txt" cols="85" rows="20">
        	<%=info.getIntroduction()%>
        	</textarea>
            <div class="note"><font color="#FFFF00">* 自我介绍！</font></div>  
            
        </form>
    </div>
  
</body>
</html>
