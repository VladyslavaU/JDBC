<%--
  Created by IntelliJ IDEA.
  User: vuvar
  Date: 6/20/2021
  Time: 7:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find Account</title>
    <form action="account" method="post">
        <pre>
            First Name: <input type="text" name="firstName"/>
            Last Name: <input type="text" name="lastName"/>
            <input type="hidden" name="action" value="find"/>
            <input type="submit" name="find">
        </pre>
    </form>
</head>
<body>

</body>
</html>
