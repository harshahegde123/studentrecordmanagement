import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getters and Setters
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public double getMarks() { return marks; }

    public void setMarks(double marks) { this.marks = marks; }

    @Override
    public String toString() {
        return "Student ID: " + id +
               ", Name: " + name +
               ", Marks: " + marks;
    }
}

public class StudentManagementSystem {

    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Student Record Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: updateStudent(); break;
                case 4: deleteStudent(); break;
                case 5:
                    running = false;
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student Marks: ");
        double marks = scanner.nextDouble();

        Student student = new Student(id, name, marks);
        studentList.add(student);
        System.out.println("Student added successfully.");
    }

    private static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n--- Student Records ---");
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Student s : studentList) {
            if (s.getId() == id) {
                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new marks: ");
                double marks = scanner.nextDouble();

                s.setName(name);
                s.setMarks(marks);

                System.out.println("Student updated successfully.");
                return;
            }
        }

        System.out.println("Student with ID " + id + " not found.");
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();

        for (Student s : studentList) {
            if (s.getId() == id) {
                studentList.remove(s);
                System.out.println("Student deleted successfully.");
                return;
            }
        }

        System.out.println("Student with ID " + id + " not found.");
    }
}
