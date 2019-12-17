package binarysearchtree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

public class BSTTest {
    @Test
    public void bst_add_proOrder_test() {
        BST<Integer> bst = getIntegerBST();
        bst.preOrder();
    }

    @Test
    public void bst_add_proOrder_not_cursive_test() {
        BST<Integer> bst = getIntegerBST();
        bst.preOrderNR();
    }

    private BST<Integer> getIntegerBST() {
        int[] nums = {5, 3, 6, 8, 4, 2};
        BST<Integer> bst = new BST<>();
        for (int num : nums) {
            bst.add(num);
        }
        return bst;
    }
    /////////////////
    //      5      //
    //    /   \    //
    //   3    6    //
    //  / \    \   //
    // 2  4     8  //
    /////////////////

    @Test
    public void bst_to_string_test() {
        BST<Integer> bst = getIntegerBST();
        System.out.println(bst);
    }

    @Test
    public void bst_inOrder_test() {
        BST<Integer> bst = getIntegerBST();
        bst.inOrder();
    }

    @Test
    public void bst_postOrder_test() {
        BST<Integer> bst = getIntegerBST();
        bst.postOrder();
    }

    @Test
    public void bst_levelOrder_test() {
        BST<Integer> bst = getIntegerBST();
        bst.levelOrder();
    }

    @Test
    public void bst_minimum_test() {
        BST<Integer> bst = getIntegerBST();
        System.out.println(bst.minimum());
    }

    @Test
    public void bst_maximum_test() {
        BST<Integer> bst = getIntegerBST();
        System.out.println(bst.maximum());
    }

    @Test
    public void bst_removeMax_test() {
        BST<Integer> bst = new BST<>();
        Random random = new Random();

        int n = 1000;

        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }

        ArrayList<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty()) {
            nums.add(bst.removeMax());
        }

        System.out.println(nums);

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) < nums.get(i)) {
                throw new IllegalArgumentException("Error");
            }
        }

        System.out.println("removeMax test complete");

    }

    @Test
    public void bst_removeMin_test() {
        BST<Integer> bst = new BST<>();
        Random random = new Random();

        int n = 1000;

        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }

        ArrayList<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty()) {
            nums.add(bst.removeMin());
        }

        System.out.println(nums);

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) > nums.get(i)) {
                throw new IllegalArgumentException("Error");
            }
        }

        System.out.println("removeMin test complete");

    }

    @Test
    public void bst_remove_test(){
        BST<Integer> bst = getIntegerBST();
        bst.remove(5);
        System.out.println(bst);
    }


}