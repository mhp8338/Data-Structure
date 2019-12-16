package binarysearchtree;

/**
 * @author xuepipi
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        /**
         * 属性
         */
        public E e;
        public Node right, left;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }

    }

    /**
     * BST属性
     */
    private Node root;
    private int size;

    /**
     * 构造方法
     */
    public BST() {
        this.root = null;
        size = 0;
    }

    /**
     * 返回size
     *
     * @return size
     */
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
//        if (root == null) {
//            root = new Node(e);
//            size++;
//        } else {
//            add(root, e);
//        }
        root = add(root, e);
    }

    /**
     * node为根结点的二分搜索树添加元素e
     *
     * @param node 二分搜索树子树的根结点
     * @param e    待插入的元素e
     * @return 返回插入e后二分搜索树的根
     */
    private Node add(Node node, E e) {
        /**
         * 递归中止条件
         */
//        if (e.compareTo(node.e) == 0) {
//            return;
//        } else if (e.compareTo(node.e) > 0 && node.right == null) {
//            node.right = new Node(e);
//            size++;
//            return;
//        } else if (e.compareTo(node.e) < 0 && node.left == null) {
//            node.left = new Node(e);
//            size++;
//            return;
//        }
        if (node == null) {
            size++;
            return new Node(e);
        }

        /**
         * 递归子问题
         */
        if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        } else {
            node.left = add(node.left, e);
        }
        return node;
    }


    /**
     * 检查二分搜索树中是否包含元素e
     *
     * @param e e
     * @return boolean value
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * preOrder
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        /**
         * recurse end...
         */
        if (node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    /**
     * generate node is root, depth parameter is depth BST String
     *
     * @param node  root
     * @param depth depth
     * @param res   result
     */
    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth)).append("null\n");
            return;
        }
        res.append(generateDepthString(depth)).append(node.e).append("\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}
