package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class WindowTabBookMember extends JPanel {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField fieldSearchBook;
	private JButton btnSearchBook;
	private JTable tableBooks;

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
		
		tableBooks = new JTable();
		tableBooks.setBounds(154, 64, 633, 380);
		contentPanel.add(tableBooks);
	}
}
