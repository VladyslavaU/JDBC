<%--
  Created by IntelliJ IDEA.
  User: vuvar
  Date: 6/19/2021
  Time: 8:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person Details</title>
</head>

<jsp:useBean id="person" class="jsp.Person">
    <jsp:setProperty name="person" property="*"/>
</jsp:useBean>

Person Details<br/>

First Name:
<jsp:getProperty property="firstName" name="person"/>
<br/>
Last Name:
<jsp:getProperty property="lastName" name="person"/>
<br/>
Age:
<jsp:getProperty property="age" name="person"/>
<br/>
Email:
<jsp:getProperty property="email" name="person"/>
<br/>


</body>
</html>
