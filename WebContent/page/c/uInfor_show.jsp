<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
.uAll{margin-left:50px;font-size:20px;}
.uName{margin-top:80px;}
.uPhone{margin-top:0px;padding-left:42px;}
.uPlace{margin-top:30px;padding-left:28px;}
.uMail{margin-top:0px;padding-left:42px;}


.btnSubmit{margin:80px 0px 20px 250px;}
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
	margin:70px 0px 100px 0px;
	}
.txt{
	margin-left:5px;
	margin-top: 3em;
	font-family:"Arial","Microsoft YaHei","黑体","宋体",sans-serif;
	font-size:16px;
	}
.note{  
	top:530px;
	left:70px;
	position:absolute;
	line-height:20px;
	padding:3px 5px;  
	}  
</style>
</head>
	
<body>
	<div class="content">
    	<form name="basicForm" method="post" action="../../UserServlet?action=uInforCompany">
            <div class="titleBasic"><span>基本信息</span></div>
            <div class="uAll">
                <div class="uName mainIn"><font color="#CCCCCC">公司名称：</font><input type="text" name="uName" /></div>
                <div class="both"></div>
                <div class="uPhone mainIn"><font color="#CCCCCC">电话：</font><input type="text" name="uPhone" /></div>
                <div class="uMail mainIn"><font color="#CCCCCC">邮箱：</font><input type="text" name="uPlace" /></div>
                <div class="both"></div>
                <div class="uPlace mainIn"><font color="#CCCCCC">所在地：</font><input type="text" name="uEmail" /></div>
            </div>
    		<div class="txtForm">
                <div class="titleBasic"><span>公司简介</span></div>
                <textarea name="text" class="txt" cols="85" rows="20"></textarea>
                <div class="note"><font color="#FFFF00">* 简单地描述一下公司</font></div>  
                <div class="btnSubmit">
                    <input type="submit" value="保存信息" /> 
    			</div>
            </div>
         </form>
    </div>  
</body>
</html>
