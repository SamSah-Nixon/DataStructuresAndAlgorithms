import java.util.ArrayDeque;

/*
 * Sam Sah-Nixon
 * Created: 3/30/23
 * Last Modified: 4/4/23
 * A Binary Tree with a breadth first search and depth first search
 */
public class BinaryTree<E extends Comparable<? super E>> {

    private TreeNode<E> root;
    private int size;

    public BinaryTree(){
        root = null;
        size = 0;
    }

    /**
     * A breadth first search of the tree
     * @param item The item to search for
     * @return true if the item is found, false otherwise
     */
    public boolean breadthFirstSearch(E item){
        ArrayDeque<TreeNode<E>> deque = new ArrayDeque<TreeNode<E>>();
        TreeNode<E> current;
        deque.addLast(root);
        while(!deque.isEmpty()){
            current = deque.removeFirst();
            if(current.data == item)
                return true;
            if(current.leftChild != null)
                deque.addLast(current.leftChild);
            if(current.rightChild != null)
                deque.addLast(current.rightChild);
        }
        return false;
    }

    /**
     * A depth first search of the tree
     * Recursively searches the tree in the order specified
     * @param item The item to search for
     * @param order The order to search in (1 = preorder, 2 = inorder, 3 = postorder)
     * @return true if the item is found, false otherwise
     */
    public boolean depthFirstSearch(E item, int order){
        return switch (order) {
            case 1 -> preorderSearch(root, item);
            case 2 -> inorderSearch(root, item);
            case 3 -> postorderSearch(root, item);
            default -> false;
        };
    }

    //Postorder depth first search
    public boolean postorderSearch(TreeNode<E> node, E item) {
        if(node != null){
            if(postorderSearch(node.leftChild, item))
                return true;
            if(postorderSearch(node.rightChild, item))
                return true;
            if(node.data == item)
                return true;
        }
        return false;
    }
    //Inorder depth first search
    public boolean inorderSearch(TreeNode<E> node, E item) {
        if(node != null){
            if(inorderSearch(node.leftChild, item))
                return true;
            if(node.data == item)
                return true;
            if(inorderSearch(node.rightChild, item))
                return true;
        }
        return false;
    }

    //Preorder depth first search
    public boolean preorderSearch(TreeNode<E> node, E item) {
        if(node != null){
            if(node.data == item)
                return true;
            if(preorderSearch(node.leftChild, item))
                return true;
            if(preorderSearch(node.rightChild, item))
                return true;
        }
        return false;
    }

    //Insert
    public void insert(E data){
        //If there is no tree create the root
        if (isEmpty())
            root = new TreeNode<E>(data);
        else{
            //Uses a deque to keep track of the next nodes to check for empty children
            ArrayDeque<TreeNode<E>> deque = new ArrayDeque<TreeNode<E>>();
            TreeNode<E> current;
            deque.addLast(root);
            //While there are still nodes that haven't been checked
            while(!deque.isEmpty()){
                current = deque.removeFirst();
                //If current has no left child create left child
                if(current.leftChild == null){
                    current.leftChild = new TreeNode<E>(data, current);
                    break;
                }
                //If current has no right child create right child
                else if(current.rightChild == null){
                    current.rightChild = new TreeNode<E>(data, current);
                    break;
                }
                //If no empty spaces to put new node add children to deque
                else{
                    deque.addLast(current.leftChild);
                    deque.addLast(current.rightChild);
                }
            }
        }
        size++;
    }

    /**
     * Gets the size of the tree
     * @return the size of the tree
     */
    public int size(){
        return size;
    }

    /**
     * Checks if the tree is empty
     * @return true if the tree is empty, false otherwise
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * Returns the tree in a readable string format. Shows the parent and then children of each node
     * @return the string of the tree
     */
    public String toString(){
        if(root == null)
            return "[]";
        ArrayDeque<TreeNode<E>> deque = new ArrayDeque<TreeNode<E>>();
        TreeNode<E> current;
        String string = "[";
        deque.addLast(root);
        while(!deque.isEmpty()){
            current = deque.removeFirst();
            if(current.parent == null)
                string+="(null, "+current.data+")";
            else
                string += ", ("+current.parent.data+", "+current.data+")";
            if(current.leftChild != null)
                deque.addLast(current.leftChild);
            if(current.rightChild != null)
                deque.addLast(current.rightChild);
        }
        return string+"]";
    }


    //Node class
    private class TreeNode<T extends Comparable<? super T>>{
        private T data;
        private TreeNode<T> parent;
        private TreeNode<T> leftChild;
        private TreeNode<T> rightChild;

        public TreeNode(T data){
            this.data = data;
            this.parent = null;
            leftChild = null;
            rightChild = null;
        }
        public TreeNode(T data, TreeNode<T> parent){
            this.data = data;
            this.parent = parent;
            leftChild = null;
            rightChild = null;
        }
    }
}