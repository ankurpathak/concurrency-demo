package com.github.ankurpathak;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static com.github.ankurpathak.GraphDemo.bfsTraversal;
import static com.github.ankurpathak.GraphDemo.dfsTraversal;
import static org.assertj.core.api.Assertions.assertThat;

public class GraphDemoTests {
    private List<List<Integer>> firstGraph;
    private List<List<Integer>> secondGraph;
    private List<List<Integer>> thirdGraph;
    private List<List<Integer>> fourthGraph;


    @BeforeEach
    public void setup() {
        firstGraph = List.of(
                Collections.emptyList(), //0
                List.of(2, 5), //1
                List.of(1, 3), //2
                List.of(2, 5), //3
                List.of(6), //4
                List.of(1, 3), //5
                List.of(4) //6
        );

        secondGraph = List.of(
                Collections.emptyList(), //0
                List.of(2), //1
                List.of(1, 3), //2
                List.of(2, 4), //3
                List.of(3, 5, 7, 8), //4
                List.of(4, 6), //5
                List.of(5), //6
                List.of(4, 8), //7
                List.of(4, 7) //8
        );

        thirdGraph = List.of(
                Collections.emptyList(), //0
                List.of(2, 8), //1
                List.of(1, 3), //2
                List.of(2, 4, 8), //3
                List.of(3, 5, 7), //4
                List.of(4, 6), //5
                List.of(5, 7), //6
                List.of(4, 6), //7
                List.of(1, 3, 9, 10), //8
                List.of(8, 10), //9
                List.of(8, 9) //10
        );

        fourthGraph = List.of(
                Collections.emptyList(), //0
                List.of(2, 3, 4), //1
                List.of(1, 6), //2
                List.of(1, 5), //3
                List.of(1, 7), //4
                List.of(3, 8), //5
                List.of(2, 9), //6
                List.of(4, 8), //7
                List.of(5, 7), //8
                List.of(6, 10), //9
                List.of(9) //10
        );
    }


    @Test
    public void testDfs() {
        assertThat(firstGraph).isNotNull().isNotEmpty();
        assertThat(dfsTraversal(firstGraph)).isNotNull().isNotEmpty().containsExactly(1, 2, 3, 5, 4, 6);
        assertThat(secondGraph).isNotNull().isNotEmpty();
        assertThat(dfsTraversal(secondGraph)).isNotNull().isNotEmpty().containsExactly(1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(thirdGraph).isNotNull().isNotEmpty();
        assertThat(dfsTraversal(thirdGraph)).isNotNull().isNotEmpty().containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }


    @Test
    public void testBfs() {
        assertThat(fourthGraph).isNotNull().isNotEmpty();
        assertThat(bfsTraversal(fourthGraph)).isNotNull().isNotEmpty().containsExactly(1,2,3,4,6,5,7,9,8,10);
    }

}
