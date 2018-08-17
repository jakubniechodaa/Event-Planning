<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>

<body>
<%@ include file="/WEB-INF/views/fragments/header.jsp"  %>
<div class="container">

     <%--NIE ZAZNACZA SELECTOW MOZLIWE ZE PRZEZ CONVVERTER, TRZEBA ZAREJESTROWAC W SPRINGBOOCIE--%>
<table>
<form:form method="post" modelAttribute="event" action="/admin/eventedited/">
    <tr>
        <td>name:</td><td><form:input path="name" /></td>
        <form:errors path="name" cssStyle="color: red" element="td"/>
    </tr>

    <tr>
        <td>artists:</td><td><form:select itemLabel="name" path="artists"
                                        itemValue="id"  items="${artists}"/></td>
        <form:errors path="artists" cssStyle="color: red" element="td"/>
    </tr>

    <tr>
        <td>venue:</td><td><form:select itemLabel="name" path="venue"
                                        itemValue="id" value="${event.getVenue()}" >
        <form:options items="${venues}" itemLabel="name" itemValue="id"/></form:select></td>
        <form:errors path="venue" cssStyle="color: red" element="td"/>
    </tr>

    <tr>
        <td>type:</td><td><form:select itemLabel="name" path="type"
                                       itemValue="id"  items="${types}"/></td>
        <form:errors path="type" cssStyle="color: red" element="td"/>
    </tr>

    <tr>
        <td>genres:</td><td><form:select itemLabel="name" path="genres"
                                         itemValue="id"  items="${genres}"/></td>
        <form:errors path="genres" cssStyle="color: red" element="td"/>
    </tr>

    <tr>
        <td>date:</td><td><form:input type="date" path="date" name="date" /></td>
        <form:errors path="date" cssStyle="color: red" element="td"/>
    </tr>
        <form:hidden path="id" />

    <tr><td><input type="submit" value="Save"></td></tr>
</form:form>
</table>
</div>
<%@ include file="/WEB-INF/views/fragments/footer.jsp"  %>
</body>
</html>