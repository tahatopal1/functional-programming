package com.project.functional.u12_collectors.s88_collectors1;

import java.sql.Date;
import java.util.Spliterator;
import java.util.function.Consumer;

public class EmployeeSpliterator implements Spliterator<Employee> {

    private Spliterator<String> wordSpliterator;

    public EmployeeSpliterator(Spliterator<String> wordSpliterator) {
        this.wordSpliterator = wordSpliterator;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Employee> action) {
        Employee employee = new Employee();
        if (this.wordSpliterator.tryAdvance(word -> employee.setId(Integer.parseInt(word)))
                && this.wordSpliterator.tryAdvance(employee::setName)
                && this.wordSpliterator.tryAdvance(word -> employee.setGender(word.charAt(0)))
                && this.wordSpliterator.tryAdvance(word -> employee.setDob(Date.valueOf(word)))
                && this.wordSpliterator.tryAdvance(employee::setCity)
                && this.wordSpliterator.tryAdvance(employee::setDesignation)
                && this.wordSpliterator.tryAdvance(word -> employee.setJoiningDate(Date.valueOf(word)))
                && this.wordSpliterator.tryAdvance(word -> employee.setSalary(Double.parseDouble(word)))) {
            action.accept(employee);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Spliterator<Employee> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return wordSpliterator.estimateSize() / 8;
    }

    @Override
    public int characteristics() {
        return wordSpliterator.characteristics();
    }
}
