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

public class My_Orders1{
	private JTable table;
	private JTable table1;
	DefaultTableModel model;
	private final JLabel lblNewLabel = new JLabel("New label");
	
	public My_Orders1(){
		JFrame b=new JFrame("Shopzyyy/My_Orders/My_Orders1");
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
			String str="Select * from orders";
			PreparedStatement ps = con.prepareStatement(str);
			ResultSet rs=ps.executeQuery();
			table1 = new JTable();
			table1.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
			table1.setBackground(new Color(204, 255, 255));
			scrollPane.setViewportView(table1);
			table1.setModel(DbUtils.resultSetToTableModel(rs));
			
			
			
			
			
			
			
//			JLabel lblNewLabel_3 = new JLabel("New label");
//			lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\esghseysm (1).png"));
//			lblNewLabel_3.setBounds(0, 0, 1540, 845);
//			b.getContentPane().add(lblNewLabel_3);
			
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
			lblNewLabel.setIcon(new ImageIcon("D:\\VIT\\Sem3\\Notes\\SBL-Java\\Programs\\Mini_Project\\Resources\\istockphoto-472674192-1024x1024 (1).png"));
			lblNewLabel.setBounds(0, 0, 1540, 845);
			b.getContentPane().add(lblNewLabel);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
    }
	public static void main(String[] args) {
		new My_Orders1();
	}
}
