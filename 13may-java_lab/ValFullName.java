//Exercise 4: Write a Java Program to validate the full name of an employee. Create and throw a user defined exception if firstName and lastName is blank.
import java.util.Scanner;
class MyExcep extends Exception
{
     
    MyExcep(String str)
    {
        super(str);
    }
 
}
class ValFullName
{
public static void main(String args[])throws MyExcep
{
String fn,ln;
Scanner in = new Scanner(System. in);
System.out.print("Enter your First Name :- ");
fn = in.nextLine();
System.out.print("Enter your Last Name :- ");
ln = in.nextLine();

	if(fn.equals("") || ln.equals(""))
	{
		 throw new MyExcep("You have not entered the full name ...");
	}
	else
	{
		System.out.print("Your full name is :- "+fn +" "+ln);
	}


}
}
