package com.github.ankurpathak;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'journeyToMoon' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY astronaut
     */

    public static int journeyToMoon(int n, List<List<Integer>> astronaut) {
        boolean[] visited = new boolean[n];

        List<List<Integer>> collector = new ArrayList<>();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (List<Integer> edge : astronaut) {
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }


        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                component.add(i);
                dfs(graph, i, visited, component);
                collector.add(component);
            }
        }

        long ans = 1L * n * (n - 1) / 2;
        for (List<Integer> component : collector) {
            long size = component.size();
            ans -= ((1L * size * (size - 1) / 2));
        }

        return (int) ans;

    }


    private static void dfs(List<List<Integer>> graph, int i, boolean[] visited, List<Integer> component) {
        visited[i] = true;

        for (Integer it : graph.get(i)) {
            if (!visited[it]) {
                component.add(it);
                dfs(graph, it, visited, component);
            }
        }
    }

}

class Solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/input.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/output.txt"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int p = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> astronaut = new ArrayList<>();

        IntStream.range(0, p).forEach(i -> {
            try {
                astronaut.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.journeyToMoon(n, astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
