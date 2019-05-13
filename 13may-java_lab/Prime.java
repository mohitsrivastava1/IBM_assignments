//Exercise 3: Write a Java program that prompts the user for an integer and then prints out all the prime numbers up to that Integer?
import java.util.Scanner;
class Prime
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an Integer ...");
		int n = sc.nextInt();
		int p;
		//System.out.println("2");
		for(int i=2;i<=n;i++)
		{
			p=0;
			for(int j=2;j<i;j++)
			{
				if(i%j==0)
				p=1;
			}
			if(p==0)
				System.out.println(i);
		}
	}
}