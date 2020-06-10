public class AutoWordSuggestionUsingTries {
    public static void main(String[] args) {
        Tries trie = new Tries();
        trie.insert("car");
        trie.insert("card");
        trie.insert("care");
        trie.insert("careful");
        trie.insert("egg");
        System.out.println(
            trie.generateWordSuggestion("a"));
    }
}