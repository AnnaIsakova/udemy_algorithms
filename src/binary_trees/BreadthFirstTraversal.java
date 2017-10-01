package binary_trees;


import stacks_queues.Queue;
import stacks_queues.exceptions.QueueOverflowException;
import stacks_queues.exceptions.QueueUnderflowException;

public class BreadthFirstTraversal {

    public static void breadthFirst(Node root) throws QueueUnderflowException {
        if (root == null) return;

        Queue<Node> queue = new Queue<>(Node.class);
        try {
            queue.enqueue(root);
        } catch (QueueOverflowException e) {
            System.out.println("root");
        }

        int index = 0;
        while (!queue.isEmpty()){
            index++;
            Node node = queue.dequeue();
            System.out.print(node.getData() + " ");
            if (node.getLeftChild() != null){
                try {
                    queue.enqueue(node.getLeftChild());
                } catch (QueueOverflowException e) {
                    System.out.print("\nException at: " + index);
                    break;
                }
            }

            if (node.getRightChild() != null){
                try {
                    queue.enqueue(node.getRightChild());
                } catch (QueueOverflowException e) {
                    System.out.print("\nException at: " + index);
                    break;
                }
            }
        }
        System.out.println();
    }
}
