package org.nbicocchi.threads.bankaccount;

import java.util.Random;

public class Person implements Runnable {
    private final BankAccount account;
    private final Random rnd;

    public Person(BankAccount account) {
        rnd = new Random();
        this.account = account;
    }

    @Override
    /*
     * Remove synchronized (account) to observe eventual race conditions. They might
     * show up immediately or after several runs. Because of these unpredictable
     * behaviors, multi-threaded programs are often difficult to debug!
     */
    public void run() {
        while (true) {
            synchronized (account) {
                int amount = rnd.nextInt(100);

                if (account.getBalance() < amount) {
                    System.out.printf("%s quitting [balance=%d, amount=%d]\n", Thread.currentThread().getName(),
                            account.getBalance(), amount);
                    break;
                }

                System.out.printf("%s is going to withdraw [balance=%d, amount=%d]\n", Thread.currentThread().getName(),
                        account.getBalance(), amount);

                account.withdraw(amount);

                System.out.printf("%s completed withdraw [balance=%d]\n", Thread.currentThread().getName(),
                        account.getBalance());

                if (account.getBalance() < 0) {
                    System.out.printf("%s DOH!! [balance=%d, amount=%d]\n", Thread.currentThread().getName(),
                            account.getBalance(), amount);
                    break;
                }

            }
        }
    }
}
