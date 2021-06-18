package servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/ReadUsersServlet")

public class ReadUsersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Connection connection;

    public void init(ServletConfig config) {
        try {
            ServletContext context = config.getServletContext();
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    context.getInitParameter("dbUrl"),
                    context.getInitParameter("dbUser"),
                    context.getInitParameter("dbPassword"));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from person");
            PrintWriter out = response.getWriter();
            out.print("<table>");
            out.print("<tr>");
            out.print("<th>");
            out.println("First Name");
            out.print("</th>");
            out.print("<th>");
            out.println("Last Name");
            out.print("</th>");
            out.print("<th>");
            out.println("Age");
            out.print("</th>");
            out.print("<th>");
            out.println("Email");
            out.print("</th>");
            out.print("</tr>");
            while(resultSet.next()){
                out.println("<tr>");
                out.println("<td>");
                out.print(resultSet.getString(2));
                out.println("</td>");
                out.println("<td>");
                out.print(resultSet.getString(3));
                out.println("</td>");
                out.println("<td>");
                out.print(resultSet.getString(4));
                out.println("</td>");
                out.println("<td>");
                out.print(resultSet.getString(5));
                out.println("</td>");
                out.println("</tr>");
            }
            out.print("</table>");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void destroy() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


