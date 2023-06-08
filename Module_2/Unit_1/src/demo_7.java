

import java.util.Scanner;

public class demo_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double weight, height, BMI;
        // nhập dữ liệu từ bàn phím

        System.out.println(" Nhập cân nặng của bạn: !");
        weight = scanner.nextDouble();
        System.out.println(" Nhập chiều cao của bạn: !");
        height = scanner.nextDouble();

        // Tinh chỉ số BMI theo công thưc:sử dụng hàm Math.pow(x,2) để bình phương của một số.

        BMI = weight/Math.pow(height,2);

//        %: Chỉ định đối số phải được format
//        -: Hiển thị kết quả căn lề trái
//        20: Kích thước của cột, tức là chuỗi in ra sẽ có độ dài tối đa 20 ký tự
//        .2: Số chữ số thập phân tối đa được in ra
//        f: Chỉ định đối số phải được hiển thị ở dạng số thực
        // %s: Đọc chuỗi kí tự
        System.out.printf("%-20s%s", "bmi", "Interpretation\n");
        if (BMI < 18)
            System.out.printf("%-20.2f%s", BMI, "Underweight");
        else if (BMI < 25.0)
            System.out.printf("%-20.3f%s", BMI, "Normal");
        else if (BMI < 30.0)
            System.out.printf("%-20.2f%s", BMI, "Overweight");
        else
            System.out.printf("%-20.2f%s", BMI, "Obese");


    }
}
