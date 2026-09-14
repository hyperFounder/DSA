package main.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

class Employee implements Comparable<Employee>{
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee o1){
        int salaryCompare = Double.compare(this.salary, o1.salary);
        if (salaryCompare != 0){
            return salaryCompare;
        }
        return this.name.compareTo(o1.name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
public class ExerciseOne {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "John", 3.0));
        list.add(new Employee(2, "Alice", 3.0));
        Collections.sort(list);
        for (Employee o : list){
            System.out.println(o.getName());
        }
    }
}
