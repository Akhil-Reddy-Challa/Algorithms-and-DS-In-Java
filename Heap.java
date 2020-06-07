/*
To use this Heap
Create an Heap object in a java file
Usable/Public methods:
1) insert(int)
2) display()
3) remove()
*/
public class Heap {
    
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

	public void display() {
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
        if(leftChildIndex(index)<counter)
            findElementIndex(value_to_find, leftChildIndex(index));
        //Now go to right child
        if(rightChildIndex(index)<counter)
            findElementIndex(value_to_find, rightChildIndex(index));
    }

    private int rightChildIndex(int index) {
        return 2*index + 2;
    }

    private int leftChildIndex(int index) {
        return 2*index + 1;
    }

	public void remove() {
        /* Goal: Removing the root(Highest Integer) node and make 2nd Highest int as the root
        1) First Pop the last element and place it as Root
        2) Then write a logic to check if heap is balanced or not
        */
        if(counter == 0) //If heap is empty
            throw new IllegalStateException();
        
        //Before any operation Print the value that is going to be deleted
        System.out.println(values[0]);//Now game starts
        
        //Now replace the root with last element
        values[0] = values[--counter];
        //Now check if the childrens are balanced
        int index =0;
        while( index < counter && ifParentIsValid(index)){
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
        int highIndex = counter;
        if( hasLeftChild(index) && values[leftChildIndex(index)] > values[index] )
            highIndex = leftChildIndex(index);//Ww are not returning because right child might be bigger
        if(hasRightChild(index) && values[rightChildIndex(index)] > values[leftChildIndex(index)] && values[rightChildIndex(index)] > values[index] )
            return rightChildIndex(index);//Because we compared right child value with left value
        return highIndex;//To make the while loop stop
    }

    private boolean ifParentIsValid(int index) {
        //check if this node has left child
        if(!hasLeftChild(index))
            return false;//Because insertion happens from left to right in HEAP
        //If above not true
        if( values[leftChildIndex(index)] >= values[index] ) return true;
        //Above says that left child is not greater than root
        
        //Now check if right is great or not
        if(hasRightChild(index) && values[rightChildIndex(index)] >= values[index])
             return false;
        
        /* At this point either 
        1) right,left child are lesser than root
        or
        2) no right child
        */
        return true;
        
    }

    private boolean hasRightChild(int index) {
        return (rightChildIndex(index) < counter) ? true : false;
    }

    private boolean hasLeftChild(int index) {
        return (leftChildIndex(index) < counter) ? true : false;
    }


}