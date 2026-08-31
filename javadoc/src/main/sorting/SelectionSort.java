package main.sorting;

import java.util.Arrays;

public class SelectionSort {

    static class Employee implements Comparable<Employee>{
        int id;
        String name;
        double salary;

        public Employee(String name, int id, double salary) {
            this.name = name;
            this.id = id;
            this.salary = salary;
        }

        @Override
        public int compareTo(Employee other){
            int salaryComparison = Double.compare(this.salary, other.salary);
            // if salary is exact same, sort alphabetically
            if (salaryComparison == 0){
                return this.name.compareTo(other.name);
            }
            return salaryComparison;
        }
        // Overriding toString so the output is readable when printed
        @Override
        public String toString() {
            return String.format("main.Employee{id=%d, name='%s', salary=%.2f}", id, name, salary);
        }
    }

    public static void sort(int[] arr){
        // find smallest element in the unsorted array
        for(int i = 0; i<arr.length-1; i++){
            int minIndex = i;
            for(int j = i + 1; j<arr.length; j++){
                if (arr[j] < arr[minIndex]){
                    // Found minimum
                    minIndex = j;
                }
            }
            // swap the minimum element with the first element in the unsorted part
            if (minIndex != i){
                int temp = arr[i];
                arr[i]= arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }


    public static void main(String[] args) {


        int[] data = {5, 2, 1, 3, 6, 4};
        System.out.println("Before sorting: " + Arrays.toString(data));
        sort(data);
        System.out.println("after sorting: " + Arrays.toString(data));


        Employee[] employees = {
                new Employee("Charlie", 1, 3500),
                new Employee("Alice", 2, 2500)
        };

        System.out.println("Before sorting: (Timsort)");
        for (Employee e : employees){
            System.out.println(e);
        }
        Arrays.sort(employees);
        System.out.println("\nAfter sorting by Natural Ordering (Salary -> Name):");
        for (Employee e : employees) {
            System.out.println(e);
        }

    }
}