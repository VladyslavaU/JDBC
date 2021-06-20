package account;

import java.sql.*;

public class DepositDAO {

    public void save(Deposit deposit) {
        Connection connection = ConnectionUtil.getConnection();
        try{
            PreparedStatement statement = connection.prepareStatement("insert into deposit (amount,email) values(?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, deposit.getDeposit());
            statement.setString(2, deposit.getEmail());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
