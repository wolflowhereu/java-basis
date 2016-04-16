package com.wolflowhereu.algorithm.leecode;

import java.util.List;

/**
 * @author jx09.
 * @Date 16-3-29.
 * @Discreption
 */
public class LeeCode57 {

    /**
     * https://leetcode.com/problems/insert-interval/
     * @param intervals
     * @param newInterval
     * @return
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int index = 0;
        for (; index < intervals.size(); index++) {
            if (intervals.get(index).start > newInterval.end) break;
            if (newInterval.start > intervals.get(index).end) continue;
            newInterval.start = Math.min(newInterval.start, intervals.get(index).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(index).end);
            intervals.remove(index);
            index--;
        }

        if (index >= intervals.size()) intervals.add(newInterval);
        else intervals.add(index, newInterval);
        return intervals;
    }
}
