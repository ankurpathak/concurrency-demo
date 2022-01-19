package com.github.ankurpathak;

import java.util.*;

public class TreeDemo {
    public static void main(String[] args) {
        Integer a[] = new Integer[]{ 1, 2, 3, 4, 5, 7, 8, null,null, 6,null, null,null,9,10};
        TreeNode root = create(a);
        List<Integer> sequence =  new ArrayList();
        inorder(root, sequence);
        System.out.println(sequence);
        sequence.clear();
        preorder(root, sequence);
        System.out.println(sequence);
        sequence.clear();
        postorder(root, sequence);
        System.out.println(sequence);
        List<Integer> ds = new ArrayList<Integer>();
        bfs(root);
        System.out.println(ds);
    }


    public static  TreeNode create(Integer a[]){
        if(a == null || a.length == 0)
            return null;
        Deque<Pair> queue = new LinkedList<>();
        TreeNode root = new TreeNode(a[0]);
        Pair pair = new Pair(root, 0);
        queue.offerLast(pair);
        int i = 0;
        while (!queue.isEmpty()){
            pair = queue.pollFirst();
            int lChildIndex = 2 * pair.val + 1;
            int rChildIndex = 2 * pair.val + 2;
           Integer lChild = a[lChildIndex];
           Integer rChild = a[rChildIndex];
            if(lChild != null){
                pair.t.left = new TreeNode(lChild);
                queue.offerLast(new Pair(pair.t.left, lChildIndex));
            }

            if(rChild != null){
                pair.t.right = new TreeNode(rChild);
                queue.offerLast(new Pair(pair.t.right, rChildIndex));
            }
            i = rChildIndex;
            if(i >= a.length - 1){
                queue.clear();
            }
        }
        return root;
    }

    public static  void inorder(TreeNode root, List<Integer> ds){
        if(root == null)
            return;
        inorder(root.left, ds);
        ds.add(root.data);
        inorder(root.right, ds);
    }

    public static  void preorder(TreeNode root, List<Integer> ds){
        if(root == null)
            return;
        ds.add(root.data);
        preorder(root.left, ds);
        preorder(root.right, ds);
    }

    public static  void postorder(TreeNode root, List<Integer> ds){
        if(root == null)
            return;
        postorder(root.left, ds);
        postorder(root.right, ds);
        ds.add(root.data);
    }


