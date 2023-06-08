package pask1;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("John"); // thuộc tính có từ khóa protected được truy cập từ lớp con
       Student student1 = new Student();
        student1.setName("hung");
        Student student2 = new Student();
        student2.setName("fyfh");
        student.walk(); // phương thức có từ khóa protected được truy cập từ lớp con
        student.study();
        student.display();
        student1.display();
//        System.out.println(student1.getName());
//        System.out.println(student.getName());


    }
}
