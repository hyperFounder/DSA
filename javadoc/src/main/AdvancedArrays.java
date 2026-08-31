package main;

import java.util.*;
import java.util.stream.Collectors;


interface PaymentProcessor{
    void processPayment(double amount);
}

class CreditCardProcessor implements PaymentProcessor{
    private String cardHolderName;
    public CreditCardProcessor(String cardHolderName){
        this.cardHolderName = cardHolderName;
    }
    @Override
    public void processPayment(double amount){
        System.out.println("processing payment for " + cardHolderName + " amount: " + amount);
    }

    // Method overloading: overload the paramenters in a method
    public void processPayment(double amount, String currency){
        System.out.println("processing international payment for " + cardHolderName + " amount: " + amount + " currency: " + currency);
    }
}

abstract class Employee{
    protected String name;
    protected double salary;

    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }
    public void displayDetails(){
        // Concrete method
        System.out.println("main.Employee NAME" + name);
    }
    public abstract void doWork();
}

class Developer extends Employee{
    public Developer(String name, double salary){
        super(name, salary);
    }
    @Override
    public void doWork(){
        System.out.println(name + "is writing java code");
    }
}
class Vehicle{
    String brand = "Ford";
    public void honk(){
        System.out.println("Tut tut");
    }
}
class Car extends Vehicle{
    String modelName = "Mustang";
}
class Ticket{
    private int id;
    private String issueDescripion;

    public Ticket(int id, String issueDescripion){
        this.id = id;
        this.issueDescripion = issueDescripion;
    }

    public String getIssueDescripion() {
        return issueDescripion;
    }

    public void setIssueDescripion(String issueDescripion) {
        this.issueDescripion = issueDescripion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
public class AdvancedArrays {

    public interface Notification{
        void sendNotification();
    }

    static class EmailNotification implements Notification{
        @Override
        public void sendNotification(){
            System.out.println("Sending an email notification");
        }
    }

    static class SMSNotification implements Notification{
        @Override
        public void sendNotification(){
            System.out.println("Sending an sms notification");
        }
    }

    public static class NotificationFactory{
        public Notification createNotification(String channel){
            if (channel == null || channel.isEmpty()){
                throw new IllegalArgumentException("channel cannot be empty");
            }
            return switch (channel){
                case "SMS" -> new SMSNotification();
                case "email" -> new EmailNotification();
                default -> throw new IllegalArgumentException("invalid channel");
            };
        }
    }



    public static boolean isPalindrome(String s){
        s = s.replaceAll("[^a-zA-Z]+", "").toLowerCase();

        ArrayDeque<Character> arrayDeque = new ArrayDeque<>();

        for (Character c : s.toCharArray()){
            arrayDeque.add(c);
        }
        while (arrayDeque.size() > 1){
            char first = arrayDeque.removeFirst();
            char last = arrayDeque.removeLast();
            if (first != last) return false;
        }
        return true;
    }

    public static boolean isBalanced(String s){
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (Character c : s.toCharArray()){
            if (c == '[' || c == '{' || c == '('){
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) return false;
                char curr = stack.pop();
                if (curr == '(' && c == ')' ||(curr == '[' && c == ']') || (curr == '{' && c == '}') ) continue;
                return false;
            }
        }
        return true;
    }

    record Product(String name, String category, double price){}
    record Name(String name, int age){}

    public static void main(String[] args) {

        NotificationFactory factory = new NotificationFactory();
        Notification sms = factory.createNotification("SMS");
        sms.sendNotification();

        Notification email = factory.createNotification("email");
        email.sendNotification();

        CreditCardProcessor processor = new CreditCardProcessor("Alice");
        processor.processPayment(10);
        processor.processPayment(10, "£");

        Developer developer = new Developer("Ryan", 21);
        developer.displayDetails();


        // Create car object
        Car car = new Car();
        car.honk();
        System.out.println(car.brand + "IS-A" + car.modelName);

        NavigableMap<Integer, String> map = new TreeMap<>();
        map.put(10, "Ten");
        map.put(30, "Thirty");
        map.put(20, "Twenty");

        Iterator<Map.Entry<Integer, String>> ascIterator = map.entrySet().iterator();
        while (ascIterator.hasNext()){
            Map.Entry<Integer, String> entry = ascIterator.next();
            System.out.println("key: " + entry.getKey() + "value: " + entry.getValue());
            if (entry.getKey() == 20) ascIterator.remove();
        }

        Iterator<Map.Entry<Integer, String>> descIterator = map.descendingMap().entrySet().iterator();
        while (descIterator.hasNext()){
            Map.Entry<Integer, String> entry = descIterator.next();
            System.out.println("key: " + entry.getKey() + "value: " + entry.getValue());
        }

        List<Name> names = List.of(
                new Name("Ryan", 22),
                new Name("John", 20)
        );
        List<Integer> ages = names.stream().sorted(Comparator.comparingInt(Name::age)).filter(p -> p.age <=22).map(Name::age).collect(Collectors.toList());
        System.out.println(ages);

        List<Product> proudcts = List.of(
                new Product("Laptop", "Electronics", 1200.00),
                new Product("Phone", "Electronics", 800),
                new Product("Java book", "Books", 45),
                new Product("Desk chair", "Furniture", 150.00)
        );

        List<String> books = proudcts.stream()
                        .filter(p -> p.price >= 50 && p.price <= 1000)
                .map(Product::name)
                                .collect(Collectors.toList());

        System.out.println(books);



        System.out.println(isPalindrome("hannah"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        Queue<Ticket> tickets = new LinkedList<>();
        tickets.offer(new Ticket(1, "ticketIssue1"));
        tickets.offer(new Ticket(2, "ticketIssue2"));

        while (!tickets.isEmpty()){
            Ticket curr = tickets.poll();
            System.out.println("SOLVED: " + curr.getIssueDescripion());
        }

    }
}
