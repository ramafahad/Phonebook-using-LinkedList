import java.util.Scanner;

public class Phonebook {

    public static Scanner input = new Scanner(System.in); // to use it in the whole class if needed
    public static LinkedList<Contact> PBook = new LinkedList<Contact>(); // a list of all contacts
    public static LinkedList<Event> AllEvent = new LinkedList<Event>(); // a list of all events

    public static void main(String[] args) {

        System.out.println("Welcome to the phonebook!");
        // do while for menu
        int num;
        do {

            System.out.println("Please choose an option from the following ");
            System.out.println(
                    " 1.Add a contact \n 2.Search for a contact \n 3.Delete a contact \n 4.Schedule an event \n 5.Print event details \n 6.Print contacts by first name \n 7.Print all events alphabetically \n 8.Print contacts that share an event\n 9.Exit");
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
                    if (!search(searchChoice, choice).empty()) {
                        System.out.println("Contact/s found!\n");
                        search(searchChoice, choice).printList();
                    } else
                        System.out.println("Nothing found!\n");
                    break;

                case 3:
                    System.out.println("Enter the name of the contact you want to delete");
                    String deletedContact = input.nextLine();
                    deleteContact(deletedContact);
                    break;

                case 4:
                    scheduleEvent();
                    break;

                case 5:
                    printEventDetails();
                    break;

                case 6:
                    System.out.println("Enter the first name: ");
                    String firstName = input.next();
                    LinkedList<Contact> contactsWithSameName = search(6, firstName);
                    if (contactsWithSameName.empty())
                        System.out.print("No contact with the entered first name!\n");
                    else {
                        System.out.println("Contacts found!");
                        contactsWithSameName.printList();
                    }
                    break;

                case 7:
                    AllEvent.printList(); // print all events alphabetically
                    break;

                case 8:
                    printSharedEvent();
                    break;

                case 9:
                    System.out.println("Thank you for using the phonebook, goodbye!");
                    break;

                default:
                    System.out.println("You have entered a wrong number, please try again");
                    break;

            }

        } while (num != 9);

    }// end main

    // methods
    public static boolean checkUnique(Contact c) {
        // checks if the contact exists already in the phonebook list. returns true if
        // it is unique and false otherwise

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

        if (PBook.retrieve().getName().equalsIgnoreCase(c.getName())
                || PBook.retrieve().getPhone().equalsIgnoreCase(c.getPhone()))
            return false;

        else
            return true;

    }// end of checkUnique method

    public static LinkedList<Contact> search(int searchChoice, String choice) {
        /*
         * This method searches for a list of contacts based on the inputs the user
         * entered.
         * It searches either by full name, phone number ,email, address, birthday, or
         * first name
         * and returns a linked list with all the contacts that match the search
         */

        LinkedList<Contact> returnedlist = new LinkedList<Contact>();
        if (PBook.empty())
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
                    if (PBook.retrieve().getName().substring(0, PBook.retrieve().getName().indexOf(" "))
                            .equalsIgnoreCase(choice))
                        returnedlist.insert(PBook.retrieve());
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
                if (PBook.retrieve().getName().substring(0, PBook.retrieve().getName().indexOf(" "))
                        .equalsIgnoreCase(choice))
                    returnedlist.insert(PBook.retrieve());
                break;

        }// end switch

        return returnedlist;

    }// end searh method

    public static void scheduleEvent() {
        /*
         * schedule an event for a contact, it checks if the contact exists
         * or it has a conflict at the entered time, shows a message accordingly
         */
        System.out.println("Enter event title: ");
        String title = input.nextLine();
        System.out.println("Enter contact name:");
        String contact = input.nextLine(); // change it to contact name
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
    } // end schedule event

    public static void printEventDetails() {
        /*
         * print event details based on criteria, either by contact name or event title
         * shows a message if the contact doesnt exist or if it doesnt have any events
         * or if there is no events that match the titles entered
         */

        System.out.println("Enter search criteria number :\n1.Contact name\n2.Event tittle");
        int searchEvent = input.nextInt();
        input.nextLine();
        LinkedList<Contact> returnedContacts = new LinkedList<Contact>();
        switch (searchEvent) {
            case 1:
                System.out.println("Enter contact name:");
                String contactName = input.nextLine();
                returnedContacts = search(1, contactName);
                if (returnedContacts.empty())
                    System.out.print("Contact entered doesn't exist!\n");
                else {
                    if (!returnedContacts.retrieve().getEvents().empty()) {
                        System.out.println("Events for " + contactName);
                        returnedContacts.retrieve().getEvents().printList();
                    } // end if
                    else
                        System.out.println("There are no events for " + contactName);
                } // end else
                break;

            case 2:
                System.out.println("Enter Event name:");
                String EventName = input.nextLine();
                if (AllEvent.empty())
                    System.out.println("There are no events!");
                else {
                    AllEvent.findFirst();
                    while (!AllEvent.last()) {
                        if (AllEvent.retrieve().gettitle().equalsIgnoreCase(EventName))
                            System.out.println(AllEvent.retrieve().toString());
                        AllEvent.findNext();
                    } // end while
                    if (AllEvent.retrieve().gettitle().equalsIgnoreCase(EventName))// checking for last element
                        System.out.println(AllEvent.retrieve().toString());
                } // end else
                break;

            default:
                System.out.println("You have entered a wrong number, please try again");
                break;

        }
    }// end method

    public static void deleteContact(String name) {
        /*
         * This method takes the name of contact as a string and delete it
         * , Also delete all associated events, the method does not return anything
         */

        if (PBook.empty()) { // check if pbook is empty
            System.out.println("there is no contacts to be deleted");
            return;
        }

        LinkedList<Contact> TempList = search(1, name);// search for the contact that has the given name
        if (!TempList.empty()) { // check if there is a returned contact
            PBook.removeSpecificObject(TempList.retrieve()); // delete the contact
            System.out.println("Contact is deleted! ");
            if (!AllEvent.empty()) { // chech if there exist any event

                boolean isDeleted = false;
                AllEvent.findFirst();
                while (!AllEvent.last()) { // loop to delete any associated events
                    if (AllEvent.retrieve().getContactInvolved().getName().equalsIgnoreCase(name)) {
                        AllEvent.remove();
                        isDeleted = true;
                    } // end if
                    else
                        AllEvent.findNext();
                } // end while loop

                // check last element
                if (AllEvent.retrieve().getContactInvolved().getName().equalsIgnoreCase(name)) {
                    AllEvent.remove();
                    isDeleted = true;
                }

                if (isDeleted == true)
                    System.out.println("and all associated event were deleted!");
                else
                    System.out.println("this contact doesn't have any event to be deleted");
            } // end if

            else
                System.out.println("there is no scheduled events to be deleted");
        } // outer if

        else // no contact with name
            System.out.println("contact not found");
    }// end deleteContact method

    public static void printSharedEvent() {
        /*
         * this method prints the names of contacts that share an event the user
         * specified
         */
        System.out.println("Enter event title");
        String EventName = input.nextLine();
        System.out.println("Enter event date and time (MM/DD/YYYY HH:MM):");
        String DateTime = input.nextLine();
        System.out.println("Enter event location:");
        String location = input.nextLine();
        if (AllEvent.empty())
            System.out.println("There are no events!");
        else {
            boolean found = false;
            AllEvent.findFirst();
            while (!AllEvent.last()) {
                if (AllEvent.retrieve().gettitle().equalsIgnoreCase(EventName)
                        && AllEvent.retrieve().getDateTime().equalsIgnoreCase(DateTime)
                        && AllEvent.retrieve().getLocation().equalsIgnoreCase(location)) {
                    found = true;
                    System.out.println(AllEvent.retrieve().getContactInvolved().getName());
                }
                AllEvent.findNext();
            } // end while
            if (AllEvent.retrieve().gettitle().equalsIgnoreCase(EventName)
                    && AllEvent.retrieve().getDateTime().equalsIgnoreCase(DateTime)
                    && AllEvent.retrieve().getLocation().equalsIgnoreCase(location)) {
                found = true;
                System.out.println(AllEvent.retrieve().getContactInvolved().getName());
            }

            if (!found)
                System.out.println("No event found for the entered info!");
            else
                System.out.println("these are all the involved contacts");
        } // end else
    }// end method

}// end phone book
