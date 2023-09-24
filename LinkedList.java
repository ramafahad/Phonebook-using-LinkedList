import java.util.List;

    //linked list data structure used to store the contacts.
    //methods for adding, searching, and deleting contacts from the list.

    //public boolean add(){}
    // public Contact -or list of contacts?- search(){}
    // public void delete(){ also deletes events }
public class LinkedList<T>  { 
    private Node<T> head;
    private Node<T> current;


    public LinkedList () {
        head = current = null;
    }

    public boolean empty () { 
        return head == null;
    }

    public boolean last () {
        return current.next ==null;
    }

    public void findfirst() {
        current = head;
    }

    public void findnext () { 
        current = current.next;
    }
    public T retrieve() {
        return current.data; 
    }
    public void update (T val) { 
        current.data = val;
    }


}