package com.github.ankurpathak;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.github.ankurpathak.BinarySearchTree.*;
import static com.github.ankurpathak.TreeDemo.inorder;
import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchTreeTests {
    private int[] rootSequence = new int[]{12, 25, 37, 50, 62, 75, 87};
    private int[] secondRootSequence = new int[]{10, 20, 30, 50, 60, 70, 80};
    private int[] thirdRootSequence = new int[]{12, 25, 30, 37, 40, 50, 60, 62, 70, 75, 87};
    private TreeNode root;
    private TreeNode secondRoot;
    private TreeNode thirdRoot;
    private List<Integer> ds = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        root = createBst(rootSequence);
        secondRoot = createBst(secondRootSequence);
        thirdRoot = createBst(thirdRootSequence);
    }

    @Test
    public void testCreateBst() {
        assertThat(root).isNotNull();
        inorder(root, ds);
        assertThat(ds).isNotNull().isNotEmpty().containsExactly(12, 25, 37, 50, 62, 75, 87);
    }


    @Test
    public void testMax() {
        assertThat(root).isNotNull();
        assertThat(max(root)).isNotNull().extracting("val").isEqualTo(87);
        assertThat(max(null)).isNull();
    }


    @Test
    public void testMin() {
        assertThat(root).isNotNull();
        assertThat(min(root)).isNotNull().extracting("val").isEqualTo(12);
        assertThat(min(null)).isNull();
    }


    @Test
    public void testFind() {
        assertThat(root).isNotNull();
        assertThat(find(root, 50)).isNotNull().extracting("val").isEqualTo(50);

        assertThat(root).isNotNull();
        assertThat(find(root, 60)).isNull();
    }


    @Test
    public void testCeil() {
        assertThat(root).isNotNull();
        assertThat(ceil(root, 49)).isNotNull().extracting("val").isEqualTo(50);

        assertThat(root).isNotNull();
        assertThat(ceil(root, 50)).isNotNull().extracting("val").isEqualTo(50);


        assertThat(root).isNotNull();
        assertThat(ceil(root, 1000)).isNotNull().extracting("val").isEqualTo(Integer.MAX_VALUE);
    }


    @Test
    public void testFloor() {
        assertThat(root).isNotNull();
        assertThat(floor(root, 51)).isNotNull().extracting("val").isEqualTo(50);


        assertThat(root).isNotNull();
        assertThat(floor(root, 50)).isNotNull().extracting("val").isEqualTo(50);


        assertThat(root).isNotNull();
        assertThat(floor(root, -1000)).isNotNull().extracting("val").isEqualTo(Integer.MIN_VALUE);
    }

    @Test
    public void testReplaceWithSumOfSmaller() {
        assertThat(secondRoot).isNotNull();
        replaceBySumOfSmaller(secondRoot, new int[]{0});
        inorder(secondRoot, ds);
        assertThat(ds).isNotNull().isNotEmpty().containsExactly(0, 10, 30, 60, 110, 170, 240);
    }

    @Test
    public void testReplaceWithSumOfSmaller1() {
        assertThat(secondRoot).isNotNull();
        replaceBySumOfSmaller1(secondRoot, 0);
        inorder(secondRoot, ds);
        assertThat(ds).isNotNull().isNotEmpty().containsExactly(0, 10, 30, 60, 110, 170, 240);
    }


    @Test
    public void testReplaceWithSumOfLarger() {
        assertThat(secondRoot).isNotNull();
        replaceBySumOfLarger(secondRoot, new int[]{0});
        inorder(secondRoot, ds);
        Collections.reverse(ds);
        assertThat(ds).isNotNull().isNotEmpty().containsExactly(0, 80, 150, 210, 260, 290, 310);
    }


    @Test
    public void testReplaceWithSumOfLarger1() {
        assertThat(secondRoot).isNotNull();
        replaceBySumOfLarger1(secondRoot, 0);
        inorder(secondRoot, ds);
        Collections.reverse(ds);
        assertThat(ds).isNotNull().isNotEmpty().containsExactly(0, 80, 150, 210, 260, 290, 310);
    }


    @Test
    public void testCollectInRange() {
        assertThat(thirdRoot).isNotNull();
        collectInRange(thirdRoot, 35, 65, ds);
        assertThat(ds).isNotNull().isNotEmpty().containsExactly(37, 40, 50, 60, 62);
    }


}
