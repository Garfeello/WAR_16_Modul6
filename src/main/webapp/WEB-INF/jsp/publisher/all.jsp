<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<h2> Lista wszystkich wydawców </h2>

<a href="add">
    Dodaj nowego wydawce
</a>

<c:forEach items="${allPublishers}" var="publisher">
    <br />
    ------------------------------------
    <br />

    <h3>${publisher.name}</h3>

    <a href="edit?toEditId=${publisher.id}">
        Edytuj
    </a>
    <br />
    <a href="remove?toRemoveId=${publisher.id}">
        Usun
    </a>

    <br />
    ------------------------------------
    <br />
</c:forEach>