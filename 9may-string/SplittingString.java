//Develop your own version of split()
import java.lang.String;
class SplittingString
{
	 public static void main(String[] args) 
	{
	 	String str="Thiss aissan myississnissa cariss";
	 	
	 	String delim="iss";
	 	
		int ld=delim.length();
		//For adding (ld-1) white spaces at the end of string to make it print completely, otherwise last (ld-1)character/s wasn't printing.
	 	for(int i=0 ; i<(ld-1) ; i++)
			{
			str=str+" ";
			//System.out.println(str);
		}
	 	SplittingString obj = new SplittingString();
	 	obj.mySplit(str,delim);
	 	//System.out.println("The splitted string is : - "+ res);
	}

	void mySplit(String s , String d)
	{

		int ls=s.length();
		int ld=d.length();
		
		
		
		for(int i = 0 ; i < ls-ld+1 ; i++)
		{ 
			String strTemp="";
			for(int j = i ; j < i+ld ; j++)
			{

				strTemp = strTemp + s.charAt(j);
				//System.out.print(strTemp);
			}
			if(strTemp.equals(d))
			{
				System.out.print(" '"+ strTemp +"' ");
				strTemp="";
				i=i+ld-1;

			}
			else
			{
				System.out.print(s.charAt(i));
				strTemp="";

			}
		}
		System.out.println();
	}
}