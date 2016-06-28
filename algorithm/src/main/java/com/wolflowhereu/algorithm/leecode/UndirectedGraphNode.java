package com.wolflowhereu.algorithm.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fan on 16-6-27.
 */
public class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
}
