package 통일db;

import java.awt.EventQueue;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionInformation {
	public static String url = "jdbc:mysql://ec2-52-78-29-225.ap-northeast-2.compute.amazonaws.com";
	public static String userid = "root";
	public static String password = "db14";
	public static String sql = "SELECT * FROM UnificationDB.User";
	public static String driver = "com.mysql.cj.jdbc.Driver";
	
	
    public static void main(String[] args) {
        // Connection 객체를 자동완성으로 import할 때는 com.mysql.connection이 아닌
        // java 표준인 java.sql.Connection 클래스를 import해야 한다.
        Connection conn = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url, userid, password);
            System.out.println("연결 성공");
      
        }
        catch(ClassNotFoundException e){
            System.out.println("드라이버 로딩 실패");
        }
        catch(SQLException e){
            System.out.println("에러: " + e);
        }
        finally{
            try{
                if( conn != null && !conn.isClosed()){
                	System.out.println("~~");
                  //  conn.close();
                }
            }
            catch( SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    
    
    public String getDriver() {
		   return this.driver;
	   }
	   
	   public String getUrl() {
		   return this.url;
	   }
	   
	   public String getUserId() {
		   return this.userid;
	   }
	   
	   public String getPassword() {
		   return this.password;
	   }
	   
	   public String getSql() {
		   return this.sql;
	   }
	   
	   public void setSql(String s) {
		   this.sql = s;
	   }
	

	   
	  
}
