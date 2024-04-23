package com.project.functional.u8_functionalprogrammingindepth.s47_closure;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class ClosureDemo {

    // A closure is a function that refers to free variables in its lexical context
    public static void main(String[] args) {
        List<ITask> iTasks = generateTask();
        ITask incrementTask = iTasks.get(0);
        ITask printTask = iTasks.get(1);

        // Even though lexical context is closed, we can still access the 'X',
        // ... because JRE track down that variable.
        printTask.doTask();

        // We can even change the value of the variable 'X'
        incrementTask.doTask();

        // Then if we print it once more, we can see the result is changed.
        printTask.doTask();

        System.out.println("*****");

        Runnable runnable = generateTask2();
        runnable.run();
        runnable.run();
    }

    static List<ITask> generateTask() {
        AtomicReference<AtomicInteger> x = new AtomicReference<>(new AtomicInteger(100));
        ITask task1 = () -> x.set(new AtomicInteger(x.get().incrementAndGet()));
        ITask task2 = () -> System.out.println(x.get().intValue());
        return List.of(task1, task2);
    }

    static Runnable generateTask2() {
        Integer[] x = {0};

        return () -> {
            x[0] = x[0] + 1;
            System.out.println(x[0]);
        };
    }

    // You cannot have a primitive or primitive wrapper here. Because you cannot alter the reference.
    // There are 3 different solution for having closures.

    // 1) Array of integer; since only the item changes (so reference of array object doesn't change)
    // ... it complies with having a final or an effectively final variable.

    // 2) Encapsulating the value within an Object; Same logic with Array

    // 3) Atomic integers (or variables); this one is effectively final meaning it ensures the
    // ... thread-safety.



}
