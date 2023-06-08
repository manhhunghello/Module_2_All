package case_study.service;

import case_study.model.Product;
import case_study.model.Cart;
import case_study.model.ShoppingCart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CartManager {
    Scanner scanner = new Scanner(System.in);
    List<Cart> carts;
    List<ShoppingCart> shoppingCarts;
    ProductManager productManager;
    FileManager fileManager;

    public CartManager(ProductManager productManager) {
        fileManager = new FileManager();
        carts = new ArrayList<>();
        shoppingCarts = new ArrayList<>();
        shoppingCarts = fileManager.readFileCart(shoppingCarts);
        this.productManager = productManager;
        checkDefaultIndex();
    }

    public void shopping() {
        String name = fileManager.readFileAccountLogIn().getUserName();
        Cart cart = new Cart(name);
        for (Cart c : carts) {
            if (c.getName().equals(name) && !c.isPaid()) {
                cart = c;
            }
        }
        productManager.display();
        Product p = productManager.getById();
        if (p != null) {
            System.out.println(" Enter the product you want to buy :");
            int quantity = Integer.parseInt(scanner.nextLine());
            addCart(p, quantity, cart);
        }else {
            System.out.println(" No products !");
        }
    }

    public void addCart(Product product, int quantity, Cart cart) {
        ShoppingCart s = new ShoppingCart(cart, product, quantity);
        boolean flag = false;
        for (ShoppingCart a : shoppingCarts) {
            if (a.getProduct().getName().equals(product.getName()) && cart.getName().equals(a.getIdCart().getName()) && !a.getIdCart().isPaid()) {
                a.setQuantity(a.getQuantity() + quantity);
                flag = true;
            }
        }
        if (!flag) {
            shoppingCarts.add(s);
        }

        fileManager.writeFileCart(shoppingCarts);
    }

    public void displayCart() {
        double sum = 0;
        String userName = fileManager.readFileAccountLogIn().getUserName();
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%s",
                "Id", "UserName", "Date-buy", "id-Pro", "Name-Product", "Brand", "Price", "Description", "Quantity\n");
        for (ShoppingCart s : shoppingCarts) {
            if (!s.getIdCart().isPaid()) {
                if (userName.equals(s.getIdCart().getName())) {
                    sum += s.getProduct().getPrice() * s.getQuantity();
                    s.display();
                }
            }
        }
        System.out.println("The total amount you need to pay is : " + sum);
    }

    public void deleteCart() {
        displayCart();
        int id;
        boolean flag = false;
        do {
            try {
                System.out.println("Enter id you want: ");
                id = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Have error, please try again!");
            }

        } while (true);
        for (int i = 0; i < shoppingCarts.size(); i++) {
            if (id == shoppingCarts.get(i).getId()) {
                shoppingCarts.remove(i);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("No id you want to delete");
        }
        fileManager.writeFileCart(shoppingCarts);
    }

    private void checkDefaultIndex() {
        if (shoppingCarts.isEmpty()) {
            ShoppingCart.idUpShoppingCart = 0;
        } else {
            Product.idUp = shoppingCarts.get(shoppingCarts.size() - 1).getId();
        }
    }

    public void pay() {
        String userName = fileManager.readFileAccountLogIn().getUserName();
        for (ShoppingCart shoppingCart : shoppingCarts) {
            if (shoppingCart.getIdCart().getName().equals(userName)) {
                shoppingCart.getIdCart().setPaid(true);
                System.out.println("Payment success");
                fileManager.writeFileCart(shoppingCarts);
            }
        }
    }

    public void totalToPay() {
        double totalMoney = 0;
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%s",
                "Id", "UserName", "Date-buy", "Id-Pro", "Name-Product", "Brand", "Price", "Description", "Quantity\n");
        for (ShoppingCart s : shoppingCarts) {
            if (s.getIdCart().isPaid() == true) {
                totalMoney += s.getProduct().getPrice() * s.getQuantity();
                s.display();
            }
            System.out.println("Total store revenue is :" + totalMoney);
        }
    }


}
