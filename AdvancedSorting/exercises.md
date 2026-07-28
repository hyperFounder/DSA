### Exercise 1: High-Speed Primitive Sorting (Dual-Pivot Quicksort)

**Task:** You are given an array of primitive `double` values representing the finish times of runners in a 100m sprint: `double[] raceTimes = {10.5, 9.8, 11.2, 9.9, 10.1};`. 
1. Use `Arrays.sort()` to sort the array in ascending order.
2. Extract and print the top 3 fastest times (the gold, silver, and bronze medalists).

* **Goal:** Understand basic array manipulation and recognize that `Arrays.sort(primitives)` utilizes the highly performant, but unstable, **Dual-Pivot Quicksort** algorithm under the hood.

---

### Exercise 2: Natural Ordering of Objects (`Comparable<T>` & Timsort)

**Task:** Create an `Employee` class with attributes `id` (int), `name` (String), and `salary` (double).
1. Implement the `Comparable<Employee>` interface on the class. 
2. Override the `compareTo(Employee o)` method to establish a "natural ordering": sort primarily by `salary` in ascending order. If two employees have the exact same salary, sort them alphabetically by `name`.
3. Create an array of `Employee` objects and sort them using `Arrays.sort(employees)`.

* **Goal:** Master the `Comparable<T>` interface for natural ordering and understand that `Arrays.sort(objects)` uses **Timsort**—a stable hybrid of Merge Sort and Insertion Sort that preserves the relative order of equal elements.

---

### Exercise 3: Schedule Organizer (2D Array Sorting & Lambdas)

**Task:** You are given a 2D array representing scheduled meetings, where each sub-array contains `[startTime, endTime]`:
`int[][] meetings = {{14, 16}, {9, 10}, {10, 12}, {8, 9}};`
1. Use `Arrays.sort()` alongside a lambda expression to sort the meetings chronologically by their **start time** (the first column).
2. *Bonus:* Modify the lambda so that if two meetings start at the exact same time, they are sorted by their end time.

* **Goal:** Master custom sorting logic by passing a `Comparator<T>` via lambda expressions. (e.g., `Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));`).

---

### Exercise 4: Dynamic Inventory Sorting (`Collections.sort()`)

**Task:** Create a `List<Product>` where a `Product` has `name` and `price`. 
1. Use `Collections.sort()` (or the `List.sort()` default method) to sort the list of products by price in ascending order using a lambda expression.
2. Chain comparator methods to sort the list in **descending** order of price, using `Comparator.comparing(...).reversed()`.

* **Goal:** Practice sorting dynamic `List` interfaces and chaining functional `Comparator` methods, reinforcing how **Timsort** is applied to Java Collections.
