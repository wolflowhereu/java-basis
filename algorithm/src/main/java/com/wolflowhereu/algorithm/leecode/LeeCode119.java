package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanhongbin on 2016/4/20.
 */
public class LeeCode119 {
    /**
     * https://leetcode.com/problems/pascals-triangle-ii/
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        rowIndex++;
        for (int i = 0; i < rowIndex; i++) {
            int back = 0;
            for (int j = 0; j < list.size(); j++) {
                int value = list.get(j);
                list.set(j, value + back);
                back = value;
            }
            list.add(1);
        }
        return list;
    }


    @Test
    public void test() {
        System.out.println(getRow(10));
    }
}
