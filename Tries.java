import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

	public List<String> generateWordSuggestion(String user_input) {
        List<String> words = new ArrayList<>();//For storing all the words
        var lastNode_of_user_input = getLastNodeOf(root,user_input);
        //Now get the last letter's address of the user_input;
        //From the last_letter we should scan the remaining words;
        if(lastNode_of_user_input == null) return null;//If there is no such word
        else 
            fetchWords(lastNode_of_user_input,user_input,words);
        
        return words;
	}

    private void fetchWords(Node root, String user_input, List<String> words) {
        if(root.isEndOfWord)//If the current node is endOfWord add it to list
            words.add(user_input);
        for(var children:root.getChildrens())
        //Now to get the reamining words, traverse the trie, so loop through the root childrens
            fetchWords(children, user_input+children.value, words);
            //We should get new word everytime, hence we aggregate current_root_char to the user_input
    }

    private Node getLastNodeOf(Node temp_root, String user_input) {
        if(user_input == null) return null;//If input is null
        for(var letter:user_input.toCharArray()){
        //Iterate through the input word by word 
            if(temp_root.hasChild(letter))
                temp_root = temp_root.getChild(letter);//Find the last character
            else return null;//If input is not in the trie
        }
        return temp_root;//Return's the node which has the last char of input
    }
        
    }