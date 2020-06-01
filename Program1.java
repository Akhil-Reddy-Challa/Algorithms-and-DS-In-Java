import java.util.Stack;

public class Program1 {
    public static void main(String[] args) {
        String expression=")a(";
        Stack<Character> keys =new Stack<Character>();
        for (char value: expression.toCharArray()) {
            //System.out.println(value);
            if(value == '(' || value == '<' || value == '[')
            {
                keys.push(value);
            }
            else if(!keys.isEmpty() && (value == ')' || value == '>' || value == ']')){
                char c = keys.peek();
                if(c=='<' && value=='>') keys.pop();
                else if(c=='(' && value==')') keys.pop();
                else if(c=='[' && value==']') keys.pop();
            }
            
        }
        if(keys.isEmpty()){
            System.out.println("Expression is balanced");
        }
        else System.out.println("Expression is NOT-Balanced");
         
    }
}