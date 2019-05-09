//Write a Java program to check whether a given string ends with the contents of another string.

import java.util.Scanner;
class EndingWith
{
public static void main(String args[])
{
String s1,s2;
Scanner in = new Scanner(System. in);
System.out.println("Enter string 1 :-");
s1 = in.nextLine();
System.out.println("Enter string 2 :-");
s2 = in.nextLine();

System.out.println("Result :- "+s1.endsWith(s2));
}

}
