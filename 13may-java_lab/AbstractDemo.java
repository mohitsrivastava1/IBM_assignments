abstract class Item

{

	public abstract int id_getter();

	public abstract void id_setter(int id);

	public abstract int cpoies_getter();

	public abstract void copies_setter(int copies);

	public abstract String title_getter();

	public abstract void title_setter(String title);

	public abstract void check_in();

	public abstract void check_out();

	public abstract void print();

}



class Library extends Item

{

	private int identification_number, number_of_copies;

	private String title, check_in_date, check_out_date;



	Library( int identification_number, int number_of_copies, String title)

	{

		this.identification_number = identification_number;

		this.number_of_copies = number_of_copies;

		this.title = title;

	}



	public int id_getter(){

		return identification_number;

	}

	public void id_setter(int id)

	{

		identification_number = id;

	}

	public int cpoies_getter()

	{

		return number_of_copies;

	}

	public void copies_setter(int copies)

	{

		number_of_copies = copies;

	}

	public String title_getter()

	{

		return title;

	}

	public void title_setter(String title)

	{

		this.title = title;

	}

	public void check_in()

	{

		System.out.println("Checked In");

	}

	public void check_out()

	{

		System.out.println("Checked Out");

	}



	public void print()

	{

		System.out.println("Enter your choice to print:");

		System.out.println("1. Title \n 2. Number of copies \n 3. Identification Number");

		java.util.Scanner sc = new java.util.Scanner(System.in);

		int choice = sc.nextInt();

		switch(choice)

		{

			case 1: System.out.println("Title: "+title); break;

			case 2: System.out.println("Number of copies: "+number_of_copies); break;

			case 3: System.out.println("Identification Number: "+identification_number); break;

			default: System.out.println("Enter appropriate choice");

		}



	}

} 





class WrittenItem extends Item{

	private int identification_number, number_of_copies;

	private String title; 

	String author_name;





	WrittenItem( int identification_number, int number_of_copies, String title, String author_name)

	{

		this.identification_number = identification_number;

		this.number_of_copies = number_of_copies;

		this.title = title;

		this.author_name = author_name;

	}



	public String get_author_name(){

		return author_name;

	}

	public void set_author_name(String author_name)

	{

		this.author_name = author_name;

	}	



	public int id_getter(){

		return identification_number;

	}

	public void id_setter(int id)

	{

		identification_number = id;

	}

	public int cpoies_getter()

	{

		return number_of_copies;

	}

	public void copies_setter(int copies)

	{

		number_of_copies = copies;

	}

	public String title_getter()

	{

		return title;

	}

	public void title_setter(String title)

	{

		this.title = title;

	}

	public void check_in()

	{

		System.out.println("Checked In");

	}

	public void check_out()

	{

		System.out.println("Checked Out");

	}



	public void print()

	{

		System.out.println("Enter your choice to print:");

		System.out.println("1. Title \n 2. Number of copies \n 3. Identification Number");

		java.util.Scanner sc = new java.util.Scanner(System.in);

		int choice = sc.nextInt();

		switch(choice)

		{

			case 1: System.out.println("Title: "+title); break;

			case 2: System.out.println("Number of copies: "+number_of_copies); break;

			case 3: System.out.println("Identification Number: "+identification_number); break;

			default: System.out.println("Enter appropriate choice");

		}



	}

}



class Books extends WrittenItem

{

	Books(int identification_number, int number_of_copies, String title, String author_name)

	{

		super(identification_number, number_of_copies, title, author_name);

	}

}



class Journal extends WrittenItem

{

	private String year_published;



	Journal(int identification_number, int number_of_copies, String title, String author_name, String year_published)

	{

		super(identification_number, number_of_copies, title, author_name);

		this.year_published = year_published;

	}



	public String get_year_published(){

		return year_published;

	}

	public void set_year_published(String year_published)

	{

		this.year_published = year_published;

	}	



}



class AbstractDemo

{

	public static void main(String[] args) {

		Library l =new Library(101,60,"Wings of fire");

		l.print();

		WrittenItem wi = new WrittenItem(101,60,"Wings of fire","Abdul Kalam");

		System.out.println(wi.get_author_name());

	}

}