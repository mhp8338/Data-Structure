package setandmap;

import avltree.AVLTree;

/**
 * @tag: DataStructure
 * @author: mhp
 * @createDate: 2020/1/29
 * @description:
 */
public class AVLSet<E extends Comparable<E>> implements ISet<E> {
    private AVLTree<E,Object> avlTree;

    public AVLSet(){
        avlTree = new AVLTree<>();
    }
    @Override
    public void add(E e) {
        avlTree.add(e,null);
    }

    @Override
    public void remove(E e) {
        avlTree.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return avlTree.contains(e);
    }

    @Override
    public int getSize() {
        return avlTree.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avlTree.isEmpty();
    }
}
