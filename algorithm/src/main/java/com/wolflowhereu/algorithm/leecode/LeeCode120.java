package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanhongbin on 2016/4/20.
 */
public class LeeCode120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 0; i < triangle.size() - 1; i++) {
            List<Integer> list = triangle.get(i);
            List<Integer> nextList = triangle.get(i + 1);
            int back = list.get(0);
            for (int j = 0; j < list.size(); j++) {
                int value = nextList.get(j) + Math.min(back, list.get(j));
                back = list.get(j);
                nextList.set(j, value);
            }
            nextList.set(nextList.size() - 1, nextList.get(nextList.size() - 1) + back);
        }
        if (triangle.size() <= 0) return 0;

        List<Integer> last = triangle.get(triangle.size() - 1);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < last.size(); i++) {
            if (result > last.get(i)) result = last.get(i);
        }
        return result;
    }

    @Test
    public void test() {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        triangle.add(l1);
        List<Integer> l2 = new ArrayList<>();
        triangle.add(l2);
        List<Integer> l3 = new ArrayList<>();
        triangle.add(l3);
//        List<Integer> l4 = new ArrayList<>();
//        triangle.add(l4);
//[[-1],[3,2],[1,-2,-1]]   2 1
        l1.add(-1);
        l2.add(3);
        l2.add(2);
        l3.add(1);
        l3.add(-2);
        l3.add(-1);
//        l4.add(4);
//        l4.add(1);
//        l4.add(8);
//        l4.add(3);
        System.out.println(minimumTotal(triangle));
    }
}
