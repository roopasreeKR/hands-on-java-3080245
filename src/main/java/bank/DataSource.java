package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataSource {

  public static Connection connect() {
    String db_file = "jdbc:sqlite:resources/bank.db";
    Connection connection = null;

    // Load the SQLite JDBC driver (optional)
    try {
      Class.forName("org.sqlite.JDBC");
    } catch (ClassNotFoundException e) {
      System.out.println("SQLite JDBC Driver not found!");
      e.printStackTrace();
    }

    try {
      connection = DriverManager.getConnection(db_file);
      System.out.println("we are connected");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return connection;
  }

  public static Customer getCustomer(String userName) {
    String sql = "select * from customers where username = ?";
    Customer customer = null;
    try (Connection connection = connect();
        PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setString(1, userName);
      try (ResultSet resultset = statement.executeQuery()) {
        customer = new Customer(resultset.getInt("id"),
            resultset.getString("name"),
            resultset.getString("userName"),
            resultset.getString("password"),
            resultset.getInt("account_id"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return customer;
  }

  public static Accounts getAccounts(int id) {
    String sql = "select * from Accounts where ID = ?";

    Accounts accounts = null;
    try (Connection connect = connect();
        PreparedStatement statement = connect.prepareStatement(sql)) {
      statement.setInt(1, id);
      try (ResultSet resultset = statement.executeQuery()) {
        accounts = new Accounts(resultset.getInt("id"),
            resultset.getString("type"),
            resultset.getDouble("balance"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return accounts;
  }

  public static void updateAccountBalance(int accountID, double balance) {
    String sql = "update accounts set balance = ? where id = ?";
    try (Connection connect = connect();
        PreparedStatement statement = connect.prepareStatement(sql);) {
      statement.setDouble(1, balance);
      statement.setInt(2, accountID);
      statement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  /*
   * public static void main(String args[]) {
   * Customer customer = getCustomer("ojamblinbx@ycombinator.com");
   * System.out.println(customer.getName());
   * Accounts account = getAccounts(10385);
   * System.out.println(account.getBalance());
   * }
   */

}
