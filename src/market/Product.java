package market;

public class Product {
	private String id_prod;
	private String name;
	private double price;
	private int quantity;

	public Product(String id_prod, String name, double price, int quantity) {
		super();
		this.id_prod = id_prod;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getId_prod() {
		return id_prod;
	}

	public void setId_prod(String id_prod) {
		this.id_prod = id_prod;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return id_prod + ", name: " + name + ", price: " + price + ", quantity: " + quantity;
	}

}
