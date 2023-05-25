package org.medron.concurrency.pack4;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {


    public void moneyTransfer(Account a, Account b,int amount){
        b.setAmount(b.getAmount()+amount);
        a.setAmount(a.getAmount()-amount);
    }


    public static void main(String[] args) {
        Random random = new Random();
        Account account1 = new Account(5000);
        Account account2 = new Account(5000);
        Main main = new Main();
        main.moneyTransfer(account1,account2,2000);
        System.out.println(account1.getAmount());
        System.out.println(account2.getAmount());

    }
    private Account account1 = new Account();
    private Account account2 = new Account();
    private Random random = new Random();
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();


    public void checkLock(Lock a,Lock b) {
        boolean a_elde_edildi = false;
        boolean b_elde_edildi = false;

        while(true) {
            a_elde_edildi = a.tryLock();
            b_elde_edildi = b.tryLock();

            if (a_elde_edildi == true && b_elde_edildi == true) {
                return;
            }
            if (a_elde_edildi == true) {
                a.unlock();
            }
            if (b_elde_edildi == true) {
                b.unlock();
            }
        }
    }

    public void threadFunction1(){
        checkLock(lock1, lock2);
        //TODO:

        lock1.unlock();
        lock2.unlock();


    }
    public void threadFunction2(){
        checkLock(lock1, lock2);
        //TODO:

        lock1.unlock();
        lock2.unlock();


    }

}
