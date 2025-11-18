
/*
Mitchell Levy
CMPT 435 Algorithms and Analysis
Assignment 8
11-16-23
 */


import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Coinchange {

	public static int greedycoinchange(int givenvalue, int[] givencoins)
	{
		
		// Complete the code here to make change of givenvalue using coins in the array givencoins
		// Minimize the number of coins used
		// Input: Coin denominations in array givencoins are already sorted in descending order
		// Output: The number of coins used to make change of givenvalue		

		int s = givenvalue; // change we are trying to make
		int[] arr; // holds values of how many of each coin that we need
		arr = new int[givencoins.length]; // needs to be same length as amount of coins we were given
		for(int i = 0; i < arr.length; i++) // go through each type of coin
		{
			while(s >= givencoins[i]) // while there is still room enough to keep using current coin
			{
				s = s - givencoins[i]; // use current coin once and reduce our target by coin amount
				arr[i]++; // increase value of how many coins we used by one
			}
		}

		int sum = 0; // how many coins we used
		for(int j = 0; j < arr.length; j++) // goes through array of the amount of coins used
		{
			sum = sum + arr[j]; // adds up the amount of each coin used
		}
		return sum; // gives the total amount of coins used
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 0; // n cents
		
		Scanner reader = new Scanner(System.in);  
		
		System.out.println("Please enter the value you want to make change: ");
		
		n = reader.nextInt();
		
		int[] coins = {10, 5, 1};
		// Add various denominations to test the program
		
		System.out.println("used "+ greedycoinchange(n, coins)+" coins for "+ n + " cents");


		System.out.println("Please enter the value you want to make change: ");

		n = reader.nextInt();

		int[] coins2 = {25, 10, 5, 1};
		// Add various denominations to test the program

		System.out.println("used "+ greedycoinchange(n, coins2)+" coins for "+ n + " cents");
	}

}
