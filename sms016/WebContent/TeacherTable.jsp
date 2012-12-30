
<%@page import="com.sms.vo.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator" %>
<%@taglib prefix="p" uri="/WEB-INF/sms.tld"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="Styles/style1.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">

</script>
</head>
<body>
	<div id="page">
		<div id="header">
			<div id="logo" class="orangeaddress">
				<a href="#"> <img alt="School Logo" src="images/school_logo.jpg"
					style="border: 0pt none;">
				</a>
			</div>
			<div align="right"><a href="logout.jsp"> Logout </a></div>
			<div id="navigation">
				<ul>
					<li><a href="subjects.jsp" class="nav_home navigationpref"><br />ADMIN
					</a></li>
					<li><a href="AddTeacher.jsp" class="nav_about active navigationpref"><br />ADD TEACHERS
					</a></li>
					<li><a href="TeacherTable.jsp" class="nav_workshops navigationpref"><br />TEACHERS Table
					</a></li>
					<li><a href="#" class="nav_sports navigationpref"><br />Sports
					</a></li>
					<li><a href="#" class="nav_contact navigationpref"><br />Contact
					</a></li>
				</ul>
			</div>
		</div>
		<div id="middle">
	<div align="center">
		<form action="TeacherTableController">
		<br/><br/><br/>
		<table>
			<tr>
				<td> column name :</td>
				<td><input type="text" name="cname" id="cname"/></td>
			</tr>				
			<tr>
				<td>datatype :</td>
				<td>
				<select name="datatype">
					<option value="int">number</option>
					<option value="char">character</option>
					<option value="date">date</option>
				</select>
				</td>
			</tr>
			<tr>
			<td><input type="submit" name="Addcolumn" value="Add Column"/></td>
			</tr>
		</table>
		</form>
	</div>
	</div>
	</div>
	<div id="footer">
		<ul>
			<li><a href="#">ADMIN</a></li>
			<li>|</li>
			<li><a href="#">About</a></li>
			<li>|</li>
			<li><a href="#">Workshops</a></li>
			<li>|</li>
			<li><a href="#">Sports</a></li>
			<li>|</li>
			<li><a href="#">Contact</a></li>
		</ul>
		<div id="copyright">
			Copyright ©2012 Company name<br />
		</div>
		<div id="generalia">Address:</div>
	</div>
</body>
</html>