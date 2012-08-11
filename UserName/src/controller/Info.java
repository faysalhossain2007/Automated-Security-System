package controller;

public class Info {
	private String userName;
	private String passWord;
	private int id;
	
	public Info(){}
	public Info(int userId, String name, String pass)
	{
		setName(name);
		setPass(pass);
		setId(userId);
	}
	private void setId(int userId) {
		// TODO Auto-generated method stub
		id=userId;
		
	}
	private void setPass(String	name) {
		// TODO Auto-generated method stub
		userName=name;
		
	}
	private void setName(String pass) {
		// TODO Auto-generated method stub
		passWord=pass;		
	}
	public String getName(){
		return userName;
	}
	public String getPass() {
		return passWord;		
	}
	public int getId()
	{
		return id;
	}
}
