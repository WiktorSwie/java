import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersDataBase {
	public void addUser(User NewUser) throws Exception {
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
	        	connection = DriverManager.getConnection("jdbc:sqlite:D:\\JAVA\\Db\\dbforproject.db");

	        	String sql = "INSERT INTO Users (Login, Password, Role) VALUES (?, ?, 0)";
	        	PreparedStatement statement = connection.prepareStatement(sql);

	        	statement.setString(1, NewUser.getLogin());
	        	statement.setString(2, NewUser.getPassword());

	        	statement.executeUpdate();

	        	statement.close();
	        
		}
	    	catch(SQLException e){
	    	 	System.err.println(e.getMessage());
	    	 	throw e;
	    	}
		catch (ClassNotFoundException e) {
			System.err.println(e.getMessage()); 
			throw e;
		}
	    	finally {         
			try {
				if(connection != null)
					connection.close();
			}
			catch(SQLException e) {          
				System.err.println(e); 
			}
	    }
	}
	
	public void removeUser (User prsn) throws Exception {
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
	        	connection = DriverManager.getConnection("jdbc:sqlite:D:\\JAVA\\Db\\dbforproject.db");

	        	Statement statement = connection.createStatement();
	        	statement.setQueryTimeout(30); 

	        	statement.executeUpdate("DELETE FROM Users WHERE login='"+ prsn.getLogin() + "'");
	        
		}
	    	catch(SQLException e){
	    	 	System.err.println(e.getMessage());
	    	 	throw e;
	    	}
		catch (ClassNotFoundException e) {
			System.err.println(e.getMessage()); 
			throw e;
		}
	    	finally {         
			try {
				if(connection != null)
					connection.close();
			}
			catch(SQLException e) {          
				System.err.println(e); 
			}
	    }
	}
	
	public List<User> getUsers () throws Exception {
		List<User> listOfUsers = new ArrayList<User>();

		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
	         	connection = DriverManager.getConnection("jdbc:sqlite:D:\\JAVA\\Db\\dbforproject.db");

	         	Statement statement = connection.createStatement();
	         	statement.setQueryTimeout(30); 

	         	ResultSet resultSet = statement.executeQuery("SELECT Login, Password,Role from Users");
	         	while(resultSet.next())
	         	{
	        	 	User newUser = new User(resultSet.getString("Login"), resultSet.getString("Password"),resultSet.getInt("Role"));
	        	 	listOfUsers.add (newUser);
	         	}
		}
	    	catch(SQLException e){
	    	 	System.err.println(e.getMessage()); 
	    	}       
	    	finally {         
			try {
				if(connection != null)
					connection.close();
			}
			catch(SQLException e) {        
				System.err.println(e); 
			}
	    	}
		
		return listOfUsers;
	}
}