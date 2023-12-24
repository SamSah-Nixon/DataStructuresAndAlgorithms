public class Main {
    public static void main(String[] args){
        AVLTree<Integer> tree = new AVLTree<Integer>();
        tree.insert(2);
        System.out.println(tree);
        tree.insert(1);
        System.out.println(tree);
        tree.insert(3);
        System.out.println(tree);
        tree.insert(4);
        System.out.println(tree);
        tree.insert(5);
        System.out.println(tree);
    }
}
