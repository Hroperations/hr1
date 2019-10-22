<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@include file="taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
div {
 
  margin-top: 100px;
  margin-bottom: 200px;
  margin-right: 200px;
  margin-left: 300px;
  background-color: white;
}</style>
</head>
<body>
<h1 align="center">Application Status</h1>
<div>
<table>
<tr>
<th>Application Status</th>
</tr>
<c:forEach items="${applicantModelList}" var="applicantmodel">
<tr>
<td><c:out value="${applicantmodel.getApplicationStatus()}"/></td>
</tr>
</c:forEach>
</table>
<br>
<br>
<a href="ApplicantView.html">Go Back to Main View</a>
</div>
</body>
</html>