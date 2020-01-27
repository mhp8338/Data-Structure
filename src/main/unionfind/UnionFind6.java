package unionfind;

/**
 * @tag: DataStructure
 * @author: mhp
 * @createDate: 2020/1/26
 * @description: quick union
 * 路径压缩，一步到位，令树的高度退化为最低(2)
 * time space: O(log*n)
 */
public class UnionFind6 implements IUnionFind {

    /**
     * 记录parent[i]指向第i元素对应的父亲节点
     */
    private int[] parent;

    /**
     * rank[i]为每棵树的层级关系
     */
    private int[] rank;

    public UnionFind6(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    /**
     * O(h)
     *
     * @param p 待查节点
     * @return 返回p所在树的根结点
     */
    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is illegal argument");
        }
        /*找父亲所在树的根结点，并指向该根结点*/
        if (parent[p] != p) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }

        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]) {
            /*pRoot子节点数量大于qRoot*/
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot] ++;
        }

    }
}
