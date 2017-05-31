package market;

public class Sale {
	private String id_sale;
	private String date;
	private String jmbg_em;
	private String jmbg_cl;
	private String id_prod;
	private int quantity;

	public Sale(String id_sale, String date, String jmbg_em, String jmbg_cl, String id_prod, int quantity) {
		super();
		this.id_sale = id_sale;
		this.date = date;
		this.jmbg_em = jmbg_em;
		this.jmbg_cl = jmbg_cl;
		this.id_prod = id_prod;
		this.quantity = quantity;
	}

	public String getId_sale() {
		return id_sale;
	}

	public void setId_sale(String id_sale) {
		this.id_sale = id_sale;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getJmbg_em() {
		return jmbg_em;
	}

	public void setJmbg_em(String jmbg_em) {
		this.jmbg_em = jmbg_em;
	}

	public String getJmbg_cl() {
		return jmbg_cl;
	}

	public void setJmbg_cl(String jmbg_cl) {
		this.jmbg_cl = jmbg_cl;
	}

	public String getId_prod() {
		return id_prod;
	}

	public void setId_prod(String id_prod) {
		this.id_prod = id_prod;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
