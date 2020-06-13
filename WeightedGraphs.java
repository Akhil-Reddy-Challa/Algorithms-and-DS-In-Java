import java.util.*;

public class WeightedGraphs {
    private class Node {
        String label;

        Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
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
        var new_node = new Node(label);
        nodes.putIfAbsent(label, new_node);
        adjacencyList.putIfAbsent(new_node, new ArrayList<>());
    }

    public void addEdge(String from, String to, int weight) {
        var from_node = nodes.get(from);
        if (from_node == null)
            throw new IllegalArgumentException();
        var to_node = nodes.get(to);
        if (to_node == null)
            throw new IllegalArgumentException();
        adjacencyList.get(from_node).add(new Edge(from_node, to_node, weight));
        adjacencyList.get(to_node).add(new Edge(to_node, from_node, weight));
    }

    public void print() {
        for (var source : adjacencyList.keySet()) {
            var targets = adjacencyList.get(source);
            if (!targets.isEmpty())
                System.out.println(source + " is connected to " + targets);
            else
                System.out.println(source + " has NO Connections");
        }
    }
}