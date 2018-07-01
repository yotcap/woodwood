<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link href="css/login.css" rel='stylesheet' type='text/css' />
<script src="js/login.js"></script>
</head>
<body>

<script>$(document).ready(function(c) {
	$('.close').on('click', function(c){
		$('.login-form').fadeOut('slow', function(c){
	  		$('.login-form').remove();
		});
	});	  
});
</script>
 <!--SIGN UP-->
 <div class="bottomB">
		<div class="containerHeader">
        	<div class="headerHome">
        		<span><a href="index.jsp">WebCap</a></span>
            </div>
        </div>
        <h1>You're Welcome</h1>
        
        <div class="logSelectForm" id="logSelect">
        	<div class="close" onClick=""></div>
            <div class="head-info">
            	<label class="lbl-1"> </label>
             	<label class="lbl-2"> </label>
             	<label class="lbl-3"> </label>
             </div>
             <div class="clear"> </div>
             <div class="sForm">
                 <div class="sUser" onClick="logPersonOpen();"><img src="img/user.png" /><span><a href="#">个人登录</a></span></div>
                 <div class="sCompany" onClick="logCompanyOpen();"><img src="img/company.png" /><span><a href="#">公司登录</a></span></div>
				 <div class="reg">
                	<p>还未注册？<a href="reg.jsp"  target="_blank" onClick="">点此注册</a></p>
                	<br />
            	</div>
             </div>      
        </div>
        
        
        
        
        
        <div class="login-form" id="log">
            <div class="close" onClick="logClose();"></div>
            <div class="head-info">
            	<label class="lbl-1"> </label>
             	<label class="lbl-2"> </label>
             	<label class="lbl-3"> </label>
             </div>
             <div class="clear"> </div>
            <div class="avtar">
                <img src="img/avtar.png" />
            </div>
            <form action="UserServlet?action=logStudent" method="post">
                <input name="username" type="text" class="logText" value="User name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'User name';}" >
                <div class="key">
                	<input name="password" type="password" class="logPawMain"value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
                </div>
                <div class="logForget" onClick="getPerson();"><a href="#">忘记密码？</a></div>
                <div class="signin">
                	<input type="submit" value="Login" class="logSubmit" />
                </div>
            </form>
            <div class="reg">
                <p>还未注册？<a href="reg.jsp"  target="_blank" onClick="">点此注册</a></p>
                <br />
            </div>
        </div>
        
        
        <div class="login-formCompany" id="logCompany">
            <div class="close" onClick="logClose();"></div>
            <div class="head-info">
            	<label class="lbl-1"> </label>
             	<label class="lbl-2"> </label>
             	<label class="lbl-3"> </label>
             </div>
             <div class="clear"> </div>
            <div class="avtar">
                <img src="img/avtar.png" />
            </div>
            <form action="UserServlet?action=logCompany" method="post">
                <input name="username" type="text" class="logText" value="Company name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Company name';}" >
                <div class="key">
                	<input name="password" type="password" class="logPawMain"value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
                </div>
                <div class="logForget" onClick="getCompany();"><a href="#">忘记密码？</a></div>
                <div class="signin">
                	<input type="submit" value="Login" class="logSubmit" />
            	</div>
            </form>
            <div class="reg">
                <p>还未注册？<a href="reg.jsp" onClick="">点此注册</a></p>
                <br />
            </div>
        </div>
        

      
      
      
      
    <div class="copy-rights">
		<p>Copyright &copy; 2017.Company name All rights reserved.Powered by <a href="http://www.sobaho.com">www.sobaho.com</a></p>
    </div>
    
 </div>

</body>
</html>