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
