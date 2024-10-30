package com.blog.models; 

import java.sql.*;

import jakarta.servlet.RequestDispatcher;

public class Database 
{
	
	// Database Info ; 
			private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
			private static final String username = "SYSTEM";
			private static final String password = "youssef3334AB";
	
	public static Connection getConnection() throws SQLException 
	{ 
       return DriverManager.getConnection(url , username , password);
	}
	
	public static User getUserByUsernameAndPassword(String username, String password) 
	{
		  try 
	        {	        		  
			  	// Establish Connection And Statement to Execute ;
		        Connection connection = null;
		        Statement st = null;
		        ResultSet rs = null;
		        
		        
	        	// Connect To Database ;
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            connection = DriverManager.getConnection(url, dbusername, dbpassword);
	            System.out.println("Connected to Database!");

	            // Create Query ;
	            String sql = "SELECT id , username , password FROM users WHERE username ='"+username+"' and password='"+password+"'";  // Query
	            System.out.println("Executing Query: " + sql);

	            // Executing Query ;
	            st = connection.createStatement();
	            rs = st.executeQuery(sql);
	            
	            // Assign data that in database to the list of students that we create ;
	            boolean found = false;
	           if ( rs.next()) 
	           {
	            found = true;
	            return new User(rs.getInt("id") , rs.getString("username") , rs.getString("password") , "");
	           
	            }
	        	
	            // Check if there is no data in table then print not found ; 
	            if (!found) 
	            {
	                return null;
	            }
	        	} 
		  		catch (ClassNotFoundException e) 
		  			{
	        		System.out.println("Error loading driver: " + e.getMessage());
		  			}
		  	 	catch (SQLException e) 
		  			{
		  			System.out.println("Database error: " + e.getMessage() );
		  			} 
    }
}