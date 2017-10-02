package binary_trees;

public class BinarySearchTree {

    private Node<Integer> root;

    public void add(Integer value){
        if (value == null) return;
        Node<Integer> node = new Node<>(value);
        if (root == null){
            root = node;
            return;
        }

        insert(root, node);
    }

    private Node<Integer> insert(Node<Integer> root, Node<Integer> nodeToInsert){
        if (root == null) return nodeToInsert;
        if (root.getData() >= nodeToInsert.getData()){
            root.setLeftChild(insert(root.getLeftChild(), nodeToInsert));
        } else {
            root.setRightChild(insert(root.getRightChild(), nodeToInsert));
        }
        return root;
    }

    public Integer get(Integer value){
        Node<Integer> node = lookup(root, value);
        if (node == null) return null;
        return node.getData();
    }

    private Node<Integer> lookup(Node<Integer> root, Integer value){
        Node<Integer> result = null;
        if (root == null) return null;
        System.out.println("Visiting node: " + root.getData());
        if (root.getData() > value){
            result = lookup(root.getLeftChild(), value);
        } else if (root.getData() < value){
            result = lookup(root.getRightChild(), value);
        } else {
            result = root;
            return result;
        }
        return result;
    }

    public Integer findMinimum(){
        Node<Integer> min = getMin(root);
        return min.getData();
    }

    private Node<Integer> getMin(Node<Integer> root){
        if (root.getLeftChild() == null) return root;
        return getMin(root.getLeftChild());
    }

    public int findDepth(){
        return calcDepth(root);
    }

    private int calcDepth(Node<Integer> root){
        if (root == null) return 0;
        if (root.getLeftChild() == null && root.getRightChild() == null) return 0;

        int leftDepth = 1 + calcDepth(root.getLeftChild());
        int rightDepth = 1 + calcDepth(root.getRightChild());

        return Math.max(leftDepth, rightDepth);
    }

    public void mirror(){
        mirror(root);
    }

    private void mirror(Node<Integer> root){
        if (root == null) return;
        Node<Integer> temp = root.getLeftChild();
        root.setLeftChild(root.getRightChild());
        root.setRightChild(temp);
        mirror(root.getLeftChild());
        mirror(root.getRightChild());
    }

    public Node<Integer> getRoot() {
        return root;
    }
}
