package manager;

import model.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerProduct {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Product> productList = new ArrayList<>();

    public void addProduct() {
        Product product = create();
        productList.add(product);

    }

    public void editProduct() {
        System.out.println("Mã sản phẩm mới: ");
        String code = scanner.nextLine();

        String name = checkInputName();

        System.out.println("Giá sản phẩm mới: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.println("Số lượng sản phẩm mới: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        System.out.println("Mô tả sản phẩm mới: ");
        String description = scanner.nextLine();
        System.out.println("Nhap name muon sua mới:");
        Product product = new Product(code, name, price, quantity, description);
        String nameE = scanner.nextLine();
        int indexE = findIndexByName(nameE);
        if (indexE != -1)
            productList.set(indexE, product);

        else
            System.err.println("Không có " + name + " trong danh sách");


    }

    public void delete() {

        System.out.println(" Nhập mã sản phẩm muốn xoá: ");
        String code = scanner.nextLine();
//        String product = scanner.nextLine();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getCode().equals(code)) {
                System.out.println("Bạn có chắc chắn muốn xóa sản phẩm này không? Nhập Y để xác nhận ");
                String input = scanner.nextLine();
                if (input.equals("Y")) {
                    productList.remove(i);
                    System.out.println("Sản phẩm đã bị xóa thành công");

                } else {
                    System.out.println("Huỷ xoá");
                }
                return;
            }
        }
        System.out.println(" không tìm thấy sản phẩm có mã muốn xoá");


    }


    public int findIndexByName(String name) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void show() {
        if (productList.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống. ");

            return;
        }
        System.out.println("Danh sách sản phẩm:");
        System.out.printf("%-15s%-25s%-18s%-23s%s", "Mã sản phẩm", "Tên sản phẩm", "Giá sản phẩm", "Số lượng sản phẩm", "Mô tả sản phẩm\n");
        for (Product s : productList) {
            System.out.printf("%-15s%-25s%-18s%-23s%s", s.getCode(), s.getName(), s.getPrice(), s.getQuantity(), s.getDescription() + "\n");

        }
    }

    public String checkInputName() {
        System.out.println("Tên sản phẩm: ");
        String name = scanner.nextLine();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equals(name)) {
                System.out.println(" Ten da ton tai");
                return checkInputName();
            }
        }
        return name;

    }

    public Product create() {
        System.out.println("Mã sản phẩm: ");
        String code = scanner.nextLine();
        String name = checkInputName();


        System.out.println("Giá sản phẩm: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.println("Số lượng sản phẩm: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        System.out.println("Mô tả sản phẩm: ");
        String description = scanner.nextLine();
        return new Product(code, name, price, quantity, description);


    }


}

