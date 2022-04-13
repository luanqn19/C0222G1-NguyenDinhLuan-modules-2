package _10_List.exercise.Arraylist;

import java.util.ArrayList;
import java.util.Arrays;

public class MyList<E> {
    public static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private E[] elements;

    private void ensureCapacity (int minCapacity) {
        if (size >= elements.length || minCapacity >= 0) {
            int newSize = elements.length + minCapacity;
//            E[] newData = (E[]) (new Object[newSize]);
            elements = Arrays.copyOf(elements, newSize);
//            System.arraycopy(elements , 0 , newData , 0 , newSize);
//            elements = newData;
        }
    }

    public MyList () {

    }

    public MyList (E[] e) {
        for (int i = 0 ; i < e.length ; i++) {
            this.add(e[i]);
        }
    }

    public MyList (int capactity) {
        this.elements = (E[]) new Object[capactity];
    }

    public void add (int index , E e) {
        this.ensureCapacity(2);
        if (size == 0) this.elements[index] = e;
        else {
            for (int i = this.size - 1 ; i >= index ; i--) this.elements[i + 1] = this.elements[i];
            this.elements[index] = e;
        }
        this.size++;
    }

    private void checkIndex (int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + "out of bound!");
    }

    public E remove (int index) {
        checkIndex(index);
        E e = elements[index];

        for (int i = index ; i < size - 1 ; i++) elements[i] = elements[i + 1];

        elements[size - 1] = null;

        size--;
        return e;
    }


    public int size () {
        return size;
    }

    @Override
    public MyList<E> clone () {
        MyList<E> e = new MyList<>();
        e.elements = Arrays.copyOf(this.elements , this.size);
        e.size = this.size;
        return e;
    }

    public boolean contains (E o) {
        for (E item : elements) {
            if (o.equals(item)) return true;
        }
        return false;
    }

    public int indexOf (E o) {
        for (int i = 0 ; i < elements.length ; i++)
            if (o.equals(elements[i])) return i;
        return - 1;
    }

    public boolean add (E o) {
        this.add(o);
        size++;
        return true;
    }

    public E get (int i) {
        checkIndex(i);
        return elements[i];
    }

    public void clear () {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }
}
