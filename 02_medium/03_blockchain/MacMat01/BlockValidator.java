public class BlockValidator {

    public static boolean isValidNewBlock(Block newBlock, Block previousBlock) {
        // Rule 1: The index of the new block should be one greater than the previous block.
        if (newBlock.getIndex() != previousBlock.getIndex() + 1) {
            return false;
        }

        // Rule 2: The new block's previousHash should match the hash of the previous block.
        if (!newBlock.getPreviousHash().equals(previousBlock.getHash())) {
            return false;
        }

        // Rule 3: The new block's hash should be valid (e.g., meet a certain difficulty target).
        return isValidBlockHash(newBlock.getHash());
    }

    // Add more validation rules as needed.

    private static boolean isValidBlockHash(String hash) {
        // You can define a difficulty target or other criteria for a valid hash.
        // For example, the hash should start with a certain number of leading zeros.
        // Implement your specific criteria here.
        return true; // Replace with your validation logic.
    }
}
