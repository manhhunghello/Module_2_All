//Các phương thức:
//
//        Phương thức khởi tạo một tham số khởi tạo node đầu tiên trong danh sách
//
//        Phương thức thêm một phần tử mới vào danh sách: add()
//
//        Phương thức thêm một phần tử mới vào đầu danh sách: addFirst()
//
//        Phương thức truy cập một phần tử trong danh sách: get()
//
//        Phương thức printList() in các phần tử trong danh sách
//
//        Lớp MyLinkedListTest chứa phương thức main() để thực thi ứng dụng
package TH2_LinkedList;

public class MyLinkedList {  ////////////////////// Lớp MyLinkedList chứa lớp Node.///////////////////////
    private Node head; /// tao danh sách head
    private int numNotes; //////////// numNodes size xác định số phần tử trong danh sách, mặc định gán là 0./////////////

    public MyLinkedList( Object data) {
    head = new Node(data);
    numNotes ++;
    }
    private class Node{
        private Node next; ///Đây là một tham chiếu đến node tiếp theo trong danh sách.
        // Thuộc tính này cho biết node kế tiếp mà node hiện tại đang liên kết tới. Nếu next là null,
        // nghĩa là node hiện tại là node cuối cùng trong danh sách.
        private Object data;

        public Node(Object data) {
            this.data = data;
        }
    }
//    Mục đích: Thêm đối tượng vào vị trí thứ index trong danh sách
//    Tham số đầu vào: vị trí thêm (index), đối tượng thêm (data)
    public void add(int index, Object data){  ////// Vị trí thêm index, đối tượng thêm java /////////

        //Tạo một tham chiếu tạm thời temp trỏ tới node đầu tiên của danh sách (head).
        Node temp = head;
//        Khởi tạo một tham chiếu holder để lưu trữ tham chiếu tới node kế tiếp của temp.
        Node holder;
        for(int i=0; i < index-1 && temp.next != null; i++) {
            //Duyệt qua danh sách từ node đầu tiên cho đến node trước vị trí thêm (index-1)
            // hoặc đến cuối danh sách (temp.next != null).
            temp = temp.next; /// di chuyển temp tơí node kế tiếp
        }
        holder = temp.next; ///Lưu trữ tham chiếu tới node kế tiếp của temp vào holder, lúc này holder ở vị trí thứ 3
        temp.next = new Node(data);// Tạo một node mới với dữ liệu là data và liên kết nó với temp bằng cách gán temp.next bằng node mới này.
        temp.next.next = holder;//Liên kết node mới với node kế tiếp (holder) bằng cách gán temp.next.next bằng holder.
        numNotes ++ ;//Tăng biến numNotes lên 1 để đếm số lượng node trong danh sách.
    }
    public void add(Object data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
           Node temp = head;
            while (temp.next != null) {
               temp = temp.next;
            }
           temp.next = newNode;
        }
        numNotes ++;
    }
    public void addLast(Object data) {
        add(data);
    }

//    Mục đích: Thêm đối tượng vào vị trí đầu tiên trong danh sách
//    Tham số đầu vào: đối tượng thêm (data)
    public void addFirst(Object data) {
        //Tạo một tham chiếu tạm thời temp trỏ tới node đầu tiên của danh sách (head).
        Node temp = head; ///
        head = new Node(data);// Tạo một node mới với dữ liệu là data và gán nó cho head, tức là đặt node mới này làm node đầu tiên của danh sách.
                                // Dữ liệu của node mới được truyền vào thông qua tham số data.
        head.next = temp;///Thiết lập kết nối giữa node mới và node tiếp theo trong danh sách
                        // bằng cách gán temp cho head.next.
                         // Điều này đảm bảo rằng node mới trỏ đến node trước đó (node đầu tiên cũ) trong danh sách.
        //Có nghĩa là gán lại cho temp, vì temp là giá trị ban dầu
        numNotes ++ ;
    }


//    Mục đích: Lấy phần tử ở vị trí index từ danh sách
//    Tham số đầu vào: vị trí cần lấy (index)
    public Node get(int index){
        Node temp = head;
        for(int i=0; i<index; i++) {
            temp = temp.next;
        }
        return temp;
    }
    public Object getData(int index) {
        Node node = get(index);
        return node.data;
    }
//    Mục đích: Hiển thị danh sách các phần tử trong danh sách
    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }


}
