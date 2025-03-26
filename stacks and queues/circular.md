### Circular Queue

A **circular queue** is a data structure that uses a fixed-size array to store elements in a circular manner. It is similar to a regular queue, but it efficiently uses the available space by wrapping around when the rear of the queue reaches the end of the array.

### Key Concepts

1. **Front Pointer**: This pointer tracks the front of the queue, i.e., the position of the element that will be dequeued next.
2. **Rear Pointer**: This pointer tracks the rear of the queue, i.e., the position where the next element will be enqueued.
3. **Full Queue**: A circular queue is considered full when the next position of the rear pointer is the front pointer (i.e., the rear pointer is one step before the front pointer).
4. **Empty Queue**: A circular queue is empty when the front pointer is equal to the rear pointer.

### Operations

1. **Enqueue (Insert an element)**:
   - If the queue is not full, the rear pointer is incremented, and the new element is added at the rear.
   - The rear pointer wraps around when it reaches the end of the array.

2. **Dequeue (Remove an element)**:
   - If the queue is not empty, the element at the front pointer is removed, and the front pointer is incremented.
   - The front pointer wraps around when it reaches the end of the array.


### Example in C:

```c
#define MAX 5

int queue[MAX];
int front = -1;
int rear = -1;

void enqueue(int value) {
    if ((rear + 1) % MAX == front) {
        printf("Queue is full\n");
        return;
    }
    if (front == -1) { // if queue is empty
        front = 0;
    }
    rear = (rear + 1) % MAX;
    queue[rear] = value;
}

int dequeue() {
    if (front == -1) {
        printf("Queue is empty\n");
        return -1;
    }
    int value = queue[front];
    if (front == rear) { // Only a single value in the queue
        front = rear = -1;  // Queue becomes empty
    } else {
        front = (front + 1) % MAX;
    }
    return value;
}
```

