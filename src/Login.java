import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Login{
	int uid;
	private JTextField username;
	private JPasswordField password;
	public Login(){

		JFrame f=new JFrame("Shopzyyy/Login");
		f.getContentPane().setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		f.getContentPane().setBackground(new Color(255, 240, 245));
		f.setBounds(100, 100, 1603, 882);//to set dimensions of the frame
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(569, 179 , 400, 400);
		f.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
		lblNewLabel_1.setBackground(Color.YELLOW);
		lblNewLabel_1.setBounds(583, 287, 159, 33);
		f.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(583, 387, 171, 33);
		f.getContentPane().add(lblNewLabel_2);
		
		username = new JTextField();
		username.setBounds(797, 287, 144, 33);
		f.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(797, 388, 144, 33);
		f.getContentPane().add(password);
					
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopzzy","root","root@123");
					Statement stmt=con.createStatement();
					String sql="Select * from shopzzy.registrations where Username='"+username.getText()+"' and Password='"+password.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next())
					{
						JOptionPane.showMessageDialog(null,"Login Successful!!!");
						f.setVisible(false);
						new Home();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Invalid Credentials!!!");
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				;
				}
			}
		});
		btnNewButton.setBackground(Color.YELLOW);
		btnNewButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
		btnNewButton.setBounds(697, 485, 126, 33);
		f.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Forgot Password");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				new Forgot_Password();
			}
		});
		btnNewButton_1.setBackground(Color.YELLOW);
		btnNewButton_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
		btnNewButton_1.setBounds(962, 573, 198, 33);
		f.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New User");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				new New_User();
			}
		});
		btnNewButton_2.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
		btnNewButton_2.setBackground(Color.YELLOW);
		btnNewButton_2.setBounds(433, 573, 126, 33);
		f.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\VIT\\Sem3\\Notes\\SBL-Java\\Programs\\Mini_Project\\Resources\\login logo.jpg"));
		lblNewLabel_3.setBounds(709, 135, 114, 114);
		f.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton_3 = new JButton("X");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				new Home();
			}
		});
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.RED);
		btnNewButton_3.setFont(new Font("Calibri", Font.BOLD, 23));
		btnNewButton_3.setBounds(1491, 0, 47, 47);
		f.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\VIT\\Sem3\\Notes\\SBL-Java\\Programs\\Mini_Project\\Resources\\online_shopping_addiction-scaled.png"));
		lblNewLabel_4.setBounds(0, 0, 1538, 856);
		f.getContentPane().add(lblNewLabel_4);
		f.setVisible(true);
	}
	public int getuid()
	{
		return uid;
	}
	public static void main(String[] args) {
		new Login();
	}
}


