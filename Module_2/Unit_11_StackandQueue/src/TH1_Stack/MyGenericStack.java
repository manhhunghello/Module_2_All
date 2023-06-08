package TH1_Stack;

import java.util.LinkedList;

public class MyGenericStack<T> {
    private LinkedList<T> stack;

    public MyGenericStack() {
        stack = new LinkedList<T>();
    }

    /////// Cài đặt phương thức push() ////////
    public void push(T element) {
        stack.addFirst(element);

    }

    ///////// Cài đặt phương thức size() ///////
    public int size() {
        return stack.size();
    }

    public T pop() {

        if (!isEmpty())
            return stack.pop();
        return null;
    }

    public boolean isEmpty() {
        return stack.size() < 1;
    }


    public void show() {
        while (!stack.isEmpty()) { // for (int i = 0; i < stack.size();) { // 0 < stack.size nghia la đã có phần tử trong stack
            System.out.printf(" %s ", stack.pop());
        }
    }

    public static   void stackOfIStrings() {
        MyGenericStack<String> stack = new MyGenericStack<>();
        stack.push("Five");
        stack.push("Four");
        stack.push("Three");
        stack.push("Two");
        stack.push("One");
        System.out.println("1.1. Kích thức của ngắn sếp sau thao tác push: " + stack.size());
        System.out.printf("1.2. Pop các phần tử từ ngăn sếp ra : ");
       stack.show();
        System.out.println("\n1.3. Kich thước của ngăn sếp sau khi pop : " + stack.size());
    }

    public static void stackOfIntegers() {
        MyGenericStack<Integer> stack = new MyGenericStack<>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println("2.1.  Kích thức của ngắn sếp sau thao tác push: " + stack.size());
        System.out.printf("2.2. Pop các phần tử từ ngăn sếp ra: ");
        stack.show();
        System.out.println("\n3.3 Kich thước của ngăn sếp sau khi pop : " + stack.size());
    }


}