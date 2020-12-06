<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    answer {
        color: azure;
        background-color: blueviolet;
        margin: 1px;
    }
</style>

<form:form modelAttribute="student">

    First name:
    <answer>
            ${student.firstName}
    </answer>
    <br />

    Last name:
    <answer>
            ${student.lastName}
    </answer>
    <br />

    Gender:
    <answer>
            ${student.gender}
    </answer>
    <br />

    Country:
    <answer>
            ${student.country}
    </answer>
    <br />

    Notes:
    <form:textarea path="notes" cols="20" rows="3" disabled="true" />
    <br />

    Mailing list:
    <answer>
            ${student.mailingList}
    </answer>
    <br />

    Programming skills:
    <br />
    <answer>
        <c:forEach items="${student.programmingSkills}" var="skill">
            ${skill}<br/>
        </c:forEach>
    </answer>
    <br />

    Hobbies:
    <br />
    <answer>
        <c:forEach items="${student.hobbies}" var="hobby">
            ${hobby}<br/>
        </c:forEach>
    </answer>

</form:form>