import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
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
import javax.swing.JFormattedTextField;
import javax.swing.DropMode;
import javax.swing.JTextField;
public class Mens_Top_Wear_2{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public Mens_Top_Wear_2(){
		JFrame b=new JFrame("Shopzyyy/Home/Mens_Top_Wear_2");
		b.getContentPane().setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		b.getContentPane().setBackground(new Color(255, 240, 245));
		b.setBounds(100, 100, 1603, 882);//to set dimensions of the frame
		b.setLocationRelativeTo(null);
		b.getContentPane().setLayout(null);
		b.setVisible(true);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopzzy","root","root@123");
			JButton Mens_Top_Wear_2 = new JButton("Home");
		Mens_Top_Wear_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b.setVisible(false);
				new Home();
			}
		});
		Mens_Top_Wear_2.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		Mens_Top_Wear_2.setBounds(10, 10, 117, 21);
		Mens_Top_Wear_2.setForeground(new Color(0, 0, 0));
		Mens_Top_Wear_2.setBackground(new Color(255, 255, 102));
		b.getContentPane().add(Mens_Top_Wear_2);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(220, 220, 220));
		textPane.setBounds(137, 10, 998, 21);
		b.getContentPane().add(textPane);
		
		JButton Cart = new JButton("My Cart");
		Cart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b.setVisible(false);
				new My_Cart();
			}
		});
		Cart.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		Cart.setBackground(new Color(255, 255, 102));
		Cart.setBounds(1413, 10, 117, 21);
		b.getContentPane().add(Cart);
		
		JButton login = new JButton("Login/Sign up");
		login.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		login.setBackground(new Color(255, 255, 102));
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b.setVisible(false);
				new Login();
			}
		});
		login.setBounds(1145, 10, 131, 21);
		b.getContentPane().add(login);
		
		JButton orders = new JButton("My Orders");
		orders.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		orders.setBackground(new Color(255, 255, 102));
		orders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b.setVisible(false);
				new My_Orders();
			}
		});
		orders.setBounds(1286, 10, 117, 21);
		b.getContentPane().add(orders);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\VIT\\Sem3\\Notes\\SBL-Java\\Programs\\Mini_Project\\Resources\\Mens top wear\\mt5.jpg"));
		lblNewLabel.setBounds(45, 125, 325, 325);
		b.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("<html>Pack of :1 <br>\r\nStyle Code : TS-SHIRT1029 <br>\r\nClosure :Buttoned <br>\r\nFit: Regular <br>\r\nFabric: Cotton Blend <br>\r\nSleeve: Full Sleeve <br>\r\nPattern :Checkered <br>\r\nReversible :No <br></html");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_4.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNewLabel_4.setBounds(45, 480, 294, 168);
		b.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Rs 600/-");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNewLabel_5.setBounds(45, 642, 325, 63);
		b.getContentPane().add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(311, 480, 59, 47);
		b.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD TO CART");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int a = 0;
					String sql1= "Select * from shopzzy.product where productcode=?";
					PreparedStatement st1 = con.prepareStatement(sql1);
					st1.setString(1, "02MT01");
					ResultSet rs1=st1.executeQuery();
					if(rs1.next())
					{
//						String sql2= "Select * from shopzzy.product where productcode=?";
//						PreparedStatement st2 = con.prepareStatement(sql1);
//						st2.setString(1, "01MT01");
						a=rs1.getInt("Price");

					}
					String sql = "Insert into shopzzy.mycart (pcode, Price, quantity) Values(?,?,?)";
					PreparedStatement st = con.prepareStatement(sql);
					st.setString(1, "02MT01");
					st.setInt(2, a);
					String s=textField.getText();
					st.setInt(3,Integer.parseInt(s));
					st.executeUpdate();
//					if(rs.next())
							JOptionPane.showMessageDialog(null, "Sucessfully added to cart!!");

				

					} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		btnNewButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		btnNewButton.setBackground(Color.YELLOW);
		btnNewButton.setBounds(137, 715, 131, 47);
		b.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\VIT\\Sem3\\Notes\\SBL-Java\\Programs\\Mini_Project\\Resources\\Mens top wear\\mt6.jpg"));
		lblNewLabel_1.setBounds(421, 125, 325, 325);
		b.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_6 = new JLabel("<html>100% Cotton <br>\r\nItalian Fabric <br>\r\nClosure :Buttoned <br>\r\nButton Closure <br>\r\nPatch Pocket <br>\r\nSleeve: Full Sleeve <br>\r\nLocker Loop <br>\r\nCurved Hem <br></html");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_6.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNewLabel_6.setBounds(421, 480, 294, 168);
		b.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Rs 600/-");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNewLabel_7.setBounds(421, 642, 325, 63);
		b.getContentPane().add(lblNewLabel_7);
		
		textField_1 = new JTextField();
		textField_1.setBounds(687, 480, 59, 47);
		b.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("ADD TO CART");
		btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				int a = 0;
				String sql1= "Select * from shopzzy.product where productcode=?";
				PreparedStatement st1 = con.prepareStatement(sql1);
				st1.setString(1, "02MT02");
				ResultSet rs1=st1.executeQuery();
				if(rs1.next())
				{
//					String sql2= "Select * from shopzzy.product where productcode=?";
//					PreparedStatement st2 = con.prepareStatement(sql1);
//					st2.setString(1, "01MT01");
					a=rs1.getInt("Price");

				}
				String sql = "Insert into shopzzy.mycart (pcode, Price, quantity) Values(?,?,?)";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, "02MT02");
				st.setInt(2, a);
				String s=textField_1.getText();
				st.setInt(3,Integer.parseInt(s));
				st.executeUpdate();
