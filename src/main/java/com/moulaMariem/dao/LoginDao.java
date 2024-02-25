package com.moulaMariem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//This class establishes a connection to the Oracle database using JDBC (java.sql.Connection).
public class LoginDao {
	public static boolean validate(String name,String pass){  
		boolean status=false;  
		try{  
		// Loading the Oracle JDBC driver class
		Class.forName("oracle.jdbc.driver.OracleDriver");  
        // Establishing a connection to the database
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  
		 //
        // Preparing a SQL statement to query the database
		PreparedStatement ps=con.prepareStatement(  
		"select * from userreg where name=? and pass=?");  
		ps.setString(1,name);  
		ps.setString(2,pass);  
		      
		ResultSet rs=ps.executeQuery();
        // Checking if the result set has any rows
		status=rs.next();  
		          
		}catch(Exception e){
            // Handling any exceptions that occur during database operations
			System.out.println(e);
			}  
		return status;  
		}  
}
