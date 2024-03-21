package com.project.functional.u15_datastructuresfunctional.s107_queue;

public class Demo {
    public static void main(String[] args) {
        QueueFun<Integer> queue = QueueFun.queue();
        QueueFun<Integer> enqueue = queue.enqueue(1)
                .enqueue(20)
                .enqueue(13)
                .enqueue(9);

        enqueue.forEach(System.out::println);
        System.out.println();

        QueueFun<Integer> dequeue = enqueue.dequeue();
        dequeue.forEach(System.out::println);
        System.out.println();

        System.out.println(dequeue.peek());
        System.out.println();

        System.out.println(dequeue.isEmpty());
        System.out.println();

        System.out.println(dequeue.size());

    }
}
