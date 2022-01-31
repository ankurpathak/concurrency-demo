package com.github.ankurpathak;

public class BinarySearchTree {


    public static TreeNode createBst(int a[]) {
        return createDfs(a, 0, a.length - 1);
    }

    private static TreeNode createDfs(int a[], int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + ((high - low) >> 1);
        TreeNode node = new TreeNode(a[mid]);
        node.left = createDfs(a, low, mid - 1);
        node.right = createDfs(a, mid + 1, high);
        return node;
    }


    public static TreeNode max(TreeNode root) {
        TreeNode start = new TreeNode();
        start.right = root;
        TreeNode it = start;
        while (it.right != null) {
            it = it.right;
        }
        return it != start ? it : null;
    }

    public static TreeNode min(TreeNode root) {
        TreeNode start = new TreeNode();
        start.left = root;
        TreeNode it = start;
        while (it.left != null) {
            it = it.left;
        }
        return it != start ? it : null;
    }


    public static TreeNode find(TreeNode root, int val) {
        TreeNode start = new TreeNode(Integer.MAX_VALUE);
        start.left = root;
        TreeNode it = start;
        while (it != null) {
            if (val == it.val)
                return it;
            else if (val < it.val) {
                it = it.left;
            } else {
                it = it.right;
            }
        }
        return null;
    }

    public static TreeNode ceil(TreeNode root, int val) {
        TreeNode start = new TreeNode(Integer.MAX_VALUE);
        TreeNode ceil = start;
        start.left = root;
        TreeNode it = start;
        while (it != null) {
            if (val == it.val)
                return it;
            else if (val < it.val) {
                ceil = it;
                it = it.left;
            } else {
                it = it.right;
            }
        }
        return ceil;
    }


    public static TreeNode floor(TreeNode root, int val) {
        TreeNode start = new TreeNode(Integer.MIN_VALUE);
        TreeNode floor = start;
        start.right = root;
        TreeNode it = start;
        while (it != null) {
            if (val == it.val)
                return it;
            else if (val < it.val) {
                it = it.left;
            } else {
                floor = it;
                it = it.right;
            }
        }
        return floor;
    }


    public static void replaceBySumOfSmaller(TreeNode root, int[] sum) {
        if (root == null)
            return;
        replaceBySumOfSmaller(root.left, sum);
        sum[0] += root.val;
        root.val = sum[0] - root.val;
        replaceBySumOfSmaller(root.right, sum);
    }

    public static void replaceBySumOfLarger(TreeNode root, int[] sum) {
        if (root == null)
            return;
        replaceBySumOfLarger(root.right, sum);
        sum[0] += root.val;
        root.val = sum[0] - root.val;
        replaceBySumOfLarger(root.left, sum);
    }


}
