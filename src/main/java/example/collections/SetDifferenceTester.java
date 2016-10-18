package example.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import example.collections.common.DifferenceTester;
import example.collections.common.Printer;

/**
 * Basically, set does not contains duplicates.
 * HashSet is implemented using a hash table. Elements are not ordered. The add, remove, and contains methods has constant time complexity O(1). 
 * TreeSet is implemented using a tree structure(red-black tree in algorithm book). The elements in a set are sorted, but the add, remove, and contains methods has  time complexity of O(log (n)). It offers several methods to deal with the ordered set like first(), last(), headSet(), tailSet(), etc.  
 * LinkedHashSet is between HashSet and TreeSet. It is implemented as a hash table with a linked list running through it, so it provides the order of insertion. The time complexity of basic methods is O(1).   
 * @author Gavi
 *
 */
public class SetDifferenceTester implements DifferenceTester {
	
	static Collection<Integer> listData = new ArrayList<>();
	static int numberOfCycles = 2; 
	static int max = 500000;

	static Set<Integer> hashSet = new HashSet<>();
	static Set<Integer> sortedSet = new TreeSet<>();
	static Set<Integer> linkedHashset = new LinkedHashSet<>();
	
	public static void main(String [] args) throws InterruptedException {	
		
		SetDifferenceTester setDifferencesTester = new SetDifferenceTester();

		System.out.println(Printer.addSeparator(setDifferencesTester.addSampleData()));
		
		setDifferencesTester.test(hashSet);		
		setDifferencesTester.test(sortedSet);		
		setDifferencesTester.test(linkedHashset);		
	}
	
	void test(Set set) throws InterruptedException {
		
		System.out.println(Printer.addSeparator(testRemove(set)));
		
		System.out.println(Printer.addSeparator(testAdd(set)));
		
		System.out.println(Printer.addSeparator(testContainsAll(set)));		
	}
	
	/**
	 * Adds sample data to the listData collection.
	 */
	public String addSampleData() {
		
		long start = System.currentTimeMillis();		
		
		System.out.println("Preparing test...");
		for (int i = 0; i < numberOfCycles; i++) {
			for (int j = 0; j < max; j++) {
				listData.add(j);
			}		
			System.out.println(((i+1.0f)/(numberOfCycles+1.0f))*100 + "%");	
		}
		System.out.println(100 + "%");
		
		long end = System.currentTimeMillis();
		
		StringBuilder sb = new StringBuilder();
		sb.append(Thread.currentThread().getStackTrace()[1].getMethodName() + Printer.printNewLine());
		sb.append("sample data added to collection in " + (end-start) + " ms" + Printer.printNewLine());
		sb.append("number of data added is " + listData.size());
		
		return sb.toString();
	}
	
	/**
	 * Adds listData sample collection's elements to the list parameter one-by-one, then removes one-by-one.
	 * @param list
	 * @return
	 */
	public String testRemove(Set set) {
		
		String listType = set.getClass().getName();
		
		long start = System.currentTimeMillis();
		for (Iterator<Integer> iterator = listData.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			set.add(integer);
		}
		int addedCount = set.size();		
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			iterator.remove();
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
	public String testAdd(Set set) {
		
		String listType = set.getClass().getName();
		
		long start = System.currentTimeMillis();
		for (Iterator<Integer> iterator = listData.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			set.add(integer);
		}	
		long end = System.currentTimeMillis();
		
		StringBuilder sb = new StringBuilder();
		sb.append(Thread.currentThread().getStackTrace()[1].getMethodName() + ": " + listType + Printer.printNewLine());
		sb.append("sample data added to " + listType + " in " + (end-start) + " ms" + Printer.printNewLine());
		sb.append("number of data added is " + set.size());
		
		return sb.toString();
	}
	
	/**
	 * Tests if the added list contains all of the listData collection elements. 
	 * @param list
	 * @return
	 */
	public String testContainsAll(Set set) {
		
		String listType = set.getClass().getName();
		
		long start = System.currentTimeMillis();
		boolean containsAll = set.containsAll(listData);
		long end = System.currentTimeMillis();
		

		StringBuilder sb = new StringBuilder();
		sb.append(Thread.currentThread().getStackTrace()[1].getMethodName() + ": " + listType + Printer.printNewLine());
		sb.append("containsall test for " + listType + " ended in " + (end-start) + " ms" + Printer.printNewLine());	
		sb.append("containsall is " + containsAll);	
		
		return sb.toString();
	}
	


}

