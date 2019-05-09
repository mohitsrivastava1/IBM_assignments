//Write a Java program to test if a given string contains the specified sequence of char values.

import java.util.Scanner;
class ContainsSequence
{
public static void main(String args[])
{
String s1,s2;
Scanner in = new Scanner(System. in);
System.out.println("Enter string  :-");
s1 = in.nextLine();
System.out.println("Enter sequence :-");
s2 = in.nextLine();
System.out.println("Result :- "+ s1.contains(s2));
}
}
