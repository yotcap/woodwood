<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registered</title>
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
        		<span><a href="#">WebCap</a></span>
            </div>
        </div>
        <h1>You're Welcome</h1>

        
        
        <div class="selectForm" id="select">
        	<div class="close" onClick=""></div>
            <div class="head-info">
            	<label class="lbl-1"> </label>
             	<label class="lbl-2"> </label>
             	<label class="lbl-3"> </label>
             </div>
             <div class="clear"> </div>
             <div class="sForm">
                 <div class="sUser" onClick="regPersonOpen();"><img src="img/user.png" /><span><a href="#">个人注册</a></span></div>
                 <div class="sCompany" onClick="regCompanyOpen();"><img src="img/company.png" /><span><a href="#">公司注册</a></span></div>

             </div>      
        </div>
        
        
        
        <div class="regPersonForm" id="regPerson">
        	<div class="close" onClick="logOpen_reg_page();"></div>
        	<div class="head-info">
                <label class="lbl-1"> </label>
                <label class="lbl-2"> </label>
                <label class="lbl-3"> </label>
            </div>
            <div class="clear"> </div>
            <div class="avtar">
            	<img src="img/avtar.png" />
            </div>
            <form action="UserServlet?action=regStudent" method="post" >
            	<div class="regPerForm">
            		<input name="username" id="jude_user" type="text" class="regText" value="请输入用户名" onFocus="this.value='';regUserTipShow();" onblur="regUserTipHide();if (this.value == '') {this.value = '请输入用户名';}" />
                    <div class="regTipa regUserTip" id="tipUser"><span>↑ 请输入用户名，6-16位字母/数字组合</span></div>
                	<div class="regUserError regUserErrorL" id="errorUserLong" ><span>↓ 用户名过长</span></div>
                    <div class="regUserError regUserErrorS" id="errorUserShort" ><span>↓ 用户名过短</span></div>
                    
                    
                    <input type="text" class="regPawText" value="请输入密码" id="pawText" />
                    <input name="password" type="password" class="regPaw" id="pawPaw"  onkeyup="value=value.replace(/[^\w\.\/]/ig,'')"/>
                    <div class="regTipP regPawTip" id="tipPaw"><span>↑ 6-16位字母/数字组合</span></div>
                    <div class="regPawError" id="errorPaw" ><span>↑ 请确认密码格式</span></div>
                    
                    
                    <input type="text" class="regPawText" value="请重复您的密码" id="pawTextAgain" />
                    <input name="passworda" type="password" class="regPaw" id="pawPawAgain"  onkeyup="value=value.replace(/[^\w\.\/]/ig,'')" />
                    
                    <div class="regTip regPawTipA" id="tipPawA"><span>↑ 重复您的密码</span></div>
                    <div class="regPawErrorA" id="errorPawA" ><span>↑ 请确保密码保持一致</span></div>
                    
                                     
                    <input name="email" id="judge_email" type="text" class="regMail" value="请输入邮箱" onFocus="this.value='';regPerMailTipShow();" onblur="if (this.value == '') {this.value = '请输入邮箱';};regPerMailTipHide();"/>
                    <div class=" regTip regMailTip" id="tipMail"><span>↑ 输入您的邮箱</span></div>
                    <div class="regMailError" id="errorMail" ><span>↑ 请确保邮箱正确</span></div>
                           
                    
                </div>
                <div class="signin">
                	<input type="submit" class="regSubmit" value="注册"  /><br />
            	</div>
            </form>
            <div class="reg">
           		<p>已注册？<a href="log.html" target="_blank" onClick="">点此登录</a></p>
            <br /></div>
        </div>
        
        
          
      	<div class="regCompanyForm" id="regCompany">
        
        	<div class="close" onClick="logOpen_reg_page();"></div>
        	<div class="head-info">
                <label class="lbl-1"> </label>
                <label class="lbl-2"> </label>
                <label class="lbl-3"> </label>
            </div>
            <div class="clear"> </div>
            <div class="avtar">
            	<img src="img/avtar.png" />
            </div>
            <form action="UserServlet?action=regCompany" method="post" >
            	<div class="regComForm">
                    <input name="username" id="jude_userCom" type="text" class="regText" value="Company name" onFocus="this.value='';regComNameTipShow();" onblur="if (this.value == '') {this.value = 'Company name';};regComNameTipHide();" />
                    <div class=" regTip regComTip regComNameTip" id="tipComName"><span>↑ 6-16位字母/数字组合</span></div>
                    <div class="regTip regComNameError" id="errorComName" ><span>↓ 请确认用户名</span></div>
                 
                    
                    <input type="text" class="regPawText" value="请输入密码" id="pawCompanyText" />
                    <input name="password" type="password" class="regPaw" id="pawCompanyPaw" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')" />
                    <div class="regComPawTip" id="tipComPaw"><span>↑ 6-16位字母/数字组合</span></div>
                    <div class="regComPawError" id="errorComPaw" ><span>↑ 请确认密码格式</span></div>
                    
                    
                    
                    <input type="text" class="regPawText" value="请重复您的密码" id="pawCompanyTextAgain" />
                    <input name="passworda"type="password" class="regPaw" id="pawCompanyPawAgain" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')" />
                    <div class="regComPawTipA" id="tipComPawA"><span>↑ 重复您的密码</span></div>
                    <div class="regComPawErrorA" id="errorComPawA" ><span>↑ 请确保密码保持一致</span></div>
                    
                    
                    
                    
                    
                    <input name="email" id="judge_ComEmail" type="text" class="regMail" value="请输入邮箱" onFocus="this.value='';regComMailTipShow();" onblur="if (this.value == '') {this.value = '请输入邮箱';};regComMailTipHide();"/>
                    <div class="regComMailTip" id="tipComMail"><span>↑ 输入您的邮箱</span></div>
                    <div class="regComMailError" id="errorComMail" ><span>↑ 请确保邮箱正确</span></div>
                    
                    
                    </div>
                    <div class="signin">
                        <input type="submit" class="regSubmit" value="注册"  /><br />
                    </div>
               
                
            </form>
            <div class="reg">
           		<p>已注册？<a href="log.jsp"  target="_blank" onClick="">点此登录</a></p>
            <br /></div>
        </div>
      
      
    <div class="copy-rights">
		<p>Copyright &copy; 2017.Company name All rights reserved.Powered by <a href="http://www.sobaho.com">www.sobaho.com</a></p>
    </div>
    
 </div>
