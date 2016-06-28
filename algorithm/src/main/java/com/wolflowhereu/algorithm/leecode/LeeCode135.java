package com.wolflowhereu.algorithm.leecode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fan on 16-6-27.
 */
public class LeeCode135 {

    /**
     * https://leetcode.com/problems/candy/
     *
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        if (ratings.length <= 0) return 0;
        int sum = 0, pre = ratings[0], preCandy = 1, preMaxIndex = 0, preMax = 1;

        for (int i = 0; i < ratings.length; i++) {
            if (ratings[i] > pre) {
                preCandy++;
                sum += preCandy;
                preMaxIndex = i;
                preMax = preCandy;
            } else if (pre == ratings[i]) {
                preCandy = 1;
                sum += preCandy;
                preMaxIndex = i;
                preMax = preCandy;
            } else {
                sum += i - preMaxIndex;
                if (i - preMaxIndex >= preMax) {
                    sum++;
                }
                preCandy = 1;
            }
            pre = ratings[i];
        }

        return sum;
    }


    //[0,-1,3,-3,-2,-5,3,-2]
    // 1  0 1  0 -1 -2 -1 -2
    // 4  3 4  3  2  1  2  1
    @Test
    public void test() {//12

        Assert.assertEquals(16, candy(new int[]{4, 3, 4, 3, 2, 1, 2, 1}));
    }
}
