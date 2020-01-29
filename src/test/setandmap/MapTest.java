package setandmap;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MapTest {

    private static double getRunningTime(IMap<String, Integer> iMap, String fileName) {
        long startTime = System.nanoTime();
        System.out.println(fileName);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(fileName, words)) {
            System.out.println("Total words:" + words.size());
            for (String word : words) {
                if (iMap.contains(word)) {
                    iMap.add(word, iMap.get(word) + 1);
                } else {
                    iMap.add(word, 1);
                }
            }
            System.out.println("Total different words:" + iMap.getSize());
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    @Test
    public void bst_map_test() {
        ArrayList<String> words = new ArrayList<>();
        String fileName = "src/main/setandmap/pride-and-prejudice.txt";
        BSTMap<String, Integer> bstMap = new BSTMap<>();
        if (FileOperation.readFile(fileName, words)) {
            for (String word : words) {
                if (bstMap.contains(word)) {
                    bstMap.add(word, bstMap.get(word) + 1);
                } else {
                    bstMap.add(word, 1);
                }
            }
        }
        System.out.println("Total different words:" + bstMap.getSize());
        System.out.println("Frequency of Pride:" + bstMap.get("pride"));
        System.out.println("Frequency of Prejudice:" + bstMap.get("prejudice"));
    }

    @Test
    public void link_list_map_test() {
        ArrayList<String> words = new ArrayList<>();
        String fileName = "src/main/setandmap/pride-and-prejudice.txt";
        LinkListMap<String, Integer> linkListMap = new LinkListMap<>();
        if (FileOperation.readFile(fileName, words)) {
            for (String word : words) {
                if (linkListMap.contains(word)) {
                    linkListMap.add(word, linkListMap.get(word) + 1);
                } else {
                    linkListMap.add(word, 1);
                }
            }
        }
        System.out.println("Total different words:" + linkListMap.getSize());
        System.out.println("Frequency of Pride:" + linkListMap.get("pride"));
        System.out.println("Frequency of Prejudice:" + linkListMap.get("prejudice"));
    }

    @Test
    public void time_complexity_of_map() {
        String fileName = "src/main/setandmap/pride-and-prejudice.txt";
        double bstTime = getRunningTime(new BSTMap<String, Integer>(), fileName);
        double linkListTime = getRunningTime(new LinkListMap<String, Integer>(), fileName);
        double avlTime = getRunningTime(new AVLMap<String, Integer>(), fileName);
        System.out.println("BST map : " + bstTime + "s");
        System.out.println("LinkList map : " + linkListTime + "s");
        System.out.println("AVL map : " + avlTime);
    }


}