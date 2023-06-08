//package BTVN;
//
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.Scanner;
//
//class Employee {
//    private static int count = 1;
//    private int id;
//    private String name;
//    private String phone;
//    private String birthday;
//
//    public Employee(String name, String phone, String birthday) {
//        this.id = count++;
//        this.name = name;
//        this.phone = phone;
//        this.birthday = birthday;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public String getBirthday() {
//        return birthday;
//    }
//
//    public int getAge() {
//        return 0;
//    }
//
//    public void displayAllEmployees() {
//
//    }
//
//    public void addPartTimeEmployee() {
//
//    }
//
//    public void addFullTimeEmployee() {
//
//    }
//
//    public void calculatePay() {
//
//    }
//
//    public void deleteEmployee(int idToDelete) {
//
//    }
//
//    public void updateEmployee(int idToUpdate) {
//
//    }
//
//    public void searchEmployee(String nameToSearch) {
//
//    }
//
//    public void sortByAge() {
//
//    }
//
//    public void exit() {
//
//    }
//}
//
//class PartTimeEmployee extends Employee {
//    private int hoursWorked;
//
//    public PartTimeEmployee(String name, String phone, String birthday, int hoursWorked) {
//        super(name, phone, birthday);
//        this.hoursWorked = hoursWorked;
//    }
//
//    public int getHoursWorked() {
//        return hoursWorked;
//    }
//
//    public int calculateSalary() {
//        return hoursWorked * 30000;
//    }
//}
//
//class FullTimeEmployee extends Employee {
//    private double payRate;
//
//    public FullTimeEmployee(String name, String phone, String birthday, double payRate) {
//        super(name, phone, birthday);
//        this.payRate = payRate;
//    }
//
//    public double getPayRate() {
//        return payRate;
//    }
//
//    public int calculateSalary() {
//        return (int) (3000000 * payRate);
//    }
//}
//
//class EmployeeManagement {
//    private Employee[] employees;
//    private int numOfEmployees;
//
//    public EmployeeManagement(int size) {
//        employees = new Employee[size];
//        numOfEmployees = 0;
//    }
//
//    public void addEmployee(Employee e) {
//        employees[numOfEmployees] = e;
//        numOfEmployees++;
//    }
//
//    public void displayEmployees() {
//        for (int i = 0; i < numOfEmployees; i++) {
//            Employee e = employees[i];
//            System.out.println("ID: " + e.getId());
//            System.out.println("Name: " + e.getName());
//            System.out.println("Phone: " + e.getPhone());
//            System.out.println("Birthday: " + e.getBirthday());
//            if (e instanceof PartTimeEmployee) {
//                PartTimeEmployee pte = (PartTimeEmployee) e;
//                System.out.println("Hours Worked: " + pte.getHoursWorked());
//            } else if (e instanceof FullTimeEmployee) {
//                FullTimeEmployee fte = (FullTimeEmployee) e;
//                System.out.println("Pay Rate: " + fte.getPayRate());
//            }
//            System.out.println();
//        }
//    }
//
//    public void calculateSalary() {
//        for (int i = 0; i < numOfEmployees; i++) {
//            Employee e = employees[i];
//            System.out.println("ID: " + e.getId());
//            System.out.println("Name: " + e.getName());
//            if (e instanceof PartTimeEmployee) {
//                PartTimeEmployee pte = (PartTimeEmployee) e;
//                System.out.println("Salary: " + pte.calculateSalary());
//            } else if (e instanceof FullTimeEmployee) {
//                FullTimeEmployee fte = (FullTimeEmployee) e;
//                System.out.println("Salary: " + fte.calculateSalary());
//            }
//            System.out.println();
//        }
//    }
//
//    public void deleteEmployee(int id) {
//        int index = -1;
//        for (int i = 0; i < numOfEmployees; i++) {
//            if (employees[i].getId() == id) {
//                index = i;
//                break;
//            }
//        }
//        if (index == -1) {
//            System.out.println("Employee with ID " + id + " not found.");
//        } else {
//            for (int i = index; i < numOfEmployees - 1; i++) {
//                employees[i] = employees[i + 1];
//            }
//            numOfEmployees--;
//            System.out.println("Employee with ID " + id + " deleted successfully.");
//        }
//    }
//
//    public void updateEmployee(int id) {
//        int index = -1;
//        for (int i = 0; i < numOfEmployees; i++) {
//            if (employees[i].getId() == id) {
//                index = i;
//                break;
//            }
//        }
//        if (index == -1) {
//            System.out.println("Employee with ID " + id + " not found.");
//        } else {
//            Scanner input = new Scanner(System.in);
//            Employee e = employees[index];
//            System.out.println("Current Name: " + e.getName());
//            System.out.print("Enter New Name: ");
//            String name = input.nextLine();
//            System.out.println("Current Phone: " + e.getPhone());
//            System.out.print("Enter New Phone: ");
//            String phone = input.nextLine();
//            System.out.println("Current Birthday: " + e.getBirthday());
//            System.out.print("Enter New Birthday: ");
//            String birthday = input.nextLine();
//            if (e instanceof PartTimeEmployee) {
//                PartTimeEmployee pte = (PartTimeEmployee) e;
//                System.out.println("Current Hours Worked: " + pte.getHoursWorked());
//                System.out.print("Enter New Hours Worked: ");
//                int hoursWorked = input.nextInt();
//                pte = new PartTimeEmployee(name, phone, birthday, hoursWorked);
//                employees[index] = pte;
//            } else if (e instanceof FullTimeEmployee) {
//                FullTimeEmployee fte = (FullTimeEmployee) e;
//                System.out.println("Current Pay Rate: " + fte.getPayRate());
//                System.out.print("Enter New Pay Rate: ");
//                double payRate = input.nextDouble();
//                fte = new FullTimeEmployee(name, phone, birthday, payRate);
//                employees[index] = fte;
//            }
//            System.out.println("Employee with ID " + id + " updated successfully.");
//        }
//    }
//
//    public void searchEmployee(String name) {
//        boolean found = false;
//        for (int i = 0; i < numOfEmployees; i++) {
//            Employee e = employees[i];
//            if (e.getName().equals(name)) {
//                System.out.println("ID: " + e.getId());
//                System.out.println("Name: " + e.getName());
//                System.out.println("Phone: " + e.getPhone());
//                System.out.println("Birthday: " + e.getBirthday());
//                if (e instanceof PartTimeEmployee) {
//                    PartTimeEmployee pte = (PartTimeEmployee) e;
//                    System.out.println("Hours Worked: " + pte.getHoursWorked());
//                } else if (e instanceof FullTimeEmployee) {
//                    FullTimeEmployee fte = (FullTimeEmployee) e;
//                    System.out.println("Pay Rate: " + fte.getPayRate());
//                }
//                System.out.println();
//                found = true;
//            }
//        }
//        if (!found) {
//            System.out.println("Employee with name");
//        }
//        public void sortByAge () {
//            Arrays.sort(employees, 0, numOfEmployees, new Comparator<Employee>() {
//                @Override
//                public int compare(Employee e1, Employee e2) {
//                    return e1.getAge() - e2.getAge();
//                }
//            });
//            System.out.println("Employees sorted by age:");
//            displayAllEmployees();
//        }
//
//        public void exit () {
//            System.out.println("Exiting program...");
//            System.exit(0);
//        }
//    }
//
//    private void displayAllEmployees() {
//    }
//
//
//    public static void main(String[] args) {
//        Employee ems = new Employee();
//        Scanner input = new Scanner(System.in);
//        while (true) {
//            System.out.println("1. Display all employees");
//            System.out.println("2. Add a new part-time employee");
//            System.out.println("3. Add a new full-time employee");
//            System.out.println("4. Calculate pay for an employee");
//            System.out.println("5. Delete an employee");
//            System.out.println("6. Update an employee");
//            System.out.println("7. Search for an employee by name");
//            System.out.println("8. Sort employees by age");
//            System.out.println("9. Exit");
//            System.out.print("Enter your choice (1-9): ");
//            int choice = input.nextInt();
//            switch (choice) {
//                case 1:
//                    ems.displayAllEmployees();
//                    break;
//                case 2:
//                    ems.addPartTimeEmployee();
//                    break;
//                case 3:
//                    ems.addFullTimeEmployee();
//                    break;
//                case 4:
//                    ems.calculatePay();
//                    break;
//                case 5:
//                    System.out.print("Enter employee ID to delete: ");
//                    int idToDelete = input.nextInt();
//                    ems.deleteEmployee(idToDelete);
//                    break;
//                case 6:
//                    System.out.print("Enter employee ID to update: ");
//                    int idToUpdate = input.nextInt();
//                    ems.updateEmployee(idToUpdate);
//                    break;
//                case 7:
//                    input.nextLine(); // Consume newline character left by previous input
//                    System.out.print("Enter employee name to search: ");
//                    String nameToSearch = input.nextLine();
//                    ems.searchEmployee(nameToSearch);
//                    break;
//                case 8:
//                    ems.sortByAge();
//                    break;
//                case 9:
//                    ems.exit();
//                    break;
//                default:
//                    System.out.println("Invalid choice. Please enter a number from 1 to 9.");
//                    break;
//            }
//            System.out.println();
//        }
//    }
//}
//
//
//
