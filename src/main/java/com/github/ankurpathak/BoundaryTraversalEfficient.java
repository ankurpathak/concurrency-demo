package com.github.ankurpathak;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoundaryTraversalEfficient {


    public static  boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }
    public static  List<Integer> boundaryTraversalAnticlockwise(TreeNode root){
        if(root == null)
            return Collections.emptyList();
        List<Integer> ds = new ArrayList<>();
        if(!isLeaf(root)) ds.add(root.data);
        addLeftBoundary(root, ds);
        addLeafNodes(root, ds, true);
        int sizeBeforeRightBoundary = ds.size();
        addRightBoundary(root, ds);
        reverse(ds, sizeBeforeRightBoundary);
        return ds;
    }

    public static  List<Integer> boundaryTraversalClockwise(TreeNode root){
        if(root == null)
            return Collections.emptyList();
        List<Integer> ds = new ArrayList<>();
        if(!isLeaf(root)) ds.add(root.data);
        addRightBoundary(root, ds);
        addLeafNodes(root, ds, false);
        int sizeBeforeLeftBoundary = ds.size();
        addLeftBoundary(root, ds);
        reverse(ds, sizeBeforeLeftBoundary);
        return ds;
    }






    private static  void addRightBoundary(TreeNode root, List<Integer> ds) {
        TreeNode it = root.right;
        while (it != null){
            if(!isLeaf(it)) ds.add(it.data);
            it = it.right != null ? it.right : it.left;
        }
    }

    private static  void addLeafNodes(TreeNode root, List<Integer> ds, boolean anticlockwise) {
        if(isLeaf(root)) {
            ds.add(root.data);
            return;
        }
        TreeNode first = anticlockwise ? root.left : root.right;
        TreeNode second = anticlockwise ? root.right : root.left;

        if(first != null) addLeafNodes(first, ds, anticlockwise);

        if(second != null) addLeafNodes(second, ds, anticlockwise);
    }

    private static  void addLeftBoundary(TreeNode root, List<Integer> ds) {
        TreeNode it = root.left;
        while (it != null){
            if(!isLeaf(it)) ds.add(it.data);
            it = it.left != null ? it.left : it.right;
        }
    }


    public static  void  reverse(List<Integer> a, int index){
        int mid = (int) Math.ceil(index + (a.size() - 1.0 - index) / 2);
        for(int i = 0 ; index + i < mid; i++){
           Integer temp = a.get(index + i);
            a.set(index + i, a.get(a.size() - i -1));
            a.set(a.size() - i -1, temp);
        }
    }


}
