package ≈Î¿œdb;

import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;

public class ShowTable extends JFrame
{
	static ConnectionInformation ci = new ConnectionInformation();
	
	static String url = ci.url;
    static String userid = ci.getUserId();
    static String password = ci.getPassword();
    static String sql = ci.getSql();
	
    public ShowTable(String sql) {
    	System.out.println("url: " + url);
    	System.out.println("userid: " + userid);
    	System.out.println("sql: " + sql);
    	
    	ci.main(null);
    	getContentPane().setBackground(new Color(222, 184, 135));
    	getContentPane().setFont(new Font("µ∏øÚ", Font.PLAIN, 20));
        ArrayList columnNames = new ArrayList();
        ArrayList data = new ArrayList();

        //  Connect to an MySQL Database, run query, get result set
        

        // Java SE 7 has try-with-resources
        // This will ensure that the sql objects are closed when the program 
        // is finished with them
        try (Connection connection = DriverManager.getConnection( ci.url, ci.userid, ci.password );
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( sql ))
        {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names
            for (int i = 1; i <= columns; i++)
            {
                columnNames.add( md.getColumnName(i) );
            }

            //  Get row data
            while (rs.next())
            {
                ArrayList row = new ArrayList(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.add( rs.getObject(i) );
                }

                data.add( row );
            }
        }
        catch (SQLException e)
        {
            System.out.println( e.getMessage() );
        }

        // Create Vectors and copy over elements from ArrayLists to them
        // Vector is deprecated but I am using them in this example to keep 
        // things simple - the best practice would be to create a custom defined
        // class which inherits from the AbstractTableModel class
        Vector columnNamesVector = new Vector();
        Vector dataVector = new Vector();

        for (int i = 0; i < data.size(); i++)
        {
            ArrayList subArray = (ArrayList)data.get(i);
            Vector subVector = new Vector();
            for (int j = 0; j < subArray.size(); j++)
            {
                subVector.add(subArray.get(j));
            }
            dataVector.add(subVector);
        }

        for (int i = 0; i < columnNames.size(); i++ )
            columnNamesVector.add(columnNames.get(i));
        getContentPane().setLayout(null);

        //  Create table with database data    
        JTable table = new JTable(dataVector, columnNamesVector)
        {
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };
        

        JScrollPane scrollPane = new JScrollPane( table );
        scrollPane.setBounds(12, 10, 611, 242);
        getContentPane().add( scrollPane );
        
        JButton btnNewButton = new JButton("\uB2EB\uAE30");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        btnNewButton.setBounds(268, 270, 105, 27);
        getContentPane().add(btnNewButton);
    }

    public static void main(String args)
    {
        ShowTable frame = new ShowTable(args);
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.getContentPane().setPreferredSize(new Dimension(650,300));
        frame.pack();
        frame.setVisible(true);
    }
}