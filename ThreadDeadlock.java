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
public class ThreadDeadlock {

    public static void main(String[] args)
    {
        final String resource1 = "Ajay Videkar";
        final String resource2 = "Sourabh Dravid";
        Thread t1 = new Thread() {
          public void run()
          {
              synchronized(resource2)
              {
                  System.out.println("Resource2 locked");
              }
              try
              {
                  Thread.sleep(100);
              }
              catch(Exception e)
              {
                  System.out.println(e);
              }
              synchronized(resource1)
              {
                  System.out.println("Resource1 locked");
              }
          }
        };
        
        Thread t2 = new Thread() {
          public void run()
          {
              synchronized(resource1)
              {
                  System.out.println("Resource1 locked");
              }
              try
              {
                  Thread.sleep(100);
              }
              catch(Exception e)
              {
                  System.out.println(e);
              }
              synchronized(resource2)
              {
                  System.out.println("Resource2 locked");
              }
          }
        };
        
        t1.start();
        t2.start();
    }
    
}
