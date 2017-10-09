package stacks_queues;

import stacks_queues.exceptions.QueueOverflowException;
import stacks_queues.exceptions.QueueUnderflowException;

import java.lang.reflect.Array;

public class Queue<T> {

    private static final int EMPTY_VALUE = -1;
    private static final int MAX_SIZE = 40;
    private T[] elements;

    private int headIndex = EMPTY_VALUE;
    private int tailIndex = EMPTY_VALUE;

    private int count;

    public Queue(Class<T> clazz) {
        elements = (T[]) Array.newInstance(clazz, MAX_SIZE);
    }

    public boolean isEmpty(){
        return headIndex == EMPTY_VALUE;
    }

    public boolean isFull(){
        int nextIndex = (tailIndex + 1) % MAX_SIZE;
        return nextIndex == headIndex;
    }

    public void enqueue(T data) throws QueueOverflowException {
        if (isFull()){
            throw new QueueOverflowException();
        }

        tailIndex = (tailIndex + 1) % MAX_SIZE;
        elements[tailIndex] = data;

        if (headIndex == EMPTY_VALUE){
            headIndex = tailIndex;
        }

        count++;
    }

    public T dequeue() throws QueueUnderflowException {
        if (isEmpty()){
            throw new QueueUnderflowException();
        }

        T data = elements[headIndex];
        if (headIndex == tailIndex){
            headIndex = EMPTY_VALUE;
        } else {
            headIndex = (headIndex + 1) % MAX_SIZE;
        }

        count--;
        return data;
    }

    public int size(){
        return count;
    }

}
