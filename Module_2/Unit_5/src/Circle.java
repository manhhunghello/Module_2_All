
public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {}

    public Circle(double radius) {
        this.radius = radius;
    }

     private double getRadius() { // thay đổi access modifier của phương thức này
        return radius;

    }

     private double getArea() { // thay đổi access modifier của phương thức này
        return radius * radius * Math.PI;
    }

    public static class TestCircle {
        public static void main(String[] args) {
            Circle circle = new Circle(2.0);


            // Gọi phương thức getRadius() và getArea() trong lớp Circle, đang ở trong phạm vi access modifier private
            // Nếu bạn muốn sử dụng phương thức này từ bên ngoài lớp Circle thì sẽ bị lỗi biên dịch.
            double radius = circle.getRadius();// hoặc viết là System.out.println("Radius: " + circle.getRadius());
            double area = circle.getArea();

            System.out.println("Radius = " + radius);
            System.out.println("Area = " + area);

        }
    }
}

