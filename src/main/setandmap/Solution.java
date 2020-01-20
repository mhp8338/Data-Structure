package setandmap;

import java.util.*;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.floor(nums[i]+t)!=null&&set.floor(nums[i]+t)>=nums[i]-t){
                return true;
            }
            set.add(nums[i]);
            if(set.size()==k+1){
                set.remove(nums[i-k]);
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[] nums = {0,2147483647};
        System.out.println(Math.pow(2, 3));
        Map<Integer,String> map  = new HashMap<>();
        map.put(1,"a");
        System.out.println(map.getOrDefault(0, "s"));
        Queue queue = new LinkedList();
    }

}
