package setandmap;

/**
 * @author xuepipi
 */
public interface ISet<E> {
    /**
     * not add the same element
     * @param e e
     */
    void add(E e);

    /**
     * remove the elements
     * @param e e
     */
    void remove(E e);

    /**
     * contains e
     * @param e e
     * @return true or false
     */
    boolean contains(E e);

    /**
     * get size
     * @return size
     */
    int getSize();

    /**
     * empty
     * @return true or false
     */
    boolean isEmpty();

}
