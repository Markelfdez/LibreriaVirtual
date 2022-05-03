package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Book;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class WindowTabShoppingCart extends JPanel {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnSearchBook;
	private JButton btnCleanCart;
	private JScrollPane scrollPane;
	private JTable tableShoppingCart;

	public WindowTabShoppingCart() {
		setLayout(null);
		
		contentPanel.setBounds(0, 0, 940, 500);
		add(contentPanel);
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(249, 230, 231));
		
		btnSearchBook = new JButton("Purchase");
		btnSearchBook.setBounds(280, 427, 89, 25);
		contentPanel.add(btnSearchBook);
		
		btnCleanCart = new JButton("Clean Cart");
		btnCleanCart.setBounds(560, 427, 89, 25);
		contentPanel.add(btnCleanCart);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(153, 38, 633, 366);
		contentPanel.add(scrollPane);
		
		tableShoppingCart = new JTable();
		scrollPane.setViewportView(tableShoppingCart);
		
		
			
		}
	}

