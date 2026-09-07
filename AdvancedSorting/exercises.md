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

### Exercise 5: The Contract Violation (`compareTo` correctness)
**Task:** Create an `Account` class with a `long balance` field and a naive `compareTo` written as `return (int)(this.balance - other.balance);`.
1. Sort a list of accounts with ordinary balances and confirm it appears to work.
2. Now add two accounts with balances of `Long.MAX_VALUE` and `-1L`. Observe the wrong result caused by overflow and the `int` cast.
3. Replace the body with `Long.compare(this.balance, other.balance)` and confirm the fix.
4. Write a second broken comparator that returns `1` when equal instead of `0`, sort a list of 40 elements, and catch the `IllegalArgumentException: Comparison method violates its general contract!` that Timsort throws.
* **Goal:** Learn why subtraction is never a safe comparison, and see that Java actively detects inconsistent comparators rather than silently misbehaving.

---

### Exercise 6: Multi-Key Comparator Chains (`thenComparing`)
**Task:** Create a `Candidate` record with `lastName`, `yearsExperience` and `expectedSalary`.
1. Sort by years of experience descending, then salary ascending, then last name alphabetically, using a single chained `Comparator`.
2. Build the same ordering by hand in a `compareTo` method with nested `if` blocks, then compare the line counts.
3. Use `Comparator.comparingInt` for the primitive fields and note why it beats `Comparator.comparing` here.
4. Apply `.reversed()` to the whole chain and predict, before running it, which keys flip direction.
* **Goal:** Master comparator chaining and learn the trap that `.reversed()` reverses the entire chain, not just the last key.

---

### Exercise 7: Stability Proof (Timsort vs Dual-Pivot)
**Task:** Create a `Delivery` record with `driver` and `postcode`. Build a list where several deliveries share a postcode.
1. Sort by driver, then sort the result by postcode. Confirm that within each postcode the drivers remain in order.
2. Copy the same data into a parallel `int[]` and sort it with `Arrays.sort`. Explain why stability is a meaningless question for primitives.
3. Force an unstable sort on objects with `Arrays.sort(array, comparator)` vs a manual quicksort you write yourself, and observe the difference.
4. Write down one real scenario where losing stability would be a bug.
* **Goal:** Understand what stability actually guarantees, and why the JDK uses two different algorithms for primitives and objects.

---

### Exercise 8: Sorting by Computed Key (`Comparator.comparing` with an extractor)
**Task:** Given a `List<String>` of filenames like `"report-2024-03.pdf"`, sort them by the embedded date rather than lexicographically.
1. Write a key extractor that parses the year and month out of each name.
2. Sort with `Comparator.comparing(this::extractDate)`.
3. Measure how many times the extractor is called during a sort of 10,000 elements.
4. Precompute the keys into a `record Keyed(LocalDate key, String name)`, sort that, then map back. Compare the timings.
* **Goal:** Learn the Schwartzian transform (decorate-sort-undecorate) and see that an expensive key extractor is called O(n log n) times, not n times.

---

### Exercise 9: Nulls and Missing Data (`nullsFirst` / `nullsLast`)
**Task:** Create a `Ticket` record with `title` and a nullable `assignee`.
1. Sort by assignee and watch `NullPointerException` fire from inside the comparator.
2. Fix it with `Comparator.nullsLast(Comparator.naturalOrder())` wrapped around the key comparator.
3. Chain it so unassigned tickets sort last, and within each group sort by title.
4. Explain why the NPE stack trace points at `TimSort` rather than at your code.
* **Goal:** Handle nullable sort keys properly, rather than defending with `if (x == null)` inside a comparator.

---

### Exercise 10: Partial Sorting (`PriorityQueue` vs full sort)
**Task:** Given 1,000,000 random `int` values, find the 10 largest.
1. Sort the whole array and take the last 10. Time it.
2. Use a min-heap `PriorityQueue<Integer>` of fixed size 10: offer every element, poll whenever size exceeds 10. Time it.
3. Compare O(n log n) against O(n log k) with real numbers.
4. Repeat with k = 500,000 and find the crossover point where full sorting wins.
* **Goal:** Recognise that "top k" is not a sorting problem, and learn where the heap stops paying off.

---

### Exercise 11: Sorting Map Entries (streams and `LinkedHashMap`)
**Task:** Given `Map<String, Integer>` of word frequencies, produce the top 20 by count.
1. Stream `entrySet()`, sort with `Map.Entry.comparingByValue(Comparator.reverseOrder())`, limit to 20.
2. Collect into a `LinkedHashMap` using the four-argument `Collectors.toMap` and explain why the three-argument version loses your ordering.
3. Add a tie-break so equal counts come out alphabetically by key.
4. Do the same without streams, using an `ArrayList<Map.Entry<String,Integer>>` and `list.sort(...)`.
* **Goal:** Learn that `HashMap` cannot hold an order, and that collecting a sorted stream into one silently discards the work.

---

### Exercise 12: Interval Merging (sort as a preprocessing step)
**Task:** Given `int[][] intervals` such as `{{1,3},{8,10},{2,6},{15,18}}`, merge all overlapping ranges.
1. Sort by start time with `Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]))`.
2. Sweep once, extending the current interval when the next start is at or before the current end.
3. Try solving it without sorting first, and note how much harder the problem becomes.
4. Handle the edge cases: empty input, a single interval, and intervals that touch exactly at a boundary.
* **Goal:** See sorting used as the enabling step rather than the answer — the pattern behind meeting rooms, calendar conflicts, and range coalescing.

---

### Exercise 13: Custom Ordering Rules (`Comparator` with domain logic)
**Task:** Sort a `List<String>` of version numbers like `"1.10.2"`, `"1.9.0"`, `"2.0.1"` into true version order, where `1.10` comes after `1.9`.
1. Split each version into numeric segments and compare segment by segment.
2. Handle versions with different segment counts, so `"1.2"` sorts before `"1.2.1"`.
3. Write it as a standalone `Comparator<String>` class implementing the interface, not a lambda.
4. Add a JUnit test asserting the comparator is transitive across three specific versions.
* **Goal:** Write a non-trivial comparator from scratch and confirm it satisfies the contract, rather than trusting it because the output looked right.

---

### Exercise 14: Sorting Immutably (`stream().sorted()` vs `List.sort()`)
**Task:** Take a `List<Employee>` passed into a method you do not own.
1. Sort it with `list.sort(...)` and observe that you mutated the caller's list.
2. Rewrite using `list.stream().sorted(...).toList()` returning a new list.
3. Call `List.of(...)` to build an immutable list, then try `sort()` on it and catch the `UnsupportedOperationException`.
4. Decide which version belongs in a Spring `@Service` method and justify it in one sentence.
* **Goal:** Understand that in-place sorting is a side effect on someone else's data, and know when returning a new collection is the safer contract.

---

**Habits to enforce across all of these:**
- Never write `a - b` in a comparator. Use `Integer.compare`, `Long.compare`, `Double.compare`.
- A comparator must be transitive and consistent: if `compare(a,b) == 0` then `compare(b,a)` must be 0 too. Timsort will throw if you break this.
- Keep `compareTo` consistent with `equals` for anything you might put in a `TreeSet` or `TreeMap`, or elements will vanish.
- Extract expensive sort keys once before sorting, not inside the comparator.
