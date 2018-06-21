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
    <link href="css/style.css" rel="stylesheet">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
    <form action="<%=basePath%>book/doadd.action" enctype="multipart/form-data" method="post">
        <table align="center" width="500">
            <th>
                <tr>
                    <td colspan="2"><p class="title">新增书籍</p></td>
                </tr>
            </th>
            <tr>
                <td><p>出版号：</p></td>
                <td><input name="isbn" type="text" id="isbn"/></td>
                <td><p id="errormessage" class="errmsg"></p></td>
            </tr>
            <tr>
                <td><p>书籍名称：</p></td>
                <td><input name="bookName" type="text"/></td>
            </tr>
            <tr>
                <td><p>价格：</p></td>
                <td><input name="price" type="text"/></td>
            </tr>
            <tr>
                <td><p>出版社：</p></td>
                <td><input name="publisher" type="text"/></td>
            </tr>
            <tr>
                <td><p>出版时间：</p></td>
                <td>
                    <%--<input name="publishDate" type="text" value="<%=date%>"/>--%>
                    <input name="publishDate" type="date"/>
                </td>
            </tr>
            <tr>
                <td><p>封面图片：</p></td>
                <td><input name="bookIcon" type="file"/></td>
            </tr>
            <tr>
                <td><p>上架类型：</p></td>
                <td><select name="categoryId"  style="width: 175px;">
                    <c:forEach items="${categories}" var="category">
                        <option value="${category.id}">${category.name}</option>
                    </c:forEach>
                </select></td>
            </tr>
            <tr>
                <td><input type="reset" class="btn"/></td>
                <td><input type="submit" class="btn"/></td>
            </tr>
        </table>
        <c:if test="${errors!=null}">
            <c:forEach var="error" items="${errors}">
                <a>${error.defaultMessage}</a>
            </c:forEach>
        </c:if>
    </form>

</body>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script>
    var isbninput=$("#isbn");
    isbninput.blur(
        function () {
            var ib=isbninput.val();
            $.post("book/findbyisbn",{
                "isbn":ib
            },function (data) {
                var res=eval(data);
                if(res){
                    $("#errormessage").text("");
                } else{
                    $("#errormessage").text("该书籍已经存在！");
                }
            });
        }
    );
</script>
</html>
