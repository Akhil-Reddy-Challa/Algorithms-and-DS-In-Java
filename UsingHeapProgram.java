public class UsingHeapProgram {
    public static void main(String[] args) {
        //Testing for heap Program
        //Make array sorted
        int[] array = {45,4,78,2,0,89};
        Heap heap = new Heap();
        for(var number:array){
            heap.insert(number);
        }
    }
}