package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.BookControllerImplementation;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class WindowTabBookMember extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField fieldSearchBook;
	private JButton btnSearchBook;
	private JTable tableBooks;
	private JButton btnAddToShoppingCart;
	BookControllerImplementation aux;

	public WindowTabBookMember() {
		setLayout(null);
		
		contentPanel.setBounds(0, 0, 940, 500);
		add(contentPanel);
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(249, 230, 231));
		
		fieldSearchBook = new JTextField();
		fieldSearchBook.setColumns(10);
		fieldSearchBook.setBounds(154, 24, 427, 25);
		contentPanel.add(fieldSearchBook);
		
		btnSearchBook = new JButton("Search");
		btnSearchBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearchBook.setBounds(698, 24, 89, 25);
		contentPanel.add(btnSearchBook);
		
		JComboBox comboBoxBook = new JComboBox();
		comboBoxBook.setBounds(583, 24, 116, 25);
		contentPanel.add(comboBoxBook);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(154, 77, 633, 316);
		contentPanel.add(scrollPane);
		
		tableBooks = new JTable();
		scrollPane.setViewportView(tableBooks);
		
		btnAddToShoppingCart = new JButton("Add to shopping cart");
		btnAddToShoppingCart.setBounds(378, 404, 133, 23);
		contentPanel.add(btnAddToShoppingCart);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		spinner.setBounds(521, 405, 30, 20);
		contentPanel.add(spinner);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnAddToShoppingCart)) {
			aux.addBookToCart(null);
		}
		
	}
}
