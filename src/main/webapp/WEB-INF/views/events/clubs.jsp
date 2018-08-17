<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%@ include file="/WEB-INF/views/fragments/header.jsp"  %>

<div class="container">
    <h5>this club events</h5>
<table>
    <th>name</th>  <th>date</th>  <th>type</th> <th>details</th>

<c:forEach items="${venueEvents}" var="cev">
    <tr>
        <td>${cev.name}</td><td>${cev.date}</td><td>${cev.type}</td><td><a href="/event/details/${cev.id}">click</a></td>
    </tr>
</c:forEach>
</table>

</div>



<%@ include file="/WEB-INF/views/fragments/footer.jsp"  %>
</body>
</html>