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
        if(balanceFactor < -1){
            //System.out.println("Right Hanging tree at: "+ root.data);
            //Now find the balance factor of right child
            //Using balance factor technique find root.rightChild's left & right node height difference
            int rightChildHeight_balanceFactor = height(root.rightChild.leftChild) - height(root.rightChild.rightChild);
            if(rightChildHeight_balanceFactor == -1){
                /* Example: Tree
                10
                    20
                        30
                */
                //Now balanceFactor of Node(20) == -1, hence Leftrotation(10) required
                //System.out.println("Left Rotation on "+root.data+" required");
                //Implementing the above
                //Insert root node as leftChild of root.rightChild
                var new_root = root.rightChild;
                new_root.leftChild = root;
                root.rightChild =null;
                root.height =0;
                /* Tree changed to:
                    20
                 10    30
                //Return rightChild as new root
                 */
                return new_root;
                //Height is already perfectly adjusted in this case
            }
            else{
                 /* Example: Tree
                10
                    30
                20
                */
                //Now balanceFactor of Node(20) == 1, hence rightRotate(30) &
                //Leftrotation(10) required
                //System.out.println("Right Rotation on "+root.rightChild.data+" required");
                //Implement Right Rotate;
                int temp = root.rightChild.data;//From above example storing 30 in temp
                //Now insert Node(20) as rightChild of root
                root.rightChild = root.rightChild.leftChild;//value insertion
                root.rightChild.height = 1;//default height would be 0 because it was leaf node before so setting it to 1
                /* Above 2 statements Graphical interpretation:
                From:  10
                           30
                        20
                To: 
                    10
                        20
                */
                //Now we should append temp i.e 30 to node(20)
                root.rightChild.rightChild = new AVLNode(temp);
                //Above statement appends 30 to the end

                //Now tree is as below 
                /* Example: Tree
                10
                    20
                        30
                */     
                //System.out.println("Left Rotation on "+root.data+" required");
                //Now again implement same left rotation logic from the above if clause
                root.rightChild.leftChild = new AVLNode(root.data);
                return root.rightChild;                                        

            }
        }
        else if(balanceFactor>1){
            //Same implementation logic as the above
            //System.out.println("Left hanging tree at: " + root.data);
            int leftChildHeight_balanceFactor = height(root.leftChild.leftChild) - height(root.leftChild.rightChild);
            if(leftChildHeight_balanceFactor == 1){
                //System.out.println("Right Rotation on "+root.data+" required");
                var new_root = root.leftChild;
                new_root.rightChild = root;
                root.leftChild =null;
                root.height =0;                
                return new_root;
            }
            else{
                //System.out.println("Left Rotation on "+root.leftChild.data+" required");
                int temp = root.leftChild.data;
                root.leftChild = root.leftChild.rightChild;
                root.leftChild.height = 1;
                root.leftChild.leftChild = new AVLNode(temp);
                //System.out.println("Right Rotation on "+root.data+" required");
                root.leftChild.rightChild = new AVLNode(root.data);
                return root.leftChild;
            }
        }
        //else System.out.println("----Balanced Tree");
                
        
        return root;
    }
    private int height(AVLNode root) {
        return root == null ? -1: root.height;
    }

}