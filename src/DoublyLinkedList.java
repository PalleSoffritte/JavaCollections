public class DoublyLinkedList<T> {
    private DoubleNode<T> head;
    private DoubleNode<T> tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addAtEnd(T value) {
        DoubleNode<T> n = new DoubleNode<>(tail, value, null);
        if (isEmpty()) {
            head = tail = n;
        } else {
            tail.setNext(n);
            n.setPrev(tail);
            tail = n;
        }
    }

    public void addAtFront(T value) {
        DoubleNode<T> n = new DoubleNode<>(null, value, head);
        if (isEmpty()) {
            head = tail = n;
        } else {
            head.setPrev(n);
            n.setNext(head);
            head = n;
        }
    }

    public T removeFromFront() {
        if (isEmpty()) {
            return null;
        }
        T value = head.getC();
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.getNext();
            if (head != null) head.setPrev(null);
        }
        return value;
    }

    public T removeFromEnd() {
        if (isEmpty()) {
            return null;
        }
        T value = tail.getC();
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.getPrev();
            if (tail != null) tail.setNext(null);
        }
        return value;
    }

    public int countNodes() {
        DoubleNode<T> cn = head;
        int count = 0;
        while (cn != null) {
            count++;
            cn = cn.getNext();
        }
        return count;
    }

    public boolean deleteValue(T value) {
        DoubleNode<T> cn = head;
        while (cn != null && (cn.getC() == null ? value != null : !cn.getC().equals(value))) {
            cn = cn.getNext();
        }

        if (cn == null) {
            return false;
        }

        if (cn.getPrev() == null) {
            head = cn.getNext();
            if (head != null) head.setPrev(null);
            if (head == null) tail = null;
        } else if (cn.getNext() == null) {
            tail = cn.getPrev();
            if (tail != null) tail.setNext(null);
            if (tail == null) head = null;
        } else {
            cn.getPrev().setNext(cn.getNext());
            cn.getNext().setPrev(cn.getPrev());
        }

        return true;
    }

    @Override
    public String toString() {
        DoubleNode<T> cn = head;
        StringBuilder str = new StringBuilder();
        while (cn != null) {
            str.append(cn.getC());
            cn = cn.getNext();
        }
        return str.toString();
    }

    public void reverse() {
        DoubleNode<T> cn = head;
        DoubleNode<T> tmp = null;
        while (cn != null) {
            tmp = cn.getNext();
            cn.setNext(cn.getPrev());
            cn.setPrev(tmp);
            cn = cn.getPrev();
        }
        tmp = head;
        head = tail;
        tail = tmp;
        if (head != null) head.setPrev(null);
        if (tail != null) tail.setNext(null);
    }
}