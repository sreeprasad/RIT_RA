<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 
 <html:form action="/FileUpload" method="post" enctype="multipart/form-data">
 
<table>
 
<tr>
<td align="center" colspan="2">
<html:submit>Upload File</html:submit>
</td>
</tr>

</table>
</html:form>

 
</body>
</html>