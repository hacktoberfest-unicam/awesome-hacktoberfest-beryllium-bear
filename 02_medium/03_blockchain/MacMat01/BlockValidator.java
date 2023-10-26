public class BlockValidator {

    public static boolean isValidNewBlock(Block newBlock, Block previousBlock) {
        // Rule 1: The index of the new block should be one greater than the previous block.
        if (newBlock.getIndex() != previousBlock.getIndex() + 1) {
            return false;
        }

        // Rule 2: The new block's previousHash should match the hash of the previous block.
        return newBlock.getPreviousHash().equals(previousBlock.getHash());
    }
}
