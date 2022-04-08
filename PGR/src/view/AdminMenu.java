package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

public class AdminMenu extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTabbedPane pestanya;
	
	private PestanyaBook book;
	private PestanyaMember member;
	private PestanyaAuthor author;
	private PestanyaGenre genre;
	
	public AdminMenu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminMenu.class.getResource("/img/pajaritoguay.jpg")));
		setBounds(100, 100, 490, 428);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
				
		
		iniciarPestanyas();
	}

	private void iniciarPestanyas() {
		pestanya = new JTabbedPane();
		
		book = new PestanyaBook();
		member = new PestanyaMember();
		author = new PestanyaAuthor();
		genre = new PestanyaGenre();
		
		pestanya.add("Book", book);
		pestanya.add("Member", member);
		pestanya.add("Author", author);
		pestanya.add("Genre", genre);
		
		getContentPane().add(pestanya);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
