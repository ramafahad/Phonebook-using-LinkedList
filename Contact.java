
import java.util.*;
public class Contact implements Comparable<Contact>  { 
    private String name;
    private String phone; // i believe its better in String
    private String email;
    private String address;
    private String birthday;
    private String notes;
    private List<Event> events;

    /*there is a sentence said if a contact is deleted then all related events are also deleted 
    so there should be an event array or something in contact and use aggreagation as java2
    */
    //sort by name when added to linked list

    public Contact(String name, String phone, String email, String address, String birthday, String notes) {
        
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.birthday = birthday;
        this.notes = notes;
        events=null;
    }

    public Contact() {
        name=null;
        phone=null;
        email=null;
        address=null;
        birthday=null;
        notes=null;
        events=null;
    }


    @Override
    public String toString() {
        return "Contact [name=" + name + ", phone=" + phone + ", email=" + email + ", address=" + address
                + ", birthday=" + birthday + ", notes=" + notes + "]";
    }


     @Override
    public int compareTo(Contact b) {
       // if (name.compareTo(b.name)==0)
          //   return (name.substring(name.indexOf(" "))).compareTo(b.name.substring(b.name.indexOf(" "))); //compares last names
       return name.compareTo(b.name);
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

   


    
    


    

        





}