package pask1;

public class Person {
    private String name; // thuộc tính có từ khóa protected

    public void walk() { // phương thức có từ khóa protected
        System.out.println("Walking...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}