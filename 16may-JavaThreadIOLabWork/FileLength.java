/*Exercise 3: Write a Java program that reads on file name from the user, 
then displays information about whether the file exists, 
whether the file is readable, whether the file is writable, 
the type of file and the length of the file in bytes?  */
import java.io.*;
import java.util.Scanner;
class FileLength 
{   
    public static void main(String[] args) 
    {

        try
        {
         
    	String fname;
        Scanner scan = new Scanner(System.in);
        
        /* enter filename with extension to open and read its content */
        
        System.out.print("Enter File Name (with extension like file.txt) : ");
        fname = scan.nextLine();
        File f1 = new File(fname);
        
        
        

        System.out.println("This file :"+(f1.exists()?"Exists":"Does not exists"));
        System.out.println("Is Readable:"+f1.canRead());
        System.out.println("IS Writable:"+f1.canWrite());
        System.out.println("Is file:"+f1.isFile());
        System.out.println("File Size:"+f1.length()+"bytes");

    	}
            catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        
    }   
}