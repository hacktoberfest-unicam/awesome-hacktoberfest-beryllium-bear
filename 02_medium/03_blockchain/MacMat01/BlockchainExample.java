public class BlockchainExample {
    public static void main(String[] args) {
        int difficulty = 4; // Adjust the difficulty level.
        Blockchain myBlockchain = new Blockchain(difficulty);

        myBlockchain.createBlock("Block 1 Data");
        myBlockchain.createBlock("Block 2 Data");
        myBlockchain.createBlock("Block 3 Data");

        myBlockchain.printChain();
    }
}
