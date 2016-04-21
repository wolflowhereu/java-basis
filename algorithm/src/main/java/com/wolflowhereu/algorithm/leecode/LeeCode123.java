package com.wolflowhereu.algorithm.leecode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fanhongbin on 2016/4/20.
 */
public class LeeCode123 {
    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 0) return 0;
        int max = prices[0], min = prices[0];
        int[] dpPre = new int[prices.length], dpPost = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > max) max = prices[i];
            if (prices[i] < min) max = min = prices[i];
            dpPre[i] = Math.max(max - min, dpPre[i - 1]);
        }

        max = prices[prices.length - 1];
        min = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] > max) min = max = prices[i];
            if (prices[i] < min) min = prices[i];
            dpPost[i] = Math.max(max - min, dpPost[i + 1]);
        }

        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            result = Math.max(result, dpPre[i] + dpPost[i]);
        }
        return result;
    }


    @Test
    public void test() {
        Assert.assertEquals(maxProfit(new int[]{1, 2, 3, 4, 1, 2, 3, 4, 1, 10, 9, 8, 6, 2, 5, 1}), 12);
        Assert.assertEquals(maxProfit(new int[]{2, 1, 2, 0, 1}), 2);
    }
}
