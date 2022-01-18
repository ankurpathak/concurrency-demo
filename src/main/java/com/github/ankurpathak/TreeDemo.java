package com.github.ankurpathak;

import java.util.*;

public class TreeDemo {
    public static void main(String[] args) {
        Integer a[] = new Integer[]{ 1, 2, 3, 4, 5, 7, 8, null,null, 6,null, null,null,9,10};
        TreeNode<Integer> root = create(a);
        List<Integer> sequence =  new ArrayList<>();
        inorder(root, sequence);
        System.out.println(sequence);
        sequence.clear();
        preorder(root, sequence);
        System.out.println(sequence);
        sequence.clear();
        postorder(root, sequence);
        System.out.println(sequence);
        List<List<Integer>> ds = new ArrayList<>();
        bfs(root);
        System.out.println(ds);
    }


    public static <T> TreeNode<T> create(T a[]){
        if(a == null || a.length == 0)
            return null;
        Deque<Pair<TreeNode<T>>> queue = new LinkedList<>();
        TreeNode<T> root = new TreeNode<>(a[0]);
        Pair<TreeNode<T>> pair = new Pair<>(root, 0);
        queue.offerLast(pair);
        int i = 0;
        while (!queue.isEmpty()){
            pair = queue.pollFirst();
            int lChildIndex = 2 * pair.index + 1;
            int rChildIndex = 2 * pair.index + 2;
            T lChild = a[lChildIndex];
            T rChild = a[rChildIndex];
            if(lChild != null){
                pair.t.left = new TreeNode<>(lChild);
                queue.offerLast(new Pair<>(pair.t.left, lChildIndex));
            }

            if(rChild != null){
                pair.t.right = new TreeNode<>(rChild);
                queue.offerLast(new Pair<>(pair.t.right, rChildIndex));
            }
            i = rChildIndex;
            if(i >= a.length - 1){
                queue.clear();
            }
        }
        return root;
    }

    public static <T> void inorder(TreeNode<T> root, List<T> ds){
        if(root == null)
            return;
        inorder(root.left, ds);
        ds.add(root.data);
        inorder(root.right, ds);
    }

    public static <T> void preorder(TreeNode<T> root, List<T> ds){
        if(root == null)
            return;
        ds.add(root.data);
        preorder(root.left, ds);
        preorder(root.right, ds);
    }

    public static <T> void postorder(TreeNode<T> root, List<T> ds){
        if(root == null)
            return;
        postorder(root.left, ds);
        postorder(root.right, ds);
        ds.add(root.data);
    }


    public static <T> List<List<T>> bfs(TreeNode<T> root){
        if(root == null)
            return Collections.emptyList();
        List<List<T>> ds = new ArrayList<>();
        Deque<TreeNode<T>> queue = new LinkedList<>();
        queue.offerLast(root);
        while (!queue.isEmpty()){
            int levelElementsCount = queue.size();
            List<T> level = new ArrayList<>();
            for(int i = 0; i < levelElementsCount ; i++){
                TreeNode<T> node = queue.pollFirst();
                if(node != null){
                    if(node.left != null){
                        queue.offerLast(node.left);
                    }
                    if(node.right != null){
                        queue.offerLast(node.right);
                    }
                    level.add(node.data);
                }
            }
            ds.add(level);
        }
        return ds;
    }

