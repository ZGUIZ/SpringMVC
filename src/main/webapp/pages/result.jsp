<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/6/19
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    //使用base标签解决网站的相对路径问题
    //网站下载路径
    String basePath=request.getContextPath()+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${result}">
    操作成功！
</c:if>
<p id="timep">还有3秒跳转</p>
<a href="<%=basePath%>${url}">点此跳转</a>
</body>
<
<script type="text/javascript">
    var lasttime=3;
    var handle=window.setInterval("setTimeDisplay(--lasttime)",1000);

    function setTimeDisplay(time) {
        if(time<=0){
            window.clearInterval(handle);
            window.location.href="http://"+window.location.host+"/book/listbypager";
        }
        var p=document.getElementById("timep");
        p.innerHTML="还有"+lasttime+"秒跳转";
    }

</script>
</html>
