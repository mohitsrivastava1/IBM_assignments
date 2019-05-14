// 1. Enter a new Laptop
// 2. View All Laptop Details
// 3. Search for a Laptop: By (Id, Brand, Ram Size, Hdd Size)
// 4. Delete a Laptop : By(ID)
// 5. Update Laptop Details : 
import java.util.Scanner;
import java.util.ArrayList;
class Laptop
{
    private Integer id, ramSize, hddSize;
    private String brand;
 
    Laptop(int id, int ramSize, int hddSize, String brand )
    {
        this.id = id;
        this.ramSize = ramSize;
        this.hddSize = hddSize;
        this.brand = brand;
    }
 
    //Creating the getters
    public Integer getId(){
        return this.id;
    }
    public Integer getRamSize(){
        return this.ramSize;
    }
 
    public Integer getHddSize(){
        return this.hddSize;
    }
 
    public String getBrand(){
        return this.brand;
    }

    
    public void setRamSize(int ramSize){
        this.ramSize = ramSize;
    }
 
    public void setHddSize(int hddSize){
        this.hddSize = hddSize;
    }
 
    public void setBrand(String brand){
        this.brand = brand;
    }
}
 
class LaptopAPIUsingCollections
{
    public static void main(String[] args)
    {
 
        ArrayList list = new ArrayList();
        Scanner sc = new Scanner(System.in);
        int n=0;
        do
        {
            System.out.println("Enter '1' for Adding a new laptop,\n '2' for Viewing all laptop details,\n '3' for Searching a laptop,\n '4' for Deleting a laptop,\n '5' for Updating laptop details and\n '6' for exit :- ");
            n = sc.nextInt();
            switch(n)
            {
                case 1: System.out.println("Enter the laptop id, RAMsize, HDDsize, Brand respctively :- ");
                int i = sc.nextInt();
                int r = sc.nextInt();
                int h = sc.nextInt();
                sc.nextLine();// NOTE - V.IMP.
                String b = sc.nextLine();
                list.add(new Laptop(i,r,h,b));
                System.out.println("Laptop details added...");
                break;
                
                case 2: System.out.println("All Laptop details are :- ");
                for(int x=0; x<list.size(); x++)
                {   System.out.println("For Laptop " + (x+1) );
                    System.out.println("Id : " + ((Laptop)list.get(x)).getId());
                    System.out.println("Ram : " + ((Laptop)list.get(x)).getRamSize());
                    System.out.println("HDD Size : " + ((Laptop)list.get(x)).getHddSize());
                    System.out.println("Brand : " + ((Laptop)list.get(x)).getBrand());
 
                }
                break;

                case 3: System.out.println("For searching through Id press 1, through Brand press 2, through Ram Size press 3, through HDD Size press 4");
                int n1 = sc.nextInt();
                sc.nextLine();
                switch(n1)
                {
                    case 1:System.out.println("Enter the Id to be searched :- ");
                     int i1 = sc.nextInt();
                     for(int x=0; x<list.size(); x++)
                     {
                        if(i1 == ((Laptop)list.get(x)).getId())
                        {
                            System.out.println("Ram : " + ((Laptop)list.get(x)).getRamSize());
                            System.out.println("HDD Size : " + ((Laptop)list.get(x)).getHddSize());
                            System.out.println("Brand : " + ((Laptop)list.get(x)).getBrand());
 
                        }
                     }
                     break;

                    case 2: System.out.println("Enter the Brand to be searched :- ");
                    //sc.nextLine();
                     String b1 = sc.nextLine();
                     for(int x=0; x<list.size(); x++)
                     {
                        //System.out.println("Hello");
                        if(b1.equals(((Laptop)list.get(x)).getBrand()))
                        {
                            System.out.println("Ram : " + ((Laptop)list.get(x)).getRamSize());
                            System.out.println("HDD Size : " + ((Laptop)list.get(x)).getHddSize());
                            System.out.println("Id : " + ((Laptop)list.get(x)).getId());
 
                        }
                     }
                     break;
                     
                     case 3: System.out.println("Enter the Ram Size to be searched :- ");
                     int r1 = sc.nextInt();
                     for(int x=0; x<list.size(); x++)
                     {
                        if(r1 == ((Laptop)list.get(x)).getRamSize())
                        {
                            System.out.println("Brand : " + ((Laptop)list.get(x)).getBrand());
                            System.out.println("HDD Size : " + ((Laptop)list.get(x)).getHddSize());
                            System.out.println("Id : " + ((Laptop)list.get(x)).getId());
 
                        }
                     }
                     break;

                     case 4: System.out.println("Enter the HDD Size to be searched :- ");
                     int h1 = sc.nextInt();
                     for(int x=0; x<list.size(); x++)
                     {
                        if(h1 == ((Laptop)list.get(x)).getHddSize())
                        {
                            System.out.println("Brand : " + ((Laptop)list.get(x)).getBrand());
                            System.out.println("RAM : " + ((Laptop)list.get(x)).getRamSize());
                            System.out.println("Id : " + ((Laptop)list.get(x)).getId());
 
                        }
                     }
                     break;

                     default:System.out.println("Invalid Choice ");
                 }
                 break;

                 case 4: System.out.println("Enter the Id of the laptop to be deleted :- ");
                 int i2 = sc.nextInt();
                  for(int x=0; x<list.size(); x++)
                  {
                    if(i2 == ((Laptop)list.get(x)).getId())
                    {
                        list.remove(x);
                    }
                  }
                 System.out.println("Deletion Successful...");
                 break;

                 case 5: System.out.println("Enter the Id of the laptop to be updated :- ");
                 int i3 = sc.nextInt();
                 System.out.println("Enter 1 for brand updating, 2 for HDD size updating , 3 for Ram Size updating");
                 int upd=sc.nextInt();
                 if(upd == 1)
                 {  
                    System.out.println("Enter the new brand :-");
                    sc.nextLine();
                    String b2=sc.nextLine();
                    for(int x=0; x<list.size(); x++)
                    {
                        if(i3 == ((Laptop)list.get(x)).getId())
                        {
                        //list.set(((Laptop)list.get(x)).getBrand(), b2);
                            ((Laptop)list.get(x)).setBrand(b2);
                            System.out.println("Updated...");

                        }
                    }
                 }
                 else if(upd == 2)
                 {
                    System.out.println("Enter the new HDD Size :-");
                    int h2=sc.nextInt();
                    for(int x=0; x<list.size(); x++)
                    {
                        if(i3 == ((Laptop)list.get(x)).getId())
                        {
                        //list.set(x.getHddSize(), h2);
                            ((Laptop)list.get(x)).setHddSize(h2);
                            System.out.println("Updated...");

                        }
                    }
                 }
                 else if(upd == 3)
                 {
                    System.out.println("Enter the new Ram Size :-");
                    int r2=sc.nextInt();
                    for(int x=0; x<list.size(); x++)
                    {
                        if(i3 == ((Laptop)list.get(x)).getId())
                        {
                        //list.set(x.getRamSize(), r2);
                            ((Laptop)list.get(x)).setRamSize(r2);
                            System.out.println("Updated...");
                        }
                    }
                 }
                 else
                 {
                    System.out.println("Invalid Input...");
                 }
                 break;
                 
                 case 6:System.out.println("Thankyou");
                 break;

                 default: System.out.println("Invalid Input...");
                 
                     
                }
            }while(n != 6);
        }
    }
