package Database.Models;

import java.sql.Date;

//javabeans onde só tem atributos, o metodo constructor e os getters and setters, so serve de objeto persistido
public class User {
	private long id;
	private String name;
	private String email;
	private String password;
	private Date registerDate = new Date(System.currentTimeMillis());

	public User() {}

	public User(, String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
}
