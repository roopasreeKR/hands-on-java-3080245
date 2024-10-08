package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

  public static Connection connect(){
   String db_file = "jdbc:sqllite:resources/bank.db";
   Connection connection = null;
   try{
   connection = DriverManager.getConnection(db_file);
   System.out.println("we are connected");
   }catch(SQLException e){
     e.printStackTrace();
   }
   return connection;
  }

  public static void main(String args[]){
    connect();
  }




}
