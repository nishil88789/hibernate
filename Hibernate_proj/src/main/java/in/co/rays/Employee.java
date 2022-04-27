package in.co.rays;

public class Employee {

	private int id;
	private String firstname;
	private String lastname;
	private Address EmpdAdd;
	
	public Employee() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Address getEmpdAdd() {
		return EmpdAdd;
	}

	public void setEmpdAdd(Address empdAdd) {
		this.EmpdAdd = empdAdd;
	}
	
	
}
