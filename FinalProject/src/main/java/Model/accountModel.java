package Model;

public class accountModel {
	private int accID;
	private String userName;
	private String pass;
	private int isSell;
	private int isAdmin;
	private String email;
	
	public accountModel() {
		
	}
	
	public accountModel(int accID, String userName, String pass, int isSell, int isAdmin, String email) {
		this.accID = accID;
		this.userName = userName;
		this.pass = pass;
		this.isSell = isSell;
		this.isAdmin = isAdmin;
		this.email = email;
	}
	
	public int getAccID() {
		return accID;
	}
	public void setAccID(int accID) {
		this.accID = accID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getIsSell() {
		return isSell;
	}
	public void setIsSell(int isSell) {
		this.isSell = isSell;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
