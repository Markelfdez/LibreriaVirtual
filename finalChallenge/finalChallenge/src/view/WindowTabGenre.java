package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import earlyVersions.PestanyaGenre;
import earlyVersions.PestanyaMember;

public class WindowTabGenre extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField fieldSearchGenre;
	private JTextField fieldCodeGenre;
	private JTextField fieldNameGenre;
	private JButton btnLogOut;
	
	public WindowTabGenre() {
		setLayout(null);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(249, 230, 231));
		contentPanel.setBounds(0, 0, 942, 556);
		add(contentPanel);
		
		fieldSearchGenre = new JTextField();
		fieldSearchGenre.setColumns(10);
		fieldSearchGenre.setBounds(189, 24, 443, 29);
		contentPanel.add(fieldSearchGenre);
		
		JButton btnSearchGenre = new JButton("Search");
		btnSearchGenre.setBounds(642, 26, 98, 25);
		contentPanel.add(btnSearchGenre);
		
		JLabel lblCodeGenre = new JLabel("Code");
		lblCodeGenre.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblCodeGenre.setBounds(189, 181, 52, 23);
		contentPanel.add(lblCodeGenre);
		
		fieldCodeGenre = new JTextField();
		fieldCodeGenre.setFont(new Font("Dialog", Font.PLAIN, 10));
		fieldCodeGenre.setColumns(10);
		fieldCodeGenre.setBounds(251, 184, 181, 20);
		contentPanel.add(fieldCodeGenre);
		
		JLabel lblNameGenre = new JLabel("Name\r\n");
		lblNameGenre.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNameGenre.setBounds(189, 292, 62, 23);
		contentPanel.add(lblNameGenre);
		
		fieldNameGenre = new JTextField();
		fieldNameGenre.setFont(new Font("Dialog", Font.PLAIN, 10));
		fieldNameGenre.setColumns(10);
		fieldNameGenre.setBounds(251, 295, 181, 20);
		contentPanel.add(fieldNameGenre);
		
		JButton btnModifyGenre = new JButton("Modify");
		btnModifyGenre.setBounds(426, 456, 98, 25);
		contentPanel.add(btnModifyGenre);
		
		JButton btnInsertGenre = new JButton("Insert");
		btnInsertGenre.setBounds(298, 456, 98, 25);
		contentPanel.add(btnInsertGenre);
		
		JButton btnDeleteGenre = new JButton("Delete\r\n");
		btnDeleteGenre.setBounds(549, 456, 98, 25);
		contentPanel.add(btnDeleteGenre);
		
		JList listGenre = new JList();
		listGenre.setBounds(511, 95, 276, 306);
		contentPanel.add(listGenre);
		
		JLabel lblFoto1AdminGenre = new JLabel("");
		lblFoto1AdminGenre.setIcon(new ImageIcon(PestanyaGenre.class.getResource("/img/Admin_genre2-removebg-preview.png")));
		lblFoto1AdminGenre.setBounds(10, 246, 243, 274);
		contentPanel.add(lblFoto1AdminGenre);
		
		JLabel lblFotos2AdminGenre = new JLabel("");
		lblFotos2AdminGenre.setIcon(new ImageIcon(PestanyaGenre.class.getResource("/img/Admin_genre-removebg-preview.png")));
		lblFotos2AdminGenre.setBounds(689, 292, 243, 238);
		contentPanel.add(lblFotos2AdminGenre);
		
		btnLogOut = new JButton("");
		btnLogOut.setIcon(new ImageIcon(PestanyaMember.class.getResource("/img/logOut.png")));
		btnLogOut.setBounds(862, 24, 30, 30);
		contentPanel.add(btnLogOut);
		btnLogOut.addActionListener(this);


	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}