package TH2_Queue;

public class MyLinkedListQueue<T> {
    public Node head;
    public Node tail;
    public int size= 10;

    public MyLinkedListQueue(){

    }
    public boolean isEmpty(){
        return head == null && tail == null;
    }
    public void enqueue(int key){
        Node temp = new Node(key);
        if (isEmpty()){
            this.head = this.tail=temp;
            return;
        }
        this.tail.next = temp;
        this.tail=tail.next;


    }
    public Node dequeue(){
        if (this.head==null){
            return null;
        }
        Node temp = this.head;

        this.head=this.head.next;
        if (this.head == null)
            this.tail = null;
        return temp;



    }
    public void show(){
        Node temp = head ;
        while (temp != null ){
            System.out.println(temp.key);
            temp=temp.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedListQueue <Integer> ll = new MyLinkedListQueue<>();
        ll.enqueue(3);
        ll.enqueue(4);
        ll.enqueue(5);
        ll.enqueue(6);

        ll.show();
        System.out.println("-------------------------");
        ll.dequeue();
        ll.show();
        System.out.println("-------------------------");
        ll.dequeue();
        ll.show();
        System.out.println("-------------------------");
        ll.dequeue();
        ll.show();
        System.out.println("-------------------------");

        ll.show();


    }
}

