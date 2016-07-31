/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

/**
 *
 * 
 * @author avidekar
 */
public class ThreadInterfaceImplementation implements Runnable
{
    public void run()
    {
       for(int i=0; i<5; i++)
       {
           try{
               Thread.sleep(1000);
               System.out.println(Thread.currentThread().getName()); //gives the current thread name
           }
           catch(InterruptedException e){
               System.out.println(e);
           }
           System.out.println(i);
       }
    }
    
    public static void main(String args[])
    {
        ThreadInterfaceImplementation t1 = new ThreadInterfaceImplementation();
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t1);
        thread1.start();
        thread2.start(); //will run like a normal function and not like a thread method
        thread1.setName("Main Thread");
        thread2.setName("Sub Thread");
        System.out.println("Name of Thread1 after updating : "+thread1.getName());
        System.out.println("Name of Thread2 after updating : "+thread2.getName());
        System.out.println("ID of Thread1 is " +thread1.getId());
        System.out.println("ID of Thread2 is " +thread2.getId());
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
    }
}
