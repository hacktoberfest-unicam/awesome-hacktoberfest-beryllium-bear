import hashlib
import time

# Block class definition
class Block:
    def __init__(self, data, previous_hash):
        self.timestamp = time.time()
        self.data = data
        self.previous_hash = previous_hash
        self.hash = self.calculate_hash()

    def calculate_hash(self):
        data_string = str(self.timestamp) + str(self.data) + str(self.previous_hash)
        return hashlib.sha256(data_string.encode()).hexdigest()

# Blockchain class definition
class Blockchain:
    def __init__(self):
        self.chain = [self.create_genesis_block()]

    def create_genesis_block(self):
        return Block("Genesis Block", "0")

    def add_block(self, data):
        previous_block = self.chain[-1]
        new_block = Block(data, previous_block.hash)
        self.chain.append(new_block)

    def is_chain_valid(self):
        for i in range(1, len(self.chain)):
            current_block = self.chain[i]
            previous_block = self.chain[i - 1]

            if current_block.hash != current_block.calculate_hash():
                return False

            if current_block.previous_hash != previous_block.hash:
                return False

        return True

# Create a blockchain and add some blocks
my_blockchain = Blockchain()
my_blockchain.add_block("Transaction 1")
my_blockchain.add_block("Transaction 2")
my_blockchain.add_block("Transaction 3")

# Print the blockchain
for block in my_blockchain.chain:
    print("Timestamp:", block.timestamp)
    print("Data:", block.data)
    print("Hash:", block.hash)
    print("Previous Hash:", block.previous_hash)
    print()

# Check if the blockchain is valid
if my_blockchain.is_chain_valid():
    print("Blockchain is valid.")
else:
    print("Blockchain is not valid. It may have been tampered with.")
