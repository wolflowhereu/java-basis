package com.wolflowhereu.algorithm.leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jx09.
 * @Date 16-3-29.
 * @Discreption
 */
public class LeeCode56 {
    public List<Interval> merge(List<Interval> intervals) {
        ArrayList<Interval> list = new ArrayList<>();
        if (intervals == null || intervals.size() <= 0) return list;

        Collections.sort(intervals, (o1, o2) -> o1.start < o2.start ? -1 : o1.start == o2.start ? (o1.end < o2.end ? -1 : o1.end == o2.end ? 0 : 1) : 1);
        intervals.forEach(interval -> {
            if (list.isEmpty()) list.add(interval);
            Interval last = list.get(list.size() - 1);
            if (last.end >= interval.start) last.end = last.end > interval.end ? last.end : interval.end;
            else list.add(interval);
        });
        return list;
    }
}
