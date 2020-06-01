public class WorkingWithQueues {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        queue.enqueue(10);
        queue.enqueue(122);
        queue.enqueue(14);
        queue.dequeue();
        System.out.println(queue.peek());
        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());
    }
}