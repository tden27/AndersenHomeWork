package myLinkedList;

import java.util.Comparator;
import java.util.NoSuchElementException;

public interface MyLinkedList<T> {

    /**
     * Метод возвращает кол-во элементов в списке
     * @return - кол-во элементов в списке
     */
    int size();

    /**
     * Метод добавляет эелемент в конец списка
     * @param t - добавляемый элемент
     */
    void add(T t);

    /**
     * Метод добавляет элемент в начало списка
     * @param t - добавляемый элемент
     */
    void addFirst(T t);

    /**
     * Метод вставляет элемент в указанную позицию.
     * Все элементы от указанного индекса и до конца сдвигаются на одну позицию вправо.
     * @param t - вставляемый элемент
     * @param index - позиция вставляемого элемента
     * @return - true если вставка элемента удачна, иначе false
     * @throws IndexOutOfBoundsException
     */
    boolean set(T t, int index) throws IndexOutOfBoundsException;

    /**
     * Метод получает элемент по указанному в параметрах индексу
     * @param index - индекс получаемого элемента
     * @return - возвращает полученный элемент
     * @throws IndexOutOfBoundsException
     */
    T get(int index) throws IndexOutOfBoundsException;

    /**
     * Метод возвращает индекс элемента указанного в параметрах
     * @param t - элемент индекс которого нужно получить
     * @return - индекс первого найденного элемента, либо -1 если такой элемент не найден
     */
    int indexOf(T t);

    /**
     * Метод удаляет из списка элемент указанный в параметрах.
     * Если таких элементов несколько, удаляет все найденные.
     * @param t - удаляемый элемент
     * @return - true если удаление прошло успешно, иначе false
     * @throws NoSuchElementException
     */
    boolean remove(T t) throws NoSuchElementException;

    /**
     * Метод сортирует список в порядке согласно указанному Comparator
     * @param c - Comparator в соответствии с которым происходит сортировка
     */
    void sort(Comparator<? super T> c);
}
