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
        
        for(var child:root.getChildrens())
            traverse(child);
        
        System.out.println(root.value);
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

	public void removeWord(String word) {
        endOfWordIsDisabled = false;
        if(!containsWord(word)) System.out.println("Word doen't exist");
        else
        root = deleteWord(root,word.toCharArray(),0);

	}

    boolean endOfWordIsDisabled = false;
    private Node deleteWord(Node current_root, char[] word, int index) {

        if(index < word.length && current_root.hasChild(word[index])){
            var previous_root = deleteWord(current_root.getChild(word[index]), word, index+1);
            
            //Now we have two nodes, 1) Pointing to current node (2)  Pointing to previous node
            if(previous_root.isEndOfWord && !endOfWordIsDisabled){//Now we have reached end of word, so mark the endOfWord flag to false
                previous_root.isEndOfWord = false;
                endOfWordIsDisabled = true;//We set this true because we only have to mark the deleteingWord's endOfWord as false
            }
            if(previous_root.children.size() == 0 && endOfWordIsDisabled){//After flagging endofWord, if the letter is Orphan(No childs) we have to delete that;
                if(!previous_root.isEndOfWord){//To make sure we are not deleting another Words endOfWord;
                    current_root.children.remove(previous_root.value);
                } 
            }
        }
        
        return current_root;
    }

	public void generateWordSuggestion(String user_input) {
        generateWordSuggestion(user_input,root);
	}
    String word="";
    private void generateWordSuggestion(String input,Node temp_root) {
        
        for(var child:temp_root.getChildrens())
            traverse(child);
        
        word += temp_root.value;
        if(input == word) System.out.println("Yo");
        else System.out.println(temp_root.value);
       
    }

             
    }