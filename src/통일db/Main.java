package ≈Î¿œdb;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;

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

public class Main extends JFrame {

   private JPanel contentPane;
   ArrayList columnNames = new ArrayList();
   ArrayList data = new ArrayList();
   Vector columnNamesVector = new Vector();
   Vector dataVector = new Vector();
   
   ConnectionInformation ci = new ConnectionInformation();
   
   String url = ci.getUrl();
   String userid = ci.getUserId();
   String password = ci.getPassword();
   String sql = ci.getSql();

   /**
    * Create the frame.
    */
   
   
   public static void main(String[] args) {
	   
	      EventQueue.invokeLater(new Runnable() {
	         public void run() {
	            try {
	            	
	               Main frame = new Main();
	               frame.setVisible(true);
	            } catch (Exception e) {
	               e.printStackTrace();
	            }
	         }
	      });
	      
	      
	   }
      
   public Main() {
         ci.main(null);
         UserThings us = new UserThings();

         
         
///////////////////////////////////////////////////////////////////////////////
      

      
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 963, 554);
      contentPane = new JPanel();
      contentPane.setBackground(new Color(222, 184, 135));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JLabel lblNewLabel = new JLabel("\uD1B5\uC77C \uAC80\uC0C9 \uC2DC\uC2A4\uD15C");
      lblNewLabel.setForeground(new Color(0, 0, 0));
      lblNewLabel.setFont(new Font("µ∏øÚ√º", Font.BOLD, 21));
      lblNewLabel.setBounds(230, 24, 476, 36);
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      contentPane.add(lblNewLabel);
      

      JPanel buttonPanel = new JPanel();
      getContentPane().add( buttonPanel, BorderLayout.SOUTH );
      
      JLabel lblNewLabel_1 = new JLabel("<SQL \uBA85\uB839\uC5B4>");
      lblNewLabel_1.setForeground(new Color(0, 0, 0));
      lblNewLabel_1.setFont(new Font("µ∏øÚ", Font.BOLD, 17));
      lblNewLabel_1.setBounds(487, 304, 448, 24);
      lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
      contentPane.add(lblNewLabel_1);
      

      
      JScrollPane scrollPane_1 = new JScrollPane();
      scrollPane_1.setBounds(487, 338, 448, 121);
      contentPane.add(scrollPane_1);
      
      JTextArea sql1 = new JTextArea();
      scrollPane_1.setColumnHeaderView(sql1);
      
      JButton btnNewButton_1 = new JButton("\uC785\uB825");
      btnNewButton_1.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		//sqlπÆ πﬁ¿Ω
      		sql = sql1.getText();
     		ShowTable.main(null);
      	}
      });
      btnNewButton_1.setBounds(524, 466, 93, 27);
      contentPane.add(btnNewButton_1);
      
      
      JButton btnNewButton = new JButton("\uC804\uCCB4 \uC0AD\uC81C");
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            sql1.setText("");
         }
      });
      btnNewButton.setBounds(814, 466, 93, 27);
      contentPane.add(btnNewButton);
      
      JLabel lblNewLabel_2 = new JLabel("");
      lblNewLabel_2.setIcon(new ImageIcon("D:\\\uD55C\uB3D9\uB300 \uAC15\uC758\uBCC4\\4\uD559\uB144 1\uD559\uAE30\\Database System\\\uD300\uD50C\\Unification DB image.jpg"));
      lblNewLabel_2.setBounds(713, 24, 208, 170);
      contentPane.add(lblNewLabel_2);
      
      JButton btnUserThings = new JButton("User things");
      btnUserThings.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		UserThings.main(null);
      	}
      });
      btnUserThings.setBounds(22, 74, 194, 26);
      contentPane.add(btnUserThings);
      
      JButton btnContentsHashtag = new JButton("Contents & HashTag");
      btnContentsHashtag.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		ContentsThings.main(null);
      		
      	}
      });
      btnContentsHashtag.setBounds(22, 130, 194, 26);
      contentPane.add(btnContentsHashtag);
      

      
      JButton btnManager = new JButton("Manager");
      btnManager.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		ManagerThings.main(null);
      	}
      });
      btnManager.setBounds(22, 306, 194, 26);
      contentPane.add(btnManager);
      
      JButton btnDictionary = new JButton("Dictionary");
      btnDictionary.setBounds(22, 243, 194, 26);
      contentPane.add(btnDictionary);
     
      
   }
}