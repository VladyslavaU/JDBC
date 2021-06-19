<%--
  Created by IntelliJ IDEA.
  User: vuvar
  Date: 6/19/2021
  Time: 6:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.*" contentType="text/html;charset=UTF-8" language="java" %>

<%!
    Connection con;
    PreparedStatement ps;

    public void jspInit() {
        try {
            Class.forName("org.postgresql.Driver");
            DriverManager.getConnection("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://95.67.63.220:5432/users", "postgres", "123123");
            ps = con.prepareStatement("insert into person(first_name, last_name, age, email) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
    public void jspDestroy() {
        try {
            ps.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
%>

<%
    String firstName = request.getParameter("firstname");
    String lastName = request.getParameter("lastname");
    int age = Integer.parseInt(request.getParameter("age"));
    String email = request.getParameter("email");

    try {
        ps.setString(1, firstName);
        ps.setString(2, lastName);
        ps.setInt(3, age);
        ps.setString(4, email);

        ps.executeUpdate();
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
%>

