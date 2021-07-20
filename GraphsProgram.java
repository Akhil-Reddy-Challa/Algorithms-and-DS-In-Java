public class GraphsProgram {
    public static void main(String[] args) {
        Graphs graph = new Graphs();
        graph.addNode("D");
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");

        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("D", "A");
        graph.addEdge("D", "B");
        graph.addEdge("A", "D");
        graph.addEdge("C", "D");

        // graph.print();
        // Find if path exists
        System.out.println(graph.pathExists("A", "C"));

    }
}