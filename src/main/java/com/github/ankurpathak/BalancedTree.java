package com.github.ankurpathak;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;


public class BalancedTree {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        TreeNode root = BinaryTreeCodec.deserialize("[1,null,15,14,17,7,null,null,null,2,12,null,3,9,null,null,null,null,11]");
        root = solution3.balanceBST(root);
    }


    public static TreeNode create(Integer[] a) {
        if (a == null || a.length == 0)
            return null;

        Deque<Pair> stack = new ArrayDeque<>();
        TreeNode root = new TreeNode(a[0]);
        stack.push(new Pair(root, 1));
        int idx = 1;
        while (!stack.isEmpty() && idx < a.length) {
            Pair curr = stack.peekFirst();
            switch (curr.val) {
                case 1:
                    if (a[idx] != null) {
                        curr.t.left = new TreeNode(a[idx]);
                        stack.offerFirst(new Pair(curr.t.left, 1));
                    }
                    curr.val++;
                    idx++;
                    break;
                case 2:
                    if (a[idx] != null) {
                        curr.t.right = new TreeNode(a[idx]);
                        stack.offerFirst(new Pair(curr.t.right, 1));
                    }
                    curr.val++;
                    idx++;
                    break;
                case 3:
                    stack.pollFirst();
                    break;
            }

        }
        return root;
    }
}


class Solution3 {
    private static final Map<TreeNode, Pair> cache = new HashMap<>();

    static {
        cache.put(null, new Pair(0));
    }

    private static int getHeight(TreeNode root) {
        Pair left = cache.get(root.left);
        Pair right = cache.get(root.right);
        return 1 + Math.max(left.height, right.height);
    }

    private static int getBalance(TreeNode root) {
        Pair left = cache.get(root.left);
        Pair right = cache.get(root.right);
        return left.height - right.height;
    }

    public static void updateHeightAndBalance(TreeNode root) {
        cache.putIfAbsent(root, new Pair());
        Pair left = cache.get(root.left);
        Pair right = cache.get(root.right);

        cache.computeIfPresent(root, (it, pair) -> {
            pair.height = 1 + Math.max(left.height, right.height);
            pair.balance = left.height - right.height;
            return pair;
        });
    }

    public static TreeNode getRotation(TreeNode root) {
        updateHeightAndBalance(root);
        int rootBalance = getBalance(root);
        if (rootBalance >= 2) {
            // int rootLeftBalance = getBalance(root.left);
            if (root.left.left != null) { //ll
                root = rightRotation(root);
            } else if (root.left.right != null) { // lr
                root.left = leftRotation(root.left);
                root = rightRotation(root);
            }
        } else if (rootBalance <= -2) {
            // int rootRightBalance = getBalance(root.right);
            if (root.right.right != null) { //rr
                root = leftRotation(root);
            } else if (root.right.left != null) { //rl
                root.right = rightRotation(root.right);
                root = leftRotation(root);
            }
        }
        return root;
    }

    public static TreeNode rightRotation(TreeNode oA) {
        TreeNode oB = oA.left;
        TreeNode oBRight = oB.right;
        oB.right = oA;
        oA.left = oBRight;
        updateHeightAndBalance(oA);
        updateHeightAndBalance(oB);
        return oB;
    }

    public static TreeNode leftRotation(TreeNode oA) {
        TreeNode oB = oA.right;
        TreeNode oBLeft = oB.left;
        oB.left = oA;
        oA.right = oBLeft;
        updateHeightAndBalance(oA);
        updateHeightAndBalance(oB);
        return oB;
    }

    public TreeNode balanceBST(TreeNode root) {
        if (root == null)
            return null;

        root.left = balanceBST(root.left);
        root.right = balanceBST(root.right);
        root = getRotation(root);
        return root;
    }

    private static class Pair {
        int height = 1;
        int balance = 0;

        Pair(int height) {
            this.height = height;
        }

        Pair() {

        }
    }
}
