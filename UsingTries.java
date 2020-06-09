
public class UsingTries {
    public static void main(String[] args) {
        Tries trie = new Tries();
        trie.insert("Yugoslevia");
        trie.insert("Yuge");
        System.out.println("Inserted");
        //System.out.println(trie.containsWord(null));
        trie.traverse();
    }
}