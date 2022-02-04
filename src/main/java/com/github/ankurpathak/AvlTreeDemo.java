package com.github.ankurpathak;

public class AvlTreeDemo {
    public static void main(String[] args) {
        int[] a = new int[]{10, 20, 30, 40, 50};
        TreeNode root = createAvl(a, 0, a.length - 1);

    }

    public static TreeNode createAvl(int a[], int l, int h) {
        if (l > h) {
            return null;
        }
        int mid = l + ((h - l) >> 1);
        TreeNode root = new TreeNode(a[mid]);
        root.left = createAvl(a, l, mid - 1);
        root.right = createAvl(a, mid + 1, h);
        root = getRotation(root);
        return root;
    }


    public static void updateHeightAndBalance(TreeNode root) {
        int lh = root.left != null ? root.left.height : -1;
        int rh = root.right != null ? root.right.height : -1;

        root.height = 1 + Math.max(lh, rh);
        root.balance = lh - rh;
    }

    public static TreeNode getRotation(TreeNode root) {
        updateHeightAndBalance(root);
        if (root.balance == 2) {
            if (root.left.balance == 1) { //ll
                root = rightRotation(root);
            } else { // lr
                root.left = leftRotation(root.left);
                root = rightRotation(root);
            }
        } else if (root.balance == -2) {
            if (root.right.balance == -1) { //rr
                root = leftRotation(root);
            } else { //rl
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

    public static TreeNode add(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (val < root.val) {
            root.left = add(root.left, val);
        } else if (root.val < val) {
            root.right = add(root.right, val);
        }

        root = getRotation(root);
        return root;
    }

    public static TreeNode remove(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = remove(root.left, key);
        } else if (root.val < key) {
            root.right = remove(root.right, key);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            TreeNode leftExtremeRight = findExtremeRight(root.left);
            root.val = leftExtremeRight.val;
            root.left = remove(root.left, leftExtremeRight.val);
        }
        root = getRotation(root);
        return root;
    }

    private static TreeNode findExtremeRight(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }
}
