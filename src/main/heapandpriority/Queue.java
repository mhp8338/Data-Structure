package heapandpriority;

/**
 * @tag: DataStructure
 * @author: mhp
 * @createDate: 2020/1/14
 * @description:
 */
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
