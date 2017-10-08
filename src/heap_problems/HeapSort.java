package heap_problems;

public class HeapSort {

    int[] array = new int[100];

    public static void main(String[] args) {

    }

    void swap(int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    int getLeftChildIndex(int index, int endIndex){
        int leftIndex = (index * 2) + 1;
        if (index < 0 || index > endIndex || leftIndex > endIndex) {
            return -1;
        }

        return leftIndex;
    }

    int getRightChildIndex(int index, int endIndex){
        int rightIndex = (index * 2) + 2;
        if (index < 0 || index > endIndex || rightIndex > endIndex) {
            return -1;
        }

        return rightIndex;
    }

    int getParentIndex(int index, int endIndex){
        if (index < 0 || index > endIndex){
            return -1;
        }
        return (index - 1) / 2;
    }

    void percolateDown(int index, int endIndex){
        int leftChildIndex = getLeftChildIndex(index, endIndex);
        int rightIndex = getRightChildIndex(index, endIndex);

        if (leftChildIndex != -1 && array[leftChildIndex] > array[index]){
            swap(index, leftChildIndex);
            percolateDown(leftChildIndex, endIndex);
        }

        if (rightIndex != -1 && array[rightIndex] > array[index]){
            swap(index, rightIndex);
            percolateDown(rightIndex, endIndex);
        }
    }

    void heapify(int endIndex){
        int index = getParentIndex(endIndex, endIndex);
        while (index >= 0){
            percolateDown(index, endIndex);
            index--;
        }
    }

    void sort(){
        int endIndex = array.length - 1;
        heapify(endIndex);

        while (endIndex >= 0){
            swap(0, endIndex);
            endIndex--;
            percolateDown(0, endIndex);
        }

    }
}
