<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<h2> DODAWANIE NOWEGO WYDAWCE </h2>

<form:form method="post"
           modelAttribute="publisher">

    <form:hidden path="id"/> <br />
    Imię: <form:input path="name" /> <br />
    <form:errors path="name" /> <br />

    NIP: <form:input path="nip" /> <br />
    <form:errors path="nip" /> <br />

    REGON: <form:input path="regon" /> <br />
    <form:errors path="regon" /> <br />

    <br />
    <input type="submit" value="Wyślij" />

</form:form>