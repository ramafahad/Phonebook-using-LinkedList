import java.util.Scanner;

public class Phonebook{

public static Scanner input = new Scanner(System.in); // to use it in the whole class if needed
public static LinkedList<Contact> PBook= new LinkedList<Contact>(); // to use it in main and other methods
//field for linkedlist

// i think the uniqueness for the contact should be checking here, i mean we can create a contact but not add it untill we check


// implement a method to print all contact that share a event& that shate the first name

public static void main(String[] args) {
    

    System.out.println("Welcome to the phonebook!");
    // do while for menu 
    int num;
    do{

        System.out.println("Please choose an option from the following ");
        System.out.println(" 1.Add a contact \n 2.Search for a contact \n 3.Delete a contact \n 4.Schedule an event \n 5.Print event details \n 6.Print contacts by first name \n 7.Print all events alphabetically \n 8.Exit");

        num=input.nextInt();
        input.nextLine();


        switch(num){
            case 1:
            System.out.println("Enter the contact's name:");
            String name=input.nextLine();
            System.out.println("Enter the contact's phone number");
            String phone=input.nextLine();
            System.out.println("Enter the contact's email address:");
            String email=input.nextLine();
            System.out.println("Enter the contact's address:");
            String address=input.nextLine();
            System.out.println("Enter the contact's birthday:");
            String bday=input.nextLine();
            System.out.println("Enter any notes for the contact:");
            String note=input.nextLine();
            Contact newContact= new Contact(name,phone,email,address,bday,note);

            if(checkUnique(newContact)) {
                PBook.add(newContact);
                System.out.println("Contact added successfully!");}
            else
            System.out.println("This contact already exists!");
                
            break;

            case 2:
            System.out.println("Enter search criteria:\n 1.Name\n 2. Phone Number\n 3.Email Address \n 4.Address\n 5.Birthday");
            int searchChoice=input.nextInt();
            switch (searchChoice) {
                case 1:
                    System.out.println("Enter the contact's name:");
                    break;
                case 2:
                    System.out.println("Enter the contact's phone number");
                    break;
                case 3:
                    System.out.println("Enter the contact's email address:");
                    break;
                case 4:
                    System.out.println("Enter the contact's address:");
                    break;
                case 5:
                    System.out.println("Enter the contact's birthday:");
                    break;
                default:
                System.out.println("You have entered a wrong number, please try again");
                    break;
            }


            
            break;

            case 3:
            break;

            case 4:
            break;

            case 5:
            break;

            case 6:
            break;

            case 7:
            break;

            case 8:
            System.out.println("Thank you for using ring ring phonebook, goodbye!");
            break;


            default:
            System.out.println("You have entered a wrong number, please try again");
            break;



        }


    }while(num!=8); // i dont know what would be the max num so i put 8 عباطه





}// end main



public static boolean checkUnique(Contact c){

    // return true if its unique false otherwise
    if(PBook.isEmpty())
    return true;
    PBook.findfirst();
    while(!PBook.last())
    {
        if(PBook.retrieve().getName().equals(c.getName()) || PBook.retrieve().getPhone().equals(c.getPhone())){
            return false;
        }
        PBook.findnext();
    }

    if(PBook.retrieve().getName().equals(c.getName()) || PBook.retrieve().getPhone().equals(c.getPhone()))
        return false;

    else
        return true;

}








    
}