public class GraphsProgram {
    public static void main(String[] args) {
        Graphs graph = new Graphs();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("D", "C");
        graph.print();
        graph.traverseDFS("mA");
    }
}