<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%@ include file="/WEB-INF/views/fragments/header.jsp"  %>

<div class="container">
    <h5>upcomming events(${futureEvents.size()})</h5>
<table>
    <th>name</th>  <th>date</th>  <th>edit</th> <th>delete</th>
<c:forEach items="${futureEvents}" var="ev" begin="0">
    <tr>
        <td>${ev.name}</td><td>${ev.date}</td><td><a href="/admin/eventedit/${ev.id}">click</a></td><td><a href="/admin/eventdelete/${ev.id}">click</a></td>
    </tr>
</c:forEach>
</table>

</div>

<%@ include file="/WEB-INF/views/fragments/footer.jsp"  %>
</body>
</html>