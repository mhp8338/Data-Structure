package binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    /**
     * preOrder not recursive
     */
    public void preOrderNR() {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 二分搜索树的中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历以node为根的二分搜索树
     *
     * @param node node
     */
    private void inOrder(Node node) {
        /*
        recurse end...
         */
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 后序遍历二分搜索树
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    public void levelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    /**
     * 寻中二分搜索树的最小元素
     *
     * @return 最小元素的值
     */
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }

        Node node = minimum(root);
        return node.e;
    }

    /**
     * 返回以node为根的的二分搜索树最小值所在的节点
     *
     * @param node node
     * @return node => minimum e
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }

        return minimum(node.left);
    }

    /**
     * 寻中二分搜索树的最大元素
     *
     * @return 最大元素的值
     */
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }

        Node node = maximum(root);
        return node.e;
    }

    /**
     * 返回以node为根的的二分搜索树最小值所在的节点
     *
     * @param node node
     * @return node => minimum e
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }

        return maximum(node.right);
    }

    /**
     * 删除最小值，并返回最小节点的数值
     *
     * @return e
     */
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除以node为根节点的最小值
     * 返回更新后的根结点
     *
     * @param node node
     * @return new node
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else if (e.compareTo(node.e) < 0){
            node.left = remove(node.left,e);
            return node;
        }else {
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            return successor;
        }
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
