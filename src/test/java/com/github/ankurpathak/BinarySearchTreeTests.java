package com.github.ankurpathak;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.github.ankurpathak.BinarySearchTree.*;
import static com.github.ankurpathak.TreeDemo.inorder;
import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchTreeTests {
    private int[] rootSequence = new int[]{12, 25, 37, 50, 62, 75, 87};
    private TreeNode root;
    private List<Integer> ds = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        root = createBst(rootSequence);
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


}
