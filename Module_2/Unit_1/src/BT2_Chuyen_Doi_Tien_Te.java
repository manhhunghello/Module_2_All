

import java.util.Scanner;

public class BT2_Chuyen_Doi_Tien_Te {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double vnd = 23000;
        double USD;
        System.out.print("Nhap so tien USD: ");
        USD = scanner.nextDouble();
        double quyDoi = USD * 23000;
        System.out.println("Gia tri VND là: " + quyDoi);

    }
}

