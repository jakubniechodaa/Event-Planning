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

<h4>add venue</h4>
<table>
<form:form method="post" modelAttribute="venue" action="/venue/added">
    <tr>
        <td>name:</td><td><form:input path="name" /></td>
        <form:errors path="name" cssStyle="color: red" element="td"/>
    </tr>
    <tr>
        <td>capacity:</td><td><form:input type="number" path="capacity" /></td>
        <form:errors path="capacity" cssStyle="color: red" element="td"/>
    </tr>
    <tr>
        <td>city:</td><td><form:select itemLabel="name" path="city"
                                        itemValue="id"  items="${cities}"/></td>
        <form:errors path="city" cssStyle="color: red" element="td"/>
    </tr>


    <tr><td><input type="submit" value="Save"></td></tr>
</form:form>
</table>
</br>
<h5>can't u find your city on the list? </h5><a href="/city/add"> click here </a>

</div>
<%@ include file="/WEB-INF/views/fragments/footer.jsp"  %>
</body>
</html>