### Exercise 1: Bracket Validator (`ArrayDeque` as Stack)

**Task:** Write a program that takes a string containing different types of brackets (e.g., `"{[()]}"` or `"{[(])}"`). 
1. Iterate through the characters of the string.
2. Use an `ArrayDeque<Character>` to `push()` opening brackets.
3. When you encounter a closing bracket, `pop()` from the deque and verify it matches the correct opening bracket type. 
4. Print whether the string is balanced and valid.

* **Goal:** Practice LIFO (Last-In, First-Out) stack mechanics using the modern `ArrayDeque` class instead of Java's legacy `Stack` class.

---

### Exercise 2: Help Desk Ticket System (`LinkedList` as Queue)

**Task:** Create a simple `Ticket` class with `id` and `issueDescription` attributes.
1. Instantiate a `Queue<Ticket>` backed by a `LinkedList`.
2. Add several incoming tickets to the back of the queue using `.offer()`.
3. Write a loop that processes the tickets in strict First-In, First-Out (FIFO) order by calling `.poll()`. Print out the ticket details as they are resolved until the queue is empty.

* **Goal:** Practice utilizing a `LinkedList` as a standard `Queue` interface to process elements sequentially.

---

### Exercise 3: Two-Pointer Palindrome Checker (`ArrayDeque` as Deque)

**Task:** Write a method that takes a single word (String), converts it to lowercase, and evaluates whether it reads the same forwards and backwards.
1. Add each character of the word into an `ArrayDeque<Character>`.
2. Use a `while` loop that continues as long as the deque has more than one element.
3. Simultaneously remove and compare the front character using `.pollFirst()` and the back character using `.pollLast()`. If they ever mismatch, it is not a palindrome.

* **Goal:** Leverage the bidirectional (Double-Ended Queue) capabilities of `ArrayDeque` to easily manipulate and evaluate elements at both ends of a collection.

### Exercise 4: Browser History (`ArrayDeque` as Twin Stacks): $O(n)$ approach using Two stacks
- https://www.thealgorists.com/LLD/WebBrowserHistory


**Task:** Model a browser's back and forward navigation with a `BrowserHistory` class holding a current `String url` plus two `ArrayDeque<String>` fields named `back` and `forward`.
1. Write `visit(String url)`. Push the current URL onto `back`, set the new current URL, and clear `forward` entirely.
2. Write `back()`. If `back` is empty, return the current URL unchanged. Otherwise push current onto `forward` and pop from `back`.
3. Write `forward()` as the mirror image of step 2.
4. Cap `back` at 50 entries by calling `pollLast()` when it grows past the limit.
* **Goal:** Practice coordinating two stacks as a single unit of state, and see why `ArrayDeque` beats `Stack` when you need to evict from the far end.

---

### Exercise 5: Order Line Aggregator (`HashMap` with `merge`)
**Task:** Create an `OrderLine` record with `sku`, `quantity` and `unitPrice`. Build an `OrderTotaliser` that consumes a `List<OrderLine>` containing duplicate SKUs.
1. Aggregate quantities into a `Map<String, Integer>` using `map.merge(sku, qty, Integer::sum)`. Do not use `containsKey` followed by `get`.
2. Use `computeIfAbsent` to build a second `Map<String, List<OrderLine>>` grouping every raw line by SKU.
3. Print the totals sorted by highest value first, and note which map implementation you would swap in if the output had to stay in insertion order.
* **Goal:** Replace the get-check-put idiom with the atomic `Map` default methods, and understand when `LinkedHashMap` earns its place over `HashMap`.

---

### Exercise 6: Inventory Restock Alerts (`PriorityQueue` with `Comparator`)
**Task:** Create a `StockItem` class with `name`, `currentStock` and `reorderLevel`. Build a `RestockService` that surfaces the most urgent items first.
1. Define urgency as `currentStock - reorderLevel`, so the most negative value is the most urgent.
2. Instantiate a `PriorityQueue<StockItem>` with a `Comparator.comparingInt` on that urgency value.
3. Offer twenty items into the queue, then `poll()` the top five for a restock report.
4. Add a tie-break so items with equal urgency come out alphabetically, using `.thenComparing`.
* **Goal:** Practice heap semantics and comparator chaining, and prove to yourself that iterating a `PriorityQueue` directly does not give sorted order. Only polling does.

---

