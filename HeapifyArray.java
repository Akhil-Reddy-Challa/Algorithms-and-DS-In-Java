import java.util.Arrays;

public class HeapifyArray {
    public static void main(String[] args) {
        int[] numbers = {5,3,8,4,1,2};
        //Heapify an array
        /*
        int deepestNode = numbers.length/2 -1;
        for(int i=deepestNode;i>=0;i--){
            heapify(numbers,i,numbers.length);
        }*/
        System.out.println(Arrays.toString(numbers));
        //Get kth largest in array using Heap
        System.out.println(kthlargest(numbers,6));
    }

    private static int kthlargest(int[] numbers, int k) {
        Heap heap = new Heap();
        for(var num: numbers)
            heap.insert(num);
        int highestNumber=0;
        while(k>0){
            highestNumber = heap.remove();
            k--;
        }
        return highestNumber;
    }

    private static void heapify(int[] numbers, int position, int length) {
        
            int highIndex = position;//Assume parent is highest
            //Now see if leftChild exists, if yes compare value
            int leftChildIndex = 2*position +1;
            if(leftChildIndex < length && numbers[leftChildIndex] > numbers[highIndex])
                highIndex = leftChildIndex;//LeftChild is greater so highIndex points to leftChild
            int rightChildIndex = 2*position+2;
            if(rightChildIndex < length && numbers[rightChildIndex] > numbers[highIndex])
                highIndex = rightChildIndex;//Right child exists and is greater than highIndex(leftChild or parent)
            
            if(position == highIndex)
                return;
            swap(numbers, position, highIndex);
            heapify(numbers,highIndex, length);
        
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}