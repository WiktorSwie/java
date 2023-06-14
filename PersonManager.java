package projekcik;
import java.util.ArrayList;
import java.util.List;

public class PersonManager {
	public List<User> Users;
	private UsersDataBase UsersDB;
	
	public PersonManager () {
		UsersDB = new UsersDataBase();
		Users = new ArrayList<User>();
	}
	
	public void addUser (User p) throws Exception {
		UsersDB.addUser(p);
		Users.add(p);
	}
	
	public Boolean removeUser (String Login) throws Exception {
		User tempUser = null;
		for (User p : Users)
			if (p.getLogin().equals(Login)) {
				tempUser = p;
				break;
			}
		if (tempUser != null) {
			removeUser(tempUser);
			return true;
		}
		else
			return false;
	}
	
	public void removeUser (User p) throws Exception {
		UsersDB.removeUser(p);
		Users.remove(p);
	}
	
	public  List<User> readUsers() throws Exception {
		this.Users = UsersDB.getUsers();
		return this.Users;
	}
	
	public List<User> getUsers() throws Exception {
		if (this.Users == null || this.Users.size() == 0)
			this.Users = UsersDB.getUsers();
		return this.Users;
	}
	
	public User getUser (String Login) {
		for (User p : Users)
			if (p.getLogin().equals(Login)) {
				return p;
			}
		return null;
	}
}
