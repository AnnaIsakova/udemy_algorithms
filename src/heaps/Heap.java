package heaps;

import java.lang.reflect.Array;
import java.util.Arrays;

public abstract class Heap<T extends Comparable> {

    static final int MAX_SIZE = 40;
    T[] array;
    int count = 0;

    public Heap(Class<T> clazz){
        this(clazz, MAX_SIZE);
    }

    public Heap(Class<T> clazz, int size){
        this.array = (T[]) Array.newInstance(clazz, size);
    }

    public void printHeap(){
        System.out.println(Arrays.toString(array));
    }

    public int getLeftChildIndex(int rootIndex){
        int leftIndex = (rootIndex * 2) + 1;
        if (rootIndex < 0 || leftIndex >= count) return -1;
        return leftIndex;
    }

    public int getRightChildIndex(int rootIndex){
        int rightIndex = (rootIndex * 2) + 2;
        if (rootIndex < 0 || rightIndex >= count) return -1;
        return rightIndex;
    }

    public int getParentIndex(int childIndex){
        if (childIndex < 0) return -1;
        return (childIndex - 1) / 2;
    }

    void swap(int index1, int index2){
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public int getCount(){
        return count;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return array.length <= count;
    }

    public T getElementByIndex(int index){
        if (index < 0 || index > count) return null;
        return array[index];

    }

    public abstract void siftDown(int index);

    public abstract void siftUp(int index);

    public void insert(T elem){
        if (isFull()){
            throw new RuntimeException("queue is full");
        }

        array[count] = elem;
        siftUp(count);
        count++;
    }

    public T removeHighestPriority(){
        T elem = getHighestPriority();
        array[0] = array[count-1];
        count--;
        siftDown(0);
        return elem;
    }

    public T getHighestPriority(){
        if (isEmpty()) {
            throw new RuntimeException("empty");
        }

        return array[0];
    }

}
