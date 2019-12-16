package binarysearchtree;

import org.junit.Test;

import static org.junit.Assert.*;

public class BSTTest {
    @Test
    public void bst_add_proOrder_test(){
        int[] nums = {5,3,6,8,4,2};
        BST<Integer> bst = new BST<>();
        for (int num : nums) {
            bst.add(num);
        }
        bst.preOrder();
    }

    @Test
    public void bst_to_string_test(){
        int[] nums = {5,3,6,8,4,2};
        BST<Integer> bst = new BST<>();
        for (int num : nums) {
            bst.add(num);
        }
        System.out.println(bst);
    }

}