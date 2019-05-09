//Take a string from user at runtime and then check, print the number of vowels in the string
 import java.util.Scanner;
class Vowels
{
public static void main(String args[])
{
String s;
Scanner in = new Scanner(System. in);
System.out.println("Enter a string");
s = in.nextLine();
int vowels=0;
char ch;
int length = s.length();
	for(int i = 0; i < length; ++i)
        {
            ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
            {
                ++vowels;
            }
        }
        System.out.println("Vowels: " + vowels);
    }
}