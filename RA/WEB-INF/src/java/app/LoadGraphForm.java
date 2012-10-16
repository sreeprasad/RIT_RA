 


package app;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
 
public final class LoadGraphForm extends ActionForm {




// ------------------------------------------------ Instance Variables


    /**
     * The password.
     */
    private String password = null;
    private String dbname= null;

    /**
     * The username.
     */
    private String username = null;
    private String year= null;

	private String firstname = null;
 // ------------------------------------------------------ Properties


    /**
     * Return the password.
     */
    public String getDbname() {

  return (this.dbname);

    }


    /**
     * Set the password.
     *
     * @param password The new password
     */
    public void setDbname(String dbname) {

        this.dbname = dbname;

    }
 
    public String getYear() {

  return (this.year);

    }


    
    public void setYear(String year) {

        this.year = year;

    }



 
 

// -------------------------------------------------- Public Methods


    /**
     * Reset all properties to their default values.
     *
     * @param mapping The mapping used to select this instance
     * @param request The servlet request we are processing
     */
    public void reset(ActionMapping mapping,
        HttpServletRequest request) {

        setYear(null);
        setDbname(null);

    }


    /**
     * Ensure that both fields have been input.
     *
     * @param mapping The mapping used to select this instance
     * @param request The servlet request we are processing
     */
    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        ActionErrors errors = new ActionErrors();

        if ((dbname == null) || (dbname.length() < 1))
            errors.add("dbname",
                new ActionError("error.username.required"));

        if ((year == null) || (year.length() < 1))
            errors.add("year",
                new ActionError("error.password.required"));

        return errors;

    }

} // End LogonForm
