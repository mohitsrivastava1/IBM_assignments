/*Exercise 9: Create a class with a method which can calculate the 
sum of first n natural numbers which are divisible by 3 or 5.*/

import java.util.Scanner;
class SumNaturalNumbers
{
	public static void main(String[] args)
	{
	  	int  result=calculateSum();
	  	System.out.println("Result :- " +result);
	}

 	public static int calculateSum()
 	{
	  	Scanner scan = new Scanner(System.in);
	  	System.out.println("Enter the input number :- ");
	  	int n = scan.nextInt();
	  	int sum=0;
	    for(int i=1; i<=n;i++)
	    {
	    	if((i%3)==0 || (i%5)==0)
	    	{
	          	sum=sum+i;
	        }
	    }
	    return sum;
	}
	 
}
