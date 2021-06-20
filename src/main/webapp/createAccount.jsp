<%--
  Created by IntelliJ IDEA.
  User: vuvar
  Date: 6/20/2021
  Time: 7:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Account</title>
</head>
<body>
<h1>Create Account</h1>
<form action="account" method="post">
    <pre>
      First Name: <label>
<input type="text" name="firstName"/>
</label>
      Last Name: <label>
<input type="text" name="lastName"/>
</label>
        </label>
        Email: <label>
<input type="text" name="email"/>
</label>
        <input type="hidden" name="action" value="create"/>
      <input type="submit" value="Save">

    </pre>
</form>
</body>
</html>