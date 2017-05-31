package market;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataConn {
	private String url;
	private String user;
	private String pass;
	private Connection conn;

	public DataConn(String url, String user, String pass) {
		super();
		this.url = url;
		this.user = user;
		this.pass = pass;

		try {
			this.conn = DriverManager.getConnection(url, user, pass);
			// System.out.println("TADA");
		} catch (SQLException e) {
			System.out.println("Connection Eror");
		}
	}

	public List<Product> getProducts() {
		List<Product> li = new ArrayList<Product>();
		String ko = "select id_prod, name, price, quantity FROM product";
		Statement st;

		try {
			st = conn.createStatement();
			ResultSet rd = st.executeQuery(ko);

			while (rd.next()) {
				Product p = new Product(rd.getString("id_prod"), rd.getString("name"), rd.getDouble("price"),
						rd.getInt("quantity"));
				System.out.println(rd.getString("name"));
				li.add(p);
			}
			rd.close();
			return li;
		} catch (SQLException rt) {
			return null;
		}

	}

	public List<Client> getClients() {
		List<Client> li = new ArrayList<Client>();
		String ko = "select jmbg_cl, first_name, last_name, phone, total FROM CLIENT";
		Statement st;

		try {
			st = conn.createStatement();
			ResultSet rd = st.executeQuery(ko);

			while (rd.next()) {
				Client kj = new Client(rd.getString("jmbg_cl"), rd.getString("first_name"), rd.getString("last_name"),
						rd.getString("phone"), rd.getDouble("total"));
				// System.out.println(rd.getString("name"));
				li.add(kj);
			}
			rd.close();
			return li;
		} catch (SQLException rt) {
			return null;
		}

	}

	public List<Sale> getSale() {
		List<Sale> li = new ArrayList<Sale>();
		String ko = "select id_sale, id_prod, jmbg_cl, jmbg_em, quantity, date FROM Sale";
		Statement st;

		try {
			st = conn.createStatement();
			ResultSet rd = st.executeQuery(ko);

			while (rd.next()) {
				Sale kj = new Sale(rd.getString("id_sale"), rd.getString("date"), rd.getString("jmbg_em"),
						rd.getString("jmbg_cl"), rd.getString("id_prod"), rd.getInt("quantity"));
				// System.out.println(rd.getString("name"));
				li.add(kj);
			}
			rd.close();
			return li;
		} catch (SQLException rt) {
			return null;
		}

	}

	public List<Sale> getSaleFilter(String startDate, String endDate) {
		// conn.open();
		List<Sale> li = new ArrayList<Sale>();
		String ko = "select id_sale, id_prod, jmbg_cl, jmbg_em, quantity, date FROM Sale where date>='" + startDate
				+ "' and date<='" + endDate + "'";
		Statement st;

		try {
			st = conn.createStatement();
			ResultSet rd = st.executeQuery(ko);

			while (rd.next()) {
				Sale kj = new Sale(rd.getString("id_sale"), rd.getString("date"), rd.getString("jmbg_em"),
						rd.getString("jmbg_cl"), rd.getString("id_prod"), rd.getInt("quantity"));
				// System.out.println(rd.getString("name"));
				li.add(kj);
			}
			// rd.close();
			return li;
		} catch (SQLException rt) {
			rt.printStackTrace();
			return null;
		}

	}
	
	public List<Client> getClientTotal(String from, String to) {
		// conn.open();
		List<Client> li = new ArrayList<Client>();
		String ko = "select jmbg_cl, first_name, last_name, phone, total FROM CLIENT where total>="+from+" and total<="+to;
		Statement st;

		try {
			st = conn.createStatement();
			ResultSet rd = st.executeQuery(ko);

			while (rd.next()) {
				Client kj = new Client(rd.getString("jmbg_cl"), rd.getString("first_name"), rd.getString("last_name"),
						rd.getString("phone"), rd.getDouble("total"));
				// System.out.println(rd.getString("name"));
				li.add(kj);
			}
			// rd.close();
			return li;
		} catch (SQLException rt) {
			rt.printStackTrace();
			return null;
		}

	}

	public void insertProduct(String name, double price, int quantity) {
		int id = findProductMaxId() + 1;
		Product p = new Product(id+"", name, price, quantity);
		String go = "insert into Product (id_prod, name, price, quantity) values(" + p.getId_prod() + ",'" + p.getName() + "'," + p.getPrice()
				+ "," + p.getQuantity() + ")";

		Statement st;

		try {
			st = conn.createStatement();
			st.executeUpdate(go);
		} catch (SQLException fs) {

		}
	}

	public int findProductMaxId() {
		String sql = "select max(id_prod) as max from Product;";
		Statement s;
		try {
			s = conn.createStatement();
			ResultSet result = s.executeQuery(sql);
			int id = 0;
			while (result.next()) {
				id = result.getInt("max");
			}
			result.close();
			return id;
		} catch (SQLException e) {
			return 0;
		}
	}

	public void insertClient(String jmbg, String firstName, String lastName, String phone) {
		Client cl = new Client(jmbg, firstName, lastName, phone, 0);
		String go = "insert into Client (jmbg_cl, first_name, last_name, phone) values('" + cl.getJmbg_cl() + "','" + cl.getFirstName()
				+ "','" + cl.getLastName() + "','" + cl.getPhone() + "')";

		Statement st;

		try {
			st = conn.createStatement();
			st.executeUpdate(go);
		} catch (SQLException fs) {
			fs.printStackTrace();
		}
	}

	public void insertEmployee(String jmbg, String firstName, String lastName, String phone, String address) {
		Employee e = new Employee(jmbg, firstName, lastName, phone, address);
		String go = "insert into Employee (jmbg_em, first_name, last_name, phone, address) values('" + e.getJmbg_em() + "','"
				+ e.getFirstName() + "','" + e.getLastName() + "','" + e.getPhone() + "','" + e.getAddress() + "')";

		Statement st;

		try {
			st = conn.createStatement();
			st.executeUpdate(go);
		} catch (SQLException fs) {
			fs.printStackTrace();
		}
	}

	public void insertSale(String jmbg_em, String jmbg_cl, String date, int quantity, int id_prod) {
		int id = findMaxSaleId() + 1;
		String go = "insert into Sale (id_sale, jmbg_em, jmbg_cl, date, quantity, id_prod) values(" + id + ",'"
				+ jmbg_em + "','" + jmbg_cl + "','" + date + "'," + quantity + "," + id_prod + ")";

		Statement st;

		try {
			st = conn.createStatement();
			st.executeUpdate(go);
		} catch (SQLException fs) {
			fs.printStackTrace();
		}
	}

	public void updateQuantity(int quantity, String id_prod) {
		String go = "update Product set quantity = " + (getBy(id_prod) - quantity) + " where id_prod=" + id_prod;

		Statement st;

		try {
			st = conn.createStatement();
			st.executeUpdate(go);
		} catch (SQLException fs) {
			fs.printStackTrace();
		}
	}

	public int getBy(String id_prod) {
		String go = "select quantity from Product where id_prod=" + id_prod;

		Statement st;

		try {
			st = conn.createStatement();
			ResultSet result = st.executeQuery(go);
			int id = 0;
			while (result.next()) {
				id = result.getInt("quantity");
			}
			result.close();
			return id;
		} catch (SQLException fs) {
			fs.printStackTrace();
			return 0;
		}
	}

	public void updateClient(String jmbg, double chan) {
		String upda = "update Client set total = " + chan + "where jmbg_cl='" + jmbg + "'";

		Statement st;

		try {
			st = conn.createStatement();
			st.executeUpdate(upda);
		} catch (SQLException fs) {
			fs.printStackTrace();
		}
	}

	public int selectTotal(String jmbg) {
		String sqla = "select total from Client where jmbg_cl=" + jmbg;
		Statement s;
		try {
			s = conn.createStatement();
			ResultSet result = s.executeQuery(sqla);
			int id = 0;
			while (result.next()) {
				id = result.getInt("total");
			}
			result.close();
			return id;
		} catch (SQLException e) {
			return 0;
		}
	}

	public double selectProductPriceDo(String idddd) {
		String sqla = "select price from Product where id_prod=" + idddd;
		Statement s;
		try {
			s = conn.createStatement();
			ResultSet result = s.executeQuery(sqla);
			double id = 0;
			while (result.next()) {
				id = result.getDouble("price");
			}
			result.close();
			return id;
		} catch (SQLException e) {
			return 0;
		}
	}

	public int findMaxSaleId() {
		String sql = "select max(id_sale) as max from Sale;";
		Statement s;
		try {
			s = conn.createStatement();
			ResultSet result = s.executeQuery(sql);
			int id = 0;
			while (result.next()) {
				id = result.getInt("max");
			}
			result.close();
			return id;
		} catch (SQLException e) {
			return 0;
		}
	}

	public int findId(String idprod) {
		String sql = "SELECT id_prod FROM Product WHERE id_prod = " + idprod + ";";
		Statement s;
		try {
			s = conn.createStatement();
			ResultSet result = s.executeQuery(sql);
			int id = 0;
			while (result.next()) {
				id = result.getInt("id_prod");
			}
			result.close();
			return id;
		} catch (SQLException e) {
			// System.out.println("Greska u upitu");
			return 0;
		}
	}

	public int findJmbgClient(String jmbg) {
		String sql = "SELECT jmbg_cl FROM Client WHERE jmbg_cl = '" + jmbg + "';";
		Statement s;
		try {
			s = conn.createStatement();
			ResultSet result = s.executeQuery(sql);
			int id = 0;
			while (result.next()) {
				// System.out.println(result.next());
				id = 1;
			}
			result.close();
			return id;
		} catch (SQLException e) {
			// System.out.println("Greska u upitu");
			return 0;
		}
	}

	public int findJmbgEmployee(String jmbg) {
		String sql = "SELECT jmbg_em FROM Employee WHERE jmbg_em = '" + jmbg + "';";
		Statement s;
		try {
			s = conn.createStatement();
			ResultSet result = s.executeQuery(sql);
			int id = 0;
			while (result.next()) {
				// System.out.println(result.next());
				id = 1;
			}
			result.close();
			return id;
		} catch (SQLException e) {
			// System.out.println("Greska u upitu");
			return 0;
		}
	}

	public boolean close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				return false;
			}
		}
		return true;
	}

}
