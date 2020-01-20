package segmenttree;

import org.junit.Test;

/**
 * @tag: DataStructure
 * @author: mhp
 * @createDate: 2020/1/19
 * @description:
 */
public class SegmentTreeTest {
    private Integer[] nums =  {-2, 0, 3, -5, 2, -1};
    private SegmentTree<Integer> segmentTree;



    @Test
    public void build_segment_tree_test(){
        segmentTree = new SegmentTree<>(nums, Integer::sum);
        System.out.println(segmentTree);
    }

    @Test
    public void query_test(){
        segmentTree = new SegmentTree<>(nums, Integer::sum);
        System.out.println(segmentTree.query(0,5));
    }


}
