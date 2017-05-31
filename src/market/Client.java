package market;

public class Client {
	private String jmbg_cl;
	private String firstName;
	private String lastName;
	private String phone;
	private double total;

	public Client(String jmbg_cl, String firstName, String lastName, String phone, double total) {
		super();
		this.jmbg_cl = jmbg_cl;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.total = total;
	}

	public String getJmbg_cl() {
		return jmbg_cl;
	}

	public void setJmbg_cl(String jmbg_cl) {
		this.jmbg_cl = jmbg_cl;
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

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return jmbg_cl + ", firstName: " + firstName + ", lastName: " + lastName + ", phone: " + phone+" "+total;
	}

}
