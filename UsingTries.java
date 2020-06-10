
public class UsingTries {
    public static void main(String[] args) {
        Tries trie = new Tries();
        trie.insert("care");
        trie.insert("car");
        trie.insert("cab");
        trie.insert("cage");

        System.out.println("Contain care: "+trie.containsWord("care"));
        trie.removeWord("care");
        System.out.println("Contain care: "+trie.containsWord("care"));
        System.out.println(trie.containsWord("car"));
        System.out.println(trie.containsWord("cab"));
        System.out.println(trie.containsWord("cage"));
        
        trie.traverse();
    }
}
/*
        if(index == word.length){
            System.out.println("INSIDE IF: Index is: "+index+" Value is: "+root.value);
            //root.isEndOfWord = false;
        }
        
        else if(root.hasChild(word[index])){
            System.out.println("Index is: "+index+" Value is: "+root.value);
            var temp_root = deleteWord(root.getChild(word[index]), word, index+1);
            System.out.println(temp_root.value+" "+temp_root.isEndOfWord+" "+temp_root.children.size()
            +" "+yesICanBeDeleted);

            if(temp_root.isEndOfWord && !endofWordIsDisabled) {
                System.out.println("I am disabled for "+temp_root.value);
                temp_root.isEndOfWord = false;
                endofWordIsDisabled = true;
            }
            if(yesICanBeDeleted){
                temp_root.children.remove(deleteCharacter);
                yesICanBeDeleted = false;
                System.out.println("DELETED...........................................");
            }
            else if(temp_root.children.size() == 0){
                System.out.println("I am deleting for "+temp_root.value);
                yesICanBeDeleted = true;deleteCharacter = temp_root.value;
                //temp_root.children.clear();
            }

        }
        return root;
*/