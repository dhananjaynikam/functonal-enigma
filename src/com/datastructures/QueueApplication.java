package com.datastructures;

public class QueueApplication {

    public static void main(String[] args){
        QueueLinkedList queue = new QueueLinkedList();

        queue.addToQueue(2);
        queue.addToQueue(3);
        queue.displayQueue();
        queue.leaveQueue();
        queue.displayQueue();
    }

}
