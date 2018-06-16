<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Amia
  Date: 2018/6/15
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    //使用base标签解决网站的相对路径问题
    //网站下载路径
    String basePath=request.getContextPath()+"/";
    Date date=new Date();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <title>新增书籍</title>
    <base href="<%=request.getContextPath()+"/"%>">
    <style type="text/css">
        p,select,input{
            margin-top: 10px;
        }
        .title{
            font-size: 32px;
            text-align: center;
        }
    </style>
</head>
<body>
    <form action="<%=basePath%>category/doupdate.action" method="post">
        <table align="center" width="500">
            <th>
                <tr>
                    <td colspan="2"><p class="title">更新书籍</p></td>
                </tr>
            </th>
            <tr>
                <td><p>编号：</p></td>
                <td><input type="text" value="${category.id}" disabled="disabled"/><input type="hidden" name="id" value="${category.id}"/></td>
            </tr>
            <tr>
                <td><p>名称：</p></td>
                <td><input name="name" type="text" value="${category.name}"/></td>
            </tr>
            <tr>
                <td><input type="reset" class="btn"/></td>
                <td><input type="submit" class="btn"/></td>
            </tr>
        </table>
    </form>
</body>

</html>
