import java.util.*;

public class WeightedGraphs {
    private class Node {
        String label;
        private List<Edge> edges = new ArrayList<>();
        Node(String label) {
            this.label = label;
        }
        @Override
        public String toString() {
            return label;
        }
        public void addEdge(Node to,int weight){
            edges.add(new Edge(this, to, weight));
        }

        public List<Edge> getEdges() {
            return edges;
        }
    }

    private class Edge {
        private Node from;
        private Node to;
        private int weight;

        Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + " -> " + to;
        }
    }
    Map<String, Node> nodes = new HashMap<>();
    Map<Node, List<Edge>> adjacencyList = new HashMap<>();
    public void addNode(String label) {
        //var new_node = new Node(label);
        nodes.putIfAbsent(label, new Node(label));
        //adjacencyList.putIfAbsent(new_node, new ArrayList<>());
    }

    public void addEdge(String from, String to, int weight) {
        var from_node = nodes.get(from);
        if (from_node == null)
            throw new IllegalArgumentException();
        var to_node = nodes.get(to);
        if (to_node == null)
            throw new IllegalArgumentException();
        
        from_node.addEdge(to_node, weight);
        to_node.addEdge(from_node, weight);
    }

    public void print() {
        for (var node : nodes.values()) {
            var edges = node.getEdges();
                System.out.println(node + " Connections are: " + edges);
         }
    }
}