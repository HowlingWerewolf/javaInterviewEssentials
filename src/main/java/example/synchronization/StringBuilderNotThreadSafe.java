package example.synchronization;

/**
 * This example is about thread safety, especially the StringBuilder case. We all know, that it is not synchronized, so it is faster than StringBuffer.
 * 
 * Example:
 * StringBuilder: 0 1 2 3 4 5 6 7 8 9 10 11 12 21 13 22 14 23 15 16 17 18 19 20 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 
 *
 *
 * StringBuffer: 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 
 * 
 * The example shows that StringBuilder threads runs concurrently resulted in mixing up the numbers.
 * However, StringBuffer runs synchronized, one thread waits for the other (in this case, 20 to 40 counting thread started running first).
 * 
 * @author Gavi
 *
 */
public class StringBuilderNotThreadSafe {
	
    private static StringBuilder builder;
    private static StringBuffer buffer;

    public static void foo()
    {
        builder = new StringBuilder();
        buffer = new StringBuffer();
    }

    public static void builderAppend(final String a)
    {
        builder.append(a);
    }

    public static void bufferAppend(final String a)
    {
    	buffer.append(a);
    }

    public static void main(String [] args) {       	
    	
    	foo();
    	
		Thread builder1 = new Thread(){
			
			public void run() {
		    	for(int i = 0; i <= 20; i++) {
		    		builderAppend(i + " ");	
		    	}		
			};
		};
    	
		Thread builder2 = new Thread(){
			
			public void run() {
		    	for(int i = 21; i <= 40; i++) {
		    		builderAppend(i + " ");	
		    	}		
			};
		};
    	
		Thread buffer1 = new Thread(){
			
			public void run() {
		    	for(int i = 0; i <= 20; i++) {
		    		bufferAppend(i + " ");	
		    	}		
			};
		};
    	
		Thread buffer2 = new Thread(){
			
			public void run() {
		    	for(int i = 21; i <= 40; i++) {
		    		bufferAppend(i + " ");	
		    	}		
			};
		};
		
		builder1.start();
		builder2.start();
		buffer1.start();
		buffer2.start();
    	
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	System.out.println("StringBuilder: " + builder.toString() + "\n\n");
    	System.out.println("StringBuffer: " + buffer.toString() + "\n\n");
    	
    	
    }
}
