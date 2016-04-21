package com.wolflowhereu.algorithm.leecode;

/**
 * Created by fanhongbin on 2016/4/20.
 */
public class LeeCode122 {

    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 0) return 0;
        int min = Integer.MAX_VALUE, max = Integer.MAX_VALUE, result = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < max) {
                result += max - min;
                min = max = prices[i];
                continue;
            } else max = prices[i];
        }

        result += max - min;

        return result;

    }
}
