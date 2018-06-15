<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <td>isbn</td>
            <td>书名</td>
            <td>价格</td>
            <td>出版社</td>
            <td>出版日期</td>
            <td>分类</td>
        </tr>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.isbn}</td>
                <td>${book.bookName}</td>
                <td>${book.price}</td>
                <td>${book.publisher}</td>
                <td>${book.publishDate}</td>
                <td>${book.categoryId}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
