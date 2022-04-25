package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LogInFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fieldUsername;
	private JPasswordField passwordField;
	private JButton btnLogIn;
	private JButton btnSignUp;
	
	public LogInFrame() {
		setTitle("Inicio\r\n");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\1dami\\Downloads\\pajaritoguay.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 942, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCopy = new JLabel(" \u00A9");
		lblCopy.setBounds(762, 29, 46, 39);
		contentPane.add(lblCopy);
		
		btnLogIn = new JButton("Log In");
		btnLogIn.setFont(new Font("Source Code Pro", Font.BOLD, 12));
		btnLogIn.setBounds(465, 273, 89, 23);
		btnLogIn.addActionListener(this);
		contentPane.add(btnLogIn);
		
		
		btnSignUp = new JButton("Sign Up");
		btnSignUp.setFont(new Font("Source Code Pro", Font.BOLD, 12));
		btnSignUp.setBounds(682, 273, 89, 23);
		btnSignUp.addActionListener(this);
		contentPane.add(btnSignUp);


		JLabel lblTitle = new JLabel("Chapters and Verses");
		lblTitle.setFont(new Font("Script MT Bold", Font.BOLD, 35));
		lblTitle.setBounds(465, 19, 352, 83);
		contentPane.add(lblTitle);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.LIGHT_GRAY);
		passwordField.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		passwordField.setToolTipText("");
		passwordField.setBounds(465, 232, 306, 30);
		contentPane.add(passwordField);
		
		JLabel lblPasswd = new JLabel("Password");
		lblPasswd.setFont(new Font("Source Code Pro", Font.BOLD, 18));
		lblPasswd.setBackground(Color.WHITE);
		lblPasswd.setBounds(567, 195, 110, 39);
		contentPane.add(lblPasswd);
		
		fieldUsername = new JTextField();
		fieldUsername.setForeground(Color.LIGHT_GRAY);
		fieldUsername.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		fieldUsername.setText("Insert username");
		fieldUsername.setBounds(465, 154, 306, 30);
		contentPane.add(fieldUsername);
		fieldUsername.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username\r\n");
		lblNewLabel.setFont(new Font("Source Code Pro", Font.BOLD, 18));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(567, 113, 110, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setFont(new Font("Verdana", Font.BOLD, 15));
		lblFondo.setIcon(new ImageIcon(LogInFrame.class.getResource("/img/book-quotes-1531945007.jpg")));
		lblFondo.setBounds(0, 0, 926, 517);
		contentPane.add(lblFondo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnSignUp)) {
			SignUp registro = new SignUp(true);
			registro.setVisible(true);
		}
		
		if(e.getSource().equals(btnLogIn)) {
			AdminMenu admin = new AdminMenu();
			admin.setVisible(true);
		}
		
	}
}
