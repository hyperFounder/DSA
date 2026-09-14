package main.arrays;

import org.junit.jupiter.api.Order;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class ExerciseTwo {
    public static void main(String[] args) {
        List<OrderLine> lines = List.of(
                new OrderLine("APPLE", 3, 0.50),
                new OrderLine("PEAR", 2, 0.75),
                new OrderLine("APPLE", 5, 0.50),
                new OrderLine("KIWI", 1, 0.30),
                new OrderLine("PEAR", 4, 0.70)
        );
        OrderTotaliser t = new OrderTotaliser();
        t.print(t.aggregateQuantity(lines));


    }
    public record OrderLine(String sku, int quantity, double unitPrice){
        public OrderLine{
            Objects.requireNonNull(sku);
        }
    }

    static class OrderTotaliser{
        // Aggregate quantities into a Map

        private Map<String, Integer> aggregateQuantity(List<OrderLine> lines){
            Map<String, Integer> result = new HashMap<>();
            for (OrderLine orderLine: lines){
                result.merge(orderLine.sku(), orderLine.quantity(), Integer::sum);
            }
            return result;
        }

        public void print(Map<String, Integer> totals) {
            totals.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(e -> System.out.printf("%s -> %d%n", e.getKey(), e.getValue()));
        }
    }
}
