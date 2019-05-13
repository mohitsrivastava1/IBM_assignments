//Exercise 5:  Validate the age of a person and display proper message by using user defined exception. Age of a person should be above 15.

import java.util.Scanner;
class MyExcept extends Exception
{
     
    MyExcept(String a)
    {
        super(a);
    }
 
}
class ValAge
{
public static void main(String args[])throws MyExcept
{
Scanner in = new Scanner(System. in);
System.out.print("Enter your Age :- ");
int ag = in.nextInt();

	if(ag < 15)
	{
		 throw new MyExcept("Your age is not valid...");
	}
	else
	{
		System.out.print("Your age is :- "+ag);
	}


}
}
