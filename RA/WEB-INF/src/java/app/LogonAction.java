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
import java.sql.SQLException;
import java.sql.*;
import javax.sql.*;

 

 
public final class LogonAction extends Action {

	ValidUserCheck vc = new ValidUserCheck();

  
    public boolean isUserLogon(String username,
         String password,LogonForm form)  throws SQLException{
			
    //  		return (ValidUserCheck.getInstance().isValidUser(username,password,form));
	 return true;
    	}

  public ActionForward perform(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
        throws IOException, ServletException {

  
        String username = ((LogonForm) form).getUsername();
        String password = ((LogonForm) form).getPassword();

   
        boolean validated = false;
		//Person P = null;
        try {

            validated = isUserLogon(username,password,((LogonForm) form));
        }

        catch (SQLException ude) {
    
            ActionErrors errors = new ActionErrors();
            errors.add(ActionErrors.GLOBAL_ERROR,
            new ActionError("error.logon.connect"));
            saveErrors(request,errors);
            // return to input page
            return (new ActionForward(mapping.getInput()));
        }

        if (!validated) {
            // credentials don't match
            ActionErrors errors = new ActionErrors();
            errors.add(ActionErrors.GLOBAL_ERROR,
            new ActionError("error.logon.invalid"));
            saveErrors(request,errors);
            // return to input page
            return (new ActionForward(mapping.getInput()));
        }
			return (mapping.findForward(Constants.SUCCESS));
		}
} // End LogonAction
