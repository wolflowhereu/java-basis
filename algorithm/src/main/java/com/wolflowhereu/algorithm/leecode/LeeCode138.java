package com.wolflowhereu.algorithm.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fan on 16-6-28.
 */
public class LeeCode138 {

    private Map<Integer, RandomListNode> map = new HashMap<>();

    /**
     * https://leetcode.com/problems/copy-list-with-random-pointer/
     * @param head
     * @return
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head==null) return null;
        if (map.containsKey(head.label)) return map.get(head.label);
        RandomListNode randomListNode = new RandomListNode(head.label);
        map.put(randomListNode.label, randomListNode);
        randomListNode.next = copyRandomList(head.next);
        randomListNode.random = copyRandomList(head.random);
        return randomListNode;
    }
}
