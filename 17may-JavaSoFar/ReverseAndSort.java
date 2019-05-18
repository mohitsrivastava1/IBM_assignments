/*Create a method which accepts an integer array, reverse the numbers in the 
array and returns the resulting array in sorted order*/
import java.util.Scanner;
import java.lang.String;
import java.lang.StringBuilder;
import java.util.Arrays;


class ReverseAndSort
{
	public static void main(String args[])
	{
		int result[] = getSorted();
		System.out.println("The result is :- ");
		for(int i = 0 ; i<result.length ; i++)
		{
		System.out.println(result[i]);
		}
	}
	public static int[] getSorted()
	{
		System.out.println("Enter the size of array :- ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		String str;
		for(int i = 0; i < n ; i++)
		{
			System.out.println("Enter the element in array :- ");
			arr[i] = scan.nextInt();

		}
		
		for(int i = 0; i < n ; i++)
		{
			//arr[i] = scan.nextInt();
			str = String.valueOf(arr[i]);
			//System.out.println(str);
			StringBuilder sb = new StringBuilder();
			sb.append(str);
			sb = sb.reverse();
			//str = sb.toString();
			arr[i] = Integer.parseInt(sb.toString());
		}
		Arrays.sort(arr);
		return arr;

	}
}