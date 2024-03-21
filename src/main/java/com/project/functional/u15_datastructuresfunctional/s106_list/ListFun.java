package com.project.functional.u15_datastructuresfunctional.s106_list;

import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.function.Consumer;

public abstract class ListFun<T> {

    public abstract T head();

    public abstract ListFun<T> tail();

    public abstract boolean isEmpty();

    public static final ListFun NIL = new Nil();

    public int length() {
        int l = 0;
        ListFun<T> temp = this;
        while (!temp.equals(NIL)) {
            l++;
            temp = temp.tail();
        }
        return l;
    }

    @RequiredArgsConstructor
    private static class Const<T> extends ListFun<T> {

        private final T head;
        private final ListFun<T> tail;

        @Override
        public T head() {
            return head;
        }

        @Override
        public ListFun<T> tail() {
            return tail;
        }

        @Override
        public boolean isEmpty() {
            return length() == 0;
        }
    }

    private static class Nil<T> extends ListFun<T> {
        private Nil() {

        }

        @Override
        public T head() {
            return null;
        }

        @Override
        public ListFun<T> tail() {
            return null;
        }

        @Override
        public boolean isEmpty() {
            return true;
        }
    }

    public static <T> ListFun<T> list() {
        return NIL;
    }

    public static <T> ListFun<T> list(T...t) {
        ListFun<T> temp = list();
        for (int i = t.length - 1; i >= 0; i--) {
            temp = new Const<>(t[i], temp);
        }
        return temp;
    }

    public ListFun<T> add(T t) {
        return new Const<T>(t, this);
    }

    public ListFun<T> add(int pos, T t) {
        if (pos < 1 || pos > length()) {
            throw new IndexOutOfBoundsException();
        }
        if (pos == 1) {
            return this.tail().add(t);
        }
        return new Const<>(head(), tail().add(pos-1, t));
    }

    public void forEach(Consumer<? super T> action) {
        T current = this.head();
        ListFun<T> temp = this;

        for (int i = 0; i < length(); i++) {
            action.accept(current);
            temp = temp.tail();
            current = temp.head();
        }

    }

    public ListFun<T> removeByObject(T t) {
        if (this.length() == 0) {
            return this;
        } else if (t.equals(this.head())) {
            return tail();
        } else {
            ListFun<T> removedList = tail().removeByObject(t);
            return new Const<>(head(), removedList);
        }
    }

    public ListFun<T> removeByIndex(int pos) {
        if (pos < 0 || pos > length()) {
            throw new IndexOutOfBoundsException();
        }
        if (pos == 0) {
            return tail();
        }
        return new Const<>(head(), tail().removeByIndex(pos-1));
    }

    public ListFun<T> reverseList() {
        ListFun<T> list = list();
        T current = this.head();
        ListFun<T> temp = this;

        while(!temp.equals(NIL)) {
            list = list.add(current);
            temp = temp.tail();
            current = temp.head();
        }
        return list;
    }

    public static <T> ListFun<T> concat(ListFun<T> list1, ListFun<T> list2) {
        return list1.isEmpty()
                ? list2
                : new Const<>(list1.head(), concat(list1.tail(), list2));
    }

    public ListFun<T> addAll(final Collection<? extends T> list) {
        ListFun<T> result = this;
        for (T t : list) {
            result = result.add(t);
        }
        return result;
    }

    public ListFun<T> clear() {
        return list();
    }

}
