import java.util.Scanner;

import org.junit.rules.Stopwatch;

import java.util.*;
import java.io.*;

// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author
 *  @version HT 2020
 */

class SortComparison {

	/**
	 * Sorts an array of doubles using InsertionSort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order.
	 *
	 */
	static double [] insertionSort (double a[]){
		double temp;
		 if (a != null)
		 {
		 for (int i = 1; i < a.length; i++) {
			 for(int j = i ; j > 0 ; j--){ 
				 if(a[j] < a[j-1])
				 {
					 temp = a[j];
					 a[j] = a[j-1];
					 a[j-1] = temp;
				 }
			 }
		 }
		 return a;
		 }
		 else
		 {
			 return null;
		 }
	}

	/**
	 * Sorts an array of doubles using Selection Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double [] selectionSort (double a[]){
		if (a != null)
    	{
    	int n = a.length;
    	for (int i = 0; i < n-1; i++)
    	{
    	int min_idx = i;
    	for (int j = i+1; j < n; j++)
    	if (a[j] < a[min_idx]) min_idx = j;
    	double temp = a[min_idx];
    	a[min_idx] = a[i];
    	        a[i] = temp;
    	    }
    	return a;
    	}
    	else
    	{
    		return null;
    	}

	}

	/**
	 * Sorts an array of doubles using Quick Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double [] quickSort (double a[]){
		if (a==null)
		{
			return null;
		}
		else
		{
			recursiveQuickSort(a, 0, a.length-1);
			return a;
		}
		//todo: implement the sort

	}//end quicksort
	public static void recursiveQuickSort(double [] a, int lo, int hi)
	{
		int pivotPos = partition(a, lo, hi);
		if(lo <(pivotPos-1))
		{
			recursiveQuickSort(a, lo, (pivotPos-1));
		}
		if (hi >pivotPos)
		{
			recursiveQuickSort(a, pivotPos, hi);
		}
	}
	private static int partition(double [] a, int lo, int hi)
	{
		double pivotEle = a[lo];
		
		while(lo <= hi)
		{
			while(a[lo] < pivotEle)
			{
				lo++;
			}
			while(a[hi] > pivotEle)
			{
				hi--;
			}
			if(lo<= hi)
			{
				double aTemp = a[lo];
				a[lo] = a[hi];
				a[hi] = aTemp;
				
				lo++;
				hi--;
			}
		}
		return lo;
	}

	/**
	 * Sorts an array of doubles using Merge Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	/**
	 * Sorts an array of doubles using iterative implementation of Merge Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a: An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted order.
	 */

	static double[] mergeSortIterative (double a[]) {
		if (a == null)
		{
			return null;
		}
		else
		{
			double [] aux = new double [a.length];
			if (a.length ==1)
			{
				return a;
			}

			else
			{
				sortIterative(a);
				return a;
			}
		}

	}//end mergesortIterative
	public static void sortIterative(double [] a)
	{
		int N = a.length;
		double [] aux = new double[N];
		for (int sz=1; sz < N; sz = sz+sz)
			for(int lo = 0; lo < N - sz; lo += sz + sz)
				merge (a, aux, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
	}


	/**
	 * Sorts an array of doubles using recursive implementation of Merge Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a: An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted order.
	 */
	static double [] mergeSortRecursive (double a[]) {

		if (a == null)
		{
			return null;
		}
		else
		{
			double [] aux = new double [a.length];
			if (a.length ==1)
			{
				return a;
			}

			else
			{
				sortRecursive(a,aux, 0, a.length - 1);
				return a;
			}
		}
		
		

		//todo: implement the sort

	}//end mergeSortRecursive
	private static void sortRecursive(double [] a, double [] aux, int lo, int hi)
	{
		if(hi<=lo) return;
		int mid = lo + (hi - lo)/2;
		sortRecursive(a, aux, lo, mid);
		sortRecursive(a, aux, mid +1, hi);
		merge(a, aux, lo, mid, hi);
		
	}
	private static void merge(double [] a, double [] aux, int lo, int mid, int hi)
	{
		
		for(int k = lo; k<= hi; k++)
			aux[k] = a[k];
		
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++)
		{
			if		(i > mid )			a[k] = aux[j++];
			else if	(j > hi)			a[k] = aux[i++];
			else if	(aux[j] < aux[i]) 	a[k] = aux[j++];
			else						a[k] = aux[i++];
		}
		
	}


