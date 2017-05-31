package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import market.Client;
import market.DataConn;
import market.Product;
import market.Sale;

import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.Rectangle;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnAddClient;
	private JButton btnAddEmployee;
	private JButton btnSale;
	private JButton btnShowSalesBu;
	private JButton btnShowClients;
	private JButton btnShowProducts;
	private JTable table;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	private JFrame frame;
	private JPanel panel;
	private JLabel lblProducts;
	private DataConn dc;
	private JScrollPane js;
	private JLabel label;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnFilter;
	private JLabel lblStartDate;
	private JLabel lblEndDate;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnNewButton_1());
		contentPane.add(getTextField_1());
		contentPane.add(getBtnFilter());
		contentPane.add(getLblEndDate());
		contentPane.add(getLblStartDate());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnAddClient());
		contentPane.add(getBtnAddEmployee());
		contentPane.add(getBtnSale());
		contentPane.add(getBtnShowSalesBu());
		contentPane.add(getBtnShowClients());
		contentPane.add(getBtnShowProducts());
		contentPane.add(getPanel());
		getPanel().setLayout(null);
		contentPane.add(getLblProducts());
		contentPane.add(getTextField());
		contentPane.add(getLabel());

		js = new JScrollPane();
		js.setViewportView(getTable_1("products"));
		js.setBounds(new Rectangle(0, 0, 597, 295));
		panel.add(js);

		// The 0 argument is number rows.

		// table = new JTable(tableModel);

	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("ADD PRODUCT");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					AddUnv bm = new AddUnv(btnNewButton.getText());
					bm.setVisible(true);

					bm.setLocationRelativeTo(null);
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnNewButton.setBounds(616, 55, 162, 44);
		}
		return btnNewButton;
	}

	private JButton getBtnAddClient() {
		if (btnAddClient == null) {
			btnAddClient = new JButton("ADD CLIENT");
			btnAddClient.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AddUnv bm = new AddUnv(btnAddClient.getText());
					bm.setVisible(true);
					// bm.pack();
					bm.setLocationRelativeTo(null);
				}
			});
			btnAddClient.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnAddClient.setBounds(616, 97, 162, 44);
		}
		return btnAddClient;
	}

	private JButton getBtnAddEmployee() {
		if (btnAddEmployee == null) {
			btnAddEmployee = new JButton("ADD EMPLOYEE");
			btnAddEmployee.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					AddUnv bm = new AddUnv(btnAddEmployee.getText());
					bm.setVisible(true);

					bm.setLocationRelativeTo(null);
				}
			});
			btnAddEmployee.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnAddEmployee.setBounds(616, 139, 162, 44);
		}
		return btnAddEmployee;
	}

	private JButton getBtnSale() {
		if (btnSale == null) {
			btnSale = new JButton("SALE");
			btnSale.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					AddUnv bm = new AddUnv(btnSale.getText());
					bm.setVisible(true);

					bm.setLocationRelativeTo(null);
				}
			});
			btnSale.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnSale.setBounds(616, 181, 162, 44);
		}
		return btnSale;
	}

	private JButton getBtnShowSalesBu() {
		if (btnShowSalesBu == null) {
			btnShowSalesBu = new JButton("SHOW SALES BY DATE");
			btnShowSalesBu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					lblProducts.setText("SALE");
					js.remove(table);
					js.setViewportView(getTable_1("sale"));
					lblStartDate.setText("start date");
					lblEndDate.setText("end date");
				}
			});
			btnShowSalesBu.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnShowSalesBu.setBounds(616, 222, 162, 44);
		}
		return btnShowSalesBu;
	}

	private JButton getBtnShowClients() {
		if (btnShowClients == null) {
			btnShowClients = new JButton("SHOW CLIENTS");
			btnShowClients.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					lblProducts.setText("CLIENTS");

					js.remove(table);
					js.setViewportView(getTable_1("clients"));
					// getTable_1("clients");
					// js.setViewportView(getTable_1("clients"));
					// panel.repaint();
					// js.repaint();
					// table.repaint();
				}
			});
			btnShowClients.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnShowClients.setBounds(616, 264, 162, 44);
		}
		return btnShowClients;
	}

	private JButton getBtnShowProducts() {
		if (btnShowProducts == null) {
			btnShowProducts = new JButton("SHOW PRODUCTS");
			btnShowProducts.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					lblProducts.setText("PRODUCTS");
					// lblClients.setVisible(false);
					js.setViewportView(getTable_1("products"));
					panel.repaint();
				}
			});
			btnShowProducts.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnShowProducts.setBounds(616, 306, 162, 44);

		}
		return btnShowProducts;
	}

	private JTable getTable_1(String text) {

		String col[];
		if (table == null || table != null) {
			dc = new DataConn("jdbc:mysql://localhost/programmingProject", "root", "");
			if (text.equals("products")) {

				lblStartDate.setVisible(false);
				lblEndDate.setVisible(false);
				textField.setVisible(false);
				textField_1.setVisible(false);

				btnFilter.setVisible(false);
				btnNewButton_1.setVisible(false);

				col = new String[] { "Product ID", "Name", "Price", "Quantity" };

				tableModel = new DefaultTableModel(col, 0);

				List<Product> li = dc.getProducts();
				for (Product p : li) {
					Object[] hj = { p.getId_prod(), p.getName(), p.getPrice(), p.getQuantity() };
					tableModel.addRow(hj);

				}

			}

			if (text.equals("clients")) {
				// System.out.println("TO JE TO DA");
				col = new String[] { "Client JMBG", "First Name", "Last Name", "Phone", "Total" };

				tableModel = new DefaultTableModel(col, 0);

				List<Client> li = dc.getClients();
				for (Client w : li) {
					//System.out.println(w);
					Object[] xz = { w.getJmbg_cl(), w.getFirstName(), w.getLastName(), w.getPhone(), w.getTotal() };
					tableModel.addRow(xz);
				}
				lblStartDate.setVisible(true);
				lblEndDate.setVisible(true);
				textField.setVisible(true);
				textField_1.setVisible(true);
				lblStartDate.setText("From: ");
				lblEndDate.setText("To:");

				btnFilter.setVisible(false);
				btnNewButton_1.setVisible(true);
			}

			if (text.equals("sale")) {
				// System.out.println("TO JE TO DA");
				col = new String[] { "Sale ID", "Product ID", "Client JMBG", "Employee JMBG", "DATE", "QUANTITY" };

				tableModel = new DefaultTableModel(col, 0);

				List<Sale> li = dc.getSale();
				for (Sale w : li) {
					Object[] xz = { w.getId_sale(), w.getId_prod(), w.getJmbg_cl(), w.getJmbg_em(), w.getDate(),
							w.getQuantity() };
					tableModel.addRow(xz);
				}
				lblStartDate.setVisible(true);
				lblEndDate.setVisible(true);
				textField.setVisible(true);
				textField_1.setVisible(true);

				btnFilter.setVisible(true);
				btnNewButton_1.setVisible(false);
			}

			if (text.equals("sale filter")) {
				btnNewButton_1.setVisible(false);

				col = new String[] { "Sale ID", "Product ID", "Client JMBG", "Employee JMBG", "DATE", "QUANTITY" };

				tableModel = new DefaultTableModel(col, 0);

				boolean date1 = textField.getText().matches("\\d{4}-\\d{2}-\\d{2}")
						|| textField.getText().matches("\\d{4}/\\d{2}/\\d{2}");
				boolean date2 = textField_1.getText().matches("\\d{4}-\\d{2}-\\d{2}")
						|| textField_1.getText().matches("\\d{4}/\\d{2}/\\d{2}");

				if(date1 && date2){
				List<Sale> li = dc.getSaleFilter(textField.getText(), textField_1.getText());
				textField.setText("");
				textField_1.setText("");
				for (Sale w : li) {
					Object[] xz = { w.getId_sale(), w.getId_prod(), w.getJmbg_cl(), w.getJmbg_em(), w.getDate(),
							w.getQuantity() };
					tableModel.addRow(xz);
				
				}
			}
				else{ 
					JOptionPane.showMessageDialog(frame, "Date must be in format YEAR(4)-MONTH(2)-DAY(2) OR YEAR(4)/MONTH(2)/DAY(2)", "Date Eror", JOptionPane.WARNING_MESSAGE);
				}
			}
			
			if(text.equals("calculate total")){ 
				col = new String[] { "Client JMBG", "First Name", "Last Name", "Phone", "Total" };

				tableModel = new DefaultTableModel(col, 0);
				if(textField.getText().equalsIgnoreCase("")|| textField_1.getText().equalsIgnoreCase("")){
					textField.setText("0");
					textField_1.setText("0");
				}
				
				List<Client> li = dc.getClientTotal(textField.getText(), textField_1.getText());
				for (Client w : li) {
					
					Object[] xz = { w.getJmbg_cl(), w.getFirstName(), w.getLastName(), w.getPhone(), w.getTotal() };
					tableModel.addRow(xz);
				}
				lblStartDate.setText("From: ");
				lblEndDate.setText("To:");
				
				textField.setText("");
				textField_1.setText("");

				btnFilter.setVisible(false);
				btnNewButton_1.setVisible(true);
				
			}

			
			table = new JTable(tableModel);
			// ******************************
			table.setBorder(UIManager.getBorder("Button.border"));
			table.setShowVerticalLines(false);
			table.setFillsViewportHeight(true);
			DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
			rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
			table.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
			table.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
			table.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
			table.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
			if (table.getColumnCount() > 4) {
				table.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
				if (table.getColumnCount() > 5) {
					table.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
					if (table.getColumnCount() > 6) {
						table.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
					}
				}
			}
			
			table.setBounds(0, 11, 1840, 273);
			table.repaint();
			dc.close();
			

		}
		return table;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(10, 55, 607, 295);
		}
		return panel;
	}

	private JLabel getLblProducts() {
		if (lblProducts == null) {
			lblProducts = new JLabel("PRODUCTS");
			lblProducts.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblProducts.setBounds(10, 25, 102, 23);
		}
		return lblProducts;
	}

	private JLabel getLabel() {
		if (label == null) {
			ImageIcon image = new ImageIcon("bitcoin-logo-cyan.png");

			label = new JLabel(image);
			label.setBounds(0, 0, 788, 361);
		}
		return label;
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(259, 24, 86, 20);
			textField.setColumns(10);
		}
		return textField;
	}

	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(406, 23, 86, 20);
		}
		return textField_1;
	}

	private JButton getBtnFilter() {
		if (btnFilter == null) {
			btnFilter = new JButton("FILTER");
			btnFilter.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					js.remove(table);
					js.setViewportView(getTable_1("sale filter"));
				}
			});
			btnFilter.setBounds(502, 21, 89, 23);
		}
		return btnFilter;
	}

	private JLabel getLblStartDate() {
		if (lblStartDate == null) {
			lblStartDate = new JLabel("start date");
			lblStartDate.setBounds(200, 25, 59, 19);
		}
		return lblStartDate;
	}

	private JLabel getLblEndDate() {
		if (lblEndDate == null) {
			lblEndDate = new JLabel("end date");
			lblEndDate.setBounds(355, 25, 59, 19);
		}
		return lblEndDate;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("CALCULATE TOTAL");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					js.remove(table);
					js.setViewportView(getTable_1("calculate total"));
				}
			});
			btnNewButton_1.setBounds(616, 11, 162, 34);
		}
		return btnNewButton_1;
	}
}
