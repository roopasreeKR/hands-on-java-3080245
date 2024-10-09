package bank;

import bank.Exceptions.AmountException;

public class Accounts {

  private int ID;
  private String type;
  private double balance;

  public Accounts(int ID, String type, double balance) {
    setID(ID);
    setType(type);
    setBalance(balance);
  }

  public int getID() {
    return this.ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public double getBalance() {
    return this.balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public void deposite(double amount) throws AmountException {
    if (amount < 1) {
      throw new AmountException("The minimum deposite is one");
    } else {
      double newBalance = balance + amount;
      setBalance(newBalance);
      DataSource.updateAccountBalance(ID, newBalance);
    }

  }

  public void withdraw(double amount) throws AmountException {
    if(amount<0){
      throw new AmountException(("withdraw amount must be greater than zero"));
    }else if(amount > getBalance()){
      throw new AmountException("u do not have sufficient balance");
    }else{
      double newBalance = balance - amount;
      setBalance(newBalance);
      DataSource.updateAccountBalance(ID, newBalance);

    }

  }

}
