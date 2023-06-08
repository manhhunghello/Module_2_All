package model;



public class Product {
    private String Code;
    private String Name;
    private double price;
    private int quantity;
    private String description;

    public Product() {
    }

    public Product(String code, String name, double price, int quantity, String description) {
        Code = code;
        Name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    //    public String toString() {
//        return "Product{" +
//                "code='" + code + '\'' +
//                "name='" + name + '\'' +
//                "price='" + price + '\'' +
//                "quantity='" + quantity + '\'' +
//                "description='" + description + '\'' +
//                '}';
//    }
//    public void addProduct(){
//        System.out.println("Thêm sản phẩm mới:");
//        System.out.println("Nhập mã sản phẩm: ");
//        String code = scanner.nextLine();
//        System.out.println("Nhập d sản phẩm: ");
//        }




}




