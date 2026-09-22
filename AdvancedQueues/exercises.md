### Exercise 1: Build Your Own Doubly Linked List (Nodes & Pointers)

**Task:** Write a generic `MyLinkedList<T>` with a private static nested `Node<T>` class holding `value`, `prev` and `next`.
1. Use two sentinel nodes, `head` and `tail`, that are created in the constructor and never removed. Link them to each other.
2. Implement `addFirst`, `addLast`, `removeFirst` and `removeLast`, all in $O(1)$. Throw `NoSuchElementException` when removing from an empty list.
3. Implement `get(int index)` that walks from `head` if the index is in the first half, or from `tail` if it is in the second half.
4. Track `size` as a field so it is $O(1)$, and override `toString` to print `[a, b, c]`.

* **Goal:** Feel exactly why the ends are $O(1)$ and random access is $O(n)$, and see how sentinels remove every `if (head == null)` special case. This is how `java.util.LinkedList` works internally.

---

### Exercise 2: Pointer Surgery (Reverse, Middle and Cycle Detection)
- https://leetcode.com/problems/reverse-linked-list/
- https://leetcode.com/problems/linked-list-cycle/

**Task:** Create a minimal singly linked `ListNode` class with `int val` and `ListNode next`.
1. Write `reverse(ListNode head)` iteratively using three pointers: `prev`, `curr` and `next`. Then write it recursively.
2. Write `middle(ListNode head)` using a slow pointer that moves one step and a fast pointer that moves two.
3. Write `hasCycle(ListNode head)` using Floyd's tortoise and hare. Build a test list whose last node points back to the second node.
4. Test every method with `null`, a single node and two nodes before the happy path.

* **Goal:** Get comfortable rewiring `next` pointers without losing the rest of the list, which is the core skill behind almost every linked list interview question.

---

### Exercise 3: The Queue API Trap (`offer`/`poll` vs `add`/`remove`)

**Task:** Write a small `QueueApiDemo` class that exercises both method families on an empty queue.
1. Declare `Queue<String> q = new ArrayDeque<>();` and call `remove()`, `element()`, `poll()` and `peek()` on it. Record which throw and which return `null`.
2. Repeat with `new LinkedList<>()` and confirm the behaviour matches.
3. Try `q.offer(null)` on both. `ArrayDeque` throws `NullPointerException`. `LinkedList` accepts it.
4. Explain in a comment why allowing `null` makes `poll()` returning `null` ambiguous, and why `ArrayDeque` banning it is the safer design.

* **Goal:** Know the throwing and non-throwing halves of the `Queue` interface cold, and understand one more reason `ArrayDeque` is the default.

---

### Exercise 4: Circular Array Queue from Scratch
- https://leetcode.com/problems/design-circular-queue/

**Task:** Build a fixed-capacity `IntRingQueue` backed by an `int[]` with `head`, `tail` and `size` fields.
1. Implement `offer(int x)` returning `false` when full, and `poll()` throwing when empty.
2. Advance indices with `(index + 1) % capacity` so they wrap around.
3. Refactor to force the capacity up to the next power of two and replace the modulo with `index & (capacity - 1)`.
4. Add a `grow()` method that doubles the array and copies elements in logical order, starting from `head`. This is the part most people get wrong.

* **Goal:** Understand how `ArrayDeque` is really a resizing circular array, and why power-of-two masking is a cheap trick you will see again in ring buffers.

---

### Exercise 5: Binary Tree Level Order Traversal (BFS with `ArrayDeque`)
- https://leetcode.com/problems/binary-tree-level-order-traversal/

**Task:** Create a `TreeNode` class and write `List<List<Integer>> levelOrder(TreeNode root)`.
1. Offer the root into a `Queue<TreeNode>` backed by `ArrayDeque`.
2. At the start of each loop iteration, capture `int levelSize = queue.size()` before polling anything.
3. Poll exactly `levelSize` nodes, adding their values to the current level list and offering their non-null children.
4. Extend it to return levels in zigzag order by using `addFirst` or `addLast` on a `Deque<Integer>` per level.

