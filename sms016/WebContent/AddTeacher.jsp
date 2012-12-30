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
function fun(num) {
	document.getElementById("val").value=num;
	document.myform.submit();
}
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
					<li><a href="TeacherTable.jsp" class="nav_workshops navigationpref"><br />Workshops
					</a></li>
					<li><a href="#" class="nav_sports navigationpref"><br />Sports
					</a></li>
					<li><a href="#" class="nav_contact navigationpref"><br />Contact
					</a></li>
				</ul>
			</div>
		</div>
		<div id="middle">
			<form action="AddTController">
				<div id="left">
					<br/><br/><br/>
					<table>
					<tr>
					<td>TEACHER ID :</td>
					<td><input type="text" name="tid" id="tid"><br/></td>
					</tr>
					<tr>
		 			<td>TEACHER NAME :</td>
		 			<td><input type="text" name="tname" id="tname"><br/></td>
					</tr>
					<tr>
					<!-- <td><p:TeacherTable></p:TeacherTable></td> !-->
					</tr>
					<tr>
					<td><p:Button name="AddTeacher" type="button" value="AddTeacher" onclick="fun(1)" /></td>
					</tr>
					</table>
					<input type="hidden" name="val" id="val">
				</div>
				<div id="right">
					<table>
					<tr>
					<td>Column Name :</td>
					<td><input type="text" name="cname" id="cname"/></td>
					</tr>				
					<tr>
					<td>Datatype :</td>
					<td>
					<select name="datatype">
						<option value="int">number</option>
						<option value="char">character</option>
						<option value="date">date</option>
					</select>
					</td>
					</tr>
					<tr>
					<td><p:Button name="AddDetail" type="button" value="AddDetail" onclick="fun(2)" /></td>
					</tr>
					</table>
				</div>
			</form>
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