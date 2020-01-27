package unionfind;

import java.util.Random;

/**
 * @tag: DataStructure
 * @author: mhp
 * @createDate: 2020/1/26
 * @description:
 */
public class Main {
    /**
     * 测试并查集的效率
     *
     * @param iUnionFind 并查集的几种实现方式
     * @param n          测试次数
     * @return 耗费时间
     */
    private static double test(IUnionFind iUnionFind, int n) {
        int size = iUnionFind.getSize();
        double startTime = System.nanoTime();
        Random random = new Random();
        /*测试与元素合并*/
        for (int i = 0; i < n; i++) {
            int p = random.nextInt(size);
            int q = random.nextInt(size);
            iUnionFind.unionElements(p, q);
        }

        /*测试两个元素是否为同一集合的效率*/
        for (int i = 0; i < n; i++) {
            int p = random.nextInt(size);
            int q = random.nextInt(size);
            iUnionFind.isConnected(p, q);
        }
        double endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int size = 10000000;
        int n = 10000000;
/*
        System.out.println("UnionFind1 cost:" + test(new UnionFind1(size), n));
        System.out.println("UnionFind2 cost:" + test(new UnionFind2(size), n));
*/
        System.out.println("UnionFind3 cost:" + test(new UnionFind3(size), n) + " s.");
        System.out.println("UnionFind4 cost:" + test(new UnionFind4(size), n) + " s.");
        System.out.println("UnionFind5 cost:" + test(new UnionFind5(size), n) + " s.");
        System.out.println("UnionFind6 cost:" + test(new UnionFind6(size), n) + " s.");

    }
}
