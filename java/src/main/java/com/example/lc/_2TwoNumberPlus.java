package com.example.lc;

import java.util.Random;

/*
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的
 * 每个节点只能存储 一位 数字。如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class _2TwoNumberPlus {

    public static void main(String[] args) {
        Node[] pair = generateLinkList();
        Node addend1 = pair[0], addend2 = pair[1];
        print(addend1);
        print(addend2);

        calculateAndPrint(addend1, addend2);
    }

    private static void calculateAndPrint(Node addend1, Node addend2) {
        boolean carry = false;
        Node p1 = addend1, p2 = addend2, result = new Node(), pointer = result;
        while (p1 != null || p2 != null) {
            int left = p1 != null ? p1.value : 0;
            int right = p2 != null ? p2.value : 0;
            int sum = left + right + (carry ? 1 : 0);
            carry = sum > 9;

            pointer.next = new Node();
            pointer.next.value = sum % 10;
            pointer = pointer.next;

            p1 = p1 != null ? p1.next : null;
            p2 = p2 != null ? p2.next : null;
        }

        if (carry) {
            pointer.next = new Node();
            pointer.next.value = 1;
        }
        result = result.next;

        print(result);
    }

    private static void print(Node node) {
        do {
            System.out.print(node.value);
            node = node.next;
        } while (node != null);
        System.out.println();
    }

    private static Node[] generateLinkList() {
        Random random = new Random();

        Node addend1 = null, addend2 = null, tmp = null;
        int end = random.nextInt(10);
        for (int j = 0; j < end; j++) {
            Node node = new Node();
            node.value = random.nextInt(10);
            if (j == 0) {
                addend1 = node;
            } else {
                tmp.next = node;
            }
            tmp = node;
        }

        end = random.nextInt(10);
        for (int j = 0; j < end; j++) {
            Node node = new Node();
            node.value = random.nextInt(10);
            if (j == 0) {
                addend2 = node;
            } else {
                tmp.next = node;
            }
            tmp = node;
        }
        return new Node[]{addend1, addend2};
    }

    static class Node {
        int value;
        Node next;
    }
}
