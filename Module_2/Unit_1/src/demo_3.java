

import java.util.Scanner;

public class demo_3 {
    public static void main(String[] args) {
        float width;
        float height;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter width:" );
        width = scanner.nextFloat(); //Nhap chieu rong
        System.out.println("Enter height: ");
        height = scanner.nextFloat();
        float area = width * height;
        System.out.println("dien tich hinh chu nhat la:" + area);


    }
}
