
public class MaxHeap {
    public static void main(String[] args) {
        int[] array = { 45, 4, 78, 2, 0, 89 };
        var heap = new MaxHeapHelper();
        for (var number : array)
            heap.insert(number);
        // heap.display();
        for (int i = 0; i < array.length; i++) {
            System.out.println("Max element(" + (i + 1) + ") " + heap.getMax());
            heap.remove();
        }
    }
}