public class AVLTrees {
    private class AVLNode{
        int data;
        AVLNode leftChild;
        AVLNode rightChild;
        AVLNode(int data){
            this.data = data;
        }
    }
    private AVLNode root;
	public void insert(int data){
        if(root == null){
            root = new AVLNode(data);
        }
        else{
            AVLNode temp = root;
            while(temp!=null){
                if(data > temp.data){
                    if(temp.rightChild == null){
                        temp.rightChild = new AVLNode(data);
                        break;
                    }
                    else temp = temp.rightChild;
                }
                else{
                    if(data < temp.data){
                        if(temp.leftChild == null){
                            temp.leftChild = new AVLNode(data);
                            break;
                        }
                        else temp = temp.leftChild;
                    }
                }
            }
        }
    }
    public void displayInorder(){
        displayInorder(root);
    }

    private void displayInorder(AVLNode root) {
        if(root == null) return;
        displayInorder(root.leftChild);
        System.out.println(root.data);
        displayInorder(root.rightChild);
    }
}