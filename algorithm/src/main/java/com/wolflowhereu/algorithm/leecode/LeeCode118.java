package com.wolflowhereu.algorithm.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanhongbin on 2016/4/20.
 */
public class LeeCode118 {

    /**
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            int back = 0;
            for (int j = 0; j < i; j++) {
                int value = result.get(i - 1).get(j);
                list.add(value + back);
                back = value;
            }
            list.add(1);
            result.add(list);
        }
        return result;
    }
}
