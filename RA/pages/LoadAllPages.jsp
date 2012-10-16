<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@page import="java.util.*"%>

<HTML>
<HEAD>
<TITLE>Welcome!</TITLE>
 <script src="pages/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var selectedOptions = $('#_selDoc option:selected');
	
	$("#_selDoc").change(function(){
		var selectedOptions = $("#_selDoc").val();
	   $('#selPage').find('option').each(function() {
 		if($("#_selDoc").val()!= $(this).val()){
			$(this).remove();
}
	});		
	});
	
});
 </script>
 </HEAD>
<BODY>
 

<h1> DAKKU DADDY LOAD DOCUMENT </h1>
<%   String s[]= new String[100];
List<String> listRole = (List<String>)(request.getSession().getAttribute("list")); 
List<String> listRoleDocId = (List<String>)(request.getSession().getAttribute("listPageId")); 
 if(listRoleDocId!=null){
 %>

 <table border='1'>	
	<th>Docid</th>
 <% for(int i=0;i<listRole.size();i++){%>		
		<tr><td><%=listRole.get(i)%></td></tr>
	<%}%>
  </table>
</br>
<b>Enter the doc id you wish to see </b>
<html:form action="/LoadDocument">
<html:text property="empFname"/>
<html:submit value="getAllPages"/>

</html:form>
<% }else{ %>
	<table>
    <tr> <td></td><td><table>
	<th>Page id </th>
 <% for(int i=0;i<listRoleDocId.size();i++){%>		
		<tr><td><%=listRoleDocId.get(i)%></td></tr>
		<%}%>

	
	</td>
	</tr>
	
<% } %>

 




</BODY>
</HTML>

 