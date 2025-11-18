
/*
Mitchell Levy
9-14-23
Assignment 2
CMPT 435 Algorithms and Analysis
 */

import java.util.Arrays;

public class Problem1 {

	public static int[] removeduplicates(int[] A)
	{	
		// Complete this method
		// Return a new array with all duplicates in A[] removed

		int n = A.length;                   // n is length of A
		int[] B = new int[n];				// Array B is now same size as A
		boolean duplicate = false;			// flag to check if there is a duplicate or not
		int current_index = 0;		        // index to keep track of where we are in the new array B

		for(int i = 0; i < n; i++)			// loop through every value in A
		{
			for(int j = i + 1; j < n; j++)	// loop through A again except for the first index
			{
				if (A[i] == A[j])			// check if there is a duplicate
				{
					duplicate = true;		// set flag
					break;					// we don't need to keep going, we found a duplicate, so break
				}
			}
			if(duplicate == false)			// if we did not find a duplicate
			{
				B[current_index] = A[i];	// put the value in the new array
				current_index++;			// keep track of which index we are on in B
			}
			else							// there was a duplicate
			{
				duplicate = false;			// reset flag and try go back to beginning of loop
			}
		}

		return Arrays.copyOf(B, current_index);	// returns copy of array with only values that were added to it
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Test removeduplicates()
		
		int[] testarray1 = {-5, 2, 3, 1, 2, 2, 1};

		System.out.println("Test 1: Array before removing duplicates: " + Arrays.toString(testarray1));
		System.out.println("The array after removing duplicates "+ Arrays.toString(removeduplicates(testarray1)));
		// expected output: {2, 1, 3, -5}	


		int[] testarray2 = {1, 1, 1, 2, 2, 2, 1};

		System.out.println("Test 2: Array before removing duplicates: " + Arrays.toString(testarray2));
		System.out.println("The array after removing duplicates "+ Arrays.toString(removeduplicates(testarray2)));
		// expected output: {1, 2}


		int[] testarray3 = {1, 3, 1, 2, 2, 2, 2};

		System.out.println("Test 3: Array before removing duplicates: " + Arrays.toString(testarray3));
		System.out.println("The array after removing duplicates "+ Arrays.toString(removeduplicates(testarray3)));
		// expected output: {1, 3, 2}

		int[] testarray4 = {1, 2, 3, 4, 5, -1, -2, 3, -4, -5};

		System.out.println("Test 4: Array before removing duplicates: " + Arrays.toString(testarray4));
		System.out.println("The array after removing duplicates "+ Arrays.toString(removeduplicates(testarray4)));
		// expected output: {1, 2, 3, 4, 5, -1, -2, -4, -5}
	}
}
