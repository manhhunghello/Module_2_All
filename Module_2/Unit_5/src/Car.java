
public class Car {
    private String name;
    private String engine;
    public static int numberOfCars;

    public Car(String name, String engine) {

        this.name = name;

        this.engine = engine;

        numberOfCars++;

    }
    // getters and setters

        public static void main(String[] args) {

            Car car1 = new Car("Mazda 3","Skyactiv 3");

            System.out.println(Car.numberOfCars + " " + car1.name + " " + car1.engine); // NumberOfCars là biến static nên phải chấm với car

            Car car2 = new Car("Mazda", "6Skyactiv 6");

            System.out.println(Car.numberOfCars + " " + car2.name + car2 . engine);

        }




}


