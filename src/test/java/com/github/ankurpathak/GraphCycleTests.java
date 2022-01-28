package com.github.ankurpathak;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static com.github.ankurpathak.GraphCycle.dfsCycleChecker;
import static org.assertj.core.api.Assertions.assertThat;

public class GraphCycleTests {

    private List<List<Integer>> firstGraph;


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
    }

    @Test
    public void testDfsCycle() {
        assertThat(firstGraph).isNotNull().isNotEmpty();
        assertThat(dfsCycleChecker(firstGraph)).isTrue();
    }

    @Test
    public void testBfsCycle() {
        assertThat(firstGraph).isNotNull().isNotEmpty();
        assertThat(dfsCycleChecker(firstGraph)).isTrue();
    }
}
