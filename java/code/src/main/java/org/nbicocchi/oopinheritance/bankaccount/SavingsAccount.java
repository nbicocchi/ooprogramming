package org.nbicocchi.oopinheritance.bankaccount;

/**
 * A class representing a particular bank account with interests on deposits
 *
 * @author Nicola Bicocchi
 */
public class SavingsAccount extends BankAccount {
    /**
     * The interest rate applied
     */
    double interestRate;

    /**
     * Creates a saving account with specified initial balance and interst rate
     *
     * @param balance      The initial balance
     * @param interestRate Interest rate to be applied ()
     */
    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    /**
     * Calculate yearly interest for the account
     */
    public double calculateInterest() {
        return balance * interestRate;
    }

    @Override
    public String toString() {
        return "SavingsAccount [interestRate=" + interestRate + ", balance=" + balance + "]";
    }
}