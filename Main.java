//import java.util.Arrays;

//Main.java
public class Main{
    public static void main(String[] args) {
        var list = new LinkedListprogram();
        list.addLast(10);
        list.addLast(12);
        list.addLast(16);
        list.addFirst(5);
        list.addLast(18);
        list.addLast(20);
        System.out.println("Size of Linked list is "+list.size());
        list.print(); 
        //var new_Array = list.toArray();
        //System.out.println(Arrays.toString(new_Array));
        //Reverse a Linked List
        list.reverse();
        
    }
}