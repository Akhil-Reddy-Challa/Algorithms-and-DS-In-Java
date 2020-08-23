/*
To use this Class
Create an object in a java file
Usable/Public methods:
1) insert(int)
2) display()
3) remove()
*/
public class MinHeapHelper {

    int[] values = new int[100];
    int counter = 0;
    int root = values[0];

    public void insert(int data) {
        values[counter++] = data;
        bubbleUp();
    }

    private void bubbleUp() {
        var index = counter - 1;
        while (index > 0 && values[index] < values[parentIndex(index)]) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    private void swap(int index, int parentIndex) {
        int temp = values[index];
        values[index] = values[parentIndex];
        values[parentIndex] = temp;
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    public void display() {
        for (int i = 0; i < counter; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println();
    }

    public void findElementIndex(int value_to_find) {
        findElementIndex(value_to_find, 0);
    }

    private void findElementIndex(int value_to_find, int index) {
        if (values[index] == value_to_find) {
            System.out.println("Found at index: " + index);
            return;
        }
        // Now go to left child
        if (leftChildIndex(index) < counter)
            findElementIndex(value_to_find, leftChildIndex(index));
        // Now go to right child
        if (rightChildIndex(index) < counter)
            findElementIndex(value_to_find, rightChildIndex(index));
    }

    private int rightChildIndex(int index) {
        return 2 * index + 2;
    }

    private int leftChildIndex(int index) {
        return 2 * index + 1;
    }

    public void remove() {
        /*
         * Goal: Removing the root(Lowest Integer) node and make 2nd lowest int as the
         * root 1) First Pop the last element and place it as Root 2) Then write a logic
         * to check if heap is balanced or not
         */
        if (counter == 0) // If heap is empty
            throw new IllegalStateException();
        // Now game starts
        // First replace the root with last element
        values[0] = values[--counter];
        // Now check if the childrens are balanced
        int index = 0;
        while (index < counter && !ifParentIsValid(index)) {
            // Swapping time
            // We now know that some child has less value than root
            int largerChildIndex = getSmallerChildIndex(index);
            // We have large child value
            // Swap them
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }

    }

    private int getSmallerChildIndex(int index) {
        int highIndex = counter;
        if (hasLeftChild(index) && values[leftChildIndex(index)] < values[index])
            highIndex = leftChildIndex(index);// Don't return yet, because right child might be much lesser than left
        if (hasRightChild(index) && values[rightChildIndex(index)] < values[index]
                && values[rightChildIndex(index)] < values[leftChildIndex(index)])
            highIndex = rightChildIndex(index);// Because we compared right child value with left value

        return highIndex;
    }

    private boolean ifParentIsValid(int index) {
        // check if this node has left child
        if (hasLeftChild(index) && values[leftChildIndex(index)] <= values[index])
            return false;
        // Above says that left child is less than root, so we return false to swap

        // Now check if right is great or not
        if (hasRightChild(index) && values[rightChildIndex(index)] <= values[index])
            return false;

        /*
         * At this point either right,left child are greater than root
         */
        return true;

    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) < counter;
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) < counter;
    }

    public int getMax() {
        // Returns root node of a tree
        return values[0];
    }

}