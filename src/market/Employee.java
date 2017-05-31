package market;

public class Employee {
	private String jmbg_em;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;

	public Employee(String jmbg_em, String firstName, String lastName, String phone, String address) {
		super();
		this.jmbg_em = jmbg_em;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}

	public String getJmbg_em() {
		return jmbg_em;
	}

	public void setJmbg_em(String jmbg_em) {
		this.jmbg_em = jmbg_em;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return jmbg_em + ", firstName: " + firstName + ", lastName: " + lastName + ", phone: " + phone + ", address: "
				+ address;
	}

}
