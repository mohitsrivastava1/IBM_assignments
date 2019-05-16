/* Exercise 1: Write a Java program that reads a file and displays the file on the screen, 
with a line number before each line? */
        
import java.util.Scanner;
import java.io.*;

class LineNumber
{
    public static void main(String[] input)
    {
        String fname;
        Scanner scan = new Scanner(System.in);
        
        /* enter filename with extension to open and read its content */
        
        System.out.print("Enter File Name to Open (with extension like file.txt) : ");
        fname = scan.nextLine();
        
        /* this will reference only one line at a time */
        
        String line = null;
        try
        {
            /* FileReader reads text files in the default encoding */
            FileReader fR = new FileReader(fname);
            
            /* always wrap the FileReader in BufferedReader */
            BufferedReader bR = new BufferedReader(fR);
            int count=0;
            while((line = bR.readLine()) != null)
            {
                System.out.println(++count + ") "+line);
            }
            
            /* always close the file after use */
            bR.close();
        }
        catch(IOException ex)
        {
            System.out.println("Error reading file named '" + fname + "'");
        }
    }
}