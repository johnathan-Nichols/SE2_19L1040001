package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connect.DBConnect;
import model.Admin;
import model.CheckingAccount;
import model.Customer;
import model.DBEdits;
import model.LoanAccount;
import model.SavingsAccount;
import model.TransactionHistory;
import model.User;

/**	
 * This is a DAO (DATA ACCESS OBJECT) class which provides 
 * CRUD (CREATE - READ - UPDATE - DELETE) database operations 
 * for the table user in the database
 */
public class UserDAO {
//Add Limit start, number to SQL SELECT * FROM `members` LIMIT 1, 2;
	/**
	 *Creates a UserDAO object to allow the use of inner classes for retrieving data from the server 
	 */
	public UserDAO() {
	}
	
	public int getLast(String table) {
		try {
			return Integer.parseInt(queryString("SELECT id FROM "+table+" ORDER BY id DESC LIMIT 0,1;", "id"));
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 *Returns all users with full data available 
	 */
	public List<User> selectAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			ResultSet rs = queryRRS("SELECT * FROM user");
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String lastName = rs.getString("lastName");
				String middleName = rs.getString("middleName"); 
				String firstName = rs.getString("firstName");  
				Date dob = rs.getDate("dob"); 
				char idType = rs.getString("idType").charAt(0);
				String idCode = rs.getString("idCode"); 
				String loginName = rs.getString("loginName");
				String loginPassword = rs.getString("loginPassword");
				boolean validUser = rs.getBoolean("validUser");
				boolean activatedUser = rs.getBoolean("activatedUser");
				Date activationDate = rs.getDate("activationDate"); 			
				char userType = rs.getString("userType").charAt(0);	
				String securityQuestion = rs.getString("securityQuestion");
				String securityAnswer = rs.getString("securityAnswer");		
				users.add(new User(id, lastName, middleName, firstName, dob, idType, idCode, loginName, loginPassword, validUser, activatedUser, activationDate, userType, securityQuestion, securityAnswer));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	/**
	 *Returns all users with full data available 
	 */
	public List<User> selectAllUsers(int limit) {
		List<User> users = new ArrayList<User>();
		
		int max = getLast("user");
		int start = 0;
		
		try {
			while(users.size() < limit && !(start > max)) {
				ResultSet rs = queryRRS("SELECT * FROM user LIMIT "+start+", "+limit+";");
				
				while (rs.next()) {
					int id = rs.getInt("id");
					String lastName = rs.getString("lastName");
					String middleName = rs.getString("middleName"); 
					String firstName = rs.getString("firstName");  
					Date dob = rs.getDate("dob"); 
					char idType = rs.getString("idType").charAt(0);
					String idCode = rs.getString("idCode"); 
					String loginName = rs.getString("loginName");
					String loginPassword = rs.getString("loginPassword");
					boolean validUser = rs.getBoolean("validUser");
					boolean activatedUser = rs.getBoolean("activatedUser");
					Date activationDate = rs.getDate("activationDate"); 			
					char userType = rs.getString("userType").charAt(0);	
					String securityQuestion = rs.getString("securityQuestion");
					String securityAnswer = rs.getString("securityAnswer");		
					users.add(new User(id, lastName, middleName, firstName, dob, idType, idCode, loginName, loginPassword, validUser, activatedUser, activationDate, userType, securityQuestion, securityAnswer));
				}	
				start += limit;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	/**
	 *Selects the last user found with a specific id number 
	 *	-As this is the primary key there should never be more than 1 user with the same id number 
	 */
	public User selectUserByID(int user_id) {
		User user = new User();
		try {
			ResultSet rs = queryRRS("SELECT * FROM user WHERE id = " + user_id);
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String lastName = rs.getString("lastName");
				String middleName = rs.getString("middleName"); 
				String firstName = rs.getString("firstName");  
				Date dob = rs.getDate("dob"); 
				char idType = rs.getString("idType").charAt(0);
				String idCode = rs.getString("idCode"); 
				String loginName = rs.getString("loginName");
				String loginPassword = rs.getString("loginPassword");
				boolean validUser = rs.getBoolean("validUser");
				boolean activatedUser = rs.getBoolean("activatedUser");
				Date activationDate = rs.getDate("activationDate"); 	
				char userType = rs.getString("userType").charAt(0);		
				String securityQuestion = rs.getString("securityQuestion");
				String securityAnswer = rs.getString("securityAnswer");	
				user = new User(id, lastName, middleName, firstName, dob, idType, idCode, loginName, loginPassword, validUser, activatedUser, activationDate, userType, securityQuestion, securityAnswer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 *Grabs all of the Admins with full data including user data
	 *	-leaves out the duplicate user ID number 
	 */
	public List<Admin> selectAllAdmins() {

		List<Admin> admins = new ArrayList<>();
		try {
			ResultSet rs = queryRRS("SELECT * FROM admin");
			
			while (rs.next()) {
				int id = rs.getInt("id");
				int userID = rs.getInt("user_id");
				User user = selectUserByID(userID);
				admins.add(new Admin(id, user));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admins;
	}

	/**
	 *Grabs all of the Admins with full data including user data
	 *	-leaves out the duplicate user ID number 
	 */
	public List<Admin> selectAllAdmins(int limit) {
		List<Admin> admins = new ArrayList<>();
		
		int max = getLast("admin");
		int start = 0;
		
		try {
			while(admins.size() < limit && !(start > max)) {
				ResultSet rs = queryRRS("SELECT * FROM admin LIMIT "+start+", "+limit+";");
				
				while (rs.next()) {
					int id = rs.getInt("id");
					int userID = rs.getInt("user_id");
					User user = selectUserByID(userID);
					admins.add(new Admin(id, user));
				}
				start += limit;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admins;
	}
		
	/**
	 *Grabs all of the Customers with full data including user data
	 *	-leaves out the duplicate user ID number 
	 */
	public List<Customer> selectAllCustomers() {

		List<Customer> customers = new ArrayList<>();
		try {
			ResultSet rs = queryRRS("SELECT * FROM customer");
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String positionInCompany = rs.getString("positionInCompany");
				String employer = rs.getString("employer");
				String nationality = rs.getString("nationality");
				String houseNumber = rs.getString("houseNumber");
				String streetName = rs.getString("streetName");
				String cityName = rs.getString("cityName");
				String stateName = rs.getString("stateName");
				String countryName = rs.getString("countryName");
				int postalCode = rs.getInt("postalCode");
				int userID = rs.getInt("user_id");
				User user = selectUserByID(userID);
				customers.add(new Customer(id, user, positionInCompany, employer, nationality, houseNumber, streetName, cityName, stateName, countryName, postalCode));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customers;
	}
	
	/**
	 *Grabs all of the Customers with full data including user data
	 *	-leaves out the duplicate user ID number 
	 */
	public List<Customer> selectAllCustomers(int limit) {
		List<Customer> customers = new ArrayList<>();
		
		int max = getLast("customer");
		int start = 0;
		
		try {
			while(customers.size() < limit && !(start > max)) {
				ResultSet rs = queryRRS("SELECT * FROM customer LIMIT "+start+","+limit+";");
				
				while (rs.next()) {
					int id = rs.getInt("id");
					String positionInCompany = rs.getString("positionInCompany");
					String employer = rs.getString("employer");
					String nationality = rs.getString("nationality");
					String houseNumber = rs.getString("houseNumber");
					String streetName = rs.getString("streetName");
					String cityName = rs.getString("cityName");
					String stateName = rs.getString("stateName");
					String countryName = rs.getString("countryName");
					int postalCode = rs.getInt("postalCode");
					int userID = rs.getInt("user_id");
					User user = selectUserByID(userID);
					customers.add(new Customer(id, user, positionInCompany, employer, nationality, houseNumber, streetName, cityName, stateName, countryName, postalCode));
				}
				start += limit;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customers;
	}
	
	public List<CheckingAccount> selectAllChecking(){
		List<CheckingAccount> accounts = new ArrayList<>();
		try {
			ResultSet rs = queryRRS("Select * FROM checkingAccount;");
			
			while(rs.next()) {
				int accountID = rs.getInt("id");
				int custID = rs.getInt("customer_id");
				double accountBalance = rs.getDouble("accountBalance");
				Date creationDate = rs.getDate("creationDate");
				boolean valid = rs.getBoolean("validAccount");
				boolean active = rs.getBoolean("activatedAccount");
				Customer cust = new Customer();
				cust.setId(custID);
				accounts.add(new CheckingAccount(accountID, cust, creationDate, accountBalance,  false, valid, active));
			}
		}catch(Exception e) {
			System.out.println("Error grabbing checking");
			e.printStackTrace();
		}
		return accounts;
	}
	
	public List<CheckingAccount> selectAllChecking(int limit){
		List<CheckingAccount> accounts = new ArrayList<>();
		
		int max = getLast("checkingAccount");
		int start = 0;
		try {
			while(accounts.size() < limit && !(start > max)) {
				ResultSet rs = queryRRS("Select * FROM checkingAccount LIMIT "+start+","+limit+";");
				
				while(rs.next()) {
					int accountID = rs.getInt("id");
					int custID = rs.getInt("customer_id");
					double accountBalance = rs.getDouble("accountBalance");
					Date creationDate = rs.getDate("creationDate");
					boolean valid = rs.getBoolean("validAccount");
					boolean active = rs.getBoolean("activatedAccount");
					Customer cust = new Customer();
					cust.setId(custID);
					accounts.add(new CheckingAccount(accountID, cust, creationDate, accountBalance,  false, valid, active));
				}	
				start += limit;
			}
		}catch(Exception e) {
			System.out.println("Error grabbing checking");
			e.printStackTrace();
		}
		return accounts;
	}
	
	public List<SavingsAccount> selectAllSavings(){
		List<SavingsAccount> accounts = new ArrayList<>();
		try {
			ResultSet rs = queryRRS("Select * FROM savingsAccount;");
			
			while(rs.next()) {
				int accountID = rs.getInt("id");
				int custID = rs.getInt("customer_id");
				double increasePercentage = rs.getDouble("increasePercentage");
				int increaseRate = rs.getInt("increaseRate");
				Date lastIncrease = rs.getDate("lastIncrease");
				Date creationDate = rs.getDate("creationDate");
				double accountBalance = rs.getDouble("accountBalance");
				boolean valid = rs.getBoolean("validAccount");
				boolean active = rs.getBoolean("activatedAccount");
				Customer cust = new Customer();
				cust.setId(custID);
				accounts.add(new SavingsAccount(accountID, cust, increasePercentage, increaseRate, lastIncrease, creationDate, accountBalance,  false, valid, active));
			}
		}catch(Exception e) {
			System.out.println("Error grabbing checking");
			e.printStackTrace();
		}
		return accounts;
	}
	
	public List<SavingsAccount> selectAllSavings(int limit){
		List<SavingsAccount> accounts = new ArrayList<>();
		
		int max = getLast("savingsAccount");
		int start = 0;
		
		try {
			while(accounts.size() < limit && !(start > max)) {
				ResultSet rs = queryRRS("Select * FROM savingsAccount LIMIT "+start+","+limit+";");
				
				while(rs.next()) {
					int accountID = rs.getInt("id");
					int custID = rs.getInt("customer_id");
					double increasePercentage = rs.getDouble("increasePercentage");
					int increaseRate = rs.getInt("increaseRate");
					Date lastIncrease = rs.getDate("lastIncrease");
					Date creationDate = rs.getDate("creationDate");
					double accountBalance = rs.getDouble("accountBalance");
					boolean valid = rs.getBoolean("validAccount");
					boolean active = rs.getBoolean("activatedAccount");
					Customer cust = new Customer();
					cust.setId(custID);
					accounts.add(new SavingsAccount(accountID, cust, increasePercentage, increaseRate, lastIncrease, creationDate, accountBalance,  false, valid, active));
				}	
				start += limit;
			}
		}catch(Exception e) {
			System.out.println("Error grabbing checking");
			e.printStackTrace();
		}
		return accounts;
	}
	
	public List<LoanAccount> selectAllLoan(){
		List<LoanAccount> accounts = new ArrayList<>();
		try {
			ResultSet rs = queryRRS("Select * FROM loanAccount;");
			
			while(rs.next()) {
				int accountID = rs.getInt("id");
				int custID = rs.getInt("customer_id");
				double increaseRate = rs.getDouble("increaseRate");
				int increaseInterval = rs.getInt("increaseInterval");
				double latePaymentPenalty = rs.getDouble("latePaymentPenalty");
				double intervalRequiredPayment = rs.getDouble("intervalRequiredPayment");
				double currentIntervalPaymentReceived = rs.getDouble("currentIntervalPaymentReceived");
				Date lastIntervalDate = rs.getDate("lastIntervalDate");
				double accountBalance = rs.getDouble("accountBalance");
				Date creationDate = rs.getDate("creationDate");
				double owedAmount = rs.getDouble("owedAmount");
				boolean valid = rs.getBoolean("validAccount");
				boolean active = rs.getBoolean("activatedAccount");
				Customer cust = new Customer();
				cust.setId(custID);
				accounts.add(new LoanAccount(accountID, cust, increaseRate, increaseInterval, latePaymentPenalty, intervalRequiredPayment, currentIntervalPaymentReceived, lastIntervalDate, creationDate, accountBalance, owedAmount, false, valid, active));
			}
		}catch(Exception e) {
			System.out.println("Error grabbing checking");
			e.printStackTrace();
		}
		return accounts;
	}
	
	public List<LoanAccount> selectAllLoan(int limit){
		List<LoanAccount> accounts = new ArrayList<>();
		
		int max = getLast("loanAccount");
		int start = 0;
		
		try {
			while(accounts.size() < limit && !(start > max)) {
				ResultSet rs = queryRRS("Select * FROM loanAccount LIMIT "+start+","+limit+";");
				
				while(rs.next()) {
					int accountID = rs.getInt("id");
					int custID = rs.getInt("customer_id");
					double increaseRate = rs.getDouble("increaseRate");
					int increaseInterval = rs.getInt("increaseInterval");
					double latePaymentPenalty = rs.getDouble("latePaymentPenalty");
					double intervalRequiredPayment = rs.getDouble("intervalRequiredPayment");
					double currentIntervalPaymentReceived = rs.getDouble("currentIntervalPaymentReceived");
					Date lastIntervalDate = rs.getDate("lastIntervalDate");
					double accountBalance = rs.getDouble("accountBalance");
					Date creationDate = rs.getDate("creationDate");
					double owedAmount = rs.getDouble("owedAmount");
					boolean valid = rs.getBoolean("validAccount");
					boolean active = rs.getBoolean("activatedAccount");
					Customer cust = new Customer();
					cust.setId(custID);
					accounts.add(new LoanAccount(accountID, cust, increaseRate, increaseInterval, latePaymentPenalty, intervalRequiredPayment, currentIntervalPaymentReceived, lastIntervalDate, creationDate, accountBalance, owedAmount, false, valid, active));
				}	
				start += limit;
			}
		}catch(Exception e) {
			System.out.println("Error grabbing checking");
			e.printStackTrace();
		}
		return accounts;
	}
	
	/**
	 * Checks for user in database, if found, returns false, if not found, returns true
	 * @param loginName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyUser(String loginName) {
		String query = "SELECT id FROM user WHERE loginName = \"" + loginName + "\";";
		try {
			ResultSet rs = queryRRS(query);
			return rs.next();	
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Checks for user in database, if found, returns false, if not found, returns true
	 * @param loginName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyUser(int userID){
		String query = "SELECT id FROM user WHERE id = \"" + userID + "\";";
		try {
			ResultSet rs = queryRRS(query);
			return rs.next();	
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Checks for customer in database, if found, returns false, if not found, returns true
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public boolean addCustomer(HttpServletRequest request, HttpServletResponse response) {
		//First, add User
		if(!addUser(request, response, false)) {
			return false;
		}
		
		//Second, build Customer input data
		String userID = "";
		try {
			userID = queryString(("SELECT id from user WHERE loginName = \"" + request.getParameter("Login Name") + "\";"), "id");
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		String input = "insert into customer (user_id, positionInCompany, employer, nationality, houseNumber, streetName, cityName, stateName, countryName, postalCode)"
				+ "values(" + userID + ","
				+ "    \"" + request.getParameter("positionInCompany") + "\","
				+ "    \"" + request.getParameter("employer") + "\","
				+ "    \"" + request.getParameter("nationality") + "\","
				+ "    \"" + request.getParameter("houseNumber") + "\","
				+ "    \"" + request.getParameter("streetName") + "\","
				+ "    \"" + request.getParameter("cityName") + "\","
				+ "    \"" + request.getParameter("stateName") + "\","
				+ "    \"" + request.getParameter("countryName") + "\","
				+  request.getParameter("postalCode") + ");";
		System.out.println(input);
		queryExecute(input);
				//+ "select * from customer inner join user on customer.user_id = user.id;");
		
		String query = "SELECT * FROM customer INNER JOIN user ON customer.user_id = user.id WHERE customer.user_id = " + userID + ";";
		try {
			ResultSet rs = queryRRS(query);
			return rs.next();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}	
	
	/**
	 * Checks for admin in database, if found, returns false, if not found, returns true
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public boolean addAdmin(HttpServletRequest request, HttpServletResponse response) {
		//First, add User
		if(!addUser(request, response, true)) {
			return false;
		}
		
		//Second, build Admin input data
		String userID = "";
		try {
			userID = queryString(("SELECT id from user WHERE loginName = \"" + request.getParameter("Login Name") + "\";"), "id");
			queryReturn("insert into admin (user_id) values (" + userID + ");");
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		String query = "SELECT * FROM admin INNER JOIN user ON admin.user_id = user.id WHERE user_id = " + userID + ";";
		return queryExecute(query);
	}

	/**
	 * Checks for user in database, if found, returns false, if not found, returns true
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public boolean addUser(HttpServletRequest request, HttpServletResponse response, boolean isAdmin){
		String loginName = request.getParameter("Login Name");
		String loginPassword = request.getParameter("Login Password");
		String firstName = request.getParameter("First Name");
		String middleName = request.getParameter("Middle Name");
		String lastName = request.getParameter("Last Name");
		String idType = request.getParameter("Identification Type");
		String idCode = request.getParameter("Identification Code");
		String dob = request.getParameter("Date Of Birth");
		char userType = isAdmin ? 'A' : 'C';

		//check if user exists already
		if(verifyUser(loginName)) {
			return false;
		}
		
		String query = "INSERT INTO user(lastName, middleName, firstName, dob, idType, idCode, loginName, loginPassword, userType)\r\n"
				+ "VALUES ("
				+ "\"" + lastName + "\","
				+ "\"" + middleName + "\","
				+ "\"" + firstName + "\","
				+ "\"" + dob + "\","
				+ "\"" + idType + "\","
				+ "\"" + idCode + "\","
				+ "\"" + loginName + "\","
				+ "\"" + loginPassword + "\","
				+ "\"" + userType + "\""
				+ ");";
		queryExecute(query);
		
		//Check if user is real now
		return verifyUser(loginName);
	}

	public boolean verifyCustomerID(int id) {
		try {
			ResultSet rs = queryRRS("select * from customer where id = "+id+";");
			if(rs.next()) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void addCheckingAccount(CheckingAccount checkingAccount, int customer_id) {
		if(!verifyCustomerID(customer_id)) {
			return;
		}
		
		String query = "Insert Into checkingAccount (customer_id, accountBalance, validAccount, activatedAccount)"
				+ " VALUES ("
				+ "\"" + customer_id + "\","
				+ "\"" + checkingAccount.getAccountBalance() + "\","
				+ "" + checkingAccount.isValidAccount() + ","
				+ "" + checkingAccount.isActivatedAccount() + ""
				+ ");";
		queryExecute(query);
	}

	public void addSavingsAccount(SavingsAccount savingsAccount, int customer_id) {
		if(!verifyCustomerID(customer_id)) {
			return;
		}
		
		String query = "Insert Into savingsAccount (customer_id, increasePercentage, increaseRate, allowedWithdrawInterval, intervalStartDate, earlyWithdawPenalty, accountBalance, validAccount, activatedAccount) "
				+ "VALUES ("
				+ "\"" + customer_id + "\","
				+ "\"" + savingsAccount.getIncreasePercentage() + "\","
				+ "\"" + savingsAccount.getIncreaseRate() + "\","
				+ "\"" + savingsAccount.getAccountBalance() + "\","
				+ "" + savingsAccount.isValidAccount() + ","
				+ "" + savingsAccount.isActivatedAccount() + ""
				+ ");";
		queryExecute(query);
	}

	public void addLoanAccount(LoanAccount loanAccount, int customer_id) {
		if(!verifyCustomerID(customer_id)) {
			return;
		}
		
		String query = "Insert Into loanaccount (customer_id, increaseRate, increaseInterval, latePaymentPenalty, intervalRequiredPayment, currentIntervalPaymentReceived, owedAmount, accountBalance, validAccount, activatedAccount)"
				+ "VALUES ("
				+ "\"" + customer_id + "\","
				+ "\"" + loanAccount.getIncreaseRate() + "\","
				+ "\"" + loanAccount.getIncreaseInterval() + "\","
				+ "\"" + loanAccount.getLatePaymentPenalty() + "\","
				+ "\"" + loanAccount.getIntervalRequiredPayment() + "\","
				+ "\"" + loanAccount.getCurrentIntervalPaymentReceived() + "\","
				+ "\"" + loanAccount.getAccountBalance() + "\","
				+ "\"" + loanAccount.getAccountBalance() + "\","
				+ loanAccount.isValidAccount() + ","
				+ loanAccount.isActivatedAccount()
				+ ");";
		queryExecute(query);
	}
	
	public List<TransactionHistory> getHistory(int accountId, char accountType){
		boolean hasAccount = false;
		
		switch(accountType) {
			case 's':
				hasAccount = queryExecute("SELECT id FROM savingsAccount WHERE id="+accountId+";");
				break;
			case 'c':
				hasAccount = queryExecute("SELECT id FROM checkingAccount WHERE id="+accountId+";");
				break;
			case 'l':
				hasAccount = queryExecute("SELECT id FROM loanAccount WHERE id="+accountId+";");
				break;
			default:
				return null;
		}
		
		if(hasAccount) {
			List<TransactionHistory> edits = new ArrayList<TransactionHistory>();

			try {
				ResultSet rs = queryRRS("SELECT * FROM transactionHistory WHERE account_id="+accountId+" AND accountType=\""+accountType+"\";");
				
				while (rs.next()) {
					int id = rs.getInt("id");
					int accID = rs.getInt("account_id");
					char accType = rs.getString("acountType").charAt(0);
					Date transDate = rs.getDate("transactionDate");
					double amount = rs.getDouble("amount");
					int recID = rs.getInt("receiving_id");
					char recType = rs.getString("receivingType").charAt(0);					
					
					edits.add(new TransactionHistory(id, accID, accType, transDate, amount, recID, recType));
				}	
				
				return edits;
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}else {
			System.out.println("Could not find the account accountId="+accountId+" accountType=\""+accountType+"\"");
			return null;
		}
	}
	
	public List<TransactionHistory> getHistory(int accountId, char accountType, int limit){
		boolean hasAccount = false;
		
		switch(accountType) {
			case 's':
				hasAccount = queryExecute("SELECT id FROM savingsAccount WHERE id="+accountId+";");
				break;
			case 'c':
				hasAccount = queryExecute("SELECT id FROM checkingAccount WHERE id="+accountId+";");
				break;
			case 'l':
				hasAccount = queryExecute("SELECT id FROM loanAccount WHERE id="+accountId+";");
				break;
			default:
				return null;
		}
		
		if(hasAccount) {
			List<TransactionHistory> edits = new ArrayList<TransactionHistory>();
			
			int max = getLast("transactionHistory WHERE account_id="+accountId+" AND accountType=\""+accountType+"\"");
			int start = 0;

			try {
				while(edits.size() < limit && !(start > max)) {
					ResultSet rs = queryRRS("SELECT * FROM transactionHistory WHERE account_id="+accountId+" AND accountType=\""+accountType+"\" LIMIT "+start+","+limit+";");
					
					while (rs.next()) {
						int id = rs.getInt("id");
						int accID = rs.getInt("account_id");
						char accType = rs.getString("acountType").charAt(0);
						Date transDate = rs.getDate("transactionDate");
						double amount = rs.getDouble("amount");
						int recID = rs.getInt("receiving_id");
						char recType = rs.getString("receivingType").charAt(0);					
						
						edits.add(new TransactionHistory(id, accID, accType, transDate, amount, recID, recType));
					}	
					start += limit;
				}
				
				return edits;
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}else {
			System.out.println("Could not find the account accountId="+accountId+" AND accountType=\""+accountType+"\";");
			return null;
		}
	}
	
	public List<DBEdits> getEdits(int userId){
		if(verifyUser(userId)) {
			List<DBEdits> edits = new ArrayList<DBEdits>();

			try {
				ResultSet rs = queryRRS("SELECT * FROM dbedits");
				
				while (rs.next()) {
					int id = rs.getInt("id");
					Date editDate = rs.getDate("editDate");
					int editerUserID = rs.getInt("editer_user_id");
					int editedUserID = rs.getInt("edited_user_id");
					String editDescription = rs.getString("editDescription");
					
					edits.add(new DBEdits(id, editDate, editerUserID, editedUserID, editDescription));
				}	
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
			
			return edits;
		}else {
			System.out.println("Could not find the user "+userId);
			return null;
		}
	}
	
	public List<DBEdits> getEdits(int userId, int limit){
		if(verifyUser(userId)) {
			List<DBEdits> edits = new ArrayList<DBEdits>();
			
			int max = getLast("dbedits WHERE editer_user_id="+userId);
			int start = 0;

			try {
				while(edits.size() < limit && !(start > max)) {
					ResultSet rs = queryRRS("SELECT * FROM dbedits LIMIT "+start+","+limit+";");
					
					while (rs.next()) {
						int id = rs.getInt("id");
						Date editDate = rs.getDate("editDate");
						int editerUserID = rs.getInt("editer_user_id");
						int editedUserID = rs.getInt("edited_user_id");
						String editDescription = rs.getString("editDescription");
						
						edits.add(new DBEdits(id, editDate, editerUserID, editedUserID, editDescription));
					}	
					start += limit;
				}
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
			
			return edits;
		}else {
			System.out.println("Could not find the user "+userId);
			return null;
		}
	}
	
	/**
	 * Uses the Default database to retrieve ResultSet - Only accepts SELECT statements
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public ResultSet queryRRS(String query) throws Exception {
		try {
			Connection connection = DBConnect.getConnection();
			Statement stm = connection.createStatement();
			
			// Step 2: Set the database
			ResultSet rs = stm.executeQuery("USE se201_project;");
			
			// Step 3: Grab data from tables
			rs = stm.executeQuery(query);
			
			return rs;
		}catch(Exception e) {
			throw new Exception("Error found in given query. queryRRS only accepts SELECT statements. " + query);
		}
	}
	
	/**
	 * Retrieves ResultSet - Only accepts SELECT statements
	 * @param database
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public ResultSet queryRRS(String database, String query) throws Exception {
		try {
			Connection connection = DBConnect.getConnection();
			Statement stm = connection.createStatement();
			
			// Step 2: Set the database
			ResultSet rs = stm.executeQuery(database);
			
			// Step 3: Grab data from tables
			rs = stm.executeQuery(query);
			
			return rs;
		}catch(Exception e) {
			throw new Exception("Error found in given query. queryRRS only accepts SELECT statements. " + query);
		}
	}

	/**
	 * Uses the Default database to retrieve a single String - Only accepts SELECT statements
	 * @param query
	 * @param colName
	 * @return
	 * @throws Exception
	 */
	public String queryString(String query, String colName) throws Exception {
		ResultSet rs = queryRRS(query);
		String returnable = new String();
		
		//check against what we found in the DB
		try {
			if(rs.next()) {
				returnable = rs.getString(colName);
			}
			
			//request.getRequestDispatcher(loggedIn)
			return returnable;
		}catch(Exception e) {
			throw new Exception("Error found in given query. queryString only accepts SELECT statements. " + query);
		}
	}
	
	/**
	 * Retrieves a single String - Only accepts SELECT statements
	 * @param database
	 * @param query
	 * @param colName
	 * @return
	 * @throws Exception
	 */
	public String queryString(String database, String query, String colName) throws Exception {
		ResultSet rs = queryRRS(database, query);
		String returnable = new String();
		
		//check against what we found in the DB
		try {
			if(rs.next()) {
				returnable = rs.getString(colName);
			}
			
			//request.getRequestDispatcher(loggedIn)
			return returnable;
		}catch(Exception e) {
			throw new Exception("Error found in given query. queryString only accepts SELECT statements. " + query);
		}
	}

	/**
	 * Uses the Default database and returns a true value if the database has been modified - Only accepts CREATE, ALTER, INSERT, UPDATE and DELETE statements
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public boolean queryReturn(String query) {
		try {
			Connection connection = DBConnect.getConnection();
			Statement stm = connection.createStatement();
			
			// Step 2: Set the database
			stm.execute("USE se201_project;");
			
			// Step 3: Grab data from tables
			int rowsAffected = stm.executeUpdate(query);
			
			return (rowsAffected > 0);
		}catch(Exception e) {
			System.out.println("Error found in given query. queryReturn only accepts CREATE, ALTER, INSERT, UPDATE and DELETE statements. " + query);
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Returns a true value if the database has been modified - Only accepts CREATE, ALTER, INSERT, UPDATE and DELETE statements
	 * @param database
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public boolean queryReturn(String database, String query) {
		try {
			Connection connection = DBConnect.getConnection();
			Statement stm = connection.createStatement();
			
			// Step 2: Set the database
			stm.executeQuery(database);
			
			// Step 3: Grab data from tables
			int rowsAffected = stm.executeUpdate(query);
			
			return (rowsAffected > 0);
		}catch(Exception e) {
			System.out.println("Error found in given query. queryReturn only accepts CREATE, ALTER, INSERT, UPDATE and DELETE statements. " + query);
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Returns a true if a ResultSet is returned, returns false if null or other values are returned. - Accepts any SQL statement
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public boolean queryExecute(String query){
		try {
			Connection connection = DBConnect.getConnection();
			Statement stm = connection.createStatement();
			
			// Step 2: Set the database
			stm.execute("USE se201_project;");
			
			// Step 3: Grab data from tables
			return stm.execute(query);
		}catch(Exception e) {
			System.out.println("Error found in given query. " + query);
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Uses the default database and returns a true if a ResultSet is returned, returns false if null or other values are returned. - Accepts any SQL statement
	 * @param database
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public boolean queryExecute(String database, String query) {
			try {
				Connection connection = DBConnect.getConnection();
				Statement stm = connection.createStatement();
				
				// Step 2: Set the database
				stm.execute(database);
				
				// Step 3: Grab data from tables
				return stm.execute(query);
			}catch(Exception e) {
				System.out.println("Error found in given query. " + query);
				e.printStackTrace();
				return false;
			}
		}

	/**
	 * Takes the user id of the editer and the edited and the description and saves a log in the database. 
	 * 
	 * @param admin
	 * @param cust
	 * @param description
	 * @throws Exception
	 */
	public void sendEdit(int editer, int edited, String description) throws Exception {
		String query = "INSERT INTO dbedits (editer_user_id, edited_user_id, editDescription) VALUES ("+editer+","+edited+",\""+description+"\");";
		queryExecute(query);
	}
}

