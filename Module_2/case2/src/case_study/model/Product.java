package case_study.model;

import case_study.model.Brand;

import java.io.Serializable;


public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    public static int idUp;
    private double price;
    private String name;
    private Brand brand;
    private String describe;

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
        System.out.printf("%-15s%-25s%-15s%-18s%s",
                this.id, this.name, this.brand.getBrandName(), this.price, this.describe + "\n");
    }
}
