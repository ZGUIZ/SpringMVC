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
    <link href="css/style.css"/>
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
        <form id="findbycondition" class="form-search" action="<%=basePath%>book/listbypager.action" method="post">
            <table align="center" class="table">
                <tr>
                    <td><input type="text" placeholder="查询的isbn" name="book.isbn" value="${pager.book.isbn}" class="pagerinput input-medium search-query"/></td>
                    <td><input type="text" placeholder="查询的书名" name="book.bookName" value="${pager.book.bookName}" class="pagerinput input-medium search-query"/></td>
                    <%--<td><input type="text" placeholder="低于此价格" name="book.price" value="${pager.book.price}" class="pagerinput input-medium search-query"/></td>--%>
                    <td><input type="text" placeholder="出版社" name="book.publisher" value="${pager.book.publisher}" class="pagerinput input-medium search-query"/></td>
                    <%--<td><input type="date" name="book.publishDate" value="${pager.book.publishDate}" class="pagerinput"/></td>--%>
                    <td>
                        <select name="book.categoryId" style="width: 175px; height: 25px">
                            <option value="0"></option>
                            <c:forEach items="${categories}" var="category">
                                <option value="${category.id}" <c:if test="${category.id==pager.book.categoryId}">selected="selected"</c:if>>${category.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <input id="currentpage" name="currentPage" type="hidden" value="1" />
                    <td>
                        <button class="btn" type="submit">查找</button>
                    </td>
                </tr>
            </table>
        </form>
        <table id="datastable" align="center" class="table table-striped table-hover table-bordered">
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
            <tbody id="datasbody">
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
            </tbody>
        </table>
        <div align="right">
            <button class="btn btn-link" onclick="javascript:setPagerAndSubmit(${pager.prePage})">上一页</button>
            <button class="btn btn-link" onclick="javascript:setPagerAndSubmit(${pager.nextPage})">下一页</button>
        </div>
    </div>
</body>
<script type="text/javascript">
    function deleteBook(isbn,name){
        if(confirm("确认删除《"+name+"》？")){
            //location.href="book/delbyajax.action?isbn="+isbn;
            getDatas();
        }
    }
    function setPagerAndSubmit(num) {
        var pager=document.getElementById("currentpage");
        pager.value=num;
        document.getElementById("findbycondition").submit();
    }

    function getDatas() {
        $.get("/book/ajaxpager?page=${pager.currentPage}",function (data) {
            var datasbody=$("#datasbody");
            datasbody.empty();

            var res=jQuery.parseJSON(data);
            for(var i=0;i<res.length;i++){
                var newtr=document.createElement("tr");
                datasbody.append(newtr);
                var id=document.createElement("td");
                id.innerHTML=res[i].isbn;
                var name=document.createElement("td");
                name.innerHTML=res[i].bookName;
                var price=document.createElement("td");
                price.innerHTML=res[i].price;
                var publisher=document.createElement("td");
                publisher.innerHTML=res[i].publisher;
                var publishDate=document.createElement("td");
                publishDate.innerHTML=res[i].publishDate;
                var category=document.createElement("td");
                category.innerHTML=res[i].category.name;
                var fun=document.createElement("td");
                fun.innerHTML='<a href="book/update.action?isbn=${book.isbn}">修改</a>\n' +
                    '<a href="javascript:deleteBook(${book.isbn},${book.bookName});" >删除</a>';
                newtr.append(id);
                newtr.append(name);
                newtr.append(price);
                newtr.append(publisher);
                newtr.append(publishDate);
                newtr.append(fun);
            }
        });
    }

</script>
</html>
