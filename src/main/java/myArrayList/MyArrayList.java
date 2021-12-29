package myArrayList;

import java.util.Comparator;

public interface MyArrayList<T> {

    /**
     * Метод добавляет элемент в список, вставляя его в конце
     * @param element - добавляемый элемент
     * @return - true при удачном добавлении, иначе false
     */
    boolean add(T element);

    /**
     * Метод получает элемент по указанному в параметрах индексу
     * @param index - индекс получаемого элемента
     * @return - возвращает полученный элемент
     * @throws IndexOutOfBoundsException
     */
    T get(int index) throws IndexOutOfBoundsException;

    /**
     * Метод вставляет указанный элемент по указанному в параметрах индексу.
     * Все элементы от указанного индекса и до конца сдвигаются на одну позицию вправо
     * @param index - индекс вставки элемента
     * @param element - элемент, который вставляется
     * @return - true если вставка прошла успешно, иначе false
     * @throws IndexOutOfBoundsException
     */
    boolean set(int index, T element) throws IndexOutOfBoundsException;

    /**
     * Метод удаляет элемент по указанному индексу. Все элементы после указанного индекса
     * сдвигаются на одну позицию влево.
     * @param index - индекс удаляемого элемента
     * @return - возвращает удаленный элемент
     * @throws IndexOutOfBoundsException
     */
    T remove(int index) throws IndexOutOfBoundsException;

    /**
     * Метод удаляет из списка элемент указанный в параметрах.
     * Если таких элементов несколько, удаляет все найденные.
     * @param element - удаляемый элемент
     * @return - true если удаление прошло успешно, иначе false
     */
    boolean remove(T element);

    /**
     * Метод возвращает количество элементов в списке
     * @return - количество элементов в списке
     */
    int size();

    /**
     * Метод сортирует список в порядке согласно указанному Comparator
     * @param c - Comparator в соответствии с которым происходит сортировка
     */
    void sort(Comparator<? super T> c);
}

