package bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Account {
    private String name;
    private int balance;
    private long accNo;
    private static long gencnum = 2024071001;
    private int pin;
    private static Map<Long, Account> accountMap = new HashMap<>();

    public Account(String name) {
        this.name = name;
        this.accNo = gencnum;
        balance = 1000;
        gencnum++;
        System.out.print("Enter the four digit passowrd : ");
        while (true) {
            int pass = new Scanner(System.in).nextInt();
            if (pass >= 1000 && pass <= 9999) {
                pin = pass;
                break;
            } else {
                System.out.println("Enter the valid password");
            }
        }
    }

    public static void createAccount(String name) {
        Account account = new Account(name);
        accountMap.put(account.accNo, account);
        getDetails(account.accNo);
    }

    public static void verify(long accNo, int pin) {
        Account account = accountMap.get(accNo);
        if (account != null) {
            if (pin == account.pin) {
                AccountManipulatio(account);
            } else {
                System.out.println("Incorrect credentials");
            }
        }else {
            System.out.println("There is no account found");
        }
    }

    public static void getDetails(long accNo) {
        System.out.println("Your account created successfully !");
        System.out.println("Name : " + accountMap.get(accNo).name + "\nAccount Number : " + accNo);
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public static void deposit(int amnt, Account p) {
        p.setBalance( p.getBalance()+amnt);
        System.out.println("Your amount " + amnt + " deposited in your account successfully!");
        System.out.print("Current Balance: " + p.getBalance());
    }

    public static int withdraw(int amnt, Account p) {
        if (p.getBalance() > amnt) {
            p.setBalance(p.getBalance() - amnt);
            return amnt;
        }
        return 0;
    }

    public static void AccountManipulatio(Account p) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the option to process further more\n" +
                "1.Withdraw\n" +
                "2.Check Balance\n" +
                "3.Deposit\n");
        int ch = sc.nextInt();
        switch (ch) {
            case 1: {
                System.out.println("Enter the Amount : ");
                int amnt = sc.nextInt();
                if (withdraw(amnt, p) > 0) {
                    System.out.print("Rs " + amnt + " withdrawn succefully");
                    System.out.println("Current Balance = " + p.getBalance());
                }
                break;
            }
            case 2: {

                System.out.println("Current Balance: " + p.getBalance());
                break;
            }
            case 3: {
                System.out.print("Enter the amount : ");
                int amnt = sc.nextInt();
                deposit(amnt, p);
                break;
            }
            default: {
                System.out.println("Sorry you Entered the invalid option try again!");
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Choose correct option given below\n" +
                    "1.Already have a Account\n" +
                    "2.Register\n");
            int ch = sc.nextInt();
            switch (ch) {
                case 1: {
                    System.out.println("Enter the account number");
                    int accno = sc.nextInt();
                    System.out.println("Enter the account password");
                    int pin = sc.nextInt();
                    verify(accno, pin);
                    break;
                }
                case 2: {
                    System.out.print("Enter the name : ");
                    String name = sc.next();
                    createAccount(name);
                    break;
                }
                default:
                    System.out.println("Enter the valid option");
            }
        }
    }
}
