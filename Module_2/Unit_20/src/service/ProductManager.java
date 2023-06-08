package service;

import Model.Brand;
import Model.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductManager implements Manager,FUNCTION {
    private final List<Product> productList;
    private final Scanner scanner;
    FileManager fileManager;
    private final BrandManager brandManager;


    public ProductManager(BrandManager brandManager) {
        productList = new ArrayList<>();
        scanner = new Scanner(System.in);
        fileManager = new FileManager();
        this.brandManager = brandManager;
        fileManager.readFileProduct(productList,brandManager);

        checkDefaultIndex();

    }

    @Override
    public List<Product> add() {
        System.out.println(" Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        double price;
        while (true) {
            System.out.println(" Nhập giá sản phẩm: ");
            try {
                price = Double.parseDouble(scanner.nextLine());
                if (price < 0) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }

        }
        Brand brand = getBrand();
        System.out.println(" Nhập mô tả cho sản phẩm.  ");
        String describe = scanner.nextLine();
        Product product = new Product(name, price, brand, describe);
        productList.add(product);
        fileManager.writeFileProduct(productList);
        display();
        return productList;
    }


    @Override
    public List<Product> update() {
        Product product = getById();
        if (product != null) {
            System.out.println("Enter Name: ");
            String name = scanner.nextLine();
            if (!name.equals("")) {
                product.setName(name);
            }
            double price;
            while (true) {
                System.out.println("Enter Price: ");
                try {
                    price = Double.parseDouble(scanner.nextLine());
                    if (price > 0) {
                        product.setPrice(price);
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(" Vui lòng nhập lại số tiền");
                }
            }
            brandManager.display();
            System.out.println(" Enter Brand: ");
            product.setBrand(getBrand());
            System.out.println("Enter describe: ");
            String describe = scanner.nextLine();
            product.setDescribe(describe);

        }
        fileManager.writeFileProduct(productList);
        display();
        return productList;
    }

    @Override
    public List<Product> delete() {
        Product product = getById();
        if (product != null) {
            productList.remove(product);
        }
        fileManager.writeFileProduct(productList);
        display();
        return productList;
    }

    @Override
    public void sortByName() {
        productList.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        display();
    }

    @Override
    public void sortByPrice() {
        productList.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() > o2.getPrice()) return 1;
                else if (o1.getPrice() < o2.getPrice()) return -1;
                else return 0;
            }
        });
        display();
    }

    @Override
    public void search() {
        System.out.println("Nhập tên bạn muốn tìm kiếm :");
        String name = scanner.nextLine();
        for (Product p : productList) {
            if (p.getName().contains(name)) {
                System.out.println(p);
            }
        }
    }

    @Override
    public void display() {
        System.out.printf("%-15s%-35s%-15s%-18s%s",
                "Id", "Name", "Brand", "Price", "Description\n");

        for (Product p : productList) {
            p.display();
        }
    }

    public Product getById() {
        int id;
        do {
            try {
                display();
                System.out.println("Nhập Id bạn muốn chỉnh sửa: ");
                id = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println(" Sai định dạng ! Vui lòng nhập lại ");
            }
        } while (true);
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    private Brand getBrand() {
        brandManager.display();
        Brand brand;
        do {
            brand = brandManager.getByIdBrand();
        } while (brand == null);
        return brand;
    }

    private void checkDefaultIndex() {
        if (productList.isEmpty()) {
            Product.idUp = 0;
        } else {
            Product.idUp = productList.get(productList.size() - 1).getId();
        }
    }
}
