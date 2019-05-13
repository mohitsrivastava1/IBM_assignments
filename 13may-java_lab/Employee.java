/*Exercise 6:  Create an Exception class named as EmployeeException (User defined Exception) in a package named as com.cg.eis.exception
and throw an exception if salary of an employee is below than 3000.
 Use Exception Handling mechanism to handle exception properly.*/
import java.util.Scanner;
import com.cg.eis.exception.EmployeeException;

class Employee
{
public static void main(String args[])throws EmployeeException
{
Scanner in = new Scanner(System. in);
System.out.print("Enter your Salary :- ");
int sal = in.nextInt();

	if(sal < 3000)
	{
		 throw new EmployeeException("Your salary is lesser than expected...");
	}
	else
	{
		System.out.print("Your salary is :- "+sal);
	}


}
}
