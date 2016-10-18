package example.thread;

/*
 * What will be the output of the program?
 */

public class SynchronizedThreadDemo 
{ 
    private int count = 1; 
    public synchronized void doSomething() 
    { 
        for (int i = 0; i < 10; i++) 
            System.out.println(count++); 
    } 
    public static void main(String[] args) 
    { 
        SynchronizedThreadDemo demo = new SynchronizedThreadDemo(); 
        Thread a1 = new A(demo); 
        Thread a2 = new A(demo); 
        a1.start(); 
        a2.start(); 
    } 
} 

class A extends Thread 
{ 
    SynchronizedThreadDemo demo; 
    public A(SynchronizedThreadDemo td) 
    { 
        demo = td; 
    } 
    public void run() 
    { 
        demo.doSomething(); 
    } 
}
