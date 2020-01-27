package unionfind;

/**
 * @tag: DataStructure
 * @author: mhp
 * @createDate: 2020/1/26
 * @description:
 */
public interface IUnionFind {
    /**
     * 两集合的并集
     * @param p 编号p对应的集合
     * @param q 编号q对应的集合
     */
    void unionElements(int p, int q);

    /**
     * 是否连接
     * @param p 编号p的集合
     * @param q 编号q的集合
     * @return 是否连接
     */
    boolean isConnected(int p, int q);

    /**
     * 元素数
     * @return #大小
     */
    int getSize();

}

