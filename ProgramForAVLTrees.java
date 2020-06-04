public class ProgramForAVLTrees {
    public static void main(String[] args) {
        AVLTrees avl = new AVLTrees();
        //avl.insert(12);
        avl.insertWithRecursion(12);
        avl.insertWithRecursion(2);
        avl.insertWithRecursion(20);
        avl.displayInorder();
        ///Implement Height checker feature
        // Introduce new Integer height in AVLNode class and store height
        // as you insert elements;
    }
}