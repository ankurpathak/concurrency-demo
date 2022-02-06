package com.github.ankurpathak;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class BinaryTreeCodec {
    public static String serialize(TreeNode root) {
        if (root == null)
            return "[]";
        StringBuilder collector = new StringBuilder("[");
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.pollFirst();
            if (curr != root) {
                collector.append(", ");
            }
            if (curr != null) {
                collector.append(curr.val);
                queue.offerLast(curr.left);
                queue.offerLast(curr.right);
            } else {
                collector.append(curr);
            }
        }
        collector.append("]");
        return collector.toString();
    }

    // Decodes your encoded data to tree.

    public static TreeNode deserialize(String data) {
        if (data == null)
            return null;

        data = data.trim();

        if (!data.startsWith("[") || !data.endsWith("]") || Objects.equals("[]", data))
            return null;

        String[] tokens = data.split("\\s*,\\s*");
        tokens[0] = tokens[0].substring(1).trim();
        tokens[tokens.length - 1] = tokens[tokens.length - 1].substring(0, tokens[tokens.length - 1].indexOf("]")).trim();
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.valueOf(tokens[0]));
        queue.offerLast(root);
        for (int i = 2; i < tokens.length && !queue.isEmpty(); i += 2) {
            TreeNode curr = queue.pollFirst();
            if (!Objects.equals(tokens[i - 1], "null")) {
                curr.left = new TreeNode(Integer.valueOf(tokens[i - 1]));
                queue.offerLast(curr.left);
            }

            if (!Objects.equals(tokens[i], "null")) {
                curr.right = new TreeNode(Integer.valueOf(tokens[i]));
                queue.offerLast(curr.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        String tree = "[]";
        TreeNode root = deserialize(tree);
        System.out.println(serialize(root));

    }
}
