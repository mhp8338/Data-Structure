package unionfind;

/**
 * @tag: DataStructure
 * @author: mhp
 * @createDate: 2020/1/26
 * @description: quick union
 * 利用提高find效率，减少树高度
 */
public class UnionFind4 implements IUnionFind {

    /**
     * 记录parent[i]指向第i元素对应的父亲节点
     */
    private int[] parent;

    /**
     * rank[i]为每棵树的高度
     */
    private int[] rank;

    public UnionFind4(int size) {
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
     * @return 返回的树的根结点节点
     */
    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is illegal argument");
        }
        /*当p的父亲节点不指向自己的时候，找他的父亲*/
        while (parent[p] != p) {
            p = parent[p];
        }
        return p;
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
