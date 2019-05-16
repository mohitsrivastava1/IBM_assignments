/*Exercise 5: Write a program to do the following operations using Thread:
	Create an user defined Thread class called as CopyDataThread .java .
	This class will be designed to copy the content from one file source.txt  to
 another file target.txt and after every 10 characters copied,   10 characters are copied 
 message  will be shown to user.(Keep delay of 5 seconds after every 10 characters  read.)
	Create another class FileProgram.java which will create above thread.
 Pass required File Stream classes to  CopyDataThread constructor and implement the above functionality.
*/

import java.io.*;
class FileProgram

{

	public static void main(String[] args) 

	{

		File s = new File("Source.txt");

		File t = new File("Target.txt");

		CopyDataThread copy = new CopyDataThread(s,t);

		copy.start();

	}

}



class CopyDataThread extends Thread

{

	File s,t;

	CopyDataThread(File s, File t)

	{

		this.s = s;

		this.t = t;

	}


	@Override
	public void run()

	{

		try{

			

			String contents ="";

			int numberofChars = 0; 

			int value = 0;

			FileInputStream in = new FileInputStream(s);

            while((value = in.read())!=-1)

            {

            	contents = contents + (char)value;

                ++numberofChars;

                if(numberofChars == 10)

                {

                	System.out.println("10 characters copied :- " + contents);

                	numberofChars = 0;

                	Thread.sleep(5000);

                }

            }



            BufferedWriter bw = new BufferedWriter(new FileWriter(t));

    		bw.write(contents);

    		bw.flush();

			bw.close(); 

		}catch(Exception e)

		{

			System.out.println("Exception is : "+e);

		}

	}

}