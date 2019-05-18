/*Exercise 11: Create a method to check if a number is an increasing number*/

import java.util.Scanner;
class IncreasingNumber
{
    public static void main(String args[])
    {
    	int num;
    	Scanner scan = new Scanner(System.in);
        
       
       	System.out.println("Enter a number : ");
       	num = scan.nextInt();
        
	       if(checkNumber(num))
	       {
	       	System.out.println("It is not an increasing number...");
	       }
	       else
	       {
	       	System.out.println("It is an increasing number...");
	       }
   }
   static boolean checkNumber(int n)
   {
       
       boolean flag = false;
        
       
       
       
       int currentDigit = n % 10;
       n = n/10;
        
       
       while(n>0)
       {
           
           if(currentDigit < (n % 10))
           {
               flag = true;
               break;
           }

           currentDigit = n % 10;
           n = n/10;
       }
        
      return flag;
    }
}
