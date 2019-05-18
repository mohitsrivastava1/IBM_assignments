/*Exercise 10: Create a class with a method to find the difference
 between the sum of the squares and the square of the
  sum of the first n natural numbers.*/

import java.util.Scanner;
import java.lang.Math;

class SquareAndSum
{
	public static void main(String s[]) 
	{ 
	    Scanner scan = new Scanner(System.in);
	  	System.out.println("Enter the input number :- ");
	  	int n = scan.nextInt(); 
	    System.out.println("Result is :- " + calculateDifference(n));      
	      
	} 
  
static int calculateDifference(int n){ 
  
int l, k, m; 
    // Sum of the squares of the 
    // first n natural numbers is 
    l = (n * (n + 1) * (2 * n + 1)) / 6; 
      
    // Sum of n naturals numbers 
    k = (n * (n + 1)) / 2; 
  
    // Square of k 
    k = k * k; 
      
    // Differences between l and k 
    m = Math.abs(l - k); 
      
    return m; 
  
} 
}  