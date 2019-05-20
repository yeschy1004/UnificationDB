package ÅëÀÏdb;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ContentsThings extends JFrame {

	private JPanel contentPane;


	ConnectionInformation ci = new ConnectionInformation();

	 String url = ci.getUrl();
     String userid = ci.getUserId();
     String password = ci.getPassword();
     String sql = "Select * From UnificationDB.User";

  	ShowTable st = new ShowTable(sql);
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContentsThings frame = new ContentsThings();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ContentsThings() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 912, 547);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 184, 135));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("User 21500153's show all contents (level 1)");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "Select Contents.title, Contents.copyright, Contents.description, Contents.language, Contents.field, Contents.registration_time, Contents.uploaded_time\r\n" + 
						"From UnificationDB.Contents, UnificationDB.User\r\n" + 
						"Where  user_id = '21500153' AND authentication >= security_level";
				st.main(sql);
				
			}
		});
		btnNewButton.setBounds(26, 34, 332, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(682, 254, 125, 39);
		contentPane.add(btnNewButton_1);
		
		JButton btnUsersSearching = new JButton("User 21500153's Searching - online & language: eng");
		btnUsersSearching.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sql = "Select Contents.title, Contents.copyright, Contents.description, Contents.language, Contents.field, Contents.registration_time, Contents.uploaded_time\r\n" + 
						"From UnificationDB.Contents, UnificationDB.User\r\n" + 
						"Where  user_id = '21500153' AND authentication >= security_level AND contents_type = 1 AND language = 'eng'";
				st.main(sql);
				
			}
		});
		btnUsersSearching.setBounds(26, 98, 350, 45);
		contentPane.add(btnUsersSearching);
		
		JButton btnUsersSearching_1 = new JButton("User 21500153's Searching - hotest contents");
		btnUsersSearching_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sql = "Select Contents.title, Contents.copyright, Contents.description, Contents.language, Contents.field, Contents.registration_time, Contents.uploaded_time\r\n" + 
						"From UnificationDB.Contents, UnificationDB.User\r\n" + 
						"Where  user_id = '21500153' AND authentication >= security_level AND visitor_num = (Select max(visitor_num) From UnificationDB.Contents)";
				st.main(sql);
			}
		});
		btnUsersSearching_1.setBounds(26, 166, 312, 45);
		contentPane.add(btnUsersSearching_1);
		
		JButton btnUsersSearching_2 = new JButton("User 21500153's Searching - registration_time betwwen 2000s - 2010");
		btnUsersSearching_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sql = "Select Contents.title, Contents.copyright, Contents.description, Contents.language, Contents.field, Contents.registration_time, Contents.uploaded_time\r\n" + 
						"From UnificationDB.Contents, UnificationDB.User\r\n" + 
						"Where  user_id = '21500153' AND authentication >= security_level AND (DATE(registration_time) BETWEEN '2000-01-01' AND '2010-12-31')";
				st.main(sql);
				
			}
		});
		btnUsersSearching_2.setBounds(26, 229, 455, 45);
		contentPane.add(btnUsersSearching_2);
		
		JButton btnUsersShow = new JButton("User 21500153's show all contents order by upload-time");
		btnUsersShow.setBounds(26, 284, 428, 45);
		contentPane.add(btnUsersShow);
		
		JButton btnUsersShow_1 = new JButton("Manager show all contents order by upload-time(Most Recent)");
		btnUsersShow_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sql = "Select Contents.title, Contents.copyright, Contents.description, Contents.language, Contents.field, Contents.registration_time, Contents.uploaded_time\r\n" + 
						"FROM UnificationDB.Contents ORDER BY uploaded_time DESC";
				st.main(sql);
			}
			
		});
		btnUsersShow_1.setBounds(456, 34, 428, 45);
		contentPane.add(btnUsersShow_1);
		
		JButton btnManagerShowAll = new JButton("Manager show all contents order by Registration-time(Least Recent)");
		btnManagerShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				sql = "Select Contents.title, Contents.copyright, Contents.description, Contents.language, Contents.field, Contents.registration_time, Contents.uploaded_time\r\n" + 
						"FROM UnificationDB.Contents ORDER BY registration_time";
				st.main(sql);
			}
		});
		btnManagerShowAll.setBounds(456, 98, 428, 45);
		contentPane.add(btnManagerShowAll);
	}

}