//				if(rs.next())
						JOptionPane.showMessageDialog(null, "Sucessfully added to cart!!");

			

				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	});
		btnNewButton_2.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		btnNewButton_2.setBackground(Color.YELLOW);
		btnNewButton_2.setBounds(515, 715, 131, 46);
		b.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\VIT\\Sem3\\Notes\\SBL-Java\\Programs\\Mini_Project\\Resources\\Mens top wear\\mt7.jpg"));
		lblNewLabel_2.setBounds(805, 125, 325, 325);
		b.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_8 = new JLabel("<html>Secondary Color :Maroon <br>\r\nStyle Code : Closure :Butoned <br>\r\nClosure :Buttoned <br>\r\nFit :Slim <br>\r\nFabric: Cotton Blend <br>\r\nFabric :Cotton Blend <br>\r\nSleeve :Full Sleeve <br>\r\nPattern : Checkered<br></html");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_8.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_8.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNewLabel_8.setBounds(805, 480, 314, 168);
		b.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Rs 600/-");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNewLabel_9.setBounds(805, 642, 325, 63);
		b.getContentPane().add(lblNewLabel_9);
		
		textField_2 = new JTextField();
		textField_2.setBounds(1076, 480, 59, 47);
		b.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("ADD TO CART");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int a = 0;
					String sql1= "Select * from shopzzy.product where productcode=?";
					PreparedStatement st1 = con.prepareStatement(sql1);
					st1.setString(1, "02MT03");
					ResultSet rs1=st1.executeQuery();
					if(rs1.next())
					{
//						String sql2= "Select * from shopzzy.product where productcode=?";
//						PreparedStatement st2 = con.prepareStatement(sql1);
//						st2.setString(1, "01MT01");
						a=rs1.getInt("Price");

					}
					String sql = "Insert into shopzzy.mycart (pcode, Price, quantity) Values(?,?,?)";
					PreparedStatement st = con.prepareStatement(sql);
					st.setString(1, "02MT03");
					st.setInt(2, a);
					String s=textField_2.getText();
					st.setInt(3,Integer.parseInt(s));
					st.executeUpdate();
//					if(rs.next())
							JOptionPane.showMessageDialog(null, "Sucessfully added to cart!!");

				

					} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_3.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		btnNewButton_3.setBackground(Color.YELLOW);
		btnNewButton_3.setBounds(1272, 715, 131, 46);
		b.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\VIT\\Sem3\\Notes\\SBL-Java\\Programs\\Mini_Project\\Resources\\Mens top wear\\mt8.jpg"));
		lblNewLabel_3.setBounds(1170, 125, 325, 325);
		b.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_10 = new JLabel("<html>Secondary Color ;Black <br>\r\nClosure :Button <br>\r\nFit: Regular<br>\r\nFit: Regular <br>\r\nFabric :Pure Cotton <br>\r\nSleeve: Full Sleeve <br>\r\nPattern :Solid <br></html");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_10.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_10.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNewLabel_10.setBounds(1170, 480, 314, 168);
		b.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Rs 650/-");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblNewLabel_11.setBounds(1170, 642, 325, 63);
		b.getContentPane().add(lblNewLabel_11);
		
		textField_3 = new JTextField();
		textField_3.setBounds(1436, 480, 59, 47);
		b.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("ADD TO CART");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int a = 0;
					String sql1= "Select * from shopzzy.product where productcode=?";
					PreparedStatement st1 = con.prepareStatement(sql1);
					st1.setString(1, "02MT04");
					ResultSet rs1=st1.executeQuery();
					if(rs1.next())
					{
//						String sql2= "Select * from shopzzy.product where productcode=?";
//						PreparedStatement st2 = con.prepareStatement(sql1);
//						st2.setString(1, "01MT01");
						a=rs1.getInt("Price");

					}
					String sql = "Insert into shopzzy.mycart (pcode, Price, quantity) Values(?,?,?)";
					PreparedStatement st = con.prepareStatement(sql);
					st.setString(1, "02MT04");
					st.setInt(2, a);
					String p=textField_3.getText();
					st.setInt(3,Integer.parseInt(p));
					st.executeUpdate();
//					if(rs.next())
							JOptionPane.showMessageDialog(null, "Sucessfully added to cart!!");

				

					} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_4.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		btnNewButton_4.setBackground(Color.YELLOW);
		btnNewButton_4.setBounds(900, 715, 131, 46);
		b.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton1 = new JButton("PREVIOUS");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b.setVisible(false);
				new Mens_Top_Wear_1();
			}
		});
		btnNewButton1.setBackground(new Color(255, 255, 102));
		btnNewButton1.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		btnNewButton1.setBounds(10, 780, 137, 39);
		b.getContentPane().add(btnNewButton1);
		
		JButton btnNewButton_1 = new JButton("NEXT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b.setVisible(false);
				new Mens_Top_Wear_3();
			}
		});
		btnNewButton_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		btnNewButton_1.setBackground(new Color(255, 255, 102));
		btnNewButton_1.setBounds(1393, 780, 137, 39);
		b.getContentPane().add(btnNewButton_1);
		
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
	}
	public static void main(String[] args) {
		new Mens_Top_Wear_2();
	}
}
