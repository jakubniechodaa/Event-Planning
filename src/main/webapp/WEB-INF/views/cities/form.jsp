<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>

<body>
<%@ include file="/WEB-INF/views/fragments/header.jsp"  %>

<h4>add city</h4>
<table>
    <form:form method="post" modelAttribute="city" action="/city/added">
        <tr>
            <td>name:</td><td><form:input path="name" /></td>
            <form:errors path="name" cssStyle="color: red" element="td"/>
        </tr>
        <tr><td><input type="submit" value="Save"></td></tr>
    </form:form>
</table>

<%@ include file="/WEB-INF/views/fragments/footer.jsp"  %>
</body>
</html>