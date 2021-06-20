package advancedJDBC;

import java.sql.*;

public class TransactionDAO {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://95.67.63.220:5432/users", "postgres", "123123");
            Statement stmt = connection.createStatement();
            connection.setAutoCommit(false);
            stmt.executeUpdate("update account set balance=balance-500 where id=1");
            stmt.executeUpdate("update account set balance=balance+500 where id=2");
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.close();
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}
