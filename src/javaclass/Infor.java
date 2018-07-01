package javaclass;

public class Infor {
	public String name;//名称
	public String phone;//电话
	public String address;//地址
	public String email;//邮箱
	public String introduction;//简介
	//姓名
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	
	//电话
	public void setPhone(String phone){
		this.phone=phone;
	}
	public String getPhone(){
		return phone;
	}
	//地址
	public void setAddress(String address){
		this.address=address;
	}
	public String getAddress(){
		return address;
	}
	
	
	//邮件
	public void setEmail(String email){
		this.email=email;
	}
	public String getEmail(){
		return email;
	}
	
	//简介
	public void setIntroduction(String introduction){
		this.introduction=introduction;
	}
	public String getIntroduction(){
		return introduction;
	}
}
