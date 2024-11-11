package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserDBCalls {
	int checkUserLogin(String username,String password) {
		String query = "SELECT * FROM Account WHERE UserName = ? and Password= ? ;";
		try {
			Connection con = new DBconnection().getConnect();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,username);
			pst.setString(2, password);
			ResultSet res = pst.executeQuery();
			if(res.next()) {
				return res.getInt("acc_id");
			}
			else {
				return 0;
			}
		}catch(Exception e) {
			System.out.println("Exception occured : "+e);
		}
		return 0;
	}
	public double CurrentBalance(long accNo) {
		String query = "SELECT * FROM Account WHERE  acc_id = ? ;";
		try {
			Connection con = new DBconnection().getConnect();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setLong(1,accNo);
			ResultSet res = pst.executeQuery();
			if(res.next()) {
				return res.getDouble("balance");
			}
			else {
				return 0;
			}
		}catch(Exception e) {
			System.out.println("Exception occured : "+e);
		}
		return 0;
	}
	
	public int UpdateBalance(long accNo,double amount){
		String query = "UPDATE Account SET balance = ? WHERE acc_id = ?;";
		try {
			Connection con = new DBconnection().getConnect();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setLong(2,accNo);
			pst.setDouble(1, amount);
			int result = pst.executeUpdate();
			
			if(result != 0 ) {
				System.out.println("Balance Updated");
				return result;
			}
			else {
				return 0;
			}
		}catch(Exception e) {
			System.out.println("Exception occured : "+e);
		}
		return 0;
	}
}