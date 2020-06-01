public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] container = {1,8,6,2,5,4,8,3,7};
        int start=0,end=container.length-1;int count=end+1;
         int smallest_wall;
         int highest_capacity=0;int calculate;
    //     while(start<count){
    //         end = start+1;
    //     while(end<count){
    //         smallest_wall = container[start]<container[end] ? container[start] : container[end];
    //         calculate = smallest_wall*(end-start);
    //         //System.out.println("Start: "+start+" End: "+end+" Calculate is: "+calculate);
            
    //         if(highest_capacity < calculate) 
    //             highest_capacity = calculate;
    //         //System.out.println("Storage capacity: "+calculate+" Litres");
    //         end++;
    //     }
    //     start++;
    //     }
    // System.out.println("highest capacity: "+highest_capacity);

//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Second-Faster Approach
        while(start<end){
            smallest_wall = container[start]<container[end] ? container[start] : container[end];
            calculate = smallest_wall*(end-start);
            if(highest_capacity < calculate) 
                 highest_capacity = calculate;
            if(container[start]<container[end]) start++;
            else end--;
        }
        System.out.println("highest capacity: "+highest_capacity);
    
    }
}