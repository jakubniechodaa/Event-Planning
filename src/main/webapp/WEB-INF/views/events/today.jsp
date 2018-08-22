<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%@ include file="/WEB-INF/views/fragments/header.jsp"  %>

<div class="container">
    <h5>events today: ${today.size()}</h5>
<table>
    <th>name</th>  <th>date</th> <th>till</th>  <th>details</th>
<c:forEach items="${today}" var="td">
    <tr>
        <td>${td.name}</td><td>${td.date}</td><td>${td.till}</td><td><a href="/event/details/${td.id}">click</a></td>
    </tr>
</c:forEach>
</table>

</div>

<%@ include file="/WEB-INF/views/fragments/footer.jsp"  %>
</body>
</html>