import java.util.Objects;
import java.util.UUID;

public class SBIUser implements BankInterface{
    //attributes
    private String name;
    private String accountsNo;
    private double balance;
    private String password;
    private static double rateOfInterest;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountsNo() {
        return accountsNo;
    }

    public void setAccountsNo(String accountsNo) {
        this.accountsNo = accountsNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static double getRateOfInterest() {
        return rateOfInterest;
    }

    public static void setRateOfInterest(double rateOfInterest) {
        SBIUser.rateOfInterest = rateOfInterest;
    }

    public SBIUser(String name, double balance, String password) {
        this.name = name;
        this.balance = balance;
        this.password = password;
        this.rateOfInterest = 6.5;
        this.accountsNo = String.valueOf(UUID.randomUUID());
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    @Override
    public String addMoney(int amount) {
        balance = balance+amount;
        return "Your new balance is: "+balance;
    }

    @Override
    public String withdrawMoney(int amount, String enteredpassword) {
        if(Objects.equals(password, enteredpassword)){
            if(amount>balance){
                return "Insufficient Balance";
            }else{
                balance = balance-amount;
                return "Your current balance is: "+balance;
            }
        }else{
            return "Wrong Password";
        }
    }

    @Override
    public double calculateInterest(int years) {
        return (rateOfInterest*balance)/years;
    }
}
