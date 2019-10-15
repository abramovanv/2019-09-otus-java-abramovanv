package hw2.otus;
import java.util.*;


public class DIArrayList<T> implements List<T> {

    private T[] myarray;
    private int index;
    final static private int DEFAULT_SIZE = 30;


    protected DIArrayList() {
        myarray = (T[]) new Object[DEFAULT_SIZE];
    }


    @Override
    public boolean add(T newelement) {
        if (index == myarray.length) {grow(2);}
        myarray[index] = newelement;
        index++;
        return true;
    }

    private void grow(int count) {
        myarray = Arrays.copyOf(myarray, myarray.length+count);
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        Object[]  tmparray = collection.toArray();
        int tmparraylen = tmparray.length;
        grow(tmparraylen);
        System.arraycopy(tmparray, 0, myarray, myarray.length-tmparraylen, tmparraylen);
        return tmparraylen != 0;
    }


    @Override
    public T get(int i) {
        if (i >= myarray.length || i < 0) {
            throw new IndexOutOfBoundsException("Неверный индекс: " + i);
        }
        return myarray[i];
    }

    @Override
    public T set(int i, T t) {

        if (i >= myarray.length || i < 0) {
            throw new IndexOutOfBoundsException("Неверный индекс: " + i);
        }
        if (i < myarray.length) {
            myarray[i] = t;
        }
        return myarray[i];
    }

    @Override
    public ListIterator<T> listIterator() {
        return new MyListIterator<T>(index, myarray);
    }

    @Override
    public int size() {
        return myarray.length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(myarray, myarray.length);

    }

    @Override
    public boolean addAll(int i, Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int i, T t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator(int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> subList(int i, int i1) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();}

    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        throw new UnsupportedOperationException();}


}