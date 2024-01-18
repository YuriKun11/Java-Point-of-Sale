import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Quantity extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String getValue;
	String number;
	public JLabel totalBill = new JLabel("₱");
	public JLabel testLabel = new JLabel("Total Items");
	JPanel panel_3 = new JPanel();
	
	public JList productList = new JList();
	public JList totalPriceList = new JList();
	public JList quantityList = new JList();
	public DefaultListModel productListDlm = new DefaultListModel();
	public DefaultListModel totalPriceListDlm = new DefaultListModel();
	public DefaultListModel quantityListDlm = new DefaultListModel();
	
	private JButton[] numberButtons;
	JButton backSpace = new JButton("Clear");
	JButton payButton = new JButton("PAY");
	JLabel change = new JLabel("₱");
	

	JPanel panel_4 = new JPanel();

	DefaultListCellRenderer renderer =  (DefaultListCellRenderer)quantityList.getCellRenderer();  
	
	DefaultListCellRenderer renderer2 =  (DefaultListCellRenderer)totalPriceList.getCellRenderer();  
	private JTextField customerMoney;
	private final JPanel panel_5 = new JPanel();
	private final JButton btnPrintReceipt = new JButton("Print Receipt?");
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quantity quantity = new Quantity();
					quantity.setUndecorated(true);
					quantity.setVisible(true);
					
					quantity.setLocationRelativeTo(null);
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Quantity() {
		
		numberButtons = new JButton[10];
		
		
		backSpace.addActionListener(this);
		payButton.addActionListener(this);
		btnPrintReceipt.addActionListener(this);
		
		 for (int i = 0; i < 10; i++) {
	            numberButtons[i] = new JButton(String.valueOf(i));
	            numberButtons[i].addActionListener(this);
	            numberButtons[i].setFocusable(false);
	        }
		 
		 for (int i = 1; i <= 9; i++) {
			 panel_4.add(numberButtons[i]);
	        }
		
		 panel_4.add(numberButtons[0]);
		
		
		renderer.setHorizontalAlignment(JLabel.CENTER);  
		
		renderer2.setHorizontalAlignment(JLabel.CENTER);  
		
		
		
		setBounds(100, 100, 647, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 248));
		panel.setBounds(0, 0, 375, 71);
		contentPane.add(panel);
		panel.setLayout(null);
		
	
		testLabel.setBounds(10, 31, 152, 29);
		panel.add(testLabel);
		testLabel.setHorizontalAlignment(SwingConstants.CENTER);
		testLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 71, 357, 339);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Qty");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 11, 55, 26);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Product");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(63, 11, 105, 26);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Price");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(240, 11, 105, 26);
		panel_1.add(lblNewLabel_1_1_1_1);
		quantityList.setBackground(new Color(240, 240, 240));
		
		quantityList.setEnabled(false);
		quantityList.setFont(new Font("Verdana", Font.PLAIN, 15));
		quantityList.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		
		quantityList.setBounds(10, 48, 55, 271);
		panel_1.add(quantityList);
		totalPriceList.setBackground(new Color(240, 240, 240));
		totalPriceList.setEnabled(false);
		totalPriceList.setFont(new Font("Verdana", Font.PLAIN, 15));
		
		
		totalPriceList.setBounds(250, 48, 83, 271);
		panel_1.add(totalPriceList);
		productList.setBackground(new Color(240, 240, 240));
		productList.setEnabled(false);
		productList.setFont(new Font("Verdana", Font.PLAIN, 15));
		productList.setModel(new AbstractListModel() {
			String[] values = new String[] {""};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		
		productList.setBounds(87, 48, 145, 271);
		panel_1.add(productList);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(248, 248, 248));
		panel_2.setBounds(357, 0, 282, 71);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblPayment = new JLabel("Payment");
		lblPayment.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayment.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPayment.setBounds(0, 31, 152, 29);
		panel_2.add(lblPayment);
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.setBounds(216, 17, 51, 43);
		panel_2.add(btnNewButton);
		btnNewButton.setFocusable(false);
		
		
		panel_3.setBackground(new Color(248, 248, 248));
		panel_3.setBounds(367, 82, 262, 398);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Total:");
		lblNewLabel_1_1_1.setBounds(33, 14, 75, 20);
		lblNewLabel_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_1_1_1);
		
		customerMoney = new JTextField();
		customerMoney.setToolTipText("");
		customerMoney.setFont(new Font("Verdana", Font.PLAIN, 14));
		customerMoney.setHorizontalAlignment(SwingConstants.CENTER);
		customerMoney.setBounds(33, 73, 112, 40);
		panel_3.add(customerMoney);
		customerMoney.setColumns(10);
		
		
		totalBill.setHorizontalAlignment(SwingConstants.CENTER);
		totalBill.setFont(new Font("Verdana", Font.PLAIN, 15));
		totalBill.setBounds(135, 11, 105, 26);
		panel_3.add(totalBill);
		
		
		payButton.setFocusable(false);
		payButton.setBounds(33, 338, 207, 34);
		panel_3.add(payButton);
		
	
		backSpace.setFocusable(false);
		backSpace.setBounds(155, 73, 85, 40);
		panel_3.add(backSpace);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Change:");
		lblNewLabel_1_1_1_2.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_1_1_1_2.setBounds(33, 42, 75, 20);
		panel_3.add(lblNewLabel_1_1_1_2);
		
		
		change.setHorizontalAlignment(SwingConstants.CENTER);
		change.setFont(new Font("Verdana", Font.PLAIN, 15));
		change.setBounds(135, 36, 105, 26);
		panel_3.add(change);
		
		
		panel_4.setBounds(33, 124, 207, 203);
		panel_3.add(panel_4);
		panel_4.setLayout(new GridLayout(4, 4, 10, 10));
		panel_5.setBounds(0, 421, 357, 59);
		
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		btnPrintReceipt.setFocusable(false);
		btnPrintReceipt.setBounds(75, 11, 207, 34);
		
		panel_5.add(btnPrintReceipt);
		
	
		
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				
				dispose();
				
			}
			
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub 
		
		for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
            	customerMoney.setText(customerMoney.getText() + i);
            }
        }
		
		if(e.getSource() == backSpace) {
			customerMoney.setText("");
		}
		if(e.getSource() == payButton) {

			String bill = totalBill.getText();
			String payment = customerMoney.getText();
			
			int amount = Integer.parseInt(bill);
			int money = Integer.parseInt(payment);
			
			int result = money - amount;
			
			if(money >= amount) {
				System.out.println("The change is : "+result);
				change.setText("₱ "+result);
			}else {
				System.out.println("Kulang ina mo");
				change.setText("Short");
			}
		}

		Receipt receipt = new Receipt();
		if(e.getSource() == btnPrintReceipt) {
		
			receipt.setUndecorated(true);
			receipt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			receipt.totalBill.setText(totalBill.getText());
		
			if(change.getText()=="Short" || change.getText() == "₱"){
				receipt.change.setText("");
			}else {
				receipt.change.setText(change.getText());
			}
			
			
			for (int i=0; i<productListDlm.getSize(); i++) {
				receipt.productListDlm.addElement(productListDlm.elementAt(i));
				receipt.quantityListDlm.addElement(quantityListDlm.elementAt(i));
				receipt.totalPriceListDlm.addElement(totalPriceListDlm.elementAt(i));
				}

			receipt.productList.setModel(receipt.productListDlm);
			receipt.quantityList.setModel(receipt.quantityListDlm);
			receipt.totalPriceList.setModel(receipt.totalPriceListDlm);
			
			dispose();
			
			receipt.setVisible(true);
			receipt.setLocationRelativeTo(null);
			
		
		}
	
	}
}
