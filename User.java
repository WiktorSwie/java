import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class User {
	String Login;
	
	public User (String Login, String Password, int Role) {
		this.Login = Login;
		this.Password = Password;
		this.Role = Role;
	}

	public String getLogin() {
		return Login;
	}

	
	public void setLogin(String newLogin) {
		this.Login = newLogin;
	}
	

	public String getPassword() {
		return Password;
	}


	public void setPassword(String newPassword) {
		this.Password = newPassword;
	}

	public String Password;
	
	int Role;
	
	public int getRole() {
		return Role;
	}

	public void setRole(int Role) {
		this.Role = Role;
	}

}