import java.util.*;

public class Graphs {

    private final Map<String, Node> nodes;
    private final Map<Node, List<Node>> neighbours;

    Graphs() {
        nodes = new HashMap<>();
        neighbours = new HashMap<>();
    }

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

    public void addNode(String label) {
        var newNode = new Node(label);
        nodes.putIfAbsent(label, newNode);
        neighbours.putIfAbsent(newNode, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        var fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException("Node(" + from + ") doesn't exist");
        var toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException("Node(" + to + ") doesn't exist");
        neighbours.get(fromNode).add(toNode);
    }

    public void print() {
        for (var source : neighbours.keySet()) {
            var targets = neighbours.get(source);
            if (targets.isEmpty())
                System.out.println(source + " has NO Connections");
            else
                System.out.println(source + " -> " + targets);
        }
    }

    public void removeEdge(String from, String to) {
        var from_node = nodes.get(from);
        if (from_node == null)
            throw new IllegalArgumentException();
        var to_node = nodes.get(to);
        if (to_node == null)
            throw new IllegalArgumentException();
        // Now see if they are having a Edge
        var hasEdge = neighbours.get(from_node).contains(to_node);// Check if the Node as any edge
        if (hasEdge)// If check is true then there is connection
            neighbours.get(from_node).remove(to_node);// Now we deleted the connection
        else // No connection is there
            System.out.println("No connection exists between " + from + " and " + to);
    }

    public void removeNode(String member) {
        // First check if the Node exists;
        if (!nodes.containsKey(member))
            throw new IllegalArgumentException();
        var nodeToDelete = nodes.get(member);
        // Delete all the incoming connections
        for (var node : neighbours.keySet()) {
            var connections = neighbours.get(node);
            if (connections.contains(nodeToDelete)) {
                connections.remove(nodeToDelete);
            }
        }
        // Remove from list table
        neighbours.remove(nodeToDelete);
    }

    public void traverseDFS(String startNode) {
        var node_address = nodes.get(startNode);
        if (node_address != null)
            traverseDFS(nodes.get(startNode), new HashSet<String>());
    }

    private void traverseDFS(Node node, HashSet<String> visited) {
        System.out.println(node.label);
        var connections = neighbours.get(node);
        visited.add(node.label);// Even if the string exists it doesn't return exception
        for (var connection : connections) {
            // Check if connection is visited
            var isVisited = visited.contains(connection.label);
            if (!isVisited)
                traverseDFS(connection, visited);// Now start recursing with the Node
        }
    }

    public void traverseBFS(String node) {
        var node_address = nodes.get(node);
        if (node_address == null)
            return;
        var visited = new HashSet<String>();
        visited.add(node);
        var queue = new ArrayDeque<Node>();
        queue.add(node_address);
        while (!queue.isEmpty()) {
            var current_node = queue.poll();
            System.out.println(current_node.label);
            // Get connections of current_node
            for (var connection : neighbours.get(current_node)) {
                var notVisited = visited.add(connection.label);
                if (notVisited) {
                    // Now add it stack
                    queue.add(connection);
                }

            }
        }
    }

    public void topologicalSort() {
        Stack<Node> stack = new Stack<>();
        HashSet<Node> visitedNodes = new HashSet<>();
        for (var node : nodes.values())
            topologicalSort(node, stack, visitedNodes);

        System.out.println(stack);
        System.out.println(visitedNodes);
    }

    private void topologicalSort(Node node, Stack<Node> stack, HashSet<Node> visitedNodes) {

        if (visitedNodes.contains(node))
            return;
        visitedNodes.add(node);
        for (var connection : neighbours.get(node))
            topologicalSort(connection, stack, visitedNodes);

        stack.push(node);
    }

    public boolean hasCycle() {
        var allNodes = new HashSet<Node>();
        allNodes.addAll(nodes.values());
        var visiting = new HashSet<Node>();
        var visited = new HashSet<Node>();
        while (!allNodes.isEmpty()) {
            var current = allNodes.iterator().next();
            if (hasCycle(current, allNodes, visiting, visited))
                return true;
        }
        return false;
    }

    private boolean hasCycle(Node current, HashSet<Node> allNodes, HashSet<Node> visiting, HashSet<Node> visited) {
        allNodes.remove(current);
        visiting.add(current);
        for (var neighbour : neighbours.get(current)) {
            if (visited.contains(neighbour))
                continue;
            if (visiting.contains(current))
                return true;
            if (hasCycle(neighbour, allNodes, visiting, visited))
                ;
            return true;
        }
        visiting.remove(current);
        visited.add(current);
        return false;
    }

    public boolean pathExists(String start, String destination) {
        var startNode = nodes.get(start);
        var destinationNode = nodes.get(destination);
        if (startNode == null || destinationNode == null)
            throw new IllegalArgumentException();

        var visited = new HashSet<String>();
        var queue = new ArrayDeque<Node>();
        queue.add(startNode);
        while (!queue.isEmpty()) {
            var current = queue.poll();
            var connections = neighbours.get(current);
            for (var connection : connections) {
                if (connection == destinationNode) {
                    return true;
                }
                if (visited.add(connection.label)) {
                    queue.add(connection);
                }
            }
        }
        return false;
    }

}
