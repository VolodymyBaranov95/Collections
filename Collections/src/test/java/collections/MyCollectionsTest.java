package ua.yandex.collections;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import java.text.*;

public class MyCollectionsTest {

    @Test
    public void reverseList() {
        MyLinkedList list = new MyLinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        MyCollections.reverse(list);
        String expRes = list.toString();
        String actRes = "d,c,b,a";
        assertEquals(expRes, actRes);
    }

    @Test
    public void reverseArray() {
        MyArrayList list = new MyArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        MyCollections.reverse(list);
        String actRes = "d,c,b,a";
        String expRes = list.toString();
        assertEquals(actRes, expRes);
    }

    @Test
    public void binarySearchFound() {
        MyArrayList list = new MyArrayList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        int expRes = MyCollections.binarySearch(list, 20);
        int actRes = 1;
        assertEquals(actRes, expRes);
    }

    @Test
    public void binarySearchNotFound() {
        MyArrayList list = new MyArrayList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        int expRes = MyCollections.binarySearch(list, 35);
        int actRes = -4;
        assertEquals(actRes, expRes);
    }

    @Test
    public void binarySearchWithCollatorFound() {
        MyArrayList list = new MyArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        int expRes = MyCollections.binarySearch(list, "b", Collator.getInstance());
        int actRes = 1;
        assertEquals(expRes, actRes);
    }

    @Test
    public void binarySearchWithCollatorNotFound() {
        MyArrayList list = new MyArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("e");
        int expRes = MyCollections.binarySearch(list, "d", Collator.getInstance());
        int actRes = -4;
        assertEquals(expRes, actRes);
    }
}