<script>
	var tx = document.getElementById("pawText"), pwd = document.getElementById("pawPaw");
	tx.onfocus = function(){
		if(this.value != "请输入密码") return;
		this.style.display = "none";
		pwd.style.display = "block";
		pwd.value = "";
		pwd.focus();
		}
	pwd.focus = function(){
		document.getElementById('tipPaw').style.display="block";
		}
		
	pwd.onblur = function(){
		document.getElementById('tipPaw').style.display="none";
		var len=document.getElementById('pawPaw').value.length;
		var val=document.getElementById('pawPaw').value;
			
		if(this.value != "") return;
		this.style.display = "none";
		document.getElementById('tipPaw').style.display="none";
	
		tx.style.display = "block";
		tx.value = "请输入密码";
		}
		
		
		
	var tt = document.getElementById("pawTextAgain"), pwda = document.getElementById("pawPawAgain");
	tt.onfocus = function(){
		if(this.value != "请重复您的密码") return;
		this.style.display = "none";
		pwda.style.display = "block";
		pwda.value = "";
		pwda.focus();
		}
	pwda.focus = function(){
		document.getElementById('tipPawA').style.display="block";
		}
	pwda.onblur = function(){
		document.getElementById('tipPawA').style.display="none";
		var valA=document.getElementById('pawPawAgain').value;
		var val=document.getElementById('pawPaw').value;
		
		if(this.value != "") return;
		this.style.display = "none";
		document.getElementById('tipPawA').style.display="none";
		
		tt.style.display = "block";
		tt.value = "请重复您的密码";
		}
		
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
	
		
	var txx = document.getElementById("pawCompanyText"), pwdx = document.getElementById("pawCompanyPaw");
	txx.onfocus = function(){
		if(this.value != "请输入密码") return;
		this.style.display = "none";
		pwdx.style.display = "block";
		pwdx.value = "";
		pwdx.focus();
		}
	pwdx.focus = function(){
		document.getElementById('tipComPaw').style.display="block";
		}
	pwdx.onblur = function(){
		document.getElementById('tipComPaw').style.display="none";
		var len=document.getElementById('pawCompanyPaw').value.length;
		var val=document.getElementById('pawCompanyPaw').value;
		
		if(this.value != "") return;
		this.style.display = "none";
		document.getElementById('tipComPaw').style.display="none";
		txx.style.display = "block";
		txx.value = "请输入密码";
		}
		
		
	var ttx = document.getElementById("pawCompanyTextAgain"), pwdax = document.getElementById("pawCompanyPawAgain");
	ttx.onfocus = function(){
		if(this.value != "请重复您的密码") return;
		this.style.display = "none";
		pwdax.style.display = "block";
		pwdax.value = "";
		pwdax.focus();
		}
	pwdax.focus = function(){
		document.getElementById('tipComPawA').style.display="block";
		}
	pwdax.onblur = function(){
		document.getElementById('tipComPawA').style.display="none";	
		if(this.value != "") return;
		this.style.display = "none";
		document.getElementById('tipComPawA').style.display="none";
		ttx.style.display = "block";
		ttx.value = "请重复您的密码";
		}
		
		
