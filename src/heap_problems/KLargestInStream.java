package heap_problems;

import heaps.Heap;
import heaps.MinHeap;

public class KLargestInStream {

    public static void main(String[] args) {
        int[] arr = {3,7,8,9,4,5,6,1,2,0};
        Heap<Integer> heap = findKElemsInArray(2, arr);
        heap.printHeap();
    }

    static Heap<Integer> findKElemsInArray(int k, int[] array){
        Heap<Integer> heap = new MinHeap<Integer>(Integer.class, k);

        for (int i = 0; i < k; i++) {
            if (k >= array.length) return heap;
            heap.insert(array[k]);
        }

        int root = heap.getElementByIndex(0);
        for (int i = k; i < array.length; i++) {
            if (array[i] > root){
                heap.removeHighestPriority();
                heap.insert(array[i]);
                root = heap.getElementByIndex(0);
            }
        }
        return heap;
    }
}
