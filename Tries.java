import java.util.HashMap;

public class Tries {
    private class Node{
        private char value;
        private HashMap<Character,Node> children = new HashMap<>();
        private boolean isEndOfWord;

        Node(char value){
            this.value = value;
        }

        public boolean hasChild(char letter) {
            return children.containsKey(letter);
        }

        public void addChild(char letter) {
            children.put(letter, new Node(letter));
        }

        public Node getChild(char letter) {
            return children.get(letter);
        }

        public Node[] getChildrens() {
            return children.values().toArray(new Node[0]);
        }
    }
    private Node root = new Node(' ');//We need to have an empty root always

    public void insert(String word){
        var current = root;
        //Convert String to Lowercase
        word = word.toLowerCase();
        for(var letter:word.toCharArray()){
            if(!current.hasChild(letter))
                current.addChild(letter);
            current = current.getChild(letter);
        }
        current.isEndOfWord = true;
    }

/*
This is using Array which leads to memory wastage;
Hence replacing array in Node class with HashMap

        public void insert(String word){
        var current = root;
        //Convert String to Lowercase
        word = word.toLowerCase();
        int position_to_insert=0;
        for(var letter:word.toCharArray()){
            
            position_to_insert = letter -'a';//We have character index now

            //Check to see if the letter is already inserted in the Trie
            if(current.children[position_to_insert] == null)
                current.children[position_to_insert] = new Node(letter);
            current = current.children[position_to_insert];
        }
        //We have inserted the word into the tree
        //Set the end of word to true
        current.isEndOfWord = true;
    }
*/
    public void traverse() {
       traverse(root);
    }

	private void traverse(Node root) {
        System.out.println(root.value);
        //Now get all the childrens from the Node
        for(var child:root.getChildrens()){
            traverse(child);
        }
    }

    public boolean containsWord(String word) {
        if(word == null) return false;

        word = word.toLowerCase();
        Node current = root;
        for(var letter:word.toCharArray()){
            if(!current.hasChild(letter))
                return false;
            current = current.getChild(letter);
        }
        return current.isEndOfWord;
	}
}