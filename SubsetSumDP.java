
/*
Mitchell Levy
CMPT 435 Algorithms and Analysis
Assignment 10
12-7-23
 */

import java.util.Arrays;

public class SubsetSumDP {
	
	public static boolean subsetSum(int[] A, int x)
	{

		boolean[][] Sum = new boolean[A.length + 1][x + 1];
		// Complete the function from here
		// Feel free to change the return type and parameters
		// Implement the dynamic programming Subset Sum Algorithm
		// Return true if there exists a subset in A with sum = x
		// Hint: Follow the pseudocode of subsetSum in the slides

		for (int i = 0; i <= A.length; i++)
		{
			Sum[i][0] = true; // if sum is zero true (makes first column all true)
		}

		for (int j = 1; j <= x; j++)
		{
			Sum[0][j] = false; // if sum is not zero but subset is empty (makes most of row 1 false)
		}

		for (int i = 1; i <= A.length; i++) // use the two for loops fill in entire graph
		{
			for(int j = 1; j <= x; j++)
			{
				if(A[i - 1] > j) // if this condition is true
				{
					Sum[i][j] = Sum[i - 1][j]; // use this formula
				}
				else // if the condition is not true
				{
					Sum[i][j] = (Sum[i - 1][j] || Sum[i-1][j - A[i - 1]]);
					// use recurrence equation to find sum = j by including or excluding A[i - 1]
				}
			}
		}
		for (int n = 0 ; n < Sum.length ; n++)
		{
			System.out.println((Arrays.toString(Sum[n])));
		}
		return Sum[A.length][x];
	}

	public static void main(String[] args) {

		// Test 1
		int[] A = {1,3,5,2,8};
		
		int x = 9;

		System.out.println("Test 1: ");
		System.out.println("There exists a subset in A[] with sum = " + x + " : " + subsetSum(A, x) );
		// Expected output: true
		System.out.println();


		// Test 1
		int[] A1 = {1, 3, 5, 11};

		int x1 = 6;

		System.out.println("Test 75675656: ");
		System.out.println("There exists a subset in A1[] with sum = " + x1 + " : " + subsetSum(A1, x1) );
		// Expected output: true
		System.out.println();


		// Test 2
		int[] B = {6,3,5};

		int y1 = 10;
		int y2 = 11;

		System.out.println("Test 2: ");
		System.out.println("There exists a subset in B[] with sum = " + y1 + " : " + subsetSum(B, y1) );
		// Expected output: false
		System.out.println("There exists a subset in B[] with sum = " + y2 + " : " + subsetSum(B, y2) );
		// Expected output: true
		System.out.println();

		// Test 3
		int[] C = {12, 4, 2};

		int z1 = 6;
		int z2 = 36;
		int z3 = 16;

		System.out.println("Test 3: ");
		System.out.println("There exists a subset in C[] with sum = " + z1 + " : " + subsetSum(C, z1) );
		// Expected output: true
		System.out.println("There exists a subset in C[] with sum = " + z2 + " : " + subsetSum(C, z2) );
		// Expected output: false
		System.out.println("There exists a subset in C[] with sum = " + z3 + " : " + subsetSum(C, z3) );
		// Expected output: true
		System.out.println();
	}

}
