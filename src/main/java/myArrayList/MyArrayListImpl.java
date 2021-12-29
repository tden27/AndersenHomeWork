package myArrayList;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayListImpl<T> implements MyArrayList<T> {
    // Массив элементов внутри списка
    private Object[] elements;

    // Емкость изначального массива элементов по умолчанию
    private static final int DEFAULT_CAPACITY = 10;

    // Размер внутреннего массива
    private int capacity;

    // Кол-во элементов в списке (его размер)
    private int size;

    public MyArrayListImpl() {
        elements = new Object[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
        size = 0;
    }

    public MyArrayListImpl(int inutCapacity) {
        elements = new Object[inutCapacity];
        capacity = inutCapacity;
        size = 0;
    }

    @Override
    public boolean add(T element) {
        if (size < capacity) {
            elements[size++] = element;
            return true;
        } else {
            int newCapacity = (int) ((capacity * 1.5) + 1);
            elements = Arrays.copyOf(elements, newCapacity);
            capacity = newCapacity;
            elements[size++] = element;
            return true;
        }
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index >= size) throw new IndexOutOfBoundsException(String.valueOf(index));
        return (T) elements[index];
    }

    @Override
    public boolean set(int index, T element) throws IndexOutOfBoundsException {
        if (index >= size) throw new IndexOutOfBoundsException(String.valueOf(index));

        if (size < capacity) {
            System.arraycopy(elements, index, elements, index + 1,
                    size - index);
            elements[index] = element;
            size++;
            return true;
        } else {
            int newCapacity = (int) ((capacity * 1.5) + 1);
            elements = Arrays.copyOf(elements, newCapacity);
            capacity = newCapacity;
            System.arraycopy(elements, index, elements, index + 1,
                    size - index);
            elements[index] = element;
            size++;
            return true;
        }
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        if (index >= size) throw new IndexOutOfBoundsException(String.valueOf(index));

        T removedElement = (T) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) System.arraycopy(elements, index + 1, elements, index, numMoved);
        size--;
        return removedElement;
    }

    @Override
    public boolean remove(T element) {
        if (element == null) {
            for (int index = 0; index < size; index++)
                if (elements[index] == null) {
                    remove(index);
                }
        } else {
            for (int index = 0; index < size; index++)
                if (element.equals(elements[index])) {
                    remove(index);
                }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void sort(Comparator<? super T> c) {
        boolean unsorted = true;
        T temp;
        while (unsorted) {
            unsorted = false;
            for (int i = 0; i < size-1; i++) {
                if (c.compare((T) elements[i], (T) elements[i + 1]) > 0) {
                    temp = (T) elements[i];
                    elements[i] = elements[i + 1];
                    elements[i + 1] = temp;
                    unsorted = true;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append(elements[i].toString());
            result.append("\n");
        }
        return result.toString();
    }
}
