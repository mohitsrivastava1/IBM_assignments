/*Exercise 6: Create a method that can accept an array of String objects and sort in alphabetical order.
 The elements in the left half should be completely in uppercase and the elements in the right half 
 should be completely in lower case. Return the resulting array.
Note: If there are odd number of String objects, then (n/2) +1 elements should be in UPPPERCASE
*/
import java.util.Scanner;
import java.util.Arrays;
class ArraySort
{
	public static void main(String args[])
	{
		String str;
		System.out.println("Enter a string :- ");
		Scanner scan = new Scanner(System.in);
		str = scan.nextLine();
		String result[] = work(str);
		for(int i = 0 ; i<result.length ; i++)
		{
		System.out.println(result[i]);
		}

	}
	public static String[] work(String s)
	{

		s.trim();
		String arr[]=s.split(" ");
		Arrays.sort(arr);
		int l = arr.length;
		if(l % 2 == 0)
		{
			for(int i = 0; i < l/2 ; i++)
			{
				arr[i] = arr[i].toUpperCase();
			}
			for(int i = l/2; i < l ; i++)
			{
				arr[i] = arr[i].toLowerCase();
			}
			return arr;

		}
		else
		{
			for(int i = 0; i < (l/2)+1 ; i++)
			{
				arr[i] = arr[i].toUpperCase();
			}
		
			for(int i = (l/2)+1; i < l ; i++)
			{
				arr[i] = arr[i].toLowerCase();
			}
			return arr;
		}


	}
}