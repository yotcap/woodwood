// JavaScript Document
window.onload=function(){
	var f;
	var menu_ul= document.getElementById("menu");
	var menulu = document.getElementById("menu").getElementsByTagName("li");
	var menuA = document.getElementById("menu").getElementsByTagName("a");
	menu_ul.onmouseout=function(){
			f=setTimeout(function(){menulu[0].style.borderTop="2px solid #0CF";menuA[0].style.color="#0CF";},500);//延时0.3秒
			}
	menulu[0].style.borderTop="#0CF 2px solid";
	menuA[0].style.color="#0CF";
	for(var i=0;i<menulu.length;i++){
		menulu[i].onmouseover=function(){
	
			for(var j=0;j<menulu.length;j++)
			{	window.clearInterval(f); //清除定时器
				 //menulu[j].style.backgroundColor="black"; 
				 menulu[0].style.borderTop="2px solid rgba(200,200,200,0)";
				 menuA[0].style.color="#FFF"; 
			}
			this.style.borderTop="2px solid #0CF";
			menuA[i].style.color="#0CF";
			//menulu[0].style.borderTop="0px";
			//menuA[0].style.color="#FFF"; 
		}
		
		menulu[i].onmouseout=function(){
	
			for(var j=0;j<menulu.length;j++){
				 window.clearInterval(f); //清除定时器
				 menulu[j].style.borderTop="2px solid rgba(200,200,200,0)";
			}
		}
	}	
	
	
	
	
}
