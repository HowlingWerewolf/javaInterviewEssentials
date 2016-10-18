package example.collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import example.collections.common.DifferenceTester;
import example.collections.common.Printer;

/**
 * HashMap makes absolutely no guarantees about the iteration order. It can (and will) even change completely when new elements are added.
 * TreeMap will iterate according to the "natural ordering" of the keys according to their compareTo() method (or an externally supplied Comparator). Additionally, it implements the SortedMap interface, which contains methods that depend on this sort order.
 * LinkedHashMap will iterate in the order in which the entries were put into the map
 * "Hashtable" is the generic name for hash-based maps. In the context of the Java API, Hashtable is an obsolete class from the days of Java 1.1 before the collections framework existed. It should not be used anymore, because its API is cluttered with obsolete methods that duplicate functionality, and its methods are synchronized (which can decrease performance and is generally useless). Use ConcurrrentHashMap instead of Hashtable.
 * @author Gavi
 *
 */
public class MapDifferenceTester implements DifferenceTester {
	
	static Map<Integer, Integer> mapData = new HashMap<>();
	static int numberOfCycles = 5; 
	static int max = 100000;
	
	static Map<Integer, Integer> hashMap = new HashMap<>();
	static Map<Integer, Integer> hashTable = new Hashtable<>(); 
	static Map<Integer, Integer> treeMap = new TreeMap<>();
	static Map<Integer, Integer> linkedHashmap = new LinkedHashMap<>();
	
	public static void main(String [] args) throws InterruptedException {	
		
		MapDifferenceTester setDifferencesTester = new MapDifferenceTester();

		System.out.println(Printer.addSeparator(setDifferencesTester.addSampleData()));
		
		setDifferencesTester.test(hashMap);
		setDifferencesTester.test(hashTable);		
		setDifferencesTester.test(treeMap);		
		setDifferencesTester.test(linkedHashmap);		
	}
	
	void test(Map map) throws InterruptedException {
		
		System.out.println(Printer.addSeparator(testRemove(map)));
		
		System.out.println(Printer.addSeparator(testAdd(map)));
		
		System.out.println(Printer.addSeparator(testContainsAll(map)));		
	}
	
	/**
	 * Adds sample data to the listData collection.
	 */
	public String addSampleData() {
		
		long start = System.currentTimeMillis();		
		
		System.out.println("Preparing test...");
		
		int count = 0;
		for (int i = 0; i < numberOfCycles; i++) {
			for (int j = 0; j < max; j++) {
				mapData.put(count, j);
				count++;
			}		
			System.out.println(((i+1.0f)/(numberOfCycles+1.0f))*100 + "%");	
		}
		System.out.println(100 + "%");
		
		long end = System.currentTimeMillis();
		
		StringBuilder sb = new StringBuilder();
		sb.append(Thread.currentThread().getStackTrace()[1].getMethodName() + Printer.printNewLine());
		sb.append("sample data added to collection in " + (end-start) + " ms" + Printer.printNewLine());
		sb.append("number of data added is " + mapData.size());
		
		return sb.toString();
	}
	
	/**
	 * Adds listData sample collection's elements to the list parameter one-by-one, then removes one-by-one.
	 * @param list
	 * @return
	 */
	public String testRemove(Map map) {
		
		String listType = map.getClass().getName();
		
		long start = System.currentTimeMillis();
	    Iterator it = mapData.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry element = (Map.Entry)it.next();
	        map.put(element.getKey(), element.getValue());
	    }
		int addedCount = map.size();		
	    
		it = map.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry element = (Map.Entry)it.next();
	        it.remove();
	    }	
		long end = System.currentTimeMillis();
		
		StringBuilder sb = new StringBuilder();
		sb.append(Thread.currentThread().getStackTrace()[1].getMethodName() + ": " + listType + Printer.printNewLine());
		sb.append("sample data added and removed from " + listType + " in " + (end-start) + " ms" + Printer.printNewLine());
		sb.append("number of data added is " + addedCount + " (also removed)");
		
		return sb.toString();		
	}
	
	/**
	 * Adds listData sample collection's elements to the list parameter one-by-one.
	 * @param list
	 * @return
	 */
	public String testAdd(Map map) {
		
		String listType = map.getClass().getName();
		
		long start = System.currentTimeMillis();
		
	    Iterator it = mapData.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry element = (Map.Entry)it.next();
	        map.put(element.getKey(), element.getValue());
	    }
	    
		long end = System.currentTimeMillis();
		
		StringBuilder sb = new StringBuilder();
		sb.append(Thread.currentThread().getStackTrace()[1].getMethodName() + ": " + listType + Printer.printNewLine());
		sb.append("sample data added to " + listType + " in " + (end-start) + " ms" + Printer.printNewLine());
		sb.append("number of data added is " + map.size());
		
		return sb.toString();
	}
	
	/**
	 * Tests if the added list contains all of the listData collection elements. 
	 * @param list
	 * @return
	 */
	public String testContainsAll(Map map) {
		
		String listType = map.getClass().getName();
		
		long start = System.currentTimeMillis();
		
		boolean containskey = true;
		boolean containsvalue = true;
		
	    Iterator it = mapData.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry element = (Map.Entry)it.next();
	        containskey = containskey && map.containsKey(element.getKey());
	        containsvalue = containsvalue && map.containsValue(element.getValue());
	    }
		long end = System.currentTimeMillis();
		

		StringBuilder sb = new StringBuilder();
		sb.append(Thread.currentThread().getStackTrace()[1].getMethodName() + ": " + listType + Printer.printNewLine());
		sb.append("contains test for " + listType + " ended in " + (end-start) + " ms" + Printer.printNewLine());	
		sb.append("containskey is " + containskey + Printer.printNewLine());
		sb.append("containsvalue is " + containsvalue);	
		
		return sb.toString();
	}
	


}

