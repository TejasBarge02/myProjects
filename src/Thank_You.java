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

public class Thank_You{
	private JTable table;
	DefaultTableModel model;
	private final JLabel lblNewLabel = new JLabel("New label");
	
	public Thank_You(){
		JFrame b=new JFrame("Shopzyyy/Home/Thank_You");
		b.getContentPane().setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		b.getContentPane().setBackground(new Color(255, 240, 245));
		b.setBounds(100, 100, 1603, 882);//to set dimensions of the frame
		b.setLocationRelativeTo(null);
		b.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b.setVisible(false);
				new Home();
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 102));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		btnNewButton.setBounds(645, 536, 260, 88);
		b.getContentPane().add(btnNewButton);
		lblNewLabel.setIcon(new ImageIcon("D:\\VIT\\Sem3\\Notes\\SBL-Java\\Programs\\Mini_Project\\Resources\\Thanks for coming! (1).png"));
		lblNewLabel.setBounds(0, 0, 1540, 856);
		b.getContentPane().add(lblNewLabel);
		b.setVisible(true);
		
	}
	public static void main(String[] args) {
		new Thank_You();
	}
}

