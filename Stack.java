public class Stack {

    private int[] storage = new int[100];
    private int top=-1;
	public void push(int element) {
        storage[++top] = element;
        //Check for GitHUB
        int i=0;
    }
	public void pop() {
        if (top!=-1) top--;
        else top=-1;
	}
	public int peek() {
        if(top!=-1) return storage[top];
        else return -1;
	}
	public boolean isEmpty() {
        if(top==-1) return false;
        return true;
	}


}