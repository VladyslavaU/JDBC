package account;

import java.sql.*;

public class AccountDAO {

    public void save(Account account) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("insert into account (first_name,last_name, email, balance) values(?,?,?.?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, account.getFirstName());
            statement.setString(2, account.getLastName());
            statement.setString(3, account.getEmail());
            statement.setInt(4, account.getBalance());

            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Account findByEmail(String email) {
        Account account = new Account();
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from account where email=?");
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                account.setId(rs.getInt(1));
                account.setFirstName(rs.getString(2));
                account.setLastName(rs.getString(3));
                account.setEmail(rs.getString(4));
                account.setBalance(rs.getInt(5));
            }
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return account;
    }
}
