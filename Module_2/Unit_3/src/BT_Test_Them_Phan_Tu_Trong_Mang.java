package Unit_3;

import java.util.Arrays;

public class BT_Test_Them_Phan_Tu_Trong_Mang {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 6}; // Mảng ban đầu
//        int[] newArr = new int[arr.length + 1]; // Mảng mới có độ dài lớn hơn mảng ban đầu một phần tử
//
//        int indexToAdd = 4; // Vị trí muốn thêm số 5 vào (index 4 tương đương với phần tử có giá trị là 6 trong mảng ban đầu)
//
//        // Sao chép phần tử từ mảng ban đầu sang mảng mới, đến khi đến vị trí muốn thêm số 5.
//        for (int i = 0; i < indexToAdd; i++) {
//            newArr[i] = arr[i];
//        }
//
//        // Thêm số 5 vào vị trí muốn thêm vào
//        newArr[indexToAdd] = 5;
//
//        // Sao chép phần tử còn lại từ mảng ban đầu sang mảng mới.
//        for (int i = indexToAdd + 1; i < newArr.length; i++) {
//            newArr[i] = arr[i - 1];
//        }
//
//        // In ra mảng mới đã được thêm số 5 vào vị trí muốn thêm vào
//        System.out.println("Mảng mới: " + Arrays.toString(newArr));
//
//
//
        int[] arr = {1, 2, 3, 4, 5}; // Mảng ban đầu
        int[] newArr = new int[arr.length - 1]; // Mảng mới có độ dài nhỏ hơn mảng ban đầu một phần tử

        int indexToDelete = 2; // Vị trí muốn xóa phần tử (index 2 tương đương với phần tử có giá trị là 3 trong mảng ban đầu)

        // Sao chép phần tử từ mảng ban đầu sang mảng mới, trừ phần tử ở vị trí muốn xóa
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == indexToDelete) {
                continue;
            } else {
                newArr[j] = arr[i];
                j++;
            }

            // In ra mảng mới đã được xóa phần tử

        }
        System.out.println("Mảng mới: " + Arrays.toString(newArr));
    }
}

