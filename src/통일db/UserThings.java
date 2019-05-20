package ≈Î¿œdb;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.util.Scanner;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;

public class UserThings extends JFrame {

	
	
	private JPanel contentPane;
	private JButton btnNewButton_1;
	private JLabel lblContents;
	
	ConnectionInformation ci = new ConnectionInformation();

	 String url = ci.getUrl();
     String userid = ci.getUserId();
     String password = ci.getPassword();
     String sql = "Select * From UnificationDB.User";
     
 	ShowTable st = new ShowTable(sql);
 	private JButton btnEditJcsPhone;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	
	public static void main(String[] args) {
	      EventQueue.invokeLater(new Runnable() {
	         public void run() {
	            try {
	               UserThings frame = new UserThings();
	               frame.setVisible(true);
	            } catch (Exception e) {
	               e.printStackTrace();
	            }
	         }
	      });
	   }
	
	public UserThings() {
		ci.main(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1023, 442);
		contentPane = new JPanel();
		contentPane.setToolTipText("Enter your ID");
		contentPane.setBackground(new Color(222, 184, 135));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Log In");
		lblNewLabel.setBounds(29, 24, 119, 34);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("±º∏≤", Font.PLAIN, 16));
		contentPane.add(lblNewLabel);
		

		JLabel queryLabel = new JLabel("nothing");	
		queryLabel.setBounds(138, 327, 857, 66);
		contentPane.add(queryLabel);
		
		
		JButton btnNewButton = new JButton("anonymous");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "Select * from UnificationDB.User Where user_id = 'anonymous' AND password = 'anonymous'";
				st.main(sql);
				queryLabel.setText(sql);
				
			}
		});
		btnNewButton.setBounds(12, 68, 151, 23);
		contentPane.add(btnNewButton);
		
		JButton btnUserLevel = new JButton("user level 1");
		btnUserLevel.setBounds(175, 68, 151, 23);
		btnUserLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "Select * from UnificationDB.User WHERE user_id = '21500153' AND password = '1111'";
				st.main(sql);
				queryLabel.setText(sql);
			}
		});
		contentPane.add(btnUserLevel);
		
		JButton btnManager = new JButton("manager");
		btnManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "Select * from UnificationDB.User WHERE user_id = 'manager' AND password = 'manager'";
				st.main(sql);
				queryLabel.setText(sql);
			}
		});
		btnManager.setBounds(339, 68, 151, 23);
		contentPane.add(btnManager);
		
		JButton btnJohn = new JButton("register: JC");
		btnJohn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement pstmt = null;
				sql = "INSERT INTO UnificationDB.User "
						+ "(user_id, authentication, password, phone, data_birth, nationality, address, gender, name, email)"
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				try {
					
					try {
						Class.forName(ci.driver);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					con = DriverManager.getConnection(url, userid, password);
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, "JC");
					pstmt.setInt(2, 1);
					pstmt.setString(3,  "JC");
					pstmt.setString(4, "01000000000");
					pstmt.setString(5, "801010");
					pstmt.setString(6, "Republic of Korea");
					pstmt.setString(7, "Pohang");
					pstmt.setString(8, "male");
					pstmt.setString(9, "jaechang");
					pstmt.setString(10, "jcNam@gmail.com");
					
					System.out.println("did it");
					pstmt.executeUpdate();
					
				}catch(SQLException e1) {
					System.out.println(e1);
				}
			
				queryLabel.setText(sql);
			}
		});
		btnJohn.setBounds(12, 145, 151, 23);
		contentPane.add(btnJohn);
		
		JLabel lblEditInformation = new JLabel("Edit Information");
		lblEditInformation.setBounds(196, 114, 143, 34);
		lblEditInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditInformation.setFont(new Font("±º∏≤", Font.PLAIN, 16));
		contentPane.add(lblEditInformation);
		
		JButton btnClose = new JButton("close");
		btnClose.setBounds(844, 370, 151, 23);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   dispose();
			}
		});
		contentPane.add(btnClose);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setBounds(20, 114, 143, 34);
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setFont(new Font("±º∏≤", Font.PLAIN, 16));
		contentPane.add(lblRegister);
		
		btnNewButton_1 = new JButton("Show all favorite contents");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "Select contents_id, title, copyright, field, description\r\n" + 
						"from UnificationDB.Contents\r\n" + 
						"Where contents_id IN (Select contents_id from UnificationDB.Bookmark where user_id = '21900688')";
				st.main(sql);
				queryLabel.setText(sql);
			}
		});
		btnNewButton_1.setBounds(799, 49, 196, 23);
		contentPane.add(btnNewButton_1);
		
		lblContents = new JLabel("21900688's Favorite");
		lblContents.setBounds(777, 10, 218, 34);
		lblContents.setHorizontalAlignment(SwingConstants.CENTER);
		lblContents.setFont(new Font("±º∏≤", Font.PLAIN, 16));
		contentPane.add(lblContents);
		
		JLabel lblCurrentState = new JLabel("Current Query: ");
		lblCurrentState.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentState.setFont(new Font("±º∏≤", Font.PLAIN, 16));
		lblCurrentState.setBounds(0, 327, 136, 66);
		contentPane.add(lblCurrentState);
		
		

		
		
		
		JButton btnLoginfail = new JButton("login-fail");
		btnLoginfail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "Select * from UnificationDB.User WHERE user_id = '21900688' AND password = '1212'";
			    st.main(sql);
			    queryLabel.setText(sql);
			}
		});
		btnLoginfail.setBounds(175, 31, 151, 23);
		contentPane.add(btnLoginfail);
		
		btnEditJcsPhone = new JButton("JC's New password");
		btnEditJcsPhone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement pstmt = null;
				sql = "UPDATE UnificationDB.User SET password = ? WHERE (user_id = ?)";
				try {
					
					try {
						Class.forName(ci.driver);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					con = DriverManager.getConnection(url, userid, password);
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, "NewJC");
					pstmt.setString(2,  "JC");
					
					System.out.println("did it");
					pstmt.executeUpdate();
					
				}catch(SQLException e1) {
					System.out.println(e1);
				}
			
				queryLabel.setText(sql);
			}
		});
		btnEditJcsPhone.setBounds(177, 145, 186, 23);
		contentPane.add(btnEditJcsPhone);
		
		JLabel lblShowOtherUsers = new JLabel("Show other user's Information");
		lblShowOtherUsers.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowOtherUsers.setFont(new Font("±º∏≤", Font.PLAIN, 16));
		lblShowOtherUsers.setBounds(514, 24, 231, 37);
		contentPane.add(lblShowOtherUsers);
		
		JButton btnJc = new JButton("User: 21900688");
		btnJc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "Select user_id, gender from UnificationDB.User WHERE user_id = '21900688' AND password = '1111'";
			    st.main(sql);
			    queryLabel.setText(sql);
				
			}
		});
		btnJc.setBounds(562, 82, 151, 23);
		contentPane.add(btnJc);
		
		JButton btnAddFavorite = new JButton("Add favorite: con_6");
		btnAddFavorite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement pstmt = null;
				sql = "INSERT INTO UnificationDB.Bookmark "
						+ "(bookmark_id, user_id, contents_id)"
						+ "VALUES (?, ?, ?)";
				try {
					
					try {
						Class.forName(ci.driver);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					con = DriverManager.getConnection(url, userid, password);
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, "bm7");
					pstmt.setString(2, "21900688");
					pstmt.setString(3, "con_6");
					
					System.out.println("did it");
					pstmt.executeUpdate();
					
				}catch(SQLException e1) {
					System.out.println(e1);
				}
			
				queryLabel.setText(sql);
			}
			
		});
		btnAddFavorite.setBounds(815, 82, 164, 23);
		contentPane.add(btnAddFavorite);
		
		JButton btnDeleteFavorite = new JButton("Delete favorite: con_6");
		btnDeleteFavorite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement pstmt = null;
				sql = "DELETE FROM UnificationDB.Bookmark WHERE (bookmark_id = ?)";
				try {
					
					try {
						Class.forName(ci.driver);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					con = DriverManager.getConnection(url, userid, password);
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, "bm7");
					
					System.out.println("did it");
					pstmt.executeUpdate();
					
				}catch(SQLException e1) {
					System.out.println(e1);
				}
			
				queryLabel.setText(sql);
			}
		});
		btnDeleteFavorite.setBounds(815, 114, 164, 23);
		contentPane.add(btnDeleteFavorite);
		
		JButton btnEx = new JButton("Show User Table");
		btnEx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sql = "select * from UnificationDB.User";
				st.main(sql);
				queryLabel.setText(sql);
			}
		});
		btnEx.setBounds(831, 189, 164, 23);
		contentPane.add(btnEx);
		
		JButton btnAllUserdependsOn = new JButton("All user(depends on authentication level), User: JC");
		btnAllUserdependsOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "Select user_id, gender" + 
						"From UnificationDB.User" + 
						"Where authentication <= (Select authentication From UnificationDB.User Where user_id = 'JC') And authentication > 0 ";
				st.main(sql);	
				
			}
		});
		btnAllUserdependsOn.setBounds(468, 121, 321, 23);
		contentPane.add(btnAllUserdependsOn);
		
	
	}
}
