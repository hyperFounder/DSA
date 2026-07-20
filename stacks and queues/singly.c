#include <stdio.h>
#include <stdlib.h>

struct Node {
    int val;
    struct Node *next;
};

struct Node *head = NULL;

void insertBeginning(int value){ // O(1)
    
    struct Node *node = (struct Node *)malloc(sizeof (struct Node));
    (*node).val = value;
    (*node).next = head;
    head = node;
}

void insertEnd(int value){
    struct Node *node = (struct Node *)malloc(sizeof(struct Node));
    struct Node *h = head;

    while (h->next != NULL){
        h = h->next;
    }

    h->next = node;
    node->val = value;
    node->next = NULL;
}

void insertPosition(int index, int value) {
    struct Node *node = (struct Node *)malloc(sizeof(struct Node));
    (*node).val = value;
    (*node).next = NULL;

    if (index == 0) {
        // Same as insert at beginning
        (*node).next = head;
        head = node;
        return;
    }

    struct Node *h = head;
    struct Node *temp = NULL;
    int count = 0;

    while (h != NULL && count < index) {
        temp = h;
        h = (*h).next;
        count++;
    }

    if (count == index) {
        (*node).next = h;
        (*temp).next = node;
    } else {
        printf("Index out of bounds.\n");
        free(node);
    }
}

void deleteBeginning(){
    if (head != NULL){
        head = head->next;
    }
}

void deleteEnd(){
    struct Node *h = head;

    while (h->next->next != NULL){
        h = h->next;
    }
    h->next = NULL;
}

void deletePosition(int index) {
    struct Node *h = head;
    struct Node *temp = NULL;
    int count = 0;

    // Deleting at the head
    if (index == 0) {
        temp = head;
        head = (*head).next;
        free(temp);
        return;
    }

    // Traverse to the node before the one to delete
    while (h != NULL && count < index - 1) {
        h = (*h).next;
        count++;
    }

    if (h == NULL || (*h).next == NULL) {
        printf("Index out of bounds.\n");
        return;
    }

    temp = (*h).next;
    (*h).next = (*temp).next;
    free(temp);
}


void printList(){ // O(n)
    struct Node *h = head;
    while (h != NULL){
        printf("%d -> ", (*h).val);
        h = (*h).next;
    }
    printf("NULL \n");
}

int main(){
    insertBeginning(10);
    insertBeginning(20);
    insertBeginning(30);
    deletePosition(2);
    //deleteBeginning();

    printList();

    return 0;
}