    public static  List<List<Integer>> bfs(TreeNode root){
        if(root == null)
            return Collections.emptyList();
        List<List<Integer>> ds = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        while (!queue.isEmpty()){
            int levelElementsCount = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < levelElementsCount ; i++){
                TreeNode node = queue.pollFirst();
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

    public static  List<Integer> preorderIterative(TreeNode root){
        if(root == null)
            return Collections.emptyList();
        List<Integer> ds = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pollFirst();
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

    public static  List<Integer> inorderIterative(TreeNode root){
        if(root == null)
            return Collections.emptyList();
        List<Integer> ds = new ArrayList<>();
        Deque<TreeNode> stack  = new LinkedList<>();
        TreeNode node = root;
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


    public static  List<Integer> postorderIterative2Stack(TreeNode root){
        if(root == null)
            return Collections.emptyList();
        Deque<TreeNode> stack = new LinkedList<>();
        var stackDs = new LinkedList<Integer>();
        stack.offerFirst(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pollFirst();
            stackDs.offerFirst(node.data);
            if(node.left != null){
                stack.offerFirst(node.left);
            }
            if(node.right != null){
                stack.offerFirst(node.right);
            }
        }
        return stackDs;
    }

    public static   void reverseCollection(List<Integer> list){
        for(int i = 0; i < (list.size() >> 1); i++){
           Integer temp = list.get(i);
            list.set(i, list.get(list.size() - i - 1));
            list.set(list.size()-i -1, temp);
        }
    }


    public static  List<Integer> postorderIterative1Stack(TreeNode root){
        if(root == null)
            return Collections.emptyList();
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> ds = new ArrayList<>();
        TreeNode node = root;
        while(node != null || !stack.isEmpty()){
            if(node != null){
                stack.offerFirst(node);
                node = node.left;
            }else {
                TreeNode temp = stack.peekFirst().right;
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

    public static  Map<String, List<Integer>> allDfs(TreeNode root){
        if(root == null)
            return Collections.emptyMap();

        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder =  new ArrayList<>();
        List<Integer> postorder =  new ArrayList<>();

        Deque<Pair> stack = new LinkedList<>();
        stack.offerFirst(new Pair(root, 1));
        while (!stack.isEmpty()){
            var pair = stack.pollFirst();
            if(pair.val == 1){
                preorder.add(pair.t.data);
                pair.val++;
                stack.offerFirst(pair);
                if(pair.t.left != null){
                    stack.offerFirst(new Pair(pair.t.left, 1));
                }
            }else if(pair.val == 2){
                inorder.add(pair.t.data);
                pair.val++;
                stack.offerFirst(pair);
                if(pair.t.right != null){
                    stack.offerFirst(new Pair(pair.t.right, 1));
                }
            }else if(pair.val == 3){
                postorder.add(pair.t.data);
            }
        }

        Map<String, List<Integer>> ds = new LinkedHashMap<>();
        ds.put("preorder", preorder);
        ds.put("inorder", inorder);
        ds.put("postorder", postorder);
        return ds;
    }


   public static  int height(TreeNode root){
        if(root == null)
            return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        return 1 + Math.max(lh, rh);
   }

   public static   int balancedTree(TreeNode root){
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


   public static  int diameter(TreeNode root, int[] diameter){
        if(root == null)
            return 0;

        int lh = diameter(root.left, diameter);

        int rh =  diameter(root.right, diameter);

        diameter[0] = Math.max(diameter[0], lh + rh);

        return 1 + Math.max(lh, rh);
   }


   public static  boolean identicalTree(TreeNode root1, TreeNode root2){
        if(root1 == null || root2 == null)
            return root1 == root2;

        if(!Objects.equals(root1.data, root2.data))
            return false;

        return identicalTree(root1.left, root2.left) && identicalTree(root2.right, root2.right);
   }


   public static  List<List<Integer>> zigzag(TreeNode root){
        if(root == null)
            return Collections.emptyList();
        Deque<TreeNode> queue = new LinkedList<>();
        boolean lefToRight = true;
        queue.offerLast(root);
        List<List<Integer>> ds = new ArrayList<>();
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i <levelSize; i++){
                TreeNode node = lefToRight ? queue.pollFirst() : queue.pollLast();
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
    public static  List<List<Integer>> zigzagSimple(TreeNode root){
        if(root == null)
            return Collections.emptyList();
        Deque<TreeNode> queue = new LinkedList<>();
        boolean lefToRight = true;
        queue.offerLast(root);
        List<List<Integer>> ds = new ArrayList<>();
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            Integer[] level = new Integer[levelSize];
            for(int i = 0; i <levelSize; i++){
                TreeNode node =  queue.pollFirst();
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


    public static  List<Integer>  leftBoundaryOfTree(TreeNode root, boolean withLeaf){
        if(root == null)
            return Collections.emptyList();
        List<Integer> ds = new ArrayList<>();
        TreeNode it = root;
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

    public static  List<Integer> rightBoundaryOfTree(TreeNode root, boolean withLeaf){
        if(root == null)
            return Collections.emptyList();
        List<Integer> ds = new ArrayList<>();
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


    public static  void inorderLeafOnly(TreeNode root, List<Integer> ds){
        if(root == null)
            return;
        inorderLeafOnly(root.left, ds);
        if(isLeaf(root)){
            ds.add(root.data);
        }
        inorderLeafOnly(root.right, ds);
    }

    public static  boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }

   public static  List<Integer> boundaryTraversalAnticlockwise(TreeNode root){
        if(root == null)
            return Collections.emptyList();
        List<Integer> ds = new ArrayList<>();
        if(!isLeaf(root))
            ds.add(root.data);
        List<Integer> leftBoundary = leftBoundaryOfTree(root.left, false);
        List<Integer> leafs = new ArrayList<>();
        inorderLeafOnly(root, leafs);
        List<Integer> rightBoundary = rightBoundaryOfTree(root.right, false);
        ds.addAll(leftBoundary);
        ds.addAll(leafs);
        for(int i = 0; i < rightBoundary.size(); i++){
            ds.add(rightBoundary.get(rightBoundary.size() -i -1));
        }
        return ds;
   }

    public static  List<Integer> boundaryTraversalClockwise(TreeNode root){
        if(root == null)
            return Collections.emptyList();
        List<Integer> ds = new ArrayList<>();
        if(!isLeaf(root))
            ds.add(root.data);
        List<Integer> rightBoundary = rightBoundaryOfTree(root.right, false);
        List<Integer> leafs = new ArrayList<>();
        inorderLeafOnly(root, leafs);
        List<Integer> leftBoundary = leftBoundaryOfTree(root.left, false);
        ds.addAll(rightBoundary);
        for(int i = 0; i < leafs.size(); i++){
            ds.add(leafs.get(leafs.size() -i -1));
        }
        for(int i = 0; i < leftBoundary.size(); i++){
            ds.add(leftBoundary.get(leftBoundary.size() -i -1));
        }
        return ds;
    }


    public static  List<List<Integer>> verticalLevelTraversal(TreeNode root){
        if(root == null)
            return Collections.emptyList();

        Map<Integer, Map<Integer, Collection<Integer>>> verticalLevelMap = new TreeMap<>();
        var queue = new LinkedList<Triplet>();
        queue.offerLast(new Triplet(root, 0, 0));

        while (!queue.isEmpty()){
            var triplet =  queue.pollFirst();

            var horizontalLevelMap = verticalLevelMap.putIfAbsent(triplet.val2, new TreeMap<>());

            var intersectionBag = horizontalLevelMap.computeIfAbsent(triplet.val1, it -> new PriorityQueue<>());


            intersectionBag.add(triplet.t.data);

            if(triplet.t.left != null){
                queue.offerLast(new Triplet(triplet.t.left, triplet.val1 + 1, triplet.val2 - 1));
            }

            if(triplet.t.right != null){
                queue.offerLast(new Triplet(triplet.t.right, triplet.val1 + 1, triplet.val2 + 1));
            }
        }

        List<List<Integer>> ds =  new ArrayList<>();
        for(Map<Integer, Collection<Integer>> horizontalLevelMap: verticalLevelMap.values()){
            List<Integer> verticalLevel = new ArrayList<>();
            for(Collection<Integer> intersectionBag: horizontalLevelMap.values()){
                verticalLevel.addAll(intersectionBag);
            }
            ds.add(verticalLevel);
        }
        return ds;
    }

    public static List<Integer> topView(TreeNode root){
        if(root == null)
            return Collections.emptyList();

        var queue = new LinkedList<Pair>();
        Map<Integer, Integer> topView = new TreeMap<>();
        queue.offerLast(new Pair(root, 0));
        while (!queue.isEmpty()){
            Pair pair = queue.pollFirst();
            topView.putIfAbsent(pair.val, pair.t.data);
            if(pair.t.left != null){
                queue.offerLast(new Pair(pair.t.left, pair.val -1));
            }

            if(pair.t.right != null){
                queue.offerLast(new Pair(pair.t.right, pair.val + 1));
            }
        }
        return new ArrayList<>(topView.values());
    }

    public static List<Integer> bottomView(TreeNode root){
        if(root == null)
            return Collections.emptyList();

        var queue = new LinkedList<Pair>();
        Map<Integer, Integer> bottomView = new TreeMap<>();
        queue.offerLast(new Pair(root, 0));
        while (!queue.isEmpty()){
            Pair pair = queue.pollFirst();
            bottomView.put(pair.val, pair.t.data);
            if(pair.t.left != null){
                queue.offerLast(new Pair(pair.t.left, pair.val -1));
            }

            if(pair.t.right != null){
                queue.offerLast(new Pair(pair.t.right, pair.val + 1));
            }
        }
        return new ArrayList<>(bottomView.values());
    }

 }



class Pair{
   TreeNode t;
    int val;

    public Pair(TreeNode t, int val) {
        Objects.requireNonNull(t);
        this.t = t;
        this.val = val;
    }
}

class Triplet{
   TreeNode t;
    int val1;
    int val2;

    public Triplet(TreeNode t, int val1, int val2) {
        Objects.requireNonNull(t);
        this.t = t;
        this.val1 = val1;
        this.val2 = val2;
    }
}

