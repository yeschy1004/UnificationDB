package ≈Î¿œdb;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Show_manager extends JFrame {

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
					Show_manager frame = new Show_manager();
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
	public Show_manager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 184, 135));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel queryLabel = new JLabel("Query");
		queryLabel.setBounds(12, 536, 787, 15);
		contentPane.add(queryLabel);
		
		
		JButton btnNewButton = new JButton("AddR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "Select * from UnificationDB.AddR";
			    st.main(sql);
			    queryLabel.setText(sql);
			}
		});
		btnNewButton.setBounds(34, 32, 158, 23);
		contentPane.add(btnNewButton);
		
		JButton btnBookmark = new JButton("Bookmark");
		btnBookmark.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "Select * from UnificationDB.Bookmark";
			    st.main(sql);
			    queryLabel.setText(sql);
			}
		});
		btnBookmark.setBounds(34, 75, 158, 23);
		contentPane.add(btnBookmark);
		
		JButton btnContainr = new JButton("ContainR");
		btnContainr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "Select * from UnificationDB.ContainR";
			    st.main(sql);
			    queryLabel.setText(sql);
			}
		});
		btnContainr.setBounds(34, 126, 158, 23);
		contentPane.add(btnContainr);
		
		JButton btnContents = new JButton("Contents");
		btnContents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "Select * from UnificationDB.Contents";
			    st.main(sql);
			    queryLabel.setText(sql);
			}
		});
		btnContents.setBounds(34, 167, 158, 23);
		contentPane.add(btnContents);
		
		JButton btnContentshashtaglist = new JButton("Contents_HashTagLists");
		btnContentshashtaglist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "Select * from UnificationDB.Contents_HashTagLists";
			    st.main(sql);
			    queryLabel.setText(sql);
			}
		});
		btnContentshashtaglist.setBounds(34, 211, 245, 23);
		contentPane.add(btnContentshashtaglist);
		
		JButton btnDictionarybasic = new JButton("Dictionary_Basic");
		btnDictionarybasic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "Select * from UnificationDB.Dictionary_Basic";
			    st.main(sql);
			    queryLabel.setText(sql);
			}
		});
		btnDictionarybasic.setBounds(34, 253, 158, 23);
		contentPane.add(btnDictionarybasic);
		
		JButton btnDictionaryslang = new JButton("Dictionary_Slang");
		btnDictionaryslang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "Select * from UnificationDB.Dictionary_Slang";
			    st.main(sql);
			    queryLabel.setText(sql);
			}
		});
		btnDictionaryslang.setBounds(34, 297, 158, 23);
		contentPane.add(btnDictionaryslang);
		
		JButton btnDictionarytranslation = new JButton("Dictionary_Translation");
		btnDictionarytranslation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "Select * from UnificationDB.Dictionary_Translation";
			    st.main(sql);
			    queryLabel.setText(sql);
			}
		});
		btnDictionarytranslation.setBounds(34, 339, 158, 23);
		contentPane.add(btnDictionarytranslation);
		
		JButton btnHashpairlist = new JButton("HashPairList");
		btnHashpairlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "Select * from UnificationDB.HashPairList";
			    st.main(sql);
			    queryLabel.setText(sql);
			}
		});
		btnHashpairlist.setBounds(34, 375, 158, 23);
		contentPane.add(btnHashpairlist);
		
		JButton btnHashtag = new JButton("HashTag");
		btnHashtag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "Select * from UnificationDB.HashTag";
			    st.main(sql);
			    queryLabel.setText(sql);
			}
		});
		btnHashtag.setBounds(34, 421, 158, 23);
		contentPane.add(btnHashtag);
		
		JButton btnMakepairscontentshashtaglistr = new JButton("Make_Pairs_Contents_HashtagListsR");
		btnMakepairscontentshashtaglistr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "Select * from UnificationDB.Make_Pairs_Contents_HashtagListsR";
			    st.main(sql);
			    queryLabel.setText(sql);
			}
		});
		btnMakepairscontentshashtaglistr.setBounds(34, 460, 297, 23);
		contentPane.add(btnMakepairscontentshashtaglistr);
		
		JButton btnMakepairsrecentkeywords = new JButton("Make_Pairs_Recent_Keywords");
		btnMakepairsrecentkeywords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "Select * from UnificationDB.Make_Pairs_Recent_Keywords";
			    st.main(sql);
			    queryLabel.setText(sql);
			}
		});
		btnMakepairsrecentkeywords.setBounds(337, 32, 207, 23);
		contentPane.add(btnMakepairsrecentkeywords);
		
		JButton btnRecentkeywords = new JButton("Recent_Keywords");
		btnRecentkeywords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "Select * from UnificationDB.Recent_Keywords";
			    st.main(sql);
			    queryLabel.setText(sql);
			}
		});
		btnRecentkeywords.setBounds(337, 75, 207, 23);
		contentPane.add(btnRecentkeywords);
		
		JButton btnReferencesite = new JButton("Reference_Site");
		btnReferencesite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "Select * from UnificationDB.Reference_Site";
			    st.main(sql);
			    queryLabel.setText(sql);
			}
		});
		btnReferencesite.setBounds(337, 110, 207, 23);
		contentPane.add(btnReferencesite);
		
		JButton btnSearchbasic = new JButton("Search_Basic");
		btnSearchbasic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "Select * from UnificationDB.Search_Basic";
			    st.main(sql);
			    queryLabel.setText(sql);
			}
		});
		btnSearchbasic.setBounds(337, 150, 207, 23);
		contentPane.add(btnSearchbasic);
		
		JButton btnSearchcontents = new JButton("Search_Contents");
		btnSearchcontents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "Select * from UnificationDB.Contents";
			    st.main(sql);
			    queryLabel.setText(sql);
			}
		});
		btnSearchcontents.setBounds(337, 183, 207, 23);
		contentPane.add(btnSearchcontents);
		
		JButton btnSearchrecentkeywordsr = new JButton("Search_Recent_KeywordsR");
		btnSearchrecentkeywordsr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "Select * from UnificationDB.Search_Recent_KeywordsR";
			    st.main(sql);
			    queryLabel.setText(sql);
			}
		});
		btnSearchrecentkeywordsr.setBounds(337, 228, 207, 23);
		contentPane.add(btnSearchrecentkeywordsr);
		
		JButton btnSearchreference = new JButton("Search_Reference");
		btnSearchreference.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "Select * from UnificationDB.Search_Reference";
			    st.main(sql);
			    queryLabel.setText(sql);
			}
		});
		btnSearchreference.setBounds(337, 274, 207, 23);
		contentPane.add(btnSearchreference);
		
		JButton btnSearchslang = new JButton("Search_Slang");
		btnSearchslang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "Select * from UnificationDB.Search_Slang";
			    st.main(sql);
			    queryLabel.setText(sql);
			}
		});
		btnSearchslang.setBounds(337, 315, 207, 23);
		contentPane.add(btnSearchslang);
		
		JButton btnSearchtrans = new JButton("Search_Trans");
		btnSearchtrans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "Select * from UnificationDB.Search_Trans";
			    st.main(sql);
			    queryLabel.setText(sql);
			}
			
		});
		btnSearchtrans.setBounds(337, 348, 207, 23);
		contentPane.add(btnSearchtrans);
		
		JButton btnTaglinkingr = new JButton("Tag_LinkingR");
		btnTaglinkingr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "Select * from UnificationDB.Tag_LinkingR";
			    st.main(sql);
			    queryLabel.setText(sql);
			}
		});
		btnTaglinkingr.setBounds(337, 375, 207, 23);
		contentPane.add(btnTaglinkingr);
		
		JButton btnUpdater = new JButton("UpdateR");
		btnUpdater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "Select * from UnificationDB.UpdateR";
			    st.main(sql);
			    queryLabel.setText(sql);
			}
		});
		btnUpdater.setBounds(337, 408, 207, 23);
		contentPane.add(btnUpdater);
		
		JButton btnUser = new JButton("User");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "Select * from UnificationDB.User";
			    st.main(sql);
			    queryLabel.setText(sql);
			}
		});
		btnUser.setBounds(337, 441, 207, 23);
		contentPane.add(btnUser);
		
		JButton btnWatchr = new JButton("WatchR");
		btnWatchr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql = "Select * from UnificationDB.WatchR";
			    st.main(sql);
			    queryLabel.setText(sql);
			}
		});
		btnWatchr.setBounds(337, 472, 207, 23);
		contentPane.add(btnWatchr);
		
		JButton btnClose = new JButton("close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(592, 460, 207, 23);
		contentPane.add(btnClose);
		
	}

}
