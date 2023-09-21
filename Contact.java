

public class Contact /*  implements Comparable<Contact> */  {
private String name;
private int phone;
private String email;
private String address;
private String birthday;
private String notes;


public Contact(String name, int phone, String email, String address, String birthday, String notes) {
    if (exists(name,phone))   //to insure uniqueness, but maybe theres another way
        return;
    else{
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.birthday = birthday;
        this.notes = notes;}
}

public Contact() {
    name=null;
    phone=0;
    email=null;
    address=null;
    birthday=null;
    notes=null;
}


public boolean exists(String n, int p) {
    if (name.equals(n) || phone==p)
        return true;
    else 
    return false;
}

//public int compareTo(Contact c) {
    //return Integer.compare(this.name, c.name); }
}