### Exercise 7: Deduplicating Contact Book (`equals` and `hashCode`)
**Task:** Create a `Contact` class with `firstName`, `lastName` and `email`.
1. Add ten contacts to a `HashSet<Contact>` where three of them share an email with an existing entry. Observe that all ten are stored.
2. Override `equals` and `hashCode` using only the email field, lowercased. Re-run and observe the deduplication.
3. Now mutate the email of a contact that is already inside the set, then call `contains` on it. Explain why it cannot be found.
4. Refactor `Contact` into an immutable record and confirm the problem disappears.
* **Goal:** Understand the hash contract, the danger of mutable keys, and why records are the safer default for value objects.

---

### Exercise 8: Undoable Text Editor (Command Pattern over `ArrayDeque`)
**Task:** Define an interface `EditCommand` with `execute(StringBuilder doc)` and `undo(StringBuilder doc)`. Implement `AppendText`, `DeleteLast` and `ReplaceAll`.
1. Build an `Editor` class holding a `StringBuilder` and an `ArrayDeque<EditCommand>` history.
2. `apply(EditCommand cmd)` executes the command and pushes it onto the history.
3. `undo()` pops the most recent command and calls its `undo` method.
4. Ensure each command stores whatever state it needs to reverse itself, for example `DeleteLast` must remember the character it removed.
* **Goal:** Practice the Command pattern and see that a stack is the natural data structure for reversible operations.

---

### Exercise 9: Event Dispatcher (Observer Pattern with `CopyOnWriteArrayList`)
**Task:** Define an interface `EventListener` with `onEvent(String eventName, Object payload)`. Build a `Dispatcher` that holds `Map<String, List<EventListener>>`.
1. Write `subscribe(String eventName, EventListener listener)` using `computeIfAbsent` to create the list lazily.
2. Write `publish(String eventName, Object payload)` that notifies every registered listener.
3. Write a listener that unsubscribes itself inside `onEvent`. Run it with `ArrayList` and watch `ConcurrentModificationException` appear.
4. Swap the backing list for `CopyOnWriteArrayList` and confirm the fix.
* **Goal:** Practice the Observer pattern and learn the concurrent collection that exists specifically for read-heavy listener registries.

---

### Exercise 10: LRU Cache for Product Lookups (`LinkedHashMap`)
**Task:** Build a `ProductCache` that holds at most 100 entries and evicts the least recently used.
1. Extend `LinkedHashMap<String, Product>` and call the three-argument constructor with `accessOrder` set to `true`.
2. Override `removeEldestEntry` to return `true` once size exceeds the capacity.
3. Write a second version that composes a `LinkedHashMap` as a private field rather than extending it, exposing only `get` and `put`.
4. Compare the two and decide which you would put in production.
* **Goal:** Learn the one JDK collection that gives you an LRU for free, and practise the composition-over-inheritance judgement call.

---

### Exercise 11: Shift Rota Builder (`TreeMap` navigation)
**Task:** Create a `Shift` record with `startTime` and `staffName`. Build a `Rota` backed by `TreeMap<LocalTime, Shift>`.
1. Insert shifts at scattered times of day.
2. Use `floorEntry(LocalTime)` to answer "who is on duty right now".
3. Use `subMap(from, to)` to list every shift in the afternoon window.
4. Use `firstEntry` and `lastEntry` for the opening and closing shifts.
* **Goal:** Practise the navigation API that makes `TreeMap` worth its O(log n) cost, which a `HashMap` cannot do at any price.

---

### Exercise 12: Pluggable Discount Engine (Strategy Pattern via `Map`)
**Task:** Define an interface `DiscountStrategy` with `BigDecimal apply(BigDecimal subtotal)`. Implement `PercentageOff`, `FlatAmountOff` and `NoDiscount`.
1. Build a `PricingService` holding `Map<String, DiscountStrategy>` keyed by promo code.
2. Resolve the strategy with `getOrDefault(code, new NoDiscount())` so an unknown code never throws.
3. Refactor so the map is passed into the constructor rather than built inside it.
4. Confirm the service contains zero `if` and zero `switch` statements on promo code.
* **Goal:** Practise the Strategy pattern with a map lookup replacing branching, which is the exact shape you will later wire up with Spring dependency injection.

---

**Two habits to enforce across all of these:**
- Declare to the interface and instantiate the implementation, so `Deque<String> d = new ArrayDeque<>();` and never `ArrayDeque<String> d = ...`.
- Write the empty-collection test case before the happy path, since that is where most of these break.
