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
  
 

 
public final class FileUploadVendorAction extends Action {

	ValidUserCheck vc = new ValidUserCheck();

 

  public ActionForward perform(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
        throws IOException, ServletException {
	   
	  String csvFile="/softwares/tcat6/webapps/RA/poi/dbname-1.csv";
	 // upload_database(csvFile);
	  //upload_vendorFullText();
	  //upload_vendorName();
	  //upload_timeStamp();
		upload_search();
		 
	  return mapping.findForward("success"); 
  
		}
  
  public void upload_timeStamp(){
		 
		 try { 
			 String csvFile="/softwares/tcat6/webapps/RA/poi/timestamp_table.csv";
			 Connection conn = getConnection();
			 Statement s = conn.createStatement ();		
			 //s.executeQuery("truncate table db_name");	
		 	 String insertQuery =" insert into timeStamp (tid,timeStamp) VALUES ('";
			 
		 	BufferedReader CSVFile = 
		 	        new BufferedReader(new FileReader(csvFile));
		 	String dataRow = CSVFile.readLine();
		 	
		 	while (dataRow != null){
		 	   String[] dataArray = dataRow.split(",");
		 	    
		 	  if(dataArray[1].contains("'")){
		 		 dataArray[1]=dataArray[1].replace("'", "**");
		 	   }
		 	  
		 	   
		 	  String FireinsertQuery=insertQuery+dataArray[0]+"','"+dataArray[1]+"')";
		 	  System.out.println(FireinsertQuery);
		 	  s.executeUpdate(FireinsertQuery);
		 	   System.out.println(); // Print the data line.
		 	   dataRow = CSVFile.readLine(); // Read next line of data.
		 	  }
		 	
		 	
		       s.close();
		       CSVFile.close();

		     }catch(SQLException es){
		    	System.out.println(es.toString());
		     }catch(IOException eio){
		    	 System.out.println(eio.toString());
		     }catch (Exception e) {
		       System.err.println("CSV file cannot be read : " + e);
		     }

	}

  
  public void upload_vendorName(){
		 
		 try { 
			 String csvFile="/softwares/tcat6/webapps/RA/poi/DBname&ID.csv";
			 Connection conn = getConnection();
			 Statement s = conn.createStatement ();		
			 //s.executeQuery("truncate table db_name");	
		 	 String insertQuery =" insert into vendor_name (vid,vname) VALUES ('";
			 
		 	BufferedReader CSVFile = 
		 	        new BufferedReader(new FileReader(csvFile));
		 	String dataRow = CSVFile.readLine();
		 	
		 	while (dataRow != null){
		 	   String[] dataArray = dataRow.split(",");
		 	    
		 	  if(dataArray[1].contains("'")){
		 		 dataArray[1]=dataArray[1].replace("'", "**");
		 	   }
		 	  
		 	   
		 	  String FireinsertQuery=insertQuery+dataArray[0]+"','"+dataArray[1]+"')";
		 	  System.out.println(FireinsertQuery);
		 	  s.executeUpdate(FireinsertQuery);
		 	   System.out.println(); // Print the data line.
		 	   dataRow = CSVFile.readLine(); // Read next line of data.
		 	  }
		 	
		 	
		       s.close();
		       CSVFile.close();

		     }catch(SQLException es){
		    	System.out.println(es.toString());
		     }catch(IOException eio){
		    	 System.out.println(eio.toString());
		     }catch (Exception e) {
		       System.err.println("CSV file cannot be read : " + e);
		     }

	}
  
	public void upload_search(){

		 try { 
			 String csvFile="/softwares/tcat6/webapps/RA/poi/InfoForDBTable.csv";
			 Connection conn = getConnection();
			 Statement s = conn.createStatement ();		
			 //s.executeQuery("truncate table db_name");	
		 	 String insertQuery =" insert into search (tid,did,vid,M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12) VALUES ('";

		 	BufferedReader CSVFile = 
		 	        new BufferedReader(new FileReader(csvFile));
		
		 	String dataRow = CSVFile.readLine();
		 	int lineNumber=1;
		
		 	while (dataRow != null){
		System.out.println("was able to read file "); 
		 	
				
				

		 String[] dataArray = dataRow.split(",");

		 	  if(dataArray[1].contains("'")){
		 		 dataArray[1]=dataArray[1].replace("'", "**");
		 	   }


 			
				dataArray[4]= (dataArray[4]==null)?"0":dataArray[4];
				dataArray[5]= (dataArray[5]==null)?"0":dataArray[5];				
				dataArray[6]= (dataArray[6]==null)?"0":dataArray[6];
				dataArray[7]= (dataArray[7]==null)?"0":dataArray[7];				
				dataArray[8]= (dataArray[8]==null)?"0":dataArray[8];
				dataArray[9]= (dataArray[9]==null)?"0":dataArray[9];				
				dataArray[10]= (dataArray[10]==null)?"0":dataArray[10];
				dataArray[11]= (dataArray[11]==null)?"0":dataArray[11];				
				dataArray[12]= (dataArray[12]==null)?"0":dataArray[12];
				dataArray[13]= (dataArray[13]==null)?"0":dataArray[13];				
				dataArray[14]= (dataArray[14]==null)?"0":dataArray[14];
				dataArray[15]= (dataArray[15]==null)?"0":dataArray[15];
				
		 	  String FireinsertQuery=insertQuery+dataArray[0]+"','"+dataArray[1]+"','"+dataArray[2]+"','" +dataArray[4]+"','" +
		 	  dataArray[5]+"','" +dataArray[6]+"','" +dataArray[7]+"','" +dataArray[8]+"','" +dataArray[9]+"','" +
		 	  dataArray[10]+"','" +dataArray[11]+"','" +dataArray[12]+"','" +dataArray[13]+"','" +dataArray[14]+"','" +
		 	  dataArray[15]+"'" +")";
		System.out.println("*** before checking line number ****");
		 		 System.out.println(FireinsertQuery);		
				System.out.println("*** after checking line number ****");
		 	  if(lineNumber!=1){
		 		 System.out.println(FireinsertQuery);
			 	  s.executeUpdate(FireinsertQuery);
			 	   System.out.println(); // Print the data line.  
		 	  }
		System.out.println(lineNumber);
		 	  lineNumber++;
		 	   dataRow = CSVFile.readLine(); // Read next line of data.
		 	  }


		       s.close();
		       CSVFile.close();

		     }catch(SQLException es){
		    	System.out.println(es.toString());
		     }catch(IOException eio){
		    	 System.out.println(eio.toString());
		     }catch (Exception e) {
		       System.err.println("CSV file cannot be read : " + e);
		     }

	}



  public void upload_vendorFullText(){
		 
		 try { 
			 String csvFile="/softwares/tcat6/webapps/RA/poi/Vendor_fulltext_table.csv";
			 Connection conn = getConnection();
			 Statement s = conn.createStatement ();		
			 //s.executeQuery("truncate table db_name");	
		 	 String insertQuery =" insert into vendor_fulltext (tid,vid,M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,totalfulltext) VALUES ('";
			 
		 	BufferedReader CSVFile = 
		 	        new BufferedReader(new FileReader(csvFile));
		 	String dataRow = CSVFile.readLine();
		 	int lineNumber=1;
		 	while (dataRow != null){
		 	   String[] dataArray = dataRow.split(",");
		 	    
		 	  if(dataArray[1].contains("'")){
		 		 dataArray[1]=dataArray[1].replace("'", "**");
		 	   }
		 	  
		 	   
		 	  String FireinsertQuery=insertQuery+dataArray[0]+"','"+dataArray[1]+"','"+dataArray[2]+"','" +dataArray[3]+"','" +
		 	  dataArray[4]+"','" +dataArray[5]+"','" +dataArray[6]+"','" +dataArray[7]+"','" +dataArray[8]+"','" +
		 	  dataArray[9]+"','" +dataArray[10]+"','" +dataArray[11]+"','" +dataArray[12]+"','" +dataArray[13]+"','" +
		 	  dataArray[14]+"'" +")";
		 	  if(lineNumber!=1){
		 		 System.out.println(FireinsertQuery);
			 	  s.executeUpdate(FireinsertQuery);
			 	   System.out.println(); // Print the data line.  
		 	  }
		 	  lineNumber++;
		 	   dataRow = CSVFile.readLine(); // Read next line of data.
		 	  }
		 	
		 	
		       s.close();
		       CSVFile.close();

		     }catch(SQLException es){
		    	System.out.println(es.toString());
		     }catch(IOException eio){
		    	 System.out.println(eio.toString());
		     }catch (Exception e) {
		       System.err.println("CSV file cannot be read : " + e);
		     }

	}
  
  public void upload_database(String csvFile ){
		 
		 try { 
			 Connection conn = getConnection();
			 Statement s = conn.createStatement ();		
			 //s.executeQuery("truncate table db_name");	
		 	 String insertQuery =" insert into db_name (d_ID,d_Name,v_ID) VALUES ('";
			 
		 	BufferedReader CSVFile = 
		 	        new BufferedReader(new FileReader(csvFile));
		 	String dataRow = CSVFile.readLine();
		 	
		 	while (dataRow != null){
		 	   String[] dataArray = dataRow.split(",");
		 	    
		 	  if(dataArray[1].contains("'")){
		 		 dataArray[1]=dataArray[1].replace("'", "**");
		 	   }
		 	  
		 	   
		 	  String FireinsertQuery=insertQuery+dataArray[0]+"','"+dataArray[1]+"','"+dataArray[2]+"')";
		 	  System.out.println(FireinsertQuery);
		 	  s.executeUpdate(FireinsertQuery);
		 	   System.out.println(); // Print the data line.
		 	   dataRow = CSVFile.readLine(); // Read next line of data.
		 	  }
		 	
		 	
		       s.close();
		       CSVFile.close();

		     }catch(SQLException es){
		    	System.out.println(es.toString());
		     }catch(IOException eio){
		    	 System.out.println(eio.toString());
		     }catch (Exception e) {
		       System.err.println("CSV file cannot be read : " + e);
		     }

	}


 

public void upload(String csvFile ){
	 
	 try { 
		 Connection conn = getConnection();
		 Statement s = conn.createStatement ();		
		 s.executeQuery("truncate table db_name");	
	 	 String insertQuery =" insert into db_name (d_ID,d_Name,v_ID) VALUES ('";
		 
	 	   //create BufferedReader to read csv file
	       BufferedReader br = new BufferedReader(new FileReader(csvFile));
	       String line = "";
	       StringTokenizer st = null;

	       int lineNumber = 0; 
	       int tokenNumber = 0;

	       //read comma separated file line by line
	       while ((line = br.readLine()) != null) {
	         lineNumber++;

	         if(lineNumber!=1){
	         //use comma as token separator
	         st = new StringTokenizer(line, ",");
	         String did="",dname="",vid="";
	         while (st.hasMoreTokens()) {
	           tokenNumber++;

	           //display csv values
	           if(did=="")
	        	   	did=st.nextToken() ;
	           else if(dname=="")
	        	   	dname=st.nextToken() ;
	           else if(vid=="")
	        	   vid=st.nextToken();
	            
	         }
	         
	         String query= insertQuery + did + "','"+ dname+"','"+vid+"')";
	         System.out.println(query);
	         s.executeUpdate (query);
	         
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

