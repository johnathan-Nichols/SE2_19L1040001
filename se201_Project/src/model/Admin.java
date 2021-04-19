package model;

public class Admin {
	protected int id;
	protected User user;
	
	public Admin() {}

	public Admin(User user) {
		super();
		this.user = user;
	}

	public Admin(int id, User user) {
		super();
		this.id = id;
		this.user = user;
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
}