* **Goal:** Master the "snapshot the size" BFS template, which you will reuse for shortest paths in grids and graphs.

---

### Exercise 6: Sliding Window Rate Limiter (`ArrayDeque<Long>` of Timestamps)
- https://leetcode.com/problems/number-of-recent-calls/

**Task:** Build a `SlidingWindowRateLimiter` that allows at most `N` requests in any rolling window of `windowMillis`.
1. Store request timestamps in a `Deque<Long>`.
2. In `tryAcquire(long now)`, first evict from the front with `pollFirst()` while the oldest timestamp is older than `now - windowMillis`.
3. If the deque size is below `N`, `offerLast(now)` and return `true`. Otherwise return `false`.
4. Pass a `Clock` or a `LongSupplier` into the constructor so tests can control time instead of calling `System.currentTimeMillis()` directly.

* **Goal:** See a queue used as a moving window where old data leaves the front and new data joins the back, a pattern that shows up in real API gateways.

---

### Exercise 7: Kth Largest Element (Min-Heap of Size K)
- https://leetcode.com/problems/kth-largest-element-in-an-array/

**Task:** Write `int findKthLargest(int[] nums, int k)`.
1. Solve it naively by sorting, and note the $O(n \log n)$ cost.
2. Solve it with a `PriorityQueue<Integer>` (a min-heap by default). Offer every number, and `poll()` whenever the size exceeds `k`.
3. The answer is `peek()`. Explain why a min-heap, not a max-heap, is the right tool for the *largest* elements.
4. State the complexity as $O(n \log k)$ time and $O(k)$ space. As a stretch goal, implement Quickselect for $O(n)$ average time.

* **Goal:** Internalise the "keep a heap of size K and evict the weakest" trick, the single most reusable heap pattern.

---

### Exercise 8: Top K Frequent Elements (`HashMap` + Heap)
- https://leetcode.com/problems/top-k-frequent-elements/

**Task:** Write `int[] topKFrequent(int[] nums, int k)`.
1. Count frequencies with `counts.merge(n, 1, Integer::sum)`.
2. Build a `PriorityQueue<Map.Entry<Integer, Integer>>` ordered by `Map.Entry.comparingByValue()`, keeping its size at `k`.
3. Drain the heap into the result array.
4. Rewrite it using bucket sort, where `List<Integer>[] buckets` is indexed by frequency, and compare the $O(n)$ result to the heap version.

* **Goal:** Combine two collections into one solution, and learn that a heap is not always the fastest answer when the priority range is bounded.

---

### Exercise 9: Merge K Sorted Lists (K-Way Merge)
- https://leetcode.com/problems/merge-k-sorted-lists/

**Task:** Write `ListNode mergeKLists(ListNode[] lists)`.
1. Create a `PriorityQueue<ListNode>` using `Comparator.comparingInt(n -> n.val)`.
2. Offer the head of each non-null list.
3. Repeatedly `poll()` the smallest node, attach it to a dummy-headed result list, and offer its `next` if it is not null.
4. State why this is $O(n \log k)$, where `n` is the total number of nodes, and why merging lists one by one is worse.

* **Goal:** Learn the K-way merge, the same idea used to merge sorted files in external sorting and database engines.

---

### Exercise 10: Max-Heaps and Comparator Pitfalls

**Task:** Build a `HeapComparatorLab` that creates max-heaps in several ways.
1. Create a max-heap with `new PriorityQueue<>(Comparator.reverseOrder())`.
2. Create one with the lambda `(a, b) -> b - a`. Offer `Integer.MIN_VALUE` and `1`, then poll and observe the wrong order caused by integer overflow.
3. Fix it with `(a, b) -> Integer.compare(b, a)`.
4. Create a `Task` record with `priority` and `createdAt`, and build a heap ordered by highest priority first, then oldest first, using `Comparator.comparingInt(Task::priority).reversed().thenComparing(Task::createdAt)`.
5. Iterate the heap with a for-each loop and print it, then poll everything and print it. Note that only polling gives sorted order.

