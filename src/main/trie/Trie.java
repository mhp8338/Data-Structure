package trie;

import java.util.TreeMap;

/**
 * @tag: DataStructure
 * @author: mhp
 * @createDate: 2020/1/21
 * @description:
 */
public class Trie {
    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }


    /**
     * @return 获得Trie存储的单词数量
     */
    public int getSize() {
        return size;
    }

    /**
     * 向trie添加一个单词
     *
     * @param word 待添加的单词
     */
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }

        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    public boolean contains(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    public boolean isPrefix(String prefix){
        Node cur = root;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;

    }

    public boolean isEmpty(){
        return size == 0;
    }

}
