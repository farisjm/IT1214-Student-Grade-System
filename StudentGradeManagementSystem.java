import java.util.ArrayList;
import java.util.Scanner;


public class StudentGradeManagementSystem {

    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("    STUDENT GRADE MANAGEMENT SYSTEM");
        System.out.println("    University of Vavuniya");
        System.out.println("==================================================");

        int choice;

        do {
            printMenu();
            choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    searchStudentById();
                    break;
                case 4:
                    calculateAverageMark();
                    break;
                case 5:
                    System.out.println("\n  Exiting system. Goodbye!");
                    System.out.println("==================================================");
                    break;
                default:
                    System.out.println("\n  [!] Invalid choice. Please enter a number between 1 and 5.");
            }

        } while (choice != 5);

        scanner.close();
    }

    
    private static void printMenu() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("  MAIN MENU");
        System.out.println("--------------------------------------------------");
        System.out.println("  1. Add Student");
        System.out.println("  2. Display All Students");
        System.out.println("  3. Search Student by ID");
        System.out.println("  4. Calculate Average Mark");
        System.out.println("  5. Exit");
        System.out.println("--------------------------------------------------");
    }

    
    private static void addStudent() {
        System.out.println("\n  [ ADD STUDENT ]");

        System.out.print("  Enter Student ID   : ");
        String id = scanner.nextLine().trim();

        // Check for duplicate ID
        if (findStudentById(id) != null) {
            System.out.println("  [!] A student with ID \"" + id + "\" already exists.");
            return;
        }

        System.out.print("  Enter Student Name : ");
        String name = scanner.nextLine().trim();

        double marks = -1;
        while (marks < 0 || marks > 100) {
            marks = getDoubleInput("  Enter Marks (0-100): ");
            if (marks < 0 || marks > 100) {
                System.out.println("  [!] Marks must be between 0 and 100.");
            }
        }

        Student student = new Student(id, name, marks);
        studentList.add(student);

        System.out.println("\n  [✓] Student added successfully!");
        student.displayStudent();
    }

    
    private static void displayAllStudents() {
        System.out.println("\n  [ ALL STUDENTS ]");

        if (studentList.isEmpty()) {
            System.out.println("  [!] No student records found.");
            return;
        }

        System.out.println("  Total Students: " + studentList.size());
        for (Student s : studentList) {
            s.displayStudent();
        }
    }

    
    private static void searchStudentById() {
        System.out.println("\n  [ SEARCH STUDENT ]");
        System.out.print("  Enter Student ID to search: ");
        String id = scanner.nextLine().trim();

        Student found = findStudentById(id);

        if (found != null) {
            System.out.println("\n  [✓] Student found:");
            found.displayStudent();
        } else {
            System.out.println("  [!] No student found with ID: " + id);
        }
    }

    
    private static void calculateAverageMark() {
        System.out.println("\n  [ AVERAGE MARK ]");

        if (studentList.isEmpty()) {
            System.out.println("  [!] No student records found. Cannot calculate average.");
            return;
        }

        double total = 0;
        for (Student s : studentList) {
            total += s.getMarks();
        }

        double average = total / studentList.size();

        System.out.println("--------------------------------------------------");
        System.out.printf("  Total Students : %d%n", studentList.size());
        System.out.printf("  Total Marks    : %.2f%n", total);
        System.out.printf("  Average Mark   : %.2f%n", average);
        System.out.println("--------------------------------------------------");
    }

   
    private static Student findStudentById(String id) {
        for (Student s : studentList) {
            if (s.getStudentId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    
    private static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("  [!] Invalid input. Please enter a whole number.");
            }
        }
    }

   
    private static double getDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double value = Double.parseDouble(scanner.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("  [!] Invalid input. Please enter a valid number.");
            }
        }
    }
}
