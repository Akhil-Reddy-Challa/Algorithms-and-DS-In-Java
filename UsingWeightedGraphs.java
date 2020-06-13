public class UsingWeightedGraphs {
    public static void main(String[] args) {
        WeightedGraphs graph = new WeightedGraphs();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
        graph.addEdge("A", "B", 3);
        graph.addEdge("B", "E", 1);
        graph.addEdge("C", "D", 1);
        graph.addEdge("E", "D", 5);
        graph.addEdge("A", "C", 4);
        graph.addEdge("A", "D", 2);
        graph.addEdge("D", "B", 6);
        graph.print();
    }
}