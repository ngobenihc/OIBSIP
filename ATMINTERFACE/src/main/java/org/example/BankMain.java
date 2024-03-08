package org.example;

import java.util.ArrayList;
import java.util.Random;

public class BankMain {


    private String name;
    private ArrayList<UserInformation> users;
    private ArrayList<BankAccount>accounts;

    public BankMain(String name) {
        this.name = name;
        this.users = new ArrayList<UserInformation>();
        this.accounts = new ArrayList<BankAccount>();
    }


    public  String getNewUserUUID(){
        String uuid;
        Random random = new Random();
        int len = 2;
        boolean isUnique;

        do {
            uuid ="";
            for (int i =0;i < len;i++){
                uuid += ((Integer)random.nextInt(10)).toString();
            }

            isUnique = false;
            for(UserInformation i :this.users){

                if (uuid.compareTo(i.getUUID()) == 0){
                    isUnique = true;
                    break;
                }
            }

        }while (isUnique);
        return uuid;
    }

    public String getNewAccountUUID(){
        String uuid;
        Random random = new Random();
        int len = 10;
        boolean isUnique;

        do {
            uuid ="";

            for (int i =0;i < len;i++){
                uuid += ((Integer)random.nextInt(10)).toString();
            }

            isUnique = false;
            for(BankAccount i :this.accounts){

                if (uuid.compareTo(i.getUUID()) == 0){
                    isUnique = true;
                    break;
                }



            }

        }while (isUnique);

        return uuid;
    }

    public void addAcount(BankAccount onAccot){
        this.accounts.add(onAccot);
    }

    public UserInformation addUser(String fistName, String lastName, String pin,String location,String cell,String email){
        UserInformation newUser = new UserInformation (fistName,lastName,pin,location,cell,email,this);
        this.users.add(newUser);

        BankAccount newAccount = new BankAccount("saving",newUser,this);
        newUser.addAcount(newAccount);
        this.accounts.add(newAccount);

        return newUser;

    }

    public UserInformation userLogin(String userID,String pin){
        for (UserInformation x: this.users){

            if (x.getUUID().compareTo(userID) == 0 && x.validatePin(pin)){

                return x;
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }
}
