import node.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Binarytree {


    public static void main(String[] args) {

        int[] array = {34, 84, 15, 0, 2, 99, 79, 9, 88, 89, 18, 31, 39, 100, 101};

        Node root = null;

        for (int index : array) {
            root = insert(root, index);
            System.out.println("Inserted: " + index);
        }

        System.out.println("Inorder traversal: ");
        inorderTraversal(root);


        Node temp = search(root, 88);

        if (temp != null) {
            System.out.println(temp.getData().toString() + " Found!");
        } else {
            System.out.println("[x] " + 88 + "Not Found!");
        }

        int height = findHeight(root);

        System.out.println("The height of the binary tree is " + height + "!");

        System.out.println("Lever order traversal:");
        levelOrderTraversal(root);

    }

    private static Node insert(Node root, int data) {

        Node temp = new Node();
        temp.setData(data);

        if (root == null) {
            root = temp;
        } else {
            Node current = root;
            Node parent = null;
            while (true) {
                parent = current;
                if (data < parent.getData()) {
                    current = current.getLeft();
                    if (current == null) {
                        parent.setLeft(temp);
                        return root;
                    }
                } else {
                    current = current.getRight();

                    if (current == null) {
                        parent.setRight(temp);
                        return root;
                    }
                }
            }
        }

        return root;
    }

    public static void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.getLeft());
            System.out.println(root.getData().toString().concat(" "));
            inorderTraversal(root.getRight());
        }
    }

    public static Node search(Node root, int data) {

        Node current = root;

        System.out.println("Visiting elements: ");
        while (current != null) {
            System.out.println(current.getData().toString().concat(" "));
            if (data < current.getData()) {
                current = current.getLeft();
            } else if (data > current.getData()) {
                current = current.getRight();
            } else {
                return current;
            }
        }
        return null;
    }

    public static int findHeight(Node root) {
        if (root == null) {
            return -1;
        }
        return Math.max(findHeight(root.getLeft()), findHeight(root.getRight())) + 1;
    }

    public static void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.getLeft() != null) queue.add(current.getLeft());
            if (current.getRight() != null) queue.add(current.getRight());
            System.out.print(current.getData().toString().concat(" "));
        }
        System.out.println();
    }
}
