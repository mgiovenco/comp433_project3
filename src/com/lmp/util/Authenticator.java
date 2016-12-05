package com.lmp.util;

import com.lmp.exception.generalException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.core.Response;

public class Authenticator {
    private static final String SELECT_USER_QUERY =
        "SELECT * FROM `customer` WHERE email = ? AND password = ? AND active = 1 LIMIT 1";

    private static final String CUSTOMER_ID = "customer_id";

    /**
     * It checks customer database for matching credentials
     *
     * @param email user email
     * @param password user password
     * @return boolean (yes if the user is valid)
     */
    public static boolean authenticate(String email, String password) {
        return getUserId(email, password) >= 0;
    }

    /**
     * It verifies if customer exists
     *
     * @param email    customer email
     * @param password customer password hash
     * @return customerID        customer ID from DB or -1 if invalid
     */
    public static int authenticatedAndGet(String email, String password) {
        return getUserId(email, password);
    }

    private static int getUserId(String email, String password) {
        int customerId = -1;
        PreparedStatement pstmt = null;
        Connection conn = DBHelper.getconnection();
        if (conn != null) {
            try {
                pstmt = conn.prepareStatement(SELECT_USER_QUERY);
                pstmt.setString(1, email);
                pstmt.setString(2, password);
                ResultSet resultSet = pstmt.executeQuery();
                while (resultSet.next()) {
                    customerId = resultSet.getInt(CUSTOMER_ID);
                }
            } catch (SQLException ex) {
                System.err.println("SQLException on authenticating user.");
                System.err.println(ex.getMessage());
            } finally {
                try {
                    if (pstmt != null) {
                        pstmt.close();
                    }
                    conn.close();
                } catch (Exception e) {
                    System.err.println("SQLException on authenticating user");
                    System.err.println(e.getMessage());
                }
            }
            return customerId;
        } else {
            throw new generalException("Failed connection with DB", Response.Status.INTERNAL_SERVER_ERROR);
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
	}*/
	
	/**
	 * It verifies if customer exists
	 * @param email 	customer email
	 * @param password	customer password hash
	 * @return customerID 	customer ID from DB or -1 if invalid 
	 */
	/*public static int authenticateCustomer(String email, String password) {
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
	}	*/
}
