package org.nbicocchi.oopinheritance.bankaccount;

/**
 * A class representing a bank account
 *
 * @author Nicola
 */
public abstract class BankAccount {
    /**
     * Balance of the bank account
     */
    double balance = 0;

    /**
     * Creates an empty bank account
     */
    public BankAccount() {

    }

    /**
     * Creates a bank account with an initial balance
     *
     * @param balance The initial balance
     */
    public BankAccount(double balance) {
        this.balance = balance;
    }

    /**
     * Increase balance by amount
     *
     * @param amount
     */
    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
        }
    }

    /**
     * Decrease balance by amount
     *
     * @param amount
     */
    public void withdraw(double amount) {
        if (amount > 0) {
            balance = balance - amount;
        }
    }

    /**
     * Return current balance of the account
     *
     * @return Current balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Withdraw amount from local account and deposit the same amount to other
     * account
     *
     * @param amount
     * @param other
     */
    public void transfer(double amount, BankAccount other) {
        withdraw(amount);
        other.deposit(amount);
    }
}