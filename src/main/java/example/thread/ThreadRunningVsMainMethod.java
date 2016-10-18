package example.thread;

/*
 * What will be the output of the program?
 */

public class ThreadRunningVsMainMethod { 
	
	static final StringBuffer sb1 = new StringBuffer(); 
	static final StringBuffer sb2 = new StringBuffer(); 
	public static void main(String args[]) 
	{ 
	    new Thread() 
	    { 
	        public void run() 
	        { 
	            synchronized(sb1) 
	            { 
	                sb1.append("A"); 
	                sb2.append("B"); 
	            } 
	        } 
	    }.start(); 

	    new Thread() 
	    { 
	        public void run() 
	        { 
	            synchronized(sb1) 
	            { 
	                sb1.append("C"); 
	                sb2.append("D"); 
	            } 
	        } 
	    }.start();

	    System.out.println (sb1 + " " + sb2); 
	     
	}	
}
