//Write a Java program to replace all the 'r' characters with 't' characters in a string.

import java.util.Scanner;
class ReplaceR
{
public static void main(String args[])
{
String s1,s2;
Scanner in = new Scanner(System. in);
System.out.println("Enter string 1 :-");
s1 = in.nextLine();
s2=s1.replace('r','t');

System.out.println("Result :- "+s2);
}

}
