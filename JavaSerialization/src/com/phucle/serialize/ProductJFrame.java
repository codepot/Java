package com.phucle.serialize;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProductJFrame extends JFrame {

	public ProductJFrame() {
		this.setTitle("Product Information");
		this.setSize(400, 320);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		Font font = new Font("Arial", Font.BOLD, 18);
		JButton btn_readProduct = new JButton("Read");
		JButton btn_writeProduct = new JButton("Write");
		JButton btn_exit = new JButton("Exit");
		JPanel textfield_panel = new JPanel(new FlowLayout());
		JTextField txt_id = new JTextField(20);
		JTextField txt_description = new JTextField(20);
		JTextField txt_manufacturer = new JTextField(20);
		JTextField txt_price = new JTextField(20);
		txt_id.setFont(font);
		txt_description.setFont(font);
		txt_manufacturer.setFont(font);
		txt_price.setFont(font);

		textfield_panel.add(new JLabel("Product ID:"));
		textfield_panel.add(txt_id);
		textfield_panel.add(new JLabel("Description:"));
		textfield_panel.add(txt_description);
		textfield_panel.add(new JLabel("Manufaturer:"));
		textfield_panel.add(txt_manufacturer);
		textfield_panel.add(new JLabel("Price:"));
		textfield_panel.add(txt_price);

		this.add(textfield_panel, BorderLayout.CENTER);

		JPanel button_panel = new JPanel();
		button_panel.add(btn_readProduct);
		button_panel.add(btn_writeProduct);
		button_panel.add(btn_exit);
		this.add(button_panel, BorderLayout.SOUTH);

		btn_exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int dialogResult = JOptionPane.showConfirmDialog(null,
						"Would You Like to exit the program?", "Warning",
						JOptionPane.NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		
		
		btn_readProduct.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Product product;
				try {
					product = ReadProductObject.readProduct();
					txt_id.setText(product.getProductID() + "");
					txt_description.setText(product.getDescription());
					txt_manufacturer.setText(product.getManufacturer());
					txt_price.setText(product.getPrice()+"");
				} catch (ClassNotFoundException | IOException e1) {
					JOptionPane.showMessageDialog(null, "Can not read product Information.\n Please check if file is existing.");
					e1.printStackTrace();
				}
				
			}
		});
		
		
		btn_writeProduct.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
			        int id = Integer.parseInt(txt_id.getText());
			        double price = Double.parseDouble(txt_price.getText());
			        Product product = new Product();
					product.setProductID(id);
					product.setDescription(txt_description.getText());
					product.setManufacturer(txt_manufacturer.getText());
					product.setPrice(price);
					WriteProductObject.writeProduct(product);
					JOptionPane.showMessageDialog(null, "Product was written.");
			      } catch (NumberFormatException e2) {
			    	  JOptionPane.showMessageDialog(null, "Can not write product Information.\n Please check if id or price is a valid number");
			      } catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Can not write product Information");
					e1.printStackTrace();
				}			
				
			}
		});
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
