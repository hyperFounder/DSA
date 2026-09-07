### Exercise 1: Unique & Sorted Word Extractor (`TreeSet`)

**Task:** Write a program that takes a sentence from the user, splits it into words, converts all words to lowercase, removes punctuation, and prints the unique words in alphabetical order.

* **Goal:** Practice basic `TreeSet` operations and automatic sorting/deduplication.

---

### Exercise 2: Student Leaderboard (`TreeMap` + Custom Sorting)

**Task:** Create a class `Student` with attributes `name` and `gpa`.
1. Store student objects as **keys** in a `TreeMap` where the value is their major (e.g., `"Computer Science"`).
2. Pass a custom `Comparator` to the `TreeMap` constructor so students are automatically sorted in **descending order of GPA**.

* **Goal:** Practice using custom `Comparator` objects with tree collections.

---

### Exercise 3: Word Frequency & Range Filter (`TreeMap`)

**Task:** 1. Given a long paragraph, count the frequency of each word using a `TreeMap<String, Integer>`.
2. Use `.subMap(fromKey, toKey)` to print only words starting between `'d'` and `'m'`.

* **Goal:** Leverage key-based navigation methods in `TreeMap`.

### Exercise 4: Flight Delay Log (`floorEntry` / `ceilingEntry`)
**Task:** Build a `DelayLog` backed by `TreeMap<LocalTime, Integer>` mapping a timestamp to the delay in minutes reported at that moment.
1. Insert eight readings at scattered times across a day.
2. Write `lastKnownDelay(LocalTime t)` using `floorEntry(t)` so a query at 14:32 returns the most recent reading at or before that time.
3. Write `nextScheduledReading(LocalTime t)` using `ceilingEntry(t)`.
4. Write `delayAtOrThrow(LocalTime t)` that uses `floorEntry` and throws `NoSuchElementException` when the query falls before the first reading.
5. Compare `floorEntry` with `lowerEntry` on a timestamp that exactly matches a key, and write down the difference in one line.
* **Goal:** Learn the four navigation methods that make `NavigableMap` worth its O(log n), and internalise the inclusive/exclusive distinction between floor/ceiling and lower/higher.

---

### Exercise 5: Tiered Pricing Table (`floorEntry` as a lookup ladder)
**Task:** Model volume discounts with `TreeMap<Integer, BigDecimal>` where the key is the minimum order quantity and the value is the unit price. Seed it with 1 → £10.00, 50 → £8.50, 200 → £7.00, 1000 → £5.50.
1. Write `priceFor(int quantity)` returning the correct tier using a single `floorEntry` call.
2. Confirm that quantity 199 gets the 50-tier price and quantity 200 gets the 200-tier price.
3. Handle quantity 0 by returning `Optional.empty()` rather than letting `floorEntry` return null.
4. Rewrite the same logic with a chain of `if` statements, then delete it and note how many lines the `TreeMap` saved.
* **Goal:** See the classic real-world use of `floorEntry` — a lookup ladder where a `HashMap` is useless because you never query an exact key.

---

### Exercise 6: Meeting Room Booker (`subMap` for overlap detection)
**Task:** Build a `RoomSchedule` backed by `TreeMap<LocalTime, Booking>` keyed by start time, where `Booking` is a record of `endTime` and `bookedBy`.
1. Write `isFree(LocalTime start, LocalTime end)` that uses `floorEntry(start)` to check whether an earlier booking runs past `start`.
2. Use `subMap(start, true, end, false)` to check whether any booking begins inside the requested window.
3. Write `book(...)` that only inserts when both checks pass, returning a boolean.
4. Write `bookingsBetween(LocalTime from, LocalTime to)` returning the sub-range as a `List<Booking>`.
5. Mutate the map through the `subMap` view and observe that the change writes through to the backing map.
* **Goal:** Practise `subMap` as a live view rather than a copy, and combine it with `floorEntry` to solve a real interval-overlap problem.

---

### Exercise 7: Auction Order Book (`descendingMap` and `pollFirstEntry`)
**Task:** Build an `OrderBook` with two `TreeMap<BigDecimal, Integer>` fields: `bids` (price → quantity) and `asks`.
1. Add bids and asks at various prices.
2. Expose `bestBid()` using `lastEntry()` on bids, and `bestAsk()` using `firstEntry()` on asks.
3. Write `matchOne()` that uses `pollFirstEntry()` on asks and `pollLastEntry()` on bids to remove and return the crossing pair.
4. Print the bid side highest-first using `descendingMap()` without ever sorting anything yourself.
5. Explain why `bids` could instead be built with `new TreeMap<>(Comparator.reverseOrder())`, and which of the two approaches you prefer.
* **Goal:** Learn the poll and descending-view methods, and see that a `TreeMap` gives you both ends of an ordered structure for free.

