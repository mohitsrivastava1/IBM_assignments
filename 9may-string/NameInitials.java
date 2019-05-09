//Write a program that computes your initials from your full name and displays them.

 import java.util.Scanner;
class NameInitials
{
public static void main(String args[])
{
String s;
Scanner in = new Scanner(System. in);
System.out.println("Enter your full name :-");
s = in.nextLine();

char ch;
int len = s.length();
System.out.print(s.charAt(0));
	for(int i = 0; i < len; ++i)
        {
            ch = s.charAt(i);
            if(ch == ' ')
            {
                System.out.print(s.charAt(i+1));
            }
        }
        
    }
}