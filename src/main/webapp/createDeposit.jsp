<%--
  Created by IntelliJ IDEA.
  User: vuvar
  Date: 6/20/2021
  Time: 7:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Deposit</title>
</head>
<body>
<h1>Create Deposit</h1>
<form action="deposit" method="post">
    <pre>
      Deposit amount: <label>
<input type="text" name="amount"/>
</label>
      Email of receiver: <label>
<input type="text" name="email"/>
</label>
      <input type="submit" value="Save">
    </pre>
</form>
</body>
</html>
