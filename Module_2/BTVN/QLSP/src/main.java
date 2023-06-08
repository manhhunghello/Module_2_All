import manager.ManagerProduct;
import model.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagerProduct ll = new ManagerProduct();

        while (true) {
            System.out.println();
            System.out.println(" -------- Chương trình quản lý sản phẩm -------------");
            System.out.println(" Chọn chức năng theo số để tiếp tục");

            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới ");
            System.out.println("3. Cập nhật ");
            System.out.println("4. Xoá ");
            System.out.println("5. Sắp xếp ");
            System.out.println("6. Tìm sản phẩm có giá đắt nhất");
            System.out.println("7. Đọc vào file");
            System.out.println("8. Ghi vào file");
            System.out.println("9. Thoát");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    ll.show();
                    break;
                case 2:
                    ll.addProduct();
                    break;
                case 3:
                    ll.editProduct();
                    break;
                case 4:
                    ll.delete();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    System.exit(0);


            }
        }
    }
}
