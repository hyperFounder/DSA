### DSA Utility Functions in Java

#### Doubly Linked List

A **Doubly Linked List** is a linear collection of elements where each element points to both its previous and next element.

#### Example Initialization

```java
LinkedList<Integer> list = new LinkedList<>();

list.add(10);  // Adds 10 at the end
list.addFirst(5);  // Adds 5 at the beginning
list.addLast(20);  // Adds 20 at the end

list.remove(10);
list.removeFirst();
list.removeLast();

int firstElement = list.getFirst();
int lastElement = list.getLast();

```

#### Stack

A Stack is a collection that follows the Last In First Out (LIFO) principle.

```java

Stack<Integer> stack = new Stack<>();

stack.push(10);  // Pushes 10 onto the stack
stack.push(20);  // Pushes 20 onto the stack
int poppedElement = stack.pop();  // Removes and returns the top element (20)

int topElement = stack.peek();  // Returns the top element without removing it

```
#### Queue

A Queue is a collection that follows the First In First Out (FIFO) principle.

```java

Queue<Integer> queue = new LinkedList<>();

Enqueue and Dequeue

queue.add(10);  // Adds 10 to the queue
queue.add(20);  // Adds 20 to the queue
int dequeuedElement = queue.remove();  // Removes and returns the front element (10)

Peek

int frontElement = queue.peek();  // Returns the front element without removing it

```

#### HashMap

A HashMap is a collection of key-value pairs, where each key is unique.

```java
Basic Operations

    Put and Get

map.put("apple", 1);  // Adds a key-value pair (apple -> 1)
int value = map.get("apple");  // Returns the value associated with the key "apple" (1)

    Remove

map.remove("apple");  // Removes the entry with key "apple"

    Check if Key Exists

boolean containsKey = map.containsKey("apple");  // Returns true if "apple" exists in the map
```

#### ArrayList

An ArrayList is a dynamic array that grows as needed to accommodate elements.
```java

ArrayList<Integer> list = new ArrayList<>();

Basic Operations

    Add Elements

list.add(10);  // Adds 10 to the list
list.add(20);  // Adds 20 to the list

    Get and Set Elements

int element = list.get(0);  // Gets the element at index 0
list.set(0, 30);  // Sets the element at index 0 to 30

    Remove Elements

list.remove(0);  // Removes the element at index 0
```
#### PriorityQueue

A PriorityQueue is a queue where elements are ordered based on their priority.
```java
PriorityQueue<Integer> pq = new PriorityQueue<>();

Basic Operations

    Add Elements

pq.add(10);  // Adds 10 to the queue
pq.add(20);  // Adds 20 to the queue

    Poll and Peek

int minElement = pq.poll();  // Removes and returns the minimum element (10)
int topElement = pq.peek();  // Returns the minimum element without removing it
```

#### TreeSet

A TreeSet is a collection of elements stored in a sorted order.
```java
TreeSet<Integer> set = new TreeSet<>();

Basic Operations

    Add Elements

set.add(10);  // Adds 10 to the set
set.add(5);  // Adds 5 to the set

    Remove Elements

set.remove(5);  // Removes 5 from the set

    Check if Element Exists

boolean contains = set.contains(10);  // Returns true if 10 is in the set
```
#### Sorting Utility
You can sort arrays and lists using Java’s built-in Collections and Arrays classes.
```java
ArrayList<Integer> list = new ArrayList<>();
list.add(20);
list.add(10);
list.add(30);
Collections.sort(list);  // Sorts in ascending order
System.out.println(list);  // Output: [10, 20, 30]

Example: Sorting Array

int[] arr = {20, 10, 30};
Arrays.sort(arr);  // Sorts in ascending order
System.out.println(Arrays.toString(arr));  // Output: [10, 20, 30]
```

#### HashSet

A HashSet is a collection that does not allow duplicate elements and does not maintain any order.

```java
HashSet<Integer> set = new HashSet<>();

Basic Operations

Add Elements

set.add(10);  // Adds 10 to the set
set.add(20);  // Adds 20 to the set
set.add(10);  // Does not add 10 because it's already present

Remove Elements

set.remove(10);  // Removes 10 from the set

Check if Element Exists

boolean contains = set.contains(20);  // Returns true if 20 is in the set

Size of the Set

int size = set.size();  // Returns the number of elements in the set

Iterating Through the Set

for (Integer element : set) {
    System.out.println(element);  // Prints all elements in the set
}
```

#### Maps

A `Map` in Java is a collection that stores key-value pairs. It allows efficient retrieval, insertion, and deletion of elements based on keys.

## 2. Types of Maps
Java provides several implementations of the `Map` interface:

| Map Type          | Key Ordering | Performance Notes |
|------------------|-------------|------------------|
| `HashMap`       | No order     | O(1) for insert, delete, and lookup |
| `LinkedHashMap` | Insertion order | Maintains order of insertion |
| `TreeMap`       | Sorted order (natural/comparator) | O(log n) operations using Red-Black Tree |

---
![Screenshot 2025-03-26 at 22 49 42](https://github.com/user-attachments/assets/735e1c70-e305-4621-9e3c-04283d5c88fd)

### 3.1 Using `HashMap`
```java
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 22);
        
        System.out.println(map.get("Alice")); // Output: 25
    }
}
```



