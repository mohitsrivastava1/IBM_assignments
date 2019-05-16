/*Exercise 4: Write a program that replaces a particular word(taken at runtime) in a file*/
import java.io.*;
import java.util.Scanner;
class ReplaceWord
{   
    public static void main(String[] args) 
    {
         
    	String word,newWord;
        Scanner scan = new Scanner(System.in);
        
        
        System.out.print("Enter the word to be replaced : ");
        word = scan.nextLine();
        System.out.print("Enter the New Word : ");
        newWord = scan.nextLine();


        
         try
             {
             File file = new File("anotherFile.txt");
             BufferedReader br = new BufferedReader(new FileReader(file));
             String line = "", oldtext = "";
             while((line = br.readLine()) != null)
             {
                 oldtext += line + "\r\n";
             }
             br.close();

             String replacedtext  = oldtext.replaceAll(word, "" + newWord);
             
             FileWriter writer = new FileWriter("anotherFile.txt");
             writer.write(replacedtext);
        	System.out.print("Word Replaced !!!");


             writer.close();

         	}
         catch (IOException ioe)
            {
             ioe.printStackTrace();
         	}
     }
 }


        
        
        
