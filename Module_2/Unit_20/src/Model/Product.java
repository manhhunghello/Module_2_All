package Model;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L; // đảm bảo tính nhất quán
    private int id;
    public static int idUp;

    private String name;
    private double price;

    private Brand brand; // Nhãn hàng
    private String describe; // mô tả

    public Product() {
    }

    public Product(String name, double price, Brand brand, String describe) {
        this.id = ++idUp;
        this.price = price;
        this.name = name;
        this.brand = brand;
        this.describe = describe;
    }

    public Product(int id, String name, double price, Brand brand, String describe) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.brand = brand;
        this.describe = describe;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getIdUp() {
        return idUp;
    }

    public static void setIdUp(int idUp) {
        Product.idUp = idUp;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + price + "," + brand + "," + describe;
    }
    public void display() {
        System.out.printf("%-15s%-35s%-15s%-18s%s",
                this.id, this.name, this.brand.getBrandName(), this.price, this.describe + "\n");
    }


}
