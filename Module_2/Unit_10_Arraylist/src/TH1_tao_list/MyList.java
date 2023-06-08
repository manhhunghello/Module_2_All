//Các phương thức:
//
//        Phương thức khởi tạo không tham số
//
//        Phương thức thêm một phần tử mới vào danh sách: add()
//
//        Phương thức thay đổi số phần tử tối đa trong danh sách: ensureCapa()
//
//        Phương thức truy cập một phần tử trong danh sách: get()
//
//        Lớp MyListTest chứa phương thức main() để thực thi ứng dụng

package TH1_tao_list;

import java.util.Arrays;

public class MyList<E> {
    private int size = 1; //size xác định số phần tử trong danh sách, mặc định gán là 0.
    public static final int DEFAULT_CAPACITY = 10;//DEFAULT_CAPACITY lưu số phần tử đối đa trong danh sách mặc định là 10.
    private Object elements[];//Mảng đối tượng elements chứa các phần tử trong danh sách

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int size, Object[] elements) {
        this.size = size;
        this.elements = elements;
    }
    public void ensureCapa(){

            int  newSize = elements.length*2 ;
            elements = Arrays.copyOf(elements,newSize);

    }
    public void add(E e){
//        Mục đích: thêm một phần tử vào cuối của danh sách
//        Tham số đầu vào: phần tử cần thêm vào danh sách
        if (size>=elements.length){
            ensureCapa();
        }
        elements[size ]= e;
        size++;

    }
    public E get(int i){
//        Mục đích: Phương thức get() trả về phần tử vừa ở vị trí thứ i trong danh sách.
//        Tham số đầu vào: số nguyên chứa vị trí cần truy cập đến phần tử trong danh sách
        if (i>= size || i <0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (E) elements[i];
    }
//    public void checkI(int i){
//        if (i < 0 || i >= size){
//            throw new IndexOutOfBoundsException("index ( i ): " + i + ", Size" + i );
//        }
//    }
}
