
public class MinHeap {
    public static void main(String[] args) {
        int[] array = { 45, 4, 78, 2, 0, 89 };
        var heap = new MinHeapHelper();
        for (var number : array) {
            System.out.println("Inserting " + number + " into the heap");
            heap.insert(number);
        }
        System.out.println("Resultant Heap:");
        heap.display();
        System.out.println("Number in ascending order:");
        for (int i = 0; i < array.length; i++) {
            System.out.println("Min element(" + (i + 1) + ") " + heap.getMax());
            heap.remove();
        }
    }
}