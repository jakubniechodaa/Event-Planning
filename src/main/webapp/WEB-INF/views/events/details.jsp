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
<a href="/event/details/${event.id}/comments">comments</a>
</div>
</div>
<%@ include file="/WEB-INF/views/fragments/footer.jsp"  %>
</body>