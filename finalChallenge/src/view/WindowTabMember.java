package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;


public class WindowTabMember extends JPanel  implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JButton btnLogOut;
	private JTextField fieldSearchMember;
	
	public WindowTabMember() {
		setLayout(null);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(249, 230, 231));
		contentPanel.setBounds(0, 0, 942, 556);
		add(contentPanel);
		
		JList listMember = new JList();
		listMember.setBounds(189, 105, 549, 301);
		contentPanel.add(listMember);
		
		fieldSearchMember = new JTextField();
		fieldSearchMember.setColumns(10);
		fieldSearchMember.setBounds(189, 24, 443, 29);
		contentPanel.add(fieldSearchMember);
		
		JButton btnSearchMember = new JButton("Search");
		btnSearchMember.setBounds(642, 26, 98, 25);
		contentPanel.add(btnSearchMember);
		
		JButton btnDeleteMember = new JButton("Delete\r\n");
		btnDeleteMember.setBounds(426, 456, 98, 25);
		contentPanel.add(btnDeleteMember);
		
		JLabel lblFoto1AdminMember = new JLabel("");
		lblFoto1AdminMember.setIcon(new ImageIcon(WindowTabMember.class.getResource("/img/Admin_member-removebg-preview.png")));
		lblFoto1AdminMember.setBounds(10, 212, 246, 262);
		contentPanel.add(lblFoto1AdminMember);
		
		JLabel lblFoto2AdminMember = new JLabel("");
		lblFoto2AdminMember.setIcon(new ImageIcon(WindowTabMember.class.getResource("/img/Admin_member2-removebg-preview.png")));
		lblFoto2AdminMember.setBounds(686, 212, 246, 262);
		contentPanel.add(lblFoto2AdminMember);
		
		btnLogOut = new JButton("");
		btnLogOut.setIcon(new ImageIcon(WindowTabMember.class.getResource("/img/logOut.png")));
		btnLogOut.setBounds(862, 24, 30, 30);
		contentPanel.add(btnLogOut);
		btnLogOut.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnLogOut)) {
			JDialog dialog = (JDialog) SwingUtilities.getWindowAncestor(this);
			dialog.dispose();
		}
	}
}