import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Block {

    private final int index;
    private final long timestamp;
    private final String data;
    private final String previousHash;
    private final String hash;
    private final int nonce;

    public Block(int index, String data, String previousHash, int difficulty) {
        this.index = index;
        this.timestamp = System.currentTimeMillis();
        this.data = data;
        this.previousHash = previousHash;
        this.nonce = mineBlock(difficulty);
        this.hash = calculateHash();
    }

    public int getIndex() {
        return index;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getData() {
        return data;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getHash() {
        return hash;
    }

    public int getNonce() {
        return nonce;
    }

    public String calculateHash() {
        String dataToHash = index + timestamp + data + previousHash + nonce;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(dataToHash.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private int mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        int nonce = 0;
        while (true) {
            String attempt = calculateHash();
            if (attempt.startsWith(target)) {
                return nonce;
            }
            nonce++;
        }
    }
}

class Blockchain {
    private final List<Block> chain;
    private final int difficulty; // Adjust the difficulty level.

    public Blockchain(int difficulty) {
        chain = new ArrayList<>();
        this.difficulty = difficulty;
        // Create the genesis block (the first block in the chain)
        chain.add(new Block(0, "Genesis Block", "0", difficulty));
    }

    public Block createBlock(String data) {
        Block previousBlock = chain.get(chain.size() - 1);
        int newIndex = previousBlock.getIndex() + 1;
        String previousHash = previousBlock.getHash();
        Block newBlock = new Block(newIndex, data, previousHash, difficulty);
        chain.add(newBlock);
        return newBlock;
    }

    public boolean isValid() {
        for (int i = 1; i < chain.size(); i++) {
            Block currentBlock = chain.get(i);
            Block previousBlock = chain.get(i - 1);

            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                return false;
            }

            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                return false;
            }
        }
        return true;
    }

    public void printChain() {
        for (Block block : chain) {
            System.out.println("Block #" + block.getIndex());
            System.out.println("Timestamp: " + block.getTimestamp());
            System.out.println("Data: " + block.getData());
            System.out.println("Previous Hash: " + block.getPreviousHash());
            System.out.println("Nonce: " + block.getNonce());
            System.out.println("Hash: " + block.getHash());
            System.out.println();
        }
    }
}

