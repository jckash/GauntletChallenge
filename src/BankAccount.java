import java.util.Random;

public class BankAccount {

    private double checkingBalance;
    private double savingsBalance;
    private String accountNumber;

    private static int numberOfAccounts = 0;
    private static double totalAmount = 0;

    public BankAccount(double initialCheckingBalance, double initialSavingsBalance ){
        this.checkingBalance = initialCheckingBalance;
        this.savingsBalance = initialSavingsBalance;
        this.accountNumber = getAccountNumber();

        numberOfAccounts++;
        totalAmount += initialCheckingBalance + initialSavingsBalance;
    }


    public double getCheckingBalance(){
        return checkingBalance;
    }

    public double getSavingsBalance(){
        return savingsBalance;
    }

    public void deposit(double amount, String accountType){
        if ("checking".equalsIgnoreCase(accountType)){
            checkingBalance += amount;
        } else if ("savings".equalsIgnoreCase(accountType)){
            savingsBalance += amount;
        }
        totalAmount += amount;
    }

    public void withdraw(double amount, String accountType) {
        if("checking".equalsIgnoreCase(accountType) && checkingBalance >= amount) {
            checkingBalance -= amount;
            totalAmount -= amount;
        } else if ("savings".equalsIgnoreCase(accountType) && savingsBalance >= amount) {
            savingsBalance -= amount;
            totalAmount -= amount;

        } else {
            System.out.println("Insufficient funds");
        }
    }

    public double getTotalAmount(){
        return totalAmount;
    }

    private String getAccountNumber() {
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            int digit = random.nextInt(10);
            accountNumber.append(digit);
        }

        return accountNumber.toString();
    }

    public static int getNumberOfAccounts(){
        return numberOfAccounts;
    }
}
