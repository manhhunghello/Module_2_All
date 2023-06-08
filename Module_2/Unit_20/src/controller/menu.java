package controller;

import service.AccountManager;
import service.BrandManager;
import service.ProductManager;

import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountManager accountManager = new AccountManager();
        BrandManager brandManager = new BrandManager();
        ProductManager productManager = new ProductManager(brandManager);


        int choice = 0;
        do {
            System.out.println("-------------- MENU ----------------");
            System.out.println("Vui lòng chọn chức năng: ");
            System.out.println(" Click Enter để mua hàng luôn: ");

            System.out.println(
                    """
                            1.Đăng Nhập
                            2.Đăng Ký
                            0.Thoát
                            """);
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                menuCart(scanner);

            }
            switch (choice) {
                case 1:
                    String result = accountManager.login();

                    if (result == null) {
                        System.out.println("Đăng Nhập Thất bại");
                    } else if (result.equals("admin")) {
                        menuAdmin(scanner, productManager, brandManager);
                    } else  {
                        menuClient(productManager, scanner);
                    }

                    break;
                case 2:
                    accountManager.creatNewAccount();
                    break;
                case 0:
                    System.exit(0);
                    break;

            }


        } while (true);

    }

    private static void menuBrand(Scanner scanner, BrandManager brandManager) {
        int choiceBrand = -1;
        do {
            System.out.println("----------------Menu Brand----------------");
            System.out.println(
                                        """ 
                                            1. Thêm thương hiệu 
                                            2. Sửa thương hiệu
                                            3. Xoá thương hiệu
                                            4. Hiển thị thương hiệu
                                            0. Thoát""");
            try {
                choiceBrand = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" Sai định dạng, vui lòng nhập số !!");
            }
            switch (choiceBrand) {
                case 1:
                    brandManager.add();
                    break;
                case 2:
                    brandManager.update();
                    break;
                case 3:
                    brandManager.delete();
                    break;
                case 4:
                    brandManager.display();
                    break;
            }
        } while (choiceBrand != 0);
    }


    public static void menuAdmin(Scanner scanner, ProductManager productManager, BrandManager brandManager) {
        int choice = -1;
        do {
            System.out.println("----------------Admin -------------------");
            System.out.println(
                    """
                            1. Thêm sản phẩm
                            2 . Sửa sản phẩm
                            3 . Xoá sản phẩm
                            4 . Menu thương hiệu
                            5. Hiển thị sản phẩm
                            6. Sắp xếp theo tên
                            7. Sắp xếp theo giá
                            8. Tìm kiếm theo tên
                            0. Thoát """);
            System.out.println("Nhập lựa chọn của bạn. ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Sai định dạng, vui lòng nhập số  !!");
            }
            switch (choice) {
                case 1:
                    productManager.add();
                    break;
                case 2:
                    productManager.update();
                    break;
                case 3:
                    productManager.delete();
                    break;
                case 4:
                    menuBrand(scanner, brandManager);
                    break;
                case 5:
                    productManager.display();
                    break;
                case 6:
                    productManager.sortByName();
                    break;
                case 7:
                    productManager.sortByPrice();
                    break;
                case 8:
                    productManager.search();
                    break;

            }
        } while (choice != 0);


    }

    public static void menuCart(Scanner scanner) {
        int choice = -1;
        do {
            System.out.println("-- Cart --");
            System.out.println("1 . Hiển thị");
            System.out.println("2 . Shopping");
            System.out.println("3 . Xoá sản phẩm muốn mua");
            System.out.println("4 . Thanh Toán");
            System.out.println("0. Thoát");
            System.out.println("Vui lòng nhập lựa chọn");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi định dang, vui lòng nhập số" +
                        " !!");
            }
            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
            }
        } while (choice != 0);
    }

    public static void menuClient(ProductManager productManager, Scanner scanner) {
        productManager.display();
        int choice = -1;
        do {
            System.out.println(" --------------- Xin chào khách Hàng ----------------- ");
            System.out.println(
                            """
                                     1 . Sắp sếp theo tên
                                     2 . sắp sếp theo giá
                                     3 . tìm kiếm
                                     4 . Lọc Sản phẩm
                                     0. Thoát""");
            System.out.println("Vui lòng nhập lựa chọn");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Sai định dạng, vui lòng nhập số !!!");
            }
            switch (choice) {
                case 1:
                    productManager.sortByName();
                    break;
                case 2:
                    productManager.sortByPrice();
                    break;
                case 3:
                    productManager.search();
                    break;
            }
        } while (choice != 0);

    }
}
