<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: vuvar
  Date: 6/20/2021
  Time: 10:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<p>
<head>
    <title>Cout Demo</title>
</head>
<p>
<c:out value="${10+9}"/>
<c:set var="testScore" value="${80}" scope="session"/>
<c:out value="${testScore}"/>
<c:if test="${testScore>=80}">
    <p>Your Score Is Awesome</p>
</c:if>

<c:choose>
    <c:when test="${testScore>80}">
        A Grade
    </c:when>
    <c:when test="${testScore>=60 && testScore<=80}">
        B Grade
    </c:when>
    <c:otherwise>
        C Grade
    </c:otherwise>
</c:choose>

<c:forEach var="i" begin="1" end="3">
    <c:out value="${i}"/>
</c:forEach>

<%
    List<String> studentNames = new ArrayList<>();
    studentNames.add("John");
    studentNames.add("Bob");
    studentNames.add("Mary");
    request.setAttribute("studentNames", studentNames);
%>
<c:forEach var="studentName" items="${studentNames}">
    <c:out value="${studentName}"/>
</c:forEach>
<c:remove var="testScore"/>
After Removal The Value Is: <c:out value="${testScore}"/>

<c:set var="accountBalance" value="123.456"/>
<fmt:parseNumber var="i" type="number" value="${accountBalance}"/>
<p>Amount is: <c:out value="${i}"/></p>

<c:set var="accountBalance" value="7777.4567"/>
<p>Formatted Number type currency: <fmt:formatNumber value="${accountBalance}" type="currency"/></p>
<p>Formatted Number type number, max franction digits 2 :<fmt:formatNumber value="${accountBalance}" type="number" maxFractionDigits="2"/></p>
<p>Formatted Number type number, max integer digits 3 :<fmt:formatNumber value="${accountBalance}" type="number" maxIntegerDigits="2"/></p>
<p>Formatted Number type percent :<fmt:formatNumber value="${accountBalance}" type="percent"/></p>
<p>Formatted Number type number, pattern ####.##: $:<fmt:formatNumber value="${accountBalance}" type="number" pattern="####.##$"/></p>

<c:set var="myDate" value="12-07-2019"/>
<fmt:parseDate var="parsedDate" value="${myDate}" pattern="dd-MM-yyyy"/>
<p>Parsed Date dd-MM-yyyy: <c:out value="${parsedDate}"/></p>
</body>
</html>
