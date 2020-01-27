package unionfind;

/**
 * @tag: DataStructure
 * @author: mhp
 * @createDate: 2020/1/26
 * @description: quick union
 * 利用size提高find效率，减少树高度
 */
public class UnionFind3 implements IUnionFind {

    /**
     * 记录parent[i]指向第i元素对应的父亲节点
     */
    private int[] parent;

    /**
     * count[i]为每一个树的节点数
     */
    private int[] count;

    public UnionFind3(int size) {
        parent = new int[size];
        count = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            count[i] = 1;
        }
    }

    /**
     * O(h)
     * @param p 待查节点
     * @return 返回的树的根结点节点
     */
    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is illegal argument");
        }
        /*当 p的父亲节点不指向自己的时候，找他的父亲*/
        while (parent[p] != p){
            p = parent[p];
        }
        return p;
    }

    @Override
    public int getSize(){
        return parent.length;
    }

    @Override
    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    /**
     * @param p 编号p对应的集合
     * @param q 编号q对应的集合
     * time space: O(h)
     */
    @Override
    public void unionElements(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot){
            return;
        }

        if(count[pRoot]<count[qRoot]){
            parent[pRoot] = qRoot;
            count[qRoot] += count[pRoot];
        }else{
            /*pRoot子节点数量大于qRoot*/
            parent[qRoot] = pRoot;
            count[pRoot] += count[qRoot];
        }

    }
}
