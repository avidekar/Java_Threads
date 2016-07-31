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
public class ThreadClassImplementation extends Thread{
   
    public void run()
    {
           try{
               if(Thread.currentThread().isDaemon())
               {
                   System.out.println("Daemon Thread running");
               }
               else
               {
                   System.out.println("User Thread running");
               }
               Thread.sleep(100);
               System.out.println("Priority for "+ Thread.currentThread().getName() + " is - "+ Thread.currentThread().getPriority()); 
           }
           catch(InterruptedException e){
               System.out.println(e);
           }
    }
    
    public static void main(String[] args)
    {
        ThreadClassImplementation thread1 = new ThreadClassImplementation();
        ThreadClassImplementation thread2 = new ThreadClassImplementation();
        ThreadClassImplementation thread3 = new ThreadClassImplementation();
        ThreadGroup tg1 = new ThreadGroup("Group A");
        Thread t1 = new Thread(tg1, new ThreadClassImplementation(), "TestOne");
        Thread t2 = new Thread(tg1, new ThreadClassImplementation(), "TestTwo");
        Thread t3 = new Thread(tg1, new ThreadClassImplementation(), "TestThree");
        System.out.println("Name of Thread 1 :"+thread1.getName());
        System.out.println("Name of Thread 2 :"+thread2.getName());
        System.out.println("Name of Thread 3 :"+thread3.getName());
        thread1.setName("Main Thread");
        thread2.setName("Sub Thread 1");
        thread3.setName("Sub Thread 2");
        System.out.println("Name of Thread 1 after updating :"+thread1.getName());
        System.out.println("Name of Thread 2 after updating :"+thread2.getName());
        System.out.println("Name of Thread 3 after updating :"+thread3.getName());
        System.out.println("ID of Thread1 is " +thread1.getId());
        System.out.println("ID of Thread2 is " +thread2.getId());
        System.out.println("ID of Thread3 is " +thread3.getId());
        thread1.setPriority(MAX_PRIORITY);
        thread2.setPriority(NORM_PRIORITY);
        thread3.setPriority(MIN_PRIORITY);
        thread1.setDaemon(true);        
        thread1.start();
        //thread1.holdsLock(t3); to check if object holds lock
        thread2.start();
        try
        {
        thread2.join(); //The join() method waits for a thread to die. 
        //In other words, it causes the currently running threads to stop executing until the thread it joins with completes its task.
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        thread3.start();
        System.out.println(t1.getName());
        System.out.println(t2.getName());
        System.out.println(t3.getName());
        System.out.println("------------------");
        System.out.println(tg1.getName());
        tg1.list();
    }
}
