package view;

import javax.swing.JPanel;
import javax.swing.JButton;

public class PestanyaBook extends JPanel {

	/**
	 * Create the panel.
	 */
	public PestanyaBook() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("Book");
		btnNewButton.setBounds(182, 143, 89, 23);
		add(btnNewButton);

	}

}
