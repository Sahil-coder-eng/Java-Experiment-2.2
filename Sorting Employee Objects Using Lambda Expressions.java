import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    double marks;

    // Constructor
    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentFiltering {
    public static void main(String[] args) {
        // Step 1: Store Student objects in a list
        List<Student> students = Arrays.asList(
            new Student("Sahil", 80),
            new Student("Ankit", 72),
            new Student("Riya", 90),
            new Student("Meena", 65),
            new Student("Karan", 78)
        );

        // Step 2: Filter students scoring above 75%, sort by marks, and display names
        System.out.println("Students scoring above 75% (sorted by marks):");

        students.stream()
                .filter(s -> s.marks > 75)   // filtering
                .sorted((s1, s2) -> Double.compare(s1.marks, s2.marks))  // sorting
                .map(s -> s.name)  // mapping only names
                .forEach(System.out::println); // displaying
    }
}
