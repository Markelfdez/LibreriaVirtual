package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class SignUp extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPasswordField repeatPasswordField;
	private JTextField fieldMail;
	private JTextField fielUser;
	private JPasswordField passwordField1;
	private JTextField fieldAccount;
	private JTextField fieldPhone;
	private JTextField fieldAddress;
	private JComboBox cmbAuthor;
	private JComboBox cmbGenre;
	private JCheckBox cbxTerms;
	private JButton btnSignUp;
	private JButton btnGoBack;


	public SignUp(boolean modal) {
		this.setModal(modal);
		setTitle("Sign Up");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SignUp.class.getResource("/img/pajaritoguay.jpg")));
		setBounds(100, 100, 942, 556);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(190, 210, 209));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblMarketing = new JLabel("Sign up for free to read the best books!");
		lblMarketing.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarketing.setFont(new Font("Source Code Pro", Font.BOLD, 25));
		lblMarketing.setBounds(10, 68, 906, 55);
		contentPanel.add(lblMarketing);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Source Code Pro", Font.PLAIN, 15));
		lblUsername.setBounds(67, 170, 94, 23);
		contentPanel.add(lblUsername);
		
		JLabel lblCopy = new JLabel(" \u00A9");
		lblCopy.setBounds(569, 18, 46, 39);
		contentPanel.add(lblCopy);
		
		JLabel lblTitle = new JLabel("Chapters and Verses");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Script MT Bold", Font.BOLD, 25));
		lblTitle.setBounds(10, 11, 906, 69);
		contentPanel.add(lblTitle);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Source Code Pro", Font.PLAIN, 15));
		lblEmail.setBounds(67, 224, 94, 23);
		contentPanel.add(lblEmail);
		
		JLabel lblPasswd = new JLabel("Password");
		lblPasswd.setFont(new Font("Source Code Pro", Font.PLAIN, 15));
		lblPasswd.setBounds(67, 277, 94, 23);
		contentPanel.add(lblPasswd);
		
		JLabel lblRepPassw = new JLabel("Repeat password");
		lblRepPassw.setFont(new Font("Source Code Pro", Font.PLAIN, 15));
		lblRepPassw.setBounds(67, 334, 143, 23);
		contentPanel.add(lblRepPassw);
		
		repeatPasswordField = new JPasswordField();
		repeatPasswordField.setFont(new Font("Source Code Pro", Font.PLAIN, 10));
		repeatPasswordField.setBounds(220, 336, 181, 20);
		contentPanel.add(repeatPasswordField);
		
		fieldMail = new JTextField();
		fieldMail.setFont(new Font("Source Code Pro", Font.PLAIN, 10));
		fieldMail.setColumns(10);
		fieldMail.setBounds(219, 226, 181, 20);
		contentPanel.add(fieldMail);
		
		fielUser = new JTextField();
		fielUser.setFont(new Font("Source Code Pro", Font.PLAIN, 10));
		fielUser.setColumns(10);
		fielUser.setBounds(219, 172, 181, 20);
		contentPanel.add(fielUser);
		
		passwordField1 = new JPasswordField();
		passwordField1.setFont(new Font("Source Code Pro", Font.PLAIN, 10));
		passwordField1.setBounds(220, 279, 181, 20);
		contentPanel.add(passwordField1);
		
		JLabel lblNewLabel = new JLabel("This field can\u00B4t be modified.");
		lblNewLabel.setBounds(220, 192, 181, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Source Code Pro", Font.PLAIN, 15));
		lblAddress.setBounds(481, 170, 94, 23);
		contentPanel.add(lblAddress);
		
		JLabel lblPhone = new JLabel("Phone number");
		lblPhone.setFont(new Font("Source Code Pro", Font.PLAIN, 15));
		lblPhone.setBounds(481, 224, 114, 23);
		contentPanel.add(lblPhone);
		
		JLabel lblAccountNum = new JLabel("Account number");
		lblAccountNum.setFont(new Font("Source Code Pro", Font.PLAIN, 15));
		lblAccountNum.setBounds(481, 277, 134, 23);
		contentPanel.add(lblAccountNum);
		
		JLabel lblPreferencesA = new JLabel("Favourite author");
		lblPreferencesA.setFont(new Font("Source Code Pro", Font.PLAIN, 15));
		lblPreferencesA.setBounds(481, 334, 159, 23);
		contentPanel.add(lblPreferencesA);
		
		JLabel lblPreferencesG = new JLabel("Favourite Genre");
		lblPreferencesG.setFont(new Font("Source Code Pro", Font.PLAIN, 15));
		lblPreferencesG.setBounds(663, 334, 143, 23);
		contentPanel.add(lblPreferencesG);
		
		cmbAuthor = new JComboBox();
		cmbAuthor.setBounds(481, 368, 143, 20);
		cmbAuthor.addActionListener(this);
		contentPanel.add(cmbAuthor);
		
		cmbGenre = new JComboBox();
		cmbGenre.setBounds(663, 368, 143, 20);
		cmbAuthor.addActionListener(this);
		contentPanel.add(cmbGenre);
		
		fieldAccount = new JTextField();
		fieldAccount.setFont(new Font("Source Code Pro", Font.PLAIN, 10));
		fieldAccount.setColumns(10);
		fieldAccount.setBounds(625, 277, 181, 20);
		contentPanel.add(fieldAccount);
		
		fieldPhone = new JTextField();
		fieldPhone.setFont(new Font("Source Code Pro", Font.PLAIN, 10));
		fieldPhone.setColumns(10);
		fieldPhone.setBounds(625, 226, 181, 20);
		contentPanel.add(fieldPhone);
		
		fieldAddress = new JTextField();
		fieldAddress.setFont(new Font("Source Code Pro", Font.PLAIN, 10));
		fieldAddress.setColumns(10);
		fieldAddress.setBounds(625, 172, 181, 20);
		contentPanel.add(fieldAddress);
		
		cbxTerms = new JCheckBox("I have read and accept the terms and conditions of use.");
		cbxTerms.setHorizontalAlignment(SwingConstants.CENTER);
		cbxTerms.setBounds(285, 427, 325, 23);
		contentPanel.add(cbxTerms);
		cbxTerms.setOpaque(false);
		cbxTerms.addActionListener(this);
		
		btnSignUp = new JButton("Sign up");
		btnSignUp.setBounds(390, 457, 89, 23);
		contentPanel.add(btnSignUp);
		btnSignUp.addActionListener(this);
		
		btnGoBack = new JButton("");
		btnGoBack.setIcon(new ImageIcon(SignUp.class.getResource("/img/arrowBienHecha.png")));
		btnGoBack.setBounds(67, 457, 89, 23);
		contentPanel.add(btnGoBack);
		btnGoBack.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnGoBack)) {
			this.dispose();
		}
		
	}
}
