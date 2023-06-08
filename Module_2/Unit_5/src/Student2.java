
public class Student2 {
    private int rollno;
    private String name;
    private static String college = "BBDIT";

    //constructor to initialize the variable


    public Student2(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

    //static method to change the value of static variable
    static void change() {
        college = "CODEGYM";
    }

    //method to display values
    void display() {
        System.out.println(rollno + " " + name + " " + college);
    }

//    public static void main(String[] args) {
//        Student2 s1 = new Student2(111,"dfghj");
//        s1.display();
//    }
    public static class TestStaticMethod {
        public static void main(String args[]) {
            Student2.change(); //calling change method

            //creating objects
            Student2 s1 = new Student2(111, "Hoang");
            Student2 s2 = new Student2(222, "Khanh");
            Student2 s3 = new Student2(333, "Nam");

            //calling display method
            s1.display();
            s2.display();
            s3.display();
        }
    }


}

