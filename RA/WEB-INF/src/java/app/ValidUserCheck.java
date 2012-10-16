package app;

import java.sql.SQLException;
import java.sql.*;
import javax.sql.*;
 

public class ValidUserCheck{
	
	private static ValidUserCheck validUser = null;
	
	private String username,fname,lname,desig,email;
    
	public static ValidUserCheck getInstance() throws SQLException 
     {
        if (null==validUser){
            validUser = new ValidUserCheck();
        }
        return validUser;
    }


	public Connection getConnection(){
	 Connection conn = null;
		try{
			  String db_userName = Constants.DB_USER;
	           String db_password = Constants.DB_PASS;
			   String url = Constants.DB_URL;
	           Class.forName ("com.mysql.jdbc.Driver").newInstance ();
	           conn = DriverManager.getConnection (url, db_userName, db_password);
	           System.out.println ("Database connection established");
		}catch(SQLException e){
				System.out.println("error in ValidUserCheck");
		 				System.out.println(e.toString());
			}catch(Exception e){
				System.out.println("major excepiton in ValidUserCheck");
		 		System.out.println(e.toString());
			}		 
		return conn;
	}
	
	public boolean isValidUser(String username, String password,LogonForm form) throws SQLException {
	 	
	try{
		Statement s_validity = getConnection().createStatement();
		String query="select 	if(('"+password+"')=(select password from authenticate where username ='"+username+"'),'true','false') as answer";
		s_validity.executeQuery (query);
		System.out.println(query);
		   ResultSet rs = s_validity.getResultSet ();
		while(rs.next()){
		 if(rs.getString("answer").equals("true")) return true;
		 else return false;
	 	}
    return false;	  
	}catch(SQLException e){
		System.out.println("error in ValidUserCheck");
 				System.out.println(e.toString());
				return false;		
	}catch(Exception e){
		System.out.println("major excepiton in ValidUserCheck");
 		System.out.println(e.toString());
		return false;		
	} 		
	}
	
	
}