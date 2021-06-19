package customtags;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
        request.getParameter("email");
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
