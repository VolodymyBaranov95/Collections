package ua.yandex.collections;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import ua.yandex.collections.Node;

public class MyLinkedListTest {

    @Test
    public void addRandom() {
        MyLinkedList list = new MyLinkedList();
        list.add(5);
        list.add(10);
        list.add(20);
        Object expRes[] = list.toArray();
        Object actRes[] = {5, 10, 20};
        assertArrayEquals(actRes, expRes);
    }

    @Test
    public void addcheckFirstProporties() {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        assertFalse(!(list.getFirstNode().getPrev() == null));
    }

    @Test
    public void addPreservationProporties() {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        assertFalse(!(list.getFirstNode().getNext() == null));
    }

    @Test
    public void addProporties() {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        assertFalse(!(list.getFirstNode().getNext().getNext() == null));
    }

    @Test(expected = NotEnoughIndexException.class)
    public void getCheckNegative() {
        MyLinkedList list = new MyLinkedList();
        list.get(-10);
    }

    @Test(expected = NotEnoughIndexException.class)
    public void getOutputSize() {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(5);
        list.get(4);
    }

    @Test
    public void getRandomValue() {
        MyLinkedList list = new MyLinkedList();
        list.add(10);
        Object expRes = list.get(0);
        Integer actRes = Integer.valueOf(10);
        assertEquals(actRes, expRes);
    }

    @Test
    public void getcheckProporties() {
        MyLinkedList list = new MyLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        Object expRes = list.get(2);
        Integer actRes = Integer.valueOf(30);
        assertEquals(actRes, expRes);
    }

    @Test
    public void addIndexRandomValue() {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(2, 10);
        Object actRes = list.get(2);
        Integer expRes = Integer.valueOf(10);
        assertEquals(actRes, expRes);
    }

    @Test(expected = NotEnoughIndexException.class)
    public void addIndexCheckNegative() {
        MyLinkedList list = new MyLinkedList();
        list.add(10);
        list.add(20);
        list.add(-1, 30);
    }

    @Test(expected = NotEnoughIndexException.class)
    public void addIndexOutputSize() {
        MyLinkedList list = new MyLinkedList();
        list.add(10);
        list.add(20);
        list.add(3, 30);
    }

    @Test
    public void addAllRandomValue() {
        MyLinkedList list = new MyLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        Object mas[] = {40, 50, 60};
        list.addAll(mas);
        Object expRes[] = list.toArray();
        Object actRes[] = {10, 20, 30, 40, 50, 60};
        assertArrayEquals(expRes, actRes);
    }

    @Test
    public void addAllCheckProporties() {
        MyLinkedList list = new MyLinkedList();
        Object mas[] = {1, 2, 3, 4};
        list.addAll(mas);
        Object expRes = list.getFirstNode().getData();
        Integer actRes = Integer.valueOf(1);
        assertEquals(expRes, actRes);
    }

    @Test
    public void addAllRandom() {
        MyLinkedList list = new MyLinkedList();
        Object mas[] = {1, 2, 3, 4, 5};
        list.addAll(mas);
        Object expRes = list.getLastNode().getData();
        Integer actRes = Integer.valueOf(5);
        assertEquals(expRes, actRes);
    }

    @Test
    public void addAllIndexRandom() {
        MyLinkedList list = new MyLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        Object mas[] = {1, 2, 3};
        list.addAll(2, mas);
        Object expRes[] = list.toArray();
        Object actRes[] = {10, 20, 1, 2, 3, 30};
        assertArrayEquals(expRes, actRes);
    }

