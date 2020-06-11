import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graphs {
    private class Node{
        String label;
        Node(String label){
            this.label = label;
        }
        @Override
        public String toString(){
            return label;
        }
    }
    Map<String,Node> nodes = new HashMap<>();
    Map<Node,List<Node>> adjacencyList = new HashMap<>();    
    public void addNode(String label) {
        var new_node = new Node(label);
        nodes.putIfAbsent(label,new_node);
        adjacencyList.putIfAbsent(new_node, new ArrayList<>());
    }
    public void addEdge(String from, String to){
        var from_node = nodes.get(from);
        if(from_node == null)
            throw new IllegalArgumentException();
        var to_node = nodes.get(to);
        if(to_node == null)
            throw new IllegalArgumentException();
        adjacencyList.get(from_node).add(to_node);
    }
    public void print(){
        for(var source:adjacencyList.keySet()){
            var targets = adjacencyList.get(source);
            if(!targets.isEmpty())
                System.out.println(source+" is connected to "+targets);
        }
    }
	public void removeEdge(String from, String to) {
        var from_node = nodes.get(from);
        if(from_node == null)
            throw new IllegalArgumentException();
        var to_node = nodes.get(to);
        if(to_node == null)
            throw new IllegalArgumentException();
        //Now see if they are having a Edge
        var check = adjacencyList.get(from_node).contains(to_node);//Check if the Node as any edge
        if(check)//If check is true then there is connection
            adjacencyList.get(from_node).remove(to_node);//Now we deleted the connection
        else //No connection is there
        System.out.println("No connection exists between"+from+" and "+to);
	}
	public void removeNode(String member) {
        //First check if the Node exists;
        if(!nodes.containsKey(member))
            throw new IllegalArgumentException();
        //Now we have confirmation that memeber exists.
        //1) Delete the Node(member) from the adjacencyList
        var member_address = nodes.get(member);
        adjacencyList.remove(member_address);
        //Now we should loop thorugh adjacencyList to find if any Node as any connection with our memeber
        for(var node:adjacencyList.keySet()){
            //We have all the Node & List<Connections>
            //Loop through List
            for(var connections:adjacencyList.get(node)){
                if(connections.label == member){//We only need this if List<> has member to delete
                    System.out.println(node.label+" is connected to: "+member);
                    adjacencyList.get(node).remove(member_address);
                    //We shouldn't delete element of List while looping through it
                    //Hence we break out of the loop
                    System.out.println("I am deleted");
                    break;
                }
            }
        }
        

	}      
}
