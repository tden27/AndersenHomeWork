package myLinkedList;

import myArrayList.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListImplTest {
    public static MyLinkedListImpl<Integer> myLinkedList;

    @BeforeEach
    void init() {
        myLinkedList = new MyLinkedListImpl<>();
        myLinkedList.add(18);
        myLinkedList.add(4);
        myLinkedList.add(1);
        myLinkedList.add(80);
        myLinkedList.add(4);
        myLinkedList.add(32);
        myLinkedList.add(80);
    }

    @Test
    void size() {
        assertEquals(7, myLinkedList.size());
    }

    @Test
    void add() {
        myLinkedList.add(120);
        System.out.println(myLinkedList);
        assertEquals(8, myLinkedList.size());
    }

    @Test
    void addFirst() {
        myLinkedList.addFirst(27);
        System.out.println(myLinkedList);
        assertEquals(8, myLinkedList.size());
    }

    @Test
    void set() {
        myLinkedList.set(50, 2);
        System.out.println(myLinkedList);
        assertEquals(50, myLinkedList.get(2));
    }

    @Test
    void get() {
        assertEquals(1, myLinkedList.get(2));
    }

    @Test
    void indexOf() {
        assertEquals(3, myLinkedList.indexOf(80));
    }

    @Test
    void remove() {
        myLinkedList.remove(80);
        System.out.println(myLinkedList);
        assertEquals(5, myLinkedList.size());
    }

    @Test
    void sort() {
        MyLinkedListImpl<Person> myLinkedList = new MyLinkedListImpl<>();
        myLinkedList.add(new Person("Andrey", 35));
        myLinkedList.add(new Person("Ivan", 3));
        myLinkedList.add(new Person("Sergey", 15));
        myLinkedList.add(new Person("Andrey", 40));
        myLinkedList.add(new Person("Igor", 35));
        myLinkedList.add(new Person("Boris", 60));

        System.out.println("Before sort");
        System.out.println(myLinkedList);

        myLinkedList.sort((o1, o2) -> {
            if (o1.getName().compareTo(o2.getName()) == 0) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
            return o1.getName().compareTo(o2.getName());
        });

        System.out.println("After sort");
        System.out.println(myLinkedList);
    }
}