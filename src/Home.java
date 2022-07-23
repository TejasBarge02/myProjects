import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.UIManager;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
public class Home{
	public Home(){
		JFrame f=new JFrame("Shopzyyy/Home");
		f.getContentPane().setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		f.getContentPane().setBackground(new Color(255, 240, 245));
		f.setBounds(100, 100, 1603, 882);//to set dimensions of the frame
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		f.setVisible(true);
				
		JButton Home = new JButton("Home");
		Home.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		Home.setBounds(10, 10, 117, 21);
		Home.setForeground(new Color(0, 0, 0));
		Home.setBackground(new Color(255, 255, 102));
		f.getContentPane().add(Home);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(220, 220, 220));
		textPane.setBounds(137, 10, 998, 21);
		f.getContentPane().add(textPane);
		
		JButton Cart = new JButton("My Cart");
		Cart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				new My_Cart();
			}
		});
		Cart.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		Cart.setBackground(new Color(255, 255, 102));
		Cart.setBounds(1413, 10, 117, 21);
		f.getContentPane().add(Cart);
		
		JButton login = new JButton("Login/Sign up");
		login.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		login.setBackground(new Color(255, 255, 102));
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				new Login();
			}
		});
		login.setBounds(1145, 10, 131, 21);
		f.getContentPane().add(login);
		
		JButton orders = new JButton("My Orders");
		orders.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		orders.setBackground(new Color(255, 255, 102));
		orders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				new My_Orders();
			}
		});
		orders.setBounds(1286, 10, 117, 21);
		f.getContentPane().add(orders);
		
		JComboBox All = new JComboBox();
		All.setBackground(new Color(255, 255, 153));
		All.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
	;
		All.setToolTipText("Fashion");
		All.setModel(new DefaultComboBoxModel(new String[] {"Men's Top Wear", "Men's Bottom Wear", "Men's Footwear", "Women's Top Wear", "Women's Bottom Wear", "Women's Footwear", "Smart Phones", "Home Appliances", "Boys Wear", "Girls Wear"}));
		All.setBounds(10, 96, 269, 30);
		All.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value= All.getSelectedItem().toString();
				if(value.equals("Men's Top Wear"))
				{
					f.setVisible(false);
					new Mens_Top_Wear_1();
				}
				else if(value.equals("Men's Bottom Wear"))
				{
					f.setVisible(false);
					new Mens_Bottom_Wear_1();
				}
				else if(value.equals("Men's Footwear"))
				{
					f.setVisible(false);
					new Mens_Footwear_1();
				}
				else if(value.equals("Women's Top Wear"))
				{
					f.setVisible(false);
					new Womens_Top_Wear_1();
				}
				else if(value.equals("Women's Bottom Wear"))
				{
					f.setVisible(false);
					new Womens_Bottom_Wear_1();
				}
				else if(value.equals("Women's Footwear"))
				{
					f.setVisible(false);
					new Womens_Footwear_1();
				}
				else if(value.equals("Smart Phones"))
				{
					f.setVisible(false);
					new Smart_Phones_1();
				}
				else if(value.equals("Home Appliances"))
				{
					f.setVisible(false);
					new Home_Appliances_1();
				}
				else if(value.equals("Boys_Wear"))
				{
					f.setVisible(false);
					new Boys_Wear();
				}
				else 
				{
					f.setVisible(false);
					new Girls_Wear();
				}
			}
		});
		
		f.getContentPane().add(All);
		
		JComboBox Men_Fashion = new JComboBox();
		Men_Fashion.setBackground(new Color(255, 255, 153));
		Men_Fashion.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		Men_Fashion.setModel(new DefaultComboBoxModel(new String[] {"Men's Top Wear", "Men's Bottom Wear", "Men's Footwear"}));
		Men_Fashion.setBounds(313, 96, 269, 30);
		Men_Fashion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value= Men_Fashion.getSelectedItem().toString();
				if(value.equals("Men's Top Wear"))
				{
					f.setVisible(false);
					new Mens_Top_Wear_1();
				}
				else if(value.equals("Men's Bottom Wear"))
				{
					f.setVisible(false);
					new Mens_Bottom_Wear_1();
				}
				else if(value.equals("Men's Footwear"))
				{
					f.setVisible(false);
					new Mens_Footwear_1();
				}
			}
		});
			
		f.getContentPane().add(Men_Fashion);
		
		JComboBox Women_Fashion = new JComboBox();
		Women_Fashion.setBackground(new Color(255, 255, 153));
		Women_Fashion.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		Women_Fashion.setModel(new DefaultComboBoxModel(new String[] {"Women's Top Wear", "Women's Bottom Wear", "Women's Footwear"}));
		Women_Fashion.setBounds(625, 96, 269, 30);
		Women_Fashion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value= Women_Fashion.getSelectedItem().toString();
				if(value.equals("Women's Top Wear"))
				{
					f.setVisible(false);
					new Womens_Top_Wear_1();
				}
				else if(value.equals("Women's Bottom Wear"))
				{
					f.setVisible(false);
					new Womens_Bottom_Wear_1();
				}
				else if(value.equals("Women's Footwear"))
				{
					f.setVisible(false);
					new Womens_Footwear_1();
				}
			}
		});
		f.getContentPane().add(Women_Fashion);
		
		JComboBox Electronics = new JComboBox();
		Electronics.setBackground(new Color(255, 255, 153));
		Electronics.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		Electronics.setModel(new DefaultComboBoxModel(new String[] {"Smart Phones", "Home Appliances"}));
		Electronics.setBounds(938, 96, 269, 30);
		Electronics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value= Electronics.getSelectedItem().toString();
				if(value.equals("Smart Phones"))
				{
					f.setVisible(false);
					new Smart_Phones_1();
				}
				else if(value.equals("Home Appliances"))
				{
					f.setVisible(false);
					new Home_Appliances_1();
				}
			}
		});
		f.getContentPane().add(Electronics);
		
		JComboBox Kids = new JComboBox();
		Kids.setBackground(new Color(255, 255, 153));
		Kids.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		Kids.setModel(new DefaultComboBoxModel(new String[] {"Boys Wear", "Girls Wear"}));
		Kids.setBounds(1261, 96, 269, 30);
		Kids.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value= Kids.getSelectedItem().toString();
			
				if(value.equals("Boys Wear"))
				{
					f.setVisible(false);
					new Boys_Wear();
				}
				else 
				{
					f.setVisible(false);
					new Girls_Wear();
				}
			}
		});
		f.getContentPane().add(Kids);
		
		JLabel lblNewLabel = new JLabel("          All");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setBounds(98, 56, 83, 30);
		f.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Men's Fashion");
		lblNewLabel_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(398, 56, 126, 30);
		f.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Women's Fashion");
		lblNewLabel_2.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(705, 56, 136, 30);
		f.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Electronics");
		lblNewLabel_3.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(1042, 56, 107, 30);
		f.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Kids ");
		lblNewLabel_4.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(1377, 56, 91, 30);
		f.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Poster 1");
		lblNewLabel_5.setIcon(new ImageIcon("D:\\VIT\\Sem3\\Notes\\SBL-Java\\Programs\\Mini_Project\\Resources\\poster\\poster 1.jpg"));
		lblNewLabel_5.setBackground(new Color(0, 0, 0));
		lblNewLabel_5.setBounds(0, 147, 1540, 350);
		f.getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("SHOP NOW");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		btnNewButton.setBackground(new Color(102, 255, 255));
		btnNewButton.setBounds(899, 449, 366, 30);
		f.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("Poster 2");
		lblNewLabel_6.setIcon(new ImageIcon("D:\\VIT\\Sem3\\Notes\\SBL-Java\\Programs\\Mini_Project\\Resources\\poster\\poster 2.jpg"));
		lblNewLabel_6.setBounds(0, 490, 770, 357);
		f.getContentPane().add(lblNewLabel_6);
		lblNewLabel_6.setBounds(0, 493, 770, 345);
		
		
		
		JLabel lblNewLabel_7 = new JLabel("Poster 3");
		lblNewLabel_7.setIcon(new ImageIcon("D:\\VIT\\Sem3\\Notes\\SBL-Java\\Programs\\Mini_Project\\Resources\\poster\\Poster 3.jpg"));
		lblNewLabel_7.setBounds(770, 477, 770, 345);
		f.getContentPane().add(lblNewLabel_7);
		
		JButton btnNewButton_1 = new JButton("SHOP NOW");
		btnNewButton_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		btnNewButton_1.setBackground(new Color(255, 102, 153));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(82, 728, 239, 38);
		f.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("SHOP NOW");
		btnNewButton_2.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBackground(new Color(255, 204, 102));
		btnNewButton_2.setBounds(1316, 752, 180, 38);
		f.getContentPane().add(btnNewButton_2);
		


	}
	public static void main(String[] args) {
		new Home();
	}
}
