import java.awt.EventQueue;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.AbstractListModel;
import javax.swing.JButton;

public class Receipt extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public JList productList = new JList();
	public JList totalPriceList = new JList();
	public JList quantityList = new JList();
	public DefaultListModel productListDlm = new DefaultListModel();
	public DefaultListModel totalPriceListDlm = new DefaultListModel();
	public DefaultListModel quantityListDlm = new DefaultListModel();
	
	DefaultListCellRenderer renderer =  (DefaultListCellRenderer)quantityList.getCellRenderer();  
	DefaultListCellRenderer renderer2 =  (DefaultListCellRenderer)totalPriceList.getCellRenderer();  
	private final JLabel lblNewLabel_1_1_1 = new JLabel("Total:");
	public final JLabel totalBill = new JLabel("₱");
	private final JLabel lblNewLabel_1_1_1_2 = new JLabel("Change:");
	public final JLabel change = new JLabel("");
	private final JLabel lblThanks = new JLabel("Thanks!");
	private final JLabel lblNewLabel_1 = new JLabel("Qty");
	private final JLabel lblNewLabel_1_1 = new JLabel("Product");
	private final JLabel lblNewLabel_1_1_1_1 = new JLabel("Price");
	private final JButton btnNewButton = new JButton("X");
	private final JPanel panel_1 = new JPanel();
	private final JLabel lblSavorystackBurger = new JLabel("SavoryStack: Burger & Drinks");
	private final JLabel lblYuriforgeTechnologies = new JLabel("YuriCode Creations");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Receipt frame = new Receipt();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Receipt() {
		
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				
			}});
	
		
		renderer.setHorizontalAlignment(JLabel.CENTER);  
		renderer2.setHorizontalAlignment(JLabel.CENTER);  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 63, 414, 490);
		contentPane.add(panel);
		panel.setLayout(null);
		quantityList.setModel(new AbstractListModel() {
			String[] values = new String[] {"Test"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		
		quantityList.setFont(new Font("Verdana", Font.PLAIN, 15));
		quantityList.setEnabled(false);
		quantityList.setBackground(UIManager.getColor("Button.background"));
		quantityList.setBounds(10, 93, 55, 271);
		panel.add(quantityList);
		productList.setModel(new AbstractListModel() {
			String[] values = new String[] {"Test"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		
		productList.setFont(new Font("Verdana", Font.PLAIN, 15));
		productList.setEnabled(false);
		productList.setBackground(UIManager.getColor("Button.background"));
		productList.setBounds(78, 93, 145, 271);
		panel.add(productList);
		totalPriceList.setModel(new AbstractListModel() {
			String[] values = new String[] {"Test"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		
		totalPriceList.setFont(new Font("Verdana", Font.PLAIN, 15));
		totalPriceList.setEnabled(false);
		totalPriceList.setBackground(UIManager.getColor("Button.background"));
		totalPriceList.setBounds(244, 93, 83, 271);
		panel.add(totalPriceList);
		
		JLabel lblReciept = new JLabel("Official Receipt");
		lblReciept.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblReciept.setBounds(10, 11, 152, 29);
		panel.add(lblReciept);
		lblNewLabel_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(16, 375, 75, 20);
		
		panel.add(lblNewLabel_1_1_1);
		totalBill.setHorizontalAlignment(SwingConstants.CENTER);
		totalBill.setFont(new Font("Verdana", Font.PLAIN, 15));
		totalBill.setBounds(118, 372, 105, 26);
		
		panel.add(totalBill);
		lblNewLabel_1_1_1_2.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_1_1_1_2.setBounds(16, 403, 75, 20);
		
		panel.add(lblNewLabel_1_1_1_2);
		change.setHorizontalAlignment(SwingConstants.CENTER);
		change.setFont(new Font("Verdana", Font.PLAIN, 15));
		change.setBounds(118, 397, 105, 26);
		
		panel.add(change);
		lblThanks.setHorizontalAlignment(SwingConstants.CENTER);
		lblThanks.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblThanks.setBounds(128, 450, 152, 29);
		
		panel.add(lblThanks);
		lblNewLabel_1.setBounds(10, 61, 55, 26);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(53, 61, 105, 26);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(232, 61, 105, 26);
		panel.add(lblNewLabel_1_1_1_1);
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnNewButton.setFocusable(false);
		btnNewButton.setBounds(353, 436, 51, 43);
		
		panel.add(btnNewButton);
		panel_1.setBounds(10, 11, 414, 51);
		
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		lblSavorystackBurger.setHorizontalAlignment(SwingConstants.CENTER);
		lblSavorystackBurger.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblSavorystackBurger.setBounds(0, 0, 414, 29);
		
		panel_1.add(lblSavorystackBurger);
		lblYuriforgeTechnologies.setHorizontalAlignment(SwingConstants.CENTER);
		lblYuriforgeTechnologies.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblYuriforgeTechnologies.setBounds(0, 21, 414, 29);
		
		panel_1.add(lblYuriforgeTechnologies);
	}
}
