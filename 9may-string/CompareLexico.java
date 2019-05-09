//Write a java program to compare two strings lexicographically, ignoring case differences

import java.util.Scanner;
class CompareLexico
{
public static void main(String args[])
{
String s1,s2;
Scanner in = new Scanner(System. in);
System.out.println("Enter string 1 :-");
s1 = in.nextLine();
System.out.println("Enter string 2 :-");
s2 = in.nextLine();

int result = s1.compareToIgnoreCase(s2);
        if(result<0)
        {
        	System.out.println(s1 + " is less than "+s2);
        }
        else if(result==0)
        {
        	System.out.println(s1 + " is equal to " + s2);
        }
        else
        {
        	System.out.println(s1 + " is greater than "+ s2);
        }
    }
}