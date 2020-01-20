package segmenttree;

/**
 * @tag: DataStructure
 * @author: mhp
 * @createDate: 2020/1/19
 * @description:
 */
public interface IMerge<E> {
    /**
     * 合并两个子树的
     * @param a E a
     * @param b E b
     * @return 返回业务操作的值
     */
    E merge(E a, E b);

}
