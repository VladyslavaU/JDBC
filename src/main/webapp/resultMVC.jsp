<%--
  Created by IntelliJ IDEA.
  User: vuvar
  Date: 6/19/2021
  Time: 9:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
    <title>Result</title>
</head>
<body>
<%
    int result = (Integer) request.getAttribute("result");
    out.print("<b> The Average is: " + result + "</b>");
%>
</body>
</html>
