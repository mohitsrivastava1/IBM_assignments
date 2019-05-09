//Take a string from user at runtime and then check, print whether the string entered is a palindrome or not
import java.util.Scanner;
class Palindrome
{
public static void main(String args[])
{
String s;
Scanner in = new Scanner(System. in);
System.out.println("Enter a string");
s = in.nextLine();
int length = s.length();
String rev="";
 
      for ( int i = length - 1; i >= 0; i-- )
         rev = rev + s.charAt(i);
 
      if (s.equalsIgnoreCase(rev))
         System.out.println(s+" is a palindrome");
      else
         System.out.println(s+" is not a palindrome");

}
}