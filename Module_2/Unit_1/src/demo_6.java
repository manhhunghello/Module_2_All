

import java.util.Scanner;

public class demo_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year;
        System.out.println("Nhap nam ma ban muon kiem tra: !");
        year = scanner.nextInt();
        boolean isLeapYear = false;
        if(year % 4 == 0){
            if(year % 100 == 0){
                if(year % 400 == 0){
                    isLeapYear = true;
                }
            } else {
                isLeapYear = true;
            }
        }
        if(isLeapYear){ /// in ra màn hình kiểm tra xem năm nhập vào có phải là năm nhuận không,
                        /// nếu biên isLeapYear trả về giá trị TRUE thì in ra nắm nhuận và ngược lai.
            System.out.printf("%d la nam nhuan", year);
        } else {
            System.out.printf("%d khong phai la nam nhuan", year);
        }
    }
}
