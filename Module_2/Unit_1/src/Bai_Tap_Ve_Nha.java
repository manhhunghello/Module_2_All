

import java.util.Scanner;
public class Bai_Tap_Ve_Nha {
    public static void main(String[] args) {
//        1. Viết chương trình để tìm số nguyên tố thứ n (với n là số nguyên dương).

//        2. Viết chương trình để tìm tất cả các số hoàn hảo trong một khoảng số được nhập từ bàn phím.

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Nhap so dau: ");
//        int firstNumber = scanner.nextInt();
//        System.out.print("nhap so cuoi: ");
//        int lastNumber = scanner.nextInt();
//
//        for (int i = firstNumber; i <= lastNumber; i++) {
//            if (numberGood(i)) {
//                System.out.println(i + " la so hoan hao");
//            }
//        }
//    }
//
//    public static boolean numberGood(int number) {
//        int sum = 0;
//        for (int i = 1; i <= number / 2; i++) {
//            if (number % i == 0) {
//                sum += i;
//            }
//        }
//        return sum == number;
//        3. Viết chương trình để tính tổng của tất cả các số nguyên tố nhỏ hơn hoặc bằng một số được nhập từ bàn phím.
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter a number: ");
//        int n = scanner.nextInt();
//
//        int sum = 0;
//        for (int i = 2; i <= n; i++) {
//            if (isPrime(i)) {
//                sum += i;
//            }
//        }
//        System.out.println("The sum of all primes less than or equal to " + n + " is " + sum);
//    }
//
//    public static boolean isPrime(int number) {
//        if (number <= 1) {
//            return false;
//        }
//        for (int i = 2; i <= Math.sqrt(number); i++) {
//            if (number % i == 0) {
//                return false;
//            }
//        }
//        return true;
//        4. Viết chương trình để kiểm tra xem một chuỗi ký tự nhập từ bàn phím có phải là chuỗi đối xứng hay không.
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter a string: ");
//        String inputString = scanner.nextLine();
//
//        boolean isPalindrome = true;
//        int length = inputString.length();
//        for (int i = 0; i < length / 2; i++) {
//            if (inputString.charAt(i) != inputString.charAt(length - 1 - i)) {
//                isPalindrome = false;
//                break;
//            }
//        }
//
//        if (isPalindrome) {
//            System.out.println("The input string is a palindrome.");
//        } else {
//            System.out.println("The input string is not a palindrome.");
//        }

//        5. Viết chương trình để tính tổng của tất cả các số nguyên tố có hai chữ số.
        int sum = 0;
        for (int i = 10; i <= 99; i++) {
            if (Check(i)) {
                sum += i;
            }
        }
        System.out.println(" tong cac so nguyen to co hai chu so " + sum);
    }

    public static boolean Check(int n) {
        if (n <= 1) {
            return false; // nếu nhập n là số âm sẽ báo sai
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
