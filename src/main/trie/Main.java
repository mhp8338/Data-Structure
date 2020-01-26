package trie;

import java.util.ArrayList;
import java.util.List;

/**
 * @tag: DataStructure
 * @author: mhp
 * @createDate: 2020/1/21
 * @description:
 */
public class Main {

    public static final String TRIE_PRIDE_AND_PREJUDICE_TXT = "trie/pride-and-prejudice.txt";

    public static double testSet(Set<String> set){
        System.out.println("pride-and-prejudice");
        long startTime = System.nanoTime();
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(TRIE_PRIDE_AND_PREJUDICE_TXT,words)){
            for (String word:words){
                set.add(word);
            }

            for (String word:words){
                set.contains(word);
            }
        }
        long endTime = System.nanoTime();
        return (endTime-startTime)/1000000000.0;

    }
    public static void main(String[] args) {
        double bstSetCost = testSet(new BSTSet<>());
        System.out.println("BST set cost:"+bstSetCost+" s.");
        double trieSetCost = testSet(new TrieSet());
        System.out.println("Trie set cost:"+trieSetCost+" s.");

    }
}
