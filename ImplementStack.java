public class ImplementStack {
    public static void main(String[] args) {
        Stacks stack = new Stacks();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
    }
}