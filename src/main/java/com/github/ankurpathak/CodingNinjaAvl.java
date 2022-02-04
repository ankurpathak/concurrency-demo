package com.github.ankurpathak;


public class CodingNinjaAvl {

    public static void main(String[] args) {
        var a = insertionInAvlTree(new int[]{10, 20, 30, 40, 50, 25}, 6);
    }

    public static TreeNode<Integer> insertionInAvlTree(int allNodeValues[], int n) {
        // Write your code here.
        TreeNode<Integer> root = null;
        for (int i = 0; i < n; i++) {
            root = add(root, allNodeValues[i]);
        }
        return root;
    }

    public static TreeNode<Integer> add(TreeNode<Integer> root, int val) {
        if (root == null) return new TreeNode<Integer>(val);

        if (val < root.data) {
            root.left = add(root.left, val);
        } else if (root.data < val) {
            root.right = add(root.right, val);
        }

        root = getRotation(root);
        return root;
    }

    public static void updateHeight(TreeNode<Integer> root) {
        int lh = root.left != null ? root.left.height : 0;
        int rh = root.right != null ? root.right.height : 0;

        root.height = 1 + Math.max(lh, rh);
        //root.balance = lh - rh;
    }

    public static int calculateBalance(TreeNode<Integer> root) {
        int lh = root.left != null ? root.left.height : 0;
        int rh = root.right != null ? root.right.height : 0;
        return lh - rh;
    }

    public static TreeNode<Integer> getRotation(TreeNode<Integer> root) {
        updateHeight(root);
        int rootBalance = calculateBalance(root);
        if (rootBalance == 2) {
            int rootLeftBalance = calculateBalance(root.left);
            if (rootLeftBalance == 1) { //ll
                root = rightRotation(root);
            } else { // lr
                root.left = leftRotation(root.left);
                root = rightRotation(root);
            }
        } else if (rootBalance == -2) {
            int rootRightBalance = calculateBalance(root.right);
            if (rootRightBalance == -1) { //rr
                root = leftRotation(root);
            } else { //rl
                root.right = rightRotation(root.right);
                root = leftRotation(root);
            }
        }
        return root;
    }

    public static TreeNode<Integer> rightRotation(TreeNode<Integer> oA) {
        TreeNode<Integer> oB = oA.left;
        TreeNode<Integer> oBRight = oB.right;
        oB.right = oA;
        oA.left = oBRight;
        updateHeight(oA);
        updateHeight(oB);
        return oB;
    }

    public static TreeNode<Integer> leftRotation(TreeNode<Integer> oA) {
        TreeNode<Integer> oB = oA.right;
        TreeNode<Integer> oBLeft = oB.left;
        oB.left = oA;
        oA.right = oBLeft;
        updateHeight(oA);
        updateHeight(oB);
        return oB;
    }

    private static class TreeNode<T> {
        T data;
        int height;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
            height = 1;
        }
    }
}

