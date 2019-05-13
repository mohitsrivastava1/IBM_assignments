// Exercise 1: Write a java program that simulates a traffic light.
// The program lets the user select one of three lights: red, yellow, or green with radio buttons.
// On entering the choice, an appropriate message with stop or ready or go should appear in the console .
// Initially there is no message shown
import java.util.Scanner;
class TrafficLight
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter either 1 for Red or 2 for Yellow or 3 for Green.");
		int n = sc.nextInt();
		if(n == 1)
		{

		System.out.println("Stop !!!");
		}
		else if(n == 2)
		{

		System.out.println("Ready !!!");
		}
		else if(n == 3)
		{
			System.out.println("Go !!!");
		}
		else
		{
			System.out.println("Wrong Input !!!");
		}
	}
}