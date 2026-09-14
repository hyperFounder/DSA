package main.sorting;

import java.util.*;

class Product{
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
class Employee implements Comparable<Employee>{
    private int id;
    private String name;
    private Double salary;

    public Employee(int id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee o){
        return o.salary.equals(this.salary) ? this.name.compareTo(o.name) : o.salary.compareTo(this.salary);
    }


    public String getName() {
        return name;
    }
}

class Account implements Comparable<Account>{
    long balance;

    public Account(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public int compareTo(Account o){
        // Natural order
        return Long.compare(this.balance, o.balance);
        // Reverse order
        // return Long.compare(o.balance, this.balance);
        // return (int)(this.balance - o.balance);
    }
}
public class JavaExercises {
    public static void ex1(double[] raceTimes){
        // Arrays.sort() is for primitive types. If proceeding with it, perform Boxing to convert primitive type into Boxed Wrapper type
        Double[] arrBoxed = Arrays.stream(raceTimes)
                        .boxed()
                                .toArray(Double[]::new);
        System.out.println(arrBoxed.getClass());
        Arrays.sort(arrBoxed);
        System.out.println(Arrays.toString(arrBoxed));
        // Use collections for sorting objects
        // Return top 3 slowest times:
    }

    public static void ex2(double[][] meetings){
        // [startTime, endTime]. Sort by start time. If both the same, sort by end time
        Arrays.sort(meetings,
                new Comparator<double[]>(){
                    @Override
                    public int compare(double[] a, double[] b){
                        // If both start times are the same, sort by end time, else sort by start time
                        return Double.compare(a[0], b[0]) == 0 ? Double.compare(a[1], b[1]) : Double.compare(a[0], b[0]);
                    }
        });
        System.out.println(Arrays.deepToString(meetings));
    }


    public static void main(String[] args) {



        // Exercise 5: The Contract Violation (compareTo correctness)
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(1));
        accounts.add(new Account(3));
        accounts.add(new Account(2));
        accounts.add(new Account(Long.MAX_VALUE));
        accounts.add(new Account(-1L));
        Collections.sort(accounts);
        accounts.forEach(item -> System.out.println(item.getBalance()));


        // ex3: Schedule Organizer
        ex2(new double[][] {{14, 16}, {8, 10}, {10, 12}, {8, 9}});



        // Ex2: Natural Ordering of Objects: Comparable, compareTo
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Bob", 30.0));
        employees.add(new Employee(2, "Alice", 30.0));
        Collections.sort(employees);
        employees.forEach(item -> System.out.println(item.getName()));


        // Ex4: Dynamic Inventory Sorting
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 10));
        products.add(new Product("TV", 100));
        Collections.sort(products,
                new Comparator<Product>(){
            // Sorting in descending order
            @Override
                    public int compare(Product o1, Product o2){
                if (o1.getPrice() > o2.getPrice()){
                    return -1;
                } else if (o1.getPrice() < o2.getPrice()){
                    return 1;
                } else{
                    return 0;
                }
            }
                }

        );
        products.forEach(item -> System.out.println(item.getName()));
    }
}
