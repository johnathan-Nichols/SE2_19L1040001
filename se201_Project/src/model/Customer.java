package model;

public class Customer {
	protected int id;
	protected User user;
	protected String positionInCompany;
	protected String employer;
	protected String nationality;
	protected String houseNumber;
	protected String streetName;
	protected String cityName;
	protected String stateName;
	protected String countryName;
	protected int postalCode;
	
	public Customer() {}
	
	public Customer(User user, String positionInCompany, String employer, String nationality, String houseNumber, String streetName, String cityName, String stateName, String countryName, int postalCode) {
		super();
		this.user = user;
		this.positionInCompany = positionInCompany;
		this.employer = employer;
		this.nationality = nationality;
		this.houseNumber = houseNumber;
		this.streetName = streetName;
		this.cityName = cityName;
		this.stateName = stateName;
		this.countryName = countryName;
		this.postalCode = postalCode;
	}
	
	public Customer(int id, User user, String positionInCompany, String employer, String nationality, String houseNumber, String streetName, String cityName, String stateName, String countryName, int postalCode) {
		super();
		this.id = id;
		this.user = user;
		this.positionInCompany = positionInCompany;
		this.employer = employer;
		this.nationality = nationality;
		this.houseNumber = houseNumber;
		this.streetName = streetName;
		this.cityName = cityName;
		this.stateName = stateName;
		this.countryName = countryName;
		this.postalCode = postalCode;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the positionInCompany
	 */
	public String getPositionInCompany() {
		return positionInCompany;
	}

	/**
	 * @param positionInCompany the positionInCompany to set
	 */
	public void setPositionInCompany(String positionInCompany) {
		this.positionInCompany = positionInCompany;
	}

	/**
	 * @return the employer
	 */
	public String getEmployer() {
		return employer;
	}

	/**
	 * @param employer the employer to set
	 */
	public void setEmployer(String employer) {
		this.employer = employer;
	}

	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * @return the houseNumber
	 */
	public String getHouseNumber() {
		return houseNumber;
	}

	/**
	 * @param houseNumber the houseNumber to set
	 */
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	/**
	 * @return the streetName
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * @param streetName the streetName to set
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * @return the stateName
	 */
	public String getStateName() {
		return stateName;
	}

	/**
	 * @param stateName the stateName to set
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * @return the postalCode
	 */
	public int getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	
}

 