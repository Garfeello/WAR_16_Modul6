<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>


<h2> Lista wszystkich książek </h2>

<a href="add">
    Dodaj nowa książke
</a>

<c:forEach items="${allBooks}" var="book">
    <br />
    ------------------------------------
    <br />

    <h3>${book.title}</h3>
    <h5>${book.description}</h5>
    <h5>${book.rating}</h5>
    <h5>${book.publisher.name}</h5>

    <a href="edit?toEditId=${book.id}">
        Edytuj
    </a>
    <br />
    <a href="remove?toRemoveId=${book.id}">
        Usun
    </a>

    <br />
    ------------------------------------
    <br />
</c:forEach>