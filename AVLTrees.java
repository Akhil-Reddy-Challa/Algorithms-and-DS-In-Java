public class AVLTrees {
    private class AVLNode{
        int data;
        AVLNode leftChild;
        AVLNode rightChild;
        int height;
        AVLNode(int data){
            this.data = data;
        }
    }
    private AVLNode root;
    public void displayInorder(){
        displayInorder(root);
    }
    private void displayInorder(AVLNode root) {
        if(root == null) return;
        displayInorder(root.leftChild);
        System.out.print(root.data + ":"+root.height + " ");
        displayInorder(root.rightChild);
    }
	public void insert(int data) {
        root = insert(root,data);
    }
    private AVLNode insert(AVLNode root, int data) {
        if(root == null)
            return new AVLNode(data);
        if(data > root.data)
            root.rightChild = insert(root.rightChild, data);
        else if(data < root.data)
            root.leftChild = insert(root.leftChild, data);
        
        root.height = Math.max(height(root.leftChild),height(root.rightChild)) + 1;
        /// Below is for balancing Tree
        var balanceFactor = height(root.leftChild) - height(root.rightChild);
        if(balanceFactor>1)
            System.out.println("Left hanging tree at: " + root.data);
        else if(balanceFactor < -1)
            System.out.println("Right Hanging tree at: "+ root.data);
        return root;
    }
    private int height(AVLNode root) {
        return root == null ? -1: root.height;
    }

}