package com.github.ankurpathak;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
}
