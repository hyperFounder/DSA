import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

// ==========================================
// Exercise 3 Supporting Types: Abstract Classes & Interfaces (Simple Animal Example)
// ==========================================
interface Doggable {
    default void play() {
        System.out.println("[Action]: The dog is playing fetch.");
    }
    
    void wagTail();
}

abstract class Animal implements Doggable {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void makeSound();
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof! Woof!");
    }

    @Override
    public void wagTail() {
        System.out.println(name + " is happily wagging its tail.");
    }
}

// ==========================================
// Exercise 2 Supporting Types: Stream API Model
// ==========================================
class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
}

// ==========================================
// Master Application Class Containing All 3 Solutions
// ==========================================
public class AllProgrammingStyleSolutions {

    public static void main(String[] args) {
        System.out.println("=== EXERCISE 1: NavigableMap Range Query & Navigation ===");
        runNavigableMapDemo();

        System.out.println("\n=== EXERCISE 2: Stream API Complex Aggregation & Filtering ===");
        runStreamDemo();

        System.out.println("\n=== EXERCISE 3: Abstract Classes vs. Interfaces ===");
        runAnimalFrameworkDemo();
    }

    private static void runNavigableMapDemo() {
        // 1. Initialize NavigableMap backed by a TreeMap
        NavigableMap<Integer, String> sensorLogs = new TreeMap<>();

        // Populate with at least 5 entries (Timestamp ID -> Sensor Reading)
        sensorLogs.put(1001, "Temperature: 22.5°C");
        sensorLogs.put(1005, "Pressure: 1013 hPa");
        sensorLogs.put(1010, "Humidity: 45%");
        sensorLogs.put(1020, "Temperature: 24.1°C");
        sensorLogs.put(1035, "Vibration Warning: High");

        System.out.println("All Sensor Logs:");
        sensorLogs.forEach((id, log) -> System.out.println("  ID: " + id + " -> " + log));

        // 2. Use .higherKey(givenKey) to find the smallest key strictly greater than a given timestamp
        int queryTimestamp = 1010;
        Integer nextKey = sensorLogs.higherKey(queryTimestamp);
        System.out.println("Smallest timestamp strictly greater than " + queryTimestamp + ": " + nextKey + 
                           " (" + sensorLogs.get(nextKey) + ")");

        // 3. Use .subMap(fromKey, true, toKey, false) to extract a range (inclusive/exclusive)
        System.out.println("SubMap Range Query (1005 inclusive to 1020 exclusive):");
        NavigableMap<Integer, String> rangeView = sensorLogs.subMap(1005, true, 1020, false);
        rangeView.forEach((id, log) -> System.out.println("  ID: " + id + " -> " + log));
    }

    private static void runStreamDemo() {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "Engineering", 85000),
            new Employee("Bob", "Engineering", 95000),
            new Employee("Charlie", "HR", 60000),
            new Employee("Diana", "Engineering", 110000),
            new Employee("Evan", "Sales", 75000)
        );

        double salaryThreshold = 80000.0;

        // 1 & 2. Filter Engineering employees above threshold and group by department
        // 3. Calculate average salary for each department
        Map<String, Double> avgSalariesByDept = employees.stream()
            .filter(e -> e.getDepartment().equals("Engineering"))
            .filter(e -> e.getSalary() > salaryThreshold)
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)
            ));

        avgSalariesByDept.forEach((dept, avg) -> 
            System.out.println("Department: " + dept + ", Average Salary: $" + avg)
        );
    }

    private static void runAnimalFrameworkDemo() {
        Animal myDog = new Dog("Buddy");

        System.out.println("Animal Name: " + myDog.getName());
        myDog.makeSound(); // Implemented from abstract class contract
        myDog.wagTail();   // Implemented from interface contract
        myDog.play();      // Default method inherited from interface
    }
}
