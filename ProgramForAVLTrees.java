public class ProgramForAVLTrees {
    public static void main(String[] args) {
        AVLTrees avl = new AVLTrees();
        //(5, 10, 3, 12, 15, 14
        avl.insert(15);
        avl.insert(12);
        avl.insert(16);
        avl.insert(13);
        avl.insert(10);
        avl.insert(11);
        avl.displayInorder();
        

    }
}