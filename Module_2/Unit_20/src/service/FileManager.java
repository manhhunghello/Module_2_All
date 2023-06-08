package service;

import Model.Account;
import Model.Brand;
import Model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

//    public void readFileProduct(List<Product> productList, BrandManager brandManager) {
//        File file = new File("/Users/manhhung/Codegym/Module2/Module_2/Unit_20/src/data/Product");
//
//        try {
//            FileReader fileReader = new FileReader(file);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String string;
//            while ((string = bufferedReader.readLine()) != null) {
//                String[] arrProduct = string.split(",");
//                Brand brand = brandManager.getByNameBrand(arrProduct[4]);
//                Product product = new Product(Integer.parseInt(arrProduct[0]), arrProduct[1], Double.parseDouble(arrProduct[2]),
//                        brand, arrProduct[5]);
//                productList.add(product);
//            }
//            bufferedReader.close();
//            fileReader.close();
//
//        } catch (IOException e) {
//            System.out.println();
//        }
//
//    }


    public void readFileProduct(List<Product> productList, BrandManager brandManager) {
        File file = new File("/Users/manhhung/Codegym/Module2/Module_2/Unit_20/src/data/Product");

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                String[] arrProduct = string.split(",");
                if (arrProduct.length >= 6) {
                    Brand brand = brandManager.getByNameBrand(arrProduct[4]);
                    Product product = new Product(Integer.parseInt(arrProduct[0]), arrProduct[1], Double.parseDouble(arrProduct[2]),
                            brand, arrProduct[5]);
                    productList.add(product);
                } else {
                    // Xử lý trường hợp dữ liệu không đủ phần tử
                    System.out.println("Dữ liệu không hợp lệ: " + string);
                }
            }
            bufferedReader.close();
            fileReader.close();

        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi đọc tệp.");
            e.printStackTrace();
        }
    }


    public void writeFileProduct(List<Product> productList) {
        File file = new File("/Users/manhhung/Codegym/Module2/Module_2/Unit_20/src/data/Product");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Product p : productList) {
                bufferedWriter.write(p.toString() + "\n");
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public void writeFileBrand(List<Brand> brandList) {
        File file = new File("/Users/manhhung/Codegym/Module2/Module_2/Unit_20/src/data/Brand");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Brand b : brandList) {
                bufferedWriter.write(b.toString() + "\n");
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void readFileBrand(List<Brand> brandList) {
        File file = new File("/Users/manhhung/Codegym/Module2/Module_2/Unit_20/src/data/Brand");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                String[] arrBrand = string.split(",");
                Brand brands = new Brand(Integer.parseInt(arrBrand[0]), arrBrand[1]);
                brandList.add(brands);
            }
            bufferedReader.close();
            fileReader.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public  Account readFileAccountLogIn() {
        List<Account> accountList = new ArrayList<>();
        File file = new File("/Users/manhhung/Codegym/Module2/Module_2/Unit_20/src/data/Account.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            accountList = (List<Account>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException ignored) {
        }
        return accountList.get(0);
    }

    public List<Account> readFileAccount(){
        File file = new File("/Users/manhhung/Codegym/Module2/Module_2/Unit_20/src/data/Account.txt");
        List<Account> accountList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            accountList = (List<Account>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountList;
    }
    public void writeFileAccount(List<Account> accountList) {
        File file = new File("/Users/manhhung/Codegym/Module2/Module_2/Unit_20/src/data/Account.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(accountList);
            objectOutputStream.close();
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void writeFileAccountLogIn(List<Account> accountList){
        File file = new File("/Users/manhhung/Codegym/Module2/Module_2/Unit_20/src/data/AccountLogIn.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(accountList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            // e.getMessage(): Phương thức này trả về một thông báo lỗi mô tả ngắn gọn về lỗi xảy ra.
            System.out.println(e.getMessage());
        }

    }
}
