package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class MemberMenu extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTabbedPane windowPanel;
	
	private WindowTabBookMember book;
	private WindowTabMemberProfile profile;
	private WindowTabShoppingCart cart;

	public MemberMenu(boolean modal) {
		this.setModal(modal);
		setTitle("Member Menu");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminMenu.class.getResource("/img/pajaritoguay.jpg")));
		setBounds(100, 100, 942, 561);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
				
		
		windowPanels();
	}

	private void windowPanels() {
		windowPanel = new JTabbedPane();
		profile = new WindowTabMemberProfile();
		cart = new WindowTabShoppingCart();
		book = new WindowTabBookMember();
		
		windowPanel.add("Books", book);
		windowPanel.add("Shopping Cart", cart);
		windowPanel.add("Profile", profile);
		
		getContentPane().add(windowPanel);
		
	}
}
