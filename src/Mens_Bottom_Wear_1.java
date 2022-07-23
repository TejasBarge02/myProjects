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
public class Mens_Bottom_Wear_1{
	public Mens_Bottom_Wear_1(){
		JFrame b=new JFrame("Shopzyyy/Home/Mens_Bottom_Wear_1");
		b.getContentPane().setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		b.getContentPane().setBackground(new Color(255, 240, 245));
		b.setBounds(100, 100, 1603, 882);//to set dimensions of the frame
		b.setLocationRelativeTo(null);
		b.getContentPane().setLayout(null);
		b.setVisible(true);
				
		JButton Mens_Bottom_Wear_1 = new JButton("Home");
		Mens_Bottom_Wear_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b.setVisible(false);
				new Home();
			}
		});
		Mens_Bottom_Wear_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		Mens_Bottom_Wear_1.setBounds(10, 10, 117, 21);
		Mens_Bottom_Wear_1.setForeground(new Color(0, 0, 0));
		Mens_Bottom_Wear_1.setBackground(new Color(255, 255, 102));
		b.getContentPane().add(Mens_Bottom_Wear_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(220, 220, 220));
		textPane.setBounds(137, 10, 998, 21);
		b.getContentPane().add(textPane);
		
		JButton Cart = new JButton("My Cart");
		Cart.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		Cart.setBackground(new Color(255, 255, 102));
		Cart.setBounds(1413, 10, 117, 21);
		b.getContentPane().add(Cart);
		
		JButton login = new JButton("Login/Sign up");
		login.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		login.setBackground(new Color(255, 255, 102));
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		login.setBounds(1145, 10, 131, 21);
		b.getContentPane().add(login);
		
		JButton orders = new JButton("My Orders");
		orders.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		orders.setBackground(new Color(255, 255, 102));
		orders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		orders.setBounds(1286, 10, 117, 21);
		b.getContentPane().add(orders);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\VIT\\Sem3\\Notes\\SBL-Java\\Programs\\Mini_Project\\Resources\\Mens bottom wear\\mb1.jpg"));
		lblNewLabel.setBounds(45, 125, 325, 325);
		b.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\VIT\\Sem3\\Notes\\SBL-Java\\Programs\\Mini_Project\\Resources\\Mens bottom wear\\mb2.jpg"));
		lblNewLabel_1.setBounds(421, 125, 325, 325);
		b.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\VIT\\Sem3\\Notes\\SBL-Java\\Programs\\Mini_Project\\Resources\\Mens bottom wear\\mb5.jpg"));
		lblNewLabel_2.setBounds(805, 125, 325, 325);
		b.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\VIT\\Sem3\\Notes\\SBL-Java\\Programs\\Mini_Project\\Resources\\Mens bottom wear\\mb4.jpg"));
		lblNewLabel_3.setBounds(1170, 125, 325, 325);
		b.getContentPane().add(lblNewLabel_3);
		

		
		JButton btnNewButton_1 = new JButton("NEXT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b.setVisible(false);
				new Mens_Bottom_Wear_2();
			}
		});
		btnNewButton_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		btnNewButton_1.setBackground(new Color(255, 255, 102));
		btnNewButton_1.setBounds(1393, 780, 137, 39);
		b.getContentPane().add(btnNewButton_1);
	}
	public static void main(String[] args) {
		new Mens_Bottom_Wear_1();
	}
}
