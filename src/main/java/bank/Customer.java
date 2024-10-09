package bank;

public class Customer {

  private int ID;
  private String name;
  private String userName;
  private String password;
  private int accountID;
  private boolean authenticated;

  public Customer(int ID, String name, String userName, String password, int accountID) {
    setID(ID);
    setName(name);
    setUserName(userName);
    setPassword(password);
    setAccountID(accountID);
    setAuthenticated(false);

  }

  public int getID() {
    return this.ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getAccountID() {
    return this.accountID;
  }

  public void setAccountID(int accountID) {
    this.accountID = accountID;
  }

  public boolean isAuthenticated() {
    return this.authenticated;
  }

  public boolean getAuthenticated() {
    return this.authenticated;
  }

  public void setAuthenticated(boolean authenticated) {
    this.authenticated = authenticated;
  }


}
