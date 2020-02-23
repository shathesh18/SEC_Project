
public class Student {

	String userName;
	String passWord;
	String email;
	boolean paused;
	public Student(String userName, String passWord, String email) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.paused=false;
		
		
	}
	@Override
	public String toString() {
		return "Student [userName=" + userName + ", passWord=" + passWord + ", email=" + email + ", paused=" + paused
				+ "]";
	}
	
	
}
