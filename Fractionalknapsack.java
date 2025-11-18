
/*
Mitchell Levy
CMPT 435 Algorithms and Analysis
Assignment 8
11-16-23
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Fractionalknapsack {
	
	
	
	public static void sortitems(ArrayList<item> svd)
	{
		
		// Sort items by value to size ratio in descending order
		Collections.sort(svd, new Comparator<item>(){
		     public int compare(item o1, item o2){
		         if(o1.density == o2.density)
		             return 0;
		         return o1.density > o2.density ? -1 : 1;
		     }
		});
		
		
	}
	
	
	public static double greedyfractionalknapsack(ArrayList<item> svd, int S){
		// Complete code here to maximize the value of items in the knapsack
		// Input: items in list svd are sorted by density already
		// Output: the value of the knapsack
				
		double value = 0; // how much money we have in the bag
		double sizeLeft = S; // how much room we have left in the bag

		for(int i = 0; i < svd.size(); i++) // go through each item
		{
			double itemSize = svd.get(i).size; // get size of current item
			if(itemSize <= sizeLeft) // if there is room for entire item
			{
				sizeLeft = sizeLeft - itemSize; // put it in the bag
				value = value + svd.get(i).value; // update value
			}
			else // last item that is going in bag, after it will break.
			{
				double fraction = sizeLeft / itemSize; // find how much of a fraction we can take
				value = value + (fraction * svd.get(i).value); // take fraction of value
				break;
			}
		}
		return value;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		int max_qty,n;  
         
        Scanner reader = new Scanner(System.in);
         
        System.out.println("Enter no of items");  
        n=reader.nextInt(); 
        ArrayList<item> items=new ArrayList();
 
        
        for(int i=0;i<n;i++)  
        {    
        	System.out.println("Enter the size of item "+ (i+1)); 
        	int s =reader.nextInt();    
        	System.out.println("Enter the value of item "+ (i+1));
            double v =reader.nextDouble();
            item newitem = new item(v,s,(i+1));
            items.add(newitem);
        }
        
 
        System.out.println("Enter maximum volume of knapsack :");  
        max_qty=reader.nextInt();  
 
        greedyfractionalknapsack(items, max_qty);

*/
		int max_qty,n;
	      
        ArrayList<item> items=new ArrayList();
		// item 1, value 6, size 1
        items.add(new item(6,1,1));
		// item 2, value 10, size 2
		items.add(new item(10,2,2));
		// item 3, value 12, size 3
		items.add(new item(12,3,3));
		// the size of your knapsack
        max_qty=5;  
		// sort items by value to size ratio
		sortitems(items);

		System.out.println("Test 1:");
        System.out.println("The maximum value we can place into the knapsack is "+ greedyfractionalknapsack(items, max_qty));
		System.out.println();


		ArrayList<item> items2=new ArrayList();
		// item 1, value 6, size 1
		items2.add(new item(6,2,1));
		// item 2, value 10, size 2
		items2.add(new item(10,2,2));
		// item 3, value 12, size 3
		items2.add(new item(12,3,3));
		// item 4, value 12, size 3
		items2.add(new item(8,1,4));
		// the size of your knapsack
		max_qty=7;
		// sort items by value to size ratio
		sortitems(items2);

		System.out.println("Test 2:");
		System.out.println("The maximum value we can place into the knapsack is "+ greedyfractionalknapsack(items2, max_qty));
		System.out.println();


		ArrayList<item> items3=new ArrayList();
		// item 1, value 6, size 1
		items3.add(new item(10,5,1));
		// item 2, value 10, size 2
		items3.add(new item(9,3,2));
		// item 3, value 12, size 3
		items3.add(new item(12,3,3));
		// item 4, value 12, size 3
		items3.add(new item(12,2,4));
		// the size of your knapsack
		max_qty=7;
		// sort items by value to size ratio
		sortitems(items3);

		System.out.println("Test 3:");
		System.out.println("The maximum value we can place into the knapsack is "+ greedyfractionalknapsack(items3, max_qty));
		System.out.println();
}
	
	
}
