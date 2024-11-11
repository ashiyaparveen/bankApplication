package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Scanner;

public class Admin {
	public int id;
	public String username;
	public String password;
	public Object userName;

    public Admin() {}
  
    public Admin(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

  
    public int adminLogin(String userName, String password) {

    	AdminDBcalls admindbcalls=new AdminDBcalls();
    	return admindbcalls.checkLogin(userName,password);
    }

	public static boolean adminLogin1(Scanner scanner) {
		// TODO Auto-generated method stub
		return false;
	}


public int login(String username, String password) {
	AdminDBcalls admindbcalls=new AdminDBcalls();
	return admindbcalls.checkLogin(username,password);
	
    }

public void viewAllAccounts(HashMap<String, Account> details) {
	// TODO Auto-generated method stub
	
}
    }