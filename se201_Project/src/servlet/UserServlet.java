package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.Account;
import model.Admin;
import model.CheckingAccount;
import model.Customer;
import model.LoanAccount;
import model.Pay;
import model.SavingsAccount;
import model.TransactionHistory;
import model.Transfer;
import model.User;

/**
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 */

@WebServlet(name="/", urlPatterns= {"/"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final UserDAO userDAO = new UserDAO();

	/**
	 * Sends the found servlet.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}

	/**
	 * Finds the appropriate servlet type to send to the client.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		String funct = request.getServletPath();
			System.out.println(funct);
			switch (funct) {
				case "/disp":
					dispUserData(request, response, request.getParameter("adminEditID"), request.getParameter("adminLoginName"));
					break;
				case "/login":
					login(request, response);
					break;
				case "/signUp":
					signUp(request, response);
					break;
				case "/verifySignUp":
					verifySignUp(request, response);
					break;
				case "/verifyLogin":
					verifyLogin(request, response);
					break;
				case "/editAdmin":
				case "/editUser":
					editUser(request, response);
					break;
				case "/editCustomer":
					editCustomer(request, response);
					break;
				case "/verifyEditAdmin":
				case "/verifyEditUser":
					verifyEditUser(request, response, false, Integer.parseInt(request.getParameter("adminEditID")), Integer.parseInt(request.getParameter("user_id")));
					break;
				case "/deleteUser":
					if(request.getParameter("userType").equals("C")) {
						deleteCustomer(request, response);
					}else if(request.getParameter("userType").equals("A")) {
						deleteAdmin(request, response);
					}else {
						System.out.println("User Type Error in deleteUser().");
					}
					break;
				case "/verifyEditCustomer":
					verifyEditCustomer(request, response, Integer.parseInt(request.getParameter("adminEditID")), Integer.parseInt(request.getParameter("user_id")));
					break;
				case "/validateUser":
					validateUser(request, response);
					break;
				case "/invalidateUser":
					invalidateUser(request, response);
					break;
				case "/activateUser":
					activateUser(request, response);
					break;
				case "/deactivateUser":
					deactivateUser(request, response);
					break;
				case "/verifySignUpAdmin":
					verifySignUpAdmin(request, response);
					break;
				case "/signUpAdmin":
					signUpAdmin(request, response);
					break;
				case "/resetPassword":
					resetPassword(request, response);
					break;
				case "/verifyResetPassword":
					verifyResetPassword(request, response);
					break;
				case "/answerSecurityQuestion":
					answerSecurityQuestion(request, response);
					break;
				case "/verifyAnswerSecurityQuestion":
					verifyAnswerSecurityQuestion(request, response);
					break;
				case "/transferMoney":
					transferMoney(request, response);
					break;
				case "/validateTransferMoney":
					validateTransferMoney(request, response, false);
					break;
				case "/sendTransferMoney":
					validateTransferMoney(request, response, true);
					break;
				case "/createCheckingAccount":
					createCheckingAccount(request, response);
					break;
				case "/createSavingsAccount":
					createSavingsAccount(request, response);
					break;
				case "/createLoanAccount":
					createLoanAccount(request, response);
					break;
				case "/validateCreateSavingsAccount":
					validateCreateSavingsAccount(request, response);
					break;
				case "/validateCreateLoanAccount":
					validateCreateLoanAccount(request, response);
					break;
				case "/validateCreateCheckingAccount":
					validateCreateCheckingAccount(request, response);
					break;
				case "/payAccount":
					payAccount(request, response, 0);
					break;
				case "/validatePayAccount":
					payAccount(request, response, 1);
					break;
				case "/sendPayAccount":
					payAccount(request, response, 2);
					break;
				case "/closeAccount":
					closeAccount(request, response, true);
					break;
				case "/verifyCloseAccount":
					closeAccount(request, response, false);
					break;
				case "/setValidAccount":
					setValidAccount(request, response, true);
					break;
				case "/setInvalidAccount":
					setValidAccount(request, response, false);
					break;
				case "/setActiveAccount":
					setActiveAccount(request, response, true);
					break;
				case "/setDeactiveAccount":
					setActiveAccount(request, response, false);
					break;
				case "/view":
					view(request, response);
					break;
				case "/history":
					history(request, response);
					break;
				default:
					login(request, response);
					//listUser(request, response);
						
		}	
	}
	
	/**
	 * Sends user to security question form to verify identity
	 * 
	 * @param request
	 * @param response
	 */
	private void answerSecurityQuestion(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("answerSecurityQuestionForm.jsp");
		try {
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *  Checks the securityAnswer against the answer in the database. 
	 * 		If true, allows a new password to be entered.
	 * 		If false, denies the user with denial page 
	 * 
	 * @param request
	 * @param response
	 */
	private void verifyAnswerSecurityQuestion(HttpServletRequest request, HttpServletResponse response) {
		//get the users answer attempt
		String securityAnswer = request.getParameter("securityAnswer");
		
		//get the actual security answer from the database
		try {
			ResultSet rs = userDAO.queryRRS("SELECT securityAnswer FROM user WHERE id = 1;");
			if(securityAnswer.equals(rs.getString(0))){
				RequestDispatcher dispatcher = request.getRequestDispatcher("resetPassword.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Failed, send to failure page
		request.setAttribute("failureMessage", "Failed to verify security question. Contact a bank manager for assistance.");
		sendFailure(request, response);
	}
	
	/**
	 * Loads the resetPasswordForm.
	 * 
	 * @param request
	 * @param response
	 */
	private void resetPassword(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("resetPassword.jsp");
		try {
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * attempts to add the new password to the database then notifies user and allows login again.
	 * 
	 * @param request
	 * @param response
	 */
	private void verifyResetPassword(HttpServletRequest request, HttpServletResponse response) {
		//get the users answer attempt
		String loginPassword = request.getParameter("loginPassword");

		//get the actual security answer from the database
		try {
			verifyEdit(new String[] {"loginPassword"}, new String[] {loginPassword}, "UPDATE user SET ", " WHERE id = " + request.getParameter("user_id") + ";", Integer.parseInt(request.getParameter("adminEditID")), Integer.parseInt(request.getParameter("user_id")));
			
			//We've sent the edit, now display login page
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		//TODO when calling this method set a failureMessage attribute
		request.setAttribute("failureMessage", "Failed to reset password. Contact a bank manager for assistance.");
		sendFailure(request, response);
	}
	
	//TODO create generic failure page.
	//TODO replace the failure in other methods with this class
	//TODO when calling this method set a failureMessage attribute
	private void sendFailure(HttpServletRequest request, HttpServletResponse response) {
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Failure.jsp");
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
	/**
	 * Displays the data of the database
	 * 
	 * @param request
	 * @param response
	 */
	private void dispUserData(HttpServletRequest request, HttpServletResponse response, String adminEditID, String adminLoginName) {
		request.setAttribute("users", userDAO.selectAllUsers());

		request.setAttribute("admins", userDAO.selectAllAdmins());

		request.setAttribute("customers", userDAO.selectAllCustomers());
		
		List<CheckingAccount> check = userDAO.selectAllChecking();
		System.out.println("UserServlet : checking.customer.id=" + check.get(0).getCustomer().getId());
		request.setAttribute("checkingAccounts", check);
		
		request.setAttribute("savingsAccounts", userDAO.selectAllSavings());
		
		request.setAttribute("loanAccounts", userDAO.selectAllLoan());
		
		request.setAttribute("adminLoginName", adminLoginName);
		request.setAttribute("adminEditID", adminEditID);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ViewAllUserData.jsp");
		try {
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Old login servlet
	 *
	 * @param request
	 * @param response
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		try {
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Old signUp servlet
	 *
	 * @param request
	 * @param response
	 */
	private void signUp(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("signUpForm.jsp");
		try {
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Accepts new admin info to send to the database.
	 *
	 * @param request
	 * @param response
	 */
	private void signUpAdmin(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("signUpAdminForm.jsp");
		try {
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Old verify signup
	 * 
	 * @param request
	 * @param response
	 */
	private void verifySignUp(HttpServletRequest request, HttpServletResponse response) {		
		//check against what we found in the DB
		try {
			if(new UserDAO().addCustomer(request, response)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("verifySignUp.jsp");
				dispatcher.forward(request, response); 
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("failureMessage", "Failed to sign up.<br>Try again with a different User Name or contact a bank manager for assistance.");
		sendFailure(request, response);
	}

	/**
	 * Should only be ran from the ViewAllUserData.jsp, adds new admin to the database.
	 * 
	 * @param request
	 * @param response
	 */
	private void verifySignUpAdmin(HttpServletRequest request, HttpServletResponse response) {		
		//check against what we found in the DB
		try {
			if(new UserDAO().addAdmin(request, response)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("verifySignUp.jsp");
				dispatcher.forward(request, response); 
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("failureMessage", "Failed to sign up. Contact a bank manager for assistance.");
		sendFailure(request, response);
	}
	
	/**
	 * Old verify login
	 * 
	 * @param request
	 * @param response
	 */
	private void verifyLogin(HttpServletRequest request, HttpServletResponse response) {
		String loginName = request.getParameter("Login Name");
		String loginPassword = request.getParameter("Login Password");
		String loggedIn = "TempReject.jsp";

		try {
			//ask DB if this user exists
			String query = "SELECT id, userType FROM user WHERE loginName = \"" + loginName + "\" AND loginPassword = \"" + loginPassword + "\";";
			ResultSet rs = userDAO.queryRRS(query);
			
			if(rs.next()) {
				if(rs.getString("userType").equals("A")) {
					//Send to admin page (disp)
					dispUserData(request, response, rs.getString("id"), loginName);
					return;
				}else {
					customerLogin(request, response, loginName);
				}
			}
			
			//request.getRequestDispatcher(loggedIn)
			RequestDispatcher dispatcher = request.getRequestDispatcher(loggedIn);
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("failureMessage", "The login name "+loginName+" and the password "+loginPassword+" do not match.");
			sendFailure(request, response);
		}
	}
	
	private void customerLogin(HttpServletRequest request, HttpServletResponse response, String loginName) {
		try {
		List<CheckingAccount> checkingAccounts = new ArrayList<CheckingAccount>();
		List<LoanAccount> loanAccounts = new ArrayList<LoanAccount>();
		List<SavingsAccount> savingsAccounts = new ArrayList<SavingsAccount>();

		boolean[] hasAccounts = new boolean[] {false, false, false};
		String[] account = new String[] { "checkingaccount","savingsaccount", "loanaccount"};
		for(int i = 0; i < 3; i++) {
			String query = "select * from "+ account[i] +" inner join customer on " + account[i] + ".customer_id = customer.id inner join user on customer.user_id = user.id Where user.loginName = '" + loginName + "';";
				ResultSet rs = userDAO.queryRRS(query);
			while(rs.next()) {
				if(rs.getBoolean("activatedAccount")) {
					hasAccounts[i] = true;
					if(i==0) {
						int id = rs.getInt("id"); 
						Date creationDate = rs.getDate("creationDate"); 
						double accountBalance = rs.getDouble("accountBalance"); 
						boolean canTransfer = accountBalance>0; 
						boolean validAccount = rs.getBoolean("validAccount"); 
						boolean activatedAccount = rs.getBoolean("activatedAccount");
						checkingAccounts.add(new CheckingAccount(id, null, creationDate, accountBalance, canTransfer, validAccount, activatedAccount));
					}else if (i==1) {
						int id = rs.getInt("id");
						double increasePercentage = rs.getDouble("increasePercentage");
						int increaseRate = rs.getInt("increaseRate");
						Date lastIncrease = rs.getDate("lastIncrease");
						Date creationDate = rs.getDate("creationDate");
						double accountBalance = rs.getDouble("accountBalance");
						boolean canTransfer = accountBalance>0; 
						boolean validAccount = rs.getBoolean("validAccount");
						boolean activatedAccount = rs.getBoolean("activatedAccount");
						savingsAccounts.add(new SavingsAccount(id, null, increasePercentage, increaseRate, lastIncrease, creationDate, accountBalance, canTransfer, validAccount, activatedAccount));
					}else if (i==2) {
						int id = rs.getInt("id");
						double increaseRate = rs.getDouble("increaseRate");
						int increaseInterval = rs.getInt("increaseInterval");
						double latePaymentPenalty = rs.getDouble("latePaymentPenalty");
						double intervalRequiredPayment = rs.getDouble("intervalRequiredPayment");
						double currentIntervalPaymentReceived = rs.getDouble("currentIntervalPaymentReceived");
						Date lastIntervalDate = rs.getDate("lastIntervalDate");
						Date creationDate = rs.getDate("creationDate");
						double accountBalance = rs.getDouble("accountBalance");
						double owedAmount = rs.getDouble("owedAmount");
						boolean canTransfer = accountBalance>0; 
						boolean validAccount = rs.getBoolean("validAccount");
						boolean activatedAccount = rs.getBoolean("activatedAccount");
						loanAccounts.add(new LoanAccount(id, null, increaseRate, increaseInterval, latePaymentPenalty, intervalRequiredPayment, currentIntervalPaymentReceived, lastIntervalDate, creationDate, accountBalance, owedAmount, canTransfer, validAccount, activatedAccount));
					}
				}
			}
		}
		String query = "select customer.id from customer inner join user on customer.user_id = user.id where user.loginName = \""+loginName+"\";";
		ResultSet rs = userDAO.queryRRS(query);

		if(rs.next()) {
			request.setAttribute("customer_id", rs.getInt("customer.id"));
		} else {
			request.setAttribute("failureMessage", "Failed to find customer "+loginName+".");
			sendFailure(request, response);
		}

		request.setAttribute("checkingAccounts", checkingAccounts);
		request.setAttribute("loanAccounts", loanAccounts);
		request.setAttribute("savingsAccounts", savingsAccounts);

		request.setAttribute("hasAccountsChecking", hasAccounts[0]);
		request.setAttribute("hasAccountsSavings", hasAccounts[1]);
		request.setAttribute("hasAccountsLoan", hasAccounts[2]);
		
		request.setAttribute("loginName", loginName);
		RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerJSP/ViewCustomerData.jsp");
		dispatcher.forward(request, response); 
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("failureMessage", "Failed to display customer information.a");
			sendFailure(request, response);
		}
	}

	/**
	 * Sends the user to a form where they can edit information.
	 * 
	 * @param request
	 * @param response
	 */
	private void editUser(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("editUserForm.jsp");
		try {
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Checks if an input field is null or not and then adds it to the update query.
	 * 
	 * @param request
	 * @param response
	 */
	private void verifyEditUser(HttpServletRequest request, HttpServletResponse response, boolean extendedCase, int adminEditID, int user_id) {
		String[] queryColumnName = new String[] {"lastName", "middleName", "firstName", "dob", "idType", "idCode", "loginName", "loginPassword", "validUser", "activatedUser", "userType"};
		String[] queryInput = new String[] {request.getParameter("lastName"), request.getParameter("middleName"), request.getParameter("firstName"), request.getParameter("dob"), request.getParameter("idType"), request.getParameter("idCode"), request.getParameter("loginName"), request.getParameter("loginPassword"), request.getParameter("validUser"), request.getParameter("activatedUser"), request.getParameter("userType")};

		String queryHeader = "UPDATE user SET ";
		String queryFooter = " WHERE id = " + request.getParameter("user_id") + ";";

		verifyEdit(queryColumnName, queryInput, queryHeader, queryFooter, adminEditID, user_id);
		
		if(!extendedCase) {
			dispUserData(request, response, request.getParameter("adminEditID"), request.getParameter("adminLoginName"));
		}
	}
	
	/**
	 * Accepts new data about a customer and attempts to edit it in the database.
	 * 
	 * @param request
	 * @param response
	 */
	private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("editCustomerForm.jsp");
		try {
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sends the editCustomerForm data to the database.
	 * 
	 * @param request
	 * @param response
	 */
	private void verifyEditCustomer(HttpServletRequest request, HttpServletResponse response, int adminEditID, int user_id) {
		
		//edit User first
		verifyEditUser(request, response, true, adminEditID, user_id);
		
		//Then edit customer
		String[] queryColumnName = new String[] {"positionInCompany", "employer", "nationality", "houseNumber", "streetName", "cityName", "stateName", "countryName", "postalCode"};
		String[] queryInput = new String[] {request.getParameter("positionInCompany"), request.getParameter("employer"), request.getParameter("nationality"), request.getParameter("houseNumber"), request.getParameter("streetName"), request.getParameter("cityName"), request.getParameter("stateName"), request.getParameter("countryName"), request.getParameter("postalCode")};
		

		String queryHeader = "UPDATE customer SET ";
		String queryFooter = " WHERE id = " + request.getParameter("customer_id") + ";";

		verifyEdit(queryColumnName, queryInput, queryHeader, queryFooter, adminEditID, user_id);
		
		dispUserData(request, response, ("" + adminEditID), request.getParameter("adminLoginName"));
	}

	/**
	 * Deletes the customer and the user.
	 * 
	 * @param request
	 * @param response
	 */
	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
		deleteByID("customer", "user_id", request.getParameter("user_id"));
		deleteByID("user", "id", request.getParameter("user_id"));

		dispUserData(request, response, request.getParameter("adminEditID"), request.getParameter("adminLoginName"));
	}

	/**
	 * Deletes the admin and the user.
	 * 
	 * @param request
	 * @param response
	 */
	private void deleteAdmin(HttpServletRequest request, HttpServletResponse response) {
		deleteByID("admin", "user_id", request.getParameter("user_id"));
		deleteByID("user", "id", request.getParameter("user_id"));

		dispUserData(request, response, request.getParameter("adminEditID"), request.getParameter("adminLoginName"));
	}
	
	/**
	 * Deletes a row from the default database 'se201_project'
	 * 
	 * @param table
	 * @param column
	 * @param cellData
	 */
	private void deleteByID(String table, String column, String cellData) {
		String query = "DELETE FROM " + table + " WHERE " + column + "='"+cellData+"';";
		try {
			userDAO.queryReturn(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	

	/**
	 * Takes in query components and runs it through the system.
	 * 
	 * @param queryColumnName
	 * @param queryInput
	 * @param queryHeader
	 * @param queryFooter
	 */
	private void verifyEdit(String[] queryColumnName, String[] queryInput, String queryHeader, String queryFooter, int editer, int edited) {
		try {
			boolean sendQuery = false;
			String temp = buildQueryWithNullChecker(queryColumnName, queryInput);
			
			if(temp.length() > 0) {
				queryHeader += temp + queryFooter;
				sendQuery = true;
			}
			
			if(sendQuery) {
					userDAO.queryReturn(queryHeader);
					userDAO.sendEdit(editer, edited, queryHeader);
			}else {
				System.out.println("Nothing to update.");
			}
		}catch(Exception e) {
			e.printStackTrace();		}
	}
	
	/**
	 * Will combine StringA[i] and StringB[i] if StringB[i] is not null.
	 * 
	 * @param queryColumnName
	 * @param queryInput
	 * @return
	 * @throws Exception
	 */
	private String buildQueryWithNullChecker(String[] queryColumnName, String[] queryInput) throws Exception {
		String returnable = "";
		boolean firstInput = false;
		
		if(queryColumnName.length != queryInput.length) {
			throw new Exception("Query column name length must match query input length.");
		}
		
		for(int i = 0; i < queryColumnName.length; i++) {
			
			if(queryInput[i] != null && !queryInput[i].isEmpty()) {
				if(firstInput) {
					returnable += ", ";
				}else {
					firstInput = true;
				}
				returnable += queryColumnName[i] + "=\'" + queryInput[i] + "\'";
			}
		}
		return returnable;
	}
	
	/**
	 * validates user
	 * 
	 * @param request
	 * @param response
	 */
	private void validateUser(HttpServletRequest request, HttpServletResponse response) {
		String[] queryColumnName = new String[] {"validUser"};
		String[] queryInput = new String[] {"1"};

		String queryHeader = "UPDATE user SET ";
		String queryFooter = " WHERE id = " + request.getParameter("user_id") + ";";

		verifyEdit(queryColumnName, queryInput, queryHeader, queryFooter, Integer.parseInt(request.getParameter("adminEditID")), Integer.parseInt(request.getParameter("user_id")));
		
		dispUserData(request, response, request.getParameter("adminEditID"), request.getParameter("adminLoginName"));
	}
	
	/**
	 * validates user
	 * 
	 * @param request
	 * @param response
	 */
	private void setValidAccount(HttpServletRequest request, HttpServletResponse response, boolean valid) {
		String[] queryColumnName = new String[] {"validAccount"};
		String[] queryInput;
		
		if(valid) {
			queryInput = new String[] {"1"};
		}else {
			queryInput = new String[] {"0"};
		}
		
		String account = request.getParameter("accountType");

		String queryHeader = "UPDATE "+account+"Account SET ";
		String queryFooter = " WHERE id = " + request.getParameter("account_id") + ";";

		verifyEdit(queryColumnName, queryInput, queryHeader, queryFooter, Integer.parseInt(request.getParameter("adminEditID")), Integer.parseInt(request.getParameter("account_id")));
		
		dispUserData(request, response, request.getParameter("adminEditID"), request.getParameter("adminLoginName"));
	}
	
	/**
	 * validates user
	 * 
	 * @param request
	 * @param response
	 */
	private void setActiveAccount(HttpServletRequest request, HttpServletResponse response, boolean valid) {
		String[] queryColumnName = new String[] {"activatedAccount"};
		String[] queryInput;
		
		if(valid) {
			queryInput = new String[] {"1"};
		}else {
			queryInput = new String[] {"0"};
		}
		
		String account = request.getParameter("accountType");

		String queryHeader = "UPDATE "+account+"Account SET ";
		String queryFooter = " WHERE id = " + request.getParameter("account_id") + ";";

		verifyEdit(queryColumnName, queryInput, queryHeader, queryFooter, Integer.parseInt(request.getParameter("adminEditID")), Integer.parseInt(request.getParameter("account_id")));
		
		dispUserData(request, response, request.getParameter("adminEditID"), request.getParameter("adminLoginName"));
	}
	
	/**
	 * invalidates user
	 * 
	 * @param request
	 * @param response
	 */
	private void invalidateUser(HttpServletRequest request, HttpServletResponse response) {
		String[] queryColumnName = new String[] {"validUser"};
		String[] queryInput = new String[] {"0"};

		String queryHeader = "UPDATE user SET ";
		String queryFooter = " WHERE id = " + request.getParameter("user_id") + ";";

		verifyEdit(queryColumnName, queryInput, queryHeader, queryFooter, Integer.parseInt(request.getParameter("adminEditID")), Integer.parseInt(request.getParameter("user_id")));
		
		dispUserData(request, response, request.getParameter("adminEditID"), request.getParameter("adminLoginName"));
	}
	
	/**
	 * Activates user
	 * 
	 * @param request
	 * @param response
	 */
	private void activateUser(HttpServletRequest request, HttpServletResponse response) {
		String[] queryColumnName = new String[] {"activatedUser"};
		String[] queryInput = new String[] {"1"};

		String queryHeader = "UPDATE user SET ";
		String queryFooter = " WHERE id = " + request.getParameter("user_id") + ";";

		verifyEdit(queryColumnName, queryInput, queryHeader, queryFooter, Integer.parseInt(request.getParameter("adminEditID")), Integer.parseInt(request.getParameter("user_id")));
		
		dispUserData(request, response, request.getParameter("adminEditID"), request.getParameter("adminLoginName"));
	}
	
	/**
	 * Deactivates User
	 * 
	 * @param request
	 * @param response
	 */
	private void deactivateUser(HttpServletRequest request, HttpServletResponse response) {
		String[] queryColumnName = new String[] {"activatedUser"};
		String[] queryInput = new String[] {"0"};

		String queryHeader = "UPDATE user SET ";
		String queryFooter = " WHERE id = " + request.getParameter("user_id") + ";";

		verifyEdit(queryColumnName, queryInput, queryHeader, queryFooter, Integer.parseInt(request.getParameter("adminEditID")), Integer.parseInt(request.getParameter("user_id")));
		
		dispUserData(request, response, request.getParameter("adminEditID"), request.getParameter("adminLoginName"));
	}
	
	/**
	 * Opens the transfer money form to allow the user to transfer money from one account to another.
	 * 		get current account id, account type
	 * 		ask for transfer account id and type
	 * 		remove from current, add to new
	 * 
	 * @param request
	 * @param response
	 */
	private void transferMoney(HttpServletRequest request, HttpServletResponse response) {
		int mainID = Integer.parseInt(request.getParameter("main_id"));
		String mainType = request.getParameter("main_type");
		request.setAttribute("mainID", mainID);
		request.setAttribute("mainType", mainType);
		request.setAttribute("mainAccountAmount", request.getParameter("mainAccountAmount") );
		
		String loginName =request.getParameter("loginName");
		
		request.setAttribute("customer_id", request.getParameter("customer_id"));
		request.setAttribute("loginName", loginName);
		try {
			//Get Accounts
			List<Account> accounts = getAccounts(loginName);
			
			//Omit this account && all loan accounts
			for(int i = 0; i < accounts.size(); i++) {
				//remove any account that is this account and is a loan account --Also removes invalid accounts
				if((accounts.get(i).getAccountID() == mainID && accounts.get(i).getAccountType().equals(mainType)) || accounts.get(i).getAccountType().equals("loan") || accounts.get(i).getAccountBalance() <= 0) {
					accounts.remove(i);
				}
			}
			
			request.setAttribute("accounts", accounts);
			request.setAttribute("hasAccounts", (!accounts.isEmpty()));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/CustomerJSP/TransferMoney.jsp");
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void validateTransferMoney(HttpServletRequest request, HttpServletResponse response, boolean send){	
		String close = request.getParameter("cancel");
		if(close != null) {
			if(close.equals("true")) {
				customerLogin(request, response, request.getParameter("loginName"));
				return;
			}
		}
		
		
		request.setAttribute("customer_id", request.getParameter("customer_id"));
		request.setAttribute("loginName", request.getParameter("loginName"));
		String pageToLoad = "Failure.jsp";
		
		//send
		if(send) {
			//get transfer
			String[] getTransfer = request.getParameter("transfer").split("and");
			Transfer transfer = new Transfer(getTransfer[0], getTransfer[1], getTransfer[2], getTransfer[3], getTransfer[4], getTransfer[5], getTransfer[6]) ;
			
			if(transfer.getMainAccountAmount() < transfer.getTransferAmount()) {
				request.setAttribute("failureMessage", "Not enough money in the account.");
				sendFailure(request, response);
				return;
			}
			
			//remove from accountA
			String query = "UPDATE " + transfer.getMainType() + "Account SET accountBalance="+(transfer.getMainAccountAmount()-transfer.getTransferAmount()) + " WHERE id="+transfer.getMainID();
			try {
				userDAO.queryReturn(query);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//complete transfer with userDAO
			query = "UPDATE " + transfer.getTransferType() + "Account SET accountBalance="+(transfer.getTransferAccountAmount()+transfer.getTransferAmount()) + " WHERE id="+transfer.getTransferID();
			try {
				userDAO.queryReturn(query);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			customerLogin(request, response, request.getParameter("loginName"));
		}else {//validate ...yes/no question
			int style = Integer.parseInt(request.getParameter("transferStyle"));
			if(style==0) {//to own account
				//split account :: 0=balance, 1=ID, 2=type
				String[] account = request.getParameter("accounts").split("and");
				Transfer transfer = new Transfer(request.getParameter("mainType"), request.getParameter("mainID"), account[2], account[1], request.getParameter("transfer_Amount"), request.getParameter("mainAccountAmount"), account[0]);

				request.setAttribute("transfer_Type", transfer.getTransferType());
				request.setAttribute("transfer_ID", transfer.getTransferID());
				request.setAttribute("transfer_Amount", transfer.getTransferAmount());
				request.setAttribute("transfer", transfer.toString());
				
			}else {//to set account
				String transferType = request.getParameter("transfer_Type");
				String transferID = request.getParameter("transfer_ID");
				String transferBalance = "";
				String query = "SELECT * FROM " + transferType+ "account WHERE id="+transferID+";";
				try {
					ResultSet rs = userDAO.queryRRS(query);
					
					if(rs.next()) {
						transferBalance = rs.getString("accountBalance");
					}else {
						request.setAttribute("failureMessage", "Else:Could not complete the transfer. Account "+transferID+" was not found!");
						sendFailure(request, response);
						return;
					}
				}catch(Exception e) {
					e.printStackTrace();
					request.setAttribute("failureMessage", "Catch:Could not complete the transfer. Account "+transferID+" was not found!");
					sendFailure(request, response);
					return;
				}
				
				
				
				Transfer transfer = new Transfer(request.getParameter("mainType"), request.getParameter("mainID"), transferType, transferID, request.getParameter("transfer_Amount"), request.getParameter("mainAccountAmount"), transferBalance);

				request.setAttribute("transfer_Type", transfer.getTransferType());
				request.setAttribute("transfer_ID", transfer.getTransferID());
				request.setAttribute("transfer_Amount", transfer.getTransferAmount());
				request.setAttribute("transfer", transfer);			
			}
			pageToLoad = "CustomerJSP/VerifyTransferMoney.jsp";
		}
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher(pageToLoad);
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("failureMessage", "Could not complete the transfer.");
				sendFailure(request, response);
		}
	}
	
	/**
	 * forwards the customer to the create checking account form
	 * @param request
	 * @param response
	 */
	private void createCheckingAccount(HttpServletRequest request, HttpServletResponse response) {
		String loginName =request.getParameter("loginName");
		
		request.setAttribute("customer_id", request.getParameter("customer_id"));
		request.setAttribute("loginName", loginName);
		try {
			List<Account> accounts = getAccounts(loginName);
			request.setAttribute("accounts", accounts);
			request.setAttribute("hasAccounts", (!accounts.isEmpty()));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/LinkedJSP/CreateCheckingAccount.jsp");
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	/**
	 * forwards the customer to the create savings account form
	 * @param request
	 * @param response
	 */
	private void createSavingsAccount(HttpServletRequest request, HttpServletResponse response) {
		String loginName =request.getParameter("loginName");
		
		request.setAttribute("customer_id", request.getParameter("customer_id"));
		request.setAttribute("loginName", loginName);
		try {
			List<Account> accounts = getAccounts(loginName);
			request.setAttribute("accounts", accounts);
			request.setAttribute("hasAccounts", (!accounts.isEmpty()));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/LinkedJSP/CreateSavingsAccount.jsp");
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	/**
	 * forwards the customer to the create loan account form
	 * @param request
	 * @param response
	 */
	private void createLoanAccount(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("customer_id", request.getParameter("customer_id"));
		request.setAttribute("loginName", request.getParameter("loginName"));
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/LinkedJSP/CreateLoanAccount.jsp");
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	//TODO remove money from selected account and verify that money can be removed
	private void validateCreateCheckingAccount(HttpServletRequest request, HttpServletResponse response) {
		//double, id, type
		String[] accounts = request.getParameter("accounts").split("and");
				
		Double removeNumber = Double.parseDouble(request.getParameter("accountBalance"));
		Double currentNumber = Double.parseDouble(accounts[0]);
		int accountID = Integer.parseInt(accounts[1]);
		boolean validAccount = currentNumber >= removeNumber;
		
		CheckingAccount checking = new CheckingAccount(removeNumber);
		try {
			if(validAccount) {
				//reduce the account by x amount
				String query = "UPDATE "+accounts[2]+"account SET accountBalance="+(currentNumber - removeNumber)+" WHERE id="+accountID+";";
				userDAO.queryReturn(query);
				
				userDAO.addCheckingAccount(checking, Integer.parseInt(request.getParameter("customer_id")));
				customerLogin(request, response, request.getParameter("loginName"));
			}else {
				request.setAttribute("failureMessage", "The selected account does not have enough money.");
				sendFailure(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("failureMessage", "Failed to create the checking account.");
			sendFailure(request, response);
		}
	}

	private void validateCreateLoanAccount(HttpServletRequest request, HttpServletResponse response) {
		LoanAccount loanAccount = new LoanAccount(Double.parseDouble(request.getParameter("accountBalance")));
		try {
			userDAO.addLoanAccount(loanAccount, Integer.parseInt(request.getParameter("customer_id")));
			customerLogin(request, response, request.getParameter("loginName"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("failureMessage", "Failed to create the loan account.");
			sendFailure(request, response);
		}
	}

	private void validateCreateSavingsAccount(HttpServletRequest request, HttpServletResponse response) {
		//double, id, type
		String[] accounts = request.getParameter("accounts").split("and");
				
		Double removeNumber = Double.parseDouble(request.getParameter("accountBalance"));
		Double currentNumber = Double.parseDouble(accounts[0]);
		int accountID = Integer.parseInt(accounts[1]);
		boolean validAccount = currentNumber >= removeNumber;
		
		SavingsAccount savingsAccount = new SavingsAccount(Double.parseDouble(request.getParameter("accountBalance")));
		try {
			if(validAccount) {
				//reduce the account by x amount
				String query = "UPDATE "+accounts[2]+"account SET accountBalance="+(currentNumber - removeNumber)+" WHERE id="+accountID+";";
				userDAO.queryReturn(query);

				userDAO.addSavingsAccount(savingsAccount, Integer.parseInt(request.getParameter("customer_id")));
				customerLogin(request, response, request.getParameter("loginName"));
			}else {
				request.setAttribute("failureMessage", "The selected account does not have enough money.");
				sendFailure(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("failureMessage", "Failed to create savings account.");
			sendFailure(request, response);
		}
	}
	
	private List<Account> getAccounts(String loginName) {
		System.out.println("Getting accounts");
		//owner, accountType, accountBalance
		List<Account> accounts = new ArrayList<Account>();
		
		//Accounts to check
		String[] tables = new String[] {"checkingAccount", "savingsAccount", "loanAccount"};
		try {
			for(int i = 0; i < tables.length; i++) {
				String query = "select * from "+tables[i]+" inner join  customer on "+tables[i]+".customer_id = customer.id inner join user on customer.user_id = user.id where user.loginName = \""+loginName+"\";";
				ResultSet rs = userDAO.queryRRS(query);
				while(rs.next()) {
					if(rs.getBoolean("validAccount") && rs.getBoolean("activatedAccount")) {
						accounts.add(new Account(loginName, tables[i], rs.getDouble("accountBalance"), rs.getInt(tables[i] +".id")));
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return accounts;
	}
	
	private void closeAccount(HttpServletRequest request, HttpServletResponse response, boolean function) {
		//if loan and owedAmount = 0, allow close with money transfer
		//if savings or checking, transfer money then close
		//if no account left then say, no account to transfer remaining funds to, see bank
		//if account balance = 0 and no due amount then allow clean close.
		String close = request.getParameter("cancel");
		if(close != null) {
			if(close.equals("true")) {
				customerLogin(request, response, request.getParameter("loginName"));
				return;
			}
		}
		if(function) {
			//verify close
			request.setAttribute("customer_id", request.getParameter("customer_id"));
			request.setAttribute("loginName", request.getParameter("loginName"));
			request.setAttribute("close_Type", request.getParameter("close_Type"));
			request.setAttribute("close_ID", request.getParameter("close_ID"));
			try {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/CustomerJSP/CloseAccount.jsp");
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}else {
			//close the account -- unverify and invalidate
			try {
				String query = "UPDATE "+request.getParameter("close_Type")+"Account SET activatedAccount=false WHERE id="+request.getParameter("close_ID")+";";
				userDAO.queryReturn(query);
				customerLogin(request, response, request.getParameter("loginName"));
			}catch(Exception e) {
				e.printStackTrace();
				request.setAttribute("failureMessage", "Failed to close account.");
				sendFailure(request, response);
			}
		}
	}
	
	private void payAccount(HttpServletRequest request, HttpServletResponse response, int function) {
		//transfer money from an account to the loan account to pay off the account
		String close = request.getParameter("cancel");
		if(close != null) {
			if(close.equals("true")) {
				customerLogin(request, response, request.getParameter("loginName"));
				return;
			}
		}
		
		request.setAttribute("customer_id", request.getParameter("customer_id"));
		request.setAttribute("loginName", request.getParameter("loginName"));
		
		if(function == 0) {
			request.setAttribute("receiveID", request.getParameter("account_id"));
			request.setAttribute("iRP", request.getParameter("iRP"));
			request.setAttribute("cIPR", request.getParameter("cIPR"));
			request.setAttribute("owedAmount", request.getParameter("owedAmount"));
			
			List<Account> accounts = getAccounts(request.getParameter("loginName"));
			
			if(accounts == null) {
				request.setAttribute("failureMessage", "No accounts found. Cannot pay loan.");
				sendFailure(request, response);
			}
			
			for(int i = 0; i < accounts.size(); i++) {
				if((!(accounts.get(i).getAccountBalance() > 0)) || (accounts.get(i).getAccountID() == Integer.parseInt(request.getParameter("account_id")))) {
					accounts.remove(i);
				}
			}
			
			//check for null again
			if(accounts.isEmpty()) {
				request.setAttribute("failureMessage", "No accounts found. Cannot pay loan.");
				sendFailure(request, response);
			}
			
			try {
				request.setAttribute("accounts", accounts);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/CustomerJSP/PayAccount.jsp");
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}else if(function == 1){
			String payAmount = request.getParameter("pay_Amount");
			String receiveID = request.getParameter("receiveID");
			request.setAttribute("iRP", request.getParameter("iRP"));
			Pay pay = new Pay(request.getParameter("accounts"), receiveID, request.getParameter("owedAmount"), payAmount, request.getParameter("cIPR"));
			
			request.setAttribute("pay", pay.toString());
			request.setAttribute("payAmount", payAmount);
			request.setAttribute("receiveID", receiveID);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/CustomerJSP/VerifyPayAccount.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		}else{
			//TODO if owed-pay != 0 reduce the requiredpayment ....if that isn't 0 then set to x
			try {
				//split account :: 0=balance, 1=ID, 2=type, 3=receiveID, 4=owedAmount, 5=payAmount, 6=cIPR
				String[] pay = request.getParameter("pay").split("and");
				double iRP = Double.parseDouble(request.getParameter("iRP"));
				int receiveID = Integer.parseInt(pay[3]);
				double owedAmount = Double.parseDouble(pay[4]);
				double payAmount = Double.parseDouble(pay[5]);
				double cIPR = Double.parseDouble(pay[6]);
				
				//get the requiredPayment
				
				//Pay the loan
				String query = "UPDATE loanAccount SET owedAmount="+(owedAmount < payAmount?0:owedAmount-payAmount)+", currentIntervalPaymentReceived="+(cIPR + payAmount)+", intervalRequiredPayment="+((iRP-payAmount)<0?0:iRP-payAmount)+"  WHERE id="+receiveID+";";
				userDAO.queryReturn(query);

				query = "UPDATE " + pay[2] + "Account SET accountBalance="+(Double.parseDouble(pay[0]) - payAmount) + " WHERE id="+pay[1]+";";
				userDAO.queryReturn(query);
				
				customerLogin(request, response, request.getParameter("loginName"));
			}catch(Exception e) {
				e.printStackTrace();
				request.setAttribute("failureMessage", "Failed to close account.");
				sendFailure(request, response);
			}
		}
	}
	
	public void view(HttpServletRequest request, HttpServletResponse response) {
		String error = "Could not parse account ID";
		try {
			int accountID = Integer.parseInt(request.getParameter("account_id"));
			error = "Could not find the account type.";
			char accountType = request.getParameter("accountType").charAt(0);
			
			error = "Could not get the history.";
			List<TransactionHistory> hist = userDAO.getHistory(accountID, accountType);
			
			request.setAttribute("history", hist);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewHistory.jsp");
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(error);
		}		
	}
	
	public void history(HttpServletRequest request, HttpServletResponse response) {
		try {
			int accountID = Integer.parseInt(request.getParameter("account_id"));
			char accountType = request.getParameter("account_id").charAt(0);
			
			//userDAO.getEdits
		}catch(Exception e) {
			
		}		
	}
}

