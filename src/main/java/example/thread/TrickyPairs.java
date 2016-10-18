package example.thread;

/*
 * What will be the output of the program?
 */

public class TrickyPairs implements Runnable 
{ 
    private int x; 
    private int y; 

    public static void main(String [] args) 
    { 
    	TrickyPairs that = new TrickyPairs(); 
        (new Thread(that)).start( ); /* Line 8 */
        (new Thread(that)).start( ); /* Line 9 */
    } 
    public synchronized void run( ) /* Line 11 */
    { 
        for (;;) /* Line 13 */
        { 
            x++; 
            y++; 
            System.out.println("x = " + x + "y = " + y); 
        } 
    } 
}
