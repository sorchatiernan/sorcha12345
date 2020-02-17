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

		//todo: do experiments as per assignment instructions
	}

}//end class