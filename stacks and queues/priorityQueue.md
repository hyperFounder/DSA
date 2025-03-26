## Priority Queue

- A **Priority Queue** is a data structure where elements are stored in order based on their priority. 
- In this type of priority queue, elements are kept sorted so that the element with the highest priority is always at the front of the queue.

### Ways it can be implemented:
- **Min-Heap or Max-Heap**: Typically implemented using heaps, where a **min-heap** gives priority to the smallest element, and a **max-heap** gives priority to the largest element.
- **Singly Linked List**:
  - **Insert**: O(n) time complexity, as the list needs to be sorted after each insertion.
  - **Delete (or Dequeue)**: O(1) time complexity, as the highest priority element is always at the front.
  - **Space Complexity**: O(n)

### Time Complexities Summary:
| Operation      | Binary Heap | Fibonacci Heap |
|----------------|-------------|----------------|
| **Insert**     | O(log n)    | O(1) (amortized)|
| **Delete**     | O(log n)    | O(log n) (amortized)|
| **Peek**       | O(1)        | O(1)           |
| **Space**      | O(n)        | O(n)           |


### Operations:
1. **Insert**: Adds an element with a specific priority to the queue.
2. **Delete (or Dequeue)**: Removes the element with the highest priority (min or max) from the queue.
3. **Peek (or Front)**: Retrieves the element with the highest priority without removing it.
4. **Is Empty**: Checks if the priority queue is empty.
5. **Change Priority**: Updates the priority of an existing element (in some implementations).

### Applications:
- **Task Scheduling**: Priority queues are used in scheduling tasks based on their priority.
- **Dijkstra’s Shortest Path Algorithm**: Priority queues are used to select the next node to process in the graph traversal.
- **Huffman Encoding**: Priority queues are essential in the construction of Huffman trees used for data compression.
- **Real-time Systems**: Priority queues ensure that high-priority tasks are processed before lower-priority ones.

### Singly Linked List priority queue implementation
- Example of a singly linked list priority queue.
```c
#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node* next;
    int priority;
} Node;

// Singly Linked List

// Enqueue function to insert nodes in priority order (highest priority at front)
int enqueue(Node **queue, Node* p){
    Node *h = *queue;
    Node *prev = NULL;

    while (h != NULL && h->priority > p->priority){
        prev = h;
        h = h->next;
    }
    
    if (prev == NULL){
        // Insert at the beginning
        p->next = *queue;
        *queue = p;
    } else {
        // Insert in the middle or at the end
        prev->next = p;
        p->next = h;
    }

    return 1; // Successful Enqueue
}

// Dequeue function to remove the highest priority element (front of the queue)
int dequeue(Node **queue) { // For a double pointer, we need to pass in the memory address of a pointer
    if (*queue == NULL) {
        printf("Queue is empty\n");
        return -1;  // Return error if queue is empty
    }

    Node* temp = *queue;
    int data = temp->data;
    *queue = (*queue)->next;  // Move the front pointer to the next node

    free(temp);  // Free the memory of the removed node
    return data;  // Return the dequeued data
}

// Print the priority queue
void printQueue(Node* queue) {
    if (queue == NULL) {
        printf("Queue is empty\n");
        return;
    }

    while (queue != NULL) {
        printf("(%d, %d) ", queue->data, queue->priority);
        queue = queue->next;
    }
    printf("\n");
}

int main() {
    Node* priorityQueue = NULL;

    // Example usage
    Node* node1 = (Node*)malloc(sizeof(Node));
    node1->data = 10;
    node1->priority = 2;
    node1->next = NULL;

    Node* node2 = (Node*)malloc(sizeof(Node));
    node2->data = 20;
    node2->priority = 1;
    node2->next = NULL;

    Node* node3 = (Node*)malloc(sizeof(Node));
    node3->data = 30;
    node3->priority = 3;
    node3->next = NULL;

    enqueue(&priorityQueue, node1);
    enqueue(&priorityQueue, node2);
    enqueue(&priorityQueue, node3);

    // Print the priority queue after enqueues
    printf("Priority Queue after enqueues: ");
    printQueue(priorityQueue);

    // Dequeue the highest priority element
    printf("Dequeued element: %d\n", dequeue(&priorityQueue));

    // Print the priority queue after dequeuing
    printf("Priority Queue after dequeue: ");
    printQueue(priorityQueue);

    // Clean up remaining nodes
    while (priorityQueue != NULL) {
        dequeue(&priorityQueue);
    }

    return 0;
}
```
