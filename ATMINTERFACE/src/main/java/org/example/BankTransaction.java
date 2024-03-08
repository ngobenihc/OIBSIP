package org.example;

import java.util.Date;

public class BankTransaction {

    private double amount;
    private Date timeStamp;
    private String memo;
    private BankAccount inAccounts;

    public BankTransaction(double amount, BankAccount inAccounts) {
        this.amount = amount;
        this.inAccounts = inAccounts;
        timeStamp = new Date();
        this.memo ="";
    }

    public BankTransaction(double amount, String memo, BankAccount inAccounts) {

        this(amount,inAccounts);
        this.memo = memo;
        timeStamp = new Date();
    }

    public double getAmount() {
        return this.amount;
    }

    public String getSummaryLine() {
        System.out.println();
        if (this.amount >=0){
           return String.format("%s  %.02f  %s",this.timeStamp.toString(),this.amount,this.memo);

        }else {
            return   String.format("%s  (%.02f)  %s",this.timeStamp.toString(),-this.amount,this.memo);
        }
    }
}
