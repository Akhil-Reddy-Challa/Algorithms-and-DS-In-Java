
public class UsingTries {
    public static void main(String[] args) {
        Tries trie = new Tries();
        trie.insert("care");
        trie.insert("car");

        trie.removeWord("care");

        System.out.println(trie.containsWord("car"));
        System.out.println(trie.containsWord("care"));
        
        //trie.traverse();
    }
}