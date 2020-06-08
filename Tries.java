public class Tries {
    private static final int ALPHABET_SIZE = 26;
    private class Node{
        private char value;
        private Node[] children = new Node[ALPHABET_SIZE];
        private boolean isEndOfWord;

        Node(char value){
            this.value = value;
        }
    }
    private Node root = new Node(' ');

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

    private void display(Node current) {
        System.out.println("Values is : "+ current.value);
        for(int i=0;i<26;i++){
            if(current.children[i]!=null)
                //System.out.println((char)(i+97)+" Child exists");
                display(current.children[i]);
        }
        //System.out.println("E");
    }
}