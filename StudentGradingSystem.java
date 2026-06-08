import java.util.Scanner;

class Student {
    private String studentID;
    private String studentName;
    private int[] marks;

    Scanner sc = new Scanner(System.in);

    public Student(String studentID, String studentName) {
        this.studentID=studentID;
        this.studentName=studentName;
        marks = new int[5];
    }
    public String getStudentID() {
        return studentID;
    }
    public void setStudentID(String studentID) {
        this.studentID=studentID;
    }
    public String getStudentName() {
        return studentName;
    }
    public void SetStudentName(String studentName) {
        this.studentName=studentName;
    }
    public void setMarks() {
        for(int i = 0; i < 5; i++) {
            System.out.print("Enter subject "+(i+1)+" marks: ");
            marks[i]=sc.nextInt();
        }
    }
    public void getMarks() {
        for(int i = 0; i < 5; i++) {
            System.out.print(marks[i]+", ");
        }
    }
    public double getAverage() {
        double avg;
        int sum = 0;
        for(int i=0; i<5; i++) {
            sum+=marks[i];
        }
        return avg=(double)sum/5;
    }
    public void displayInfo() {
        System.out.println();
        System.out.println("Student ID: "+getStudentID());
        System.out.println("Student Name: "+getStudentName());
        System.out.print("Student marks: ");getMarks();
        System.out.println();
        System.out.println("Average mark: "+getAverage());
    }
}

class Classroom {
    Scanner scanner = new Scanner(System.in);
    Student[] students;
    int count;
    public Classroom() {
        students = new Student[10];
        count = 0;
    }
    public void createStudent() {
        if (count < 10) {
            System.out.println();
            System.out.println("Creating student...");
            System.out.print("Enter Student ID: ");
            String studentID = scanner.nextLine();
            System.out.print("Enter student name: ");
            String studentName = scanner.nextLine();
            Student studentRecord = new Student(studentID, studentName);
            studentRecord.setMarks();
            System.out.println("Student "+studentName+" created successfully.");
            students[count] = studentRecord;
        } else {
            System.out.println("There is no space for input another student record.");
        }
    }
    public void displayAll() {
        for(int j = 0; j <= count; j++) {
            students[j].displayInfo();
        }
    }
}

public class  StudentGradingSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Classroom classroom = new Classroom();
        int userInput;
        do {
            System.out.println();
            System.out.println("======== Student Grading System ========");
            System.out.println("----------------------------------------");
            System.out.println("> Select the choice you want from below <");
            System.out.println("1. Create a Student.");
            System.out.println("2. Veiw all the student details.");
            System.out.println("3. View a student.");
            System.out.println("4. Edit student details.");
            System.out.println("5. Delete a Student.");
            System.out.println("6. Average marks list");
            System.out.println("7. Exit");
            System.out.println();
            System.out.print("Enter choice: ");
            userInput = input.nextInt();
            switch(userInput) {
                case 1:                    
                    classroom.createStudent();
                    break;
                case 2:
                    classroom.displayAll();
                default:    
            }
        } while (userInput!=7);
    }
}
