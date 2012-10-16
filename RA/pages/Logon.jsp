<%@ taglib uri="/tags/struts-html" prefix="html" %>
<HTML>
<HEAD>
<TITLE>Sign in, Please!</TITLE>
<link rel="stylesheet" href="pages/js/themes/base/jquery.ui.all.css">
<script src="pages/js/jquery-1.6.2.min.js"></script>
<script src="pages/js/ui/jquery.ui.core.js"></script>
<script src="pages/js/ui/jquery.ui.widget.js"></script>
<script src="pages/js/jquery.ui.tabs.js"></script>
<script src="pages/js/ui/jquery.ui.accordion.js"></script>
<script src="pages/js/ui/jquery.ui.mouse.js"></script>
<script src="pages/js/ui/jquery.ui.selectable.js"></script>

<link rel="stylesheet" href="css/demos.css">
<script>
$(function() {
 
	$("#outermaintable").css("color","blue");


});
</script>
</HEAD>
<BODY bgcolor="grey">
	

<html:errors/>
 <table id="outermaintable" border="0">
	<tr> <td> 
			<img src="pages/libraryimage.jpg"  height="200" width="300"/> 
		</td>
		<td> RIT Library Dynamic Information Retrieval System</td>
		</tr>
	<tr>
		<td>
			<table id="loginTable">
				<html:form action="/LogonSubmit">
				<tr><td>Username<td><td><html:text property="username"/></td></tr>
				<tr><td>Password<td><td><html:password property="password"/></td></tr>	
		<tr><td><html:submit/>
			</td></tr>						
			</html:form>
			</table>
		</td>
	</tr>	
	
</table>

 
</BODY>
</HTML>

<%--

Allow user to submit username and password to logon action.

--%>