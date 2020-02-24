import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author Sorcha Tiernan
 *  @version HT 2020
 *  All times are in nanoseconds
 *  						Insertion	Selection	Quick		MergeRecursive	MergeIterative
 *  10 random				3572		2002		1828		1884			1790
 *  100 random				143252		132658		132410		135491			110806
 *  1000 random				2168653		2621896		473107		254210			267953
 *  1000 duplicates			222877		261684		246596		222173			244238
 *  1000 nearly ordered		236534		224742		223692		224361			224831
 *  1000 reverse order		294840		224882		230036		222288			221833
 *  1000 sorted				221760		222159		221428		221615			222477
 *  
 *  a. Which of the sorting algorithms does the order of input have an impact on? Why?
 *  		Insertions sort is affected by the order of input. A reversely sorted array has a longer running time
 *  		for than a nearly ordered or ordred array showing the the order of input has an effect on insertion sort.
	b. Which algorithm has the biggest difference between the best and worst performance, based
		on the type of input, for the input of size 1000? Why?
			Selection sort has the biggest difference between the the best and worst performance based on type of input. 
			The difference between a random array and an already sorted array is 2,399,737 nanoseconds. This makes it the biggest difference 
			between best and worst case.
	c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
		based on the input size? Please consider only input files with random order for this answer.
			Selection sort has the worst scalability based on input time. The difference in running time for a random array 
			with 10 elements and a random array with 1000 elements was 2,619,894 nanoseconds. 
			In contrast, Merge Sort Recursive had the best scalability. The difference between a 10 element array and a 1000 element array 
			was 252,326.
	d. Did you observe any difference between iterative and recursive implementations of merge
		sort?
			There was only a small difference between Merge Sort Recursive and Merge Sort Iterative. The recursive method was marginally faster than the iterative 
			method for arrays of a larger size.
	e. Which algorithm is the fastest for each of the 7 input files?
		Generally, Merge Sort recursive was the fastest algorithm.
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
	private static final double DELTA = 1e-15;
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    	double [] emptyArray = null;
    	assertNull(SortComparison.insertionSort(emptyArray));
    	assertNull(SortComparison.selectionSort(emptyArray));
    	assertNull(SortComparison.quickSort(emptyArray));
    	assertNull(SortComparison.mergeSortIterative(emptyArray));
    	SortComparison.mergeSortRecursive(emptyArray);
    	assertNull(emptyArray);
    	
    }

    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------
    @Test
    public void testInsertionSort()
    {
    	//test an array with one element
    	double [] aSingle = {1.5};	
    	double [] aSingleSorted = {1.5};
    	double [] bSingle = SortComparison.insertionSort(aSingle);
    	assertArrayEquals(aSingleSorted, bSingle, DELTA);

    	//tests a positive array
    	double [] aPositive = {3.2, 8.9, 1.0, 11.4, 5.5};
    	double [] aPositiveSorted = {1.0, 3.2, 5.5, 8.9, 11.4};
    	double [] bPositive = SortComparison.insertionSort(aPositive);
    	assertArrayEquals(aPositiveSorted, bPositive, DELTA);

    	//test a negative array
    	double [] aNegative = {-3.2, -8.9, -1.0, -11.4, -5.5};
    	double [] aNegativeSorted = {-11.4, -8.9, -5.5, -3.2, -1.0};
    	double [] bNegative = SortComparison.insertionSort(aNegative);
    	assertArrayEquals(aNegativeSorted, bNegative, DELTA);

    	//tests an array with both negative and positive components
    	double [] aMixed = {3.2, -8.9, 1.0, -11.4, -5.5};
    	double [] aMixedSorted = {-11.4, -8.9, -5.5, 1.0, 3.2};
    	double [] bMixed = SortComparison.insertionSort(aMixed);
    	assertArrayEquals(aMixedSorted, bMixed, DELTA);

    }
    @Test
    public void testSelectionSort()
    {
    	//test an array with one element
    	double [] aSingle = {1.5};	
    	double [] aSingleSorted = {1.5};
    	double [] bSingle = SortComparison.selectionSort(aSingle);
    	assertArrayEquals(aSingleSorted, bSingle, DELTA);

    	//tests a positive array
    	double [] aPositive = {3.2, 8.9, 1.0, 11.4, 5.5};
    	double [] aPositiveSorted = {1.0, 3.2, 5.5, 8.9, 11.4};
    	double [] bPositive = SortComparison.selectionSort(aPositive);
    	assertArrayEquals(aPositiveSorted, bPositive, DELTA);

    	//test a negative array
    	double [] aNegative = {-3.2, -8.9, -1.0, -11.4, -5.5};
    	double [] aNegativeSorted = {-11.4, -8.9, -5.5, -3.2, -1.0};
    	double [] bNegative = SortComparison.selectionSort(aNegative);
    	assertArrayEquals(aNegativeSorted, bNegative, DELTA);

    	//tests an array with both negative and positive components
    	double [] aMixed = {3.2, -8.9, 1.0, -11.4, -5.5};
    	double [] aMixedSorted = {-11.4, -8.9, -5.5, 1.0, 3.2};
    	double [] bMixed = SortComparison.selectionSort(aMixed);
    	assertArrayEquals(aMixedSorted, bMixed, DELTA);

    }
    @Test
    public void testMergeSortRecursive()
    {
    	//test an array with one element
    	double [] aSingle = {1.5};	
    	double [] aSingleSorted = {1.5};
    	double [] bSingle = SortComparison.mergeSortRecursive(aSingle);
    	assertArrayEquals(aSingleSorted, bSingle, DELTA);

    	//tests a positive array
    	double [] aPositive = {3.2, 8.9, 1.0, 11.4, 5.5};
    	double [] aPositiveSorted = {1.0, 3.2, 5.5, 8.9, 11.4};
    	double [] bPositive =SortComparison.mergeSortRecursive(aPositive);
    	assertArrayEquals(aPositiveSorted, bPositive, DELTA);

    	//test a negative array
    	double [] aNegative = {-3.2, -8.9, -1.0, -11.4, -5.5};
    	double [] aNegativeSorted = {-11.4, -8.9, -5.5, -3.2, -1.0};
    	double [] bNegative = SortComparison.mergeSortRecursive(aNegative);
    	assertArrayEquals(aNegativeSorted, bNegative, DELTA);

    	//tests an array with both negative and positive components
    	double [] aMixed = {3.2, -8.9, 1.0, -11.4, -5.5};
    	double [] aMixedSorted = {-11.4, -8.9, -5.5, 1.0, 3.2};
    	double [] bMixed = SortComparison.mergeSortRecursive(aMixed);
    	assertArrayEquals(aMixedSorted, bMixed, DELTA);

    }
    
    @Test
    public void testMergeSortIterative()
    {
    	//test an array with one element
    	double [] aSingle = {1.5};	
    	double [] aSingleSorted = {1.5};
    	double [] bSingle = SortComparison.mergeSortIterative(aSingle);
    	assertArrayEquals(aSingleSorted, bSingle, DELTA);

    	//tests a positive array
    	double [] aPositive = {3.2, 8.9, 1.0, 11.4, 5.5};
    	double [] aPositiveSorted = {1.0, 3.2, 5.5, 8.9, 11.4};
    	double [] bPositive =SortComparison.mergeSortIterative(aPositive);
    	assertArrayEquals(aPositiveSorted, bPositive, DELTA);

    	//test a negative array
    	double [] aNegative = {-3.2, -8.9, -1.0, -11.4, -5.5};
    	double [] aNegativeSorted = {-11.4, -8.9, -5.5, -3.2, -1.0};
    	double [] bNegative = SortComparison.mergeSortIterative(aNegative);
    	assertArrayEquals(aNegativeSorted, bNegative, DELTA);

    	//tests an array with both negative and positive components
    	double [] aMixed = {3.2, -8.9, 1.0, -11.4, -5.5};
    	double [] aMixedSorted = {-11.4, -8.9, -5.5, 1.0, 3.2};
    	double [] bMixed = SortComparison.mergeSortIterative(aMixed);
    	assertArrayEquals(aMixedSorted, bMixed, DELTA);
    }
    @Test
    public void testQuicksort()
    {
    	//test an array with one element
    	double [] aSingle = {1.5};	
    	double [] aSingleSorted = {1.5};
    	double [] bSingle = SortComparison.quickSort(aSingle);
    	assertArrayEquals(aSingleSorted, bSingle, DELTA);

    	//tests a positive array
    	double [] aPositive = {3.2, 8.9, 1.0, 11.4, 5.5};
    	double [] aPositiveSorted = {1.0, 3.2, 5.5, 8.9, 11.4};
    	double [] bPositive =SortComparison.quickSort(aPositive);
    	assertArrayEquals(aPositiveSorted, bPositive, DELTA);

    	//test a negative array
    	double [] aNegative = {-3.2, -8.9, -1.0, -11.4, -5.5};
    	double [] aNegativeSorted = {-11.4, -8.9, -5.5, -3.2, -1.0};
    	double [] bNegative = SortComparison.quickSort(aNegative);
    	assertArrayEquals(aNegativeSorted, bNegative, DELTA);

    	//tests an array with both negative and positive components
    	double [] aMixed = {3.2, -8.9, 1.0, -11.4, -5.5};
    	double [] aMixedSorted = {-11.4, -8.9, -5.5, 1.0, 3.2};
    	double [] bMixed = SortComparison.quickSort(aMixed);
    	assertArrayEquals(aMixedSorted, bMixed, DELTA);
    }
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
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
		
		double [] numbers10IS1 = numbers10;
		double [] numbers100IS1 = numbers100;
		double [] numbers1000IS1 = numbers1000;
		double [] numbers1000DuplicatesIS1 = numbers1000Duplicates;
		double [] numbersNearlyOrdered1000IS1 = numbersNearlyOrdered1000;
		double [] numbersReverse1000IS1 = numbersReverse1000;
		double [] numbersSorted1000IS1 = numbersSorted1000;
		
		double [] numbers10IS2 = numbers10;
		double [] numbers100IS2 = numbers100;
		double [] numbers1000IS2 = numbers1000;
		double [] numbers1000DuplicatesIS2 = numbers1000Duplicates;
		double [] numbersNearlyOrdered1000IS2 = numbersNearlyOrdered1000;
		double [] numbersReverse1000IS2 = numbersReverse1000;
		double [] numbersSorted1000IS2 = numbersSorted1000;
		
		double [] numbers10IS3 = numbers10;
		double [] numbers100IS3 = numbers100;
		double [] numbers1000IS3 = numbers1000;
		double [] numbers1000DuplicatesIS3 = numbers1000Duplicates;
		double [] numbersNearlyOrdered1000IS3 = numbersNearlyOrdered1000;
		double [] numbersReverse1000IS3 = numbersReverse1000;
		double [] numbersSorted1000IS3 = numbersSorted1000;
		
		
		
		double [] numbers10SS1 = numbers10;
		double [] numbers100SS1 = numbers100;
		double [] numbers1000SS1 = numbers1000;
		double [] numbers1000DuplicatesSS1 = numbers1000Duplicates;
		double [] numbersNearlyOrdered1000SS1 = numbersNearlyOrdered1000;
		double [] numbersReverse1000SS1 = numbersReverse1000;
		double [] numbersSorted1000SS1 = numbersSorted1000;
		
		double [] numbers10SS2 = numbers10;
		double [] numbers100SS2 = numbers100;
		double [] numbers1000SS2 = numbers1000;
		double [] numbers1000DuplicatesSS2 = numbers1000Duplicates;
		double [] numbersNearlyOrdered1000SS2 = numbersNearlyOrdered1000;
		double [] numbersReverse1000SS2 = numbersReverse1000;
		double [] numbersSorted1000SS2 = numbersSorted1000;
		
		double [] numbers10SS3 = numbers10;
		double [] numbers100SS3 = numbers100;
		double [] numbers1000SS3 = numbers1000;
		double [] numbers1000DuplicatesSS3 = numbers1000Duplicates;
		double [] numbersNearlyOrdered1000SS3 = numbersNearlyOrdered1000;
		double [] numbersReverse1000SS3 = numbersReverse1000;
		double [] numbersSorted1000SS3 = numbersSorted1000;
		
		
		double [] numbers10QS1 = numbers10;
		double [] numbers100QS1 = numbers100;
		double [] numbers1000QS1 = numbers1000;
		double [] numbers1000DuplicatesQS1 = numbers1000Duplicates;
		double [] numbersNearlyOrdered1000QS1 = numbersNearlyOrdered1000;
		double [] numbersReverse1000QS1 = numbersReverse1000;
		double [] numbersSorted1000QS1 = numbersSorted1000;
		
		double [] numbers10QS2 = numbers10;
		double [] numbers100QS2 = numbers100;
		double [] numbers1000QS2 = numbers1000;
		double [] numbers1000DuplicatesQS2 = numbers1000Duplicates;
		double [] numbersNearlyOrdered1000QS2 = numbersNearlyOrdered1000;
		double [] numbersReverse1000QS2 = numbersReverse1000;
		double [] numbersSorted1000QS2 = numbersSorted1000;
		
		double [] numbers10QS3 = numbers10;
		double [] numbers100QS3 = numbers100;
		double [] numbers1000QS3 = numbers1000;
		double [] numbers1000DuplicatesQS3 = numbers1000Duplicates;
		double [] numbersNearlyOrdered1000QS3 = numbersNearlyOrdered1000;
		double [] numbersReverse1000QS3 = numbersReverse1000;
		double [] numbersSorted1000QS3 = numbersSorted1000;
		
		
		double [] numbers10MSR1 = numbers10;
		double [] numbers100MSR1 = numbers100;
		double [] numbers1000MSR1 = numbers1000;
		double [] numbers1000DuplicatesMSR1 = numbers1000Duplicates;
		double [] numbersNearlyOrdered1000MSR1 = numbersNearlyOrdered1000;
		double [] numbersReverse1000MSR1 = numbersReverse1000;
		double [] numbersSorted1000MSR1 = numbersSorted1000;
		
		double [] numbers10MSR2 = numbers10;
		double [] numbers100MSR2 = numbers100;
		double [] numbers1000MSR2 = numbers1000;
		double [] numbers1000DuplicatesMSR2 = numbers1000Duplicates;
		double [] numbersNearlyOrdered1000MSR2 = numbersNearlyOrdered1000;
		double [] numbersReverse1000MSR2 = numbersReverse1000;
		double [] numbersSorted1000MSR2 = numbersSorted1000;
		
		double [] numbers10MSR3 = numbers10;
		double [] numbers100MSR3 = numbers100;
		double [] numbers1000MSR3 = numbers1000;
		double [] numbers1000DuplicatesMSR3 = numbers1000Duplicates;
		double [] numbersNearlyOrdered1000MSR3 = numbersNearlyOrdered1000;
		double [] numbersReverse1000MSR3 = numbersReverse1000;
		double [] numbersSorted1000MSR3 = numbersSorted1000;
		
		
		double [] numbers10MSI1 = numbers10;
		double [] numbers100MSI1 = numbers100;
		double [] numbers1000MSI1 = numbers1000;
		double [] numbers1000DuplicatesMSI1 = numbers1000Duplicates;
		double [] numbersNearlyOrdered1000MSI1 = numbersNearlyOrdered1000;
		double [] numbersReverse1000MSI1 = numbersReverse1000;
		double [] numbersSorted1000MSI1 = numbersSorted1000;
		
		double [] numbers10MSI2 = numbers10;
		double [] numbers100MSI2 = numbers100;
		double [] numbers1000MSI2 = numbers1000;
		double [] numbers1000DuplicatesMSI2 = numbers1000Duplicates;
		double [] numbersNearlyOrdered1000MSI2 = numbersNearlyOrdered1000;
		double [] numbersReverse1000MSI2 = numbersReverse1000;
		double [] numbersSorted1000MSI2 = numbersSorted1000;
		
		double [] numbers10MSI3 = numbers10;
		double [] numbers100MSI3 = numbers100;
		double [] numbers1000MSI3 = numbers1000;
		double [] numbers1000DuplicatesMSI3 = numbers1000Duplicates;
		double [] numbersNearlyOrdered1000MSI3 = numbersNearlyOrdered1000;
		double [] numbersReverse1000MSI3 = numbersReverse1000;
		double [] numbersSorted1000MSI3 = numbersSorted1000;
		
		
		double start1 = 0;
		double end1 = 0;
		double difference1 = 0;
		
		double start2 = 0;
		double end2 = 0;
		double difference2 = 0;
		
		double start3 = 0;
		double end3 = 0;
		double difference3 = 0;
		
		double average = 0;
		
		//Testing the sorting algorithms for an array of 10 elements
		System.out.println("Array Size = 10");
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbers10IS1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbers10IS2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbers10IS3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Insertion Sort " + average);
		
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbers10SS1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbers10SS2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbers10SS3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Selection Sort " + average);
		
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbers10QS1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbers10QS2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbers10QS3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Quick Sort " + average);
		
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbers10MSR1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbers10MSR2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbers10MSR3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Merge Sort Recursive " + average);
		
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbers10MSI1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbers10MSI2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbers10MSI3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Merge Sort Iterative " + average + "\n");
		
		//Testing the sorting algorithms for an array of 100 elements
		System.out.println("Array Size = 100");
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbers100IS1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbers100IS2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbers100IS3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Insertion Sort " + average);
		
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbers100SS1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbers100SS2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbers100SS3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Selection Sort " + average);
		
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbers100QS1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbers100QS2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbers100QS3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Quick Sort " + average);
		
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbers100MSR1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbers100MSR2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbers100MSR3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Merge Sort Recursive " + average);
		
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbers100MSI1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbers100MSI2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbers100MSI3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Merge Sort Iterative " + average + "\n");
		
		//Testing the sorting algorithms for an array of 1000 elements
		System.out.println("Array Size = 1000");
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbers1000IS1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbers1000IS2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbers1000IS3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Insertion Sort " + average);
		
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbers1000SS1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbers1000SS2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbers1000SS3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Selection Sort " + average);
		
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbers1000QS1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbers1000QS2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbers1000QS3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Quick Sort " + average);
		
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbers1000MSR1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbers1000MSR2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbers1000MSR3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Merge Sort Recursive " + average);
		
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbers1000MSI1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbers1000MSI2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbers1000MSI3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Merge Sort Iterative " + average + "\n");
		
		//Testing the sorting algorithms for an array of 100 elements which has a lot of duplicates
		System.out.println("Array Size = 1000 Duplicates");
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbers1000IS1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbers1000IS2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbers1000IS3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Insertion Sort " + average);
		
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbers1000DuplicatesSS1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbers1000DuplicatesSS2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbers1000DuplicatesSS3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Selection Sort " + average);
		
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbers1000DuplicatesQS1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbers1000DuplicatesQS2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbers1000DuplicatesQS3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Quick Sort " + average);
		
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbers1000DuplicatesMSR1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbers1000DuplicatesMSR2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbers1000DuplicatesMSR3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Merge Sort Recursive " + average);
		
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbers1000DuplicatesMSI1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbers1000DuplicatesMSI2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbers1000DuplicatesMSI3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Merge Sort Iterative " + average + "\n");
		
		//Testing the sorting algorithms for a nearly ordered array of 1000 elements
		System.out.println("Array = NearlyOrdered1000");
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbersNearlyOrdered1000IS1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbersNearlyOrdered1000IS2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbersNearlyOrdered1000IS3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Insertion Sort " + average);
		
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbersNearlyOrdered1000SS1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbersNearlyOrdered1000SS2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbersNearlyOrdered1000SS3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Selection Sort " + average);
		
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbersNearlyOrdered1000QS1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbersNearlyOrdered1000QS2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbersNearlyOrdered1000QS3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Quick Sort " + average);
		
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbersNearlyOrdered1000MSR1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbersNearlyOrdered1000MSR2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbersNearlyOrdered1000MSR3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Merge Sort Recursive " + average);
		
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbersNearlyOrdered1000MSI1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbersNearlyOrdered1000MSI2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbersNearlyOrdered1000MSI3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Merge Sort Iterative " + average + "\n");
		
		//Testing the sorting algorithms for a reversely sorted array of 1000 elements
		System.out.println("Array = Reverse1000");
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbersReverse1000IS1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbersReverse1000IS2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbersReverse1000IS3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Insertion Sort " + average);
		
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbersReverse1000SS1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbersReverse1000SS2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbersReverse1000SS3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Selection Sort " + average);
		
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbersReverse1000QS1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbersReverse1000QS2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbersReverse1000QS3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Quick Sort " + average);
		
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbersReverse1000MSR1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbersReverse1000MSR2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbersReverse1000MSR3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Merge Sort Recursive " + average);
		
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbersReverse1000MSI1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbersReverse1000MSI2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbersReverse1000MSI3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Merge Sort Iterative " + average + "\n");
		
		
		//Testing the sorting algorithms for an already sorted array with 1000 elements
		System.out.println("Array = Sorted1000");
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbersSorted1000IS1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbersSorted1000IS2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbersSorted1000IS3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Insertion Sort " + average);
		
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbersSorted1000SS1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbersSorted1000SS2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbersSorted1000SS3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Selection Sort " + average);
		
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbersSorted1000QS1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbersSorted1000QS2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbersSorted1000QS3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Quick Sort " + average);
		
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbersSorted1000MSR1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbersSorted1000MSR2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbersSorted1000MSR3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Merge Sort Recursive " + average);
		
		start1 = System.nanoTime();
		SortComparison.insertionSort(numbersSorted1000MSI1);
		end1 = System.nanoTime();
		difference1 = end1- start1;
		start2 = System.nanoTime();
		SortComparison.insertionSort(numbersSorted1000MSI2);
		end2 = System.nanoTime();
		difference2 = end2- start2;
		start3 = System.nanoTime();
		SortComparison.insertionSort(numbersSorted1000MSI3);
		end3 = System.nanoTime();
		difference3 = end3- start3;
		average = (difference1 + difference2 + difference3) / 3;
		System.out.println("Merge Sort Iterative " + average + "\n");
    	
    	
        //TODO: implement this method
    }

}

