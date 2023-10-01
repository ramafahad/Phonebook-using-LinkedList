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


    public String toString() {
        return " Event title: " + title + "\n Contact title: " + contactInvolved + "\n Event date and time(MM/DD/YYYYHH:MM):" + dateTime + "\n Event location:" + location;
    }
    

    public String gettitle() {
        return this.title;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public String getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Contact getContactInvolved() {
        return this.contactInvolved;
    }

    public void setContactInvolved(Contact contactInvolved) {
        this.contactInvolved = contactInvolved;
    }

}
