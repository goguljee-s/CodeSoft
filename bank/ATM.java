package bank;
import bank.Account;

import java.util.Scanner;

public class ATM {
    private  Account account;
    public ATM(Account account){
        this.account=account;
    }
    public static void main(String[] args) {
        Account.createAccount("Gogul");
        Account.createAccount("Gowri");
        Account.createAccount("kathir");
        Scanner sc=new Scanner(System.in);
    long accno;
    int pin;
        System.out.print("Enter your Account No : ");
        accno= sc.nextLong();
        System.out.print("Enter your Pin : ");
        pin=sc.nextInt();
        Account.verify(accno,pin);
    }
}
