package user;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author dukegodwinwilliams
 */
public class Transaction extends Account {
        public int fromAccountId;
        public int toAccountId;
        public int transactionId;
        public long transactionAccount;
        public String date;
        public String transactionType;
        
		public Transaction(int fromAccountId, int toAccountId, int transactionId, long accountNumber, String date,
				String transactionType) {
			this.fromAccountId = fromAccountId;
			this.toAccountId = toAccountId;
			this.transactionId = transactionId;
			this.transactionAccount = accountNumber;
			this.date = date;
			this.transactionType = transactionType;
		}
		public Transaction(){};
		public int getFromAccountId() {
			return fromAccountId;
		}
		public void setFromAccountId(int fromAccountId) {
			this.fromAccountId = fromAccountId;
		}
		public int getToAccountId() {
			return toAccountId;
		}
		public void setToAccountId(int toAccountId) {
			this.toAccountId = toAccountId;
		}
		public int getTransactionId() {
			return transactionId;
		}
		public void setTransactionId(int transactionId) {
			this.transactionId = transactionId;
		}
		public long getTransactionAccount() {
			return transactionAccount;
		}
		public void setTransactionAccount(long transactionAccount) {
			this.transactionAccount = transactionAccount;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getTransactionType() {
			return transactionType;
		}
		public void setTransactionType(String transactionType) {
			this.transactionType = transactionType;
		}
	
		public double CheckBalance(long accno) {
			UserDBCalls user = new UserDBCalls();
			return user.CurrentBalance(accno);
		}
		
		public double Deposite(Long accno, double amount) {
			UserDBCalls user = new UserDBCalls();
			double current_balance =  user.CurrentBalance(accno);
			current_balance += amount ;
			user.UpdateBalance(accno,current_balance);
			TransactionDbcalls trans = new TransactionDbcalls();
			int res = trans.CreateTransactions("deposite",LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),amount,accno,current_balance);
			return current_balance;
			
			
		}
		public double WithDraw(long accno, double amount) {
			UserDBCalls user = new UserDBCalls();
			double current_balance =  user.CurrentBalance(accno);
			if(current_balance < amount) {
				System.out.println("Insufficient Balance");
				return current_balance;
			}
			else {
				current_balance -= amount ;
			}
			
			user.UpdateBalance(accno,current_balance);
			TransactionDbcalls trans = new TransactionDbcalls();
			int res = trans.CreateTransactions("Withdraw",LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),amount,accno,current_balance);
			return current_balance;
			
		}
		public int transfer(long fromacc,int toacc,double trans_amount) {
			UserDBCalls user = new UserDBCalls();
			double current_balance =  user.CurrentBalance(fromacc);
			if(current_balance < trans_amount) {
				System.out.println("Insufficient Balance");
				return (int)current_balance;
			}
			else {
				current_balance -= trans_amount ;
			}
			
			user.UpdateBalance(fromacc,current_balance);
			TransactionDbcalls trans = new TransactionDbcalls();
			int res = trans.CreateTransactions("transfer",LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),trans_amount,fromacc,toacc,fromacc,current_balance);
		
			
			current_balance =  user.CurrentBalance(toacc);
			current_balance += trans_amount ;
			user.UpdateBalance(toacc,current_balance);
			trans = new TransactionDbcalls();
			res = trans.CreateTransactions("transfer",LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),trans_amount,fromacc,toacc,toacc,current_balance);
		
			
		
			
			return res;
		}
		public void ShowHistory(long AccNo) {
			TransactionDbcalls trans = new TransactionDbcalls ();
			try {
				ResultSet result = trans.RetrieveHistory(AccNo);
				while (result.next()) {
					
					int TransNo = result.getInt("trans_id");
					String TransType = result.getString("type");
					String Date = result.getString("Dateosftrans");
					double TransAmount = result.getDouble("trans_amt");
					int FromAcc = result.getInt("From_Acc");
					int ToAcc = result.getInt("To_Acc");
					int AccId = result.getInt("Acc_Id");
					double CurrentBalance = result.getDouble("acc_bal");
					 System.out.println("TransNo : " + TransNo + " TransType : " +TransType + " Date : " + Date + " TransAmount : "+TransAmount +" FromAcc : " + FromAcc + " ToAcc : "+ToAcc +" AccId : "+AccId+" CurrentBalance : " +CurrentBalance);
				}
			  } catch (Exception e) {
				
					System.out.println("Exception occured "+e);
				 }

	          
	        
		}
}