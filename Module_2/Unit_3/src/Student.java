package Unit_3;// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.


public class Student {
    int id;
    String name;
    int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
 class Main {
    public static void main(String[] args) {
        Student kinh = new Student(1,"King", 18);
        Student king = new Student(1,"King", 18);
        System.out.println(kinh==king);

    }

}
