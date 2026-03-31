package application;

import model.entities.Account;
import model.exceptions.BalanceException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter account data:");
            System.out.print("Number: ");
            int number = sc.nextInt();
            System.out.print("Holder: ");
            String holder = sc.next();
            sc.nextLine();
            System.out.print("Initial balance: ");
            double balance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();

            Account account = new Account(number, holder, balance, withdrawLimit);

            System.out.println();
            System.out.print("Enter amount to withdraw: ");
            double amount = sc.nextDouble();

            account.withdraw(amount);

            System.out.print("New balance: " + account.getBalance());
        }
        catch(InputMismatchException e){
            System.out.println("Invalid input!");
        }
        catch(BalanceException e){
            System.out.println("Erro na operação: " + e.getMessage());
        }


        sc.close();

    }

}
