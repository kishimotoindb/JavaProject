package com.example.exercise.linklist;

/**
 * Created by BigFaceBear on 2020.06.22
 * 已经存在一个链表，将一个新的节点插入到这个链表的中间。模拟Handler的MessageQueue插入消息的操作。
 */
public class InsertElem {

    public static void main(String[] args) {
        new InsertElem().insert();
    }

    private void insert() {
        Node insert = new Node(5);
        Node head = new Node(1);
        Node prev = head;
        for (int i = 2; i < 10; i++) {
            Node node = new Node(i);
            prev.next = node;
        }

        if (insert.when < head.when) {
            insert.next = head;
            head = insert;
        } else {
            prev = null;
            Node node = head;
            for (; ; ) {
                prev = node;
                node = node.next;
                if (node == null || insert.when < node.when) {
                    break;
                }
            }
            prev.next = insert;
            insert.next = node;
        }
    }

    class Node {
        int when;
        Node next;

        Node(int when) {
        }
    }
}
