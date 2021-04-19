package model;

import java.util.Date;

public class User {
	protected int id;
	protected String lastName;
	protected String middleName;
	protected String firstName;
	protected Date dob;
	protected char idType;
	protected String idCode;
	protected String loginName;
	protected String loginPassword;
	protected boolean validUser;
	protected boolean activatedUser;
	protected Date activationDate;
	protected char userType;
	protected String securityQuestion;
	protected String securityAnswer;
	
	public User() {}
	
	public User(String lastName, String middleName, String firstName, Date dob, char idType, String idCode, String loginName, String loginPassword, boolean validUser, boolean activatedUser, Date activationDate, char userType, String securityQuestion, String securityAnswer) {
		super();
		this.lastName = lastName;
		this.middleName = middleName;
		this.firstName = firstName;
		this.dob = dob;
		this.idType = idType;
		this.idCode = idCode;
		this.loginName = loginName;
		this.loginPassword = loginPassword;
		this.validUser = validUser;
		this.activatedUser = activatedUser;
		this.activationDate = activationDate;
		this.userType = userType;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
	}
	
	public User(int id, String lastName, String middleName, String firstName, Date dob, char idType, String idCode, String loginName, String loginPassword, boolean validUser, boolean activatedUser, Date activationDate, char userType,String securityQuestion, String securityAnswer) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.middleName = middleName;
		this.firstName = firstName;
		this.dob = dob;
		this.idType = idType;
		this.idCode = idCode;
		this.loginName = loginName;
		this.loginPassword = loginPassword;
		this.validUser = validUser;
		this.activatedUser = activatedUser;
		this.activationDate = activationDate;
		this.userType = userType;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public char getIdType() {
		return idType;
	}

	public void setIdType(char idType) {
		this.idType = idType;
	}

	public String getIdCode() {
		return idCode;
	}

	public void setIdCode(String idCode) {
		this.idCode = idCode;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public boolean isValidUser() {
		return validUser;
	}

	public void setValidUser(boolean validUser) {
		this.validUser = validUser;
	}

	public boolean isActivatedUser() {
		return activatedUser;
	}

	public void setActivatedUser(boolean activatedUser) {
		this.activatedUser = activatedUser;
	}

	public Date getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public char getUserType() {
		return userType;
	}

	public void setUserType(char userType) {
		this.userType = userType;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
}
 
