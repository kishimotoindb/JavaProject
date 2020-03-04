package com.example.algorithm;

import java.util.Stack;

/**
 * Created by BigFaceBear on 2019.11.21
 */
public class Hanoi {
    Stack<Integer> left;
    Stack<Integer> mid;
    Stack<Integer> right;

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi(100);
        System.out.println("before move");
        for (Integer integer : hanoi.left) {
            System.out.println(integer);
        }
        hanoi.move();
        System.out.println("after move");
        for (Integer integer : hanoi.right) {
            System.out.println(integer);
        }

    }

    Hanoi(int count) {
        left = new Stack<>();
        mid = new Stack<>();
        right = new Stack<>();
        for (int i = count; i >=0 ; i--) {
            left.push(i);
        }
    }

    void move() {
        if (left.isEmpty()) {
            return;
        } else if (left.size() == 1) {
            Integer pop = left.pop();
            right.push(pop);
        } else {
            moveLeftToMidAndRemain2();
            Integer leftTop = left.pop();
            mid.push(leftTop);
            Integer leftBottom = left.pop();
            right.push(leftBottom);
            Integer midTop = mid.pop();
            right.push(midTop);
            moveMidBackToLeft();
            move();
        }
    }

    private void moveLeftToMidAndRemain2() {
        while (left.size() > 2) {
            mid.push(left.pop());
        }

    }

    private void moveMidBackToLeft() {
        while (!mid.isEmpty()) {
            left.push(mid.pop());
        }
    }
}
