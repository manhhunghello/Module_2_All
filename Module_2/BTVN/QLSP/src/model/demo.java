//package model;
//
//import manager.ManagerProduct;
//
//import java.util.Scanner;
//
//public class demo {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        ManagerProduct managerProduct = new ManagerProduct();
//        while (true){
//            System.out.println("--------------------------------------------");
//            System.out.println("Quản lý sản phẩm");
//            System.out.println("1. Hiển thị");
//            System.out.println("2. Thêm");
//            System.out.println("3. Sửa");
//            System.out.println("4. Xóa");
//            System.out.println("5. Săp xếp");
//            System.out.println("6. Sản phẩm đắt nhất");
//            System.out.println("7. Thoát");
//            int choice = Integer.parseInt(scanner.nextLine());
//            switch (choice){
//                case 1:
//                    managerProduct.showALl();
//                    break;
//                case 2:
//                    managerProduct.add();
//                    break;
//                case 3:
//                    System.out.println("nhập name nuốn sửa");
//                    String nameE = scanner.nextLine();
//                    int indexE = managerProduct.findIndexByName(nameE);
//                    if (indexE!= -1){
//                        managerProduct.edit(indexE);
//                    }else {
//                        System.err.println("Không có " + nameE +" trong danh sách");
//                    }
//                    break;
//                case 4:
//                    System.out.println("nhập name nuốn xóa");
//                    String nameD = scanner.nextLine();
//                    int indexD = managerProduct.findIndexByName(nameD);
//                    if (indexD!= -1){
//                        managerProduct.delete(indexD);
//                    }else {
//                        System.err.println("Không có " + nameD +" trong danh sách");
//                    }
//                    break;
//                case 5:
//                    managerProduct.sortByPrice();
//                    break;
//                case 6:
//                    managerProduct.showALlPriceMax();
//                    break;
//                case 7:
//                    return;
//            }
//        }
//    }
//}