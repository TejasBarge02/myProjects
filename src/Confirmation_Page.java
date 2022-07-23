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

public class Confirmation_Page{
	
	private JTable table;
	DefaultTableModel model;
	private JTextField textField;
	int a1;
	
	public Confirmation_Page(){
		JFrame b=new JFrame("Shopzyyy/My_Cart/Confirmation_Page");
		b.getContentPane().setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		b.getContentPane().setBackground(new Color(255, 240, 245));
		b.setBounds(100, 100, 1603, 882);//to set dimensions of the frame
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
			
			PreparedStatement ps4= con.prepareStatement("Select * from shopzzy.mycart");
			ResultSet rs4 = ps4.executeQuery();
			
			
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

							
							PreparedStatement ps3 = con.prepareStatement("insert into shopzzy.orders (PCODE,PRICE,QUANTITY,AMOUNT) select pcode,Price,quantity,amount from shopzzy.mycart");
							ps3.executeUpdate();
							
							java.util.Date date=new java.util.Date();
							java.sql.Date sqlDate=new java.sql.Date(date.getTime());
							java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
							PreparedStatement ps1=con.prepareStatement("update shopzzy.orders set DATE=? , TIME=?");
							ps1.setDate(1,sqlDate);
							ps1.setTimestamp(2,sqlTime);
							ps1.executeUpdate();
							
							int a=0;
							PreparedStatement ps11 = con.prepareStatement("Select * from shopzzy.registrations where email=?");
							ps11.setString(1, textField.getText());
							ResultSet rs1=ps11.executeQuery();
							if(rs1.next())
								a=rs1.getInt("userid");
							
							PreparedStatement ps2 = con.prepareStatement("Update shopzzy.orders set UID=?");
							ps2.setInt(1, a);
							ps2.executeUpdate();
							

							
							
							JLabel lblNewLabel_1 = new JLabel("Total= Rs ");
							lblNewLabel_1.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
							lblNewLabel_1.setBounds(1221, 736, 151, 63);
							b.getContentPane().add(lblNewLabel_1);
							
							
							String str2="Select sum(amount) from shopzzy.mycart";
							PreparedStatement ps111 = con.prepareStatement(str2);
							ResultSet rs11=ps111.executeQuery();
							if(rs11.next()) {
								a1=rs11.getInt("sum(amount)");}
							
							b.setVisible(false);
							new Confirmation_Page1();
							

						}
						else
							JOptionPane.showMessageDialog(null,"Invalid Email!!!");
							
							
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
			
			JLabel lblNewLabel_2 = new JLabel("New label");
			lblNewLabel_2.setIcon(new ImageIcon("D:\\VIT\\Sem3\\Notes\\SBL-Java\\Programs\\Mini_Project\\Resources\\complete-list-of-social-media-verification-forms.png"));
			lblNewLabel_2.setBounds(0, 0, 1540, 845);
			b.getContentPane().add(lblNewLabel_2);
		
			 
			
			

			

			

			
			
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
    }
	public static void main(String[] args) {
		new Confirmation_Page();
	}
}

