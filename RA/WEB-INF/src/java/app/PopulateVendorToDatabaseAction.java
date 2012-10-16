package app;
 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
 import org.apache.poi.hssf.usermodel.examples.HSSFReadWrite;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.upload.FormFile;
import java.sql.*;
import java.util.StringTokenizer;

import javax.sql.*;
  
 

 
public final class PopulateVendorToDatabaseAction extends Action {

 
 public ActionForward perform(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
        throws IOException, ServletException {
	   
	  String csvFile="/softwares/tcat6/webapps/RA/poi/ACM2012.csv";
	  System.out.println("calling the update function");
	  upload(csvFile);
	  return mapping.findForward("success");
  
		}

 

public void upload(String csvFile ){
	 
	 try { 
		 System.out.println("inside upload");
		 Connection conn = getConnection();
		 Statement s = conn.createStatement ();		
		 
		 String getDbQuery="select d_ID from db_name where d_Name like '% ";
	 	 //String insertQuery =" insert into tempRA (dbname ,dbid,full_Text,v_ID,db-ID,cost/ft,cost/search) VALUES ('";
		 String insertQuery =" insert into tempRA (dbname,dbid) VALUES ('";
		 String getAndInsertQueryStart ="insert into tempRA (dbname,dbid) values ('";
		 String getAndInsertQueryEnd ="',select d_ID from db_name where d_Name like '";
		 
	 	   //create BufferedReader to read csv file
	       BufferedReader br = new BufferedReader(new FileReader(csvFile));
	       String line = "";
	       StringTokenizer st = null;

	       int lineNumber = 0; 
	       int tokenNumber = 0;

	       //read comma separated file line by line
	       while ((line = br.readLine()) != null) {
	         lineNumber++;

	         if(lineNumber>6){
	         //use comma as token separator
	         st = new StringTokenizer(line, ",");
	         String dbname="";
	         while (st.hasMoreTokens()) {
	           tokenNumber++;

	           //display csv values
	           if(dbname==""){
	        		dbname=st.nextToken();
	        		break;
	           }
	        	   
	           
	            
	         }
	         String allInOne =getAndInsertQueryStart+dbname+getAndInsertQueryEnd+dbname+"')";
	         /*String query=getDbQuery+dbname+"%')";
	         System.out.println(query);*/
	         System.out.println(allInOne);
	         s.executeUpdate(allInOne);
	        
			  
	         
	         
	       }
	         System.out.println();

	         //reset token number
	         tokenNumber = 0;
	       }
	       s.close();
	     }catch(SQLException es){
	    	System.out.println(es.toString()); 
	     }catch (Exception e) {
	       System.err.println("CSV file cannot be read : " + e);
	     }

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
}// End LogonAction

