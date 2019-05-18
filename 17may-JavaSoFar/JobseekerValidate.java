/*Exercise 4: You are asked to create an application for registering the details of jobseeker.
 The requirement is:Username should always end with _job and there should be at least minimum of 8 
 characters to the left of _job. Write a function to validate the same. 
 Return true in case the validation is passed. In case of validation failure return false.
*/
import java.util.Scanner;
import java.lang.String;
class JobseekerValidate
{
	public static void main(String args[])
	{
		String usrname;
		Scanner in = new Scanner(System. in);
		System.out.println("Enter username :- ");
		usrname=in.nextLine();
		if(validate(usrname))
		{
			System.out.println("Username Validated...");
		}
		else
		{
			System.out.println("Username not Validated...");
		}
	}
	public static boolean validate(String usrnm)
	{
		if(!(usrnm.endsWith("_job")))
		{
			return false;
		}
		else if((usrnm.length() - 4) < 8)
		{
			return false;
		}
		else return true;
	}
}