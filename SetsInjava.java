import java.util.HashSet;

public class SetsInjava {
    public static void main(String[] args) {
        HashSet<Character> hash = new HashSet<>();
        String s= "greenapple";
        System.out.println(s.hashCode());
        
        for(var character:s.toCharArray()){
            if(hash.contains(character))
                {
                    System.out.println("First repeated Char is: "+character);
                    break;
                }
            else hash.add(character);
        }
        
        System.out.println(hash);
        
    }
}