/*Exercise 1: Write a Java program that reads a line of integers and then displays
 each integer and the sum of all integers. (Use StringTokenizer class)?*/
import java.util.*;
 
class SumIntegerTokenizer
{
    public static void main(String args[])
    {
        int n;
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter integers with one space gap:");
        String s = sc.nextLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        while (st.hasMoreTokens())
        {
            String temp = st.nextToken();
            n = Integer.parseInt(temp);
            System.out.println(n);
            sum = sum + n;
        }
        System.out.println("sum of the integers is: " + sum);
        sc.close();
    }
}