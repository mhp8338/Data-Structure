package heapandpriority;

/**
 * @tag: DataStructure
 * @author: mhp
 * @createDate: 2020/2/25
 * @description:
 */
public class IndexMaxHeap<E extends Comparable<E>> {
    private Array<E> data;
    private int[] indexes;
    public IndexMaxHeap() {
        data = new Array<>();
    }

    public IndexMaxHeap(int capacity) {
        data = new Array<>(capacity);
        indexes = new int[capacity];
    }

    /**
     * heapify:传入一个数组，将其转换为堆
     * time: O(n)
     * 从第一个不是叶子节点的节点起，到堆顶节点，分别做siftdown操作
     *
     * @param arr 输入数组
     */
    public IndexMaxHeap(E[] arr) {
        data = new Array<E>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    /**
     * @return 堆中元素个数
     */
    public int size() {
        return data.getSize();
    }

    /**
     * @return 堆中是否为空
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * @param index index
     * @return 父亲节点所在的索引
     */
    public int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent");
        }
        return (index - 1) / 2;
    }

    /**
     * @param index index
     * @return 左孩子节点所在的索引
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * @param index index
     * @return 返回右孩子节点所在的索引
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 向堆中添加元素
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Can't find max,heap is empty");
        }
        return data.get(0);
    }

    /**
     * 找到最后的元素，与最大的元素交换位置，然后删除最后一个元素，
     * 目的是维持堆的定义
     * 最后#sift down()将其放入应该放入的位置
     *
     * @return max value
     */
    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    /**
     * sift down
     */
    private void siftDown(int k) {
        /*当有左孩子的时候=>下沉操作
         * 因为有左右一个即可，不一定有右,但一定有左元素
         * 找到左右孩子最大的那个*/
        while (leftChild(k) < size()) {
            /*
             * 有左孩子进入循环
             * */
            int j = leftChild(k);
            /*j+1<size()表示有右孩子,右孩子比左孩子大，找到最大的比较*/
            if (j + 1 < size() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j++;
            }
            /*
            data[k]比data[j]大
            data比左右子孩子的值都大
            说明位置正确
            */
            if (data.get(j).compareTo(data.get(k)) < 0) {
                break;
            }
            /*比左小：右向上合理
             * 比右小，比左大：右向上合理*/
            /*交换值*/
            data.swap(k, j);
            /*下降索引继续找*/
            k = j;
        }
    }



    /**
     * 取出堆的最大元素，换成e
     * 注意：此时e不一定满足堆的性质
     *
     * @param e 待替换的元素
     * @return 取出的与元素
     */
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }
}
