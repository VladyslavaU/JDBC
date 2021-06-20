package advancedJDBC;

import java.sql.*;

public class BatchDao {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://95.67.63.220:5432/users", "postgres", "123123");
             PreparedStatement stmt = connection.prepareStatement("insert into person(first_name, last_name, age, email) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            String[] firstNames = new String[]{"John", "Mary", "James"};
            String[] lastNames = new String[]{"Smith", "Brown", "Black"};
            int[] ages = new int[]{30, 30, 30};
            String[] emails = new String[]{"john@smith", "mary@brown", "James@Black"};
            for (int i = 0; i < firstNames.length; i++) {
                stmt.setString(1, firstNames[i]);
                stmt.setString(2, lastNames[i]);
                stmt.setInt(3, ages[i]);
                stmt.setString(4, emails[i]);
                stmt.addBatch();
            }
            int[] executeBatch = stmt.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
