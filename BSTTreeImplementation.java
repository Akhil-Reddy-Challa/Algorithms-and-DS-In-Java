public class BSTTreeImplementation {
    private class Node {
        private int data;
        private Node left;
        private Node right;
        Node(int data){
            this.data = data;
        }
    }
    public Node root;
	public void insert(int value) {
        var new_node = new Node(value);
        if(root == null) root = new_node;
        else{
            var temp = root;
            while(temp!=null){
                if(value > temp.data){
                    if(temp.right == null) {temp.right = new_node;break;}
                    else temp = temp.right;
                }
                else if(value < temp.data){
                    if(temp.left == null) {temp.left = new_node;break;}
                    else temp = temp.left;
                }
            }
        }
    }
    public void displayTreePreorder(Node temp){
        if(temp == null)
         return;
         System.out.println(temp.data);
         displayTreePreorder(temp.left);
         displayTreePreorder(temp.right);
    }
	public boolean findValue(int value,Node temp_root) {
        if(temp_root.data == value) return true;
        else if(value > temp_root.data && temp_root.right!=null) 
            return findValue(value,temp_root.right);
        else if(value < temp_root.data && temp_root.left!=null)
            return findValue(value,temp_root.left);
        return false;
	}
    public void DFS(){
        DFS(root);
        }
    private void DFS(Node root) {
        int height_of_tree = heightOfTree();
        int start = 0;
        while(start <= height_of_tree) KthNodeFromRoot(start++);
        }
    private boolean hasRightChild(Node temp_root) {
        if(temp_root.right == null) return false;
        return true;
    }
    private boolean hasLeftChild(Node temp_root) {
        if(temp_root.left == null) return false;
        return true;
    }
    public int heightOfTree(){
        return calculateHeight(root);
        //return Integer.max(leftSubTree_height,rightSubTree_height);
    }
    private int calculateHeight(Node temp_root) {
        if(temp_root == null)
            return -1;
        if(!hasLeftChild(temp_root) && !hasRightChild(temp_root))
            return 0;
        return 1+Math.max(calculateHeight(temp_root.left),calculateHeight(temp_root.right));
    }
	public boolean checkIfTreeIsBST() {
        return checkIfTreeIsBST(root);
	}
    private boolean checkIfTreeIsBST(Node temp_root) {
        //System.out.println(temp_root);
        if(temp_root == null)
            return false;
        if(isLeaf(temp_root))
            return true;
        //System.out.println("yo"+);
        if(temp_root.left.data < temp_root.data && temp_root.right.data > temp_root.data){
            //System.out.println("I am here");
            return checkIfTreeIsBST(temp_root.left) && checkIfTreeIsBST(temp_root.right);
        }
        return false;
    }
    private boolean isLeaf(Node temp_root) {
        //System.out.println("I am called");
        return temp_root.left == null && temp_root.right == null;
    }
	public void KthNodeFromRoot(int k) {
        KthNodeFromRoot(root,k);
	}
    private void KthNodeFromRoot(Node root, int k) {
        if(k == 0)
            System.out.print(root.data+" ");
        if(hasLeftChild(root)) KthNodeFromRoot(root.left, k-1);
        if(hasRightChild(root)) KthNodeFromRoot(root.right, k-1);
    }
	public void PreOrderTraversal() {
        PreOrderTraversal(root);
    }
    private void PreOrderTraversal(Node root) {
        if(root == null) return;
        System.out.println(root.data);
        PreOrderTraversal(root.left);
        PreOrderTraversal(root.right);
    }
    public void NoRecursion_InOrderTraversal(){
        NoRecursion_InOrderTraversal(root);
    }
    private void NoRecursion_InOrderTraversal(Node root) {
        while(root!=null){
            var temp = root;
            while(temp.left != null){
                temp = temp.left;
            }
            System.out.println(temp.data);
            while(temp.right != null){
                temp = temp.right;
            }
            System.out.println(temp.data);
            root = root.right;
        }
    }
}