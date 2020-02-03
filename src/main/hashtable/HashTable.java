package hashtable;

import java.util.TreeMap;

/**
 * @tag: DataStructure
 * @author: mhp
 * @createDate: 2020/2/3
 * @description:
 */
public class HashTable<K, V> {

    /**
     * 底层是红黑树
     */
    private TreeMap<K, V>[] hashTable;
    /**
     * 哈希表的空间
     */
    private int m;
    /**
     * 存储的元素个数
     */
    private int size;

    private static final int lowerTol = 2;
    private static final int upperTol = 10;
    private int capacityIndex = 0;
    private final int[] capacity = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
            12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};

//    /**
//     * @param m 输入空间
//     */
//    public HashTable(int m) {
//        this.m = m;
//        this.size = 0;
//        /*hashTable初始化*/
//        hashTable = new TreeMap[m];
//        /*无法修改t，迭代器无法修改
//        for (TreeMap t : hashTable) {
//            t = new TreeMap<>();
//        }*/
//        for (int i = 0; i < m; i++) {
//            hashTable[i] = new TreeMap<>();
//        }
//    }

    public HashTable() {
        this.m = capacity[capacityIndex];
        this.size = 0;
        /*hashTable初始化*/
        hashTable = new TreeMap[m];
        /*无法修改t，迭代器无法修改
        for (TreeMap t : hashTable) {
            t = new TreeMap<>();
        }*/
        for (int i = 0; i < m; i++) {
            hashTable[i] = new TreeMap<>();
        }

    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public int getSize() {
        return size;
    }

    /**
     * 添加元素
     *
     * @param key   key
     * @param value value
     */
    public void add(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        map.put(key, value);
        if (!map.containsKey(key)) {
            size++;
            if (size > upperTol * m && capacityIndex + 1 < capacity.length) {
                capacityIndex++;
                resize(capacity[capacityIndex]);
            }
        }
    }

    private void resize(int newM) {
        TreeMap<K, V>[] newHashtable = new TreeMap[newM];
        /*初始化*/
        for (int i = 0; i < newM; i++) {
            newHashtable[i] = new TreeMap<>();
        }
        int oldM = m;
        this.m = newM;
        /*将原来的放置到新的*/
        for (int i = 0; i < oldM; i++) {
            TreeMap<K, V> map = hashTable[i];
            for (K key : map.keySet()) {
                newHashtable[hash(key)].put(key, map.get(key));
            }
        }
        this.hashTable = newHashtable;
    }

    /**
     * @param key key
     * @return 返回值value
     */
    public V remove(K key) {
        V ret = null;
        TreeMap<K, V> map = hashTable[hash(key)];
        if (map.containsKey(key)) {
            ret = map.remove(key);
            size--;
            if (size < lowerTol * m && capacity.length-1>=0) {
                capacityIndex--;
                resize(capacity[capacityIndex]);
            }
        }
        return ret;
    }

    public void set(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException("Key is not exist,set failure");
        }
        map.put(key, value);
    }

    public boolean contains(K key) {
        return hashTable[hash(key)].containsKey(key);
    }

    public V get(K key) {
        return hashTable[hash(key)].get(key);
    }

}
