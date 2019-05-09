//Take a string from user at runtime and then print it's reverse
import java.util.Scanner;
class Reverse
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
 
      System.out.println("Reversed string is :- "+ rev);

}
}