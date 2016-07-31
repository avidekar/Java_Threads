/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

/**
 *
 * @author avidekar
 */
class Customer{
    int amount = 10000;
    
    synchronized void withdraw(int amount)
    {
        System.out.println("Withdrawing the Amount "+amount+" from the account");
        if(this.amount < amount)
        {
            System.out.println("Less balance, Waiting for deposit");
            try
            {
                wait();
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }
        System.out.println("Amount withdraw is "+amount);
        this.amount =this.amount - amount;
        System.out.println("Amount remaining is "+this.amount);
    }
    
    synchronized void deposit(int amount)
    {
        System.out.println("Depositing the amount "+amount+" in the account");
        this.amount = this.amount + amount;
        System.out.println("Total balance available "+this.amount);
        notify();
    }
}

public class InterTHreadCommunication {
    public static void main(String[] args)
    {
        final Customer c = new Customer();
        Thread t1 = new Thread(){
          public void run()
          {
             c.withdraw(15000);
          }
        };
        t1.start();
        new Thread(){
            public void run()
            {
                c.deposit(10000);
            }
        }.start();
    }
}
