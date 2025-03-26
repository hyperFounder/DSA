### Queue Data Structure

A **Queue** is a linear data structure that follows the **First In, First Out (FIFO)** principle. This means that the element added first will be the first one to be removed.

## Operations of a Queue
1. **Enqueue**: Add an element to the end of the queue.
2. **Dequeue**: Remove an element from the front of the queue.
3. **Front**: View the front element without removing it.
4. **IsEmpty**: Check if the queue is empty.
5. **IsFull**: Check if the queue is full (for array-based implementations).

## There are four different types of queues:

- Simple Queue ✅
- Circular Queue ✅ 
- Priority Queue (Linked List ✅, Heap ❌)
- Double Ended Queue ❌


### Applications of Queue

- CPU scheduling, Disk Scheduling
- When data is transferred asynchronously between two processes.The queue is used for synchronization. For example: IO Buffers, pipes, file IO, etc
- Handling of interrupts in real-time systems.
- Call Center phone systems use Queues to hold people calling them in order.

## Types of Queue Implementations

### 1. **Array-based Queue**
- A queue can be implemented using a fixed-size array.
- The front of the queue and the rear are tracked by indices.

### 2. **Linked List-based Queue**
- A queue can also be implemented using a linked list.
- The **front** is the head of the list, and the **rear** is the tail of the list.
- Dynamic resizing occurs naturally as new nodes are added and removed.

---

## Array-based Queue Implementation in C

```c
#include <stdio.h>
#include <stdlib.h>

#define MAX 5 // Maximum size of the queue

// Define the queue structure
struct Queue {
    int arr[MAX];
    int front;
    int rear;
};

// Initialize the queue
void initQueue(struct Queue* q) {
    q->front = -1;
    q->rear = -1;
}

// Check if the queue is empty
int isEmpty(struct Queue* q) {
    return (q->front == -1);
}

// Check if the queue is full
int isFull(struct Queue* q) {
    return (q->rear == MAX - 1);
}

// Enqueue operation (add an element to the queue)
void enqueue(struct Queue* q, int value) {
    if (isFull(q)) {
        printf("Queue is full!\n");
        return;
    }
    if (q->front == -1) {
        q->front = 0; // First element inserted
    }
    q->rear++;
    q->arr[q->rear] = value;
    printf("%d enqueued to the queue\n", value);
}

// Dequeue operation (remove an element from the queue)
int dequeue(struct Queue* q) {
    if (isEmpty(q)) {
        printf("Queue is empty!\n");
        return -1;
    }
    int dequeuedValue = q->arr[q->front];
    if (q->front == q->rear) { // A single value in queue
        q->front = q->rear = -1; // Reset queue when it becomes empty
    } else {
        q->front++;
    }
    return dequeuedValue;
}

// Display the queue
void displayQueue(struct Queue* q) {
    if (isEmpty(q)) {
        printf("Queue is empty!\n");
        return;
    }
    printf("Queue elements: ");
    for (int i = q->front; i <= q->rear; i++) {
        printf("%d ", q->arr[i]);
    }
    printf("\n");
}

int main() {
    struct Queue q;
    initQueue(&q);

    enqueue(&q, 10);
    enqueue(&q, 20);
    enqueue(&q, 30);

    displayQueue(&q);

    printf("%d dequeued from the queue\n", dequeue(&q));

    displayQueue(&q);

    return 0;
}
```

## Linked List implementation of a Queue
- This is basically a singly linked list with two pointers, *head (i.e: *front) at the start of the queue and *tail at the end of the queue.
- To enqueue, we insert at the end.
- To dequeue, we delete from the beginning.
---
![Screenshot 2025-03-24 at 18 49 28](https://github.com/user-attachments/assets/81829387-bf39-477f-bded-addb83ad7900)

- front is a pointer to Node.
- temp is also a pointer to Node (just copying the value of front).

```c
Node *front = NULL; // When we enqueue 10, 20, 30 front still points to 10.
Node *temp = front; // temp actually holds the same memory address as front

// Suppose we enqueue three nodes:
enqueue(10); // node1
enqueue(20); // node2
enqueue(30); // node3

temp = front; // temp points to front

```
---
```c
#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int val;
    struct Node *next;
} Node;

Node *front = NULL;
Node *tail = NULL;

void enqueue(int val) { // Insert at the END (tail)
    Node *node = (Node *)malloc(sizeof(Node));
    node->val = val;
    node->next = NULL;

    if (front == NULL) { // Queue is empty
        front = tail = node;
    } else {
        tail->next = node;
        tail = node;
    }
}

void dequeue() { // Remove from the FRONT
    if (front == NULL) {
        printf("Queue is empty... Exiting\n");
        exit(-1);
    } else {
        Node *temp = front;
        front = front->next;
        free(temp);
        if (front == NULL) { // If queue becomes empty after dequeue
            tail = NULL;
        }
    }
}

void print() {
    Node *h = front;
    while (h != NULL) {
        printf("val: %d -> \t", h->val);
        h = h->next;
    }
    printf("NULL\n");
}

int main() {
    enqueue(1);
    enqueue(2);
    enqueue(3);

    print();

    dequeue();

    print();

    dequeue();

    print();

    dequeue();

    print(); // Should print empty queue

    return 0;
}
```
