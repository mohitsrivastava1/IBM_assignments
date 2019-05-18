/*Exercise 12: Create a method to check if a number is a power of two or not*/
import java.util.Scanner;

class PowerOfTwo
{
static boolean checkNumber(int n) 
{ 
    if(n==0) 
    return false; 
  
	return (int)(Math.ceil((Math.log(n) / Math.log(2)))) == (int)(Math.floor(((Math.log(n) / Math.log(2))))); 
} 
  
 
public static void main(String[] args) 
{ 
	int num;
    Scanner scan = new Scanner(System.in);
        
       
    System.out.println("Enter a number : ");
    num = scan.nextInt();
    if(checkNumber(num)) 
    System.out.println("It is a power of two..."); 
    else
    System.out.println("It is not a power of two..."); 
      
    
} 
}