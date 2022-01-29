package com.github.ankurpathak;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static com.github.ankurpathak.GraphToposort.bfsToposort;
import static com.github.ankurpathak.GraphToposort.dfsToposort;
import static org.assertj.core.api.Assertions.assertThat;

public class GraphTopsortTests {
    private List<List<Integer>> firstGraph;


    @BeforeEach
    public void setup() {
        firstGraph = List.of(
                Collections.emptyList(), //0
                Collections.emptyList(), //1
                List.of(3), //2
                List.of(4), //3
                Collections.emptyList(), //4
                List.of(1, 6), //5
                List.of(4) //6
        );
    }


    @Test
    public void testBfsToposort() {
        assertThat(firstGraph).isNotNull().isNotEmpty();
        assertThat(bfsToposort(firstGraph)).isNotNull().isNotEmpty().containsExactly(2, 5, 3, 1, 6, 4);

    }


    @Test
    public void testDfsToposort() {
        assertThat(firstGraph).isNotNull().isNotEmpty();
        assertThat(dfsToposort(firstGraph)).isNotNull().isNotEmpty().containsExactly(5, 6, 2, 3, 4, 1);

    }


}
