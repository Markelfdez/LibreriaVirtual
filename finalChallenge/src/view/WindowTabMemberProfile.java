package view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class WindowTabMemberProfile extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tablePurchases;
	private JTextField textFieldName;
	private JTextField textFieldAddress;
	private JTextField textFieldUsername;
	private JTextField textFieldEmail;
	private JTextField textFieldPhone;
	private JTextField textFieldFavAuthor;
	private JTextField textFieldFavGenre;
	private JButton btnLogOut;
	private JTextField textFieldUser;

	public WindowTabMemberProfile() {
		setLayout(null);
		
		contentPanel.setBounds(0, 0, 940, 500);
		add(contentPanel);
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(249, 230, 231));
		
		JLabel lblUserIcon = new JLabel("");
		lblUserIcon.setIcon(new ImageIcon(WindowTabMemberProfile.class.getResource("/img/user.png")));
		lblUserIcon.setBounds(30, 30, 125, 125);
		contentPanel.add(lblUserIcon);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(221, 30, 85, 20);
		contentPanel.add(lblName);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(221, 80, 85, 20);
		contentPanel.add(lblUsername);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setBounds(221, 130, 85, 20);
		contentPanel.add(lblEmail);
		
		JLabel lblPurchases = new JLabel("Purchases");
		lblPurchases.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPurchases.setBounds(30, 248, 192, 30);
		contentPanel.add(lblPurchases);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(221, 180, 85, 20);
		contentPanel.add(lblAddress);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(30, 248, 880, 2);
		contentPanel.add(separator);
		
		JLabel lblFavouriteAuthor = new JLabel("Favourite Author");
		lblFavouriteAuthor.setBounds(475, 80, 85, 20);
		contentPanel.add(lblFavouriteAuthor);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(475, 30, 85, 20);
		contentPanel.add(lblPhone);
		
		JLabel lblFavouriteGenre = new JLabel("Favourite Genre");
		lblFavouriteGenre.setBounds(475, 130, 85, 20);
		contentPanel.add(lblFavouriteGenre);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(311, 30, 125, 20);
		contentPanel.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(311, 180, 125, 20);
		contentPanel.add(textFieldAddress);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setColumns(10);
		textFieldUsername.setBounds(311, 80, 125, 20);
		contentPanel.add(textFieldUsername);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(311, 130, 125, 20);
		contentPanel.add(textFieldEmail);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(560, 30, 125, 20);
		contentPanel.add(textFieldPhone);
		
		textFieldFavAuthor = new JTextField();
		textFieldFavAuthor.setColumns(10);
		textFieldFavAuthor.setBounds(560, 80, 125, 20);
		contentPanel.add(textFieldFavAuthor);
		
		textFieldFavGenre = new JTextField();
		textFieldFavGenre.setColumns(10);
		textFieldFavGenre.setBounds(560, 130, 125, 20);
		contentPanel.add(textFieldFavGenre);
		
		btnLogOut = new JButton("");
		btnLogOut.setIcon(new ImageIcon(WindowTabMember.class.getResource("/img/logOut.png")));
		btnLogOut.setBounds(880, 30, 30, 30);
		btnLogOut.addActionListener(this);
		contentPanel.add(btnLogOut);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(821, 214, 89, 23);
		contentPanel.add(btnDelete);
		
		JButton btnModify = new JButton("Modify");
		btnModify.setBounds(48, 214, 89, 23);
		contentPanel.add(btnModify);
		
		textFieldUser = new JTextField();
		textFieldUser.setBounds(30, 166, 125, 20);
		contentPanel.add(textFieldUser);
		textFieldUser.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 289, 880, 179);
		contentPanel.add(scrollPane);
		
		tablePurchases = new JTable();
		scrollPane.setViewportView(tablePurchases);
		tablePurchases.setModel(new DefaultTableModel(
				//TODO CARMEN AYUDA
			new Object[][] {
			},
			new String[] {
				"TITLE", "DATE", "AMOUNT"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnLogOut)) {
			JDialog dialog = (JDialog) SwingUtilities.getWindowAncestor(this);
			dialog.dispose();
		}
	}
}
