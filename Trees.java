public class Trees {
    public static void main(String[] args) {
        var tree = new TreeImplementation();
        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(6);
        tree.insert(12);
        tree.insert(3);
        tree.insert(8);
        tree.insert(28);
        //System.out.println(tree.checkIfTreeIsBST());
        //tree.KthNodeFromRoot(1);
        //tree.PreOrderTraversal();
        tree.NoRecursion_InOrderTraversal();

    }
}