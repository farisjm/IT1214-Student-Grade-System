public class Student {
    private String studentID;
    private String studentName;
    private int[] marks;

    public Student(String studentID, String studentName, int[] marks) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.marks = marks;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public int[] getMarks() {
        return marks;
    }

    public double getAverage() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.length;
    }

    public void displayStudent() {
        System.out.println("ID: " + studentID);
        System.out.println("Name: " + studentName);
        System.out.print("Marks: ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println("\nAverage: " + getAverage());
        System.out.println("----------------------");
    }
}