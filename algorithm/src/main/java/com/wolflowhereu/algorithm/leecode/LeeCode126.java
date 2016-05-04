package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by fanhongbin on 2016/4/21.
 */
public class LeeCode126 {

    /**
     * https://leetcode.com/problems/word-ladder-ii/
     * @param start
     * @param end
     * @param dict
     * @return
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<>();  // Neighbors for every node
        HashMap<String, Integer> distance = new HashMap<>();  // Distance of every node from the start node
        ArrayList<String> solution = new ArrayList<>();

        dict.add(end);
        bfs(start, end, dict, nodeNeighbors, distance);
        dfs(start, end, nodeNeighbors, distance, solution, res);
        return res;
    }

    /**
     * BFS: Trace every node's distance from the start node (level by level).
     *
     * @param start
     * @param end
     * @param dict
     * @param nodeNeighbors
     * @param distance
     */
    private void bfs(String start, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance) {
        for (String str : dict){
            nodeNeighbors.put(str, new ArrayList<>());
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distance.put(start, 0);

        while (!queue.isEmpty()) {
            int count = queue.size();
            boolean foundEnd = false;
            for (int i = 0; i < count; i++) {
                String cur = queue.poll();
                int curDistance = distance.get(cur);
                ArrayList<String> neighbors = getNeighbors(cur, dict);

                for (String neighbor : neighbors) {
                    nodeNeighbors.get(cur).add(neighbor);
                    if (!distance.containsKey(neighbor)) {// Check if visited
                        distance.put(neighbor, curDistance + 1);
                        if (end.equals(neighbor))// Found the shortest path
                            foundEnd = true;
                        else
                            queue.offer(neighbor);
                    }
                }
            }

            if (foundEnd) break;
        }
    }

    /**
     * Find all next level nodes.
     * @param node
     * @param dict
     * @return
     */
    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        char chs[] = node.toCharArray();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }

    /**
     * DFS: output all paths with the shortest distance.
     * @param cur
     * @param end
     * @param nodeNeighbors
     * @param distance
     * @param solution
     * @param res
     */
    private void dfs(String cur, String end, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
        solution.add(cur);
        if (end.equals(cur)) {
            res.add(new ArrayList<>(solution));
        } else {
            nodeNeighbors.get(cur).stream().filter(next -> distance.get(next) == distance.get(cur) + 1).forEach(next -> dfs(next, end, nodeNeighbors, distance, solution, res));
        }
        solution.remove(solution.size() - 1);
    }


    @Test
    public void test() {
        System.out.println(findLadders("hot", "dog", Stream.of(new String[]{"hot", "dog", "dot"}).collect(Collectors.toSet())));
    }
}
