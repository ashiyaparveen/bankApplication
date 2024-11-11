package user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class TransactionDbcalls {
	int CreateTransactions(String Type,String Date ,double TransAmount , 
			 long AccId ,double CurrentBalance ) {
		String query2 = "INSERT INTO Transactions (Acc_Id,dateosftrans,Type,trans_amt,acc_bal)  VALUES (?, ?, ?, ?, ?);";
		try {
			Connection con = new DBconnection().getConnect();
			PreparedStatement pst  = con.prepareStatement(query2);
			pst.setString(3, Type);
			pst.setString(2,Date);
			pst.setDouble(4,TransAmount);
			pst.setLong(1,AccId);
			pst.setDouble(5,CurrentBalance);
		
			int result = pst.executeUpdate();
			
			if(result != 0 ) {
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
	int CreateTransactions(String TransType,String Date ,double TransAmount ,long fromacc,int toacc, 
			 long AccId ,double CurrentBalance) {
		String query2 = "INSERT INTO Transactions (Type,dateosftrans,Trans_Amt,From_Acc,To_Acc,Acc_Id ,acc_bal)  VALUES (?, ?, ?, ?, ?, ?, ?);";
		try {
			Connection con = new DBconnection().getConnect();
			PreparedStatement pst  = con.prepareStatement(query2);
			pst.setString(1, TransType);
			pst.setString(2,Date);
			pst.setDouble(3,TransAmount);
			pst.setLong(4,fromacc);
			pst.setInt(5,toacc);
			pst.setLong(6,AccId);
			pst.setDouble(7,CurrentBalance);
			
			
			int result = pst.executeUpdate();
			
			if(result != 0 ) {
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
	ResultSet RetrieveHistory(long AccNo){
		String query2 = "SELECT * FROM Transactions WHERE acc_id = ? ;";
		try {
			Connection con = new DBconnection().getConnect();
			PreparedStatement pst  = con.prepareStatement(query2);
			pst.setLong(1, AccNo);
		
			ResultSet result = pst.executeQuery();
			
			if(result != null) {
				return result;
			}
			else {
				return null;
			}
		}catch(Exception e) {
				System.out.println("Exception occured : "+e);
			}
		return null;
	}
}