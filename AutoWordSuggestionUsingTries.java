public class AutoWordSuggestionUsingTries {
    public static void main(String[] args) {
        Tries trie = new Tries();
        trie.insert("car");
        trie.insert("card");
        trie.insert("care");
        trie.insert("careful");
        trie.insert("egg");
        String user_input = "car";
        trie.generateWordSuggestion(user_input);
    }
}