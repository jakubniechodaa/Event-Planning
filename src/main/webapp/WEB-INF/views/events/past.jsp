<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%@ include file="/WEB-INF/views/fragments/header.jsp"  %>

<div class="container">
    <h5>past events(${pastEvents.size()})</h5>
<table>
    <th>name</th>  <th>date</th>  <th>details</th>
<c:forEach items="${pastEvents}" var="ev" begin="0" end="4">
    <tr>
        <td>${ev.name}</td><td>${ev.date}</td><td><a href="/event/details/${ev.id}">click</a></td>
    </tr>
</c:forEach>
</table>
    <%--<a href="/allupcomming">see all</a>--%>
</div>

<%@ include file="/WEB-INF/views/fragments/footer.jsp"  %>
</body>
</html>