package com.wolflowhereu.algorithm.leecode;

/**
 * Created by fanhongbin on 2016/4/20.
 */
public class LeeCode121 {

    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int result = 0, min = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                int value = prices[i] - min;
                if (value > result) result = value;
            }
        }

        return result;
    }
}
