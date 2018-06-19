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
                <td colspan="3" style="font-style: 32px;text-align: center;">分类列表页面</td>
            </tr>
            </thead>
            <tr>
                <td colspan="3" style="font-style: 20px;text-align: center;">
                    <a href="<%=basePath%>pages/addcategory.jsp">新增分类</a>
                </td>
            </tr>
            <thead>
                <tr>
                    <td>id</td>
                    <td>分类名称</td>
                    <td>操作</td>
                </tr>
            </thead>
            <c:forEach items="${categories}" var="category">
                <tr>
                    <td>${category.id}</td>
                    <td>${category.name}</td>
                    <td><a href="category/update.action?id=${category.id}">修改</a>
                        <a href="javascript:deleteCategory('${category.id}','${category.name}');" >删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
<script type="text/javascript">
    function deleteCategory(id,name){
        if(confirm("确认删除《"+name+"》？")){
            location.href="category/del.action?id="+id;
        }
    }
</script>
</html>
