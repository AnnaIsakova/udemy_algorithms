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

    public Node<Integer> getRoot() {
        return root;
    }
}