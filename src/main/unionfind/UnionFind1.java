package unionfind;

/**
 * @tag: DataStructure
 * @author: mhp
 * @createDate: 2020/1/26
 * @description: quick find
 * 由于底层集合映射是数组，所以find操作O(1)
 */
public class UnionFind1 implements IUnionFind {
    /**
     * 数组模拟并查集
     * 第i个元素属于id[i]集合
     * */
    private int[] id;

    public UnionFind1(int n){
        id = new int[n];

        /*初始化,每个id[i]指向自己*/
        for(int i=0;i<n;i++){
            id[i] = i;
        }
    }

    @Override
    public int getSize(){
        return id.length;
    }


    /**
     * @param p 编号p对应的集合
     * @param q 编号q对应的集合
     * union操作需要O(n)时间复杂度
     */
    @Override
    public void unionElements(int p, int q){
        int pID = find(p);
        int qID = find(q);

        if(pID == qID){
            return;
        }

        for(int i=0;i<id.length;i++){
            if(find(i) == pID){
                /*设置对应集合*/
                id[i] = qID;
            }
        }
    }

    /**
     * @param p 编号p的集合
     * @param q 编号q的集合
     * @return is connected
     * time space:O(n)
     */
    @Override
    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    /**
     * @param p p
     * @return 对应所属的集合
     * TIME SPACE:O(1)
     */
    private int find(int p){
        return id[p];
    }
}
