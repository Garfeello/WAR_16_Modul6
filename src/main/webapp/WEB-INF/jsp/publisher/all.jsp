<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<h2> Lista wszystkich wydawców </h2>

<a href="add">
    Dodaj nowego wydawce
</a>


<div>
    <form method="get">
        <label>
            Wybierz tryb wyszukiwarki
            <select name="searchMode">
                <option value="name">Po nazwie</option>
                <option value="nip">Po NIP</option>
                <option value="regon">Po REGON</option>
            </select>
        </label>
        <br />
        <input type="text" name="query"/>
        <br />
        <input type="submit" value="Szukaj">
    </form>
</div>

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