import java.util.*;

import java.math.BigDecimal;

class Student{
    String name;
    BigDecimal gpa;

    public Student(String name, BigDecimal gpa){
        this.name = name;
        this.gpa = gpa;
    }
    public String getName(){
        return name;
    }
    public BigDecimal getGpa(){
        return gpa;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setGpa(BigDecimal gpa){
        this.gpa = gpa;
    }

    public static Comparator<Student> comparator = new Comparator<Student>() {
        @Override
        public int compare(Student a, Student b) {
            return b.getGpa().compareTo(a.getGpa());
        }
    };
}

public class ExerciseTwo{
    public static void main(String[] args) {
        Student studentOne = new Student("John", new BigDecimal(4.0));
        Student studentTwo = new Student("Sussan", new BigDecimal(3.0));
        TreeMap<Student, String> treeMap = new TreeMap<>(Student.comparator.reversed());
        treeMap.put(studentOne, "Computer Science");
        treeMap.put(studentTwo, "Computer Science");
        for (Map.Entry<Student, String> entry : treeMap.entrySet()){
            String name = entry.getKey().getName();
            String value = entry.getValue();
            System.out.println(name + "=" + value);
        }
    }
}
