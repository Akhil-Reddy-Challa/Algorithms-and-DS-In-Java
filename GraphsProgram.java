public class GraphsProgram {
    public static void main(String[] args) {
        Graphs graph = new Graphs();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");
        //graph.print();
        //graph.removeEdge("A","C");
        //System.out.println();
        graph.print();
        graph.removeNode("A");
        graph.print();
        graph.removeNode("C");
        graph.print();
    }
}