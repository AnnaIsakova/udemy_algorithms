package binary_trees;

public class DepthFirstTraversal {

    public static void preOrder(Node root){
        if (root == null) return;

        System.out.print(root.getData() + " ");
        preOrder(root.getLeftChild());
        preOrder(root.getRightChild());
    }

    public static void inOrder(Node root){
        if (root == null) return;

        inOrder(root.getLeftChild());
        System.out.print(root.getData() + " ");
        inOrder(root.getRightChild());
    }

    public static void postOrder(Node root){
        if (root == null) return;

        postOrder(root.getLeftChild());
        postOrder(root.getRightChild());
        System.out.print(root.getData() + " ");
    }
}
