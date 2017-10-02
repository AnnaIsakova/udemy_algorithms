package binary_trees;


import stacks_queues.exceptions.QueueUnderflowException;


public class Test {

    public static void main(String[] args) throws QueueUnderflowException {
//        testBinaryTree();
//        testBinarySearchTree();
        System.out.println(possibleNumOfTrees(3));
    }

    static void testBinaryTree() throws QueueUnderflowException {
        BinaryTree<Integer> tree10 = new BinaryTree<>();
        for (int i = 0; i < 10; i++) {
            tree10.add(i);
        }
        System.out.println("tree size: " + tree10.size());
        System.out.print("breadth-first: ");
        BreadthFirstTraversal.breadthFirst(tree10.getRoot()); //0 1 2 3 4 5 6 7 8 9
        System.out.print("depth-first pre-order: ");
        DepthFirstTraversal.preOrder(tree10.getRoot()); //0 1 3 7 8 4 9 2 5 6
        System.out.println();
        System.out.print("depth-first in-order: ");
        DepthFirstTraversal.inOrder(tree10.getRoot()); //7 3 8 1 9 4 0 5 2 6
        System.out.println();
        System.out.print("depth-first post-order: ");
        DepthFirstTraversal.postOrder(tree10.getRoot()); //7 8 3 9 4 1 5 6 2 0
        System.out.println();



        //breadth-first traversal using queues implemented in this course
        //throws QueueOverflowException if queue.MAX_SIZE < tree.size / 2
        BinaryTree<Integer> tree80 = new BinaryTree<>();
        for (int i = 0; i < 80; i++) {
            tree80.add(i);
        }
        System.out.println("tree size: " + tree80.size());
        System.out.print("breadth-first: ");
        BreadthFirstTraversal.breadthFirst(tree80.getRoot());


        BinaryTree<Integer> tree81 = new BinaryTree<>();
        for (int i = 0; i < 81; i++) {
            tree81.add(i);
        }
        System.out.println("tree size: " + tree81.size());
        System.out.print("breadth-first: ");
        BreadthFirstTraversal.breadthFirst(tree81.getRoot());
    }

    public static void testBinarySearchTree() throws QueueUnderflowException {
        BinarySearchTree tree10 = new BinarySearchTree();
        for (int i = 0; i < 10; i++) {
            if (i == 0){
                tree10.add(25);
            } else if (i % 3 == 0){
                tree10.add(i);
            } else if (i % 2 == 0){
                tree10.add(i*10);
            } else {
                tree10.add(i+5);
            }
        }
        System.out.print("breadth-first: ");
        BreadthFirstTraversal.breadthFirst(tree10.getRoot()); //25 6 40 3 20 80 6 10 9 12
        System.out.println(tree10.get(66));
        System.out.println("minimum: " + tree10.findMinimum());
        System.out.println("depth: " + tree10.findDepth());
        tree10.mirror();
        System.out.print("breadth-first after mirror: ");
        BreadthFirstTraversal.breadthFirst(tree10.getRoot());
    }

    static int possibleNumOfTrees(int nodes){
        if (nodes <= 1){
            return 1;
        }

        int sum = 0;
        for (int i = 1; i <= nodes; i++) {
            int countLeft = possibleNumOfTrees(i - 1);
            int countRight = possibleNumOfTrees(nodes - i);

            sum = sum + (countLeft * countRight);
        }
        return sum;
    }
}
