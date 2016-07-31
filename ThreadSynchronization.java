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

class Table
{    
    //synchronized thing can be done in two ways. it can also have a synchronized block.
    //check
    //synchronized void print(int n){  
    void print(int n)
    {
        synchronized(this)
        {
        for(int i=1;i<=5;i++)
            {  
                System.out.println(n*i);  
                try
                {  
                    Thread.sleep(100);  
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }  
            }  
        }
    }  
}  
  
class Thread1 extends Thread{  
Table t;  
Thread1(Table t){  
this.t=t;  
}  
public void run(){  
t.print(1);  
}  
  
}  
class Thread2 extends Thread{  
Table t;  
Thread2(Table t){  
this.t=t;  
}  
public void run(){  
t.print(100);  
}  
}  
  
class TestSynchronization
{  
public static void main(String args[])
{  
Table obj = new Table();//only one object  
Thread1 t1=new Thread1(obj);  
Thread2 t2=new Thread2(obj);  
t1.start();  
t2.start();  
}  
}  