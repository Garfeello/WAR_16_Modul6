<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<h2> DODAWANIE NOWEGO AUTORA </h2>

<form:form method="post"
           modelAttribute="author">

    <form:hidden path="id"/> <br />
    Imię: <form:input path="firstName" /> <br />
    <form:errors path="firstName" /> <br />

    Nazwisko: <form:input path="lastName" /> <br />
    <form:errors path="lastName" /> <br />

    PESEL: <form:input path="pesel" /> <br />
    <form:errors path="pesel"/> <br />

    Email: <form:input path="email" />
    <form:errors path="email" /> <br />

    <br />
    <input type="submit" value="Wyślij" />

</form:form>