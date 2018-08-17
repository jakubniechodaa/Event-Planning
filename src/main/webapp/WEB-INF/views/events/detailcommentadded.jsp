<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<body>
<%@ include file="/WEB-INF/views/fragments/header.jsp"  %>
<div class="container">
<div style="display: inline-block">
    <table>
    <th>artists</th>
    <%--${event}--%>
    <c:forEach items="${eventArtists}" var="art">
        <tr>
            <td>${art.name}</td>
        </tr>
    </c:forEach>

</table>
</div>
<div>
    <table>
        <th>genres</th>
        <%--${event}--%>
        <c:forEach items="${eventGenres}" var="gnr">
            <tr>
                <td>${gnr.name}</td>
            </tr>
        </c:forEach>

    </table>
    <table>
        <th>- club- </th> <th> - city -</th>


        <tr>
            <td>- ${eventVenue.name} -</td><td>- ${city} -</td>
        </tr>


    </table>

</div>
<div> <h5>comment:</h5>
    <table>
        <form:form method="post" modelAttribute="comment" action="/event/details/${event.id}/addedcomments">
            <tr>
                <td>content:</td><td><form:input path="content" /></td>
                <form:errors path="content" cssStyle="color: red" element="td"/>
            </tr>
            <tr>
                <td>name:</td><td><form:input path="user" /></td>
                <form:errors path="user" cssStyle="color: red" element="td"/>
            </tr>
            <form:hidden path="event" value="${event.id}" itemLabel="id"></form:hidden>
            <tr><td><input type="submit" value="Save"></td></tr>
        </form:form>
    </table>
    <div>you added comment! <a href="/event/details/${event.id}/comments">refresh</a></div>


</div>

</div>
<%@ include file="/WEB-INF/views/fragments/footer.jsp"  %>
</body>