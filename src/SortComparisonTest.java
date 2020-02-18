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
    	
    	
        //TODO: implement this method
    }

}

