<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    //使用base标签解决网站的相对路径问题
    //网站下载路径
    String basePath=request.getContextPath()+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>书籍列表页面</title>
    <base href="<%=basePath%>">
    <style type="text/css">
        .box1{
            width: 80%;
            position: relative;
            left: 50%;
            margin-left: -40%;
            margin-top: 2%;
        }
        td{
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="box1">
        <table align="center" class="table table-striped table-hover table-bordered">
            <thead>
            <tr>
                <td colspan="7" style="font-style: 32px;text-align: center;">书籍列表页面</td>
            </tr>
            </thead>
            <tr>
                <td colspan="7" style="font-style: 20px;text-align: center;">
                    <a href="book/add.action">新增书籍</a>
                </td>
            </tr>
            <thead>
                <tr>
                    <td>isbn</td>
                    <td>书名</td>
                    <td>价格</td>
                    <td>出版社</td>
                    <td>出版日期</td>
                    <td>分类</td>
                    <td>操作</td>
                </tr>
            </thead>
            <c:forEach items="${books}" var="book">
                <tr>
                    <td>${book.isbn}</td>
                    <td>${book.bookName}</td>
                    <td>${book.price}</td>
                    <td>${book.publisher}</td>
                    <td>${book.publishDate}</td>
                    <td>${book.category.name}</td>
                    <td><a href="book/update.action?isbn=${book.isbn}">修改</a>
                        <a href="javascript:deleteBook('${book.isbn}','${book.bookName}');" >删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
<script type="text/javascript">
    function deleteBook(isbn,name){
        if(confirm("确认删除《"+name+"》？")){
            location.href="book/del.action?isbn="+isbn;
        }
    }
</script>
</html>
