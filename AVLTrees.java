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
        System.out.println(root.data + " Height: "+root.height);
        displayInorder(root.rightChild);
    }
	public void insertWithRecursion(int data) {
        root = insertWithRecursion(root,data);
    }
    private AVLNode insertWithRecursion(AVLNode root, int data) {
        if(root == null)
            return new AVLNode(data);
        if(data > root.data)
            root.rightChild = insertWithRecursion(root.rightChild, data);
        else if(data < root.data)
            root.leftChild = insertWithRecursion(root.leftChild, data);
        
        root.height = Math.max(height(root.leftChild),height(root.rightChild)) + 1;
        return root;
    }

    private int height(AVLNode root) {
        return root == null ? 0: root.height;
    }
}