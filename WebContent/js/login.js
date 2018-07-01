// JavaScript Document
function logPersonOpen(){
	document.getElementById('logSelect').style.display="none";
	document.getElementById('log').style.display="block";
	}
function logCompanyOpen(){
	document.getElementById('logSelect').style.display="none";
	document.getElementById('logCompany').style.display="block";
	}
function regOpen(){
	document.getElementById('log').style.display="none";
	document.getElementById('select').style.display="block";
	}
function regClose(){
	document.getElementById('select').style.display="none";
	document.getElementById('log').style.display="block";
	}
function logOpen(){
	document.getElementById('regPerson').style.display="none";
	document.getElementById('regCompany').style.display="none";
	document.getElementById('log').style.display="block";
	}
function logClose(){
	document.getElementById('log').style.display="none";
	document.getElementById('logCompany').style.display="none";
	document.getElementById('logSelect').style.display="block";
	}
function regPersonOpen(){
	document.getElementById('select').style.display="none";
	document.getElementById('regPerson').style.display="block";
	}
function regCompanyOpen(){
	document.getElementById('select').style.display="none";
	document.getElementById('regCompany').style.display="block";
	}
///////-----------注册页面
function logOpen_reg_page(){
	document.getElementById('regPerson').style.display="none";
	document.getElementById('regCompany').style.display="none";
	document.getElementById('select').style.display="block";
	
	}
//////----------------注册检查--------------
//-----个人----
function regUserTipShow(){document.getElementById('tipUser').style.display="block";}
function regUserTipHide(){document.getElementById('tipUser').style.display="none";}
function regPerUserCheckHide(){
	document.getElementById('errorUserShort').style.display="none";
	document.getElementById('errorUserLong').style.display="none";
	}
function regPerUserCheck(){
	var len=document.getElementById('jude_user').value.length;
	var val=document.getElementById('jude_user').value;
	if(val != '请输入用户名'){
		if(len<6){document.getElementById('errorUserShort').style.display="block";}
		else if(len>16){document.getElementById('errorUserLong').style.display="block";}
	}
}

function regPerMailTipShow(){document.getElementById('tipMail').style.display="block";}
function regPerMailTipHide(){document.getElementById('tipMail').style.display="none";}
function regPerMailCheckHide(){document.getElementById('errorMail').style.display="none";}

function regPerMailCheck(){
	var email= document.getElementById('judge_email').value;
	if(email.indexOf('@') < 0 ){document.getElementById('errorMail').style.display="block";}
	else {document.getElementById('errorMail').style.display="none";}
	}
	
	
///------公司------
function regComNameTipShow(){document.getElementById('tipComName').style.display="block";}
function regComNameTipHide(){document.getElementById('tipComName').style.display="none";}
function regComNameCheckHide(){document.getElementById('errorComName').style.display="none";}
function regComNameCheck(){
	var len=document.getElementById('jude_userCom').value.length;
	var val=document.getElementById('jude_userCom').value;
	if(val != '请输入用户名'){
		if(len<6){document.getElementById('errorComName').style.display="block";}
		else if(len>16){document.getElementById('errorComName').style.display="block";}
	}
}
function regComMailTipShow(){document.getElementById('tipComMail').style.display="block";}
function regComMailTipHide(){document.getElementById('tipComMail').style.display="none";}
function regComMailCheckHide(){document.getElementById('errorComMail').style.display="none";}
function regComMailCheck(){
	var email= document.getElementById('judge_email').value;
	if(email.indexOf('@') < 0 ){document.getElementById('errorComMail').style.display="block";}
	else {document.getElementById('errorComMail').style.display="none";}
}
///////////////////////////////////////////////////////////
//////////////--------------登录检查------------------------
///////////////////////////////////////////////////////////
function person_log_form(thisform){
	with (thisform)
		  {
		  document.getElementById('log_name_error').style.display="none";
		  document.getElementById('log_name_error_a').style.display="none";
		  if (person_log_name_check(username) == false)
			{username.focus();return false}
		  else if(person_log_paw_check(password) == false)
		    {password.focus();return false}
	}
}
function person_log_name_check(field){
		with (field){
		  if (value == null || value == "" || value == 'User name'){
			  	document.getElementById('log_name_error').style.display="block";
				return false;
			}
		  else if(value.length < 6 || value.length >16){
			  document.getElementById('log_name_error_a').style.display="block";
			  return false;
			  }
		  else {
			  document.getElementById('log_name_error').style.display="none";
			  document.getElementById('log_name_error_a').style.display="none";
			  return true
			  }
		  }
}
function person_log_paw_check(p){
	with(p){
		if (value == null || value == "" || value == 'Password'){
			  	document.getElementById('log_paw_error').style.display="block";
				return false;
			}
		//////////密码错误(待定)
		
		else {
			document.getElementById('log_paw_error').style.display="none";
			document.getElementById('log_paw_error_a').style.display="none";
			return true
			}
	}
}

function company_log_form(thisform){
	with (thisform){
		  document.getElementById('log_com_name_error').style.display="none";
		  document.getElementById('log_com_name_error_a').style.display="none";
		  if (company_log_name_check(username) == false)
			{username.focus();return false}
		  else if(company_log_paw_check(password) == false)
		    {password.focus();return false}
	}
}
function company_log_name_check(field){
		with (field){
		  if (value == null || value == "" || value == 'Company name'){
			  	document.getElementById('log_com_name_error').style.display="block";
				return false;
			}
		  else if(value.length < 6 || value.length >16){
			  document.getElementById('log_com_name_error_a').style.display="block";
			  return false;
			  }
		  else {
			  document.getElementById('log_com_name_error').style.display="none";
			  document.getElementById('log_com_name_error_a').style.display="none";
			  return true
			  }
		  }
}
function company_log_paw_check(p){
	with(p){
		if (value == null || value == "" || value == 'Password'){
			  	document.getElementById('log_com_paw_error').style.display="block";
				return false;
			}
		//////////密码错误(待定)
		
		else {
			document.getElementById('log_com_paw_error').style.display="none";
			document.getElementById('log_com_paw_error_a').style.display="none";
			return true;
			}
	}
}

///////////////////////////////////////////////////////////
//////////////--------------注册检查------------------------
///////////////////////////////////////////////////////////
