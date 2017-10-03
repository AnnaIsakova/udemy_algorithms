package binary_trees;


public class BinaryTrees {

    public static boolean isBinarySearchTree(BinaryTree tree){
        return isBinarySearchTree(tree.getRoot());
    }

    public static boolean isBinarySearchTree(BinarySearchTree tree){
        return isBinarySearchTree(tree.getRoot());
    }

    private static boolean isBinarySearchTree(Node<Integer> root){

        boolean isLeft = true;
        boolean isRight = true;

        if (root.getLeftChild() != null){
            if (root.getLeftChild().getData() > root.getData()) isLeft = false;
            isBinarySearchTree(root.getLeftChild());
        }

        if (root.getRightChild() != null){
            if (root.getRightChild().getData() < root.getData()) isRight = false;
            isBinarySearchTree(root.getRightChild());
        }

        return isLeft && isRight;
    }
}
