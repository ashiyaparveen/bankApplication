package user;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
	Connection con = null;
	
	String url="jdbc:mysql://localhost:3306/bank01";
	
	String userName="root";
	
	String password="ashicse@2023";

	public Connection getConnect()
   {
	   if(con==null) {
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,userName,password);
		System.out.println("Connection Established successfully");
	}catch(Exception e) {
		System.out.println("Exception Occurred"+e);
	}
		
	}
   return con;
   }

   public static void main(String[]args) {
	   DBconnection connect = new DBconnection();
	   Connection con = connect.getConnect();
   }
}
