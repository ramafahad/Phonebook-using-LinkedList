import java.util.Scanner;

public class Phonebook{

public static Scanner input = new Scanner(System.in);
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


        switch(num){
            case 1:
            break;

            case 2:
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


    }while(num!=8); // i dont know what would be tha max num so i put 8 عباطه





}// end main


    
}