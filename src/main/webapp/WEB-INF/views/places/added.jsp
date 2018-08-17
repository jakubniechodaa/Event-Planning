<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>

<body>
<%@ include file="/WEB-INF/views/fragments/header.jsp"  %>

<div>You added venue! ${venue.name}, ${venue.city.name}, capacity: ${venue.capacity}</div>

<%@ include file="/WEB-INF/views/fragments/footer.jsp"  %>
</body>
</html>