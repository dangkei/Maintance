package common.entitys;

public class User {
	private String userName;
	private String password;
	private String validCode;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getValidCode() {
		return validCode;
	}
	public void setValidCode(String validCode) {
		this.validCode = validCode;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", validCode=" + validCode + "]";
	}
	
}
