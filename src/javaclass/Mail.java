package javaclass;

import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
public class Mail {
	private String qm ="mtr123"; //163��������
	private String tu = "163.com"; //����ĺ�׺����
	//String tto="17853505613@163.com"; //�����ʼ�������
	//String tto="kaibing1997@gmail.com";
	//String tto="2500365589@qq.com";
	private String ttitle="ע��֪ͨ";//����
	private String tcontent="��ע����";//���͵���Ϣ
	
	public boolean Mail(String mail) throws MessagingException{
		String tto=mail;
		 String qm ="mtr123"; //163��������
		 String tu = "163.com"; //����ĺ�׺����
		//String tto="17853505613@163.com"; //�����ʼ�������
		//String tto="kaibing1997@gmail.com";
		//String tto="2500365589@qq.com";
		 String ttitle="ע��֪ͨ";//����
		 String tcontent="��ע����";//���͵���Ϣ
		
		Properties props=new Properties();
		props.put("mail.smtp.host","smtp."+tu);
		props.put("mail.smtp.auth","true");
		Session s=Session.getInstance(props);
		s.setDebug(true);
		MimeMessage message=new MimeMessage(s);
		//����Ϣ�������÷�����/�ռ���/����/����ʱ��
		InternetAddress from=new InternetAddress("15552465908@"+tu); //�����115798090 ��Ϊ�����ŵ�QQ��
		message.setFrom(from);
		InternetAddress to=new InternetAddress(tto);
		message.setRecipient(Message.RecipientType.TO,to);
		message.setSubject(ttitle);
		message.setSentDate(new Date());
		//����Ϣ������������
		BodyPart mdp=new MimeBodyPart();//�½�һ������ż����ݵ�BodyPart����
		mdp.setContent(tcontent,"text/html;charset=gb2312");//��BodyPart�����������ݺ͸�ʽ/���뷽ʽ
		Multipart mm=new MimeMultipart();//�½�һ��MimeMultipart�����������BodyPart��
		//��(��ʵ�Ͽ��Դ�Ŷ��)
		mm.addBodyPart(mdp);//��BodyPart���뵽MimeMultipart������(���Լ�����BodyPart)
		message.setContent(mm);//��mm��Ϊ��Ϣ���������
		message.saveChanges();
		Transport transport=s.getTransport("smtp");
		transport.connect("smtp."+tu,"15552465908",qm); //�����115798090ҲҪ�޸�Ϊ����QQ����
		transport.sendMessage(message,message.getAllRecipients());
		transport.close();
		return true;
	}
	
}
