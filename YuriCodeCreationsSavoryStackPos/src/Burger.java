import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class Burger extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JPanel menu1 = new JPanel();
	JPanel menu2 = new JPanel();
	JPanel menu3 = new JPanel();
	
	JLabel menuList = new JLabel("");
	JLabel firstMenu = new JLabel("");
	JLabel secondMenu = new JLabel("");
	
	JPanel burgerPanel = new JPanel();
	JPanel drinksPanel = new JPanel();
	JPanel hotdogPanel = new JPanel();
	JPanel cocacolaPanel = new JPanel();
	JPanel waterPanel = new JPanel();
	
	JPanel ramunePanel = new JPanel();
	
	JPanel cheeseBurger = new JPanel();
	
	JList priceList = new JList();
	
	JButton placeOrder = new JButton("");
	JButton clearButton = new JButton("");
	
	int defaultQuantity = 1;
	
	int priceBurger = 30;
	int priceCheeseBurger = 40;
	int priceHotdog = 30;
	int priceWater = 10;
	int priceCoke= 20;
	int priceRamune= 25;
	
	Color DefaultColor, ClickedColor;
	
	JButton addToCart1 = new JButton("Cheese Burger");
	
	public DefaultListModel dlm = new DefaultListModel();
	public DefaultListModel priceListdlm = new DefaultListModel();
	public DefaultListModel quantiListdlm = new DefaultListModel();
	public JList list = new JList();
	public JList quantiList = new JList();
	
	DefaultListCellRenderer renderer =  (DefaultListCellRenderer)list.getCellRenderer();  
	DefaultListCellRenderer renderer1 =  (DefaultListCellRenderer)priceList.getCellRenderer();  
	DefaultListCellRenderer renderer2 =  (DefaultListCellRenderer)quantiList.getCellRenderer();  
	private JTextField itemQuantityField;
	
	JPanel quantityManager = new JPanel();
	
	JButton addToCart = new JButton("Egg Burger");
	JButton addToCart2 = new JButton("Hotdog");
	JButton addToCart3 = new JButton("Water");
	JButton addToCart4 = new JButton("Coke");
	JButton addToCart5 = new JButton("Ramune");
	
	JButton button1 = new JButton("1");
	JButton button2 = new JButton("2");
	JButton button3 = new JButton("3");
	JButton button5 = new JButton("5");
	
	JButton decrement = new JButton("-");
	JButton increment = new JButton("+");
	
	int buttonClick1 = 1;
	int buttonClick2 = 2;
	int buttonClick3 = 3;
	int buttonClick5 = 5;
	
	int bill;
	
	JLabel totalBill = new JLabel("0");
	private JLabel coke;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args)  {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Burger frame = new Burger();
					frame.setResizable(false);
					frame.setTitle("YuriCode Creations");
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	
	public void deleteList() {
		
		try {
			 DefaultListModel listModel = (DefaultListModel) list.getModel();
			 DefaultListModel listModel1 = (DefaultListModel) priceList.getModel();
			 DefaultListModel listModel2 = (DefaultListModel) quantiList.getModel();
		        listModel.removeAllElements();
		        listModel1.removeAllElements();
		        listModel2.removeAllElements();
		        
		        int bill = 0;
		        
		        totalBill.setText(String.valueOf(bill));
			
		}catch(Exception e) {
				
		}
		
		
		
	}
	
	
	public void Menu1() {
		menu1.setBackground(ClickedColor);
    	menu2.setBackground(DefaultColor);
    	menu3.setBackground(DefaultColor);
    	burgerPanel.setVisible(true);
    	drinksPanel.setVisible(true);
    	
    	drinksPanel.setBounds(60, 261, 688, 174);
	}
	
	public void Menu2() {
		menu1.setBackground(DefaultColor);
    	menu2.setBackground(ClickedColor);
    	menu3.setBackground(DefaultColor);
    	burgerPanel.setVisible(true);
    	drinksPanel.setVisible(false);
 
    	drinksPanel.setBounds(60, 261, 688, 174);
	}
	
	public void Menu3() {
		menu1.setBackground(DefaultColor);
    	menu2.setBackground(DefaultColor);
    	menu3.setBackground(ClickedColor);
    	burgerPanel.setVisible(false);
    	drinksPanel.setVisible(true);
 	
    	drinksPanel.setBounds(60, 84, 688, 174);
	}
	
	public void visibility1() {
		quantityManager.setVisible(false);
		addToCart.setVisible(false);
		
	}
	public void visibility2() {
		quantityManager.setVisible(false);
		addToCart1.setVisible(false);	
	}
	

	

	public Burger() {
		
		DefaultColor = new Color(255, 255, 255);
		ClickedColor = new Color(245,184,149);
		clearButton.setIcon(new ImageIcon(Burger.class.getResource("/buttonImage/clear.png")));
		
		clearButton.setBorderPainted(false);
		clearButton.setContentAreaFilled(false);
		clearButton.setFocusPainted(false);
		clearButton.setOpaque(false);
		clearButton.setRolloverEnabled(false);
		
		
		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				deleteList();
			}
			
		});
		placeOrder.setIcon(new ImageIcon(Burger.class.getResource("/buttonImage/placeOrderButton.png")));
		placeOrder.setBorderPainted(false);
		placeOrder.setContentAreaFilled(false);
		placeOrder.setFocusPainted(false);
		placeOrder.setOpaque(false);
		placeOrder.setRolloverEnabled(false);
		//brb
		
		placeOrder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				Quantity quantity = new Quantity();
				quantity.testLabel.setText("Total items");
				quantity.setUndecorated(true);
				quantity.setVisible(true);
				quantity.setLocationRelativeTo(null);
				
				
				for (int i=0; i<dlm.getSize(); i++) {
				  quantity.productListDlm.addElement(dlm.elementAt(i));
				  quantity.quantityListDlm.addElement(quantiListdlm.elementAt(i));
				  quantity.totalPriceListDlm.addElement(priceListdlm.elementAt(i));
				}

				quantity.productList.setModel(quantity.productListDlm);
				quantity.quantityList.setModel(quantity.quantityListDlm);
				quantity.totalPriceList.setModel(quantity.totalPriceListDlm);
				
				quantity.totalBill.setText(String.valueOf(calculateSum()));
				
				deleteList();
					
			}
			
		});
		

		button1.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
		  
				  itemQuantityField.setText(Integer.toString(buttonClick1));
				  
				  
			  } 
			});
		button2.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				
				itemQuantityField.setText(Integer.toString(buttonClick2));
			} 
		});
		button3.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				
				itemQuantityField.setText(Integer.toString(buttonClick3));
			} 
		});
		button5.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				
				itemQuantityField.setText(Integer.toString(buttonClick5));
			} 
		});
		decrement.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				
				try {
					itemQuantityField.setText(String.valueOf(Integer.parseInt(itemQuantityField.getText()) - 1));
					}
					catch(Exception e1) {
					  System.out.println("Enter a number");
					}
				
				
			} 
		});
		increment.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				try {
					itemQuantityField.setText(String.valueOf(Integer.parseInt(itemQuantityField.getText()) + 1));
					}
					catch(Exception e1) {
					  System.out.println("Enter a number");
					}
				
			} 
		});
		
		renderer.setHorizontalAlignment(JLabel.CENTER);  
		renderer1.setHorizontalAlignment(JLabel.CENTER);  
		renderer2.setHorizontalAlignment(JLabel.CENTER);  
		
		ImageIcon imageIcon = new ImageIcon(Burger.class.getResource("/images/foodmenu.png"));
		Image image = imageIcon.getImage();
		Image newImage = image.getScaledInstance(35, 35, Image.SCALE_DEFAULT);
		ImageIcon newImageIcon = new ImageIcon(newImage);
		
		ImageIcon imageIcon1 = new ImageIcon(Burger.class.getResource("/images/menu2.png"));
		Image image2 = imageIcon1.getImage();
		Image newImage1 = image2.getScaledInstance(35, 35, Image.SCALE_DEFAULT);
		ImageIcon newImageIcon1 = new ImageIcon(newImage1);
		
		ImageIcon imageIcon2 = new ImageIcon(Burger.class.getResource("/images/eggburger.png"));
		Image image3 = imageIcon2.getImage();
		Image newImage2 = image3.getScaledInstance(130, 100, Image.SCALE_DEFAULT);
		ImageIcon newImageIcon3 = new ImageIcon(newImage2);

		ImageIcon imageIcon5 = new ImageIcon(Burger.class.getResource("/images/menuburger.png"));
		Image image5 = imageIcon5.getImage();
		Image newImage5 = image5.getScaledInstance(130, 100, Image.SCALE_DEFAULT);
		ImageIcon newImageIcon5 = new ImageIcon(newImage5);
	
		ImageIcon imageIcon6 = new ImageIcon(Burger.class.getResource("/images/hotdog.png"));
		Image image6 = imageIcon6.getImage();
		Image newImage6 = image6.getScaledInstance(130, 100, Image.SCALE_DEFAULT);
		ImageIcon newImageIcon6 = new ImageIcon(newImage6);
	
		
		ImageIcon imageIcon7 = new ImageIcon(Burger.class.getResource("/images/water.png"));
		Image image7 = imageIcon7.getImage();
		Image newImage7 = image7.getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		ImageIcon newImageIcon7 = new ImageIcon(newImage7);
		
		ImageIcon imageIcon8 = new ImageIcon(Burger.class.getResource("/images/coke.png"));
		Image image8 = imageIcon8.getImage();
		Image newImage8 = image8.getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		ImageIcon newImageIcon8 = new ImageIcon(newImage8);
		
		ImageIcon imageIcon9 = new ImageIcon(Burger.class.getResource("/images/ramune.png"));
		Image image9 = imageIcon9.getImage();
		Image newImage9 = image9.getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		ImageIcon newImageIcon9 = new ImageIcon(newImage9);
		
		ImageIcon ImageIcon10 = new ImageIcon(Burger.class.getResource("/images/soda.png"));
		Image image10 = ImageIcon10.getImage();
		Image newImage10 = image10.getScaledInstance(35, 35, Image.SCALE_DEFAULT);
		ImageIcon newImageIcon10 = new ImageIcon(newImage10);
		
		//MouseListener
		
		menu1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	Menu1();          	
            }

        });
		menu2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Menu2();
            	
			}
		});
		menu3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Menu3();
			}
		});
		
		placeOrder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			
			}
			
		});
		
		//QUANTITY BUTTONS
		
		JPanel eggBurger = new JPanel();
		eggBurger.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				quantityManager.setVisible(true);
				addToCart.setVisible(true);
				addToCart1.setVisible(false);
				itemQuantityField.setText(String.valueOf(defaultQuantity));
			}
		});
		JPanel cheeseBurger = new JPanel();
		cheeseBurger.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				quantityManager.setVisible(true);
				addToCart.setVisible(false);
				addToCart1.setVisible(true);
				itemQuantityField.setText(String.valueOf(defaultQuantity));	
			}
		});
		JPanel hotdogPanel = new JPanel();
		hotdogPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				quantityManager.setVisible(true);
				addToCart.setVisible(false);
				addToCart1.setVisible(false);
				addToCart2.setVisible(true);
				itemQuantityField.setText(String.valueOf(defaultQuantity));	
			}
		});
		JPanel waterPanel = new JPanel();
		waterPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				quantityManager.setVisible(true);
				addToCart.setVisible(false);
				addToCart1.setVisible(false);
				addToCart2.setVisible(false);
				addToCart3.setVisible(true);
				itemQuantityField.setText(String.valueOf(defaultQuantity));	
			}
		});
		JPanel cocacolaPanel = new JPanel();
		cocacolaPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				quantityManager.setVisible(true);
				addToCart.setVisible(false);
				addToCart1.setVisible(false);
				addToCart2.setVisible(false);
				addToCart3.setVisible(false);
				addToCart4.setVisible(true);
				itemQuantityField.setText(String.valueOf(defaultQuantity));	
			}
		});
		JPanel ramunePanel = new JPanel();
		ramunePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				quantityManager.setVisible(true);
				addToCart.setVisible(false);
				addToCart1.setVisible(false);
				addToCart2.setVisible(false);
				addToCart3.setVisible(false);
				addToCart4.setVisible(false);
				addToCart5.setVisible(true);
				itemQuantityField.setText(String.valueOf(defaultQuantity));	
			}
		});
		
		
		addToCart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				dlm.addElement("Burger");
				list.setModel(dlm);
				String pricee = itemQuantityField.getText();
				 int b = Integer.parseInt(pricee);
				 int price = b * priceBurger;
 
				quantiListdlm.addElement(b);
				quantiList.setModel(quantiListdlm);
				
				priceListdlm.addElement(price);
				priceList.setModel(priceListdlm);

				
				visibility1();
				
				
				totalBill.setText("₱ "+String.valueOf(calculateSum()));
				
				
			}});
		addToCart1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dlm.addElement("Cheese Burger");
				list.setModel(dlm);
				
				// TODO Auto-generated method stub
				String pricee = itemQuantityField.getText();
				int b = Integer.parseInt(pricee);
				int price = b * priceCheeseBurger;		
				
				quantiListdlm.addElement(b);
				quantiList.setModel(quantiListdlm);
				
				priceListdlm.addElement(price);
				priceList.setModel(priceListdlm);
	
				visibility2();
				
				totalBill.setText(String.valueOf(calculateSum()));
				
				
			}});
		addToCart2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dlm.addElement("Hotdog");
				list.setModel(dlm);
				
				// TODO Auto-generated method stub
				String pricee = itemQuantityField.getText();
				int b = Integer.parseInt(pricee);
				int price = b * priceHotdog;		
				
				quantiListdlm.addElement(b);
				quantiList.setModel(quantiListdlm);
				
				priceListdlm.addElement(price);
				priceList.setModel(priceListdlm);
				
				visibility2();
				
				totalBill.setText(String.valueOf(calculateSum()));
				
				
			}});
		addToCart3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dlm.addElement("Water");
				list.setModel(dlm);
				
				// TODO Auto-generated method stub
				String pricee = itemQuantityField.getText();
				int b = Integer.parseInt(pricee);
				int price = b * priceWater;		
				
				quantiListdlm.addElement(b);
				quantiList.setModel(quantiListdlm);
				
				priceListdlm.addElement(price);
				priceList.setModel(priceListdlm);
				
				visibility2();
				
				totalBill.setText(String.valueOf(calculateSum()));
				
				
			}});
		addToCart4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dlm.addElement("Coke");
				list.setModel(dlm);
				
				// TODO Auto-generated method stub
				String pricee = itemQuantityField.getText();
				int b = Integer.parseInt(pricee);
				int price = b * priceCoke;		
				
				quantiListdlm.addElement(b);
				quantiList.setModel(quantiListdlm);
				
				priceListdlm.addElement(price);
				priceList.setModel(priceListdlm);
				
				visibility2();
				
				totalBill.setText(String.valueOf(calculateSum()));
				
				
			}});
		addToCart5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dlm.addElement("Ramune");
				list.setModel(dlm);
				
				// TODO Auto-generated method stub
				String pricee = itemQuantityField.getText();
				int b = Integer.parseInt(pricee);
				int price = b * priceRamune;		
				
				quantiListdlm.addElement(b);
				quantiList.setModel(quantiListdlm);
				
				priceListdlm.addElement(price);
				priceList.setModel(priceListdlm);
				
				visibility2();
				
				totalBill.setText(String.valueOf(calculateSum()));
				
				
			}});
		

		
		Quantity frame = new Quantity();
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1118, 677);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 248));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 774, 73);
		contentPane.add(panel);
		panel.setLayout(null);
		JLabel lblNewLabel = new JLabel("SavoryStack:");
		lblNewLabel.setForeground(new Color(255, 161, 108));
		lblNewLabel.setBounds(35, 11, 225, 51);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 38));
		
		JLabel lblBurgerDrinks = new JLabel("Burger & Drinks");
		lblBurgerDrinks.setForeground(new Color(0, 0, 0));
		lblBurgerDrinks.setFont(new Font("Yu Gothic UI", Font.BOLD, 38));
		lblBurgerDrinks.setBounds(270, 11, 280, 51);
		panel.add(lblBurgerDrinks);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 70, 78, 568);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		JLabel lblNewLabel_1 = new JLabel("Menu");
		lblNewLabel_1.setBounds(22, 5, 45, 25);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		panel_1.add(lblNewLabel_1);
		menu1.setBounds(0, 41, 78, 48);
		panel_1.add(menu1);
		menu1.add(menuList);
		menuList.setForeground(new Color(255, 255, 255));
		menuList.setBackground(new Color(255, 255, 255));
		menuList.setHorizontalAlignment(SwingConstants.CENTER);
		menuList.setIcon(newImageIcon);
		
		menu1.setBackground(ClickedColor);

		menu2.setBounds(0, 100, 89, 48);
		panel_1.add(menu2);
		menu2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		menu2.setBackground(new Color(255, 255, 255));
		
		
		
		menu2.add(firstMenu);
		firstMenu.setHorizontalAlignment(SwingConstants.CENTER);
		firstMenu.setIcon(newImageIcon1);
		
		JLabel image1_1 = new JLabel("");
		image1_1.setHorizontalAlignment(SwingConstants.CENTER);
		image1_1.setForeground(Color.WHITE);
		image1_1.setBackground(Color.WHITE);
		menu2.add(image1_1);
		
		
		menu3.setBackground(new Color(255, 255, 255));
		menu3.setBounds(0, 159, 89, 48);
		panel_1.add(menu3);
		menu3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		menu3.add(secondMenu);
		secondMenu.setFont(new Font("Tahoma", Font.PLAIN, 33));
		secondMenu.setHorizontalAlignment(SwingConstants.CENTER);
		
		secondMenu.setIcon(newImageIcon10);
		
		JLabel burger_1 = new JLabel("");
		burger_1.setHorizontalAlignment(SwingConstants.CENTER);
		menu3.add(burger_1);
		
		JLabel image1_1_1 = new JLabel("");
		image1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		image1_1_1.setForeground(Color.WHITE);
		image1_1_1.setBackground(Color.WHITE);
		menu3.add(image1_1_1);
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(773, 0, 329, 627);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(null);
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(0, 0, 329, 159);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		ImageIcon imageIcon4 = new ImageIcon(Burger.class.getResource("/images/profile.jpg"));
		Image image4 = imageIcon4.getImage();
		Image newImage4 = image4.getScaledInstance(90, 90, Image.SCALE_DEFAULT);
		ImageIcon newImageIcon4 = new ImageIcon(newImage4);
		
		JLabel profileImage = new JLabel("");
		profileImage.setHorizontalAlignment(SwingConstants.LEFT);
		profileImage.setBounds(10, 0, 90, 90);
		panel_4.add(profileImage);
		profileImage.setIcon(newImageIcon4);
		
		JLabel lblNewLabel_8 = new JLabel("Yuri Reyes");
		lblNewLabel_8.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(108, 28, 87, 14);
		panel_4.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Software Developer");
		lblNewLabel_9.setFont(new Font("Verdana", Font.ITALIC, 13));
		lblNewLabel_9.setBounds(110, 50, 153, 14);
		panel_4.add(lblNewLabel_9);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 91, 309, 57);
		panel_4.add(panel_6);
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Current Order");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(10, 19, 128, 27);
		panel_6.add(lblNewLabel_7);
		
		
		clearButton.setBounds(164, 11, 135, 46);
		panel_6.add(clearButton);
		clearButton.setFocusable(false);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBounds(10, 519, 309, 97);
		panel_3.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Total:");
		lblNewLabel_6.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(10, 11, 55, 25);
		panel_5.add(lblNewLabel_6);
		
	
		placeOrder.setFont(new Font("Verdana", Font.PLAIN, 17));
		placeOrder.setBounds(48, 41, 218, 40);
		panel_5.add(placeOrder);
		placeOrder.setFocusable(false);
		
		
		totalBill.setFont(new Font("Verdana", Font.PLAIN, 17));
		totalBill.setBounds(69, 11, 208, 25);
		panel_5.add(totalBill);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(248, 248, 248));
		panel_2.setBounds(10, 170, 309, 343);
		panel_3.add(panel_2);
		panel_2.setLayout(null);
		list.setBackground(new Color(248, 248, 248));
	
		panel_2.add(list);
		priceList.setBackground(new Color(248, 248, 248));
		
		
		priceList.setBounds(250, 29, 49, 303);
		panel_2.add(priceList);
		quantiList.setBackground(new Color(248, 248, 248));
		
		
		quantiList.setFont(new Font("Verdana", Font.PLAIN, 18));
		quantiList.setFixedCellWidth(100);
		quantiList.setFixedCellHeight(50);
		quantiList.setBounds(10, 29, 49, 303);
		panel_2.add(quantiList);
		
		JLabel lblNewLabel_10 = new JLabel("Qty");
		lblNewLabel_10.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(10, 11, 46, 14);
		panel_2.add(lblNewLabel_10);
		
		JLabel lblNewLabel_10_1 = new JLabel("Product");
		lblNewLabel_10_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_10_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10_1.setBounds(124, 11, 46, 14);
		panel_2.add(lblNewLabel_10_1);
		
		JLabel lblNewLabel_10_1_1 = new JLabel("Price");
		lblNewLabel_10_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10_1_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_10_1_1.setBounds(253, 11, 46, 14);
		panel_2.add(lblNewLabel_10_1_1);
		
		drinksPanel.setBounds(60, 261, 688, 174);
		contentPane.add(drinksPanel);
		drinksPanel.setLayout(null);
		drinksPanel.setVisible(true);
		drinksPanel.setBackground(new Color(248, 248, 248));
		
		
		ramunePanel.setBounds(465, 11, 203, 151);
		drinksPanel.add(ramunePanel);
		ramunePanel.setLayout(null);
		ramunePanel.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_3_2_1_1 = new JLabel("Ramune");
		lblNewLabel_3_2_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		lblNewLabel_3_2_1_1.setBounds(10, 11, 104, 34);
		ramunePanel.add(lblNewLabel_3_2_1_1);
		
		JLabel lblNewLabel_4_2_1_1 = new JLabel("Drinks");
		lblNewLabel_4_2_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblNewLabel_4_2_1_1.setBounds(10, 39, 46, 14);
		ramunePanel.add(lblNewLabel_4_2_1_1);
		
		JLabel lblNewLabel_5_2_1_1 = new JLabel("₱ 25");
		lblNewLabel_5_2_1_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_5_2_1_1.setBounds(10, 126, 46, 14);
		ramunePanel.add(lblNewLabel_5_2_1_1);
		
		JLabel ramune = new JLabel("");
		ramune.setHorizontalAlignment(SwingConstants.CENTER);
		ramune.setBounds(68, 39, 125, 101);
		ramunePanel.add(ramune);
		
		ramune.setIcon(newImageIcon9);
		
		
		cocacolaPanel.setBounds(252, 11, 203, 151);
		drinksPanel.add(cocacolaPanel);
		cocacolaPanel.setLayout(null);
		cocacolaPanel.setBackground(Color.WHITE);
		
		
		coke = new JLabel("Coke");
		coke.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		coke.setBounds(10, 11, 104, 34);
		cocacolaPanel.add(coke);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Drinks");
		lblNewLabel_4_2_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblNewLabel_4_2_1.setBounds(10, 39, 46, 14);
		cocacolaPanel.add(lblNewLabel_4_2_1);
		
		JLabel lblNewLabel_5_2_1 = new JLabel("₱ 20");
		lblNewLabel_5_2_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_5_2_1.setBounds(10, 126, 46, 14);
		cocacolaPanel.add(lblNewLabel_5_2_1);
		
		JLabel cokeImage = new JLabel("");
		cokeImage.setHorizontalAlignment(SwingConstants.CENTER);
		cokeImage.setBounds(68, 39, 125, 101);
		cocacolaPanel.add(cokeImage);
		
		cokeImage.setIcon(newImageIcon8);
		
		
		waterPanel.setBounds(39, 11, 203, 151);
		drinksPanel.add(waterPanel);
		waterPanel.setLayout(null);
		waterPanel.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_3_2 = new JLabel("Water");
		lblNewLabel_3_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		lblNewLabel_3_2.setBounds(10, 11, 104, 34);
		waterPanel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_4_2 = new JLabel("Drinks");
		lblNewLabel_4_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblNewLabel_4_2.setBounds(10, 39, 46, 14);
		waterPanel.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_5_2 = new JLabel("₱ 10");
		lblNewLabel_5_2.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_5_2.setBounds(10, 126, 46, 14);
		waterPanel.add(lblNewLabel_5_2);
		
		JLabel waterImage = new JLabel("");
		waterImage.setHorizontalAlignment(SwingConstants.CENTER);
		waterImage.setBounds(68, 59, 125, 81);
		waterPanel.add(waterImage);
		
		waterImage.setIcon(newImageIcon7);
		
		
		eggBurger.setBounds(38, 11, 203, 151);
		burgerPanel.add(eggBurger);
		eggBurger.setBackground(new Color(255, 255, 255));
		eggBurger.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Burger and Egg");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(10, 11, 131, 34);
		eggBurger.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Meal");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(10, 39, 46, 14);
		eggBurger.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("₱ 30");
		lblNewLabel_5.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(10, 126, 46, 14);
		eggBurger.add(lblNewLabel_5);
		
		
		JLabel burgerImage = new JLabel("");
		burgerImage.setBounds(68, 39, 125, 101);
		eggBurger.add(burgerImage);
		burgerImage.setIcon(newImageIcon3);
		
		
		cheeseBurger.setBounds(251, 11, 203, 151);
		burgerPanel.add(cheeseBurger);
		cheeseBurger.setLayout(null);
		cheeseBurger.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_3_1 = new JLabel("Cheese Burger");
		lblNewLabel_3_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		lblNewLabel_3_1.setBounds(10, 11, 118, 34);
		cheeseBurger.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Meal");
		lblNewLabel_4_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblNewLabel_4_1.setBounds(10, 39, 46, 14);
		cheeseBurger.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("₱ 40");
		lblNewLabel_5_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_5_1.setBounds(10, 126, 46, 14);
		cheeseBurger.add(lblNewLabel_5_1);
		
		JLabel burgerImage_1 = new JLabel("");
		burgerImage_1.setHorizontalAlignment(SwingConstants.CENTER);
		burgerImage_1.setBounds(68, 56, 125, 84);
		cheeseBurger.add(burgerImage_1);
		
		burgerImage_1.setIcon(newImageIcon5);
		
		
		
		hotdogPanel.setBounds(464, 11, 203, 151);
		burgerPanel.add(hotdogPanel);
		hotdogPanel.setLayout(null);
		hotdogPanel.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Hotdog");
		lblNewLabel_3_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		lblNewLabel_3_1_1.setBounds(10, 11, 135, 34);
		hotdogPanel.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Meal");
		lblNewLabel_4_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblNewLabel_4_1_1.setBounds(10, 39, 46, 14);
		hotdogPanel.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("₱ 30");
		lblNewLabel_5_1_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_5_1_1.setBounds(10, 126, 46, 14);
		hotdogPanel.add(lblNewLabel_5_1_1);
		
		JLabel burgerImage_1_1 = new JLabel("");
		burgerImage_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		burgerImage_1_1.setBounds(68, 56, 125, 84);
		hotdogPanel.add(burgerImage_1_1);
		
		burgerImage_1_1.setIcon(newImageIcon6);
		
	
		quantityManager.setBackground(new Color(255, 255, 255));
		quantityManager.setVisible(false);
		quantityManager.setBounds(99, 439, 664, 188);
		contentPane.add(quantityManager);
		quantityManager.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Item Quantity");
		lblNewLabel_2.setBounds(10, 21, 165, 23);
		quantityManager.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		
		init1();
	
	}
	
	void init1() {
		
		list.setFont(new Font("Verdana", Font.PLAIN, 18));
		
		//Jist
		
		list.setEnabled(false);
		priceList.setEnabled(false);
		quantiList.setEnabled(false);
		
		list.setFixedCellHeight(50);
		list.setFixedCellWidth(100);
		priceList.setFont(new Font("Verdana", Font.PLAIN, 18));
		priceList.setFixedCellHeight(50);
		priceList.setFixedCellWidth(100);
		quantiList.setFixedCellHeight(50);
		quantiList.setFixedCellWidth(100);
		list.setBounds(63, 29, 177, 303);
		
		burgerPanel.setBounds(60, 84, 688, 174);
		contentPane.add(burgerPanel);
		burgerPanel.setLayout(null);
		burgerPanel.setBackground(new Color(248, 248, 248));

		itemQuantityField = new JTextField();
		itemQuantityField.setBounds(148, 11, 175, 43);
		quantityManager.add(itemQuantityField);
		itemQuantityField.setHorizontalAlignment(SwingConstants.CENTER);
		itemQuantityField.setFont(new Font("Verdana", Font.PLAIN, 18));
		itemQuantityField.setColumns(10);
		
		
		decrement.setBounds(351, 15, 51, 43);
		quantityManager.add(decrement);
		decrement.setFocusable(false);
		
		
		increment.setBounds(412, 15, 51, 43);
		quantityManager.add(increment);
		increment.setFocusable(false);
		
		
		button1.setFocusable(false);
		button1.setBounds(10, 65, 152, 43);
		quantityManager.add(button1);
		
		
		button2.setFocusable(false);
		button2.setBounds(172, 65, 152, 43);
		quantityManager.add(button2);
		
		button3.setFocusable(false);
		button3.setBounds(10, 119, 152, 43);
		quantityManager.add(button3);
		
		
		button5.setFocusable(false);
		button5.setBounds(172, 119, 152, 43);
		quantityManager.add(button5);
		
		addToCart.setFocusable(false);
		addToCart.setVisible(false);
		addToCart.setBounds(372, 119, 269, 43);
		quantityManager.add(addToCart);
		
		addToCart1.setFocusable(false);
		addToCart1.setVisible(false);
		addToCart1.setBounds(372, 119, 269, 43);
		quantityManager.add(addToCart1);
		
		addToCart2.setFocusable(false);
		addToCart2.setVisible(false);
		addToCart2.setBounds(372, 119, 269, 43);
		quantityManager.add(addToCart2);
		
		addToCart3.setFocusable(false);
		addToCart3.setVisible(false);
		addToCart3.setBounds(372, 119, 269, 43);
		quantityManager.add(addToCart3);
		
		addToCart4.setFocusable(false);
		addToCart4.setVisible(false);
		addToCart4.setBounds(372, 119, 269, 43);
		quantityManager.add(addToCart4);
		
		addToCart5.setFocusable(false);
		addToCart5.setVisible(false);
		addToCart5.setBounds(372, 119, 269, 43);
		quantityManager.add(addToCart5);
		
	}
	
	
	 int calculateSum() {
	        int sum = 0;

	        // Calculator for Jlist
	        for (int i = 0; i < priceListdlm.getSize(); i++) {
	            sum += (Integer) priceListdlm.getElementAt(i);
	        }

	        return sum;
	    }
}
