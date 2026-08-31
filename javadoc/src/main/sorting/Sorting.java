package main.sorting;

import java.util.*;

public class Sorting {

    static class Product implements Comparable<Product>{
        String name;
        int price;

        public Product(String name, int price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public int compareTo(Product o){
            return Integer.compare(this.price, o.price);
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

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
        public int compareTo(Employee o){
            int salaryCompare = Double.compare(this.salary, o.salary);
            if (salaryCompare !=0){
                return salaryCompare;
            }
            return this.name.compareTo(o.name);
        }

        @Override
        public String toString() {
            return "main.Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product("Watch", 50));
        products.add(new Product("keyboard", 10));
        System.out.println(products);
        Collections.sort(products);
        System.out.println(products);
        Collections.sort(products, Collections.reverseOrder());

        System.out.println(products);


        double[] raceTimes = {10.5, 9.8, 11.2, 9.9, 10.1};
        Arrays.sort(raceTimes);
        double gold = raceTimes[0];
        double silver = raceTimes[1];
        double bronze = raceTimes[2];

        System.out.println("Gold: " + gold);
        System.out.println("silver: " + silver);
        System.out.println("bronze: " + bronze);

        Employee a = new Employee("John", 1, 10.4);
        Employee b = new Employee("Alice", 2, 10.4);

        List<Employee> employees = new ArrayList<>();
        employees.add(a);
        employees.add(b);

        Collections.sort(employees);
        for (Employee e : employees){
            System.out.println(e);
        }
        // startTime, endTime
        int[][] meetings = {
                {14, 16},
                {9, 10},
                {10, 12},
                {8, 9}
        };

//        Arrays.sort(meetings, (x,y) -> Integer.compare(x[0], y[0]));
        Arrays.sort(meetings, (x, y) -> {
            int startCompare = Integer.compare(x[0], y[0]);
            return (startCompare != 0) ? startCompare : Integer.compare(x[1], y[1]);
        });

//        Arrays.sort(
//                meetings, new Comparator<int[]>() {
//                    @Override
//                    public int compare(int[] o1, int[] o2) {
//                        int compareStartTime = Integer.compare(o1[0], o2[0]);
//                        // If startTime not the same
//                        if (compareStartTime != 0){
//                            // Compare by start time
//                            return compareStartTime;
//                        }
//                        // Compare by end time
//                        return Integer.compare(o1[1], o2[1]);
//                    }
//                }
//        );


        System.out.println(Arrays.deepToString(meetings));


        // Arrays.sort use a dual pivot quicksort
    }
}
