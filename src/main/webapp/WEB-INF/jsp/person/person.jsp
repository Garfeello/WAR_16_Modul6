<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="post"
           modelAttribute="person">

    Login: <br />
    <form:input path="login" /> <br />

    Password: <br />
    <form:password path="password" /> <br />

    Email: <br />
    <form:input path="email"/> <br />

    <input type="submit" value="Zapisz!">

</form:form>

<%--<form method="post">

    Login: <br />
    <input type="text" name="login"> <br />

    Password: <br />
    <input type="password" name="password"> <br />

    Email: <br />
    <input type="text" name="email"> <br />

    <input type="submit" value="Zapisz!">

</form>--%>