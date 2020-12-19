<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<h2> DODAWANIE NOWEJ KSIĄŻKI </h2>

<form:form method="post"
           modelAttribute="book">

    <form:hidden path="id"/> <br />
    Tytuł: <form:input path="title" /> <br />
    <form:errors path="title"/> <br />

    Ocena: <form:input path="rating" /> <br />
    <form:errors path="rating"/> <br />

    Opis: <form:input path="description" /> <br />
    <form:errors path="description" /> <br />

    Wydawca: <form:select path="publisher.id" items="${allPublishers}"
                          itemLabel="name" itemValue="id" /> <br />
    <form:errors path="publisher" /> <br />


    Autorzy: <form:select path="authorList" items="${allAuthors}"
                          itemLabel="fullName" itemValue="id" multiple="true" />
    <form:errors path="authorList"/> <br />

    Ilość stron: <form:input path="pages" /> <br />
    <form:errors path="pages"/> <br />

    <br />
    <input type="submit" value="Wyślij" />

</form:form>