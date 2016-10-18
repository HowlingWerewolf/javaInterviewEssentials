package example.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import example.collections.common.DifferenceTester;
import example.collections.common.Printer;

/**
 * For LinkedList<E>

get(int index) is O(n/4) average
add(E element) is O(1)
add(int index, E element) is O(n/4) average
     but O(1) when index = 0 <--- main benefit of LinkedList<E>
remove(int index) is O(n/4) average
Iterator.remove() is O(1) <--- main benefit of LinkedList<E>
ListIterator.add(E element) is O(1) <--- main benefit of LinkedList<E>

For ArrayList<E>

get(int index) is O(1) <--- main benefit of ArrayList<E>
add(E element) is O(1) amortized, but O(n) worst-case since the array must be resized and copied
add(int index, E element) is O(n/2) average
remove(int index) is O(n/2) average
Iterator.remove() is O(n/2) average
ListIterator.add(E element) is O(n/2) average
 * @author Gavi
 *
 */
public class ListDifferenceTester implements DifferenceTester {
	
	static Collection<Integer> listData = new ArrayList<>();
	static int numberOfCycles = 5; 
	static int max = 100000;
	
	static List<Integer> arrayList = new ArrayList<>(1);	
	static List<Integer> linkedList = new LinkedList<>();
	
	public static void main(String [] args) throws InterruptedException {	
		
		ListDifferenceTester listDifferencesTester = new ListDifferenceTester();

		System.out.println(Printer.addSeparator(listDifferencesTester.addSampleData()));
		
		listDifferencesTester.test(arrayList);
		
		listDifferencesTester.test(linkedList);		
	}
	
	void test(List list) throws InterruptedException {
		
		System.out.println(Printer.addSeparator(testRemove(list)));
		
		System.out.println(Printer.addSeparator(testAdd(list)));
		
		System.out.println(Printer.addSeparator(testContainsAll(list)));		
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
	public String testRemove(List list) {
		
		String listType = list.getClass().getName();
		
		long start = System.currentTimeMillis();
		for (Iterator<Integer> iterator = listData.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			list.add(integer);
		}
		int addedCount = list.size();
		while (list.size() > 0){
			list.remove(0);
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
	public String testAdd(List list) {
		
		String listType = list.getClass().getName();
		
		long start = System.currentTimeMillis();
		for (Iterator<Integer> iterator = listData.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			list.add(integer);
		}	
		long end = System.currentTimeMillis();
		
		StringBuilder sb = new StringBuilder();
		sb.append(Thread.currentThread().getStackTrace()[1].getMethodName() + ": " + listType + Printer.printNewLine());
		sb.append("sample data added to " + listType + " in " + (end-start) + " ms" + Printer.printNewLine());
		sb.append("number of data added is " + list.size());
		
		return sb.toString();
	}
	
	/**
	 * Tests if the added list contains all of the listData collection elements. 
	 * @param list
	 * @return
	 */
	public String testContainsAll(List list) {
		
		String listType = list.getClass().getName();
		
		long start = System.currentTimeMillis();
		boolean containsAll = list.containsAll(listData);
		long end = System.currentTimeMillis();
		

		StringBuilder sb = new StringBuilder();
		sb.append(Thread.currentThread().getStackTrace()[1].getMethodName() + ": " + listType + Printer.printNewLine());
		sb.append("containsall test for " + listType + " ended in " + (end-start) + " ms" + Printer.printNewLine());	
		sb.append("containsall is " + containsAll);	
		
		return sb.toString();
	}
	


}

