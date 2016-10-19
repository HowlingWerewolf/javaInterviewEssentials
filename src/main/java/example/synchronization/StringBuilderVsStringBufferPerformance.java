package example.synchronization;

/**
 * StringBuilder is faster than StringBuffer because it's not synchronized.
 * @author Gavi
 *
 */
public class StringBuilderVsStringBufferPerformance {
	
	public static void main (String [] args) throws InterruptedException {
		
        int N = 100000000;
        long t;
		
        {
            StringBuffer sb = new StringBuffer();
            t = System.currentTimeMillis();
            for (int i = N; i --> 0 ;) {
                sb.append("");
            }
            System.out.println("StringBuffer: " + (System.currentTimeMillis() - t) + " ms");
        }

        {
            StringBuilder sb = new StringBuilder();
            t = System.currentTimeMillis();
            for (int i = N; i --> 0 ;) {
                sb.append("");
            }
            System.out.println("StringBuilder: " + (System.currentTimeMillis() - t) + " ms");
        }

	}	

}
