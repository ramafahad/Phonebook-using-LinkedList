
    //linked list data structure used to store the contacts.
    //methods for adding, searching, and deleting contacts from the list.

    // public Contact -or list of contacts?- search(){}
    // public void delete(){ also deletes events }
public class LinkedList<T>  { 
    private Node<T> head;
    private Node<T> current;


    public LinkedList () {
        head = current = null;
    }

    public boolean isEmpty () { 
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


    public void add(T c){
        Node<T> n = new Node<T>(c);

        if(head == null) // if empty
        { head=current=n;
           return; 
        }

        if(((Contact)c).compareTo((Contact)head.data)<0) // add at first and change the head
        {
            n.next=head;
            head=n;
            return;

        }



        Node<T> p=head;
        Node<T> cur = head.next;

        while(cur!=null &&  (  ((Contact)cur.data).compareTo((Contact)c)  ) <=0    ){
            p=cur;
            cur=cur.next;
        }

        n.next=cur;   // add at the last or middle 
        p.next=n;


    }







}