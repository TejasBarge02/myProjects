import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.sql.Statement;
import java.util.regex.Pattern;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
public class New_User{
	static int p=0,u=0,m=0,pq=0;
	int secques,uid;
	private JTextField email;
	private JTextField username;
	private JTextField name;
	private JTextField mobile_no;
	private JPasswordField password1;
	private JPasswordField password2;
	private JTextField sec_ans;
	private final JButton btnNewButton_1 = new JButton("X");
	@SuppressWarnings("unchecked")
	private static void isUsernameValid(String username) 
	{

		Pattern specialCharPattern=Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
		if(specialCharPattern.matcher(username).find()) {
			u=1;
		}
		
	}
	private static void isMobileNoValid(String mobileno) 
	{
		if(mobileno.length()<10 || mobileno.length()>10) {
			m=1;
			
		}

		Pattern specialCharPattern=Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
		if(specialCharPattern.matcher(mobileno).find()) {
			m=1;
		}
	}
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
	
	private static void isEmailValid(String email) 
	{
		
		if(true) {
				String str1="@";
				String str2=".";
				if(email.contains(str1) && email.contains(str2))
					pq=0;
				else pq=1;
		}
	}
	
	public New_User(){
		JFrame f=new JFrame("Shopzyyy/New_User");
		f.getContentPane().setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
		f.getContentPane().setBackground(new Color(255, 240, 245));
		f.setBounds(100, 100, 1603, 882);//to set dimensions of the frame
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\VIT\\Sem3\\Notes\\SBL-Java\\Programs\\Mini_Project\\Resources\\login logo.jpg"));
		lblNewLabel_3.setBounds(709, 22, 114, 114);
		f.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Name:");
		lblNewLabel_4.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(583, 183, 159, 33);
		f.getContentPane().add(lblNewLabel_4);
		
		name = new JTextField();
		name.setBounds(797, 183, 144, 33);
		f.getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Mobile No. :");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
		lblNewLabel.setBounds(583, 253, 159, 33);
		f.getContentPane().add(lblNewLabel);
		
		mobile_no = new JTextField();
		mobile_no.setBounds(797, 253, 144, 33);
		f.getContentPane().add(mobile_no);
		mobile_no.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
		lblNewLabel_1.setBackground(Color.YELLOW);
		lblNewLabel_1.setBounds(583, 323, 159, 33);
		f.getContentPane().add(lblNewLabel_1);
		
		email = new JTextField();
		email.setBounds(797, 323, 144, 33);
		f.getContentPane().add(email);
		email.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Username:");
		lblNewLabel_2.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(583, 393, 171, 33);
		f.getContentPane().add(lblNewLabel_2);
		
		username = new JTextField();
		username.setBounds(797, 393, 144, 33);
		f.getContentPane().add(username);
		
		JLabel lblNewLabel_5 = new JLabel("Address:");
		lblNewLabel_5.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(583, 463, 159, 33);
		f.getContentPane().add(lblNewLabel_5);

		
		JTextArea address = new JTextArea();
		address.setBounds(797, 463, 144, 47);
		f.getContentPane().add(address);
		
		JLabel lblNewLabel_6 = new JLabel("Choose Password:");
		lblNewLabel_6.setForeground(Color.BLACK);
		lblNewLabel_6.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(583, 533, 159, 33);
		f.getContentPane().add(lblNewLabel_6);
		
		password1 = new JPasswordField();
		password1.setBounds(797, 533, 144, 33);
		f.getContentPane().add(password1);
		
		JLabel lblNewLabel_7 = new JLabel("Re-Enter Password:");
		lblNewLabel_7.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
		lblNewLabel_7.setBounds(583, 603, 171, 33);
		f.getContentPane().add(lblNewLabel_7);
		
		password2 = new JPasswordField();
		password2.setBounds(797, 603, 144, 33);
		f.getContentPane().add(password2);
		
		JLabel lblNewLabel_8 = new JLabel("Security Question:");
		lblNewLabel_8.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
		lblNewLabel_8.setBounds(583, 673, 171, 33);
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
		sec_ques.setBounds(797, 673, 417, 33);
		f.getContentPane().add(sec_ques);
		
		JLabel lblNewLabel_9 = new JLabel("Answer:");
		lblNewLabel_9.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
		lblNewLabel_9.setBounds(583, 743, 159, 33);
		f.getContentPane().add(lblNewLabel_9);
		
		sec_ans = new JTextField();
		sec_ans.setBounds(797, 743, 144, 33);
		f.getContentPane().add(sec_ans);
		sec_ans.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setIcon(new ImageIcon("D:\\VIT\\Sem3\\Notes\\SBL-Java\\Programs\\Mini_Project\\Resources\\image-shocked-young-brunette-lady-260nw-641814046.png"));
		lblNewLabel_10.setBounds(0, 0, 1540, 845);
		f.getContentPane().add(lblNewLabel_10);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				new Home();
			}
		});
		
		btnNewButton_1.setFont(new Font("Calibri", Font.BOLD, 23));
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(1493, 0, 47, 47);
		f.getContentPane().add(btnNewButton_1);
		
	JButton btnNewButton = new JButton("Sign Up");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopzzy","root","root@123");
				Statement stmt=con.createStatement();
				String sql1="Select * from shopzzy.registrations where Email='"+email.getText()+"or MobileNo="+mobile_no.getText()+"'";
				ResultSet rs1=stmt.executeQuery(sql1);
				isMobileNoValid(mobile_no.getText().toString());
				isUsernameValid(username.getText().toString());
				isPasswordValid(password1.getText().toString());
				isEmailValid(email.getText().toString());
				if(m==1) {
					JOptionPane.showMessageDialog(null, "Invalid mobile no.!!!\nValid Mobile No. Contains:\n1. Exactly 10 digits");
					f.setVisible(true);
					new New_User();
					}
				else if(u==1) {
					JOptionPane.showMessageDialog(null, "Invalid Username.!!!\n Username should not contain any special characters");
				f.setVisible(true);
				new New_User();
				}
				else if(p==1) {
					JOptionPane.showMessageDialog(null, "Invalid Password!!!\nValid Password Contains:\n1. 8 characters\n2. Atleast one digit and special symbol");
					f.setVisible(true);
					new New_User();
					p=0;
				}
				else if(pq==1) {
					JOptionPane.showMessageDialog(null, "Invalid Email ID!!!");
					f.setVisible(true);
					new New_User();
				}

				else if(!password1.getText().toString().equals(password2.getText().toString()))
				{
					JOptionPane.showMessageDialog(null, "Your Password Doesn't matches!!!");
				f.setVisible(true);
				new New_User();
				}
				else if(rs1.next())
				{
					JOptionPane.showMessageDialog(null,"Email or Mobile no. already exists!!! Kindly login.");
					f.setVisible(false);
					new Login();
				}
				else {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				
					Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopzzy","root","root@123");
					PreparedStatement ps = con1.prepareStatement("INSERT INTO shopzzy.registrations (userid, Name, MobileNo, Username, Address, Password, SecQuesId, Answer, Email) VALUES(?,?,?,?,?,?,?,?,?)");
					ps.setInt(1,uid);
					ps.setString(2,name.getText());
					ps.setString(3,mobile_no.getText());
					ps.setString(4,username.getText());
					ps.setString(5,address.getText());
					ps.setString(6,password1.getText());
					ps.setInt(7,secques);
					ps.setString(8,sec_ans.getText());
					ps.setString(9,email.getText());
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Sucessfully signed up!! Kindly Login");
					f.setVisible(false);
					new Login();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				;
				}
}
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
	});
	
	btnNewButton.setBackground(Color.YELLOW);
	btnNewButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
	btnNewButton.setBounds(1355, 743, 126, 33);
	f.getContentPane().add(btnNewButton);
	
	JLabel label = new JLabel("New label");
	label.setBounds(99, 603, 45, 13);
	f.getContentPane().add(label);
	f.setVisible(true);
	
}

	public static void main(String[] args) {
		new New_User();
	}
}
