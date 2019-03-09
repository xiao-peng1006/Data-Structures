public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    public Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     *
     * @return number of elements in the linkedlist
     */
    public int getSize() {
        return size;
    }

    /**
     *
     * @return boolean if the linkedlist is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *
     * @param index
     * @param e
     *
     * add element at index location (start from 0)
     */
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        prev.next = new Node(e, prev.next);

        size++;
    }

    /**
     * 
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     *
     */
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Illegal Index.");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        return cur.e;
    }

    /**
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Illegal Index.");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        cur.e = e;
    }

    /**
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    /**
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Illegal Index.");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;

        return delNode.e;
    }

    /**
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            sb.append(cur + "->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
