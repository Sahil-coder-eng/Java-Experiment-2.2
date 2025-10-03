import java.util.*;

class Employee {
    String name;
    int age;
    double salary;

    // Constructor
    Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // To print employee details
    @Override
    public String toString() {
        return name + " | Age: " + age + " | Salary: " + salary;
    }
}

public class EmployeeSorting {
    public static void main(String[] args) {
        // Step 1: Store Employee objects in a list
        List<Employee> employees = Arrays.asList(
            new Employee("Sahil", 24, 55000),
            new Employee("Ankit", 30, 70000),
            new Employee("Riya", 22, 50000),
            new Employee("Meena", 28, 65000)
        );

        // Step 2: Sort by name (alphabetically)
        employees.sort((e1, e2) -> e1.name.compareTo(e2.name));
        System.out.println("Sorted by Name:");
        employees.forEach(System.out::println);

        // Step 3: Sort by age (ascending)
        employees.sort((e1, e2) -> Integer.compare(e1.age, e2.age));
        System.out.println("\nSorted by Age:");
        employees.forEach(System.out::println);

        // Step 4: Sort by salary (descending)
        employees.sort((e1, e2) -> Double.compare(e2.salary, e1.salary));
        System.out.println("\nSorted by Salary (Descending):");
        employees.forEach(System.out::println);
    }
}
