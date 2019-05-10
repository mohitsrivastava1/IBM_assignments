 // An anagram is a word or a phrase made by transposing the letters of another word or phrase;
 //  for example, "parliament" is an anagram of "partial men," and "software" is an anagram of "swear oft."
 //   Write a program that figures out whether one string is an anagram of another string.
 //    The program should ignore white space and punctuation.
import java.lang.String;
class Anagram
{
	 public static void main(String[] args) 
	{
	 	String str1="software";
	 	String str2="swear oft";
		str1=str1.toLowerCase();
		str2=str2.toLowerCase();
		str1=str1.trim();
		str2=str2.trim();

		//converting punctuations into white spaces.
		str1=str1.replace(',',' ');
		str2=str2.replace(',',' ');
		char arr1[]=str1.toCharArray();
		char arr2[]=str2.toCharArray();

		//Bubble Sorting arr1
		int l1 = arr1.length;
        for (int i = 0; i < l1-1; i++)
            for (int j = 0; j < l1-i-1; j++)
                if (arr1[j] > arr1[j+1])
                {
                    // swap temp and arr[i]
                    char temp = arr1[j];
                    arr1[j] = arr1[j+1];
                    arr1[j+1] = temp;
                }


        //Bubble Sorting arr2
        int l2 = arr2.length;
        for (int i = 0; i < l2-1; i++)
            for (int j = 0; j < l2-i-1; j++)
                if (arr2[j] > arr2[j+1])
                {
                    // swap temp and arr[i]
                    char temp = arr2[j];
                    arr2[j] = arr2[j+1];
                    arr2[j+1] = temp;
                }
        str1="";str2="";
        //Converting character arrays to strings.
        for(int i=0; i<arr1.length; i++)
        {
        	str1=str1+arr1[i];
        }

        for(int i=0; i<arr2.length; i++)
        {
        	str2=str2+arr2[i];
        }

        //Removing white spaces in strings.
        str1=str1.trim();
        str2=str2.trim();

        if(str1.equals(str2))
        	System.out.println("Strings are anagram !!!");
        else
        	System.out.println("Strings are not an anagram !!!");

	}
}
