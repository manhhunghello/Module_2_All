package TH1_Stack;

import java.util.Queue;

public class GenericStackClient {
    public static void main(String[] args) {

        MyGenericStack<Integer> stack = new MyGenericStack<>();
//        stack.push(2);
//        stack.push(5);
//        stack.push(6);
//        stack.push(7);
//        stack.push(9);
//        stack.push(2);

//        stack.show();

//        stack.pop();
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());

//        stack.show();

/////// --------------------////////////
        System.out.println("1. Stack của String");
        MyGenericStack.stackOfIStrings(); //
        System.out.println("----------------");
        System.out.println("1. Stack của Interger");
        MyGenericStack.stackOfIntegers(); //






    }


}
