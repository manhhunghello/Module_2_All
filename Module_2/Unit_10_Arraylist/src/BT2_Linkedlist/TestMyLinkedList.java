package BT2_Linkedlist;

public class TestMyLinkedList {
    public static void main(String[] args) {
        // Tạo một đối tượng MyLinkedList
        MyLinkedList myList = new MyLinkedList();

        // Thêm các phần tử vào danh sách
        myList.add("First");
        myList.add("Second");
        myList.add("Third");
        // Lấy danh sánh
        System.out.println("lay danh sach index la 3: " + myList.get(2));

        // In danh sách
        System.out.println("Danh sách ban đầu:");
        myList.printList(); // In ra: First -> Second -> Third

        // xoa vi tri cuối cùng
       myList.addLast("Hung");

        // Thêm phần tử vào đầu danh sách
        myList.addFirst("New First");

        // In danh sách sau khi thêm phần tử vào đầu
        System.out.println("Danh sách sau khi thêm phần tử vào đầu:");
        myList.printList(); // In ra: New First -> First -> Second -> Third

        // Xóa phần tử tại vị trí 2
        myList.remove(2);

        // In danh sách sau khi xóa phần tử
        System.out.println("Danh sách sau khi xóa phần tử:");
        myList.printList(); // In ra: New First -> First -> Third

        // Truy cập phần tử tại vị trí 1
        Object element = myList.get(1);
        System.out.println("Phần tử tại vị trí 1: " + element); // In ra: Phần tử tại vị trí 1: First

        // In số lượng phần tử trong danh sách
        int size = myList.size();
        System.out.println("Số lượng phần tử trong danh sách: " + size); // In ra: Số lượng phần tử trong danh sách: 3

        // Kiểm tra phần tử "Second" có trong danh sách không
        boolean contains = myList.contains("Second");
        System.out.println("Có chứa phần tử \"Second\" trong danh sách không? " + contains); // In ra: Có chứa phần tử "Second" trong danh sách không? false

        // Tạo một bản sao của danh sách
        MyLinkedList cloneList = myList.clone();

        // In danh sách bản sao
        System.out.println("Danh sách bản sao:");
        cloneList.printList(); // In ra: New First -> First -> Third
    }
}
