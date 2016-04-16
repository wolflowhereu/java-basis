package com.wolflowhereu.algorithm.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode30 {
    /**
     * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
     *
     * @param s
     * @param words
     * @return
     */
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words == null || words.length <= 0) return result;
        int length = words[0].length();
        Map<String, Integer> wordMap = new HashMap<>();
        Map<String, Integer> markMap = new HashMap<>();
        for (String word : words) {
            Integer count = wordMap.getOrDefault(word, 0);
            wordMap.put(word, count + 1);
        }


        for (int i = 0; i <= s.length() - length * words.length; i++) {
            int count = 0;
            markMap.clear();
            for (int j = 0; j < words.length; j++) {
                int k = i + j * length;
                String word = s.substring(k, k + length);
                if (wordMap.containsKey(word)) {
                    markMap.put(word, markMap.getOrDefault(word, 0) + 1);
                } else break;

                if (markMap.get(word) > wordMap.get(word)) break;
                count++;
            }

            if (count == words.length) result.add(i);
        }

        return result;
    }

}
