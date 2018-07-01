<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无标题文档</title>
<script type="text/javascript" src="../../js/user.js"></script>
<style type="text/css">
body{
	width:850px;
	height: 500px;
	background:#C99;
	overflow-x:hidden;
	}
.content{
	width:800px;
	margin:50px 0px 0px 20px;
	}
.titleBasic{
	padding-bottom:20px;
	border-bottom:2px solid #CCC;
	}
.titleBasic span{ font-size:22px;color:#FFF;}
.left_content{
	width:520px;
	height:500px;
	float:left;
	margin-top:20px;
	}
.right_content{
	float:left;
	background:#CCC;
	width:780px;
	height:450px;
	margin-top:20px;
	}
.right_content textarea{
	width:760px;}
.right_content span{display:block;margin:20px 0px 0px 10px;}
.right_content input{
	width:760px;
	margin-top:10px;
	margin-left:7px;
	}
.btn_up{
	width:760px;
	height:30px;
	margin-top:20px;
	margin-left:7px;
	}
.right_content textarea{
	margin-top:5px;
	margin-left:7px;
	}
</style>
</head>

<body>
	<div class="content">
        <div class="right_content"><!--发帖 -->
        <form action="../../UserServlet?action=Postmessage" method="post">
            <span>内容</span>
            <textarea name="messageContent" rows="18" ></textarea>
            <input type="submit" value="留言" class="btn_up"/>
         </form>
        </div>
    </div>
    

</body>
</html>
