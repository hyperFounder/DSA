package main.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DynamicInventorySorting {

    static class Product{
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public static void main(String[] args) {
            List<Product> inventory = new ArrayList<>();
            inventory.add(new Product("Laptop", 1299.99));
            inventory.add(new Product("Mouse", 24.50));
            inventory.add(new Product("Mechanical Keyboard", 115.00));
            inventory.add(new Product("Monitor", 349.99));
            System.out.println("Original inventory");
            inventory.forEach(System.out::println);
            inventory.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
            System.out.println("Sorted by price ascending");
            inventory.forEach(System.out::println);
            inventory.sort(Comparator.comparing(Product::getPrice).reversed());
            System.out.println("Sorted by price descending");
            inventory.forEach(System.out::println);
        }
    }
}
