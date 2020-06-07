public class Heaps {
    public static void main(String[] args) {
        ImplementHeap heap = new ImplementHeap();
        heap.insert(10);
        heap.insert(5);
        heap.insert(17);
        heap.insert(4);
        heap.insert(22);
        heap.insert(7);
        heap.insert(8);
        heap.displayArray();
        heap.findElementIndex(8);
        heap.remove();
        heap.displayArray();
    }
}