package segmenttree;


/**
 * @tag: DataStructure
 * @author: mhp
 * @createDate: 2020/1/19
 * @description:
 */
public class SegmentTree<E> {
    private E[] data;
    private E[] tree;
    private IMerge<E> iMerge;

    public SegmentTree(E[] arr, IMerge<E> iMerge) {
        this.iMerge = iMerge;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, arr.length - 1);
    }


    /**
     * @param treeIndex 在treeIndex位置创建区间为[l,r]线段树
     * @param l         left
     * @param r         right
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {


        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int mid = l + (r - l) / 2;
        int leftIndex = leftChild(treeIndex);
        int rightIndex = rightChild(treeIndex);
        buildSegmentTree(leftIndex, l, mid);
        buildSegmentTree(rightIndex, mid + 1, r);
        tree[treeIndex] = iMerge.merge(tree[leftIndex], tree[rightIndex]);

    }

    public int getSize() {
        return data.length;
    }

    public E getIndex(int index) {
        if (index < 0 || index > data.length) {
            throw new IllegalArgumentException("index is illegal");
        }
        return data[index];
    }

    /**
     * 查询[queryL,queryR]的值
     *
     * @param queryL 左索引
     * @param queryR 右索引
     * @return 返回merge的值
     */
    public E query(int queryL, int queryR) {
        /*保护*/
        if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR) {
            throw new IllegalArgumentException("Query Failure,Argument Is Illegal");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    /**
     * 查找以index为根线段树，对应区间为[l,r]的范围里，搜索[queryL,queryR]的值
     *
     * @param index  根结点索引
     * @param l      线段树的左区间
     * @param r      线段树的右区间
     * @param queryL 目标区域的左区间
     * @param queryR 目标区域的右区间
     * @return 返回值
     */
    private E query(int index, int l, int r, int queryL, int queryR) {
        /*递归终止条件*/
        if (l == queryL && r == queryR) {
            return tree[index];
        }
        int rightIndex = rightChild(index);
        int leftIndex = leftChild(index);
        /*如果左右区间直接包含目标区域*/
        int mid = l + (r - l) / 2;
        if (queryL >= mid + 1) {
            return query(rightIndex, mid + 1, r, queryL, queryR);
        }
        if (queryR <= mid) {
            return query(leftIndex, l, mid, queryL, queryR);
        }
        /*如果目标区域需要组合左右两个区域，才能得到结果*/
        E leftResult = query(leftIndex, l, mid, queryL, mid);
        E rightResult = query(rightIndex, mid + 1, r, mid + 1, queryR);
        return iMerge.merge(leftResult, rightResult);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("index is illegal");
        }
        /*改变存储数据数组data的值*/
        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    /**
     * 在以treeIndex为根的线段树更新index值为e
     *
     * @param treeIndex 线段树根的index
     * @param l         left
     * @param r         right
     * @param index     插入的index
     * @param e         值
     */
    private void set(int treeIndex, int l, int r, int index, E e) {
        /*递归中止，此时直接赋值*/
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }

        /*递归过程，找到中止后，由下往上更新*/
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int mid = l + (r - l) / 2;
        if (index >= mid + 1) {
            set(rightTreeIndex, mid + 1, r, index, e);
        } else {//index <= mid
            set(leftTreeIndex, l, mid, index, e);
        }
        tree[treeIndex] = iMerge.merge(tree[leftTreeIndex], tree[rightTreeIndex]);

    }


    public int leftChild(int index) {
        return index * 2 + 1;
    }

    public int rightChild(int index) {
        return index * 2 + 2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                sb.append(tree[i]);
            } else {
                sb.append("NULL");
            }

            if (i != tree.length - 1) {
                sb.append(", ");
            }

        }
        return sb.toString();
    }
}
