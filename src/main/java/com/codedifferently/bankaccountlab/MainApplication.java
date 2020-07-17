package com.codedifferently.bankaccountlab;

import javax.sql.rowset.serial.SQLInputImpl;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class MainApplication {

    private static final Scanner scan = new Scanner(System.in);
    private static final Logger logger = Logger.getGlobal();
    private static ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
    private static BankAccount currentAcc;
    private static boolean end = false;

    public static void main(String [] args){
        do {
            menu();
        }while(!end);

        logger.info("Thanks for using this ATM.");
    }

    public static BankAccount selectAccount(){
        try {
            logger.info("Type Account Number:");
            int acc = scan.nextInt();
            for (BankAccount a : accounts) {
                if (a.getAccountNumber() == acc) {
                    currentAcc = a;
                }
            }
            if (!safeLock()) {
                currentAcc = null;
            }
            else{
                currentAcc.unlock();
            }
            return currentAcc;
        }catch(InputMismatchException e){
            logger.info("Wrong input");
            return null;
        }catch(NullPointerException e){
            logger.info("Account does not exist");
            return null;
        }
    }

    private static Boolean safeLock(){
        try {
            logger.info("Type Password:");
            int pass = scan.nextInt();
            return currentAcc.getPassword() == pass;
        }catch(InputMismatchException e){
            logger.info("Wrong input");
            return false;
        }catch(NullPointerException e){
            logger.info("Account does not exist. Create an account.");
            return false;
        }
    }

    public static void menu(){
        try {
            logger.info("Menu:\n1. Transaction (Deposit/Withdraw)\n2. View Account\n3. Create Account\n4. Delete Account\n5. Exit");
            switch (scan.nextLine()) {
                case "1":
                    selectAccount();
                    if(!currentAcc.locked()) {
                        transaction();
                    }
                    currentAcc = null;
                    break;
                case "2":
                    selectAccount();
                    if(!currentAcc.locked()) {
                        viewAccount();
                    }
                    currentAcc = null;
                    break;
                case "3":
                    createAccount();
                    currentAcc = null;
                    break;
                case "4":
                    selectAccount();
                    if(!currentAcc.locked()) {
                        deleteAccount();
                    }
                    currentAcc = null;
                    break;
                case "5":
                    end = true;
                    break;
                default:
                    logger.info("Not a valid number.");
            }
        }catch(InputMismatchException e){
            logger.info("Wrong input");
        }catch(NullPointerException e){
            logger.info("Account does not exist.");
        }
    }

    public static void transaction(){
        try {
            if(currentAcc != null) {
                logger.info("Menu:\n1. Deposit\n2. Withdraw");
                switch (scan.nextInt()) {
                    case 1:
                        logger.info("Enter a value to deposit: ");
                        currentAcc.deposit(scan.nextDouble());
                        currentAcc.setFees(2.5);
                        break;
                    case 2:
                        logger.info("Enter a value to withdraw: ");
                        currentAcc.withdraw(scan.nextDouble());
                        currentAcc.setFees(2.5);
                        break;
                    case 3:
                        logger.info("Current Fee is: " + currentAcc.getFees() + "\nEnter amount you paying: ");
                        currentAcc.payFees(scan.nextDouble());
                    default:
                        logger.info("Not a valid number.");
                }
            }
        }catch(InputMismatchException e){
            logger.info("Wrong input");
        }
    }

    public static void createAccount(){
        AccountType();
        accounts.add(currentAcc);
        setPassword();
    }

    private static void AccountType(){
        try {
            logger.info("What type of account to create: \n1. checking account\n2. savings account\n3. business");
            switch (scan.nextInt()) {
                case 1:
                    currentAcc = new CheckingAccount();
                    logger.info("Account Number is: " + currentAcc.getAccountNumber());
                    break;
                case 2:
                    currentAcc = new SavingsAccount();
                    logger.info("Account Number is: " + currentAcc.getAccountNumber());
                    break;
                case 3:
                    currentAcc = new BusinessAccount();
                    logger.info("Account Number is: " + currentAcc.getAccountNumber());
                    break;
                default:
                    logger.info("Not a valid number.");
            }
        }catch(InputMismatchException e){
            logger.info("Wrong input");
        }
    }

    public static void deleteAccount(){
        int i = 0;
        for(BankAccount acc: accounts){
           if(acc == currentAcc){
               accounts.remove(i);
               break;
           }
           i++;
        }
        currentAcc = null;
        logger.info("Account Deleted.");
    }

    public static void viewAccount(){
        if(currentAcc != null) {
            logger.info(currentAcc.toString());
        }
    }

    private static void setPassword(){
        try {
            logger.info("Set password: ");
            currentAcc.setPassword(scan.nextInt());
        }catch (InputMismatchException e){
            logger.info("Wrong input");
        }
    }

}
