
public class Problem3 {

	public static int squareroot(int x)
	{
		// given a positive integer x, return square root of x
		// if x is not a perfect square, return the floor of its square root
		// complete the method squareroot() here
		// O(log n) expected
		// Algorithms slower than O(logn) will be graded out of 10 points
		// feel free to change the return type or parameters

		int start = 1;  // start is the first index we are using to search
		int end = x;  // end is the last index we are using to search
		int mid;  // mid is the middle index we are using to search
		int prev = -1; // keeps track of previous index for first occurrence

		while(start <= end)
		{
			mid = (start + end) / 2;
			int guess = mid * mid;
			if(guess == x) // found the number
			{
				return mid;
			}
			else if (guess > x) // number is in first half
			{
				end = mid - 1; // get rid of second half
			}
			else // guess < x so, number is in second half
			{
				prev = mid; // save possible answer
				start = mid + 1; // get rid of first half
			}
		}
		return prev;
	}
	

	
	public static void main(String[] args) {
		// test your squareroot() method here

		System.out.println("Test 1:");

		int x1 = 9;
		int x2 = 5;
		int x3 = 17;
		System.out.println("The square root of " + x1 + " is " + squareroot(x1));
		// 3 expected
		System.out.println("The square root of " + x2 + " is " + squareroot(x2));
		// 2 expected
		System.out.println("The square root of " + x3 + " is " + squareroot(x3));
		// 4 expected

		System.out.println();
		System.out.println("Test 2:");

		int x4 = 1;
		int x5 = 3;
		int x6 = 101;
		int x7 = 144;
		System.out.println("The square root of " + x4 + " is " + squareroot(x4));
		// 1 expected
		System.out.println("The square root of " + x5 + " is " + squareroot(x5));
		// 1 expected
		System.out.println("The square root of " + x6 + " is " + squareroot(x6));
		// 10 expected
		System.out.println("The square root of " + x7 + " is " + squareroot(x7));
		// 12 expected
	}
}
