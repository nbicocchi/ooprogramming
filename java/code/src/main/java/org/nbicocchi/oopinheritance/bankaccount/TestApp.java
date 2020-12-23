package org.nbicocchi.oopinheritance.bankaccount;

/**
 * Implementare le classi rappresentate in UML all'interno del file .svg
 * presente nel package e testarle con il main() sottostante.
 *
 * @author Nicola Bicocchi
 */
public class TestApp {
    public static void main(String[] args) {
        SavingsAccount ac01 = new SavingsAccount(5000, 0.01);
        SavingsAccount ac02 = new SavingsAccount(10000, 0.02);

        ac01.deposit(1000);
        ac01.transfer(1000, ac02);

        ac01.withdraw(500);
        ac02.withdraw(500);

        ac01.deposit(ac01.calculateInterest());
        ac02.deposit(ac02.calculateInterest());

        System.out.println(ac01);
        System.out.println(ac02);
    }
}