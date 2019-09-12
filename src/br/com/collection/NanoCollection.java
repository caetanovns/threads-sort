package br.com.collection;

import java.util.Iterator;

public class NanoCollection<E> implements Iterable<E> {

    Node<E> head;
    Integer counter = 0;

    public class Node<E> implements Iterator<E>, Comparable<Node> {
        public E data;
        public Node next;
        Node previous;

        Node<E> current;

        Node(E e) {
            this.data = e;
        }

        public Node(Node<E> head) {
            this.current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            Node tmp = current;
            current = current.next;
            return (E) tmp.data;
        }

        @Override
        public int compareTo(Node e) {
            if ((int) this.data > (int) e.data) {
                return 1;
            } else if ((int) this.data == (int) e.data) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Node<E>(head);
    }

    public void add(E node) {
        Node new_node = new Node(node);
        new_node.next = null;
        if (head == null) {
            head = new_node;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        counter++;
    }

    public boolean forward(Node<E> node) {
        if (node.next == null)
            return false;

        E e = (E) node.next.data;
        node.next.data = node.data;
        node.data = e;
        return true;
    }

    public void swap(Node<E> node1, Node<E> node2) {
        E dataTemp = node1.data;
        node1.data = node2.data;
        node2.data = dataTemp;
    }

    public int size() {
        return counter;
    }

    public Node<E> get(int index) throws NullPointerException {
        try {
            Node<E> node = head;
            while (index > 0) {
                node = node.next;
                index -= 1;
            }
            return node;
        } catch (Exception e) {
            throw new NullPointerException("Invalid Index");
        }

    }

}
