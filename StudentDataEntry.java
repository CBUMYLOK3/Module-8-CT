import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Student implements Comparable<Student> {
    private String name;
    private String address;
    private double GPA;

    public Student(String name, String address, double GPA) {
        this.name = name;
        this.address = address;
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getGPA() {
        return GPA;
    }

    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }
}

public class StudentDataEntry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Student> students = new LinkedList<>();

        System.out.println("Enter student data (Enter 'quit' for name to exit):");

        while (true) {
            System.out.print("Name: ");
            String name = scan.nextLine();
            if (name.equals("quit")) {
                break;
            }

            System.out.print("Address: ");
            String address = scan.nextLine();

            double GPA;
            while (true) {
                System.out.print("GPA: ");
                String gpaInput = scan.nextLine();
                try {
                    GPA = Double.parseDouble(gpaInput);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid GPA. Please enter a valid numeric value.");
                }
            }

            students.add(new Student(name, address, GPA));
        }

        Collections.sort(students);

        try (FileWriter writer = new FileWriter("D:/CSU Global/Programming-II/Module 8 CT/student_data.txt")) {
            for (Student student : students) {
                writer.write("Name: " + student.getName() + "\n");
                writer.write("Address: " + student.getAddress() + "\n");
                writer.write("GPA: " + student.getGPA() + "\n\n");
            }
            System.out.println("Student data has been written to student_data.txt.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }
    }
}
