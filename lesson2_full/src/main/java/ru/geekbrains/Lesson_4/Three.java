package Lesson_4;

public class Three {

    Node root;

    private class Node {
        public int value;
        public boolean color;
        public Node left;
        public Node right;
    }

    public void insert(int value) {
        root = insert(value, root);
        root.color = false; // корень всегда черный
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node();
            node.value = value;
            node.color = true; // новые узлы - красные
        } else if (value < node.value) {
            node.left = insert(value, node.left);
            if (node.left.color && node.left.left.color) {
                // если левый узел красный и его левый - тоже, балансируем
                node = rotateRight(node);
            }
        } else if (value > node.value) {
            node.right = insert(value, node.right);
            if (node.right != null && node.right.color && node.right.left.color) {
                // если правый узел красный и его левый - тоже, балансируем
                node = rotateLeft(node);
            }
        }
        return node;
    }

    // методы вращения и изменения цвета узлов

    private Node rotateRight(Node node) {

        Node left = node.left;
        node.left = left.right;
        left.right = node;

        flipColors(node, left);

        return left;
    }

    private Node rotateLeft(Node node) {

        Node right = node.right;
        node.right = right.left;
        right.left = node;

        flipColors(node, right);

        return right;
    }

    private void flipColors(Node node, Node rotateNode) {

        node.color = true;
        rotateNode.color = false;

        if (node.left != null) node.left.color = true;
        if (node.right != null) node.right.color = true;
    }

}