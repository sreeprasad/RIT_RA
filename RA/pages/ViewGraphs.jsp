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
 	
	$("#submitdetails").hide();
	$("#submitdetails").click(function(){
		
		alert("submit clicked");
	});	
	 
    $("ul.subnav").parent().append("<span></span>"); //Only shows drop down trigger when js is enabled (Adds empty span tag after ul.subnav*)  
      
    $("ul.topnav li span").click(function() { //When trigger is clicked...  
          
        //Following events are applied to the subnav itself (moving subnav up and down)  
       $(this).parent().find("ul.subnav").slideDown('fast').show(); //Drop down the subnav on click  
  		 
		// to click 
		$(this).parent().find("ul.subnav a").click(function(){
			
			
			var id = $(this).attr("id");
			var classname = $(this).attr("class");
 			if(classname!="year"){
				var db =$(this).text();
				var inputCallOut ="You have selected the database";
				$("#dbselected").append("<br/>"+inputCallOut+"<br/><input type='text' id='dbinput' value="+db+"></input>");	
			}else{
				var yearSel =$(this).text();
				var inputCallOut ="You have selected the year";
				
				$("#dbselected").append("<br/><br/><br/>"+inputCallOut+"<br/><input type='text' id='dbinput' value="+yearSel+"></input>");
				$("#submitdetails").show();
			}
			 
			 
			
		});


        $(this).parent().hover(function() {  
        }, function(){    
            $(this).parent().find("ul.subnav").slideUp('slow'); //When the mouse hovers out of the subnav, move it back up  
        });  
  
        //Following events are applied to the trigger (Hover events for the trigger)  
        }).hover(function() {   
            $(this).addClass("subhover"); //On hover over, add class "subhover"  
        }, function(){  //On Hover Out  
            $(this).removeClass("subhover"); //On hover out, remove class "subhover"  
    });
 

});
</script>
<style type="text/css">
ul.topnav {  
    list-style: none;  
    padding: 0 20px;      
    margin: 0;  
    float: left;  
    width: 920px;  
    background: #222;  
    font-size: 1.2em;  
    background: url(topnav_bg.gif) repeat-x;  
}  
ul.topnav li {  
    float: left;  
    margin: 0;    
    padding: 0 15px 0 0;  
    position: relative; /*--Declare X and Y axis base for sub navigation--*/  
}  
ul.topnav li a{  
    padding: 10px 5px;  
    color: #fff;  
    display: block;  
    text-decoration: none;  
    float: left;  
}  
ul.topnav li a:hover{  
    background: url(topnav_hover.gif) no-repeat center top;  
}  
ul.topnav li span { /*--Drop down trigger styles--*/  
    width: 17px;  
    height: 35px;  
    float: left;  
    background: url(subnav_btn.gif) no-repeat center top;  
}  
ul.topnav li span.subhover {background-position: center bottombottom; cursor: pointer;} /*--Hover effect for trigger--*/  
ul.topnav li ul.subnav {  
    list-style: none;  
    position: absolute; /*--Important - Keeps subnav from affecting main navigation flow--*/  
    left: 0; top: 35px;  
    background: #333;  
    margin: 0; padding: 0;  
    display: none;  
    float: left;  
    width: 170px;  
    border: 1px solid #111;  
}  
ul.topnav li ul.subnav li{  
    margin: 0; padding: 0;  
    border-top: 1px solid #252525; /*--Create bevel effect--*/  
    border-bottom: 1px solid #444; /*--Create bevel effect--*/  
    clear: both;  
    width: 170px;  
}  
html ul.topnav li ul.subnav li a {  
    float: left;  
    width: 145px;  
    background: #333 url(dropdown_linkbg.gif) no-repeat 10px center;  
    padding-left: 20px;  
}  
html ul.topnav li ul.subnav li a:hover { /*--Hover effect for subnav links--*/  
    background: #222 url(dropdown_linkbg.gif) no-repeat 10px center;   
}
</style>

</HEAD>
<BODY bgcolor="grey">

 
  
 <div id="URLDropDown">
	

