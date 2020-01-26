package trie;

/**
 * @tag: DataStructure
 * @author: mhp
 * @createDate: 2020/1/21
 * @description:
 */
public class TrieSet implements Set<String> {
    private Trie trie = new Trie();
    @Override
    public void add(String s) {
        trie.add(s);
    }

    @Override
    public boolean contains(String s) {
        return trie.contains(s);
    }

    @Override
    public void remove(String s) {

    }

    @Override
    public int getSize() {
        return trie.getSize();
    }

    @Override
    public boolean isEmpty() {
        return trie.isEmpty();
    }
}
