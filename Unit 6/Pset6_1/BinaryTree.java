import java.util.ArrayDeque;

/*
 * Sam Sah-Nixon
 * Created: 3/30/23
 * Last Modified: 4/11/23
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
    public boolean breathFirstSearch(E item){
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
     * Deletes a node from the tree
     * @param data The value to delete
     * @return true if the node is deleted, false otherwise
     */
    public boolean delete(E data){
        if(!isEmpty()){
            size--;
            ArrayDeque<TreeNode<E>> deque = new ArrayDeque<TreeNode<E>>();
            TreeNode<E> current;
            deque.addLast(root);
            //Search for the node to delete
            while(!deque.isEmpty()){
                current = deque.removeFirst();
                //If the node to delete is found
                if(current.data == data){
                    //If the node to delete is a leaf
                    if(current.rightChild == null && current.leftChild == null){
                        if(current.parent.rightChild == current)
                            current.parent.rightChild = null;
                        else
                            current.parent.leftChild = null;
                        current.parent = null;
                        return true;
                    }
                    TreeNode<E> toDelete = current;
                    //Clear deque
                    deque.clear();
                    deque.addLast(root);
                    //Find the deepest right most node
                    while(!deque.isEmpty()){
                        current = deque.removeFirst();
                        if(current.leftChild != null)
                            deque.addLast(current.leftChild);
                        if(current.rightChild != null)
                            deque.addLast(current.rightChild);
                    }
                    toDelete.data = current.data;
                    //Sever ties
                    if(current.parent.rightChild != null)
                        current.parent.rightChild = null;
                    else
                        current.parent.leftChild = null;
                    current.parent = null;
                    return true;
                }
                //Continue looking for the node to delete
                if(current.leftChild != null)
                    deque.addLast(current.leftChild);
                if(current.rightChild != null)
                    deque.addLast(current.rightChild);
                }
            }
        return false;
    }

    /**
     * Gets the size of the tree
     * @return the size of the tree
     */
    public int getSize(){
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
                string+="(null, "+current.data+"), ";
            else
                string += "("+current.parent.data+", "+current.data+"), ";
            if(current.leftChild != null)
                deque.addLast(current.leftChild);
            if(current.rightChild != null)
                deque.addLast(current.rightChild);
        }
        return string.substring(0, string.length()-1)+"]";
    }

    //Node class
    private class TreeNode<E>{
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