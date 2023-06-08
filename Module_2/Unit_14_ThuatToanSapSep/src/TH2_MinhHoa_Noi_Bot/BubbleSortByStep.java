package TH2_MinhHoa_Noi_Bot;

import java.util.ArrayList;
import java.util.Scanner;

public class BubbleSortByStep {
    public ArrayList<Integer> arrTest() {


        int input;
        int out;

        ArrayList<Integer> arr = new ArrayList<>();
        do {

            System.out.println(" Nhập phan tu trong mang: ");
            input = Integer.parseInt(new Scanner(System.in).nextLine());
            arr.add(input);
            System.out.println("1. Nhap 1 de thoat");
            System.out.println("2. Nhap 2 để add thêm mảng : ");
            out = Integer.parseInt(new Scanner(System.in).nextLine());
            System.out.println(" Mảng sau khi thêm vào là : \n");


        }
        while (out != 1);
        for (Integer s : arr) {
            System.out.printf(" %s ", s);
        }

        return arr;
    }


    ///////////////// Nổi Bot ///////////////////////

    public void SortNoiBot() {
        ArrayList<Integer> arr = new ArrayList<>(arrTest()); // Tạo một bản sao của danh sách arrTest()
        System.out.println("\n");
        int temp;

        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = 0; j < arr.size() - 1 - i; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }

        System.out.println(" Mảng sau khi được sắp sếp là : ");

        for (int i = 0; i < arr.size(); i++) {
            System.out.printf(" %s ", arr.get(i) + " ");
        }
    }


    public static void main(String[] args) {
        BubbleSortByStep ll = new BubbleSortByStep();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Nhập kích thước của mảng: ");
//        int size = scanner.nextInt();
//        int[] list = new int[size];
//        System.out.println("Mang có " + list.length + " gía trị");
//        for (int i = 0; i <  list.length; i++) {
//            list[i]= scanner.nextInt();
//        }
//        System.out.println("Danh sách mảng: ");
//        for (int i = 0; i <  list.length; i++) {
//        System.out.printf(" %s " ,list[i] + "\t");


        ll.SortNoiBot();
//arrTest();
    }
}


