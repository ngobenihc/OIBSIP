package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        Scanner input = new Scanner(System.in);
        String firstName ="";
        //priv String name;
        String lastname ="";
        String home =" ";
        String phone = "";
        String email =" ";
        String password ="";

        String name_1 = name(firstName,input);
        String secondName = surnName(lastname,input);
        String homeAddress = address(home,input);
        String mail = emailName(email,input);
        String pin = passcode(password,input);
        String cellNumber = cellPhone(phone,input);


        BankMain bank = new BankMain("Bank of cliff");

        UserInformation userInformation = bank.addUser(name_1,secondName,pin,homeAddress,cellNumber,mail);
        BankAccount newAccount = new BankAccount("Checking",userInformation,bank);

        userInformation.addAcount(newAccount);
        bank.addAcount(newAccount);


        UserInformation currentUser;

        while (true){
            currentUser = Main.mainMenuPrompt(bank,input);

            Main.printUserMenu(currentUser,input);
        }
    }


    public static UserInformation mainMenuPrompt(BankMain bank, Scanner input){

        String userID;
        String passcord;
        UserInformation authUser;

        do {

            //System.out.printf("\n\nWelcome to %s\n\n"+ thebank.getName());
            System.out.print("Enter your user Id: ");
            userID = input.nextLine();
            System.out.print("Enter your password : ");
            passcord = input.nextLine();

            authUser = bank.userLogin(userID,passcord);

            if (authUser == null){
                System.out.println("Invalid pin or userId  please enter again ");
            }

        }while (authUser == null);

        return authUser;

    }

    public static void printUserMenu(UserInformation theUser, Scanner input){
        theUser.printAccountsSummary();

        int option;

        do {

            System.out.println("Welcome "+ theUser.getFirstName()+" how can we help you?");
            System.out.println("1: Bank history ");
            System.out.println("2: Withdrawal ");
            System.out.println("3: Deposit ");
            System.out.println("4: Send money ");
            System.out.println("5: Exit ");
            System.out.println("**************************");
            System.out.print("Make you choice of what you need to do :");
            option = input.nextInt();

            if (option < 1 || option>6){
                System.out.println("Invalid input try again with option number from 1 to 5");
            }

        }while (option < 1 || option >6);


        switch (option){
            case 1:
                Main.showbankHistoryStatement(theUser,input);
                break;
            case 2:
                Main.showwithdrawalAmount(theUser,input);
                break;
            case 3:
                Main.showdepositAmount(theUser,input);
                break;
            case 4:
                Main.showsendMoney(theUser,input);
                break;
            case 5:
                input.nextLine();
                break;

        }
        if (option !=5){

            Main. printUserMenu(theUser, input);
        }
    }

    private static void showdepositAmount(UserInformation theUser, Scanner input) {

        int toAccount;
        String memo;
        double bal;
        double amount;

        do {
            System.out.printf("enter the number (1-%d) of the account to deposit in : ",theUser.numAccount());
            toAccount = input.nextInt()-1;
            if (toAccount < 0 || toAccount >= theUser.numAccount()){
                System.out.println("the account doesnt exist enter again");
            }

        }while (toAccount < 0 || toAccount >= theUser.numAccount());

        bal = theUser.getAccountBal(toAccount);

        do {
            System.out.printf("Enter the amount you want to deposit (max R%.02f): ", bal);
            amount = input.nextDouble();
            if (amount < 0) {
                System.out.println("you don't have the money you want to send the money should be greater than zero ");
            }
//            } else if (amount > bal) {
//                System.out.printf("the money you want to see is greater than you current balance money R%.02f ", bal);
//                System.out.println();
//            }
        }while (amount < 0);

        input.nextLine();

        System.out.println("Enter your memo ");
        memo = input.nextLine();

        theUser.addAcctTransaction(toAccount, amount,memo);
    }

    private static void showwithdrawalAmount(UserInformation theUser, Scanner input) {

        int froAccount;
        String memo;
        double bal;
        double amount;

        do {
            System.out.printf("enter the number (1-%d) of the account to withdrawal from: ",theUser.numAccount());
            froAccount = input.nextInt()-1;
            if (froAccount < 0 || froAccount >= theUser.numAccount()){
                System.out.println("the account doesnt exist enter again");
            }
        }while (froAccount < 0 || froAccount >= theUser.numAccount());

        bal = theUser.getAccountBal(froAccount);

        do {
            System.out.printf("enter the amount you want to withdrawal (max R%.02f) :", bal);
            amount = input.nextDouble();
            if (amount < 0){
                System.out.println("you don't have the money you want to send ");
            } else if (amount >bal) {
                System.out.printf("the money you want to see is greater than you current money R%.02f", bal);
                System.out.println();
            }
        }while (amount < 0 || amount >bal );

        input.nextLine();

        System.out.println("Enter your memo ");
        memo = input.nextLine();

        theUser.addAcctTransaction(froAccount, -1*amount,memo);
    }

    private static void showsendMoney(UserInformation theUser, Scanner input) {

        int froAccount;
        int toAccount;
        double acctBal;
        double amount;

        do {
            System.out.printf("Enter the number (1-%d) of the account you're sending money from: ",theUser.numAccount());
            froAccount = input.nextInt()-1;
            if (froAccount < 0 || froAccount >= theUser.numAccount()){
                System.out.println("the account doesnt exist enter again");
            }
        }while (froAccount < 0 || froAccount >= theUser.numAccount());

        acctBal = theUser.getAccountBal(froAccount);


        do {
            System.out.printf("Enter the number (1-%d) of the account you want to sending money to: ",theUser.numAccount());
            toAccount = input.nextInt()-1;
            if (toAccount < 0 || toAccount >= theUser.numAccount()){
                System.out.println("the account doesnt exist enter again");
            }
        }while (toAccount < 0 || toAccount >= theUser.numAccount());

        do {
            //System.out.println();
            System.out.printf("enter the amount you want to transfer (max R%.02f): ", acctBal);
            amount = input.nextDouble();

            if (amount < 0){
                System.out.println("you don't have the money you want to send the amount must be a positive amount or greater than zero ");
            } else if (amount > acctBal) {
                System.out.printf("The money you want to see is greater than you current money R%.02f ", acctBal);
            }

        }while (amount < 0 || amount > acctBal );

        theUser.addAcctTransaction(froAccount, -1*amount, String.format("Transfer to account %s ",theUser.getAcountUUID(toAccount)));
        theUser.addAcctTransaction(toAccount, amount, String.format("Transfer to account %s ",theUser.getAcountUUID(froAccount)));

    }

    private static void showbankHistoryStatement(UserInformation theUser, Scanner input) {
        int theAcct;
        do {
            System.out.printf("Enter the number (1-%d) of the account whose bank history you want to see :",theUser.numAccount());
            theAcct = input.nextInt() -1;
            if(theAcct < 0 || theAcct >= theUser.numAccount()){
                System.out.println("the account doesnt exist enter again");
            }
        }while (theAcct < 0 || theAcct >= theUser.numAccount());

        theUser.printAccTransHistory(theAcct);
    }

public static String name(String firstName, Scanner input){

    System.out.print("Enter you firstname: ");
   return firstName = input.nextLine();
}
public static String surnName(String lastName, Scanner input){

    System.out.print("Enter your lastname: ");
    return lastName = input.nextLine();
    }
    public static String address(String home, Scanner input){
        System.out.print("Enter your location: ");
        return home = input.nextLine();
    }
    public static String emailName(String email, Scanner input){

        System.out.print("Enter your email: ");
        return email = input.nextLine();
    }
    public static String passcode(String password, Scanner input){

        System.out.print("Enter you password: ");
        return password = input.nextLine();
    }

    public static String cellPhone(String phone, Scanner input){
        System.out.print("Enter your phone numbers: ");
        return phone = input.nextLine();

    }

}