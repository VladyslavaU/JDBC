package account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {

    public void save(Account account) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("insert into account (first_name,last_name, email) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, account.getFirstName());
            statement.setString(2, account.getLastName());
            statement.setString(3, account.getEmail());

            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Account> findByNames(String firstName, String lastName) {
        ArrayList<Account> accounts = new ArrayList<>();
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from account where first_name=? and last_name=?");
            statement.setString(1, firstName);
            statement.setString(2,lastName);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt(1));
                account.setFirstName(rs.getString(2));
                account.setLastName(rs.getString(3));
                account.setEmail(rs.getString(4));
                account.setBalance(rs.getInt(5));
                accounts.add(account);
            }
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return accounts;
    }
}
