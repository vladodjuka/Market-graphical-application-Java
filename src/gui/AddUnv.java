package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import market.DataConn;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class AddUnv extends JFrame {

	private JPanel contentPane;
	private JLabel label;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JTextField textField_1;
	private JLabel lblName;
	private JTextField textField_2;
	private JLabel lblPrice;
	private JLabel lblQuantity;
	private JTextField textField_3;
	private JButton btnSubmit;
	private JLabel lblAddress;
	private JTextField textField_4;
	private String te;
	private DataConn dc;
	private JFrame frame;

	public AddUnv(String tekst) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 341, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLabel());
		contentPane.add(getTextField());
		contentPane.add(getLblNewLabel());
		contentPane.add(getTextField_1());
		contentPane.add(getLblName());
		contentPane.add(getTextField_2());
		contentPane.add(getLblPrice());
		contentPane.add(getLblQuantity());
		contentPane.add(getTextField_3());
		contentPane.add(getBtnSubmit());
		contentPane.add(getLblAddress());
		contentPane.add(getTextField_4());
		lblAddress.setVisible(false);
		textField_4.setVisible(false);
		lblNewLabel.setVisible(false);
		textField.setVisible(false);
		label.setText(tekst);
		te = tekst;
		frame = this;
		changeRole();
		//
		// if(tekst.equalsIgnoreCase("ADD PRODUCT")){
		// lblName.setText("NAME");
		//
		// }
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setFont(new Font("Tahoma", Font.BOLD, 18));
			label.setBounds(101, 31, 148, 22);
		}
		return label;
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(101, 64, 148, 20);
			textField.setColumns(10);
		}
		return textField;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Product id");
			lblNewLabel.setBounds(10, 68, 77, 14);
		}
		return lblNewLabel;
	}

	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(101, 90, 148, 20);
		}
		return textField_1;
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("NAME");
			lblName.setBounds(10, 93, 92, 14);
		}
		return lblName;
	}

	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(101, 115, 148, 20);
		}
		return textField_2;
	}

	private JLabel getLblPrice() {
		if (lblPrice == null) {
			lblPrice = new JLabel("PRICE");
			lblPrice.setBounds(10, 118, 92, 14);
		}
		return lblPrice;
	}

	private JLabel getLblQuantity() {
		if (lblQuantity == null) {
			lblQuantity = new JLabel("Quantity");
			lblQuantity.setBounds(10, 143, 65, 14);
		}
		return lblQuantity;
	}

	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(101, 140, 148, 20);
		}
		return textField_3;
	}

	private JButton getBtnSubmit() {
		if (btnSubmit == null) {
			btnSubmit = new JButton("SUBMIT");
			btnSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dc = new DataConn("jdbc:mysql://localhost/programiranjeProjekat", "root", "");
					if (te.equalsIgnoreCase("ADD PRODUCT")) {

						double ad = 0;
						int ij = 0;
						try {
							ad = Double.parseDouble(textField_2.getText());
							ij = Integer.parseInt(textField_3.getText());
						} catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(frame, "Wrong insert value. Please, check and try again.",
									"Eror", JOptionPane.WARNING_MESSAGE);
						}
						if (ad != 0 && ij != 0) {
							dc.insertProduct(textField_1.getText(), ad, ij);
							JOptionPane.showMessageDialog(frame, "Succesful insert", "JO",
									JOptionPane.INFORMATION_MESSAGE);
							clearAll();
						}
					}

					if (te.equalsIgnoreCase("ADD CLIENT")) {

						if (textField.getText().equals("") || textField_1.getText().equals("")
								|| textField_2.getText().equals("") || textField_3.getText().equals("")) {
							JOptionPane.showMessageDialog(frame, "Wrong insert value. Please, check and try again.",
									"Eror", JOptionPane.WARNING_MESSAGE);
						} else {
							boolean atleastOne = textField.getText().matches(".*[a-zA-Z]+.*");
							if (!atleastOne) {
								if (textField.getText().length() != 13) {
									JOptionPane.showMessageDialog(frame, "JMBG must be 13 characters.", "Eror",
											JOptionPane.WARNING_MESSAGE);
								}

								else {
									dc.insertClient(textField.getText(), textField_1.getText(), textField_2.getText(),
											textField_3.getText());
									JOptionPane.showMessageDialog(frame, "Succesful insert", "Everything Good",
											JOptionPane.INFORMATION_MESSAGE);

									clearAll();

								}
							} else {
								JOptionPane.showMessageDialog(frame, "JMBG must contain only numbers", "Eror",
										JOptionPane.WARNING_MESSAGE);
							}
						}

					}

					if (te.equalsIgnoreCase("ADD EMPLOYEE")) {

						if (textField.getText().equals("") || textField_1.getText().equals("")
								|| textField_2.getText().equals("") || textField_3.getText().equals("")
								|| textField_4.getText().equals("")) {
							JOptionPane.showMessageDialog(frame, "Wrong insert value. Please, check and try again.",
									"Eror", JOptionPane.WARNING_MESSAGE);
						} else {
							boolean atleastOne = textField.getText().matches(".*[a-zA-Z]+.*"); // JMBG
							boolean phone = textField_3.getText().matches(".*[a-zA-Z]+.*"); // phone
							if (!atleastOne && !phone) {
								if (textField.getText().length() != 13) {
									JOptionPane.showMessageDialog(frame, "JMBG must be 13 characters.", "Eror",
											JOptionPane.WARNING_MESSAGE);
								}

								else {
									dc.insertEmployee(textField.getText(), textField_1.getText(), textField_2.getText(),
											textField_3.getText(), textField_4.getText());
									JOptionPane.showMessageDialog(frame, "Succesful insert", "Everything Good",
											JOptionPane.INFORMATION_MESSAGE);

									clearAll();

								}
							} else {
								JOptionPane.showMessageDialog(frame, "JMBG and PHONE must contain only numbers", "Eror",
										JOptionPane.WARNING_MESSAGE);
							}
						}

					}
					if (te.equalsIgnoreCase("SALE")) {

						if (textField.getText().equals("") || textField_1.getText().equals("")
								|| textField_2.getText().equals("") || textField_3.getText().equals("")) {
							JOptionPane.showMessageDialog(frame, "Wrong insert value. Please, check and try again.",
									"Eror", JOptionPane.WARNING_MESSAGE);
						} else {
							boolean id = textField.getText().matches("\\d+");
							boolean jmbg1 = textField_1.getText().matches("\\d+");
							boolean jmbg2 = textField_2.getText().matches("\\d+");
							boolean quantity = textField_3.getText().matches("\\d+");
							DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
							Date date = new Date();
							textField_4.setText(dateFormat.format(date)); // Sale
																			// Date
							boolean dateaa = textField_4.getText().matches("\\d{4}-\\d{2}-\\d{2}");

							

							if (id && jmbg1 && jmbg2 && quantity && dateaa) {
								if (textField_1.getText().length() != 13 || textField_2.getText().length() != 13) {
									JOptionPane.showMessageDialog(frame, "JMBG must be 13 characters.", "Eror",
											JOptionPane.WARNING_MESSAGE);
								}

								else {
									
									if (dc.findJmbgClient(textField_2.getText()) == 0
											|| dc.findJmbgEmployee(textField_1.getText()) == 0) {
										if (dc.findJmbgClient(textField_2.getText()) == 0) {
											JOptionPane.showMessageDialog(frame,
													"Client JMBG doesn't exist in our database. Check again.", "Eror",
													JOptionPane.WARNING_MESSAGE);
										} else {
											JOptionPane.showMessageDialog(frame,
													"Employee JMBG doesn't exist in our database. Check again.", "Eror",
													JOptionPane.WARNING_MESSAGE);
										}
										
									}

									else {
										if (dc.findId(textField.getText()) == 0) {
											JOptionPane.showMessageDialog(frame,
													"That product doesn't exist in our database.", "Eror",
													JOptionPane.WARNING_MESSAGE);
										} else {
											int hw = dc.getBy(textField.getText());
											if (hw == 0 || hw < Integer.parseInt(textField_3.getText())) {
												JOptionPane.showMessageDialog(frame,
														"We dont't have that many products in our database.", "Eror",
														JOptionPane.WARNING_MESSAGE);
											} else {

												int quan = Integer.parseInt(textField_3.getText());
												int id_pr = Integer.parseInt(textField.getText());
												dc.insertSale(textField_1.getText(), textField_2.getText(),
														textField_4.getText(), quan, id_pr);
												dc.updateQuantity(quan, textField.getText());
												// dc.insertEmployee(textField.getText(),
												// textField_1.getText(),textField_2.getText(),textField_3.getText(),
												// textField_4.getText());
												JOptionPane.showMessageDialog(frame, "Succesful insert",
														"Everything Good", JOptionPane.INFORMATION_MESSAGE);
												double tota = (quan * dc.selectProductPriceDo(textField.getText()))
														+ dc.selectTotal(textField_2.getText());
												//System.out.println("TOTA: " + tota + "  total: "
														//+ dc.selectTotal(textField_2.getText()));
												if (tota > 100 && tota <= 500) {
													tota -= ((quan * dc.selectProductPriceDo(textField.getText())) * 10
															/ 100);
												}
												if (tota > 500) {
													tota -= ((quan * dc.selectProductPriceDo(textField.getText())) * 20
															/ 100);
												}
												dc.updateClient(textField_2.getText(), tota);
												clearAll();
											}
										}
									}

								}
							} else {
								JOptionPane.showMessageDialog(frame,
										"Check if numeric values are correctly inserted. Date must bein format: YEAR(4)-MONTH(2)-DAY(2)",
										"Eror", JOptionPane.WARNING_MESSAGE);
							}
						}

					}
					dc.close();
				}
			});
			btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnSubmit.setBounds(101, 215, 148, 23);
		}
		return btnSubmit;

	}

	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address");
			lblAddress.setBounds(10, 168, 65, 14);
		}
		return lblAddress;
	}

	private JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(101, 165, 148, 20);
		}
		return textField_4;
	}

	public void changeRole() {
		if (te.equalsIgnoreCase("ADD PRODUCT")) {
			textField.setVisible(false);
			textField_1.setVisible(true);
			textField_2.setVisible(true);
			textField_3.setVisible(true);
			textField_4.setVisible(false);
			// date.setVisible(false);
			// textField_5.setVisible(false);
			lblNewLabel.setVisible(false);
			btnSubmit.setBounds(101, 187, 148, 23);

		}
		if (te.equalsIgnoreCase("ADD CLIENT")) {
			textField.setVisible(true);
			textField_1.setVisible(true);
			textField_2.setVisible(true);
			textField_3.setVisible(true);
			textField_4.setVisible(false);
			// date.setVisible(false);
			// textField_5.setVisible(false);
			lblNewLabel.setVisible(true);
			lblNewLabel.setText("JMBG");
			lblName.setText("First Name");
			lblPrice.setText("Last Name");
			lblQuantity.setText("Phone");
			btnSubmit.setBounds(101, 187, 148, 23);

		}
		if (te.equalsIgnoreCase("ADD EMPLOYEE")) {
			textField.setVisible(true);
			textField_1.setVisible(true);
			textField_2.setVisible(true);
			textField_3.setVisible(true);
			textField_4.setVisible(true);
			lblAddress.setVisible(true);
			// date.setVisible(false);
			// textField_5.setVisible(false);
			lblNewLabel.setVisible(true);
			lblNewLabel.setText("JMBG");
			lblName.setText("First Name");
			lblPrice.setText("Last Name");
			lblQuantity.setText("Phone");
			btnSubmit.setBounds(101, 197, 148, 23);
		}

		if (te.equalsIgnoreCase("SALE")) {
			textField.setVisible(true);
			textField_1.setVisible(true);
			textField_2.setVisible(true);
			textField_3.setVisible(true);
			textField_4.setVisible(false);
			lblAddress.setVisible(false);
			lblNewLabel.setVisible(true);
			// lblNewLabel.setText("JMBG CLIENT");
			lblName.setText("JMBG EMPLOYEE");
			lblPrice.setText("JMBG CLIENT");
			// lblQuantity.setText()
			lblAddress.setText("Date");
			btnSubmit.setBounds(101, 227, 148, 23);

			textField_1.setBounds(121, 90, 148, 20);
			lblName.setBounds(10, 93, 192, 14);
		}
	}

	public void clearAll() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
	}
}
