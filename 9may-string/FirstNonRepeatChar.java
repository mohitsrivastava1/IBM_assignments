//Write a Java program to find first non repeating character in a string.
class FirstNonRepeatChar
{
    public static void main(String[] args)
    {
      String s = "ffeeddbbaaclck";
      for (char c : s.toCharArray())
      {
          if (s.indexOf(c) == s.lastIndexOf(c))
          {
              System.out.println("First non repeated characted in String "+ s + " is:" + c);
              break;
          }
      }
    }
}
