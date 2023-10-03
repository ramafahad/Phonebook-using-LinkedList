import java.util.Scanner;

public class Phonebook {

    public static Scanner input = new Scanner(System.in); // to use it in the whole class if needed
    public static LinkedList<Contact> PBook = new LinkedList<Contact>(); // to use it in main and other methods
    public static LinkedList<Event> AllEvent = new LinkedList<Event>();;
    // field for linkedlist

    // i think the uniqueness for the contact should be checking here, i mean we can
    // create a contact but not add it untill we check

    // implement a method to print all contact that share a event& that shate the
    // first name

    public static void main(String[] args) {

        System.out.println("Welcome to the phonebook!");
        // do while for menu
        int num;
        do {

            System.out.println("Please choose an option from the following ");
            System.out.println(
                    " 1.Add a contact \n 2.Search for a contact \n 3.Delete a contact \n 4.Schedule an event \n 5.Print event details \n 6.Print contacts by first name \n 7.Print all events alphabetically \n 8.Exit");

            num = input.nextInt();
            input.nextLine();

            switch (num) {
                case 1:
                    System.out.println("Enter the contact's name:");
                    String name = input.nextLine();
                    System.out.println("Enter the contact's phone number");
                    String phone = input.nextLine();
                    System.out.println("Enter the contact's email address:");
                    String email = input.nextLine();
                    System.out.println("Enter the contact's address:");
                    String address = input.nextLine();
                    System.out.println("Enter the contact's birthday:");
                    String bday = input.nextLine();
                    System.out.println("Enter any notes for the contact:");
                    String note = input.nextLine();
                    Contact newContact = new Contact(name, phone, email, address, bday, note);

                    if (checkUnique(newContact)) {
                        PBook.add(newContact);
                        System.out.println("Contact added successfully!");
                    } else
                        System.out.println("This contact already exists!");

                    break;

                case 2:
                    System.out.println(
                            "Enter search criteria:\n 1.Name\n 2.Phone Number\n 3.Email Address \n 4.Address\n 5.Birthday");
                    int searchChoice = input.nextInt();
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
                            System.out.println("You have entered a wrong number, please try again!");
                            break;
                    }
                    input.nextLine();
                    String choice = input.nextLine();

                    if (!search(searchChoice, choice).empty()) { // اتوقع افضل لو اسمي الليست بدال ما انادي مرتين بس
                                                                 // مالي خلق
                        System.out.println("Contact/s found!\n");
                        search(searchChoice, choice).printList();
                    } else
                        System.out.println("Nothing found!\n");
                    break;

                case 3:
                    System.out.println("Enter the name of the contact you want to delete");
                    String deleteContact = input.nextLine();
                    //////
                    break;

                case 4:
                    System.out.println("Enter event title: ");
                    String title = input.nextLine();
                    System.out.println("Enter contact name:");
                    String contact = input.nextLine(); // change it to conta name
                    if (search(1, contact).empty())
                        System.out.print("Contact entered doesn't exist!\n");
                    else {
                        Contact contactInvolved = search(1, contact).retrieve();
                        System.out.println("Enter event date and time (MM/DD/YYYY HH:MM):");
                        String DateTime = input.nextLine();
                        System.out.println("Enter event location:");
                        String location = input.nextLine();
                        if (contactInvolved.checkconflict(DateTime))
                            System.out.println("the contact has time conflict!\n");
                        else {
                            Event e = new Event(title, DateTime, location, contactInvolved);
                            contactInvolved.setEvents(e);
                            AllEvent.add(e);
                            // add to big list
                            System.out.println("Event scheduled successfully!");
                        }
                    } // end else
                    break;

                case 5:
                    System.out.println("Enter search criteria:\n1.Contact name\n2.Event tittle");
                    int searchEvent = input.nextInt();
                    input.nextLine();
                    switch (searchEvent) {
                        case 1:
                            System.out.println("Enter contact name:");
                            String contactE = input.nextLine();
                            if (search(1, contactE).empty())
                                System.out.print("Contact entered doesn't exist!\n");
                            else {
                                System.out.println("Events for " + contactE);
                                search(1, contactE).retrieve().getEvents().printList();
                            }
                            break;

                        case 2:
                            System.out.println("Enter Event name:");
                            String EventName = input.nextLine();
                            if (search(6, EventName).empty())
                                System.out.print(" The Event entered doesn't exist!\n");
                            else {
                                System.out.println("Events found " + EventName);
                                search(6, EventName);
                            }
                            break;

                    } // end inner switch
                    break;

                case 6:
                    System.out.println(" print contacts by first name ");
                    if (PBook.empty())
                        System.out.println("the contact list is empty");
                    else {
                        PBook.findFirst();
                        if (!PBook.last()) {

                        }

                    } // end else

                    break;

                case 7:
                    AllEvent.printList(); // print all events alphabetically
                    break;

                case 8:
                    System.out.println("Thank you for using ring ring phonebook, goodbye!");
                    break;

                default:
                    System.out.println("You have entered a wrong number, please try again");
                    break;

            }

        } while (num != 8); // i dont know what would be the max num so i put 8 عباطه

    }// end main

    public static boolean checkUnique(Contact c) {

        // return true if its unique false otherwise
        if (PBook.empty())
            return true;
        PBook.findFirst();
        while (!PBook.last()) {
            if (PBook.retrieve().getName().equalsIgnoreCase(c.getName())
                    || PBook.retrieve().getPhone().equalsIgnoreCase(c.getPhone())) {
                return false;
            }
            PBook.findNext();
        } // end while

        if (PBook.retrieve().getName().equalsIgnoreCase(c.getName())//////// !!!!!!!!!!!!! repeated
                || PBook.retrieve().getPhone().equalsIgnoreCase(c.getPhone()))
            return false;

        else
            return true;

    }// end of checkUnique method

    public static LinkedList<Contact> search(int searchChoice, String choice) {
        // لازم نشيك انها ما ترجع نل لما نناديها

        LinkedList<Contact> returnedlist = new LinkedList<Contact>();

        if (PBook.empty())// or allevent cjeck hf it is empty orcnot
            return returnedlist;

        PBook.findFirst();
        while (!PBook.last()) {
            switch (searchChoice) {
                case 1:
                    if (PBook.retrieve().getName().equalsIgnoreCase(choice))
                        returnedlist.insert(PBook.retrieve());

                    break;

                case 2:
                    if (PBook.retrieve().getPhone().equals(choice))
                        returnedlist.insert(PBook.retrieve());
                    break;

                case 3:
                    if (PBook.retrieve().getEmail().equalsIgnoreCase(choice))
                        returnedlist.insert(PBook.retrieve());
                    break;

                case 4:
                    if (PBook.retrieve().getAddress().equalsIgnoreCase(choice))
                        returnedlist.insert(PBook.retrieve());

                    break;
                case 5:
                    if (PBook.retrieve().getBirthday().equals(choice))
                        returnedlist.insert(PBook.retrieve());

                    break;

                case 6:

                    if (AllEvent.retrieve().gettitle().equalsIgnoreCase(choice))
                        System.out.println(AllEvent.retrieve());// insert as list
                    break;

            }// end switch

            PBook.findNext();
        } // end while

        // check the last node
        switch (searchChoice) {
            case 1:
                if (PBook.retrieve().getName().equalsIgnoreCase(choice))
                    returnedlist.insert(PBook.retrieve());
                break;

            case 2:
                if (PBook.retrieve().getPhone().equals(choice))
                    returnedlist.insert(PBook.retrieve());
                break;

            case 3:
                if (PBook.retrieve().getEmail().equalsIgnoreCase(choice))
                    returnedlist.insert(PBook.retrieve());
                break;

            case 4:
                if (PBook.retrieve().getAddress().equalsIgnoreCase(choice))
                    returnedlist.insert(PBook.retrieve());
                break;

            case 5:

                if (PBook.retrieve().getBirthday().equals(choice))
                    returnedlist.insert(PBook.retrieve());
                break;

            case 6:

                if (AllEvent.retrieve().gettitle().equalsIgnoreCase(choice))
                    System.out.println(AllEvent.retrieve());
                break;

        }// end switch

        return returnedlist;

    }// end searh method

}// end phone book