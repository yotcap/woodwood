<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
    <%@page import="javaclass.Mass"%>
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
	width:700px;
	margin:50px 0px 0px 50px;
	}
.titleBasic{
	padding-bottom:20px;
	border-bottom:2px solid #CCC;
	}
.titleBasic span{ font-size:22px;color:#FFF;}
.my_mes{
	width:700px;
	height:500px;
	margin-top:7px;
	}
</style>
</head>

<body>
	<div class="content">
		<div class="titleBasic"><span>留言管理</span></div>
        <div class="my_mes" id="my_mes">
        	<%
				// 获取图书信息集合
					List<Mass> list = (List<Mass>)session.getAttribute("message");
					// 判断集合是否有效
					
					if(list == null || list.size() < 1){
						out.print("没有数据！");
					}else{
						// 遍历图书集合中的数据
						for(Mass book : list){
							
			%>
			<div  style="background:#CCC;
						width:706px;	height:200px;	margin-top:1px; margin-bottom:3px;">
            	
                <div  style="width:706px;
				height:40px;float:left;	border-bottom:#999 solid 4px;text-align:center;"><!--标题 -->
                	<span style="display:block;	margin-top:10px;">来自：<%=book.getFromUsername()%></span>
                </div>
                <div  style="float:left;
			width:706px;height:112px;border-bottom:#999 solid 4px;"><!--帖子 -->
                	<%=book.getContent()%>
                </div>
                <div  style="float:left;
			width:706px;height:40px;padding-top:7px;color:#888;"><!--信息 -->
                	<div style="margin-right:20px;float:right;">
                    	
                        留给：<span  style="color:#000;"><%=book.getToUsername()%></span>
                    </div>
                	
                </div>
            </div>
            <%
					}
				}
			%>
        </div>
    </div>
    

</body>
</html>
