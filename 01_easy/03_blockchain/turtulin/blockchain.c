#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

typedef struct block {
    char *data;
    char *hash;
    char *prev_hash;
    time_t timestamp;
    struct block *next;
} block_t;

typedef struct chain {
    block_t *head;
    block_t *tail;
    int size;
} chain_t;

block_t *create_block(char *data) {
    block_t *new_block = (block_t*) malloc(sizeof(block_t));
    new_block->data = strdup(data);
    new_block->hash = NULL;
    new_block->prev_hash = NULL;
    new_block->timestamp = time(NULL);
    new_block->next = NULL;
    return new_block;
}

char *calculate_hash(block_t *block) {
    char *hash =  (char*) malloc(33);
    sprintf(hash, "%p%p%ld", block->data, block->prev_hash, block->timestamp);
    return hash;
}

void add_block(chain_t *chain, block_t *block) {
    if (chain->head == NULL) {
        chain->head = block; 
        chain->tail = block; 
        chain->size = 1;
        block->hash = calculate_hash(block);
    } else {
        chain->tail->next = block;
        block->prev_hash = chain->tail->hash;
        block->hash = calculate_hash(block);
        chain->tail = block;
        chain->size++;
    }
}

void print_block(block_t *block) {
    printf("Data: %s\n", block->data);
    printf("Hash: %s\n", block->hash); 
    printf("Prev hash: %s\n", block->prev_hash);
    printf("Timestamp: %ld\n", block->timestamp);
}

void print_chain(chain_t *chain) {
    printf("Chain size: %d\n", chain->size);
    block_t *current = chain->head;
    while (current != NULL) {
        print_block(current);
        printf("\n");
        current = current->next;
    }
}

int main() {
    chain_t *chain = (chain_t*) malloc(sizeof(chain_t));
    chain->head = NULL;
    chain->tail = NULL; 
    chain->size = 0; 

    block_t *block1 = create_block("Marta invia 10 BTC a Giorgio");
    add_block(chain, block1); 

    block_t *block2 = create_block("Giorgio invia 5 BTC a Marta");
    add_block(chain, block2);

    print_chain(chain);

    return 0;
}
