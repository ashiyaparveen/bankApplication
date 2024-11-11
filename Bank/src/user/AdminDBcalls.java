package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDBcalls{
	
	 public int checkLogin(String userName, String password) {
		String query="select * from admin where username = ? and password = ?";
		try(Connection con=new DBconnection().getConnect();
				PreparedStatement pst=con.prepareStatement(query)){
			
			pst.setString(1,userName);
			pst.setString(2,password);
			ResultSet res=pst.executeQuery();
			if(res.next()) {
				return res.getInt("admin_id");
				
			} else {
				return 0;
			}
		} catch(Exception e ) {
			System.out.println("Error occurred in getting the admin " + e);
		}
		return 0;
	}

	public int CreateAccount(long accountNumber, String userName, String accountType, double balance, String password,
			long phoneNumber, String address, String branchName) {
		// TODO Auto-generated method stub
		return 0;
	}
}
