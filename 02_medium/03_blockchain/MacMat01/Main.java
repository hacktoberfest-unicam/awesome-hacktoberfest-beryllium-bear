public class Main {
    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();

        // Add blocks to the chain
        Block block1 = blockchain.createBlock("Transaction 1");
        Block block2 = blockchain.createBlock("Transaction 2");

        // Print the blockchain
        blockchain.printChain();

        // Check if the blockchain is valid
        boolean isValid = blockchain.isValid();
        System.out.println("Is the blockchain valid? " + isValid);
    }
}
