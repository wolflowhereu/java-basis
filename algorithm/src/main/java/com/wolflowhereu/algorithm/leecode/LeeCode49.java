package com.wolflowhereu.algorithm.leecode;

import java.util.*;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode49 {
    /**
     * https://leetcode.com/problems/anagrams/
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (String str : strs) {
            String key = getSortKey(str);
            int index = map.getOrDefault(key, -1);
            List<String> list;
            if (index >= 0) list = result.get(index);
            else {
                list = new ArrayList<>();
                map.put(key, result.size());
                result.add(list);
            }
            list.add(str);
        }

        result.stream().forEach(strings -> Collections.sort(strings));

        return result;
    }

    /**
     * 字符串重新排序
     *
     * @param str
     * @return
     */
    private static String getSortKey(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}
