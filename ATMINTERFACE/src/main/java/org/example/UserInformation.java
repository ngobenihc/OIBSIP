package org.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class UserInformation {

    private String name;
    private String surname;
    private String home;
    private String phone;
    private String email;
    private byte[] password;
    private String uuid;
    private ArrayList<BankAccount> accounts;

    public UserInformation(String firstName, String lastName, String pin,String location,String cell,String email, BankMain theBank) {
        this.name = firstName;
        this.surname = lastName;
        this.home = location;
        this.phone = cell;
        this.email=email;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.password = md.digest(pin.getBytes());
        } catch (NoSuchAlgorithmException e){
            System.err.println("error,caught NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }
        this.uuid= theBank.getNewUserUUID();

        this.accounts = new ArrayList<BankAccount>();

        //System.out.println("the new user is "+ firstName + " "+ lastName + " "+ this.uuid);
        System.out.printf("New user %s, %s with ID %s created. \n ",firstName,lastName,this.uuid);
    }

    public void addAcount(BankAccount onAcct){
        this.accounts.add(onAcct);
    }
    public String getUUID() {

        return this.uuid;
    }

    public boolean validatePin(String aPin){

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return MessageDigest.isEqual(md.digest(aPin.getBytes()),this.password);
            //this.pinHash = md.digest(aPin.getBytes());
        } catch (NoSuchAlgorithmException e){
            System.err.println("error,caught NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }
        return false;
    }

    public String getFirstName() {
        return this.name;
    }
    public String getSecondName() {
        return this.surname;
    }
    public String getEmail() {
        return this.email;
    }
    public String getPhoneNumber() {
        return this.phone;
    }
    public String getHomeAddress() {
        return this.home;
    }

    public void printAccountsSummary() {
        System.out.println();
        System.out.println(this.name+"'s accounts  summary");
        for(int i =0; i< this.accounts.size(); i++){
            //System.out.printf(" %d) %s \n ",i+1, this.accounts.get(i).getSummaryLine());
            System.out.println(i+1+": "+this.accounts.get(i).getSummaryLine());
        }
        System.out.println();
    }

    public int numAccount() {
        return this.accounts.size();
    }

    public void printAccTransHistory(int index) {
        this.accounts.get(index).printTransHistory();
    }

    public double getAccountBal(int index) {
        return this.accounts.get(index).getBalance();
    }

    public String getAcountUUID(int index) {

        return this.accounts.get(index).getUUID();
    }

    public void addAcctTransaction(int index, double amount, String memo) {

        this.accounts.get(index).addTransaction(amount,memo);
    }
}