    public static <T> List<T> preorderIterative(TreeNode<T> root){
        if(root == null)
            return Collections.emptyList();
        List<T> ds = new ArrayList<>();
        Deque<TreeNode<T>> stack = new LinkedList<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()){
            TreeNode<T> node = stack.pollFirst();
            if(node.right != null){
                stack.offerFirst(node.right);
            }
            if(node.left != null){
                stack.offerFirst(node.left);
            }
            ds.add(node.data);
        }
        return ds;
    }

    public static <T> List<T> inorderIterative(TreeNode<T> root){
        if(root == null)
            return Collections.emptyList();
        List<T> ds = new ArrayList<>();
        Deque<TreeNode<T>> stack  = new LinkedList<>();
        TreeNode<T> node = root;
        while(true){
            if(node != null){
                stack.offerFirst(node);
                node = node.left;
            }else {
                if(stack.isEmpty()) break;
                node = stack.pollFirst();
                ds.add(node.data);
                node = node.right;
            }
        }
        return ds;
    }


    public static <T> List<T> postorderIterative2Stack(TreeNode<T> root){
        if(root == null)
            return Collections.emptyList();
        Deque<TreeNode<T>> stack = new LinkedList<>();
        Deque<T> stackDs = new LinkedList<>();
        stack.offerFirst(root);
        while(!stack.isEmpty()){
            TreeNode<T> node = stack.pollFirst();
            stackDs.offerFirst(node.data);
            if(node.left != null){
                stack.offerFirst(node.left);
            }
            if(node.right != null){
                stack.offerFirst(node.right);
            }
        }
        List<T> ds = new ArrayList<>();
        while(!stackDs.isEmpty()){
            ds.add(stackDs.pollFirst());
        }
        return ds;
    }


    public static <T> List<T> postorderIterative1Stack(TreeNode<T> root){
        if(root == null)
            return Collections.emptyList();
        Deque<TreeNode<T>> stack = new LinkedList<>();
        List<T> ds = new ArrayList<>();
        TreeNode<T> node = root;
        while(node != null || !stack.isEmpty()){
            if(node != null){
                stack.offerFirst(node);
                node = node.left;
            }else {
                TreeNode<T> temp = stack.peekFirst().right;
                if(temp != null){
                    node = temp;
                }else {
                    temp = stack.pollFirst();
                    ds.add(temp.data);
                    while(!stack.isEmpty() && temp == stack.peekFirst().right){
                        temp = stack.pollFirst();
                        ds.add(temp.data);
                    }
                }
            }
        }
        return ds;
    }

    public static <T> Map<String, List<T>> allDfs(TreeNode<T> root){
        if(root == null)
            return Collections.emptyMap();

        List<T> preorder = new ArrayList<>();
        List<T> inorder =  new ArrayList<>();
        List<T> postorder =  new ArrayList<>();

        Deque<Pair<TreeNode<T>>> stack = new LinkedList<>();
        stack.offerFirst(new Pair<>(root, 1));
        while (!stack.isEmpty()){
            var pair = stack.pollFirst();
            if(pair.index == 1){
                preorder.add(pair.t.data);
                pair.index++;
                stack.offerFirst(pair);
                if(pair.t.left != null){
                    stack.offerFirst(new Pair<>(pair.t.left, 1));
                }
            }else if(pair.index == 2){
                inorder.add(pair.t.data);
                pair.index++;
                stack.offerFirst(pair);
                if(pair.t.right != null){
                    stack.offerFirst(new Pair<>(pair.t.right, 1));
                }
            }else if(pair.index == 3){
                postorder.add(pair.t.data);
            }
        }

        Map<String, List<T>> ds = new LinkedHashMap<>();
        ds.put("preorder", preorder);
        ds.put("inorder", inorder);
        ds.put("postorder", postorder);
        return ds;
    }


   public static <T> int height(TreeNode<T> root){
        if(root == null)
            return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        return 1 + Math.max(lh, rh);
   }

   public static  <T> int balancedTree(TreeNode<T> root){
        if(root == null)
            return 0;

        int lh = balancedTree(root.left);
        if(lh == -1) return -1;

        int rh = balancedTree(root.right);
        if(rh == -1) return -1;

        if(Math.abs(lh - rh) > 1)
            return -1;

        return 1 + Math.max(lh, rh);
   }


   public static <T> int diameter(TreeNode<T> root, int[] diameter){
        if(root == null)
            return 0;

        int lh = diameter(root.left, diameter);

        int rh =  diameter(root.right, diameter);

        diameter[0] = Math.max(diameter[0], lh + rh);

        return 1 + Math.max(lh, rh);
   }


   public static <T> boolean identicalTree(TreeNode<T> root1, TreeNode<T> root2){
        if(root1 == null || root2 == null)
            return root1 == root2;

        if(!Objects.equals(root1.data, root2.data))
            return false;

        return identicalTree(root1.left, root2.left) && identicalTree(root2.right, root2.right);
   }


   public static <T> List<List<T>> zigzag(TreeNode<T> root){
        if(root == null)
            return Collections.emptyList();
        Deque<TreeNode<T>> queue = new LinkedList<>();
        boolean lefToRight = true;
        queue.offerLast(root);
        List<List<T>> ds = new ArrayList<>();
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            List<T> level = new ArrayList<>();
            for(int i = 0; i <levelSize; i++){
                TreeNode<T> node = lefToRight ? queue.pollFirst() : queue.pollLast();
                if(node != null){
                    if(lefToRight){
                        if(node.left != null){
                            queue.offerLast(node.left);
                        }
                        if(node.right != null){
                            queue.offerLast(node.right);
                        }
                    }else {
                        if(node.right != null){
                            queue.offerFirst(node.right);
                        }
                        if(node.left != null){
                            queue.offerFirst(node.left);
                        }
                    }
                    level.add(node.data);
                }
            }
            ds.add(level);
            lefToRight = !lefToRight;
        }
        return ds;
   }


    @SuppressWarnings("unchecked")
    public static <T> List<List<T>> zigzagSimple(TreeNode<T> root){
        if(root == null)
            return Collections.emptyList();
        Deque<TreeNode<T>> queue = new LinkedList<>();
        boolean lefToRight = true;
        queue.offerLast(root);
        List<List<T>> ds = new ArrayList<>();
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            T[] level = (T[])new Object[levelSize];
            for(int i = 0; i <levelSize; i++){
                TreeNode<T> node =  queue.pollFirst();
                if(node != null){
                    int index = lefToRight ? i : levelSize - i -1;
                    level[index] = node.data;
                    if(node.left != null)
                        queue.offerLast(node.left);
                    if(node.right != null)
                        queue.offerLast(node.right);
                }
            }
            ds.add(Arrays.asList(level));
            lefToRight = !lefToRight;
        }
        return ds;
    }


    public static <T> List<T>  leftBoundaryOfTree(TreeNode<T> root, boolean withLeaf){
        if(root == null)
            return Collections.emptyList();
        List<T> ds = new ArrayList<>();
        TreeNode<T> it = root;
        while(it != null){
            if(isLeaf(it)){
                if(withLeaf){
                    ds.add(it.data);
                }
            }else {
                ds.add(it.data);
            }
            it = it.left != null ? it.left : it.right;
        }
        return ds;
    }

    public static <T> List<T> rightBoundaryOfTree(TreeNode<T> root, boolean withLeaf){
        if(root == null)
            return Collections.emptyList();
        List<T> ds = new ArrayList<>();
        var it = root;
        while(it != null){
            if(isLeaf(it)){
                if(withLeaf){
                    ds.add(it.data);
                }
            }else {
                ds.add(it.data);
            }
            it = it.right != null ? it.right : it.left;
        }
        return ds;
    }


    public static <T> void inorderLeafOnly(TreeNode<T> root, List<T> ds){
        if(root == null)
            return;
        inorderLeafOnly(root.left, ds);
        if(isLeaf(root)){
            ds.add(root.data);
        }
        inorderLeafOnly(root.right, ds);
    }

    public static <T> boolean isLeaf(TreeNode<T> root){
        return root.left == null && root.right == null;
    }

   public static <T> List<T> boundaryTraversalAnticlockwise(TreeNode<T> root){
        if(root == null)
            return Collections.emptyList();
        List<T> ds = new ArrayList<>();
        if(!isLeaf(root))
            ds.add(root.data);
        List<T> leftBoundary = leftBoundaryOfTree(root.left, false);
        List<T> leafs = new ArrayList<>();
        inorderLeafOnly(root, leafs);
        List<T> rightBoundary = rightBoundaryOfTree(root.right, false);
        ds.addAll(leftBoundary);
        ds.addAll(leafs);
        for(int i = 0; i < rightBoundary.size(); i++){
            ds.add(rightBoundary.get(rightBoundary.size() -i -1));
        }
        return ds;
   }

    public static <T> List<T> boundaryTraversalClockwise(TreeNode<T> root){
        if(root == null)
            return Collections.emptyList();
        List<T> ds = new ArrayList<>();
        if(!isLeaf(root))
            ds.add(root.data);
        List<T> rightBoundary = rightBoundaryOfTree(root.right, false);
        List<T> leafs = new ArrayList<>();
        inorderLeafOnly(root, leafs);
        List<T> leftBoundary = leftBoundaryOfTree(root.left, false);
        ds.addAll(rightBoundary);
        for(int i = 0; i < leafs.size(); i++){
            ds.add(leafs.get(leafs.size() -i -1));
        }
        for(int i = 0; i < leftBoundary.size(); i++){
            ds.add(leftBoundary.get(leftBoundary.size() -i -1));
        }
        return ds;
    }

 }



class Pair<T>{
    T t;
    int index;

    public Pair(T t, int index) {
        this.t = t;
        this.index = index;
    }
}

