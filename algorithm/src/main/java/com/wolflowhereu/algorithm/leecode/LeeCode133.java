package com.wolflowhereu.algorithm.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fan on 16-6-27.
 */
public class LeeCode133 {

    private Map<Integer, UndirectedGraphNode> map = new HashMap<>();

    /**
     * https://leetcode.com/problems/clone-graph/
     *
     * @param node
     * @return
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return node;
        if (map.containsKey(node.label)) return map.get(node.label);
        UndirectedGraphNode undirectedGraphNode = new UndirectedGraphNode(node.label);
        map.put(undirectedGraphNode.label, undirectedGraphNode);
        node.neighbors.forEach(node2 -> undirectedGraphNode.neighbors.add(cloneGraph(node2)));
        return undirectedGraphNode;
    }


}
