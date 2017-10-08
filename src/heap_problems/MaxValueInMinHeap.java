package heap_problems;

import heaps.MinHeap;

public class MaxValueInMinHeap {

    public static void main(String[] args) {
        MinHeap<Integer> heap = new MinHeap<Integer>(Integer.class, 5);
        heap.insert(8);
        heap.insert(1);
        heap.insert(3);
        heap.insert(4);
        heap.insert(2);

        heap.printHeap();
        System.out.println(findMax(heap));
    }

    static int findMax(MinHeap<Integer> heap){
        int result;
        int lastIndex = heap.getCount() - 1;
        int lastParentIndex = heap.getParentIndex(lastIndex);
        int firstLeafIndex = lastParentIndex + 1;

        result = heap.getElementByIndex(firstLeafIndex);
        for (int i = firstLeafIndex + 1; i <= lastIndex ; i++) {
            if (heap.getElementByIndex(i) > result){
                result = heap.getElementByIndex(i);
            }
        }

        return result;
    }
}
