public class UsingWeightedGraphs {
    public static void main(String[] args) {
        WeightedGraphs graph = new WeightedGraphs();
        graph.addNode("City-A");
        graph.addNode("City-B");
        graph.addEdge("City-A", "City-B", 3);
        graph.print();
    }
}