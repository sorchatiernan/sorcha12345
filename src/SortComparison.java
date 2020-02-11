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
		return null;
		//todo: implement the sort

	}//end selectionsort

	/**
	 * Sorts an array of doubles using Quick Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double [] quickSort (double a[]){
		return null;
		//todo: implement the sort

	}//end quicksort

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
		return null;
		//todo: implement the sort

	}//end mergesortIterative



	/**
	 * Sorts an array of doubles using recursive implementation of Merge Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a: An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted order.
	 */
	static double[] mergeSortRecursive (double a[]) {
		return null;

		//todo: implement the sort

	}//end mergeSortRecursive







	public static void main(String[] args) {

		//todo: do experiments as per assignment instructions
	}

}//end class