public class Priorityqueue {
    
    private int counter=-1;
    int[] array = new int[100];
    
    void add(int element){
        if(counter == -1 || array[counter] < element)
            array[++counter] = element;
        else{
            array[++counter] = array[counter-1];
            if(counter == 1)
                array[0] = element;
            else{
            for(int i=counter-1;i>=0;i--){
                if(element < array[i])
                    array[i+1] = array[i];
                else {array[i+1] = element;break; }
            
         }
         if(array[0]>element) array[0] = element;
        }
     }
    }
    void display(){
        for(int i=0;i<=counter;i++)
            System.out.print(array[i]+" ");
        System.out.println();
    } 
    
}