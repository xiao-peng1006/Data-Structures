public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    /**
     *
     * @param capacity
     *
     * LoopQueue constructor, add one more space for loop structure use
     */
    public LoopQueue(int capacity) {
        data = (E[])new Object[capacity+1];
        front = 0;
        tail = 0;
        size = 0;
    }

    /**
     *
     */
    public LoopQueue() {
        this(10);
    }

    /**
     *
     * @return the value of capacity of the queue
     */
    public int getCapacity() {
        return data.length - 1;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     *
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     *
     * @param e
     *
     * add element at the tail of the queue
     */
    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front)
            resize(getCapacity() * 2);

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     *
     * @return pop the first element at the front of the queue
     */
    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);

        return ret;
    }

    /**
     *
     * @return get the first element at the front of the queue
     */
    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        return data[front];
    }

    /**
     *
     * @param newCapacity
     *
     * create an new array with new value of capacity and copy over all the data from the old array
     */
    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }

        data = newData;
        front = 0;
        tail = size;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size = %d, capacity = %d\n", size, getCapacity()));
        sb.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if ((i + 1) % data.length != tail)
                sb.append(',');
        }
        sb.append("] tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
