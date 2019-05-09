// Create a program that is similar to the previous one but has the following differences:
// Instead of reading integer arguments, it reads floating-point arguments.
// It displays the sum of the arguments, using exactly two digits to the right of the decimal point.
// For example, suppose that you enter the following:
// java CalculateAdd 10.100 30.0 4.502
// The program would display 44.60.
class CmdLineFloat
{

	public static void main(String... args)
	{

		if(args.length <= 1)	{

			System.out.println("Error!!!");

			return;

		}

		//int sum=0;

		float decimalSum=0.0f;

		for(int i=0; i<args.length; ++i)	{

			float tempFloat = Float.parseFloat(args[i]);

			//sum += (int)tempFloat;

			decimalSum += tempFloat; //- (int)tempFloat;

		}

		System.out.printf("Sum is: %.2f",  decimalSum);

	}

}