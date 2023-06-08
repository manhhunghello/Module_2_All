import java.util.Scanner;

public class NextDateCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập ngày, tháng và năm từ người dùng
        System.out.print("Nhập ngày: ");
        int day = scanner.nextInt();

        System.out.print("Nhập tháng: ");
        int month = scanner.nextInt();

        System.out.print("Nhập năm: ");
        int year = scanner.nextInt();

        // Tính ngày tiếp theo
        int nextDay = day;
        int nextMonth = month;
        int nextYear = year;

        // Xác định số ngày trong tháng hiện tại
        int daysInMonth = getDaysInMonth(month, year);

        if (day < daysInMonth) {
            nextDay++;
        } else if (month < 12) {
//            Đoạn này kiểm tra xem tháng hiện tại có nhỏ hơn 12 hay không.
//            Nếu đúng, nghĩa là tháng hiện tại chưa là tháng cuối cùng của năm,
//            ta sẽ đặt ngày tiếp theo là 1 và tăng tháng lên 1 để lấy tháng tiếp theo.
            nextDay = 1;
            nextMonth++;
        } else if (month == 12 && day == daysInMonth && month <=12){
//        Đoạn mã này chạy khi cả ngày và tháng đều là ngày cuối cùng của tháng và năm.
//        Trong trường hợp này, ta sẽ đặt ngày tiếp theo là 1,
//        tháng tiếp theo là 1 và tăng năm lên 1 để lấy năm tiếp theo.

            nextDay = 1;
            nextMonth = 1;
            nextYear++;
        }
        // Kiểm tra nếu ngày, tháng và năm âm
        if (nextYear < 0 || nextMonth < 0 || nextDay < 0) {
            System.out.println("Ngày tiếp theo không hợp lệ!");
            return;
        }
        if (nextMonth > 12 || day == daysInMonth) {
            int yearsToAdd = nextMonth / 12;
            int monthsLeft = nextMonth % 12;
            nextMonth = monthsLeft;
            nextYear += yearsToAdd;
            nextDay = 1 ;

        }


        // In kết quả
        System.out.println("Ngày tiếp theo là: " + nextDay + "/" + nextMonth + "/" + nextYear);
    }


    // Hàm để xác định số ngày trong một tháng cụ thể
    public static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2: // Tháng 2 (xác định số ngày trong tháng 2 tùy thuộc vào năm nhuận)
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 0; // Trường hợp không hợp lệ, trả về 0
        }
    }

    // Hàm để kiểm tra xem một năm có phải là năm nhuận hay không
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }


}


