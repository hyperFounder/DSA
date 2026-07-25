import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;
import static org.junit.jupiter.api.Assertions.*;

class Student{
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}

public class ExerciseTwo{

    public static void main(String[] args) {
        // To sort the Student object, we use a comparator. Tell Java how to sort the Student Object (By GPA)
        Comparator<Student> comparator = Comparator.comparingDouble(Student::getGpa).reversed();

        TreeMap<Student, String> map = new TreeMap<>(comparator);
        map.put(new Student("John", 3.4), "Computer Science");
        map.put(new Student("Alice", 4.5), "Computer Science");

        for (Student s : map.keySet()){
            System.out.println(s.getName() + ", GPA: " + s.getGpa());
        }




    }

}


