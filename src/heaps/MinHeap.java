package heaps;

public class MinHeap<T extends Comparable> extends Heap<T> {

    public MinHeap(Class<T> clazz) {
        super(clazz);
    }

    public MinHeap(Class<T> clazz, int size) {
        super(clazz, size);
    }

    @Override
    void siftDown(int index){
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);

        int smallerIndex = -1;
        if (leftChildIndex > -1 && rightChildIndex > -1){
            smallerIndex =
                    getElementByIndex(leftChildIndex).compareTo(getElementByIndex(rightChildIndex)) < 0
                    ? leftChildIndex : rightChildIndex;
        } else if (leftChildIndex > -1){
            smallerIndex = leftChildIndex;
        } else if (rightChildIndex > -1){
            smallerIndex = rightChildIndex;
        }

        if (smallerIndex == -1) return;

        if (getElementByIndex(smallerIndex).compareTo(getElementByIndex(index)) < 0){
            swap(index, smallerIndex);
            siftDown(smallerIndex);
        }
    }

    @Override
    void siftUp(int index) {
        int parentIndex = getParentIndex(index);

        if (parentIndex > -1 && getElementByIndex(parentIndex).compareTo(getElementByIndex(index)) < 0){
            swap(index, parentIndex);
            siftUp(parentIndex);
        }
    }

}
