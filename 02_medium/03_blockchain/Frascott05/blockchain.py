import time

#crea il singolo blocco
class Block:
    def __init__(self, index, previous_hash, data):
        self.index = index
        self.timestamp = time.time()
        self.data = data
        self.previous_hash = previous_hash
    


#creazione della catena
class Blockchain:
    def __init__(self):
        self.chain = [self.create_genesis_block()]

    def create_genesis_block(self):
        return Block(0, "0", "Blocco Genitore")#definisco un blocco di partenza

    def get_latest_block(self):
        return self.chain[-1]

    def add_block(self, data):
        previous_block = self.get_latest_block()
        new_index = previous_block.index + 1                #setto l'index al quale inserire il nuovo blocco
        new_block = Block(new_index, previous_block, data)  #creo il nuovo blocco
        self.chain.append(new_block)                        #aggiungo il blocco alla catena


def block_validitation(transaction):
    if "sono scemo" == transaction or "odio unicam" == transaction or "a morte il Gabibbo" in transaction:
        return False
    else:
        return True
#utilizzo
blockchain = Blockchain()
#aggiungo blocchi finchè l'utente non vuole uscire
while(True):
    transaction = input("Insert your transaction or press exit to terminate the programm: ")
    if transaction != "exit":
        if block_validitation(transaction):
            blockchain.add_block(transaction)
        else:
            print("Hai inserito una parola non valida")
    else:
        print("Arrivederci")
        break

for block in blockchain.chain:
    print(f"Block {block.index} - Data: {block.data} - Time: {block.timestamp}")