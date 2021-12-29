package myArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListImplTest {
    public static MyArrayListImpl<Integer> myArrayList;

    @BeforeEach
    void init() {
        myArrayList = new MyArrayListImpl<>();
        myArrayList.add(5);
        myArrayList.add(145);
        myArrayList.add(32);
        myArrayList.add(145);
        myArrayList.add(352);
    }

    @Test
    void add() {
        assertTrue(myArrayList.add(5));
    }

    @Test
    void get() {
        assertEquals(145, myArrayList.get(1));
    }

    @Test
    void set() {
        assertTrue(myArrayList.set(2, 12));
        assertEquals(12, myArrayList.get(2));
        assertEquals(6, myArrayList.size());
    }

    @Test
    void remove() {
        assertEquals(32, myArrayList.remove(2));
        assertEquals(4, myArrayList.size());
    }

    @Test
    void testRemove() {
        assertTrue(myArrayList.remove(Integer.valueOf(145)));
        assertEquals(3, myArrayList.size());
    }

    @Test
    void size() {
        myArrayList.add(7);
        myArrayList.add(15);
        assertEquals(7, myArrayList.size());
    }

    @Test
    void sort() {
        MyArrayListImpl<Person> myArrayListPerson = new MyArrayListImpl<>(50);
        myArrayListPerson.add(new Person("Andrey", 35));
        myArrayListPerson.add(new Person("Ivan", 3));
        myArrayListPerson.add(new Person("Andrey", 40));
        myArrayListPerson.add(new Person("Sergey", 15));
        myArrayListPerson.add(new Person("Igor", 35));
        myArrayListPerson.add(new Person("Boris", 60));

        System.out.println("Before sort");
        System.out.println(myArrayListPerson);

        myArrayListPerson.sort((o1, o2) -> {
            if (o1.getName().compareTo(o2.getName()) == 0) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
            return o1.getName().compareTo(o2.getName());
        });

        System.out.println("After sort");
        System.out.println(myArrayListPerson);
    }
}