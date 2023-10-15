public class Event implements Comparable<Event> {
    private String title;
    private String dateTime;
    private String location;
    private Contact contactInvolved;

    public Event(String title, String dateTime, String location, Contact contactInvolved) {
            //constructor with parameters
        this.title = title;
        this.dateTime = dateTime;
        this.location = location;
        this.contactInvolved = contactInvolved;
    }

    @Override
    public int compareTo(Event b) { 
        // the method compare between two objects And return an integer indicate if there are equal 
        //or the first object is bigger than the other ,or smaller
        return title.compareTo(b.title);
    }

    public String toString() {
        return " Event title: " + title + "\n Contact title: " + contactInvolved.getName()
                + "\n Event date and time(MM/DD/YYYYHH:MM):" + dateTime + "\n Event location:" + location+"\n";
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
