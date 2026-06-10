import java.util.Scanner;


class Student {
    String id;
    String name;
    double marks;

    Student(String id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
}
public class StudentGradeManagementSystem {

    static Student[] students = new Student[100];
    static int count = 0;

    public static void addStudent(Scanner sc) {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();
        sc.nextLine();

        students[count++] = new Student(id, name, marks);
        System.out.println("Student Added!");
    }
}
public class StudentGradeManagementSystem {
    public static void main(String[] args) {
        System.out.println("Student Grade System Started");
    }
}
