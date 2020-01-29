package setandmap;

import org.junit.Test;

import java.util.ArrayList;

public class SetTest {
    private static double getRunningTime(ISet<String> iSet, String fileName) {
        long startTime = System.nanoTime();
        System.out.println(fileName);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(fileName, words)) {
            System.out.println("Total words:" + words.size());
            for (String word : words) {
                iSet.add(word);
            }
            System.out.println("Total different words:" + iSet.getSize());
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    @Test
    public void bst_set_test_pride_and_prejudice() {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("src/main/setandmap/pride-and-prejudice.txt", words)) {
            System.out.println("Total words:" + words.size());
            BSTSet<String> bstSet = new BSTSet<>();
            for (String word : words) {
                bstSet.add(word);
            }
            System.out.println("Total different words:" + bstSet.getSize());
        }

    }

    @Test
    public void bst_set_test_a_table_of_two_cities() {
        System.out.println("A Table of Two cities");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("src/main/setandmap/a-tale-of-two-cities.txt", words)) {
            System.out.println("Total words:" + words.size());
            BSTSet<String> bst = new BSTSet<>();
            for (String word : words) {
                bst.add(word);
            }
            System.out.println("Total different words:" + bst.getSize());
        }
    }

    @Test
    public void link_list_set_test_a_tale_of_two_cities() {
        System.out.println("A Tale of Two cities");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("src/main/setandmap/a-tale-of-two-cities.txt", words)) {
            System.out.println("Total words:" + words.size());
            LinkListSet<String> linkListSet = new LinkListSet<>();
            for (String word : words) {
                linkListSet.add(word);
            }
            System.out.println("Total different words:" + linkListSet.getSize());
        }
    }

    @Test
    public void link_list_set_test_pride_and_prejudice() {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("src/main/setandmap/pride-and-prejudice.txt", words)) {
            System.out.println("Total words:" + words.size());
            LinkListSet<String> linkListSet = new LinkListSet<>();
            for (String word : words) {
                linkListSet.add(word);
            }
            System.out.println("Total different words:" + linkListSet.getSize());
        }

    }

    @Test
    public void time_complexity_of_set() {
        String fileName = "src/main/setandmap/pride-and-prejudice.txt";
        double bstTime = getRunningTime(new BSTSet<String>(), fileName);
        double linkListTime = getRunningTime(new LinkListSet<String>(), fileName);
        double avlTime = getRunningTime(new AVLSet<String>(), fileName);
        System.out.println("BST set : " + bstTime + "s");
        System.out.println("LinkList set : " + linkListTime + "s");
        System.out.println("AVL set : " + avlTime + "s");
    }
}