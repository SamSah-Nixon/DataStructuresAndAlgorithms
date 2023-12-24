import java.util.ArrayDeque;

public class BinaryTree<E extends Comparable<? super E>>{

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


    /**
     * Inserts item to tree
     * @param item item to insert
     */
    public void insert(E item){
        size++;
        if(isEmpty()){
            root = new TreeNode<E>(item);
            return;
        }
        TreeNode<E> current = root;
        while(true){
            if(item.compareTo(current.data) <= 0){
                if(current.leftChild == null){
                    current.leftChild = new TreeNode<E>(item, current);
                    return;
                }
                current = current.leftChild;
            }
            else{
                if(current.rightChild == null){
                    current.rightChild = new TreeNode<E>(item, current);
                    return;
                }
                current = current.rightChild;
            }
        }
    }

    /**
     * Deletes item from tree
     * @param item item to delete
     */
    public void delete(E item){
        TreeNode<E> current = root;
        while(current != null){
            if(item.compareTo(current.data) == 0){
                size--;
                //Leaf - No Children
                if(current.leftChild == null && current.rightChild == null)
                    current = null;
                //Only Right Child - One Child
                else if(current.leftChild == null){
                    if(current.parent.leftChild == current)
                        current.parent.leftChild = current.rightChild;
                    else
                        current.parent.rightChild = current.rightChild;
                    current.rightChild.parent = current.parent;
                    //Sever ties
                    current.parent = null;
                    current.rightChild = null;
                }
                //Only Left Child - One Child
                else if(current.rightChild == null){
                    if(current.parent.leftChild == current)
                        current.parent.leftChild = current.leftChild;
                    else
                        current.parent.rightChild = current.leftChild;
                    current.leftChild.parent = current.parent;
                    //Sever ties
                    current.parent = null;
                    current.leftChild = null;
                }
                //Two Children
                else{
                    TreeNode<E> smallest = current.rightChild;
                    //Find smallest on right side
                    while(smallest.leftChild != null)
                        smallest = smallest.leftChild;
                    current.data = smallest.data;
                    //Sever ties
                    if(smallest.parent.leftChild == smallest)
                        smallest.parent.leftChild = smallest.rightChild;
                    else
                        smallest.parent.rightChild = smallest.rightChild;
                    //If it has a right child, set its parent to current's parent
                    if(smallest.rightChild != null)
                        smallest.rightChild.parent = smallest.parent;
                }
                return;
            }
            if(item.compareTo(current.data) < 0)
                current = current.leftChild;
            else
                current = current.rightChild;
        }

    }

    /**
     * Finds item in tree
     * @param item item to find
     * @return true if item is in tree, false otherwise
     */
    public boolean find(E item){
        TreeNode<E> current = root;
        while(current != null){
            if(item.compareTo(current.data) == 0)
                return true;
            if(item.compareTo(current.data) < 0)
                current = current.leftChild;
            else
                current = current.rightChild;
        }
        return false;
    }

    /**
     * Checks if tree is empty
     * @return true if tree is empty, false otherwise
     */
    public boolean isEmpty(){
        return root == null;
    }

    /**
     * Returns the size of tree
     * @return the size of tree
     */
    public int size(){
        return size;
    }

    /**
     * Returns a string representation of tree
     * @return a string representation of tree
     */
    public String toString(){
        if(root == null)
            return "[]";
        ArrayDeque<TreeNode<E>> deque = new ArrayDeque<TreeNode<E>>();
        TreeNode<E> current;
        StringBuilder string = new StringBuilder("[");
        deque.addLast(root);
        while(!deque.isEmpty()){
            current = deque.removeFirst();
            if(current.parent == null)
                string.append("(null, "+current.data+")");
            else
                string.append(", ("+current.parent.data+", "+current.data+")");
            if(current.leftChild != null)
                deque.addLast(current.leftChild);
            if(current.rightChild != null)
                deque.addLast(current.rightChild);
        }
        return string+"]";
    }

    private static class TreeNode<E>{
        private E data;
        private TreeNode<E> parent;
        private TreeNode<E> leftChild;
        private TreeNode<E> rightChild;

        public TreeNode(E data){
            this.data = data;
            this.parent = null;
            leftChild = null;
            rightChild = null;
        }
        public TreeNode(E data, TreeNode<E> parent){
            this.data = data;
            this.parent = parent;
            leftChild = null;
            rightChild = null;
        }
    }
}
