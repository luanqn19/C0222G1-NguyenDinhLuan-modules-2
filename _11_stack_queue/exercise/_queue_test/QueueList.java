package _11_stack_queue.exercise._queue_test;

public class QueueList {
    static class Node {
        int data;
        Node link;
    }

    static class Queue {
        Node front, rear;
    }

    public static void enQueue (Queue q , int value) {
        Node temp = new Node();
        temp.data = value;
        if (q.front == null) q.front = temp;
        else q.rear.link = temp;

        q.rear = temp;
        q.rear.link = q.front;
    }

    public static int deQueue (Queue q) {
        if (q.front == null) return Integer.MIN_VALUE;
        int value;
        if (q.front == q.rear) {
            value = q.front.data;
            q.front = null;
            q.rear = null;
        } else {
            Node temp = q.front;
            value = temp.data;
            q.front = q.front.link;
            q.rear.link = q.front;
        }

        return value;
    }

    public static void display (Queue q) {
        Node temp = q.front;
        System.out.print("Elements in Circular Queue are: ");
        while (temp.link != q.front) {
            System.out.printf("%d " , temp.data);
            temp = temp.link;
        }
        System.out.printf("%d" , temp.data);
    }
}
