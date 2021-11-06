package com.ar;

// It is implemented using simple queue concept

public class DoubleEndedQ {
    private int[] array;
    private int front;
    private int rear;

    public DoubleEndedQ() {
        array = new int[10];
        front = rear = -1;
    }

    public void enqueueFromEnd(int item) throws OverFlowException {
        if (rear == array.length - 1) {
            throw new OverFlowException();
        } else {
            front = 0;
            array[++rear] = item;
        }
    }

    public void enqueueFromFront(int item) throws OverFlowException {
        if (rear == array.length - 1) {
            throw new OverFlowException();
        } else {
            for (int i = rear; i >= front; i--) {
                array[i + 1] = array[i];
            }
            array[front] = item;
            rear++;
        }
    }

    public int dequeueFromFront() throws UnderFlowException {
        if (front == -1) {
            throw new UnderFlowException();
        } else {
            int item = array[front]; // item at front is copied
            for (int i = front; i < rear; i++) {// remaining all items shifted towards frontend
                array[i] = array[i + 1];
            }
            rear--;
            if (rear == -1) // if q has only one item and that is being removed
                front = -1;

            return item;
        }
    }

    public int dequeueFromEnd() throws UnderFlowException {
        if (front == -1) {
            throw new UnderFlowException();
        } else {
            int item = array[rear]; // item at rear is copied

            rear--;
            if (rear == -1) // if q has only one item and that is being removed
                front = -1;

            return item;
        }
    }

    public void display() throws UnderFlowException {
        if (front == -1 && rear == -1) {
            throw new UnderFlowException();
        } else {
            int i = front;
            while (i <= rear) {
                System.out.println(array[i]);
                i++;
            }
        }
    }

}
