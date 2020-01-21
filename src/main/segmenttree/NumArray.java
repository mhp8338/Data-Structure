package segmenttree;

/**
 * @tag: DataStructure
 * @author: mhp
 * @createDate: 2020/1/20
 * @description:
 */
public class NumArray {
    private SegmentTree<Integer> segmentTree;
    public NumArray(int[] nums) {
        if(nums.length!=0){
            Integer[] arr = new Integer[nums.length];
            for(int i = 0; i<nums.length;i++){
                arr[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(arr,Integer::sum);
        }

    }

    public void update(int i, int val) {
        if(segmentTree == null){
            throw new IllegalArgumentException("Error");
        }
        segmentTree.set(i,val);
    }

    public int sumRange(int i, int j) {
        return segmentTree.query(i,j);
    }


}
