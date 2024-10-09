package bank;

import java.util.Scanner;

import javax.security.auth.login.LoginException;

import bank.Exceptions.AmountException;

public class Menu {

  private Scanner scanner;

  public static void main(String args[]) {
    System.out.println("Hi ! Welcom to Glow bank international");
    Menu menu = new Menu();
    menu.scanner = new Scanner(System.in);
    Customer customer = menu.authenticateUser();
    if (customer != null) {
      Accounts account = DataSource.getAccounts(customer.getAccountID());
      menu.showMenu(customer, account);
    }

    menu.scanner.close();
  }

  private Customer authenticateUser() {
    System.out.println("please insert ur user name");
    String username = scanner.next();
    System.out.println("please insert ur password");
    String password = scanner.next();
    Customer customer = null;
    try {
      customer = Autneticator.login(username, password);
    } catch (LoginException e) {
      System.out.println("there was an error" + e.getMessage());
    }
    return customer;
  }

  private void showMenu(Customer customer, Accounts accounts) {
    int selection = 0;
    while (selection != 4 && customer.isAuthenticated()) {
      System.out.println("=========");
      System.out.println("please select one of the following option");
      System.out.println("1.Deposite");
      System.out.println("2.Withdraw");
      System.out.println("3.Checkbalance");
      System.out.println("4.exit");
      System.out.println("=========");

      selection = scanner.nextInt();
      double amount;
      switch (selection) {
        case 1:
          System.out.println("how much ulike to deposite");
          amount = scanner.nextDouble();
          try {
            accounts.deposite(amount);
          } catch (AmountException e) {
            System.out.println(e.getMessage());
            System.out.println("please try again");
          }
          break;
        case 2:
          System.out.println("How much would u like to withdraw");
          amount = scanner.nextDouble();
          try {
            accounts.withdraw(amount);
          } catch (AmountException e) {
            System.out.println(e.getMessage());
            System.out.println("please try again");
          }
          break;
        case 3:
          System.out.println("amount" + accounts.getBalance());
          break;
        case 4:
          Autneticator.logout(customer);
          System.out.println("Thanks");
          break;

        default:
          System.out.println("invalid option try again");
          break;
      }
    }
  }

}
