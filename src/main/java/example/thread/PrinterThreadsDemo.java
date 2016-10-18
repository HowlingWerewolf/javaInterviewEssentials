package example.thread;

/*
 * What will be the output of the program?
 * Which thread will be computed by start method?
 */

public class PrinterThreadsDemo implements Runnable 
{ 
    private int x; 
    private int y; 

    public static void main(String args[]) 
    {
        PrinterThreadsDemo that = new PrinterThreadsDemo(); 
        (new Thread(that)).start(); 
        (new Thread(that)).start(); 
    } 
    public synchronized void run() 
    {
        for(int i = 0; i < 10; i++) 
        { 
            x++; 
            y++; 
            System.out.println(Thread.currentThread().getName() + " x = " + x + ", y = " + y);
        } 
    } 
} 