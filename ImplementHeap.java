public class ImplementHeap {
    
    int[] values = new int[100];
    int counter=0;
    int root= values[0];
	public void insert(int data) {
        values[counter++] = data;
        bubbleUp();
	}

    private void bubbleUp() {
        var index = counter-1;
        while(index>0 && values[parentIndex(index)] < values[index]){
            swap(index,parentIndex(index));
            index = parentIndex(index);
        }
    }

    private void swap(int index, int parentIndex) {
        int temp = values[index];
        values[index] = values[parentIndex];
        values[parentIndex] = temp;
    }

    private int parentIndex(int index) {
        return (index-1)/2;
    }

	public void displayArray() {
        for(int i=0;i<counter;i++){
            System.out.print(values[i]+" ");
        }
        System.out.println();
	}

	public void findElementIndex(int value_to_find) {
        findElementIndex(value_to_find,0);
	}

    private void findElementIndex(int value_to_find, int index) {
        if(values[index] == value_to_find){
            System.out.println("Found at index: "+index);
            return;
        }
        //Now go to left child
        if(leftChild(index)<counter)
            findElementIndex(value_to_find, leftChild(index));
        //Now go to right child
        if(rightChild(index)<counter)
            findElementIndex(value_to_find, rightChild(index));
    }

    private int rightChild(int index) {
        return 2*index + 2;
    }

    private int leftChild(int index) {
        return 2*index + 1;
    }

	public void remove() {
        /* Goal: Removing the root node and balance the Heap
        1) First Pop the last element and place it as Root
        2) Then write a logic to check if heap is balanced or not
        */
        if(counter == 0) //If heap is empty
            throw new IllegalMonitorStateException();
        //Now replace the root with last element
        values[0] = values[--counter];
        //Now check if the childrens are balanced
        int index =0;
        while(index<counter && !ifParentIsValid(index)){
            //Swapping time
            //We now know that some child is greater than root
            int largerChildIndex = getLargerChildIndex(index);
            //We have large child value
            //Swap them
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
	}

    private int getLargerChildIndex(int index) {
        return values[leftChild(index)] > values[rightChild(index)] ?
                leftChild(index) :
                rightChild(index);
    }

    private boolean ifParentIsValid(int index) {
        return values[leftChild(index)] <= values[index] &&
                values[rightChild(index)] <= values[index];
    }


}