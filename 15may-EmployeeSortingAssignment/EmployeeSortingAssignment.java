import java.util.Scanner;
import java.util.ArrayList;
class EmployeeSortingAssignment
{
    public static void main(String[] args)
    {
        
        java.util.List list = new java.util.ArrayList();
        Scanner sc = new Scanner(System.in);
        char ch;


        do
        {
        
                System.out.println("Enter Employee Details : - ");
                System.out.println("Enter the Name , Id , Age , Address respctively :- ");
                String name = sc.nextLine();
                int id = sc.nextInt();
                int age = sc.nextInt();
                sc.nextLine();// NOTE - V.IMP.
                String address = sc.nextLine();
                //sc.nextLine();
                list.add(new Employees(name,id,age,address));
                System.out.println("Employee details added...");
                System.out.print("Add more Employees (Y/N) :- ");
                //Scanner sc = new Scanner(System.in);
                ch = sc.next().charAt(0);
                sc.nextLine();
                if(ch != 'y' || ch != 'Y'){
                    System.out.println("Thankyou !!!");
                }

        }while(ch == 'Y' || ch == 'y');
 
        int choice;
        do
        {
        System.out.println("Sort by :- \n 1)ID\n 2)Age\n 3)Address\n 4)First Name\n 5)Last Name\n 6)Exit :- ");

        choice = sc.nextInt();
        if(choice == 1)
        {
            java.util.Collections.sort(list, new SortByID());
            System.out.println("Contents of list after sorting : " + list);
        }
        else if(choice == 2)
        {
            java.util.Collections.sort(list, new SortByAge());
            System.out.println("Contents of list after sorting : " + list);
        }
        else if(choice == 3)
        {
            java.util.Collections.sort(list, new SortByAddress());
            System.out.println("Contents of list after sorting : " + list);
        }
        else if(choice == 4)
        {
            java.util.Collections.sort(list, new SortByFirstName());
            System.out.println("Contents of list after sorting : " + list);
        }
        else if(choice == 5)
        {
            java.util.Collections.sort(list, new SortByLastName());
            System.out.println("Contents of list after sorting : " + list);
        }
        else if(choice == 6)
        {
            System.out.println("Thankyou !!!");
        }
        else
        {
            System.out.println("Invalid Choice !!!");
        }
        }while(choice != 6);

        
    }
}
 
class Employees{
    String eName, eAddress;
     private Integer eId,eAge;

    Employees(String name, int id, int age, String address){
        this.eName = name;
        this.eId = id;
        this.eAge = age;
        this.eAddress=address;
    }
 
    @Override
    public String toString(){
        return "Employee with ID:- " + this.eId + ", Name :- " + this.eName;
    }
 
    //Getters
    public Integer getEmpId(){
        return this.eId;
    }

    public Integer getEmpAge(){
        return this.eAge;
    }
 
    public String getEmpAddress(){
        return this.eAddress;
    }

    public String getEmpName(){
        return this.eName;
    }
 
 
 
}
 
//Sort on Age
class SortByAge implements java.util.Comparator{
    @Override
    public int compare(Object firstObject, Object secondObject){
return ((Employees)firstObject).getEmpAge().compareTo(((Employees)secondObject).getEmpAge()); 
    }
}
 
//Sorting on the basis of ID
class SortByID implements java.util.Comparator{
    @Override
    public int compare(Object firstObject, Object secondObject){
return ((Employees)firstObject).getEmpId().compareTo(((Employees)secondObject).getEmpId());   
    }
}
 
//Sorting on Address
class SortByAddress implements java.util.Comparator{
    @Override
    public int compare(Object firstObject, Object secondObject){
return ((Employees)firstObject).getEmpAddress().compareTo(((Employees)secondObject).getEmpAddress()); 
    }
}

//Sorting on first name
class SortByFirstName implements java.util.Comparator{
    @Override
    public int compare(Object firstObject, Object secondObject){
return ((Employees)firstObject).getEmpName().split(" ")[0].compareTo(((Employees)secondObject).getEmpName().split(" ")[0]); 
    }
}

//Sorting on last name
class SortByLastName implements java.util.Comparator{
    @Override
    public int compare(Object firstObject, Object secondObject){
return ((Employees)firstObject).getEmpName().split(" ")[((Employees)firstObject).getEmpName().split(" ").length - 1].compareTo(((Employees)secondObject).getEmpName().split(" ")[((Employees)secondObject).getEmpName().split(" ").length - 1]); 
    }
}