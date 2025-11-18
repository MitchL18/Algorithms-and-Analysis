
public class Problem2 {

	public static int count(double[] A, double x)
	{
		// given a sorted array A, and a value x, return the number of times x occurs in A
		// complete the method count() here
		// O(log n) expected
		// Algorithms slower than O(logn) will be graded out of 10 points
		// feel free to change the return type or parameters

		int n = A.length;  // n is the length of the array
		int start = 0;  // start is the first index we are using to search
		int end = n - 1;  // end is the last index we are using to search
		int mid;  // mid is the middle index we are using to search
		int prev_first = -1; // keeps track of previous index for first occurrence
		int prev_last = -1; // keeps track of previous index for last occurrence

		// finds first index

		while(start <= end)
		{
			mid = (start + end) / 2;
			if(x == A[mid]) // found the number
			{
				prev_first = mid; // save what the mid was in case it is the first occurrence
				end = mid - 1; // get rid of second half
			}
			else if (x > A[mid]) // number is in second half
			{
				start = mid + 1; // get rid of first half
			}
			else // x < A[mid] so, number is in first half
			{
				end = mid - 1; // get rid of second half
			}
		}

		// find last occurrence of number

		start = 0;  // reset start and end
		end = n - 1;

		while(start <= end)
		{
			mid = (start + end) / 2;
			if(x == A[mid]) // found the number
			{
				prev_last = mid;  // save what the mid was in case it is the last occurrence
				start = mid + 1;  // get rid of first half
			}
			else if (x > A[mid])  // number is in second half
			{
				start = mid + 1;  // get rid of first half
			}
			else  // x < A[mid] so, number is in first half
			{
				end = mid - 1;  // get rid of second half
			}
		}

		if(prev_first == -1) // if number is not in list
		{
			return 0;
		}
		return prev_last - prev_first + 1; // calculate the number of times it shows up in list
	}
	

	
	public static void main(String[] args) {
		// test your count() method here

		System.out.println("Test 1:");

		double[] testarray = {1.3, 2.1, 2.1, 2.1, 2.1, 6.7, 7.5, 7.5, 8.6, 9.0};
		double t1 = 2.1;
		double t2 = 7.5;
		double t3 = 1.3;
		System.out.println(t1+" appears "+ count(testarray, t1) + " times");
		// 4 expected
		System.out.println(t2+" appears "+ count(testarray, t2) + " times");
		// 2 expected 
		System.out.println(t3+" appears "+ count(testarray, t3) + " times");
		// 1 expected

		System.out.println();
		System.out.println("Test 2:");

		double[] testarray2 = {6.3, 6.3, 6.3, 12, 12, 12, 12, 24.3, 24.3, 24.3, 24.3, 24.3, 141, 141};
		double tt1 = 6.3;
		double tt2 = 12;
		double tt3 = 24.3;
		double tt4 = 141;
		double tt5 = 6.27;
		System.out.println(tt1+" appears "+ count(testarray2, tt1) + " times");
		// 3 expected
		System.out.println(tt2+" appears "+ count(testarray2, tt2) + " times");
		// 4 expected
		System.out.println(tt3+" appears "+ count(testarray2, tt3) + " times");
		// 5 expected
		System.out.println(tt4+" appears "+ count(testarray2, tt4) + " times");
		// 2 expected
		System.out.println(tt5+" appears "+ count(testarray2, tt5) + " times");
		// 0 expected
	}

}
