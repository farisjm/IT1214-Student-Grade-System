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

    public static void searchStudent(Scanner sc) {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        for (int i = 0; i < count; i++) {
            if (students[i].id.equalsIgnoreCase(id)) {
                System.out.println("Found: " + students[i].name + " - " + students[i].marks);
                return;
            }
        }

        System.out.println("Not Found");
    }

    public static void calculateAverage() {
        if (count == 0) {
            System.out.println("No students available.");
            return;
        }

        double total = 0;

        for (int i = 0; i < count; i++) {
            total += students[i].marks;
        }

        System.out.println("Average: " + (total / count));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Calculate Average");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    searchStudent(sc);
                    break;
                case 3:
                    calculateAverage();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 4);

        sc.close();
    }
}
