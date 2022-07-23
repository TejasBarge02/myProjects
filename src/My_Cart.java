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

public class My_Cart{
	private JTable table;
	private JTable table1;
	DefaultTableModel model;
	private JTextField textField;
	
	public My_Cart(){
		JFrame b=new JFrame("Shopzyyy/Home/My_Cart");
		b.getContentPane().setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		b.getContentPane().setBackground(new Color(255, 240, 245));
		b.setBounds(100, 100, 1603, 882);//to set dimensions of the frame
		b.setLocationRelativeTo(null);
		b.getContentPane().setLayout(null);
		b.setVisible(true);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(416, 97, 702, 611);
		b.getContentPane().add(scrollPane);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopzzy","root","root@123");
			String str="Select * from mycart";
			PreparedStatement ps = con.prepareStatement(str);
			ResultSet rs=ps.executeQuery();
			table1 = new JTable();
			table1.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
			table1.setBackground(new Color(204, 255, 255));
			scrollPane.setViewportView(table1);
			table1.setModel(DbUtils.resultSetToTableModel(rs));
			
			JLabel lblNewLabel = new JLabel("<html>Enter Product Id of product to be <br>removed from cart:<html>");
			lblNewLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
			lblNewLabel.setBounds(10, 736, 289, 58);
			b.getContentPane().add(lblNewLabel);
			
			textField = new JTextField();
			textField.setBounds(309, 750, 151, 44);
			b.getContentPane().add(textField);
			textField.setColumns(10);
			
			JButton btnNewButton = new JButton("Remove");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String str1="select * from shopzzy.mycart where pcode=?";
						PreparedStatement ps = con.prepareStatement(str1);
						ps.setString(1, textField.getText());
						ResultSet rs1=ps.executeQuery();
						if(rs1.next()) {
							String str2="delete from shopzzy.mycart where pcode=?";
							PreparedStatement ps1 = con.prepareStatement(str2);
							ps1.setString(1, textField.getText());
							ps1.executeUpdate();
							JOptionPane.showMessageDialog(null, "Removed Sucessfully!!");
							b.setVisible(false);
							new My_Cart();
						}
						else
							JOptionPane.showMessageDialog(null, "Invalid Product Id");
							
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnNewButton.setBackground(new Color(255, 255, 102));
			btnNewButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
			btnNewButton.setBounds(10, 788, 170, 47);
			b.getContentPane().add(btnNewButton);
			
			JLabel lblNewLabel_1 = new JLabel("Total= Rs ");
			lblNewLabel_1.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
			lblNewLabel_1.setBounds(1221, 736, 151, 63);
			b.getContentPane().add(lblNewLabel_1);
			int a=0;
			
			String str2="Select sum(amount) from shopzzy.mycart";
			PreparedStatement ps1 = con.prepareStatement(str2);
			ResultSet rs1=ps1.executeQuery();
			if(rs1.next()) {
				a=rs1.getInt("sum(amount)");}
			JLabel lblNewLabel_2 = new JLabel(String.valueOf(a));
			lblNewLabel_2.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
			lblNewLabel_2.setBounds(1333, 736, 135, 63);
			b.getContentPane().add(lblNewLabel_2);
			
			JButton btnNewButton_1 = new JButton("Place Order");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					b.setVisible(false);
					new Confirmation_Page();
				}
			});
			btnNewButton_1.setBackground(new Color(255, 255, 102));
			btnNewButton_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
			btnNewButton_1.setBounds(1300, 352, 214, 63);
			b.getContentPane().add(btnNewButton_1);
			
			JLabel lblNewLabel_3 = new JLabel("New label");
			lblNewLabel_3.setIcon(new ImageIcon("D:\\VIT\\Sem3\\Notes\\SBL-Java\\Programs\\Mini_Project\\Resources\\esghseysm (1).png"));
			lblNewLabel_3.setBounds(0, 0, 1540, 845);
			b.getContentPane().add(lblNewLabel_3);
			
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

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
    }
	public static void main(String[] args) {
		new My_Cart();
	}
}

