package _11_stack_queue.exercise._queue_test;

public class TestQueue {
    public static void main (String[] args) {
        QueueList.Queue q = new QueueList.Queue();
        q.front = q.rear = null;

        QueueList.enQueue(q , 15);
        QueueList.enQueue(q , 35);
        QueueList.enQueue(q , 47);

        QueueList.display(q);

        System.out.println();
        System.out.printf("Delete value = %d" , QueueList.deQueue(q));
        System.out.println();
        System.out.printf("Delete value = %d" , QueueList.deQueue(q));
        System.out.println();
        QueueList.display(q);
    }
}
