/*Exercise 5: Create a method to find the sum of the cubes of the digits of an n digit number*/
import java.util.Scanner;
class SumOfCubes
{
	public static void main(String args[])
	{
		int num;
		System.out.println("Enter a no. :- ");
		Scanner scan = new Scanner(System.in);
		num = scan.nextInt();
		System.out.println(calc(num));

	}
	public static int calc(int numb)
	{
		int temp = numb , rem , sum = 0;
		/*while(temp != 0)
		{
			++digits;
			temp = temp/10;
		}*/
		while(numb != 0)
		{
			rem = numb % 10;
			numb = numb / 10;
			rem = rem *rem *rem;
			sum = sum + rem;
		}
		return sum;
	}
}