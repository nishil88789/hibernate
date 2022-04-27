package in.co.rays;

public class User {

	private int id;
	private String Fname;
	private String Lname;
	private String username;
	private String password;
	private int Dept_ID;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public String getLname() {
		return Lname;
	}

	public void setLname(String lname) {
		Lname = lname;
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

	public int getDept_ID() {
		return Dept_ID;
	}

	public void setDept_ID(int dept_ID) {
		Dept_ID = dept_ID;
	}

}
