package com.example.algorithm.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

/**
 * Created by BigFaceBear on 2020.03.16
 */
public class CalculateTreeDepth {


    public static void main(String[] args) {
        CalculateTreeDepth c = new CalculateTreeDepth();
        Node tree = c.constructTree();
        c.printTree(tree);
        int depth = c.calculateTreeDepth(tree);
        System.out.println(System.lineSeparator() + "depth " + depth);
    }

    int calculateTreeDepth(Node node) {
        if (node.left == null && node.right == null) {
            return 1;
        } else if (node.left != null && node.right != null) {
            return 1 + Math.max(calculateTreeDepth(node.left), calculateTreeDepth(node.right));
        } else if (node.left != null) {
            return 1 + calculateTreeDepth(node.left);
        } else {
            return 1 + calculateTreeDepth(node.right);
        }
    }

    // 层序遍历
    void printTree(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        Node node;
        Node nextLevelNode = root;
        while ((node = queue.poll()) != null) {
            if (node == nextLevelNode) {
                System.out.println();
                System.out.print("level " + depth++);
                nextLevelNode = null;
            }

            System.out.print("  " + node.data);

            if (node.left != null) {
                queue.offer(node.left);
                if (nextLevelNode == null) {
                    nextLevelNode = node.left;
                }
            }
            if (node.right != null) {
                queue.offer(node.right);
                if (nextLevelNode == null) {
                    nextLevelNode = node.right;
                }
            }
        }
    }

    Node constructTree() {
        Random r = new Random();
        Node root = new Node();
        root.data = 10;

        for (int i = 0; i < 20; i++) {
            Node node = new Node();
            node.data = r.nextInt();
            insertNode(root, node);
        }
        return root;
    }

    void insertNode(Node parent, Node node) {
        if (node.data < parent.data) {
            if (parent.left == null) {
                parent.left = node;
            } else {
                insertNode(parent.left, node);
            }
        } else {
            if (parent.right == null) {
                parent.right = node;
            } else {
                insertNode(parent.right, node);
            }
        }
    }

    class Node {
        int data;
        Node left;
        Node right;
    }
}
