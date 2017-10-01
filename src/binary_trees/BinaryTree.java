package binary_trees;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BinaryTree<T> {

    private Queue<Node<T>> nodes = new LinkedBlockingQueue<>();
    private int size;
    private Node<T> root;

    public void add(T value){
        if (value == null) return;
        Node<T> node = new Node<>(value);
        nodes.add(node);
        size++;
        if (root == null) {
            root = node;
            System.out.println("root: " + root);
            return;
        }
        Node<T> currNode = nodes.peek();
        if (currNode.getLeftChild() == null){
            currNode.setLeftChild(node);
        } else if (currNode.getRightChild() == null){
            currNode.setRightChild(node);
            nodes.poll();
        }
//        System.out.println("node to add: " + node + "; size: " + size);
//        System.out.println("currNode: " + currNode + "; size: " + size + "\n\n");
    }

    public int size(){
        return size;
    }

    public Node<T> getRoot() {
        return root;
    }
}
