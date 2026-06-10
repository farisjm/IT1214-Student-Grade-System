import java.util.Scanner;

class Student {
    private String studentID;
    private String studentName;
    private int[] marks;

    public Student(String studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.marks = new int[5];
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

    public void setMarks(Scanner sc) {
        for (int i = 0; i < 5; i++) {
            while (true) {
                System.out.print("Enter Subject " + (i + 1) + " Marks (0-100): ");

                if (sc.hasNextInt()) {
                    int mark = sc.nextInt();

                    if (mark >= 0 && mark <= 100) {
                        marks[i] = mark;
                        break;
                    } else {
                        System.out.println("Marks must be between 0 and 100.");
                    }
                } else {
                    System.out.println("Please enter a valid number.");
                    sc.next(); // clear invalid input
                }
            }
        }
    }

    public double getAverage() {
        int sum = 0;

        for (int mark : marks) {
            sum += mark;
        }

        return (double) sum / marks.length;
    }

    public String getGrade() {
        double avg = getAverage();

        if (avg >= 75)
            return "A";
        else if (avg >= 65)
            return "B";
        else if (avg >= 55)
            return "C";
        else if (avg >= 35)
            return "S";
        else
            return "F";
    }

    public void displayInfo() {
        System.out.println("\n================================");
        System.out.println("Student ID   : " + studentID);
        System.out.println("Student Name : " + studentName);

        System.out.print("Marks        : ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }

        System.out.println("\nAverage      : " + String.format("%.2f", getAverage()));
        System.out.println("Grade        : " + getGrade());
        System.out.println("================================");
    }
}

class Classroom {
    private Student[] students = new Student[10];
    private int count = 0;
    private Scanner scanner;

    public Classroom(Scanner scanner) {
        this.scanner = scanner;
    }

    public void createStudent() {
        if (count >= students.length) {
            System.out.println("Classroom is full!");
            return;
        }

        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        // Check duplicate ID
        for (int i = 0; i < count; i++) {
            if (students[i].getStudentID().equalsIgnoreCase(id)) {
                System.out.println("Student ID already exists!");
                return;
            }
        }

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        Student student = new Student(id, name);

        System.out.println("\nEnter Marks");
        student.setMarks(scanner);

        scanner.nextLine(); // consume newline

        students[count++] = student;

        System.out.println("Student created successfully!");
    }

    public void displayAll() {
        if (count == 0) {
            System.out.println("No students available.");
            return;
        }

        for (int i = 0; i < count; i++) {
            students[i].displayInfo();
        }
    }

    public void viewStudent() {
        if (count == 0) {
            System.out.println("No students available.");
            return;
        }

        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        for (int i = 0; i < count; i++) {
            if (students[i].getStudentID().equalsIgnoreCase(id)) {
                students[i].displayInfo();
                return;
            }
        }

        System.out.println("Student not found!");
    }

    public void editStudent() {
        if (count == 0) {
            System.out.println("No students available.");
            return;
        }

        System.out.print("Enter Student ID to edit: ");
        String id = scanner.nextLine();

        for (int i = 0; i < count; i++) {
            if (students[i].getStudentID().equalsIgnoreCase(id)) {

                System.out.print("Enter New Name: ");
                String newName = scanner.nextLine();

                students[i].setStudentName(newName);

                System.out.println("\nRe-enter Marks:");
                students[i].setMarks(scanner);

                scanner.nextLine(); // consume newline

                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student not found!");
    }

    public void deleteStudent() {
        if (count == 0) {
            System.out.println("No students available.");
            return;
        }

        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine();

        for (int i = 0; i < count; i++) {

            if (students[i].getStudentID().equalsIgnoreCase(id)) {

                for (int j = i; j < count - 1; j++) {
                    students[j] = students[j + 1];
                }

                students[count - 1] = null;
                count--;

                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found!");
    }

    public void showAverages() {
        if (count == 0) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("\n========== AVERAGE MARKS ==========");

        for (int i = 0; i < count; i++) {
            System.out.printf(
                    "%s (%s) - Average: %.2f - Grade: %s%n",
                    students[i].getStudentName(),
                    students[i].getStudentID(),
                    students[i].getAverage(),
                    students[i].getGrade());
        }
    }
}

public class StudentGradingSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Classroom classroom = new Classroom(input);

        int choice;

        do {
            System.out.println("\n========= STUDENT GRADING SYSTEM =========");
            System.out.println("1. Create Student");
            System.out.println("2. View All Students");
            System.out.println("3. View Student");
            System.out.println("4. Edit Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Average Marks List");
            System.out.println("7. Exit");
            System.out.print("Enter Choice: ");

            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Enter a number.");
                input.next();
                System.out.print("Enter Choice: ");
            }

            choice = input.nextInt();
            input.nextLine(); // consume newline

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
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 7);

        input.close();
    }
}
