package com.project.functional.u15_datastructuresfunctional.s107_queue;

import com.project.functional.u15_datastructuresfunctional.s106_list.ListFun;

import java.util.function.Consumer;

public final class QueueFun<T> {

    private final ListFun<T> front;
    private final ListFun<T> rear;

    private QueueFun() {
        this.front = ListFun.list();
        this.rear = ListFun.list();
    }

    private QueueFun(QueueFun<T> queue, T element) {
        boolean frontIsEmpty = queue.front.isEmpty();
        this.front = frontIsEmpty ? queue.front.add(element) : queue.front;
        this.rear = frontIsEmpty ? queue.rear : queue.rear.add(element);
    }

    private QueueFun(ListFun<T> front, ListFun<T> rear) {
        final boolean frontIsEmpty = front.isEmpty();
        this.front = frontIsEmpty ? rear.reverseList() : front;
        this.rear = frontIsEmpty ? front : rear;
    }

    // Empty Queue
    public static <T> QueueFun<T> queue() {
        return new QueueFun<T>();
    }

    // Enqueue
    public QueueFun<T> enqueue(T t) {
        return new QueueFun<T>(this, t);
    }

    // Dequeue
    public QueueFun<T> dequeue() {
        return new QueueFun<>(this.front.tail(), rear);
    }

    // Traverse
    public void forEach(Consumer<? super T> action) {
        T current = this.front.head();
        ListFun<T> temp = ListFun.concat(this.front.tail(), this.rear.reverseList());
        while (temp != null) {
            action.accept(current);
            current = temp.head();
            temp = temp.tail();
        }
    }

    public int size() {
        return front.length() + rear.length();
    }

    public T peek() {
        if (this.size() == 0) {
            return null;
        }
        return this.front.head();
    }

    public boolean isEmpty() {
        return this.front.isEmpty() && this.rear.isEmpty();
    }

}
