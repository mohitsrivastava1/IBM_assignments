// Create a program that reads an unspecified number of integer arguments from the command line and adds them together.
// For example, suppose that you enter the following:
//java Calculate 1 3 2 10
//The program should display 16 and then exit. The program should display an error message if the user enters only one argument.
class CmdLineAdd
{
	public static void main(String args[])	{

		if(args.length <= 1)	{

			System.out.println("error !!!");

			return;

		}

		int sum=0;

		for(int i=0; i<args.length; ++i)	{

			sum += Integer.parseInt(args[i]);

		}



		System.out.println("Sum is: " + sum);

	}
}