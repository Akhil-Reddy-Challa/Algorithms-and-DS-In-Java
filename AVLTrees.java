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
        System.out.print("[");
        displayInorder(root);
        System.out.println("]");
    }
    private void displayInorder(AVLNode root) {
        if(root == null) return;
        displayInorder(root.leftChild);
        //System.out.print("Data: "+root.data + " Height: "+root.height + " , ");
        System.out.print(root.data+" : "+root.height+" ,");
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
        balanceFactor();
        return root;
    }
    private void balanceFactor() {
        int leftTreeHeight = height(root.leftChild);
        int rightTreeHeight = height(root.rightChild);
        int difference_of_height = leftTreeHeight - rightTreeHeight;
        if(difference_of_height>1)
            System.out.println("Left hanging tree");
        else if(difference_of_height < -1)
            System.out.println("Right Hanging tree");
        else
            System.out.println("Perfectly balanced tree");
        displayInorder();
    }

    private int height(AVLNode root) {
        return root == null ? -1: root.height;
    }
}