    @Test(expected = NotEnoughIndexException.class)
    public void addAllIndexOutputSize() {
        MyLinkedList list = new MyLinkedList();
        list.add(0);
        Object mas[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        list.addAll(2, mas);
    }

    @Test
    public void removeRandom() {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Object expRes = list.remove(2);
        Integer actRes = Integer.valueOf(3);
        assertEquals(expRes, actRes);
    }

    @Test
    public void removeRandomValueCheckProporties() {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.remove(2);
        Object expRes = list.get(2);
        Integer actRes = Integer.valueOf(4);
        assertEquals(expRes, actRes);
    }

    @Test
    public void removeCheckProporties() throws NotEnoughIndexException {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.remove(2);
        Object expRes = list.getFirstNode().getNext().getData();
        Integer actRes = Integer.valueOf(2);
        assertEquals(expRes, actRes);
    }

    @Test(expected = NotEnoughIndexException.class)
    public void removeOutputSize() {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.remove(2);
    }

    @Test
    public void setRandom() {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        Object mas[] = {2, 3, 4, 5};
        list.addAll(mas);
        list.set(2, 100);
        Object expRes = list.get(2);
        Integer actRes = Integer.valueOf(100);
        assertEquals(expRes, actRes);

    }

    @Test
    public void setRandomValue() {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        Object mas[] = {2, 3, 4, 5};
        list.addAll(mas);
        list.set(3, 100);
        list.set(4, 100);
        Object expRes[] = list.toArray();
        Object actRes[] = {1, 2, 100, 100, 5};

    }

    @Test(expected = NotEnoughIndexException.class)
    public void setOutputSize() {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.set(3, 10);
    }

    @Test
    public void indexOfRandom() {
        MyLinkedList list = new MyLinkedList();
        Object mas[] = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        list.addAll(mas);
        int expRes = list.indexOf(60);
        int actRes = 6;
        assertEquals(expRes, actRes);
    }

    @Test
    public void indexOfRandomValue() {
        MyLinkedList list = new MyLinkedList();
        Object mas[] = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        list.addAll(mas);
        int expRes = list.indexOf(90);
        int actRes = 9;
        assertEquals(expRes, actRes);
    }

    @Test
    public void indexOfNotFound() {
        MyLinkedList list = new MyLinkedList();
        Object mas[] = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        list.addAll(mas);
        int expRes = list.indexOf(100);
        int actRes = -1;
        assertEquals(expRes, actRes);
    }

    @Test
    public void size() {
        MyLinkedList list = new MyLinkedList();
        Object mas[] = {1, 2, 3, 4, 5, 6, 7, 8};
        list.addAll(mas);
        int expRes = list.size();
        int actRes = 8;
        assertEquals(expRes, actRes);
    }

    @Test
    public void sizeForEmpty() {
        MyLinkedList list = new MyLinkedList();
        int expRes = list.size();
        int actRes = 0;
        assertEquals(expRes, actRes);
    }

    @Test
    public void isEmptyTrue() {
        MyLinkedList list = new MyLinkedList();
        assertFalse(!list.isEmpty());
    }

    @Test
    public void isEmptyFalse() {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        assertFalse(list.isEmpty());
    }

    @Test
    public void clearNotEmpty() {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();
        assertFalse(!list.isEmpty());
    }

    @Test
    public void clearEmpty() {
        MyLinkedList list = new MyLinkedList();
        list.clear();
        assertFalse(!list.isEmpty());
    }

    @Test
    public void toArrayRandom() {
        MyLinkedList list = new MyLinkedList();
        Object mas[] = {1, 2, 3, 4, 5, 6, 7};
        list.addAll(mas);

        Object expRes[] = list.toArray();
        Object actRes[] = {1, 2, 3, 4, 5, 6, 7};
        assertArrayEquals(expRes, actRes);
    }

    @Test
    public void toArray() {
        MyLinkedList list = new MyLinkedList();
        Object mas[] = {1, 3, 5};
        list.addAll(mas);
        Object expRes[] = list.toArray();
        Object actRes[] = {1, 3, 5};
        assertArrayEquals(expRes, actRes);
    }

    @Test
    public void toStringRandom() {
        MyLinkedList list = new MyLinkedList();
        Object mas[] = {1, 2, 3, 4, 5, 6, 7};
        list.addAll(mas);
        String expRes = list.toString();
        String actRes = "1,2,3,4,5,6,7";
        assertEquals(expRes, actRes);
    }

    @Test
    public void toStringEmptyList() {
        MyLinkedList list = new MyLinkedList();
        String expRes = list.toString();
        String actRes = "";
        assertEquals(expRes, actRes);
    }

    @Test(expected = NotEnoughIndexException.class)
    public void removeFirstForEmpty() {
        MyLinkedList list = new MyLinkedList();
        list.removeFirst();
    }

    @Test
    public void removeFirstRandom() {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        Object expRes = list.removeFirst();
        Integer actRes = Integer.valueOf(1);
        assertEquals(expRes, actRes);
    }

    @Test(expected = NotEnoughIndexException.class)
    public void removeLastForEmpty() {
        MyLinkedList list = new MyLinkedList();
        list.removeLast();
    }

    @Test
    public void removeLast() {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        Object expRes = list.removeLast();
        Integer actRes = Integer.valueOf(2);
        assertEquals(expRes, actRes);
    }

    @Test
    public void addFirst() {
        MyLinkedList list = new MyLinkedList();
        Object mas[] = {1, 2, 3};
        list.addAll(mas);
        list.addFirst(0);
        Object expRes = list.getFirstNode().getData();
        Integer actRes = Integer.valueOf(0);
        assertEquals(expRes, actRes);
    }

    @Test
    public void addFirstCheckProporties() {
        MyLinkedList list = new MyLinkedList();
        Object mas[] = {1, 2, 3};
        list.addAll(mas);
        list.addFirst(0);
        Object expRes = list.getFirstNode().getNext().getData();
        Integer actRes = Integer.valueOf(1);
        assertEquals(expRes, actRes);
    }

    @Test
    public void addLast() {
        MyLinkedList list = new MyLinkedList();
        Object mas[] = {1, 2, 3};
        list.addAll(mas);
        list.addLast(4);
        Object expRes = list.getLastNode().getData();
        Integer actRes = Integer.valueOf(4);
        assertEquals(expRes, actRes);
    }

    @Test
    public void getLast() {
        MyLinkedList list = new MyLinkedList();
        Object mas[] = {1, 2, 3};
        list.addAll(mas);
        Object expRes = list.getLast();
        Integer actRes = Integer.valueOf(3);
    }

    @Test
    public void getFirst() {
        MyLinkedList list = new MyLinkedList();
        Object mas[] = {1, 2, 3};
        list.addAll(mas);
        Object expRes = list.getFirst();
        Integer actRes = Integer.valueOf(1);
    }
}
