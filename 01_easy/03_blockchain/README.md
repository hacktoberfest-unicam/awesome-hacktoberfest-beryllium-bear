# Blockchain
A blockchain is a distributed ledger with growing lists of records (blocks) that are securely linked together via cryptographic hashes.
Each block contains a cryptographic hash of the previous block, a timestamp, and transaction data. 
Since each block contains information about the previous block, they effectively form a chain, with each additional block linking to the ones before it. 
Consequently, blockchain transactions are irreversible in that, once they are recorded, the data in any given block cannot be altered retroactively without altering all subsequent blocks.

In this problem, you have to create a block data structure and the chain data structure.
For the `transaction data`, just use a string that will be considered the content of the block.
The user has to be able to create a block and add it to the chain.
Persistence is not required, but is suggested.

## Limitations
You can use one of the following programming languages:
- C
- C++
- C#
- Java
- Python 3
