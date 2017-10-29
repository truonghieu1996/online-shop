package models;

public class Account {

	private String displayname;
	private String username;
	private String password;
	private int role;

	public Account() {
	}

	public Account(String displayname, String username, String password, int role) {
		super();
		this.displayname = displayname;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getDisplayname() {
		return displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

}
