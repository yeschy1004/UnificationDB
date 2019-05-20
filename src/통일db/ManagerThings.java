package ÅëÀÏdb;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;

public class ManagerThings extends JFrame {

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
					ManagerThings frame = new ManagerThings();
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
	public ManagerThings() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 556);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 184, 135));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel queryLabel = new JLabel("Query");
		queryLabel.setBounds(12, 470, 879, 37);
		contentPane.add(queryLabel);
		
		
		JButton btnNewButton = new JButton("Edit User Level JC (level 1) -> (level 2)");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement pstmt = null;
				sql = "UPDATE UnificationDB.User SET authentication = ? WHERE (user_id = ?)";
				try {
					
					try {
						Class.forName(ci.driver);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					con = DriverManager.getConnection(url, userid, password);
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, 2);
					pstmt.setString(2,  "JC");
					
					System.out.println("did it");
					pstmt.executeUpdate();
					
				}catch(SQLException e1) {
					System.out.println(e1);
				}
			
				queryLabel.setText(sql);
			}
		});
		btnNewButton.setBounds(12, 52, 262, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("User managing");
		lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		lblNewLabel.setBounds(28, 20, 183, 15);
		contentPane.add(lblNewLabel);
		
		
		
		JLabel lblContentsUpdating = new JLabel("Contents");
		lblContentsUpdating.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		lblContentsUpdating.setBounds(28, 107, 183, 15);
		contentPane.add(lblContentsUpdating);
		
		JButton btnNewContents = new JButton("New contents: con_7");
		btnNewContents.addActionListener(new ActionListener() {
			
			
			
			
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement pstmt = null;
				sql = "INSERT INTO UnificationDB.Contents "
						+ "(contents_id, contents_type, title, security_level, copyright, description, language, uploaded_time, field, registration_time, visitor_num, data_type, url_link, reference)"
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
				try {
					
					try {
						Class.forName(ci.driver);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					con = DriverManager.getConnection(url, userid, password);
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, "con_7");
					pstmt.setInt(2, 0);
					pstmt.setString(3,  "difference");
					pstmt.setInt(4, 1);
					pstmt.setString(5, "Action for Korean United");
					pstmt.setString(6, "Republic of Korea");
					pstmt.setString(7, "kor");
					pstmt.setString(8, LocalDateTime.now().toString());
					pstmt.setString(9, "art");
					pstmt.setString(10, "2002-10-03 11:11:11");
					pstmt.setInt(11, 0);
					pstmt.setString(12, "book");
					pstmt.setString(13, null);
					pstmt.setString(14, null);
					
					System.out.println("did it");
					pstmt.executeUpdate();
					
				}catch(SQLException e1) {
					System.out.println(e1);
				}
			
				queryLabel.setText(sql);
			}
			
		});
		btnNewContents.setBounds(28, 132, 224, 23);
		contentPane.add(btnNewContents);
		
		JButton btnEditContents = new JButton("Edit Contents: title->Kim's Lucky day");
		btnEditContents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement pstmt = null;
				sql = "UPDATE UnificationDB.Contents SET title = ? WHERE (contents_id = ?)";
				try {
					
					try {
						Class.forName(ci.driver);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					con = DriverManager.getConnection(url, userid, password);
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, "kim's luckyday");
					pstmt.setString(2,  "con_7");
					
					System.out.println("did it");
					pstmt.executeUpdate();
					
				}catch(SQLException e1) {
					System.out.println(e1);
				}
			
				queryLabel.setText(sql);
			}
		});
		btnEditContents.setBounds(494, 132, 278, 23);
		contentPane.add(btnEditContents);
		
		JButton button = new JButton("JC out");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement pstmt = null;
				sql = "DELETE FROM UnificationDB.User WHERE (user_id = ?)";
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
					
					System.out.println("did it");
					pstmt.executeUpdate();
					
				}catch(SQLException e1) {
					System.out.println(e1);
				}
			
				queryLabel.setText(sql);
			}
		});
		button.setBounds(343, 52, 128, 23);
		contentPane.add(button);
		
		JLabel lblD = new JLabel("HashTag & HashPair");
		lblD.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		lblD.setBounds(36, 181, 183, 15);
		contentPane.add(lblD);
		
		JLabel lblDictionaryReference = new JLabel("Dictionary & Reference Site");
		lblDictionaryReference.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		lblDictionaryReference.setBounds(28, 306, 183, 15);
		contentPane.add(lblDictionaryReference);
		
		JButton btnDeleteHashtag = new JButton("Delete HashTag: KoreanWar");
		btnDeleteHashtag.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement pstmt = null;
				sql = "DELETE FROM UnificationDB.HashTag WHERE (hashtag_id = ?)";
				try {
					
					try {
						Class.forName(ci.driver);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					con = DriverManager.getConnection(url, userid, password);
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, "KoreanWar");
					
					System.out.println("did it");
					pstmt.executeUpdate();
					
				}catch(SQLException e1) {
					System.out.println(e1);
				}
			
				queryLabel.setText(sql);
			}
			
		});
		btnDeleteHashtag.setBounds(28, 219, 204, 23);
		contentPane.add(btnDeleteHashtag);
		
		JButton btnDeleteRefereneceDb = new JButton("Edit Referenece DB Site: setermin");
		btnDeleteRefereneceDb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement pstmt = null;
				sql = "UPDATE UnificationDB.Reference_Site SET url_link = ? WHERE (site_id = ?)";
				try {
					
					try {
						Class.forName(ci.driver);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					con = DriverManager.getConnection(url, userid, password);
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, "https://www.lovingsetermin.go.kr/");
					pstmt.setString(2,  "site7");
					
					System.out.println("did it");
					pstmt.executeUpdate();
					
				}catch(SQLException e1) {
					System.out.println(e1);
				}
			
				queryLabel.setText(sql);
			}
		});
		btnDeleteRefereneceDb.setBounds(295, 331, 240, 23);
		contentPane.add(btnDeleteRefereneceDb);
		
		JButton btnNewRefereneceDb = new JButton("New Referenece DB Site: setermin");
		btnNewRefereneceDb.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement pstmt = null;
				sql = "INSERT INTO UnificationDB.Reference_Site (site_id, site_name, description, url_link)"
						+ "VALUES (?, ?, ?, ?)";
				try {
					
					try {
						Class.forName(ci.driver);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					con = DriverManager.getConnection(url, userid, password);
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, "site7");
					pstmt.setString(2, "Setermin");
					pstmt.setString(3,  "Setermin, bokgi-zedo-");
					pstmt.setString(4, "https://www.saeterminlove.go.kr/");
					
					System.out.println("did it");
					pstmt.executeUpdate();
					
				}catch(SQLException e1) {
					System.out.println(e1);
				}
			
				queryLabel.setText(sql);
			}
		});
		btnNewRefereneceDb.setBounds(28, 331, 240, 23);
		contentPane.add(btnNewRefereneceDb);
		
		JButton btnNewDictionart = new JButton("New Dictionary-basic: maga-uel");
		btnNewDictionart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement pstmt = null;
				sql = "INSERT INTO UnificationDB.Dictionary_Basic (b_dictionary_id, b_word, b_definition)"
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
					
					pstmt.setString(1, "bdic5");
					pstmt.setString(2, "Maga-uel");
					pstmt.setString(3,  "Start of fall");
					
					System.out.println("did it");
					pstmt.executeUpdate();
					
				}catch(SQLException e1) {
					System.out.println(e1);
				}
			
				queryLabel.setText(sql);
			}
		});
		btnNewDictionart.setBounds(28, 364, 246, 23);
		contentPane.add(btnNewDictionart);
		
		JButton btnDeleteContents = new JButton("Delete Contents");
		btnDeleteContents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement pstmt = null;
				sql = "DELETE FROM UnificationDB.Contents WHERE (contents_id = ?)";
				try {
					
					try {
						Class.forName(ci.driver);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					con = DriverManager.getConnection(url, userid, password);
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, "con_7");
					
					System.out.println("did it");
					pstmt.executeUpdate();
					
				}catch(SQLException e1) {
					System.out.println(e1);
				}
			
				queryLabel.setText(sql);
			}
		});
		btnDeleteContents.setBounds(786, 132, 128, 23);
		contentPane.add(btnDeleteContents);
		
		JButton btnEditHashtag = new JButton("Edit HashTag merit -> law");
		btnEditHashtag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement pstmt = null;
				sql = "UPDATE UnificationDB.HashTag SET hashtag_id = ? WHERE (hashtag_id = ?)";
				try {
					
					try {
						Class.forName(ci.driver);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					con = DriverManager.getConnection(url, userid, password);
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, "law");
					pstmt.setString(2,  "merit");
					
					System.out.println("did it");
					pstmt.executeUpdate();
					
				}catch(SQLException e1) {
					System.out.println(e1);
				}
			
				queryLabel.setText(sql);
			}
		});
		btnEditHashtag.setBounds(264, 219, 218, 23);
		contentPane.add(btnEditHashtag);
		
		JButton btnEditDictionarybasicWord = new JButton("Edit Dictionary-basic: maga-uel");
		btnEditDictionarybasicWord.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Connection con = null;
					PreparedStatement pstmt = null;
					sql = "UPDATE UnificationDB.Dictionary_Basic SET b_definition = ? WHERE (b_dictionary_id = ?)";
					try {
						
						try {
							Class.forName(ci.driver);
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						con = DriverManager.getConnection(url, userid, password);
						pstmt = con.prepareStatement(sql);
						
						pstmt.setString(1, "End of fall");
						pstmt.setString(2,  "bdic5");
						
						System.out.println("did it");
						pstmt.executeUpdate();
						
					}catch(SQLException e1) {
						System.out.println(e1);
					}
				
					queryLabel.setText(sql);
				}
		});
		btnEditDictionarybasicWord.setBounds(305, 364, 230, 23);
		contentPane.add(btnEditDictionarybasicWord);
		
		JButton btnDeleteRefereneceDb_1 = new JButton("Delete Referenece DB Site: setermin");
		btnDeleteRefereneceDb_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement pstmt = null;
				sql = "DELETE FROM UnificationDB.Reference_Site WHERE (site_id = ?)";
				try {
					
					try {
						Class.forName(ci.driver);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					con = DriverManager.getConnection(url, userid, password);
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, "site7");
					
					System.out.println("did it");
					pstmt.executeUpdate();
					
				}catch(SQLException e1) {
					System.out.println(e1);
				}
			
				queryLabel.setText(sql);
			}
		});
		btnDeleteRefereneceDb_1.setBounds(570, 331, 245, 23);
		contentPane.add(btnDeleteRefereneceDb_1);
		
		JButton btnDeleteDictionarybasicWord = new JButton("Delete Dictionary-basic: maga-uel");
		btnDeleteDictionarybasicWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement pstmt = null;
				sql = "DELETE FROM UnificationDB.Dictionary_Basic WHERE (b_dictionary_id = ?)";
				try {
					
					try {
						Class.forName(ci.driver);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					con = DriverManager.getConnection(url, userid, password);
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, "bdic5");
					
					System.out.println("did it");
					pstmt.executeUpdate();
					
				}catch(SQLException e1) {
					System.out.println(e1);
				}
			
				queryLabel.setText(sql);
			}
		});
		btnDeleteDictionarybasicWord.setBounds(570, 364, 236, 23);
		contentPane.add(btnDeleteDictionarybasicWord);
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Show_manager.main(null);
			}
		});
		btnShow.setBounds(754, 31, 97, 23);
		contentPane.add(btnShow);
		
		JButton btnNewDictionaryslangWord = new JButton("New Dictionary-slang: bbaek-tai");
		btnNewDictionaryslangWord.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				PreparedStatement pstmt = null;
				sql = "INSERT INTO UnificationDB.Dictionary_Slang (s_dictionary_id, s_word, s_definition)"
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
					
					pstmt.setString(1, "sdic4");
					pstmt.setString(2, "bbaek-tai");
					pstmt.setString(3,  "Rice");
					
					System.out.println("did it");
					pstmt.executeUpdate();
					
				}catch(SQLException e1) {
					System.out.println(e1);
				}
			
				queryLabel.setText(sql);
			}
		});
		btnNewDictionaryslangWord.setBounds(28, 394, 246, 23);
		contentPane.add(btnNewDictionaryslangWord);
		
		JButton btnEditDictionaryslangWord = new JButton("Edit Dictionary-slang: bbaek-tai");
		btnEditDictionaryslangWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement pstmt = null;
				sql = "UPDATE UnificationDB.Dictionary_Slang SET s_definition = ? WHERE (s_dictionary_id = ?)";
				try {
					
					try {
						Class.forName(ci.driver);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					con = DriverManager.getConnection(url, userid, password);
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, "Steamed rice");
					pstmt.setString(2,  "sdic4");
					
					System.out.println("did it");
					pstmt.executeUpdate();
					
				}catch(SQLException e1) {
					System.out.println(e1);
				}
			
				queryLabel.setText(sql);
			}
		});
		btnEditDictionaryslangWord.setBounds(295, 394, 240, 23);
		contentPane.add(btnEditDictionaryslangWord);
		
		JButton btnDeleteDictionaryslang = new JButton("Delete Dictionary-slang: bbaek-tai");
		btnDeleteDictionaryslang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement pstmt = null;
				sql = "DELETE FROM UnificationDB.Dictionary_Slang WHERE (s_dictionary_id = ?)";
				try {
					
					try {
						Class.forName(ci.driver);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					con = DriverManager.getConnection(url, userid, password);
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, "sdic4");
					
					System.out.println("did it");
					pstmt.executeUpdate();
					
				}catch(SQLException e1) {
					System.out.println(e1);
				}
			
				queryLabel.setText(sql);
			}
		});
		btnDeleteDictionaryslang.setBounds(570, 397, 236, 23);
		contentPane.add(btnDeleteDictionaryslang);
		
		JButton btnNewDictionarytransBbaektai = new JButton("New Dictionary-trans: ternal-chagul");
		btnNewDictionarytransBbaektai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
	
				PreparedStatement pstmt = null;
			sql = "INSERT INTO UnificationDB.Dictionary_Translation (t_dictionary_id, t_word_nkorean, t_word_skorea)"
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
				
				pstmt.setString(1, "tdic4");
				pstmt.setString(2, "gul");
				pstmt.setString(3,  "ternal");
				
				System.out.println("did it");
				pstmt.executeUpdate();
				
			}catch(SQLException e1) {
				System.out.println(e1);
			}
		
			queryLabel.setText(sql);
		}
		});
		btnNewDictionarytransBbaektai.setBounds(28, 437, 246, 23);
		contentPane.add(btnNewDictionarytransBbaektai);
		
		JButton btnEditDictionarytransTernalchagul = new JButton("Edit Dictionary-trans: ternal-chagul");
		btnEditDictionarytransTernalchagul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement pstmt = null;
				sql = "UPDATE UnificationDB.Dictionary_Translation SET t_word_nkorean = ? WHERE (t_dictionary_id = ?)";
				try {
					
					try {
						Class.forName(ci.driver);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					con = DriverManager.getConnection(url, userid, password);
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, "chagul");
					pstmt.setString(2,  "tdic4");
					
					System.out.println("did it");
					pstmt.executeUpdate();
					
				}catch(SQLException e1) {
					System.out.println(e1);
				}
			
				queryLabel.setText(sql);
			}
		});
		btnEditDictionarytransTernalchagul.setBounds(295, 437, 240, 23);
		contentPane.add(btnEditDictionarytransTernalchagul);
		
		JButton btnDeleteDictionarytransTernalchagul = new JButton("Delete Dictionary-trans: ternal-chagul");
		btnDeleteDictionarytransTernalchagul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement pstmt = null;
				sql = "DELETE FROM UnificationDB.Dictionary_Translation WHERE (t_dictionary_id = ?)";
				try {
					
					try {
						Class.forName(ci.driver);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					con = DriverManager.getConnection(url, userid, password);
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, "tdic4");
					
					System.out.println("did it");
					pstmt.executeUpdate();
					
				}catch(SQLException e1) {
					System.out.println(e1);
				}
			
				queryLabel.setText(sql);
			}
		});
		btnDeleteDictionarytransTernalchagul.setBounds(547, 437, 259, 23);
		contentPane.add(btnDeleteDictionarytransTernalchagul);
		
		JButton btnEditContentsHashtag = new JButton("Edit Content's HashTag");
		btnEditContentsHashtag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement pstmt = null;
				sql = "UPDATE UnificationDB.Contents_HashTagLists SET hashtag_list = ? WHERE (hashtag_list = ?)";
				try {
					
					try {
						Class.forName(ci.driver);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					con = DriverManager.getConnection(url, userid, password);
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, "law");
					pstmt.setString(2,  "merit");
					
					System.out.println("did it");
					pstmt.executeUpdate();
					
				}catch(SQLException e1) {
					System.out.println(e1);
				}
			
				queryLabel.setText(sql);
			}
		});
		btnEditContentsHashtag.setBounds(526, 219, 183, 23);
		contentPane.add(btnEditContentsHashtag);
		
		JButton btnClose = new JButton("close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(697, 104, 128, 23);
		contentPane.add(btnClose);
		
		JButton btnInsertHashtag = new JButton("Insert HashTag: KoreanWar");
		btnInsertHashtag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement pstmt = null;
				sql = "INSERT INTO UnificationDB.HashTag "
						+ "(hashtag_id)"
						+ "VALUES (?)";
				try {
					
					try {
						Class.forName(ci.driver);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					con = DriverManager.getConnection(url, userid, password);
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, "KoreanWar");
					
					
					System.out.println("did it");
					pstmt.executeUpdate();
					
				}catch(SQLException e1) {
					System.out.println(e1);
				}
			
				queryLabel.setText(sql);
			}
		});
		btnInsertHashtag.setBounds(28, 251, 204, 23);
		contentPane.add(btnInsertHashtag);
		
		JButton btnEditHashtagLaw = new JButton("Edit HashTag law -> merit");
		btnEditHashtagLaw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement pstmt = null;
				sql = "UPDATE UnificationDB.HashTag SET hashtag_id = ? WHERE (hashtag_id = ?)";
				try {
					
					try {
						Class.forName(ci.driver);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					con = DriverManager.getConnection(url, userid, password);
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, "merit");
					pstmt.setString(2,  "law");
					
					System.out.println("did it");
					pstmt.executeUpdate();
					
				}catch(SQLException e1) {
					System.out.println(e1);
				}
			
				queryLabel.setText(sql);
			}
		});
		btnEditHashtagLaw.setBounds(264, 251, 218, 23);
		contentPane.add(btnEditHashtagLaw);
		
		JButton button_1 = new JButton("Edit Content's HashTag");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement pstmt = null;
				sql = "UPDATE UnificationDB.Contents_HashTagLists SET hashtag_list = ? WHERE (hashtag_list = ?)";
				try {
					
					try {
						Class.forName(ci.driver);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					con = DriverManager.getConnection(url, userid, password);
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, "merit");
					pstmt.setString(2,  "law");
					
					System.out.println("did it");
					pstmt.executeUpdate();
					
				}catch(SQLException e1) {
					System.out.println(e1);
				}
			
				queryLabel.setText(sql);
			}
		});
		button_1.setBounds(526, 251, 183, 23);
		contentPane.add(button_1);
		
		JButton btnNewContentshash = new JButton("New contents_hash : con_7");
		btnNewContentshash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement pstmt = null;
				sql = "INSERT INTO UnificationDB.Contents_HashTagLists "
						+ "(contents_hashtaglist_id, contents_id, hashtag_list)"
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
					
					pstmt.setString(1, "con_hash_10");
					pstmt.setString(2, "con_7");
					pstmt.setString(3, "merit");
					
					System.out.println("did it");
					pstmt.executeUpdate();
					
				}catch(SQLException e1) {
					System.out.println(e1);
				}
			
				queryLabel.setText(sql);
			}
		});
		btnNewContentshash.setBounds(264, 132, 207, 23);
		contentPane.add(btnNewContentshash);
		
		JButton btnDeleteContentshash = new JButton("Delete Contents_hash : con_7's");
		btnDeleteContentshash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement pstmt = null;
				sql = "DELETE FROM UnificationDB.Contents_HashTagLists WHERE (contents_id = ?)";
				try {
					
					try {
						Class.forName(ci.driver);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					con = DriverManager.getConnection(url, userid, password);
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, "con_7");
					
					System.out.println("did it");
					pstmt.executeUpdate();
					
				}catch(SQLException e1) {
					System.out.println(e1);
				}
			
				queryLabel.setText(sql);
			}
		});
		btnDeleteContentshash.setBounds(504, 165, 231, 23);
		contentPane.add(btnDeleteContentshash);

	}

}
