package pruebas;

import javax.swing.JPanel;
import javax.swing.JButton;

public class PanelIntr extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelIntr() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(54, 185, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(188, 120, 89, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(337, 219, 89, 23);
		add(btnNewButton_2);

	}

}
