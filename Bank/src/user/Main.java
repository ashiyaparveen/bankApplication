package user;
import java.util.*;
import java.util.ArrayList;
import java.util.*;
import java.util.ArrayList;

public class Main {
   public static void main(String[] args) {
	   Scanner sc=new Scanner(System.in);
	   HashMap<String,Account>details=new HashMap<>();
	   HashMap<String,Admin>Admin_details=new HashMap<>();
	   HashMap<String,ArrayList<Transaction>>TransactionDetails=new HashMap<>();
	   //details.put("ASHIYA", new Account(101,"ASHIY","Savings",120000.0,"123456",9045457521L,"123 Main street","CBE"));
	   Admin_details.put("Admin", new Admin(102,"Admin","12345"));
	   Admin Ad_account=null;
	   int Admin_acc = 0;
	   Account account=null;
	   long result = 0;
       boolean flag=true;	   
	   while(flag) {
		   System.out.println("1.Login\n2.Check Balance\n3.Deposit\n4.Withdraw\n5.Transfer\n6.History\n7.Logout");
				                 
		   int eventType=sc.nextInt();
           if(account==null && eventType>1) {
        	   System.out.println("User not logged in");
        	   continue;
           }
           else {
        	   switch(eventType) {
        	   case 1:
        		   System.out.println("Login (Admin/User) :");
        		   String ch=sc.next();
        		   if(ch.equals("User")) {
        			   if(account==null) {
                		   System.out.println("Enter Username :");
                		   String userName=sc.next();
                		   System.out.println("Enter Password :");
                		   String password=sc.next();
                		   //account=checkAccountExist(userName,password,details);
                		   account = new Account();
                		   result = account.Userlogin(userName,password);
                		   if(result != 0) {
                 		   System.out.println("User has been logged in with Account no "+result);
            
                 		   //TransactionDetails.put(account.userName, new ArrayList<Transaction>());
                		   }
                		   else {
                			   System.out.println("Account Does not exists . Please Create a Account");
                		   }
                		   }
                		   else {
                			   System.out.println("User is already logged in");
                		   }
        		   }
        		   else {
        			   if(Ad_account==null) {
        				   Admin ac = new Admin();
                		   System.out.println("Enter Admin Name :");
                		   String AdminName=sc.next();
                		   System.out.println("Enter Password :");
                		   String password=sc.next();
                		   Admin_acc=ac.login(AdminName,password);
    
                		   if(Admin_acc!=0) {
	                 		   System.out.println("Admin has been logged in with Account no "+Admin_acc);
	//                 		   TransactionDetails.put(account.userName, new ArrayList<Transaction>());
	                 		   
	                 		   boolean flag1=true;
	                 		   while(flag1) {
	                 			   System.out.println("1.Create Account\n2.ViewAllAccounts\n3.Logout");
	                 			    int option=sc.nextInt();
	                 			    switch(option) {
	                 			          case 1:
			                 			    	int accountNo;
			                 			    	System.out.println("Enter Account no: ");
			                 			    	accountNo=sc.nextInt();
			                 			   	    String username;
			                 			   	    System.out.println("Enter User Name: ");
			                 			   	    username=sc.next();
			                 			        String accounttype;
			                 			        System.out.println("Enter Account Type: ");
			                			   	    accounttype=sc.next();
			                 			        double balance;
			                 			        System.out.println("Enter initail balance: ");
			               			   	        balance=sc.nextDouble();
			                 			        String pw;
			                 			        System.out.println("Enter Password: ");
			               			   	        pw=sc.next();
			                 			        long phoneNo;
			                 			        System.out.println("Enter Phone Number: ");
			              			   	        phoneNo=sc.nextLong();
			                 			        String addrs;
			                 			        System.out.println("Enter Address: ");
			              			   	        addrs=sc.next();
			
			                 			        String branchname;
			                 			        System.out.println("Enter branch Name: ");
			              			   	        branchname=sc.next();
			              			   	        
			              			   	        Account acc2 = new Account(); 
			              			   	        int res = acc2.Create(accountNo,username,accounttype,balance,pw,phoneNo,addrs,branchname);
			              			   	        if(res == 1) {
			              			   	    	   System.out.println("Account Created Successfully");
			              			   	       }
			              			   	       else {
			              			   	    	  System.out.println("Account Already Exists");
			              			   	       }
			              			   	       break;
			                 			    case 2:
			                 			    	Admin ad = new Admin();
			                 			    	ad.viewAllAccounts(details);
			                 			    	break;
			                 			    case 3:
			                 			    	System.out.println("Logging Out...");
			                 			    	flag1 = false;
			                 			    	break;
			                 			    default:
			                 			    	System.out.println("Invalid choice");
			
			                 		  }
			               		   }
			                   }
			                  else {
			                	 account=null;
			                   }
			                }
			                else {
			                	System.out.println("Admin is already logged in");
			                }
			      }
        		   
        		  break;
        	   case 2:
        		   Transaction tasc = new Transaction();
      		       double currentBalance = tasc.CheckBalance(result);
        		   
        		   System.out.println("Your Account Balance is : "+currentBalance);
        		   break;
        	   case 3:
        		     System.out.println("Enter deposit amount : ");
        		     double deposit_amount=sc.nextDouble();
        		     Transaction tac = new Transaction();
        		     double balance = tac.Deposite(result,deposit_amount);
        		     System.out.println("Balance after deposite: "+balance);
        		     /*if(deposit_amount>0) {
        		    	 int fromAcountId=123;
        		    	 int TransactionId=4567;
;        		    	 double bal=account.balance+deposit_amount;
        		    	 account.balance=bal;
        		    	 System.out.println("Deposit is completed ..your initail amount is : "+account.balance);
        		    	 ArrayList<Transaction> prevTrans=TransactionDetails.get(account.getUserName());
        		    	 prevTrans.add(new Transaction(fromAcountId,101,TransactionId++,account.accountNumber,"12-nov-2023","deposit"));
        		    	 TransactionDetails.put(account.userName,prevTrans);
        		    	 details.put(account.getUserName(),account);
        		     }*/
        		     break;
        	   case 4:
        		   System.out.println("Enter the Withdraw amount : ");
        		   double withdrawAmt=sc.nextDouble();
        		   /*if(account.getBalance()>=withdrawAmt) {
        			   System.out.println("Enter the to Account id : ");
      		    	   int toAccountId=sc.nextInt();
      		    	   int fromAcountId=123;
      		    	   int TransactionId=4567;
        			   Transaction transactions=new Transaction();
        			   double bal=account.balance-withdrawAmt;
      		    	   account.balance=bal;
      		    	   ArrayList<Transaction> prevTrans=TransactionDetails.get(account.getUserName());
      		    	   prevTrans.add(new Transaction(fromAcountId,toAccountId,TransactionId++,account.accountNumber,"12-nov-2023","deposit"));
 
      		    	   TransactionDetails.put(account.userName,prevTrans);
      		    	   details.put(account.getUserName(),account);
        		   }
        		   else {
      		    	 System.out.println("Your balance is less than your Withdraw amount !!");
      		     }*/
        		  Transaction tac1 = new Transaction();
      		     double withdraw_balance = tac1.WithDraw(result,withdrawAmt);
      		     System.out.println("Current Balance : "+withdraw_balance);
      		     break;
        	   case 5:
        		   System.out.println("Enter amount to transfer :");
        		   double trans_amount = sc.nextInt();
        		   System.out.println("Enter account Number to transfer :");
        		   int trans_acc = sc.nextInt();
        		   Transaction tac2 = new Transaction();
        		   int res2 = tac2.transfer(result,trans_acc,trans_amount);
        		   if(res2 != 0) {
        			   System.out.println("Transaction successful");
        		   }
        		   else {
        			   System.out.println("Transaction Failed");
        		   }
        		   break;
        	   case 6:
        		   Transaction tac3 = new Transaction();
        		   tac3.ShowHistory(result);
        		   break;
        	   case 7:
        		   System.out.println("User has been logged out");
        		   //account=null;
        		   flag=false;
        		   break;
        		   
        	   }
        	   
           }
	   }
	   
	   
   }
   public static Account checkAccountExist(String username,String password,HashMap<String,Account>accounts) {
	   if(accounts.getOrDefault(username, null)!=null) {
		   Account acc=accounts.get(username);
		   if(acc.password.equals(password) && acc.userName.equals(username)) {
			   return acc;
		   }
		   else {
			    return new Account();
		   }
		   
	   }
	   else {
		   return new Account();
	   }
   }
   public static Admin checkAccountExist_admin(String username,String password,HashMap<String,Admin>Admin_details) {
	   if(Admin_details.getOrDefault(username, null)!=null) {
		   Admin acc1=Admin_details.get(username);
		   if(acc1.password.equals(password) && acc1.userName.equals(username)) {
			   return acc1;
		   }
		   else {
			    return new Admin();
		   }
		   
	   }
	   else {
		   return new Admin();
	   }
   }
}