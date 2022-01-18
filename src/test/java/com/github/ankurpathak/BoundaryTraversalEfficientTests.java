package com.github.ankurpathak;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.ankurpathak.BoundaryTraversalEfficient.boundaryTraversalAnticlockwise;
import static com.github.ankurpathak.BoundaryTraversalEfficient.boundaryTraversalClockwise;
import static com.github.ankurpathak.TreeDemo.create;
import static org.assertj.core.api.Assertions.assertThat;

public class BoundaryTraversalEfficientTests {
    private Integer[] rootSequence = new Integer[]{ 1, 2, 3, 4, 5, 7, 8, null,null, 6,null, null,null,9,10};
    private TreeNode<Integer> root;

    @BeforeEach
    public void setUp(){
        root = create(rootSequence);
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
