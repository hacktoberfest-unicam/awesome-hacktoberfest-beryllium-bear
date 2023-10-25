#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdbool.h>

#define MAX_DATA_LENGTH 10


typedef struct Block {
    struct Block* prev;
    char* data;
    struct Block* next;
} Block;

Block *insertAtEmpty(Block *head, const char *value);
void *insertAfter(Block *prevNode, const char *value);
Block *appendToChain(Block *head, const char *value);

bool validateBlock(Block *block);

void printList(Block *head); 

int main() {

    //? Clean declaration of head pointer
    Block* head = NULL;

    //let the user insert as many blocks as he wants
    char input[5000];
    while (true) {
        printf("A block must not have more than 3 vowels and 10 chars.\nInsert a new block (type 'exit' to stop): ");
        scanf("%s", input);

        if (strcmp(input, "exit") == 0) {
            break;
        }

        head = appendToChain(head, input);
    }

    head = appendToChain(head, "I'm the first block!");

    appendToChain(head, "I'm the last block!");
    
    printList(head);

    return 0;
}

void printList(Block *head) {
    Block *current = head;

    while (current != NULL) {
        printf("%s\n", current->data);
        current = current->next;
    }
}


bool validateBlock(Block *block) {

    //? check if block->data has more than 3 vowels inside
    int vowels = 0;
    for(int i = 0; i < strlen(block->data); i++) {
        if(block->data[i] == 'a' || block->data[i] == 'e' || block->data[i] == 'i' || block->data[i] == 'o' || block->data[i] == 'u') {
            vowels++;
        }
    }

    if(vowels > 3) {
        return false;
    }

    //? check if block->data has more than 10 characters
    if(strlen(block->data) > MAX_DATA_LENGTH) {
        return false;
    } else {
        printf("Block validated!\n");
        return true;
    }
}

Block *createBlock(const char *value) {
    Block *newBlock = malloc(sizeof(Block));
    if (newBlock == NULL) {
        printf("Error creating a new block\n");
        return NULL;
    }

    newBlock->data = calloc(strlen(value) + 1, sizeof(char));
    strcpy(newBlock->data, value);

    newBlock->prev = NULL;
    newBlock->next = NULL;

    return newBlock;
}

Block *appendToChain(Block *head, const char *value) {
    Block *newBlock = createBlock(value);
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

    if(!validateBlock(newBlock)) {
        printf("Block was not validated!\n");
        return NULL;
    }

    return head;
}

