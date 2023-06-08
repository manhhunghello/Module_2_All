package case_study.model;



import java.io.Serializable;

public class ShoppingCart implements Serializable {
    public static final long serialVersionUID = 1L;
    private int id;
    public static int idUpShoppingCart;
    private Cart idCart;
    private Product product;
    private int quantity;

    public ShoppingCart() {
    }

    public ShoppingCart(Cart idCart, Product product, int quantity) {
        this.id = ++idUpShoppingCart;
        this.idCart = idCart;
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cart getIdCart() {
        return idCart;
    }

    public void setIdCart(Cart idCart) {
        this.idCart = idCart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return id + "," + idCart + "," + product + "," + quantity;
    }
    public void display() {
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%s",
                this.id, this.idCart.getName(), this.idCart.getDate(),
                this.product.getId(), this.product.getName(), this.product.getBrand().getBrandName(),
                this.product.getPrice(), this.product.getDescribe(),
                this.quantity + "\n");
    }

}
