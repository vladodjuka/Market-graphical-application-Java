package test;

import java.util.List;

import market.DataConn;
import market.Product;

public class Test {
	public void test() {
		DataConn dc = new DataConn("jdbc:mysql://localhost/programmingProject", "root", "");
		
		
		
		List<Product> li= dc.getProducts();
		 for (Product p : li) {
			Object[] hj = {p.getId_prod(), p.getName(), p.getPrice(), p.getQuantity()};
			
			System.out.println(p.getName()+" "+li.size());
			
			
		}
		
	}

}
