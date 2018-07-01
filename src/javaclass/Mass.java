package javaclass;

public class Mass {
	public String toUsername;
	public String fromUsername;
	public String content;
	
	public void setToUsername(String username){
		this.toUsername=username;
	}
	public String getToUsername(){
		return this.toUsername;
	}
	

	public void setFromUsername(String username){
		this.fromUsername=username;
	}
	public String getFromUsername(){
		return this.fromUsername;
	}
	
	public void setContent(String content){
		this.content=content;
	}
	public String getContent(){
		return this.content;
	}
}
