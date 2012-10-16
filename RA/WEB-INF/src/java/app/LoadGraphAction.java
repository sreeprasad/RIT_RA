package app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionServlet;

import java.sql.*;
import javax.sql.*;

 

 
public final class LoadGraphAction extends Action {

 
 
  public ActionForward perform(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
        throws IOException, ServletException {

  
        String dbname = ((LoadGraphForm) form).getDbname();
        String year = ((LoadGraphForm) form).getYear();

   
        boolean validated = true;
        
         if((dbname==null)||(year==null))
        	validated=false;
        	
        if (!validated) {
            // credentials don't match
            ActionErrors errors = new ActionErrors();
            errors.add(ActionErrors.GLOBAL_ERROR,
            new ActionError("error.logon.invalid"));
            saveErrors(request,errors);
            // return to input page
            return (new ActionForward(mapping.getInput()));
        }
        
        
        	String fulltext = getdata(dbname,year);
   		 	HttpSession session = request.getSession();
   		 	session.setAttribute("fulltext", fulltext);
   		 	
   		 	session.setAttribute("year", year);
   		 	session.setAttribute("dbname", dbname);
   		 	System.out.println(fulltext);
        	System.out.println("forwarding to success");
			return (mapping.findForward(Constants.SUCCESS));
		}
  
  		public String getdata(String dbname,String year){
  			String getquery="select totalfulltext from vendor_fulltext where tid='";
				String fulltext="";
  			try{
  				Connection conn = getConnection();
  				String fireQuery = getquery+year+"' and vid='"+dbname+"'";
  				Statement s= conn.createStatement ();
  				System.out.println(fireQuery);
  				s.executeQuery(fireQuery);
  				ResultSet rs = s.getResultSet ();
			    while (rs.next ()){
			    	fulltext=rs.getString("totalfulltext");
			    }

  				
  			}catch(Exception e){
  				System.out.println(e.toString());
  			}
		    return fulltext;

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
  
  
} // End LogonAction
