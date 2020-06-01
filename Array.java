public class Array {
    int[] values=new int[1000];
    int tracker=-1;
    Array(int number){
        //Do Nothing
    }
	public void insert(int array_value_to_insert) {
        values[++tracker]=array_value_to_insert;
        
	}

	public void print() {
        for(int i=0;i<=tracker;i++)
            System.out.println(values[i]);
	}

	public void removeAt(int indexToRemove) {
        //Search if index is valid or not
        if(indexToRemove<=tracker){
            if(indexToRemove == tracker)
                tracker--;

            else{
                for(int i=indexToRemove;i<tracker;i++){
                    int temp=values[i];
                    values[i]=values[i+1];
                    values[i+1]=temp;
                }
                tracker--;
            }
        }
	}

	public void lengthOfArray() {
        System.out.println("Length of array is "+(tracker+1));
	}
	public int indexof(int arrayElementToFind) {
        for(int i=0;i<=tracker;i++)
        {
            if(values[i]== arrayElementToFind)
                return i;
        }
        return -1;
	}
    
}