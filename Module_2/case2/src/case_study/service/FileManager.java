package case_study.service;

import case_study.model.Account;
import case_study.model.Product;
import case_study.model.Brand;
import case_study.model.ShoppingCart;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileManager {
    public void readFileProduct(List<Product> productList, BrandManager brandManager) {
        File file = new File("C:\\C0223i1\\Module2\\src\\case_study\\data\\Product");

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                String[] arrProduct = string.split(",");
                Brand brand = brandManager.getByNameBrand(arrProduct[4]);
                Product product = new Product(Integer.parseInt(arrProduct[0]), arrProduct[1], Double.parseDouble(arrProduct[2]),
                        brand, arrProduct[5]);
                productList.add(product);
            }
            bufferedReader.close();
            fileReader.close();

        } catch (IOException e) {
            System.out.println();
        }

    }

    public void writeFileProduct(List<Product> productList) {
        File file = new File("C:\\C0223i1\\Module2\\src\\case_study\\data\\Product");
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
        File file = new File("C:\\C0223i1\\Module2\\src\\case_study\\data\\Brand");
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
        File file = new File("C:\\C0223i1\\Module2\\src\\case_study\\data\\Brand");
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

    public void writeFileCart(List<ShoppingCart> shoppingCarts) {
        File file = new File("C:\\C0223i1\\Module2\\src\\case_study\\data\\Cart.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(shoppingCarts);
            objectOutputStream.close();
            fileOutputStream.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<ShoppingCart> readFileCart(List<ShoppingCart> shoppingCarts) {
        File file = new File("C:\\C0223i1\\Module2\\src\\case_study\\data\\Cart.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            shoppingCarts = (List<ShoppingCart>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
        }
        return shoppingCarts;
    }

    public void writeFileAccount(List<Account> accountList) {
        File file = new File("C:\\C0223i1\\Module2\\src\\case_study\\data\\Account.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(accountList);
            objectOutputStream.close();
            fileOutputStream.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public  List<Account> readFileAccount() {
        List<Account> accountList = new ArrayList<>();
        File file = new File("C:\\C0223i1\\Module2\\src\\case_study\\data\\Account.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            accountList = (List<Account>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {

        }
        return accountList;
    }
    public  Account readFileAccountLogIn() {
        List<Account> accountList = new ArrayList<>();
        File file = new File("C:\\C0223i1\\Module2\\src\\case_study\\data\\AccountLogIn.txt");
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
    public void writeFileAccountLogIn(List<Account> accountList) {
        File file = new File("C:\\C0223i1\\Module2\\src\\case_study\\data\\AccountLogIn.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(accountList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
