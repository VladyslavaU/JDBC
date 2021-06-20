package customtags;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.sql.*;

public class ResultHandler extends TagSupport {

    Connection connection;
    PreparedStatement preparedStatement;

    public ResultHandler() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://95.67.63.220:5432/users", "postgres", "123123");
            preparedStatement = connection.prepareStatement("select * from person where email=?");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int doStartTag(){
        ServletRequest request = pageContext.getRequest();
        String email = request.getParameter("email");
        try {
            preparedStatement.setString(1,email);
            ResultSet rs = preparedStatement.executeQuery();
            JspWriter out = pageContext.getOut();

            if (rs.next()){
                out.print("User Details are:<br/> First Name:");
                out.print(rs.getString(1));
                out.print("User Details are:<br/> Last Name:");
                out.print(rs.getString(2));
            } else {
                out.print("User not found");
            }
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return Tag.SKIP_BODY;
    }

        @Override
        public void release () {
            try{
                preparedStatement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
