/*Exercise 8: Create a method which accepts an array of integer elements and
 return the second smallest element in the array*/
 import java.util.*;
 import java.util.Arrays;

 class SecondSmallestElement
 {
 	public static void main(String[] args)
 	{
  		
  		int arr1[]=getSecondSmallest();
        System.out.println("Second Smallest Element is :- " +arr1[1]);
 	}

 	public static int[] getSecondSmallest()
 	{
 		System.out.println("Enter the size of array :- ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n ; i++)
		{
			System.out.println("Enter the element in array :- ");
			arr[i] = scan.nextInt();

		}
    	Arrays.sort(arr);
    	return arr;
   	}
 
}
