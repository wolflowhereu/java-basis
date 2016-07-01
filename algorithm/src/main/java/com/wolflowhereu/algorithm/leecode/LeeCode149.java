package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by fan on 16-7-1.
 */
public class LeeCode149 {

    /**
     * https://leetcode.com/problems/max-points-on-a-line/
     *
     * @param points
     * @return
     */
    public int maxPoints(Point[] points) {
        if (points.length <= 2) return points.length;
        int max = 0;
        Map<String, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                String key = getKey(points[i], points[j]);
                Set<Integer> set = map.get(key);
                if (set == null) set = new HashSet<>();
                map.put(key, set);
                set.add(i);
                set.add(j);
                if (set.size() > max) max = set.size();
            }
        }
        return max;
    }


    private String getKey(Point p1, Point p2) {
        if (p1.x == p2.x && p1.y == p2.y) return "s_" + p1.x + "_" + p1.y;
        int x = p2.x - p1.x;
        int y = p2.y - p1.y;
        if (x == 0) return p1.x + "-";
        if (y == 0) return "-" + p1.y;
        double k = ((double) y) / x;

        double b = p1.y - (y * p1.x) / (x);
        return k + "-" + b;
    }

    @Test
    public void test2() {
        Point[] points = new Point[]{new Point(560, 248), new Point(0, 16), new Point(560, 248)};
        maxPoints(points);
    }

}
