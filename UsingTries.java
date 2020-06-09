
public class UsingTries {
    public static void main(String[] args) {
        Tries trie = new Tries();
        trie.insert("car");
        trie.insert("care");
        //System.out.println(trie.containsWord(null));
        //trie.traverse();
        trie.removeWord("care");
    }
}