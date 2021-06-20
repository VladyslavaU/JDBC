package advancedJDBC;

import java.sql.*;

public class MetaDataDAO {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://95.67.63.220:5432/users", "postgres", "123123");
             Statement stmt = connection.createStatement()) {

            ResultSet rs = stmt.executeQuery("select * from person");
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                System.out.println(resultSetMetaData.getColumnName(i));
                System.out.println(resultSetMetaData.getColumnTypeName(i));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
