<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<HTML>
<HEAD>
<TITLE>Welcome!</TITLE>
<html:base/>

<script src="js/jquery-1.6.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
 
$("#_userTable").hide();$("#_addEmployee").hide(); $("#_security").hide(); $("#_document").hide(); 
$("#_add_doc_show").hide();	$("#_useradded").click(function(e){
e.preventDefault();$("#_userTable").show();$("#_document").hide();$("#_security").hide();$("#_add_doc_show").hide();});
$("#_addUser").click(function(e){e.preventDefault(); $("#_addEmployee").show();	$("#_document").hide();	
$("#_security").hide();	$("#_add_doc_show").hide();});
$("#_security_").click(function(e){e.preventDefault();$("#_security").show();$("#_document").hide();	
$("#_add_doc_show").hide();$("#_userTable").hide();$("#_addEmployee").hide();});
$("#_document_").click(function(e){e.preventDefault();$("#_document").show();$("#_security").hide();	
$("#_add_doc_show").hide();$("#_userTable").hide();$("#_addEmployee").hide();});
$("#_createDoc_").click(function(e){e.preventDefault();$("#_add_doc_show").show();$("#_userTable").hide();
$("#_security").hide();});


});
</script>

</HEAD>
<BODY>

 
  
<table id="adminTable" border='1'>
	<tr><td>
<a id="_useradded" href=""> User</a> <br/><a id="_security_" href=""> Security</a>  <br/><a id="_document_" href="">Document</a> <br/></td></tr>
</table>

<table id="_userTable" border='1'>
	<tr>
	    <td id="_addUser"> <a id="_addUser" href=""> Add User <br/>Load <br/> <br/></td> </tr>
 
</table>
 
<table id="_addEmployee" border='1'>
 	
	 	<tr><td> Add Employee Id   <input type="text"/><br/></td></tr>
 	<tr><td> Add First Name  <input type="text"/><br/></td></tr>
	<tr><td> Add Last Name   <input type="text"/><br/></td></tr>	
	<tr><td> Add Email  <input type="text"/><br/></td></tr>	
 	<tr><td> Add Designation <input type="text"/><br/></td></tr>	 
 	<tr><td> Add Username  <input type="text"/><br/></td></tr>	 
 	<tr><td> Add Password   <input type="text"/> <br/></td></tr>
 	<tr><td>  <input type="submit" value="Submit" /> <br/></td></tr>
 </table>


<table id="_security" border='1'>
  	 	<tr><td> DAC     <input type="checkbox"/><br/></td></tr>
  	 	<tr><td> MAC      <input type="checkbox"/><br/></td></tr>
  	 	<tr><td> RBAC      <input type="checkbox"/><br/></td></tr>
 	<tr><td>  <input type="submit" value="Submit" /> <br/></td></tr>
 </table>

<table id="_document" border='1'>
 
	<tr>
	    <td> <a id="_createDoc_" href=""> Create Document </a> <br/><a id="_loadDoc_" href=""> Load Document </a> <br/></td> </tr>
 </table>

<table id="_add_doc_show" border='1'>
 
	 	<tr><td> Add document id   <input type="text"/> <br/></td></tr>
 	<tr><td> Add Page id  <input type="text"/><br/></td></tr>
	<tr><td> Add Category  <input type="text"/> <br/></td></tr>
	<tr><td> Add Text   <input type="text"/><br/></td></tr>	
	<tr><td>  <input type="submit" value="Submit" /> <br/></td></tr>
 	
 	
  </table>



  </BODY>
</HTML>

 