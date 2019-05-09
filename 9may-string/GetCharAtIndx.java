//Write a Java program to get the character at the given index within the String.

import java.util.Scanner;
class GetCharAtIndx
{
public static void main(String args[])
{
String s;
Scanner in = new Scanner(System. in);
System.out.println("Enter the String :-");
s = in.nextLine();
System.out.println("Enter the index :-");
int i=in.nextInt();
System.out.println("The character is :-"+ s.charAt(i));   
}
}