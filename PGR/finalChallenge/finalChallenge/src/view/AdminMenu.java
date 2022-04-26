package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTabbedPane;

public class AdminMenu extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTabbedPane windowPanel;
	
	private WindowTabBook book;
	private WindowTabMember member;
	private WindowTabAuthor author;
	private WindowTabGenre genre;
	
	public AdminMenu(boolean modal) {
		this.setModal(modal);
		setTitle("Admin Menu");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminMenu.class.getResource("/img/pajaritoguay.jpg")));
		setBounds(100, 100, 942, 556);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
				
		
		windowPanels();
	}

	private void windowPanels() {
		windowPanel = new JTabbedPane();
		member = new WindowTabMember();
		author = new WindowTabAuthor();
		genre = new WindowTabGenre();
		book = new WindowTabBook();
		
		windowPanel.add("Book", book);
		windowPanel.add("Member", member);
		windowPanel.add("Author", author);
		windowPanel.add("Genre", genre);
		
		getContentPane().add(windowPanel);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
