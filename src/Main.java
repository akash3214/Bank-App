import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name, password, balance to create an account");

        //create user
        String name = sc.nextLine();
        String password = sc.nextLine();
        double balance = sc.nextDouble();
        SBIUser user = new SBIUser(name, balance, password);

        //add amount
        String message = user.addMoney(100000);
        System.out.println(message);

        //withdraw money
        System.out.println("Enter amount you want to withdraw");
        int money = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your password");
        String pass = sc.nextLine();
        System.out.println(user.withdrawMoney(money, pass));

        //calculate interest
        System.out.println("Rate of Interest: "+user.calculateInterest(10));
    }
}