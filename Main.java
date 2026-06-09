import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Student Grade System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Calculate Average of All Students");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> displayAll();
                case 3 -> searchStudent();
                case 4 -> overallAverage();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    public static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        int[] marks = new int[5];
        System.out.println("Enter 5 subject marks:");
        for (int i = 0; i < 5; i++) {
            marks[i] = sc.nextInt();
        }
        sc.nextLine();

        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    public static void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        for (Student s : students) {
            s.displayStudent();
        }
    }

    public static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        String id = sc.nextLine();

        for (Student s : students) {
            if (s.getStudentID().equalsIgnoreCase(id)) {
                s.displayStudent();
                return;
            }
        }
        System.out.println("Student not found!");
    }

    public static void overallAverage() {
        if (students.isEmpty()) {
            System.out.println("No students available!");
            return;
        }

        double total = 0;

        for (Student s : students) {
            total += s.getAverage();
        }

        double avg = total / students.size();
        System.out.println("Overall Class Average: " + avg);
    }
}