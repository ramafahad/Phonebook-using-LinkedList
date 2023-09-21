public class Event {
    private String title;
    private String dateTime;
    private String location;
    private Contact contactInvolved;

    public Event(String title, String dateTime, String location, Contact contactInvolved) {

        // need to check if contactInvolved exists, and theres no conflict with contactInvolved
        
        this.title = title;
        this.dateTime = dateTime;
        this.location = location;
        this.contactInvolved = contactInvolved;
    }


}
