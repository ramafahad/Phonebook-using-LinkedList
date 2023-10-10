


public class Contact implements Comparable<Contact> {
    private String name;
    private String phone; // i believe its better in String
    private String email;
    private String address;
    private String birthday;
    private String notes;
    private LinkedList<Event> events;

   
    public Contact(String name, String phone, String email, String address, String birthday, String notes) {

        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.birthday = birthday;
        this.notes = notes;
        events = new LinkedList<Event>();
    }

    public Contact() {
        name = null;
        phone = null;
        email = null;
        address = null;
        birthday = null;
        notes = null;
        events = new LinkedList<Event>();
    }

    @Override
    public int compareTo(Contact b) {
        return name.compareTo(b.name);
    }

    @Override
    public String toString() {
        return " Name: " + name + "\n Phone Number: " + phone + "\n Email Address: " + email + "\n Address: " + address
                + "\n Birthday: " + birthday + "\n Notes: " + notes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setEvents(Event event) {
        this.events.insert(event);
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getNotes() {
        return notes;
    }

    public LinkedList<Event> getEvents() {
        return events;
    }

    public boolean checkconflict(String DateTime) {
        // true if theres conflict, false if not
        if (events.empty())
            return false;

        events.findFirst();
        while (!events.last()) {
            if (events.retrieve().getDateTime().equals((DateTime)))
                return true;
            events.findNext();
        }
        if (events.retrieve().getDateTime().equals(DateTime))
            return true;
        return false;

    }

}