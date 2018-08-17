<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%@ include file="/WEB-INF/views/fragments/header.jsp"  %>

<div class="container">
    <h5>all venues</h5>
<table>
    <th>name</th>  <th>city</th>  <th>events</th><ul>
<c:forEach items="${venues}" var="ven">
    <tr>
        <td>${ven.name}</td><td><li>${ven.city}</li></td><td><a href="/event/all/${ven.id}">click</a></td>
    </tr>
</c:forEach>
</ul>
</table>

</div>



<%@ include file="/WEB-INF/views/fragments/footer.jsp"  %>
</body>
</html>