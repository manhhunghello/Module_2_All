

import java.util.Scanner;

public class demo_4 {
    public static void main(String[] args) {
        System.out.println(" Giải quyết phương trình tuyến tính");
        System.out.println("Đưa ra một phương trình như ' a * x + b = c ', Vui lòng nhập hằng số: ");
        Scanner scanner = new Scanner(System.in);
        System.out.println(" nhap a: ");
        double a = scanner.nextDouble();
        System.out.println(" nhap b:");
        double b = scanner.nextDouble();
        System.out.println(" nhap c:");
        double c = scanner.nextDouble();
        if (a != 0){
            double ketQua = ( c-b)/a;
            System.out.printf("Equation pass with x = %f!\n", ketQua);
        } else if (b==c) {
            System.out.println("Phuong trinh co vo so nghiem x!");

        }
        else {
            System.out.println("phuong trinh vo nghiem");
        }
    }
}
