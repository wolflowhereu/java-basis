package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

import java.util.*;

/**
 * Created by fan on 16-6-28.
 */
public class LeeCode140 {

    private Map<String, List<String>> map = new HashMap<>();

    /**
     * https://leetcode.com/problems/word-break-ii/
     *
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {

        if (map.containsKey(s)) return map.get(s);
        List<String> result = new ArrayList<>();
        if (wordDict.contains(s)) result.add(s);
        for (int i = 1; i < s.length(); i++) {
            String subString = s.substring(0, i);
            if (wordDict.contains(subString)) {
                List<String> tmp = wordBreak(s.substring(i), wordDict);
                for (int j = 0; j < tmp.size(); j++) {
                    result.add(j, subString + " " + tmp.get(j));
                }
            }
        }
        map.put(s, result);
        return result;
    }


    @Test
    public void test() {
        HashSet<String> objects = new HashSet<>();
        objects.add("cat");
        objects.add("cats");
        objects.add("and");
        objects.add("sand");
        objects.add("dog");
        System.out.println(wordBreak("catsanddog", objects));
        System.out.println(wordBreak("catsanddog", objects));
    }
}
