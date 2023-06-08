package Unit_7;

public class demo {
}

/*Chuong trinh vi du ve bien static trong Java*/
 class Student {
    int rollno;
    String name;
    static String college = "BachKhoa";

    Student(int r, String n) {
        rollno = r;
        name = n;
    }

    void display() {
        System.out.println(rollno + " " + name + " " + college);
    }

    public static void main(String args[]) {
        Student s1 = new Student(111, "Hoang");
        Student s2 = new Student(222, "Thanh");
        s1.display();
        s2.display();
    }
}