<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>


<h2> Lista wszystkich książek </h2>

<a href="add">
    Dodaj nowa książke
</a>

<div>
    <form method="get">
        <label>
            Wybierz tryb wyszukiwarki
            <select name="searchMode">
                <option value="title">Po tytule</option>
                <option value="description">Po opisie</option>
                <option value="author">Po autorze</option>
            </select>
        </label>
        <br />
        <input type="text" name="query"/>
        <select name="searchAuthor">
            <c:forEach items="${allAuthors}" var="author">
                <option value="${author.id}">${author.fullName}</option>
            </c:forEach>
        </select>
        <br />
        <input type="submit" value="Szukaj">
    </form>
</div>

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