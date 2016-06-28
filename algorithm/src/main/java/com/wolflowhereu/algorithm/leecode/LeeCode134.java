package com.wolflowhereu.algorithm.leecode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fan on 16-6-27.
 */
public class LeeCode134 {

    /**
     * https://leetcode.com/problems/gas-station/
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int remain = 0, start = 0, end = 0, length = gas.length;

        while (start < length && end < length * 2) {
            if (end - start == gas.length) return start;
            remain += gas[end % length] - cost[end % length];
            while (remain < 0) {
                remain -= gas[start % length] - cost[start % length];
                start++;
            }
            end++;
        }
        return -1;
    }

    @Test
    public void test() {
        Assert.assertEquals(3, canCompleteCircuit(new int[]{}, new int[]{}));
    }
}
