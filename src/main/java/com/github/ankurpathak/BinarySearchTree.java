package com.github.ankurpathak;

import java.util.List;

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
        if (root == null)
            return null;

        TreeNode it = root;
        while (it.right != null) {
            it = it.right;
        }
        return it;
    }

    public static TreeNode min(TreeNode root) {
        if (root == null)
            return null;
        TreeNode it = root;
        while (it.left != null) {
            it = it.left;
        }
        return it;
    }


    public static TreeNode find(TreeNode root, int val) {
        TreeNode it = root;
        while (it != null) {
            if (val == it.val)
                break;
            else if (val < it.val) {
                it = it.left;
            } else {
                it = it.right;
            }
        }
        return it;
    }

    public static TreeNode ceil(TreeNode root, int val) {
        TreeNode it = root;
        TreeNode ceil = new TreeNode(Integer.MAX_VALUE);
        ceil.left = root;
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
        TreeNode it = root;
        TreeNode floor = new TreeNode(Integer.MIN_VALUE);
        floor.right = root;

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


    public static int replaceBySumOfSmaller1(TreeNode root, int sum) {
        if (root == null)
            return sum;
        sum = replaceBySumOfSmaller1(root.left, sum);
        sum += root.val;
        root.val = sum - root.val;
        sum = replaceBySumOfSmaller1(root.right, sum);
        return sum;
    }

    public static int replaceBySumOfLarger1(TreeNode root, int sum) {
        if (root == null)
            return sum;
        sum = replaceBySumOfLarger1(root.right, sum);
        sum += root.val;
        root.val = sum - root.val;
        sum = replaceBySumOfLarger1(root.left, sum);
        return sum;
    }

    public static void replaceBySumOfLarger(TreeNode root, int[] sum) {
        if (root == null)
            return;
        replaceBySumOfLarger(root.right, sum);
        sum[0] += root.val;
        root.val = sum[0] - root.val;
        replaceBySumOfLarger(root.left, sum);
    }

    public static void collectInRange(TreeNode root, int low, int high, List<Integer> ds) {
        if (root == null) {
            return;
        }
        if (root.val < low) {
            collectInRange(root.right, low, high, ds);
        } else if (root.val > high) {
            collectInRange(root.left, low, high, ds);
        } else {
            collectInRange(root.left, low, high, ds);
            ds.add(root.val);
            collectInRange(root.right, low, high, ds);
        }
    }


    public static TreeNode bstLca(TreeNode root, int val1, int val2) {
        if (root == null)
            return null;

        if (val1 < root.val && val2 < root.val) {
            return bstLca(root.left, val1, val2);
        } else if (val1 > root.val && val2 > root.val) {
            return bstLca(root.right, val1, val2);
        } else {
            return root;
        }
    }

    public static TreeNode insertRecursive(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val > val) {
            root.left = insertRecursive(root.left, val);
        } else {
            root.right = insertRecursive(root.right, val);
        }
        return root;
    }


}
