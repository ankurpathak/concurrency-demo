package com.github.ankurpathak;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static com.github.ankurpathak.GraphCycle.*;
import static org.assertj.core.api.Assertions.assertThat;

public class GraphCycleTests {

    private List<List<Integer>> firstGraph;
    private List<List<Integer>> firstDirectedGraph;
    private List<List<Integer>> firstNonCycleGraph;
    private List<List<Integer>> firstDirectedNonCycleGraph;
    private List<List<Integer>> firstNonBipartiteGraph;


    @BeforeEach
    public void setup() {
        firstGraph = List.of(
                Collections.emptyList(), //0
                List.of(2), //1
                List.of(1, 3, 8), //2
                List.of(2, 4, 5), //3
                List.of(3, 6), //4
                List.of(3, 7), //5
                List.of(4), //6
                List.of(5, 8), //7
                List.of(2, 7) //8
        );


        firstDirectedGraph = List.of(
                Collections.emptyList(), //0
                List.of(2), //1
                List.of(3, 9), //2
                List.of(4, 8), //3
                List.of(5), //4
                List.of(6), //5
                List.of(7), //6
                Collections.emptyList(), //7
                List.of(6), //8
                List.of(10), //9
                List.of(11), //10
                List.of(9)  //11
        );


        firstNonCycleGraph = List.of(
                Collections.emptyList(), //0
                List.of(2), //1
                List.of(1, 3, 4), //2
                List.of(2), //3
                List.of(2, 5), //4
                List.of(4) //5
        );


        firstDirectedNonCycleGraph = List.of(
                Collections.emptyList(), //0
                List.of(2), //1
                List.of(3, 4), //2
                Collections.emptyList(), //3
                List.of(5), //4
                Collections.emptyList() //5
        );


        firstNonBipartiteGraph = List.of(
                Collections.emptyList(), //0
                List.of(2), //1
                List.of(1, 3), //2
                List.of(2, 4, 7), //3
                List.of(3, 5, 8), //4
                List.of(4, 6), //5
                List.of(5, 7), //6
                List.of(3, 6), //7
                List.of(4)  //8
        );


    }

    @Test
    public void testDfsCycle() {
        assertThat(firstGraph).isNotNull().isNotEmpty();
        assertThat(dfsCycleChecker(firstGraph)).isTrue();

        assertThat(firstNonCycleGraph).isNotNull().isNotEmpty();
        assertThat(dfsCycleChecker(firstNonCycleGraph)).isFalse();
    }

    @Test
    public void testBfsCycle() {
        assertThat(firstGraph).isNotNull().isNotEmpty();
        assertThat(bfsCycleChecker(firstGraph)).isTrue();

        assertThat(firstNonCycleGraph).isNotNull().isNotEmpty();
        assertThat(bfsCycleChecker(firstNonCycleGraph)).isFalse();
    }

    @Test
    public void testDfsDirectedCycle() {
        assertThat(firstDirectedGraph).isNotNull().isNotEmpty();
        assertThat(dfsDirectedCycleChecker(firstDirectedGraph)).isTrue();

        assertThat(firstDirectedNonCycleGraph).isNotNull().isNotEmpty();
        assertThat(dfsDirectedCycleChecker(firstDirectedNonCycleGraph)).isFalse();
    }


    @Test
    public void testNonBipartiteGraph() {
        assertThat(firstNonBipartiteGraph).isNotNull().isNotEmpty();
        assertThat(notBipartiteChecker(firstNonBipartiteGraph)).isTrue();
    }
}