* **Goal:** Never write the subtraction comparator again, and get fluent at chaining comparators on custom objects.

---

### Exercise 11: Median of a Data Stream (Two Heaps)
- https://leetcode.com/problems/find-median-from-data-stream/

**Task:** Build a `MedianFinder` with `addNum(int num)` and `double findMedian()`.
1. Hold a max-heap `lower` for the smaller half and a min-heap `upper` for the larger half.
2. In `addNum`, offer to `lower`, then move `lower.poll()` into `upper`.
3. If `upper` is now larger than `lower`, move one element back so `lower` is always equal in size or one bigger.
4. `findMedian` returns `lower.peek()` for odd totals, or the average of both peeks as a `double` for even totals.

* **Goal:** Learn dynamic min and max tracking with heaps working as a pair, a pattern used in streaming analytics.

---

### Exercise 12: Dijkstra's Shortest Path (Lazy Deletion)
- https://leetcode.com/problems/network-delay-time/

**Task:** Write `int networkDelayTime(int[][] times, int n, int k)`.
1. Build an adjacency list as `Map<Integer, List<int[]>>` using `computeIfAbsent`.
2. Use a `PriorityQueue<int[]>` of `{node, distance}` ordered by distance.
3. When you poll an entry whose distance is greater than the best known distance for that node, skip it.
4. Explain in a comment why `PriorityQueue` has no decrease-key operation, why `remove(Object)` is $O(n)$, and why pushing duplicates and skipping stale entries is the standard workaround.

* **Goal:** Apply a heap to a real graph algorithm and understand the practical limits of the JDK implementation.

---

### Exercise 13: `ArrayDeque` vs `LinkedList` Benchmark

**Task:** Write a `QueueBenchmark` that offers and polls 10 million `Integer` values through each implementation.
1. Run a warm-up loop first so the JIT compiler has optimised the code before you measure.
2. Time the measured runs with `System.nanoTime()` and print the results.
3. Run with `-verbose:gc` or `-Xlog:gc` and compare garbage collection activity between the two.
4. As a stretch goal, rewrite it properly using JMH and compare the numbers to your hand-rolled version.

* **Goal:** Prove to yourself that contiguous memory and zero per-node allocation beat scattered nodes, rather than taking it on trust.

---

### Exercise 14: Producer-Consumer, then a Lock-Free SPSC Ring Buffer

**Task:** Pass `long` values from one producer thread to one consumer thread, first the easy way and then the fast way.
1. Build a baseline using `ArrayBlockingQueue<Long>` with `put()` and `take()`. Measure throughput.
2. Build a `SpscLongRingBuffer` holding a pre-allocated `long[]` with power-of-two capacity, plus two `AtomicLong` sequences: `head` written only by the consumer and `tail` written only by the producer.
3. `offer(long v)` returns `false` if `tail - head == capacity`. Otherwise it writes `buffer[(int) (tail & mask)]` and publishes with `tail.lazySet(tail + 1)`.
4. `poll()` returns a sentinel or empty result if `head == tail`. Otherwise it reads the slot and publishes with `head.lazySet(head + 1)`.
5. Confirm with a GC log that the ring buffer allocates nothing after construction, and compare throughput against step 1. As a stretch goal, read about false sharing and why libraries like the LMAX Disruptor pad their sequence counters.

* **Goal:** Understand why single-writer ownership removes the need for locks, and how pre-allocated primitive arrays keep the garbage collector out of the hot path.

---

**Three habits to enforce across all of these:**
- Declare to the interface and instantiate the implementation, so `Queue<Integer> q = new ArrayDeque<>();` and never `ArrayDeque<Integer> q = ...`.
- Write the empty-collection and single-element test cases before the happy path, since that is where queues and linked lists break.
- Write the time and space complexity as a comment above every method before you run it, then check whether the code actually matches.
