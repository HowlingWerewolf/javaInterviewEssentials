package example.collections.common;

public class Printer {
	
	final static String separator = "**************************";
	
	static String printSeparator(){
		return separator + printNewLine();		
	}
	
	final static String newLine = "\n";
	
	public static String printNewLine() {
		return newLine;
	}
	
	public static String addSeparator(String s) throws InterruptedException{
		StringBuilder sb = new StringBuilder();
		sb.append(printSeparator());
		sb.append(s);
		Thread.sleep(1000);
		
		return sb.toString();
	}
}
