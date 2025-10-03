import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    double marks;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentFiltering {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Sahil", 80),
                new Student("Ankit", 72),
                new Student("Riya", 90),
                new Student("Meena", 65),
                new Student("Karan", 78)
        );

        System.out.println("Students scoring above 75% (sorted by marks):");

        students.stream()
                .filter(s -> s.marks > 75)               // filter condition
                .sorted((s1, s2) -> Double.compare(s1.marks, s2.marks)) // sort by marks
                .map(s -> s.name)                       // extract names
                .forEach(System.out::println);          // print names
    }
}
