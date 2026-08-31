package main;

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


//class main.Student{
//    private String name;
//    private double gpa;
//
//    public main.Student(String name, double gpa) {
//        this.name = name;
//        this.gpa = gpa;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public double getGpa() {
//        return gpa;
//    }
//
//    public void setGpa(double gpa) {
//        this.gpa = gpa;
//    }
//}
//
//public class main.ExerciseTwo{
//
//    public static void main(String[] args) {
//        // To sort the main.Student object, we use a comparator. Tell Java how to sort the main.Student Object (By GPA)
//        Comparator<main.Student> comparator = Comparator.comparingDouble(main.Student::getGpa).reversed();
//
//        TreeMap<main.Student, String> map = new TreeMap<>(comparator);
//        map.put(new main.Student("John", 3.4), "Computer Science");
//        map.put(new main.Student("Alice", 4.5), "Computer Science");
//
//        for (main.Student s : map.keySet()){
//            System.out.println(s.getName() + ", GPA: " + s.getGpa());
//        }
//
//
//
//
//    }
//
//}
//
//
