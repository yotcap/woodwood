<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="java.util.List"%>
<%@page import="javaclass.posts"%>
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
	background:#C75;
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
	width:280px;
	height:450px;
	margin-top:20px;
	}
.right_content textarea{
	width:260px;}
.right_content span{display:block;margin:20px 0px 0px 10px;}
.right_content input{
	width:260px;
	margin-top:10px;
	margin-left:7px;
	}
.btn_up{
	width:260px;
	height:30px;
	margin-top:20px;
	margin-left:7px;
	}
.right_content textarea{
	margin-top:5px;
	margin-left:7px;
	}
.btn_more{
	background:#CCC;
	width:50px;
	height:50px;
	position:fixed; 
	bottom:25px;
	left:548px;
	}
.btn_more span{margin:7px;}
</style>
</head>

<body>
	<div class="content">
		<div class="titleBasic"><span>帖子管理</span></div>
        <div class="left_content" id="left_content"><!--帖子内容 -->
        <%
				// 获取图书信息集合
					List<posts> list = (List<posts>)session.getAttribute("posts");
					// 判断集合是否有效
					
					if(list == null || list.size() < 1){
						out.print("没有数据！");
					}else{
						// 遍历图书集合中的数据
						for(posts book : list){
							
			%>
			<div  style="background:#CCC;
						width:500px;	height:200px;	margin-top:1px; margin-bottom:3px;">
            	
                <div  style="width:500px;
				height:40px;float:left;	border-bottom:#999 solid 4px;text-align:center;"><!--标题 -->
                	<span style="display:block;	margin-top:10px;"><%=book.getTitle()%></span>
                </div>
                <div  style="float:left;
			width:500px;height:112px;border-bottom:#999 solid 4px;"><!--帖子 -->
                	<%=book.getContent()%>
                </div>
                <div  style="float:left;
			width:500px;height:40px;padding-top:7px;color:#888;"><!--信息 -->
                	<div style="margin-right:20px;float:right;">
                    	
                        发帖时间：<span  style="color:#000;"><%=book.getTime()%></span>
                    </div>
                	
                </div>
            </div>
            <%
					}
				}
			%>
        </div>
        <div class="right_content"><!--发帖 -->
         <form action="../../UserServlet?action=Poststudent" method="post">
        	<span>主题</span>
            <input name="title" type="text"/>
            <span>内容</span>
            <textarea name="content" rows="18" ></textarea>
            <input type="submit" value="发表" class="btn_up"/>
           </form>
        </div>
    </div>
</body>
</html>
