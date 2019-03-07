public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    /**
     *
     * @param capacity
     */
    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    /**
     *
     */
    public ArrayStack() {
        array = new Array<>();
    }

    /**
     *
     * @return the size of the stack
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     *
     * @return if the stack is empty or not
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     *
     * @return the capacity of the stack
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    /**
     *
     * @param e
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     *
     * @return first item in the stack and remove it from the stack
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     *
     * @return first item in the stack
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: ");
        sb.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            sb.append(array.get(i));
            if (i != array.getSize()-1)
                sb.append(", ");
        }
        sb.append("] top");
        return sb.toString();
    }


}