---

### Exercise 8: Tag Index (`computeIfAbsent` building a multimap)
**Task:** Given a `List<Article>` where each `Article` has a title and a `List<String> tags`, build an index of tag → articles.
1. Build `Map<String, List<Article>>` using `computeIfAbsent(tag, k -> new ArrayList<>()).add(article)`.
2. Write the same thing using `containsKey` + `put` + `get` and count the map operations in each version.
3. Swap the inner `ArrayList` for a `TreeSet<Article>` so each tag's articles come out sorted by title, and add the `Comparator` the `TreeSet` needs.
4. Make the outer map a `TreeMap` so tags list alphabetically, and confirm you changed exactly one line.
5. Deliberately write `computeIfAbsent(tag, k -> new ArrayList<>())` and forget the `.add(...)`. Explain what the map contains afterwards.
* **Goal:** Make the multimap idiom automatic, and understand that `computeIfAbsent` returns the value so the call chains.

---

### Exercise 9: Nested Map — Sales by Region and Month (`computeIfAbsent` twice)
**Task:** Build `Map<String, Map<Month, BigDecimal>>` mapping region → month → total revenue from a flat `List<Sale>`.
1. Populate it with a single chained statement using nested `computeIfAbsent` for the outer level and `merge` for the inner accumulation.
2. Write `revenue(String region, Month month)` that never throws on a missing region, using `getOrDefault` at both levels.
3. Write `totalFor(String region)` that streams the inner map's values and reduces them.
4. Make the inner map a `TreeMap<Month, BigDecimal>` so months come out in calendar order, and the outer a `HashMap`.
5. Add a region with no sales and confirm your read methods return zero rather than null or an exception.
* **Goal:** Get comfortable with two-level maps, and learn that `computeIfAbsent` for containers and `merge` for accumulators are different jobs.

---

### Exercise 10: The `compute` Family Compared
**Task:** Build a `Map<String, Integer>` word counter five different ways over the same input.
1. `containsKey` then `put`.
2. `getOrDefault(word, 0) + 1` then `put`.
3. `merge(word, 1, Integer::sum)`.
4. `compute(word, (k, v) -> v == null ? 1 : v + 1)`.
5. `computeIfPresent` alone, then explain why it silently produces an empty map.
6. Now use `compute` returning `null` to delete a key, and `merge` with a remapping function returning `null` to do the same.
* **Goal:** Know exactly which of the six `Map` default methods to reach for, and learn the rule that returning `null` from a remapping function removes the entry.

---

### Exercise 11: Recursive Category Tree (`TreeMap` values holding `TreeMap`)
**Task:** Model a product catalogue as `NavigableMap<String, Category>` where `Category` holds a name and its own `NavigableMap<String, Category>` of children.
1. Write `addPath(String path)` that takes `"electronics/audio/headphones"` and creates every missing level using `computeIfAbsent` in a loop.
2. Write `printTree()` that walks the structure depth-first, indenting by depth.
3. Write `find(String path)` returning `Optional<Category>` without a single null check leaking to the caller.
4. Use `descendingMap()` at one level to print that branch in reverse alphabetical order.
5. Count how many `computeIfAbsent` calls a five-level path costs, and whether re-adding the same path allocates anything.
* **Goal:** Combine recursion, nesting, and `computeIfAbsent` — this is the shape of file trees, org charts, and JSON structures.

---

### Exercise 12: Rate Limiter Window (`headMap` and `tailMap` for eviction)
**Task:** Build a `SlidingWindowLimiter` allowing at most N requests per 60 seconds, backed by `TreeMap<Long, Integer>` mapping epoch second → request count.
1. Write `allow(long nowSeconds)` that first evicts stale entries with `headMap(now - 60, false).clear()`.
2. Sum the remaining values to decide whether the request passes.
3. Record the accepted request with `merge(now, 1, Integer::sum)`.
4. Prove that `headMap(...).clear()` actually removes entries from the backing map, not from a copy.
5. Replace the sum with a running counter field and explain what you gave up in exchange for the speed.
* **Goal:** Use the head/tail views for bulk eviction, and see write-through views doing real work rather than being a curiosity.

---

**Habits to enforce across all of these:**
- Declare `NavigableMap<K,V>` when you use navigation methods, `SortedMap` when you only need ordering, and `Map` when you need neither. Never declare `TreeMap` directly.
- `computeIfAbsent` for creating containers, `merge` for accumulating values. If you find yourself writing `containsKey` followed by `get`, stop and pick one of the two.
- Write the missing-key test before the happy path. Every navigation method returns null at the boundaries, and that is where these break.
