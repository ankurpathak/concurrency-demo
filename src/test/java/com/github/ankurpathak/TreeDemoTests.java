package com.github.ankurpathak;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.github.ankurpathak.TreeDemo.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TreeDemoTests {


    private Integer[] rootSequence = new Integer[]{ 1, 2, 3, 4, 5, 7, 8, null,null, 6,null, null,null,9,10};
    private TreeNode<Integer> root;
    private List<Integer> ds = new ArrayList<>();

    @BeforeEach
    public void setUp(){
        root = create(rootSequence);
    }

    @Test
    public void testCreate(){
        assertThat(root).isNotNull();
    }

    @Test
    public void testPreorder(){
        assertThat(root).isNotNull();
        preorder(root, ds);
        assertThat(ds).isNotNull().isNotEmpty().containsExactlyElementsOf(List.of(1,2,4,5,6,3,7,8,9,10));
    }

    @Test
    public void testInorder(){
        assertThat(root).isNotNull();
        inorder(root, ds);
        assertThat(ds).isNotNull().isNotEmpty().containsExactlyElementsOf(List.of(4,2,6,5,1,7,3,9,8,10));
    }

    @Test
    public void testPostorder(){
        assertThat(root).isNotNull();
        postorder(root, ds);
        assertThat(ds).isNotNull().isNotEmpty().containsExactlyElementsOf(List.of(4, 6, 5, 2, 7, 9, 10, 8, 3, 1));
    }

    @Test
    public void testBfs(){
        assertThat(root).isNotNull();
        var ds =bfs(root);
        assertThat(ds).isNotNull().isNotEmpty().size().isEqualTo(4);
        assertThat(ds).containsExactly(
                List.of(1),
                List.of(2, 3),
                List.of(4, 5, 7, 8),
                List.of(6,9,10)
        );
    }


    @Test
    public void testZigzag(){
        assertThat(root).isNotNull();
        var ds = zigzag(root);
        assertThat(ds).isNotNull().isNotEmpty().size().isEqualTo(4);
        assertThat(ds).containsExactly(
                List.of(1),
                List.of(3,2),
                List.of(4, 5, 7, 8),
                List.of(10,9,6)
        );
    }


    @Test
    public void testZigzagSimple(){
        assertThat(root).isNotNull();
        var ds = zigzagSimple(root);
        assertThat(ds).isNotNull().isNotEmpty().size().isEqualTo(4);
        assertThat(ds).containsExactly(
                List.of(1),
                List.of(3,2),
                List.of(4, 5, 7, 8),
                List.of(10,9,6)
        );
    }


    @Test
    public void testPreorderIterative(){
        assertThat(root).isNotNull();
        assertThat(preorderIterative(root)).isNotNull().isNotEmpty().containsExactlyElementsOf(List.of(1,2,4,5,6,3,7,8,9,10));
    }


    @Test
    public void testInorderIterative(){
        assertThat(root).isNotNull();
        assertThat(inorderIterative(root)).isNotNull().isNotEmpty().containsExactlyElementsOf(List.of(4,2,6,5,1,7,3,9,8,10));
    }


    @Test
    public void testPostorder2StackIterative(){
        assertThat(root).isNotNull();
        assertThat(postorderIterative2Stack(root)).isNotNull().isNotEmpty().containsExactlyElementsOf(List.of(4, 6, 5, 2, 7, 9, 10, 8, 3, 1));
    }


    @Test
    public void testPostorder1StackIterative(){
        assertThat(root).isNotNull();
        assertThat(postorderIterative1Stack(root)).isNotNull().isNotEmpty().containsExactlyElementsOf(List.of(4, 6, 5, 2, 7, 9, 10, 8, 3, 1));
    }

    @Test
    public void tesAllDfs(){
        assertThat(root).isNotNull();
        assertThat(allDfs(root)).isNotNull().isNotEmpty().containsExactly(
                Map.entry("preorder", List.of(1,2,4,5,6,3,7,8,9, 10)),
                Map.entry("inorder", List.of(4,2,6,5,1,7,3,9,8,10)),
                Map.entry("postorder", List.of(4, 6, 5, 2, 7, 9, 10, 8, 3, 1))
        );
    }

    @Test
    public void testHeight(){
        assertThat(root).isNotNull();
        assertThat(height(root)).isEqualTo(4);
    }

    @Test
    public void testBalancedTree(){
        assertThat(root).isNotNull();
        assertThat(balancedTree(root)).isEqualTo(4);
        Integer[] notBalancedList = new Integer[]{1,2,4,3,null,5,6,9,null,null,null,null,null,null,7,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null, 8};
        TreeNode<Integer> notBalancedRoot = create(notBalancedList);
        assertThat(notBalancedRoot).isNotNull();
        assertThat(balancedTree(notBalancedRoot)).isEqualTo(-1);
    }


    @Test
    public void testDiameter(){
        assertThat(root).isNotNull();
        int[] diameter = new int[]{0};
        assertThat(diameter(root, diameter)).isEqualTo(4);
        assertThat(diameter).isNotNull().isNotEmpty().containsExactly(6);
        diameter = new int[]{0};
        Integer[] diameterList = new Integer[]{1,2,3, null, null, 4, 6, null, null, null, null, 5, null, null,7, null, null, null, null, null, null, null, null, 9,  null, null, null, null, null, null, 8};
        TreeNode<Integer> diameterListRoot = create(diameterList);
        assertThat(diameterListRoot).isNotNull();
        assertThat(diameter(diameterListRoot, diameter)).isEqualTo(5);
        assertThat(diameter).isNotNull().isNotEmpty().containsExactly(6);
    }


    @Test
    public void testIdenticalTree(){
        assertThat(root).isNotNull();
        TreeNode<Integer> root2 = create(rootSequence);
        assertThat(root2).isNotNull();
        assertThat(identicalTree(root, root2)).isTrue();
        Integer[] rootNotIdenticalSequence = new Integer[]{ 1, 2, 3, 4, 5, 7, 8, 11,null, 6,null, null,null,9,10};
        var root3 = create(rootNotIdenticalSequence);
        assertThat(root3).isNotNull();
        assertThat(identicalTree(root, root3)).isFalse();
    }


    @Test
    public void testLeftBoundary(){
        assertThat(root).isNotNull();
        assertThat(leftBoundaryOfTree(root.left, false)).containsExactly(2);
        assertThat(leftBoundaryOfTree(root.left, true)).containsExactly(2, 4);
    }




    @Test
    public void testRightBoundary(){
        assertThat(root).isNotNull();
        assertThat(rightBoundaryOfTree(root.right, false)).containsExactly(3, 8);
        assertThat(rightBoundaryOfTree(root.right, true)).containsExactly(3,8,10);
    }


    @Test
    public void testInorderLeafOnly(){
        assertThat(root).isNotNull();
        assertThat(ds).isNotNull().isEmpty();
        inorderLeafOnly(root, ds);
        assertThat(ds).isNotNull().isNotEmpty().containsExactly(4, 6, 7, 9, 10);
    }


    @Test
    public void testBoundaryAnticlockwise(){
        assertThat(root).isNotNull();
        assertThat(boundaryTraversalAnticlockwise(root)).isNotNull().isNotEmpty()
                .containsExactly(
                        1, 2, 4, 6,7,9,10,8,3
                );
    }


    @Test
    public void testBoundaryClockwise(){
        assertThat(root).isNotNull();
        assertThat(boundaryTraversalClockwise(root)).isNotNull().isNotEmpty()
                .containsExactly(
                        1, 3, 8, 10, 9, 7, 6, 4, 2
                );
    }







}
