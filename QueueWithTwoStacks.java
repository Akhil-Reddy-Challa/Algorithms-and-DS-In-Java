import java.util.PriorityQueue;

public class QueueWithTwoStacks {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(12);
        queue.add(13);
        queue.add(1);
        System.out.println(queue);
    }
    
}