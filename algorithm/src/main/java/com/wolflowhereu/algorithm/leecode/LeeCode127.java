package com.wolflowhereu.algorithm.leecode;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by fanhongbin on 2016/4/21.
 */
public class LeeCode127 {

    /**
     * https://leetcode.com/problems/word-ladder/
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        // length * 26    size
        if (beginWord.length() * 26 > wordList.size()) {
            return ladderLength(Stream.of(new String[]{beginWord}).collect(Collectors.toSet()), endWord, wordList);
        }
        return ladderLength2(beginWord, endWord, wordList);
    }

    public int ladderLength2(String beginWord, String endWord, Set<String> wordList) {
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        int size = 1, count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i >= size) {
                count++;
                size = list.size();
            }
            beginWord = list.get(i);
            if (distance(beginWord, endWord) <= 1) return count + 2;

            if (!wordList.isEmpty()) {
                for (int j = 0; j < beginWord.length(); j++) {
                    char[] currCharArr = beginWord.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        currCharArr[j] = c;
                        String newWord = new String(currCharArr);
                        if (wordList.remove(newWord)) {
                            list.add(newWord);
                        }
                    }
                }
            }
        }
        return 0;
    }

    public int ladderLength(Set<String> beginWordSet, String endWord, Set<String> wordList) {
        Set<String> newBeginWordSet = new HashSet<>();
        if (beginWordSet.isEmpty()) return 0;
        if (beginWordSet.parallelStream().anyMatch(s -> distance(s, endWord) <= 1)) return 2;
        Set<String> newWordList = wordList.parallelStream().filter(s ->
                !beginWordSet.parallelStream().anyMatch(s1 -> {
                    if (distance(s, s1) == 1) {
                        newBeginWordSet.add(s);
                        return true;
                    }
                    return false;
                })
        ).collect(Collectors.toSet());
        int length = ladderLength(newBeginWordSet, endWord, newWordList);
        if (length > 0) length++;
        return length;
    }

    public int distance(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) diff++;
        }
        return diff;
    }


    @Test
    public void test() {
        Assert.assertEquals(5, ladderLength2("hit", "cog", Stream.of(new String[]{"hot", "dot", "dog", "lot", "log"}).collect(Collectors.toSet())));
        Assert.assertEquals(ladderLength2("hot", "dog", Stream.of(new String[]{"hot", "dog"}).collect(Collectors.toSet())), 0);
    }
}
