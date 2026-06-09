import java.util.Scanner;


class Student {
    private String studentID;
    private String studentName;
    private int[] marks;
    private Scanner sc = new Scanner(System.in);

    public Student(String studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
        marks = new int[5];
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setMarks() {
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter subject " + (i + 1) + " marks: ");
            marks[i] = sc.nextInt();
        }
    }

    public double getAverage() {
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += marks[i];
        }
        return (double) sum / 5;
    }

    public void displayInfo() {
        System.out.println("\n---------------------------");
        System.out.println("Student ID: " + studentID);
        System.out.println("Student Name: " + studentName);

        System.out.print("Marks: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(marks[i] + " ");
        }

        System.out.println("\nAverage: " + getAverage());
        System.out.println("---------------------------");
    }
}


class Classroom {
    Scanner scanner = new Scanner(System.in);
    Student[] students = new Student[10];
    int count = 0;

    
    public void createStudent() {
        if (count >= 10) {
            System.out.println("Class is full!");
            return;
        }

        scanner.nextLine(); // fix buffer issue

        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        Student s = new Student(id, name);
        s.setMarks();

        students[count++] = s;

        System.out.println("Student created successfully!");
    }

    
    public void displayAll() {
        if (count == 0) {
            System.out.println("No students found.");
            return;
        }

        for (int i = 0; i < count; i++) {
            students[i].displayInfo();
        }
    }

    
    public void viewStudent() {
        scanner.nextLine();

        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        for (int i = 0; i < count; i++) {
            if (students[i].getStudentID().equals(id)) {
                students[i].displayInfo();
                return;
            }
        }
        System.out.println("Student not found!");
    }

    
    public void editStudent() {
        scanner.nextLine();

        System.out.print("Enter Student ID to edit: ");
        String id = scanner.nextLine();

        for (int i = 0; i < count; i++) {
            if (students[i].getStudentID().equals(id)) {

                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                students[i].setStudentName(newName);

                System.out.println("Re-enter marks:");
                students[i].setMarks();

                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    
    public void deleteStudent() {
        scanner.nextLine();

        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine();

        for (int i = 0; i < count; i++) {
            if (students[i].getStudentID().equals(id)) {

                for (int j = i; j < count - 1; j++) {
                    students[j] = students[j + 1];
                }

                count--;
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    
    public void showAverages() {
        if (count == 0) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n===== AVERAGE MARK LIST =====");
        for (int i = 0; i < count; i++) {
            System.out.println(students[i].getStudentName() +
                    " (" + students[i].getStudentID() + ") - Avg: " +
                    students[i].getAverage());
        }
    }
}


public class StudentGradingSystem {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Classroom classroom = new Classroom();

        int choice;

        do {
            System.out.println("\n======== STUDENT GRADING SYSTEM ========");
            System.out.println("1. Create Student");
            System.out.println("2. View All Students");
            System.out.println("3. View Student");
            System.out.println("4. Edit Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Average Marks List");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            choice = input.nextInt();

            switch (choice) {

                case 1:
                    classroom.createStudent();
                    break;

                case 2:
                    classroom.displayAll();
                    break;

                case 3:
                    classroom.viewStudent();
                    break;

                case 4:
                    classroom.editStudent();
                    break;

                case 5:
                    classroom.deleteStudent();
                    break;

                case 6:
                    classroom.showAverages();
                    break;

                case 7:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);
    }
}