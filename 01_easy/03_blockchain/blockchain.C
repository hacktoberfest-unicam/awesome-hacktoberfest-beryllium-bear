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
    block_t *new_block = (block_t*) malloc(sizeof(block_t)); // Allocazione dinamica della memoria per il nuovo blocco
    new_block->data = strdup(data); // Copia dei dati nel nuovo blocco
    new_block->hash = NULL; // Inizializzazione dell'hash a NULL
    new_block->prev_hash = NULL; // Inizializzazione dell'hash precedente a NULL
    new_block->timestamp = time(NULL); // Impostazione del timestamp corrente
    new_block->next = NULL; // Inizializzazione del puntatore al prossimo blocco a NULL
    return new_block; // Restituzione del nuovo blocco creato
}

char *calculate_hash(block_t *block) {
    char *hash =  (char*) malloc(33); // Allocazione dinamica della memoria per l'hash (32 caratteri + terminatore)
    sprintf(hash, "%p%p%ld", block->data, block->prev_hash, block->timestamp); // Generazione dell'hash usando l'indirizzo dei dati, l'indirizzo dell'hash precedente e il timestamp
    return hash; // Restituzione dell'hash calcolato
}

void add_block(chain_t *chain, block_t *block) {
    if (chain->head == NULL) { // Se la catena è vuota
        chain->head = block; // Imposta il blocco come testa della catena
        chain->tail = block; // Imposta il blocco come coda della catena
        chain->size = 1; // Imposta la dimensione della catena a 1
        block->hash = calculate_hash(block); // Calcola l'hash del blocco
    } else { // Se la catena non è vuota
        chain->tail->next = block; // Collega il blocco alla coda della catena
        block->prev_hash = chain->tail->hash; // Imposta l'hash precedente del blocco come l'hash della coda della catena
        block->hash = calculate_hash(block); // Calcola l'hash del blocco
        chain->tail = block; // Imposta il blocco come nuova coda della catena
        chain->size++; // Incrementa la dimensione della catena di 1
    }
}

void print_block(block_t *block) {
    printf("Data: %s\n", block->data); // Stampa i dati del blocco
    printf("Hash: %s\n", block->hash); // Stampa l'hash del blocco
    printf("Prev hash: %s\n", block->prev_hash); // Stampa l'hash precedente del blocco
    printf("Timestamp: %ld\n", block->timestamp); // Stampa il timestamp del blocco
}

void print_chain(chain_t *chain) {
    printf("Chain size: %d\n", chain->size); // Stampa la dimensione della catena
    block_t *current = chain->head; // Puntatore al primo blocco della catena
    while (current != NULL) { // Finché il puntatore non è NULL
        print_block(current); // Stampa i dettagli del blocco corrente
        printf("\n"); // Stampa una riga vuota
        current = current->next; // Passa al blocco successivo
    }
}

int main() {
    chain_t *chain = (chain_t*) malloc(sizeof(chain_t));
    chain->head = NULL; // Inizializzazione della testa a NULL
    chain->tail = NULL; // Inizializzazione della coda a NULL
    chain->size = 0; // Inizializzazione della dimensione a 0

    block_t *block1 = create_block("Alice invia 10 BTC a Bob"); // Creazione di un nuovo blocco con i dati forniti
    add_block(chain, block1); // Aggiunta del blocco alla catena

    block_t *block2 = create_block("Bob invia 5 BTC a Charlie"); // Creazione di un altro blocco con i dati forniti
    add_block(chain, block2); // Aggiunta del blocco alla catena

    print_chain(chain); // Stampa i dettagli della catena

    return 0; // Terminazione del programma
}
