package hashtable;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @tag: DataStructure
 * @author: mhp
 * @createDate: 2020/2/3
 * @description:
 */
public class HashTableTest {

    @Test
    public void hashtable_test() {

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("/Users/xuepipi/Desktop/mhpExercise/DataStructure/src/main/hashtable/pride-and" +
                "-prejudice.txt", words)) {
            /*hash table*/
            long startTime = System.nanoTime();
            HashTable<String, Integer> hashTable = new HashTable<>();
            for (String word : words) {
                if (hashTable.contains(word)) {
                    hashTable.set(word, hashTable.get(word) + 1);
                } else {
                    hashTable.add(word, 1);
                }
            }

            for (String word : words) {
                hashTable.contains(word);
            }

            long endTime = System.nanoTime();
            double time = endTime - startTime;
            System.out.println("hashtable:" + time / 1000000000.0);
            System.out.println("hashtable prejudice:" + hashTable.get("prejudice"));

            /*bst*/
            startTime = System.nanoTime();
            BST<String, Integer> bst = new BST<>();
            for (String word : words) {
                if (bst.contains(word)) {
                    bst.set(word, bst.get(word) + 1);
                } else {
                    bst.add(word, 1);
                }
            }

            for (String word : words) {
                bst.contains(word);
            }

            endTime = System.nanoTime();
            time = endTime - startTime;
            System.out.println("BST:" + time / 1000000000.0);
            System.out.println("bst prejudice:" + bst.get("prejudice"));

            /*avl*/
            startTime = System.nanoTime();
            AVLTree<String, Integer> avlTree = new AVLTree<>();
            for (String word : words) {
                if (avlTree.contains(word)) {
                    avlTree.set(word, avlTree.get(word) + 1);
                } else {
                    avlTree.add(word, 1);
                }
            }

            for (String word : words) {
                avlTree.contains(word);
            }

            endTime = System.nanoTime();
            time = endTime - startTime;
            System.out.println("avlTree:" + time / 1000000000.0);
            System.out.println("avltree prejudice:" + avlTree.get("prejudice"));


            /*rb tree*/
            startTime = System.nanoTime();
            RBTree<String, Integer> rbTree = new RBTree<>();
            for (String word : words) {
                if (rbTree.contains(word)) {
                    rbTree.set(word, rbTree.get(word) + 1);
                } else {
                    rbTree.add(word, 1);
                }
            }

            for (String word : words) {
                rbTree.contains(word);
            }

            endTime = System.nanoTime();
            time = endTime - startTime;
            System.out.println("rbTree:" + time / 1000000000.0);
            System.out.println("rb tree prejudice:" + rbTree.get("prejudice"));

        }
    }
}
