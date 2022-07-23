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
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class Forgot_Password{
	int secques;
	private JPasswordField answer;
	private JPasswordField password1;
	private JPasswordField password2;
	private JTextField email;
	static int p=0;
	private static void isPasswordValid(String password) 
	{
		if(password.length()<8) {
			p=1;
			
		}
		if(true) {
			int count=0;
			for (int i=0;i<=9;i++) {
				String str1=Integer.toString(i);
				if(password.contains(str1)) {
					count=1;
				}
			}
			if(count==0) {
				p=1;
			}
		}
		Pattern specialCharPattern=Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
		if(!specialCharPattern.matcher(password).find()) {
			p=1;
		}
		
	}
	public Forgot_Password(){

		JFrame f=new JFrame("Shopzyyy/Login");
		f.getContentPane().setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		f.getContentPane().setBackground(new Color(255, 240, 245));
		f.setBounds(100, 100, 1603, 882);//to set dimensions of the frame
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		
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
		
		JLabel lblNewLabel_3 = new JLabel("New label");
	lblNewLabel_3.setIcon(new ImageIcon("D:\\VIT\\Sem3\\Notes\\SBL-Java\\Programs\\Mini_Project\\Resources\\login logo.jpg"));
		lblNewLabel_3.setBounds(709, 135, 114, 114);
		f.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
		lblNewLabel_1.setBackground(Color.YELLOW);
		lblNewLabel_1.setBounds(583, 307, 159, 33);
		f.getContentPane().add(lblNewLabel_1);
		
		email = new JTextField();
		email.setBounds(797, 309, 144, 33);
		f.getContentPane().add(email);
		email.setColumns(10);
		f.setVisible(true);
		
		JLabel lblNewLabel_8 = new JLabel("Security Question:");
		lblNewLabel_8.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
		lblNewLabel_8.setBackground(Color.YELLOW);
		lblNewLabel_8.setBounds(583, 377, 171, 33);
		f.getContentPane().add(lblNewLabel_8);
		
		JComboBox sec_ques = new JComboBox();
		sec_ques.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value= sec_ques.getSelectedItem().toString();
				if(value.equals("What is your mother's name?"))
				{
					secques=1;
				}
				else if(value.equals("What was the name of your school?"))
				{
					secques=2;
				}
				else if(value.equals("Which city do you live in?"))
				{
					secques=3;}
				else
					secques=4;
			}
		});
		sec_ques.setModel(new DefaultComboBoxModel(new String[] {"What is your mother's name?","What was the name of your school?","Which city do you live in?","What is your favourite sport?"}));
		sec_ques.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
		sec_ques.setBounds(797, 377, 296, 33);
		f.getContentPane().add(sec_ques);
		
		JLabel lblNewLabel_2 = new JLabel("Answer:");
		lblNewLabel_2.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(583, 447, 159, 33);
		f.getContentPane().add(lblNewLabel_2);
		
		answer = new JPasswordField();
		answer.setBounds(797, 447, 144, 33);
		f.getContentPane().add(answer);
		
		JLabel lblNewLabel_6 = new JLabel("Choose Password:");
		lblNewLabel_6.setForeground(Color.BLACK);
		lblNewLabel_6.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(583, 517, 171, 33);
		f.getContentPane().add(lblNewLabel_6);
		
		password1 = new JPasswordField();
		password1.setBounds(797, 517, 144, 33);
		f.getContentPane().add(password1);
		

		JLabel lblNewLabel_7 = new JLabel("Re-Enter Password:");
		lblNewLabel_7.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
		lblNewLabel_7.setBounds(583, 587, 171, 33);
		f.getContentPane().add(lblNewLabel_7);
		
		password2 = new JPasswordField();
		password2.setBounds(797, 587, 144, 33);
		f.getContentPane().add(password2);
		
		JButton btnNewButton_1 = new JButton("Change Password");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopzzy","root","root@123");
					Statement stmt=con.createStatement();
					String sql="Select * from shopzzy.registrations where Email='"+email.getText()+"'and SecQuesId='"+secques+"'and Answer='"+answer.getText()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next())
					{
						isPasswordValid(password1.getText().toString());
						if(p==1) {
							JOptionPane.showMessageDialog(null, "Invalid Password!!!\nValid Password Contains:\n1. 8 characters\n2. Atleast one digit and special symbol");}
						else if(!password1.getText().toString().equals(password2.getText().toString()))
							JOptionPane.showMessageDialog(null, "Your Password Doesn't matches!!!");
						else {
							PreparedStatement ps = con.prepareStatement("UPDATE shopzzy.registrations SET Password=? WHERE Email=?");
							ps.setString(1,password1.getText());
							ps.setString(2,email.getText());
							ps.executeUpdate();
								JOptionPane.showMessageDialog(null, "Password Changed Successfully!!! Kindly login");
								f.setVisible(false);
								new Login();

							}
					}
					else
						JOptionPane.showMessageDialog(null,"Invalid Credentials!!!");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				;
				}
			}
		});
		btnNewButton_1.setBackground(Color.YELLOW);
		btnNewButton_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
		btnNewButton_1.setBounds(683, 667, 198, 33);
		f.getContentPane().add(btnNewButton_1);
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\VIT\\Sem3\\Notes\\SBL-Java\\Programs\\Mini_Project\\Resources\\5-of-the-best-password-reset-emails.png"));
		lblNewLabel.setBounds(0, 0, 1538, 845);
		f.getContentPane().add(lblNewLabel);
		
	}
	public static void main(String[] args) {
			new Forgot_Password();
	}
}



