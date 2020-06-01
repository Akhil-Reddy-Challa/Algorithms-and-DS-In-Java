
public class LinkedListprogram {
    private class Node {
        private int value;
        private Node next;
        public Node(int value){
            this.value = value;
        }
    }
    private Node first;
    private Node last;
    private int count_of_items_in_linked_list=0;
    public void addLast(int item){
        var new_node = new Node(item);

        if(first==null)
            first = last = new_node;
        else{
            last.next = new_node;
            last = new_node;
        }
        count_of_items_in_linked_list++;
    }
	public void addFirst(int item) {
        var new_node = new Node(item);
        if(first==null)
            first = last = new_node;
        else{
            new_node.next = first;
            first = new_node;
        }
        count_of_items_in_linked_list++;
    }
	public int indexOf(int element) {
        if(first!=null){
            Node temp = first;
            int indexOfElement=-1;
            while(temp!=null){
                indexOfElement++;
                if(temp.value == element)
                    return indexOfElement;
                else
                    temp = temp.next;
            }
        }
        return -1;
	}
	public void print() {
        Node temp = first;
        while(temp!=null){
            System.out.print(temp.value+" ");
            temp=temp.next;
        }
        System.out.println();
	}
	public boolean contains(int element) {
        if(indexOf(element)!=-1)
            return true;
        return false;
	}
	public void removeFirst() {
        if(first == null || first.next == null){
            first =null;
            count_of_items_in_linked_list = 0;
        }
        else {
            first = first.next;
            count_of_items_in_linked_list--;
        }
	}
	public void removeLast() {
        if(first==null || first.next == null){
            first = last = null;
            count_of_items_in_linked_list = 0;
        }
        else{
        Node temp = first;
        while(temp.next!=last){
            temp = temp.next;
        }
        temp.next = null;
        last = temp;
        count_of_items_in_linked_list--;
        }
	}
	public int size() {
        return count_of_items_in_linked_list;
    }
	public int[] toArray() {
        //int counter=0;
        int[] new_Array = new int[count_of_items_in_linked_list];
        Node temp = first;
        for(int i=0;i<count_of_items_in_linked_list;i++){
            new_Array[i] = temp.value;
            temp = temp.next;
        }
		return new_Array;
	}
	public void reverse() {
        
	}

}
