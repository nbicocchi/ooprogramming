package org.nbicocchi.threads.bankaccount;

public class TestApp {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(150);
        Thread homer = new Thread(new Person(account), "Homer");
        Thread marge = new Thread(new Person(account), "Marge");
        homer.start();
        marge.start();
    }
}
