package earlyVersions;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;

public class PestanyaBook extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField fieldSearchBook;
	private JTextField fieldIsbnBook;
	private JTextField fieldTitleBook;
	private JTextField fieldEditorialBook;
	private JTextField fieldPublicationDateBook;
	private JTextField fieldDsicountRateBook;
	private JTextField fieldStockBook;
	private JButton btnLogOut;
	private final ButtonGroup buttonGroup = new ButtonGroup();


	public PestanyaBook() {
		setForeground(new Color(249, 187, 190));
		setLayout(null);
		contentPanel.setBounds(0, 0, 942, 556);
		add(contentPanel);
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(249, 230, 231));
		
		fieldSearchBook = new JTextField();
		fieldSearchBook.setColumns(10);
		fieldSearchBook.setBounds(189, 24, 443, 29);
		contentPanel.add(fieldSearchBook);
		
		JButton btnSearchBook = new JButton("Search");
		btnSearchBook.setBounds(642, 26, 98, 25);
		contentPanel.add(btnSearchBook);
		
		JLabel lblIsbnBook = new JLabel("ISBN\r\n");
		lblIsbnBook.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblIsbnBook.setBounds(111, 93, 52, 23);
		contentPanel.add(lblIsbnBook);
		
		fieldIsbnBook = new JTextField();
		fieldIsbnBook.setFont(new Font("Dialog", Font.PLAIN, 10));
		fieldIsbnBook.setColumns(10);
		fieldIsbnBook.setBounds(243, 97, 181, 20);
		contentPanel.add(fieldIsbnBook);
		
		JLabel lblTitleBook = new JLabel("Title");
		lblTitleBook.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblTitleBook.setBounds(110, 141, 94, 23);
		contentPanel.add(lblTitleBook);
		
		JLabel lblEditorialBook = new JLabel("Editorial");
		lblEditorialBook.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblEditorialBook.setBounds(110, 189, 94, 23);
		contentPanel.add(lblEditorialBook);
		
		JLabel lblPublicationDateBook = new JLabel("Publication date\r\n");
		lblPublicationDateBook.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblPublicationDateBook.setBounds(110, 236, 121, 23);
		contentPanel.add(lblPublicationDateBook);
		
		JLabel lblCodGBook = new JLabel("CodG");
		lblCodGBook.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblCodGBook.setBounds(109, 282, 61, 23);
		contentPanel.add(lblCodGBook);
		
		JLabel lblCodAuBook = new JLabel("CodAu");
		lblCodAuBook.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblCodAuBook.setBounds(280, 283, 61, 23);
		contentPanel.add(lblCodAuBook);
		
		JLabel lblOfferBook = new JLabel("Offer");
		lblOfferBook.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblOfferBook.setBounds(524, 94, 94, 23);
		contentPanel.add(lblOfferBook);
		
		JLabel lblDiscountRateBook = new JLabel("Discount rate");
		lblDiscountRateBook.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblDiscountRateBook.setBounds(525, 143, 109, 23);
		contentPanel.add(lblDiscountRateBook);
		
		JLabel lblStockBook = new JLabel("Stock");
		lblStockBook.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblStockBook.setBounds(525, 189, 94, 23);
		contentPanel.add(lblStockBook);
		
		JLabel lblDescriptionBook = new JLabel("Description");
		lblDescriptionBook.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblDescriptionBook.setBounds(632, 232, 94, 23);
		contentPanel.add(lblDescriptionBook);
		
		fieldTitleBook = new JTextField();
		fieldTitleBook.setFont(new Font("Dialog", Font.PLAIN, 10));
		fieldTitleBook.setColumns(10);
		fieldTitleBook.setBounds(245, 144, 181, 20);
		contentPanel.add(fieldTitleBook);
		
		fieldEditorialBook = new JTextField();
		fieldEditorialBook.setFont(new Font("Dialog", Font.PLAIN, 10));
		fieldEditorialBook.setColumns(10);
		fieldEditorialBook.setBounds(245, 193, 181, 20);
		contentPanel.add(fieldEditorialBook);
		
		fieldPublicationDateBook = new JTextField();
		fieldPublicationDateBook.setFont(new Font("Dialog", Font.PLAIN, 10));
		fieldPublicationDateBook.setColumns(10);
		fieldPublicationDateBook.setBounds(245, 240, 181, 20);
		contentPanel.add(fieldPublicationDateBook);
		
		fieldDsicountRateBook = new JTextField();
		fieldDsicountRateBook.setFont(new Font("Dialog", Font.PLAIN, 10));
		fieldDsicountRateBook.setColumns(10);
		fieldDsicountRateBook.setBounds(634, 143, 181, 20);
		contentPanel.add(fieldDsicountRateBook);
		
		fieldStockBook = new JTextField();
		fieldStockBook.setFont(new Font("Dialog", Font.PLAIN, 10));
		fieldStockBook.setColumns(10);
		fieldStockBook.setBounds(635, 194, 181, 20);
		contentPanel.add(fieldStockBook);
		
		JComboBox cmbCodGBook = new JComboBox();
		cmbCodGBook.setBounds(109, 317, 143, 20);
		contentPanel.add(cmbCodGBook);
		
		JComboBox cmbCodAuBook = new JComboBox();
		cmbCodAuBook.setBounds(282, 316, 143, 20);
		contentPanel.add(cmbCodAuBook);
		
		JTextPane txtDescriptionBook = new JTextPane();
		txtDescriptionBook.setBounds(526, 260, 298, 151);
		contentPanel.add(txtDescriptionBook);
		
		JButton btnModifyBook = new JButton("Modify");
		btnModifyBook.setBounds(426, 456, 98, 25);
		contentPanel.add(btnModifyBook);
		
		JButton btnInsertBook = new JButton("Insert");
		btnInsertBook.setBounds(298, 456, 98, 25);
		contentPanel.add(btnInsertBook);
		
		JButton btnDeleteBook = new JButton("Delete\r\n");
		btnDeleteBook.setBounds(549, 456, 98, 25);
		contentPanel.add(btnDeleteBook);
		
		JRadioButton rdbtnYesBook = new JRadioButton("Yes");
		buttonGroup.add(rdbtnYesBook);
		rdbtnYesBook.setBackground(new Color(249, 230, 231));
		rdbtnYesBook.setFont(new Font("Dialog", Font.PLAIN, 13));
		rdbtnYesBook.setBounds(643, 96, 61, 21);
		contentPanel.add(rdbtnYesBook);
		
		JRadioButton rdbtnNoBook = new JRadioButton("No");
		buttonGroup.add(rdbtnNoBook);
		rdbtnNoBook.setBackground(new Color(249, 230, 231));
		rdbtnNoBook.setFont(new Font("Dialog", Font.PLAIN, 13));
		rdbtnNoBook.setBounds(740, 96, 61, 21);
		contentPanel.add(rdbtnNoBook);
		
		JLabel lblFoto1AdminBook = new JLabel("");
		lblFoto1AdminBook.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFoto1AdminBook.setIcon(new ImageIcon(PestanyaBook.class.getResource("/img/Admin_book-removebg-preview (1).png")));
		lblFoto1AdminBook.setBounds(657, 267, 274, 214);
		contentPanel.add(lblFoto1AdminBook);
		
		JLabel lblFoto2AdminBook = new JLabel("");
		lblFoto2AdminBook.setIcon(new ImageIcon(PestanyaBook.class.getResource("/img/Admin_book2-removebg-preview.png")));
		lblFoto2AdminBook.setBounds(32, 286, 256, 195);
		contentPanel.add(lblFoto2AdminBook);

		
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
