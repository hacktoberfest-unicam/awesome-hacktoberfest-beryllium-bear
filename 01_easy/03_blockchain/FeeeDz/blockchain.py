import hashlib
import json
import time

blockchain = []

def get_last_blockchain_value():
    """ Restituisce l'ultimo valore della blockchain corrente """
    if len(blockchain) == 0:
        return None
    return blockchain[-1]

def add_block(transaction_amount):
    """ Aggiunge un nuovo blocco alla blockchain.

    Argomenti:
        :transaction_amount: L'importo della transazione da aggiungere.
    """
    previous_block = get_last_blockchain_value()
    if previous_block is None:
        previous_hash = ''
    else:
        previous_hash = hashlib.sha256(json.dumps(previous_block, sort_keys=True).encode()).hexdigest()

    new_block = {
        'previous_hash': previous_hash,
        'timestamp': time.time(),
        'data': transaction_amount
    }
    blockchain.append(new_block)

def get_user_input():
    """ Restituisce l'input dell'utente (un nuovo importo della transazione) come float. """
    return float(input('Inserisci l\'importo della tua transazione: '))

def main():
    num_blocks = int(input("Quanti blocchi vuoi inserire nella blockchain? "))
    for _ in range(num_blocks):
        tx_amount = get_user_input()
        add_block(tx_amount)

    # Visualizza la lista della blockchain nella console
    for i, block in enumerate(blockchain):
        print(f'Block {i+1}')
        print(block)

if __name__ == "__main__":
    main()
