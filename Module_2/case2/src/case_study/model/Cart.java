package case_study.model;

import java.io.Serializable;

import java.time.LocalDate;

public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    public static int idUpCart;
    private String name;
    private LocalDate date;
    private boolean isPaid;

    public Cart() {
    }

    public Cart(String name) {
        this.id = ++idUpCart;
        this.name = name;
        this.date = LocalDate.now();
        this.isPaid = false;

    }

    public Cart(int id, String name, LocalDate date, boolean isPaid) {
        this.id = ++idUpCart;
        this.name = name;
        this.date = LocalDate.now();
        this.isPaid = isPaid;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + date;
    }
}
