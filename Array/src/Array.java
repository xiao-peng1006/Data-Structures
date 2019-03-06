public class Array<E> {

    private E[] data;
    private int size;

    /**
     *
     * @param capacity
     *
     * Class constructor: Use inputted capacity value to construct the array
     */
    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    /**
     *  No input paramter constructor
     */
    public Array() {
        this(10);
    }

    /**
     *
     * @return number of elements in the array
     */
    public int getSize() {
        return size;
    }

    /**
     *
     * @return total capacity of the array
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     *
     * @return boolean if the array is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *
     * @param index
     * @param e
     *
     * Insert an element at index position
     */
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add Failed. Require index >= 0 and <= size.");

        if (size == data.length)
            resize(2*data.length);

        for (int i = size-1; i >= index; i--) {
            data[i+1] = data[i];
        }

        data[index] = e;
        size++;
    }

    /**
     *
     * @param e
     *
     * add an element e after all elements in the array
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     *
     * @param e
     *
     * add an element e before all elements in the array
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     *
     * @param index
     * @return element at position of index
     */
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal");
        return data[index];
    }

    /**
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal");
        data[index] = e;
    }

    /**
     *
     * @param e
     * @return boolean if there is element e in the array
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    /**
     *
     * @param e
     * @return the position of element e, if not found, return -1
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    /**
     *
     * @param index
     * @return removed element at position of index
     */
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal");
        E ret = data[index];
        for (int i = index+1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;
        data[size] = null; /* loitering object != memory leak */

        if (size == data.length/4 && data.length/2 != 0)
            resize(data.length/2);
        return ret;
    }

    /**
     *
     * @return remove element at first position of the array
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     *
     * @return remove element at last position of the array
     */
    public E removeLast(){
        return remove(size-1);
    }

    /**
     *
     * @param e
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1)
                sb.append(',');
        }
        sb.append(']');
        return sb.toString();
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

}
