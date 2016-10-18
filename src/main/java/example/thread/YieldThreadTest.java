package example.thread;

public class YieldThreadTest extends Thread 
{ 
    public void run() 
    { 
        System.out.println("In run"); 
        yield(); 
        System.out.println("Leaving run"); 
    } 
    public static void main(String []argv) 
    { 
        (new YieldThreadTest()).start(); 
    } 
}