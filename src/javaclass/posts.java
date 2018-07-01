package javaclass;

public class posts {
	public String title;
	public String content;
	public String fuser;
	public String time;
	public String usertype;
	public int id;//ID
	//ID
	public void setID(int ID){
		this.id=ID;
	}
	public int  getID(){
		return id;
	}
	public void setUsertype(String usertype){
		this.usertype=usertype;
	}
	public String getUsertype(){
		return this.usertype;
	}
	public void setTitle(String title){
		this.title=title;
	}
	public String getTitle(){
		return this.title;
	}
	public void setContent(String content){
		this.content=content;
	}
	public String getContent(){
		return this.content;
	}
	public void setFuser(String fuser){
		this.fuser=fuser;
	}
	public String getFuser(){
		return this.fuser;
	}
	public void setTime(String time){
		this.time=time;
	}
	public String getTime(){
		return this.time;
	}
	
}
