

import java.util.Scanner;

public class demo_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bạn muốn đếm ngày vào tháng nào?");
        int month = scanner.nextInt();
        String daysInMonth;
        switch (month) {
            case 2:
//                System.out.println("Tháng '2' có 28 hoặc 29 ngày!");
                daysInMonth = " 28 or 29 ";
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
//                System.out.println("Thang " + month + " has 31 days!");
                daysInMonth = " 31 ";
                break;
            case 4:
            case 6:
            case 9:
            case 11:
//                System.out.println("Thang " + month + " has 30 days!");
                daysInMonth = " 30 ";
                break;
            default:
//                System.out.println("dau vao khong hop le");
                daysInMonth = "";
                break;

        }
        if (!daysInMonth.equals("")) { // kiểm tra xem biến daysInMonth có rỗng hay không.
                                        // Nếu không rỗng if sẽ trả về true, nếu rỗng trả về false
                                        // phương thức equals dùng để so sánh gía trị của 2 chuỗi.
                                        // Nếu sử dung toán tử == để so sánh 2 chuỗi nó sẽ ss địa chỉ ô nhớ chứ không so sánh giá trị
            System.out.printf("The month '%d' has %s days!", month, daysInMonth);
        } else {
            System.out.print("Invalid input!");
        }
        // phần if thứ 2 này có tác dụng khử mã lặp, bằng cách tạo một biên có chuôi string, sau đó sét điều kiện này,khi nhập tháng
        // thì sẻ lấy kết qủa chung để điền vào.


    }
}
