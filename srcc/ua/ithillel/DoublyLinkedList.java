package ua.ithillel;

import java.util.Objects;

public class DoublyLinkedList<E> implements CustomList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        public Node(E element, Node<E> next, Node<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }


    public void addFirst(E element) {
        Node<E> newNode = new Node<E>(element, head, null);
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(E element) {
        Node<E> newNode = new Node<E>(element, null, tail);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = newNode;
        }
        size++;
    }

    public void addAtPos(int index, E element) {
        Objects.checkIndex(index, size);
        if (index < 0 || index > this.size()) {
            throw new IllegalArgumentException("Invalid Index");
        } else if (index == 0) {
            this.addFirst(element);
        } else if (index == this.size()) {
            this.add(element);
        } else {
            Node<E> newNode = new Node<E>(element, head, tail);
            Node<E> currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode;
            newNode.prev = currentNode.prev;
            currentNode.prev = newNode;
            newNode.prev.next = newNode;
            size++;
        }
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.element;
    }

    @Override
    public boolean remove(int index) {
        Objects.checkIndex(index, size);
        if (index < 0 || index > this.size()) {
            throw new IllegalArgumentException("Invalid Index");
        } else if (index == 0) {
            this.removeFirst();
        } else if (index == this.size() - 1) {
            this.removeLast();
        } else {
            Node<E> currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;
            size--;
        }
        return true;
    }

    public void removeFirst() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
        } else {
            if (head.next == null) {
                tail = null;
            } else {
                head.next.prev = null;
            }
            head = head.next;
            size--;
        }
    }

    public void removeLast() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
        } else {
            if (head.next == null) {
                head = null;
            } else {
                tail.prev.next = null;
            }
            tail = tail.prev;
            size--;
        }
    }

    public void iterateForward() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node<E> currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.element);
            currentNode = currentNode.next;
        }
    }

    public void iterateBackward() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node<E> currentNode = tail;
        while (currentNode != null) {
            System.out.println(currentNode.element);
            currentNode = currentNode.prev;
        }
    }
}
