### Exercise 1: NavigableMap Range Query & Navigation
Task: Create a program using a `NavigableMap<Integer, String>` (backed by a `TreeMap`) to represent sensor readings mapped by their timestamp IDs. 
1. Populate the map with at least 5 entries.
2. Use `.higherKey(givenKey)` to find the smallest key strictly greater than a given timestamp.
3. Use `.subMap(fromKey, true, toKey, false)` to extract and print a range of sensor logs inclusively/exclusively.

- **Goal**: Practice advanced key navigation methods unique to `NavigableMap` beyond standard map lookups.

---

### Exercise 2: Stream API Complex Aggregation & Filtering
Task: Given a `List<Employee>` where each `Employee` has `name`, `department`, and `salary`:
1. Use Java Streams to filter employees belonging to the "Engineering" department earning above a certain threshold.
2. Group the filtered employees by their department using `Collectors.groupingBy()`.
3. Calculate the average salary for each department using `Collectors.averagingDouble()`.

- **Goal**: Master intermediate-to-advanced Stream pipeline operations, custom predicates, and reduction collectors.

---

### Exercise 3: Abstract Classes vs. Interfaces (Design Pattern Practice)
1. Create an **interface** named `Doggable` that contains a default method `play()` and an abstract method `wagTail()`.
2. Create an **abstract class** named `Animal` that implements `Doggable`, contains an instance variable `name`, a constructor to initialize it, and an abstract method `makeSound()`.
3. Create a concrete class named `Dog` that extends `Animal` and implements the missing abstract methods (`makeSound()` and `wagTail()`).
