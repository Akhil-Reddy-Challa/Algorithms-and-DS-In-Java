public class ArrayQueue {

    //Create array for Queue implementation
    //default size is 100
    int front = -1;
    int rear = -1;
    int[] array_for_queue = new int[100];
    int current_size = 0;
    int tt=0;
	public void enqueue(int number) {
        if(current_size < 100){
            array_for_queue[current_size++] = number;
            if(front == -1) front++;
            rear++;
        }
	}

	public void dequeue() {
        if(front == rear)
            //front = rear = -1;
            System.out.println("Queue is empty");
        else{
            front++;
        }
	}

	public int peek() {
        if(front < rear || (front == rear && front!=-1))
            return array_for_queue[front];
        else
            return -1;
	}

	public boolean isEmpty() {
        if(front==rear && front==-1)
            return true;
        return false;
	}

	public boolean isFull() {
        if(current_size == 100)
            return true;
        return false;
	}

}