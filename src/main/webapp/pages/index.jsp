<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body>
<h2>Hello World!</h2>
    <h3>${msg}</h3>
<c:forEach var="name" items="${names}">
    ${name}
</c:forEach>
<c:forEach var="book" items="${books}">
    ${book.isbn}
</c:forEach>
</body>
</html>
