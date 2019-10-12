package hw2.otus;
import java.util.*;

public class DIArrayList<T> implements List<T> {

    private T[] myarray;
    private int index;
    private int size;


    protected DIArrayList() {
        myarray = (T[]) new Object[30];
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(myarray, myarray.length);

    }

    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(T var1) {
        if (index == myarray.length) {
            grow(1);
        }
        myarray[index] = var1;
        index++;
        size++;
        return true;
    }


    private void grow(int count) {

        myarray = Arrays.copyOf(myarray, myarray.length + count);
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
    public boolean addAll(Collection<? extends T> collection) {
        Object[] var2 = collection.toArray();
        int var3 = var2.length;
        grow(var3);
        System.arraycopy(var2, 0, myarray, myarray.length - var3, var3);
        this.size += var3;
        return var3 != 0;
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
    public ListIterator<T> listIterator() {
        return new ListIterator<>() {
            int cursor = 0;

            @Override
            public boolean hasNext() {
                if (size >= myarray.length) {
                    return false;
                }
                return true;
            }

            @Override
            public T next() {
                int i = cursor;
                if (i >= size) {
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
        };
    }

    @Override
    public List<T> subList(int i, int i1) {
        throw new UnsupportedOperationException();
    }
}
