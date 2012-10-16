 package app;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

 
public final class FileUploadForm extends ActionForm {




// ------------------------------------------------ Instance Variables
	  private FormFile theFile;


	/**
	 * @return Returns the theFile.
	 */
	  public FormFile getTheFile() {
		  return theFile;
	  }
	  
	  
	  
	 /** 
	 * @param theFile The FormFile to set.
	 */
	  public void setTheFile(FormFile theFile) {
		  this.theFile = theFile;
	  }
   
  
 


     
} // End LogonForm
