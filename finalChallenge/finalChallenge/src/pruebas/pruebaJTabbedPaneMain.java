package pruebas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class pruebaJTabbedPaneMain extends JFrame {

	JPanel contentPane;
	
	PanelIntr panelIntr;
	
	
	JTabbedPane pestana;
		
	public pruebaJTabbedPaneMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		pestana=new JTabbedPane();
		
		panelIntr=new PanelIntr();
		
		pestana.add("si", panelIntr);
		
		
		getContentPane().add(pestana);
	}

}
