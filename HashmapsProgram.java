import java.util.HashMap;

public class HashmapsProgram {
    public static void main(String[] args) {
        HashMap<Character,Integer> hash = new HashMap<>();
        String line = "agre";
        //Character c;
        char letter;
        char non_repeated_char = line.charAt(0);
        for(int i=0;i<line.length();i++){
            letter = line.charAt(i);
            if(hash.containsKey(letter)){  
                hash.put(letter, hash.get(letter)+1);
            }
            else {
                hash.put(letter,1);
            }
        }
        System.out.println(hash);
        for(int i=0;i<line.length();i++){
            letter = line.charAt(i);
            if(hash.get(letter) == 1)
                {non_repeated_char = letter;break;}
        }
        System.out.println(non_repeated_char);
    
        
    }
}