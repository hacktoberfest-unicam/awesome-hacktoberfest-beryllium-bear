#include <stdlib.h>
#include <stdio.h>
#include <string.h>


typedef struct Block{
    struct Block* prev;
    char* data;
    struct Block* next;
}Block;

Block *insertAtEmpty(Block *head, const char *value);
void *insertAfter(Block *prevNode, const char *value);
Block *appendToChain(Block *head, const char *value);

void printList(Block *head) {
    Block *current = head;

    while (current != NULL) {
        printf("%s\n", current->data);
        current = current->next;
    }
}


int main() {

    //? Clean declaration of head pointer
    Block* head = NULL;
    head = insertAtEmpty(head, "I'm the first block!");

    insertAfter(head, "I'm the second block!");
    appendToChain(head, "I'm the last block!");

    printList(head);

    return 0;
}

Block *appendToChain(Block *head, const char *value) {
    Block *newBlock = malloc(sizeof(Block));
    if (newBlock == NULL) {
        printf("Error creating a new block\n");
        return NULL;
    }

    newBlock->data = calloc(strlen(value) + 1, sizeof(char));
    strcpy(newBlock->data, value);

    newBlock->prev = NULL;
    newBlock->next = NULL;

    if (head == NULL) {
        head = newBlock;
    } else {
        Block *current = head;
        while (current->next != NULL) {
            current = current->next;
        }

        current->next = newBlock;
        newBlock->prev = current;
    }

    return head;
}

void *insertAfter(Block *prevNode, const char *value) {
    if (prevNode == NULL) {
        printf("Error: Previous node is NULL\n");
        return NULL;
    }

    Block *newBlock = malloc(sizeof(Block));
    if (newBlock == NULL) {
        printf("Error creating a new block\n");
        return NULL;
    }

    newBlock->data = calloc(strlen(value) + 1, sizeof(char));
    if (newBlock->data == NULL) {
        printf("Error allocating memory for data\n");
        free(newBlock);
        return NULL;
    }
    strcpy(newBlock->data, value);

    newBlock->prev = prevNode;
    newBlock->next = prevNode->next;

    if (prevNode->next != NULL) {
        prevNode->next->prev = newBlock;
    }

    prevNode->next = newBlock;

    return newBlock;
}
Block *insertAtEmpty(Block *head, const char* value){
    
    head = malloc(sizeof(Block));
    if(head == NULL) {
        printf("Error creating the head of list");
        return NULL;
    }

    head->prev = NULL;
    head->next = NULL;
    //? Using malloc, the string can be modified

    head->data = calloc(strlen(value) + 1, sizeof(char));
    //? With strcpy, we execute a DEEP COPY of the string. Any modifications to "value" won't affect "head->data"
    strcpy(head->data, value);
    

    return head;
    
}