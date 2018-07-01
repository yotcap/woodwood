package javaclass;

import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
public class Mail {
	private String qm ="mtr123"; //163邮箱密码
	private String tu = "163.com"; //邮箱的后缀域名
	//String tto="17853505613@163.com"; //接收邮件的邮箱
	//String tto="kaibing1997@gmail.com";
	//String tto="2500365589@qq.com";
	private String ttitle="注册通知";//标题
	private String tcontent="您注册了";//发送的信息
	
	public boolean Mail(String mail) throws MessagingException{
		String tto=mail;
		 String qm ="mtr123"; //163邮箱密码
		 String tu = "163.com"; //邮箱的后缀域名
		//String tto="17853505613@163.com"; //接收邮件的邮箱
		//String tto="kaibing1997@gmail.com";
		//String tto="2500365589@qq.com";
		 String ttitle="注册通知";//标题
		 String tcontent="您注册了";//发送的信息
		
		Properties props=new Properties();
		props.put("mail.smtp.host","smtp."+tu);
		props.put("mail.smtp.auth","true");
		Session s=Session.getInstance(props);
		s.setDebug(true);
		MimeMessage message=new MimeMessage(s);
		//给消息对象设置发件人/收件人/主题/发信时间
		InternetAddress from=new InternetAddress("15552465908@"+tu); //这里的115798090 改为您发信的QQ号
		message.setFrom(from);
		InternetAddress to=new InternetAddress(tto);
		message.setRecipient(Message.RecipientType.TO,to);
		message.setSubject(ttitle);
		message.setSentDate(new Date());
		//给消息对象设置内容
		BodyPart mdp=new MimeBodyPart();//新建一个存放信件内容的BodyPart对象
		mdp.setContent(tcontent,"text/html;charset=gb2312");//给BodyPart对象设置内容和格式/编码方式
		Multipart mm=new MimeMultipart();//新建一个MimeMultipart对象用来存放BodyPart对
		//象(事实上可以存放多个)
		mm.addBodyPart(mdp);//将BodyPart加入到MimeMultipart对象中(可以加入多个BodyPart)
		message.setContent(mm);//把mm作为消息对象的内容
		message.saveChanges();
		Transport transport=s.getTransport("smtp");
		transport.connect("smtp."+tu,"15552465908",qm); //这里的115798090也要修改为您的QQ号码
		transport.sendMessage(message,message.getAllRecipients());
		transport.close();
		return true;
	}
	
}
