<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<h2> Czy chcesz usunąć wydawce ${publisher.name} ??</h2>

<input type="hidden" name="toRemoveId" value="${publisher.id}">

<form:form method="post"
           modelAttribute="publisher">
    <form:hidden path="id" />
    <button type="submit" value="yes" name="confirmed">TAK</button>
    <button type="submit" value="no" name="confirmed">NIE</button>
</form:form>