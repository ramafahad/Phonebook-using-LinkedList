public class Event implements Comparable<Event> {
    private String title;
    private String dateTime;
    private String location;
    private Contact contactInvolved;// also, we may name it as EventMember to be more clear

    public Event(String title, String dateTime, String location, Contact contactInvolved) {

        // need to check if contactInvolved exists, and theres no conflict with
        // contactInvolved

        this.title = title;
        this.dateTime = dateTime;
        this.location = location;
        this.contactInvolved = contactInvolved;
    }

    @Override
    public int compareTo(Event b) {
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
