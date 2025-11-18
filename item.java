
/*
Mitchell Levy
CMPT 435 Algorithms and Analysis
Assignment 16
11-13-23
 */


public class item {
	public int id;
	public double value;
	public int size;
	public double density;
	
	
	public item(double givenvalue, int givensize, int givenid)
	{
		id = givenid;
		
		size = givensize;
		
		value = givenvalue;
		
		density = value/size;
	}
	

}