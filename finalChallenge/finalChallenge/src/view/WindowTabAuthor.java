package view;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

import earlyVersions.PestanyaAuthor;
import earlyVersions.PestanyaMember;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowTabAuthor extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField fieldSearchAuthor;
	private JTextField fieldCodeAuthor;
	private JTextField fieldNameAuthor;
	private JTextField fieldSurnameAuthor;
	private JTextField fieldDeathDateAuthor;
	private JTextField fieldBirthDateAuthor;
	private JButton btnDeleteAuthor;
	private JButton btnLogOut;
	
	public WindowTabAuthor() {
		setLayout(null);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(249, 230, 231));
		contentPanel.setBounds(0, 0, 943, 562);
		add(contentPanel);
		
		fieldSearchAuthor = new JTextField();
		fieldSearchAuthor.setColumns(10);
		fieldSearchAuthor.setBounds(189, 24, 443, 29);
		contentPanel.add(fieldSearchAuthor);
		
		JButton btnSearchAuthor = new JButton("Search");
		btnSearchAuthor.setBounds(642, 26, 98, 25);
		contentPanel.add(btnSearchAuthor);
		
		JLabel lblCodeAuthor = new JLabel("Code");
		lblCodeAuthor.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblCodeAuthor.setBounds(110, 141, 52, 23);
		contentPanel.add(lblCodeAuthor);
		
		fieldCodeAuthor = new JTextField();
		fieldCodeAuthor.setFont(new Font("Dialog", Font.PLAIN, 10));
		fieldCodeAuthor.setColumns(10);
		fieldCodeAuthor.setBounds(201, 144, 181, 20);
		contentPanel.add(fieldCodeAuthor);
		
		JLabel lblNameAuthor = new JLabel("Name\r\n");
		lblNameAuthor.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNameAuthor.setBounds(111, 227, 62, 23);
		contentPanel.add(lblNameAuthor);
		
		JLabel lblSurnameAuthor = new JLabel("Surname");
		lblSurnameAuthor.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblSurnameAuthor.setBounds(110, 309, 77, 23);
		contentPanel.add(lblSurnameAuthor);
		
		JLabel lblBirthDateAuthor = new JLabel("Birth date");
		lblBirthDateAuthor.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblBirthDateAuthor.setBounds(511, 189, 106, 23);
		contentPanel.add(lblBirthDateAuthor);
		
		JLabel lblDeathDateAuthor = new JLabel("Death date");
		lblDeathDateAuthor.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblDeathDateAuthor.setBounds(511, 275, 77, 23);
		contentPanel.add(lblDeathDateAuthor);
		
		fieldNameAuthor = new JTextField();
		fieldNameAuthor.setFont(new Font("Dialog", Font.PLAIN, 10));
		fieldNameAuthor.setColumns(10);
		fieldNameAuthor.setBounds(201, 230, 181, 20);
		contentPanel.add(fieldNameAuthor);
		
		fieldSurnameAuthor = new JTextField();
		fieldSurnameAuthor.setFont(new Font("Dialog", Font.PLAIN, 10));
		fieldSurnameAuthor.setColumns(10);
		fieldSurnameAuthor.setBounds(201, 312, 181, 20);
		contentPanel.add(fieldSurnameAuthor);
		
		fieldDeathDateAuthor = new JTextField();
		fieldDeathDateAuthor.setFont(new Font("Dialog", Font.PLAIN, 10));
		fieldDeathDateAuthor.setColumns(10);
		fieldDeathDateAuthor.setBounds(618, 278, 181, 20);
		contentPanel.add(fieldDeathDateAuthor);
		
		JButton btnModifyAuthor = new JButton("Modify");
		btnModifyAuthor.setBounds(426, 456, 98, 25);
		contentPanel.add(btnModifyAuthor);
		
		JButton btnInsertAuthor = new JButton("Insert");
		btnInsertAuthor.setBounds(298, 456, 98, 25);
		contentPanel.add(btnInsertAuthor);
		
		btnDeleteAuthor = new JButton("Delete\r\n");
		btnDeleteAuthor.setBounds(549, 456, 98, 25);
		contentPanel.add(btnDeleteAuthor);
		
		fieldBirthDateAuthor = new JTextField();
		fieldBirthDateAuthor.setFont(new Font("Dialog", Font.PLAIN, 10));
		fieldBirthDateAuthor.setColumns(10);
		fieldBirthDateAuthor.setBounds(618, 193, 181, 20);
		contentPanel.add(fieldBirthDateAuthor);
		
		JLabel lblFoto1AdminAuthor = new JLabel("");
		lblFoto1AdminAuthor.setIcon(new ImageIcon(PestanyaAuthor.class.getResource("/img/Admin_author-removebg-preview.png")));
		lblFoto1AdminAuthor.setBounds(0, 227, 278, 268);
		contentPanel.add(lblFoto1AdminAuthor);
		
		JLabel lblFoto2AdminAuthor = new JLabel("");
		lblFoto2AdminAuthor.setIcon(new ImageIcon(PestanyaAuthor.class.getResource("/img/Admin_author2-removebg-preview.png")));
		lblFoto2AdminAuthor.setBounds(643, 252, 278, 268);
		contentPanel.add(lblFoto2AdminAuthor);
		
		btnLogOut = new JButton("");
		btnLogOut.setIcon(new ImageIcon(PestanyaMember.class.getResource("/img/logOut.png")));
		btnLogOut.setBounds(862, 24, 30, 30);
		contentPanel.add(btnLogOut);
		btnLogOut.addActionListener(this);


	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnLogOut)) {
			
		}
		
	}
}