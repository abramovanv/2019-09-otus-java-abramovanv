package hw2.otus;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyListIterator<T> implements ListIterator<T> {

    private int cursor = 0;
    private int index;
    private T[] myarray;

    protected MyListIterator(int index_in, T[] myarray_in) {
        index = index_in;
        myarray = myarray_in;
    }


    @Override
    public boolean hasNext() {
        if (index >= myarray.length) {
            return false;
        }
        return true;
    }

    @Override
    public T next() {
        int i = cursor;
        if (i >= myarray.length /*size*/) {
            throw new NoSuchElementException();
        }
        T[] myarray2 = myarray;
        if (i > myarray2.length) {
            throw new ConcurrentModificationException();
        }
        cursor = i + 1;
        return (T) myarray2[i];
    }

    @Override
    public boolean hasPrevious() {
        throw new UnsupportedOperationException();
    }

    @Override
    public T previous() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int nextIndex() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int previousIndex() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void set(T t) {
        myarray[cursor - 1] = t;
    }

    @Override
    public void add(T t) {
        throw new UnsupportedOperationException();
    }
}