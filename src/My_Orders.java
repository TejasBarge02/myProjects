import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
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
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import javax.swing.JTextField;

public class My_Orders{
	
	private JTable table;
	DefaultTableModel model;
	private JTextField textField;
	int a1;
	
	public My_Orders(){
		JFrame b=new JFrame("Shopzyyy/My_Cart/My_Orders");
		b.getContentPane().setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		b.getContentPane().setBackground(new Color(255, 240, 245));
		b.setBounds(100, 100, 1539, 873);//to set dimensions of the frame
		b.setLocationRelativeTo(null);
		b.getContentPane().setLayout(null);
		b.setVisible(true);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopzzy","root","root@123");

			
			JLabel lblNewLabel = new JLabel("Enter Your Email ID:");
			lblNewLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
			lblNewLabel.setBounds(491, 10, 214, 90);
			b.getContentPane().add(lblNewLabel);
			
			textField = new JTextField();
			textField.setBounds(715, 35, 305, 46);
			b.getContentPane().add(textField);
			textField.setColumns(10);
			

			
			
			JButton btnNewButton = new JButton("Verify");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {


					
					
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopzzy","root","root@123");
						String str="Select * from shopzzy.registrations where email=?";
						PreparedStatement ps = con.prepareStatement(str);
						ps.setString(1, textField.getText());
						ResultSet rs=ps.executeQuery();
						if(rs.next())
						{

							
							
							
							b.setVisible(false);
							new My_Orders1();
							

						}
						else {
							JOptionPane.showMessageDialog(null,"Invalid Email!!!");
							b.setVisible(false);
							new Home();}
						JButton btnNewButton_3 = new JButton("X");
						btnNewButton_3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								b.setVisible(false);
								new Home();
							}
						});
						btnNewButton_3.setForeground(Color.WHITE);
						btnNewButton_3.setBackground(Color.RED);
						btnNewButton_3.setFont(new Font("Calibri", Font.BOLD, 23));
						btnNewButton_3.setBounds(1491, 0, 47, 47);
						b.getContentPane().add(btnNewButton_3);		
					}catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				}
			});
			btnNewButton.setBackground(new Color(255, 255, 102));
			btnNewButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
			btnNewButton.setBounds(1077, 40, 166, 34);
			b.getContentPane().add(btnNewButton);
			
			JLabel lblNewLabel_1 = new JLabel("New label");
			lblNewLabel_1.setIcon(new ImageIcon("D:\\VIT\\Sem3\\Notes\\SBL-Java\\Programs\\Mini_Project\\Resources\\istockphoto-472674192-1024x1024 (1).png"));
			lblNewLabel_1.setBounds(0, 0, 1525, 836);
			b.getContentPane().add(lblNewLabel_1);
		
			 
			
			

			

			

			
			
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
    }
	public static void main(String[] args) {
		new My_Orders();
	}
}
