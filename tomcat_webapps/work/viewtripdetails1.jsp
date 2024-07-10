
 
<%@ page language="java"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html> 
	<head>
		<title>JSP for ViewBus</title>
	</head>
	<body>
	   <center><b><font color="#FF9900" size="5">View Trip Details</font></b><br><br>
	   <logic:notEmpty name="obj" scope="session">
		<table border="1">
		<tr><th><bean:message key="trid" /></th>
		<th><bean:message key="busno" /></th>
		<th><bean:message key="startpoint" /></th>
		<th><bean:message key="endpoint" /></th>
		<th><bean:message key="starttime" /></th>
		<th><bean:message key="endtime" /></th>
		<th><bean:message key="viewhalts" /></th>
		<th><bean:message key="change" /></th>
		
		</tr>
		<logic:iterate id="obj" name="obj">
		<tr><td><bean:write name="obj" property="trid" /></td>
		<td><bean:write name="obj" property="busno" /></td>
		<td><bean:write name="obj" property="startpoint" /></td>
		<td><bean:write name="obj" property="endpoint" /></td>
		<td><bean:write name="obj" property="starttime" /></td>
		<td><bean:write name="obj" property="endtime" /></td>
		
	<%--<bean:write name="obj" property="trid"/>--%>
		<td><a href="ViewHalts.do?trid=<bean:write name='obj' property='trid'/>">Halts</a></td>
		<td><a href="EditTrip.do?trid=<bean:write name='obj' property='trid' />"><bean:message key="edit"/></a>
		<a href="DeleteTrip.do?trid=<bean:write name='obj' property='trid' />"><bean:message key="delete"/></a></td>
		</tr>
		</logic:iterate>
		</table>
		</logic:notEmpty>
		<logic:empty name="obj" scope="session">
			No Trips available for this Bus<br/>
			<a href="addNewTrip.do?busno=<%=request.getParameter("busno")%>">Add New</a> Trip for this Bus
		</logic:empty>
		</center>
	</body>
</html>
