import java.util.*;

public class TwoWayLinkedList<E> extends AbstractSequentialList<E> {
    private Node<E> head, tail;
    private int size = 0;

    public TwoWayLinkedList() {}

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> previous;

        public Node(E element) {
            this.element = element;
        }
    }

    private class TwoWayListIterator implements ListIterator<E> {
        private Node<E> current = head;
        private Node<E> lastReturned = null;
        private int index = 0;

        public TwoWayListIterator() {}

        public TwoWayListIterator(int index) {
            current = head;
            for (int i = 0; i < index && current != null; i++) {
                current = current.next;
            }
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            lastReturned = current;
            E element = current.element;
            current = current.next;
            index++;
            return element;
        }

        @Override
        public boolean hasPrevious() {
            return current != null && current.previous != null;
        }

        @Override
        public E previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            current = current.previous;
            lastReturned = current;
            index--;
            return current.element;
        }

        @Override
        public int nextIndex() {
            return index;
        }

        @Override
        public int previousIndex() {
            return index - 1;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(E e) {
            if (lastReturned == null)
                throw new IllegalStateException();
            lastReturned.element = e;
        }

        @Override
        public void add(E e) {
            Node<E> newNode = new Node<>(e);
            if (head == null) {
                head = tail = newNode;
            } else if (current == head) {
                newNode.next = head;
                head.previous = newNode;
                head = newNode;
            } else if (current == null) {
                tail.next = newNode;
                newNode.previous = tail;
                tail = newNode;
            } else {
                Node<E> prev = current.previous;
                newNode.next = current;
                newNode.previous = prev;
                current.previous = newNode;
                if (prev != null) prev.next = newNode;
            }
            size++;
            index++;
            lastReturned = null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new TwoWayListIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new TwoWayListIterator(index);
    }

    // Optional: toString() for debugging
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;
        while (current != null) {
            result.append(current.element);
            current = current.next;
            if (current != null) result.append(", ");
        }
        return result.append("]").toString();
    }

    // You can test it like this:
    public static void main(String[] args) {
        TwoWayLinkedList<Integer> list = new TwoWayLinkedList<>();
        list.addAll(Arrays.asList(1, 2, 3, 4, 5));

        System.out.println("Forward:");
        ListIterator<Integer> iter = list.listIterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }

        System.out.println("\nBackward:");
        while (iter.hasPrevious()) {
            System.out.print(iter.previous() + " ");
        }
    }
}