///////////-------------注册检查------	
//////////////个人
function person_reg_form(thisform){
	with (thisform)
		  {
		  document.getElementById('errorUserLong').style.display="none";
		  document.getElementById('errorUserShort').style.display="none";
		  document.getElementById('errorMail').style.display="none";
		  if (person_reg_name_check(username) == false)
			{username.focus();return false;}
		  else if(person_reg_paw_check(password) == false)
		    { password.focus();return false;}
		  else if(person_reg_paw_a_check(passworda) == false)
		    { passworda.focus();return false;}
		  else if(person_log_email_check(email) == false)
		  	{email.focus();return false}
	}
}
function person_reg_name_check(p){
	with (p){
		   if(value.length < 6 || value == '请输入用户名'){
			  document.getElementById('errorUserShort').style.display="block";
			  return false;
			  }
		  else if(value.length >16 ){
			  document.getElementById('errorUserLong').style.display="block";
			  return false;
			  }
		  else {
			  document.getElementById('errorUserShort').style.display="none";
			  document.getElementById('errorUserLong').style.display="none";
			  return true;
			  }
		  }
	
}
function person_reg_paw_check(p){
	with(p){
		document.getElementById('errorPaw').style.display="none";
		if(value == '' || value == null || value == '请输入密码' || value.length < 6 || value.length > 16){
			document.getElementById('errorPaw').style.display="block";
			return false;
			}
		else {
			document.getElementById('errorPaw').style.display="none";
			return true;
			}
		}
}
function person_reg_paw_a_check(p){
	with(p){
		document.getElementById('errorPawA').style.display="none";
		paw = document.getElementById('pawPaw').value;
		if(value == '' || value != paw || value == "请重复您的密码"){
			document.getElementById('tipPawA').style.display="none";
			document.getElementById('errorPawA').style.display="block";
			return false;
			}
		else{
			document.getElementById('errorPawA').style.display="none";
			return true;
			}
		}
	}
function person_log_email_check(p){
	with(p){
		apos=value.indexOf("@");
		dotpos=value.lastIndexOf(".");
		if(value == null || value == "" || value == '请输入邮箱' ){
			document.getElementById('errorMail').style.display="block";
			return false;
			}
		else if(apos<1 || dotpos-apos<2){
			document.getElementById('errorMail').style.display="block";
			return false;
			}
		else{
			document.getElementById('errorMail').style.display="none";
			return true;
			}
		}
	}
	
//////////公司

function company_reg_form(thisform){
	with(thisform){
		document.getElementById('errorComName').style.display="none";
		document.getElementById('errorComPawA').style.display="none";
		document.getElementById('errorComPaw').style.display="none";
		document.getElementById('errorComMail').style.display="none";
		if (company_reg_name_check(username) == false)
	      {username.focus();return false;}
		else if(company_reg_paw_check(password) == false)
		  { password.focus();return false;}
		else if(company_reg_paw_a_check(passworda) == false)
		  { passworda.focus();return false;}
		else if(company_log_email_check(email) == false)
		  {email.focus();return false}
		}
	}
function company_reg_name_check(p){
	with (p){
		   if(value.length < 6 || value == 'Company name' || value.length >16 ){
			  document.getElementById('errorComName').style.display="block";
			  return false;
			  }
		  else {
			  document.getElementById('errorComName').style.display="none";
			  return true;
			  }
		  }
}
function company_reg_paw_check(p){
	with(p){
		document.getElementById('errorComPaw').style.display="none";
		if(value == '' || value == null || value == '请输入密码' || value.length < 6 || value.length > 16){
			document.getElementById('errorComPaw').style.display="block";
			return false;
			}
		else {
			document.getElementById('errorComPaw').style.display="none";
			return true;
			}
		}
	}
function company_reg_paw_a_check(p){
	with(p){
		document.getElementById('errorComPawA').style.display="none";
		paw = document.getElementById('pawCompanyPaw').value;
		if(value == '' || value != paw || value == "请重复您的密码"){
			document.getElementById('tipComPawA').style.display="none";
			document.getElementById('errorComPawA').style.display="block";
			return false;
			}
		else{
			document.getElementById('errorComPawA').style.display="none";
			return true;
			}
		}
	}
function company_log_email_check(p){
	with(p){
		apos=value.indexOf("@");
		dotpos=value.lastIndexOf(".");
		if(value == null || value == "" || value == '请输入邮箱' ){
			document.getElementById('errorComMail').style.display="block";
			return false;
			}
		else if(apos<1 || dotpos-apos<2){
			document.getElementById('errorComMail').style.display="block";
			return false;
			}
		else{
			document.getElementById('errorComMail').style.display="none";
			return true;
			}
		}
	}
</script>
</body>
</html>