package org.example;

import org.example.payment.Account;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;

public class Tui {
    private Scanner scan;
    private ArrayList<Account> accounts;

    public Tui() {
        scan = new Scanner(System.in);
        accounts = new ArrayList<>();
    }

    public void run() {
        for(;;) {
            listAccounts();
            System.out.print("Konto Auswählen oder 0) für neues Konto: ");
            int zahl = scan.nextInt();
            if (zahl == 0) {
                createNewAccount();
            } else if (zahl > 0) {
                manageAccount(accounts.get(zahl-1));
            } else {
                System.out.println("ungültige Eingabe");
            }
        }
    }

    private void manageAccount(Account acc) {
        for(;;) {
            System.out.printf("Bearbeite Konto %s, Kontostand %f\n", acc.getName(), acc.getBalance());
            System.out.println("0) Zurück 1) Einzahlen 2) Abheben 3) Konto löschen");
            int zahl = scan.nextInt();
            switch (zahl) {
                case 0:
                    return;
                case 1:
                    depositToAccount(acc);
                    break;
                case 2:
                    withdrawFromAccount(acc);
                    break;
                case 3:
                    deleteAccount(acc);
                    return;
                default:
                    System.out.println("Unglültige Eingabe");
            }
        }
    }

    private void deleteAccount(Account acc) {
        System.out.printf("Lösche Konto %s\n", acc.getName());
        accounts.remove(acc);
    }

    private void withdrawFromAccount(Account acc) {
        System.out.printf("Konto %s, aktueller Stand: %f\n", acc.getName(), acc.getBalance());
        System.out.print("Auszuzahlender Betrag:");
        double amount = scan.nextDouble();
        acc.withdraw(amount);
        System.out.printf("Konto %s, neuer Stand: %f\n", acc.getName(), acc.getBalance());
    }

    private void depositToAccount(Account acc) {
        System.out.printf("Konto %s, aktueller Stand: %f\n", acc.getName(), acc.getBalance());
        System.out.print("Einzuzahlender Betrag:");
        double amount = scan.nextDouble();
        acc.deposit(amount);
        System.out.printf("Konto %s, neuer Stand: %f\n", acc.getName(), acc.getBalance());
    }

    private void listAccounts() {
        int nr = 1;
        for(Account acc : accounts) {
            System.out.printf("%d) %s %f\n", nr, acc.getName(), acc.getBalance());
            nr++;
        }
    }

    private void createNewAccount() {
        System.out.println("Neues Konto anlegen");
        System.out.print("Name: ");
        String name = scan.next();
        System.out.print("Betrag: ");
        Double amount = scan.nextDouble();
        accounts.add(new Account(name,amount));
    }
}