	public static void main(String[] args) {
		double [] numbers10 = new double[10];
		double [] numbers100 = new double [100];
		double [] numbers1000 = new double [1000];
		double [] numbers1000Duplicates = new double [1000];
		double [] numbersNearlyOrdered1000 = new double [1000];
		double [] numbersReverse1000 = new double [1000];
		double [] numbersSorted1000 = new double [1000];
		
		int i =0;
		try
		{
		File file1 = new File("numbers10.txt");
		BufferedReader br1 = new BufferedReader(new FileReader(file1));
		String strCurrentLine;
		double douCurrentLine;
		while((strCurrentLine = br1.readLine()) != null)
		{
	
			douCurrentLine = Double.parseDouble(strCurrentLine);
			numbers10[i] = douCurrentLine;
			i++;
		}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
		try
		{
		File file2 = new File("numbers100.txt");
		BufferedReader br2 = new BufferedReader(new FileReader(file2));
		String strCurrentLine;
		double douCurrentLine;
		i = 0;
		while((strCurrentLine = br2.readLine()) != null)
		{
	
			douCurrentLine = Double.parseDouble(strCurrentLine);
			numbers100[i] = douCurrentLine;
			i++;
		}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		try
		{
		File file3 = new File("numbers1000.txt");
		BufferedReader br3 = new BufferedReader(new FileReader(file3));
		String strCurrentLine;
		double douCurrentLine;
		i = 0;
		while((strCurrentLine = br3.readLine()) != null)
		{
	
			douCurrentLine = Double.parseDouble(strCurrentLine);
			numbers1000[i] = douCurrentLine;
			i++;
		}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		try
		{
		File file4 = new File("numbers1000Duplicates.txt");
		BufferedReader br4 = new BufferedReader(new FileReader(file4));
		String strCurrentLine;
		double douCurrentLine;
		i = 0;
		while((strCurrentLine = br4.readLine()) != null)
		{
	
			douCurrentLine = Double.parseDouble(strCurrentLine);
			numbers1000Duplicates[i] = douCurrentLine;
			i++;
		}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		try
		{
		File file5 = new File("numbersNearlyOrdered1000.txt");
		BufferedReader br5 = new BufferedReader(new FileReader(file5));
		String strCurrentLine;
		double douCurrentLine;
		i = 0;
		while((strCurrentLine = br5.readLine()) != null)
		{
	
			douCurrentLine = Double.parseDouble(strCurrentLine);
			numbersNearlyOrdered1000[i] = douCurrentLine;
			i++;
		}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		try
		{
		File file6 = new File("numbersReverse1000.txt");
		BufferedReader br6 = new BufferedReader(new FileReader(file6));
		String strCurrentLine;
		double douCurrentLine;
		i = 0;
		while((strCurrentLine = br6.readLine()) != null)
		{
	
			douCurrentLine = Double.parseDouble(strCurrentLine);
			numbersReverse1000[i] = douCurrentLine;
			i++;
		}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		try
		{
		File file7 = new File("numbersSorted1000.txt");
		BufferedReader br7 = new BufferedReader(new FileReader(file7));
		String strCurrentLine;
		double douCurrentLine;
		i = 0;
		while((strCurrentLine = br7.readLine()) != null)
		{
	
			douCurrentLine = Double.parseDouble(strCurrentLine);
			numbersSorted1000[i] = douCurrentLine;
			i++;
		}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		double [] numbers10IS = numbers10;
		double [] numbers100IS = numbers100;
		double [] numbers1000IS = numbers1000;
		double [] numbers1000DuplicatesIS = numbers1000Duplicates;
		double [] numbersNearlyOrdered1000IS = numbersNearlyOrdered1000;
		double [] numbersReverse1000IS = numbersReverse1000;
		double [] numbersSorted1000IS = numbersSorted1000;
		
		
		
		double [] numbers10SS = numbers10;
		double [] numbers100SS = numbers100;
		double [] numbers1000SS = numbers1000;
		double [] numbers1000DuplicatesSS = numbers1000Duplicates;
		double [] numbersNearlyOrdered1000SS = numbersNearlyOrdered1000;
		double [] numbersReverse1000SS = numbersReverse1000;
		double [] numbersSorted1000SS = numbersSorted1000;
		
		double [] numbers10QS = numbers10;
		double [] numbers100QS = numbers100;
		double [] numbers1000QS = numbers1000;
		double [] numbers1000DuplicatesQS = numbers1000Duplicates;
		double [] numbersNearlyOrdered1000QS = numbersNearlyOrdered1000;
		double [] numbersReverse1000QS = numbersReverse1000;
		double [] numbersSorted1000QS = numbersSorted1000;
		
		double [] numbers10MSR = numbers10;
		double [] numbers100MSR = numbers100;
		double [] numbers1000MSR = numbers1000;
		double [] numbers1000DuplicatesMSR = numbers1000Duplicates;
		double [] numbersNearlyOrdered1000MSR = numbersNearlyOrdered1000;
		double [] numbersReverse1000MSR = numbersReverse1000;
		double [] numbersSorted1000MSR = numbersSorted1000;
		
		double [] numbers10MSI = numbers10;
		double [] numbers100MSI = numbers100;
		double [] numbers1000MSI = numbers1000;
		double [] numbers1000DuplicatesMSI = numbers1000Duplicates;
		double [] numbersNearlyOrdered1000MSI = numbersNearlyOrdered1000;
		double [] numbersReverse1000MSI = numbersReverse1000;
		double [] numbersSorted1000MSI = numbersSorted1000;
		
		
		double start = 0;
		double end = 0;
		double difference = 0;
		
		//Testing the sorting algorithms for an array of 10 elements
		System.out.println("Array Size = 10");
		start = System.nanoTime();
		SortComparison.insertionSort(numbers10IS);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Insertion Sort " + difference);
		
		start = System.nanoTime();
		SortComparison.insertionSort(numbers10SS);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Selection Sort " + difference);
		
		start = System.nanoTime();
		SortComparison.insertionSort(numbers10QS);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Quick Sort " + difference);
		
		start = System.nanoTime();
		SortComparison.insertionSort(numbers10MSR);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Merge Sort Recursive " + difference);
		
		start = System.nanoTime();
		SortComparison.insertionSort(numbers10MSI);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Merge Sort Iterative " + difference + "\n");
		
		//Testing the sorting algorithms for an array of 100 elements
		System.out.println("Array Size = 100");
		start = System.nanoTime();
		SortComparison.insertionSort(numbers100IS);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Insertion Sort " + difference);
		
		start = System.nanoTime();
		SortComparison.insertionSort(numbers10SS);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Selection Sort " + difference);
		
		start = System.nanoTime();
		SortComparison.insertionSort(numbers100QS);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Quick Sort " + difference);
		
		start = System.nanoTime();
		SortComparison.insertionSort(numbers100MSR);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Merge Sort Recursive " + difference);
		
		start = System.nanoTime();
		SortComparison.insertionSort(numbers100MSI);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Merge Sort Iterative " + difference + "\n");
		
		//Testing the sorting algorithms for an array of 1000 elements
		System.out.println("Array Size = 1000");
		start = System.nanoTime();
		SortComparison.insertionSort(numbers1000IS);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Insertion Sort " + difference);
		
		start = System.nanoTime();
		SortComparison.insertionSort(numbers1000SS);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Selection Sort " + difference);
		
		start = System.nanoTime();
		SortComparison.insertionSort(numbers1000QS);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Quick Sort " + difference);
		
		start = System.nanoTime();
		SortComparison.insertionSort(numbers1000MSR);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Merge Sort Recursive " + difference);
		
		start = System.nanoTime();
		SortComparison.insertionSort(numbers1000MSI);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Merge Sort Iterative " + difference + "\n");
		
		//Testing the sorting algorithms for an array of 100 elements which has a lot of duplicates
		System.out.println("Array Size = 1000 Duplicates");
		start = System.nanoTime();
		SortComparison.insertionSort(numbers1000DuplicatesIS);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Insertion Sort " + difference);
		
		start = System.nanoTime();
		SortComparison.insertionSort(numbers1000DuplicatesSS);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Selection Sort " + difference);
		
		start = System.nanoTime();
		SortComparison.insertionSort(numbers1000DuplicatesQS);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Quick Sort " + difference);
		
		start = System.nanoTime();
		SortComparison.insertionSort(numbers1000DuplicatesMSR);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Merge Sort Recursive " + difference);
		
		start = System.nanoTime();
		SortComparison.insertionSort(numbers1000DuplicatesMSI);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Merge Sort Iterative " + difference + "\n");
		
		//Testing the sorting algorithms for a nearly ordered array of 1000 elements
		System.out.println("Array = NearlyOrdered1000");
		start = System.nanoTime();
		SortComparison.insertionSort(numbersNearlyOrdered1000IS);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Insertion Sort " + difference);
		
		start = System.nanoTime();
		SortComparison.insertionSort(numbersNearlyOrdered1000SS);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Selection Sort " + difference);
		
		start = System.nanoTime();
		SortComparison.insertionSort(numbersNearlyOrdered1000QS);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Quick Sort " + difference);
		
		start = System.nanoTime();
		SortComparison.insertionSort(numbersNearlyOrdered1000MSR);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Merge Sort Recursive " + difference);
		
		start = System.nanoTime();
		SortComparison.insertionSort(numbersNearlyOrdered1000MSI);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Merge Sort Iterative " + difference + "\n");
		
		//Testing the sorting algorithms for a reversely sorted array of 1000 elements
		System.out.println("Array = Reverse1000");
		start = System.nanoTime();
		SortComparison.insertionSort(numbersReverse1000IS);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Insertion Sort " + difference);
		
		start = System.nanoTime();
		SortComparison.insertionSort(numbersReverse1000SS);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Selection Sort " + difference);
		
		start = System.nanoTime();
		SortComparison.insertionSort(numbersReverse1000QS);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Quick Sort " + difference);
		
		start = System.nanoTime();
		SortComparison.insertionSort(numbersReverse1000MSR);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Merge Sort Recursive " + difference);
		
		start = System.nanoTime();
		SortComparison.insertionSort(numbersReverse1000MSI);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Merge Sort Iterative " + difference + "\n");
		
		
		//Testing the sorting algorithms for an already sorted array with 1000 elements
		System.out.println("Array = Sorted1000");
		start = System.nanoTime();
		SortComparison.insertionSort(numbersSorted1000IS);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Insertion Sort " + difference);
		
		start = System.nanoTime();
		SortComparison.insertionSort(numbersSorted1000SS);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Selection Sort " + difference);
		
		start = System.nanoTime();
		SortComparison.insertionSort(numbersSorted1000QS);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Quick Sort " + difference);
		
		start = System.nanoTime();
		SortComparison.insertionSort(numbersSorted1000MSR);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Merge Sort Recursive " + difference);
		
		start = System.nanoTime();
		SortComparison.insertionSort(numbersSorted1000MSI);
		end = System.nanoTime();
		difference = end- start;
		System.out.println("Merge Sort Iterative " + difference + "\n");
	}

}//end class