<ul class="topnav">  
    <li><a href="#">Home</a></li>  
    <li>  
        <a href="#">Database</a>  
        <ul class="subnav">  
            <li><a class="dbname" id="e1000116" href="#">EBSCO</a></li>  
            <li><a class="dbname" id="e1000119" href="#">Scitation</a></li>
            <li><a class="dbname" id="e1000020" href="#">ACM</a></li>
            <li><a class="dbname" id="e1000027" href="#">CSA</a></li>
			<li><a class="dbname" id="e1000043" href="#">ei.org</a></li>
			<li><a class="dbname" id="e1000035" href="#">ERL</a></li>
			<li><a class="dbname" id="e1000021" href="#">ACS publication</a></li>
			<li><a class="dbname" id="e1000227" href="#">Proquest</a></li>
			<li><a class="dbname" id="e1000226" href="#">OCLC</a></li>
			<li><a class="dbname" id="e1000065" href="#">LexisNexis</a></li>
			<li><a class="dbname" id="e1000116" href="#">EBSCO</a></li>
			<li><a class="dbname" id="e1000059" href="#">Oxford university press</a></li>
			<li><a class="dbname" id="e1000074" href="#">Standard and Poors</a></li>
			<li><a class="dbname" id="e1000209" href="#">Springer</a></li>
			<li><a class="dbname" id="e1000229" href="#">SAGE journals</a></li>
			<li><a class="dbname" id="e1000045" href="#">CQ press</a></li>
			<li><a class="dbname" id="e1000032" href="#">books 24x7</a></li>
			<li><a class="dbname" id="e1000076" href="#">GALE admin</a></li>
			<li><a class="dbname" id="e1000132" href="#">Emerald</a></li>
			<li><a class="dbname" id="e1000084" href="#">Safari</a></li>
			<li><a class="dbname" id="e1000216" href="#">Credo Reference</a></li>
			<li><a class="dbname" id="e1000205" href="#">Access Medicine</a></li>
			<li><a class="dbname" id="e1000018" href="#">BioOne</a></li>
			<li><a class="dbname" id="e1000052" href="#">Elsevier</a></li>
			<li><a class="dbname" id="e1000228" href="#">AEAweb</a></li>
			<li><a class="dbname" id="e1000062" href="#">JSTOR</a></li>
			<li><a class="dbname" id="e1000241" href="#">IOP publishing</a></li>
			<li><a class="dbname" id="e1000185" href="#">WEB OF KNOWLEDGE</a></li>
			<li><a class="dbname" id="e1000048" href="#">ebrary</a></li>
			<li><a class="dbname" id="e1000316" href="#">Gale Admin</a></li>
			<li><a class="dbname" id="e1000056" href="#">Factiva</a></li>
			<li><a class="dbname" id="e1000294" href="#">IOP publishing</a></li>									
        </ul>  
    </li>  
    <li>  
        <a href="#">Year</a>  
        <ul class="subnav">  
            <li><a class="year" href="#">2001</a></li>  
            <li><a class="year" href="#">2002</a></li>
            <li><a class="year" href="#">2003</a></li>
            <li><a class="year" href="#">2004</a></li>
        </ul>  
    </li>  
    <li><a href="#">About Us</a></li>  
    <li><a href="#">Contact Us</a></li>  
    <li><a href="#">Log Out</a></li>  
</ul>
</div>
<br/><br/><br/>
<div id="selectedValues">
	<p id="dbselected"> </p>
	<p id="yearSelected"> </p>
	<input type='submit' id='submitdetails'></input>
</div>
<h2> SELECT DATABASE </h2>
<html:form action="/loadGraph">
<div id="strutsdbdropdown">
	<html:select property="dbname">
		<html:option value="e1000020">ACM</html:option>
		<html:option value="e1000027">CSA</html:option>
		<html:option value="e1000043">ei.org</html:option>
		<html:option value="e1000035">ERL</html:option>
		<html:option value="e1000021">ACS publication</html:option>
	</html:select>
</div>
 
<h2> SELECT YEAR </h2>
<div id="strutsyeardropdown">
	<html:select property="year">
		<html:option value="ts_2012">2012</html:option>
		<html:option value="ts_2011">2011</html:option>
		<html:option value="ts_2010">2011</html:option>
		<html:option value="ts_2009">2009</html:option>
		<html:option value="ts_2008">2008</html:option>
	</html:select>
	<br/><br/>
	<html:submit/>
</div>
</html:form>
<div id="results">
<%
String totalfulltext="",year="",dbname="";
 year =(String)request.getSession().getAttribute("year");
 dbname =(String)request.getSession().getAttribute("dbname");
 totalfulltext =(String)(request.getSession().getAttribute("fulltext"));
if(totalfulltext!=null){
%>
<h2>Total FullText</h2>
<input type=text  value='<%=totalfulltext%>'></input>
<%
}
else{
%> 
 
<%} %>
</div>

  </BODY>
</HTML>

 