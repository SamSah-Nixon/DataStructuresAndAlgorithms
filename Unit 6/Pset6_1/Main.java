public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(-2);
        
        tree.insert(44);
        
        tree.insert(100);
        tree.insert(29);
        tree.insert(84);
        tree.insert(9);
        
        tree.delete(100);
        
        tree.insert(7);
        tree.insert(10);
        tree.insert(8);
        tree.insert(20);
        
        tree.delete(29);
        tree.delete(84);
        tree.insert(45);
        tree.insert(68);
        tree.insert(-3);
        tree.delete(-2);
        tree.delete(68);
        tree.insert(94);
        System.out.println(tree.toString());

        
    }
}