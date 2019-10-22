<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@include file="taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
div{
margin-left: 300px;
margin-right: 100px
}</style>
</head>
<body>
<h1 align="center">Offer Letter</h1>
<form method="post" action="approve" >
<table>
<tr>
<th>Offer Letter</th>
</tr>
<c:forEach items="${applicantModelList}" var="applicantmodel">
<tr>
<td><c:out value="${applicantmodel.getFile_data()}"/></td>
</tr>
</c:forEach>

</table>
</br>
</br>
<div>
             
</form>
</div>
</body>
</html>