<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<h2> DODAWANIE NOWEJ KSIĄŻKI </h2>

<form:form method="post"
           modelAttribute="book">

    <form:hidden path="id"/> <br />
    Tytul: <form:input path="title" /> <br />
    Ocena: <form:input path="rating" /> <br />
    Opis: <form:input path="description" /> <br />
    Wydawca: <form:select path="publisher.id" items="${allPublishers}"
                          itemLabel="name" itemValue="id" /> <br />
    Autorzy: <form:select path="authorList" items="${allAuthors}"
                          itemLabel="fullName" itemValue="id" multiple="true" />

    <br />
    <input type="submit" value="Wyślij" />

</form:form>