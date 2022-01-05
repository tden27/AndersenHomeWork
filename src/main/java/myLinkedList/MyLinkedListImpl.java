package myLinkedList;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class MyLinkedListImpl<T> implements MyLinkedList<T> {
    // Кол-во элементов в списке
    private int size;

    // Первый элемент списка
    private Element<T> firstElement;

    // последний элемент списка
    private Element<T> lastElement;

    public MyLinkedListImpl() {
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T t) {
        Element<T> newElement;
        if (firstElement == null) {
            newElement = new Element<>(t, null, null);
            firstElement = newElement;
            lastElement = newElement;
        } else {
            Element<T> last = lastElement;
            newElement = new Element<>(t, null, lastElement);
            last.next = newElement;
            lastElement = newElement;
        }
        size++;
    }

    @Override
    public void addFirst(T t) {
        Element<T> element;
        if (firstElement == null) {
            element = new Element<>(t, null, null);
            firstElement = element;
            lastElement = element;
        } else {
            element = new Element<>(t, firstElement, null);
            firstElement.prev = element;
            firstElement = element;
        }
        size++;
    }

    @Override
    public boolean set(T t, int index) throws IndexOutOfBoundsException {
        if (!(index >= 0 && index <= size)) throw new IndexOutOfBoundsException(String.valueOf(index));
        Element<T> current = getElement(index);
        Element<T> previous = current.prev;
        Element<T> newElement = new Element<>(t, current, previous);
        previous.next = newElement;
        current.prev = newElement;
        size++;
        return true;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (!(index >= 0 && index <= size)) throw new IndexOutOfBoundsException(String.valueOf(index));
        return getElement(index).element;
    }

    @Override
    public int indexOf(T t) {
        int index = 0;
        if (t == null) {
            for (Element<T> x = firstElement; x != null; x = x.next) {
                if (x.element == null)
                    return index;
                index++;
            }
        } else {
            for (Element<T> x = firstElement; x != null; x = x.next) {
                if (t.equals(x.element))
                    return index;
                index++;
            }
        }
        return -1;
    }

    @Override
    public boolean remove(T t) throws NoSuchElementException {
        boolean result = false;
        if (t == null) {
            for (Element<T> x = firstElement; x != null; x = x.next) {
                if (x.element == null) {
                    removeElement(x);
                    result = true;
                }
            }
        } else {
            for (Element<T> x = firstElement; x != null; x = x.next) {
                if (t.equals(x.element)) {
                    removeElement(x);
                    result = true;
                }
            }
        }
        return result;
    }

    // Метод удаляет элемент меняя ссылки его предыдущего и последующего элементов
    private void removeElement(Element<T> element) {
        Element<T> prevRemovedElement = element.prev;
        Element<T> nextRemovedElement = element.next;

        if (prevRemovedElement == null) {
            firstElement = nextRemovedElement;
        } else {
            prevRemovedElement.next = nextRemovedElement;
            //element.prev = null;
        }

        if (nextRemovedElement == null) {
            lastElement = prevRemovedElement;
        } else {
            nextRemovedElement.prev = prevRemovedElement;
            //element.next = null;
        }

        size--;
    }

    @Override
    public void sort(Comparator<? super T> c) {
        boolean unsorted = true;
        T temp;
        while (unsorted) {
            unsorted = false;
            for (Element<T> x = firstElement; x.next != null; x = x.next) {
                if (c.compare(x.element, x.next.element) > 0) {
                    temp = x.element;
                    x.element = x.next.element;
                    x.next.element = temp;
                    unsorted = true;
                }
            }
        }
    }

    private static class Element<T> {
        // Значение текущего элемента
        T element;

        // Ссылка на следующий элемент
        Element<T> next;

        // Ссылка на предыдущий элемент
        Element<T> prev;

        public Element(T element, Element<T> next, Element<T> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    // Метод возвращает объект Element листа по указанному индексу
    private Element<T> getElement(int index) {
        if (index < (size >> 1)) {
            Element<T> x = firstElement;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Element<T> x = lastElement;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Element<T> x = firstElement;
        result.append(x.element.toString());
        result.append("\n");
        for (int i = 0; i < size-1; i++) {
            x = x.next;
            result.append(x.element.toString());
            result.append("\n");
        }
        return result.toString();
    }
}
