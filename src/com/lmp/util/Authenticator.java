package com.lmp.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.core.Response;

import com.exception.generalException;

/**
 * It checks customer database for matching credentials
 * @param 	customer email
 * @param	  customer password
 * @return	bool (yes if the user is valid)
 */

public class Authenticator {

	public static boolean authenticateUser(String email, String password) {
		boolean isUserAuthentic = false;
		Connection conn = DatabaseConnection.getSqlConnection();
		PreparedStatement pstmt = null;
		
		if(conn != null){
			try{
				String searchQuery = "SELECT * FROM `customer` WHERE email = ? AND password = ? AND active = 1 LIMIT 1";
				pstmt = conn.prepareStatement(searchQuery);
				pstmt.setString(1, email);
				pstmt.setString(2, password);
				ResultSet resultSet = pstmt.executeQuery();
				while(resultSet.next()){
					int custId = resultSet.getInt("customer_id");
					if(custId >= 0){
						isUserAuthentic = true;
					}
				}
			}
				
			} catch(SQLException sqe){
				System.err.println("SQLException on authenticating user.");
	  	      	System.err.println(sqe.getMessage());
			} finally {
				try {
					pstmt.close();
					conn.close();
				} catch (Exception e) {
					System.err.println("SQLException on authenticating user");
					System.err.println(e.getMessage());
				}
			}
		}else{
			throw new generalException("Failed connection with DB", Response.Status.INTERNAL_SERVER_ERROR);
		}
		
		return isUserAuthentic;
	}
	
	/**
	 * It verifies if customer exists
	 * @param email 	customer email
	 * @param password	customer password hash
	 * @return customerID 	customer ID from DB or -1 if invalid 
	 */
	public static int authenticateCustomer(String email, String password) {
		int customerID = -1;
		Connection conn = DatabaseConnection.getSqlConnection();
		PreparedStatement pstmt = null;
		
		if(conn != null){
			try{
				String searchQuery = "SELECT * FROM `customer` WHERE email = ? AND password = ? AND active = 1 LIMIT 1";
				pstmt = conn.prepareStatement(searchQuery);
				pstmt.setString(1, email);
				pstmt.setString(2, password);
				ResultSet resultSet = pstmt.executeQuery();
				while(resultSet.next()){
					int custId = resultSet.getInt("customer_id");
					if(custId >= 0)
						customerID = custId;
					return customerID;
				}
				
			}catch(SQLException sqe){
				System.err.println("SQLException on authenticating user");
	  	      	System.err.println(sqe.getMessage());
			} finally {
				try {
					pstmt.close();
					conn.close();
				} catch (Exception e) {
					System.err.println("SQLException on authenticating user");
					System.err.println(e.getMessage());
				}
			}
		}else{
			throw new generalException("Failed connection with DB", Response.Status.INTERNAL_SERVER_ERROR);
		}
		
		return customerID;
	}	
}
