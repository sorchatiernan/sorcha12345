import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2020
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
    	assertNull(SortComparison.mergeSortRecursive(emptyArray));
    	
    }

    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------
    @Test
    public void testInsertionSort()
    {
    	//test an array with one element
    	double [] singleArray = {1.5};	
    	double [] singleArraySorted = SortComparison.insertionSort(singleArray);
    	assertArrayEquals(singleArraySorted, singleArray, DELTA);

    	//tests a positive array
    	double [] positiveArray = {3.2, 8.9, 1.0, 11.4, 5.5};
    	double [] positiveArraySorted = SortComparison.insertionSort(positiveArray);
    	assertArrayEquals(positiveArray, positiveArraySorted, DELTA);

    	//test a negative array
    	double [] negativeArray = {-3.2, -8.9, -1.0, -11.4, -5.5};
    	double [] negativeArraySorted = SortComparison.insertionSort(negativeArray);
    	assertArrayEquals(negativeArray, negativeArraySorted, DELTA);

    	//tests an array with both negative and positive components
    	double [] mixedArray = {3.2, -8.9, 1.0, -11.4, -5.5};
    	double [] mixedArraySorted = SortComparison.insertionSort(mixedArray);
    	assertArrayEquals(mixedArray, mixedArraySorted, DELTA);

    }
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
        //TODO: implement this method
    }

}

