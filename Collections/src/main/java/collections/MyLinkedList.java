package ua.yandex.collections;

import java.util.*;

public class MyLinkedList implements MyList {

    private Node first;
    private Node last;
    private int size;

    private boolean checkIndex(int index) throws NotEnoughIndexException {
        if (index < 0 || index > size) {
            throw new NotEnoughIndexException();
        }
        return true;
    }

    private Node getNode(int index) {
        checkIndex(index);
        Node tempNode = first;
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.getNext();
        }
        return tempNode;
    }

    public int size() {
        return this.size;
    }

    public Node getFirstNode() {
        return this.first;
    }

    public Node getLastNode() {
        return this.last;
    }

    public Object get(int index) {
        checkIndex(index);
        Node tempNode = getNode(index);
        return tempNode.getData();
    }

    public void add(Object e) {
        Node tempNode = new Node(e, null, null);
        if (size == 0) {
            first = tempNode;
            last = tempNode;
            this.size = 1;
        } else {
            tempNode.setPrev(last);
            last.setNext(tempNode);
            last = tempNode;
            size++;
        }
    }

    public void add(int index, Object elem) {
        checkIndex(index);
        Node nextNode = getNode(index);
        Node newNode = new Node(elem, nextNode, nextNode.getPrev());
        if (newNode.getPrev() != null) {
            newNode.getPrev().setNext(newNode);
        }
        if (newNode.getNext() != null) {
            newNode.getNext().setPrev(newNode);
        }
        size++;
        if (index == 1) {
            first = newNode;
        }
    }

    public void addAll(Object c[]) {
        for (int i = 0; i < c.length; i++) {
            this.add(c[i]);
        }
    }

    public void addAll(int index, Object c[]) throws NotEnoughIndexException {
        checkIndex(index);
        Node nextNode = getNode(index);
        for (int i = 0; i < c.length; i++) {
            Node newNode = new Node(c[i], null, null);
            if (nextNode.getPrev() != null) {
                newNode.setPrev(nextNode.getPrev());
                newNode.getPrev().setNext(newNode);
            }
            newNode.setNext(nextNode);
            newNode.getNext().setPrev(newNode);
            size++;
        }
    }

    public Object remove(int index) {
        checkIndex(index);
        Node removeNode = getNode(index);
        Object res = removeNode.getData();
        removeNode.setData(null);
        if (removeNode.getPrev() != null) {
            removeNode.getPrev().setNext(removeNode.getNext());
        } else {
            this.first = removeNode.getNext();
        }
        if (removeNode.getNext() != null) {
            removeNode.getNext().setPrev(removeNode.getPrev());
        } else {
            this.last = removeNode.getPrev();
        }
        size--;
        return res;
    }

    public void set(int index, Object e) {
        checkIndex(index);
        Node setNode = getNode(index);
        setNode.setData(e);
    }

    public int indexOf(Object obj) {
        Node present = first;
        for (int i = 1; i < size + 1; i++) {
            if (present.getData().equals(obj)) {
                return i;
            }
            present = present.getNext();
        }
        return -1;
    }

    public void clear() {
        Node present = first;
        while (size != 0) {
            remove(0);
        }
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public Object[] toArray() {
        Object result[] = new Object[size];
        Node present = first;
        for (int i = 0; i < size; i++) {
            result[i] = present.getData();
            present = present.getNext();
        }
        return result;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        if (first != null) {
            Node present = this.first;
            for (int i = 0; i < this.size - 1; i++) {
                result.append(present.getData() + ",");
                present = present.getNext();
            }
            result.append(present.getData());

        }
        return result.toString();
    }

    public Object removeFirst() {
        if (this.size == 0) {
            throw new NotEnoughIndexException();
        } else {
            Node remove = first;
            Object result = remove.getData();
            remove.setData(null);
            first = remove.getNext();
            remove.getNext().setPrev(null);
            size--;
            return result;
        }
    }

    public Object removeLast() {
        if (size == 0) {
            throw new NotEnoughIndexException();
        } else {
            Node remove = last;
            Object result = remove.getData();
            remove.getPrev().setNext(null);
            remove.setData(null);
            last = remove.getPrev();
            size--;
            return result;
        }
    }

    public void addFirst(Object elem) {
        Node newNode = new Node(elem, first, null);
        first.setPrev(newNode);
        first = newNode;
        size++;
    }

    public void addLast(Object elem) {
        Node newNode = new Node(elem, null, last);
        last.setNext(newNode);
        last = newNode;
        size++;
    }

    public Object getFirst() {
        return this.first.getData();
    }

    public Object getLast() {
        return this.last.getData();
    }
}
