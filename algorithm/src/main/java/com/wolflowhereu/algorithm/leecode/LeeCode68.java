package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jx09.
 * @Date 16-3-30.
 * @Discreption
 */
public class LeeCode68 {

    private List<String> result = new ArrayList<>();
    private boolean bigThanMaxWidth = false;

    /**
     * https://leetcode.com/problems/text-justification/
     *
     * @param words
     * @param maxWidth
     * @return
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        fullJustify(words, maxWidth, 0);
        if (bigThanMaxWidth) return new ArrayList<>();
        return result;
    }

    public void fullJustify(String[] words, int maxWidth, int start) {
        if (start >= words.length) return;

        int end = start, width = 0;
        while (end < words.length) {
            words[end] = words[end].trim();
            if (words[end].length() > maxWidth) {
                bigThanMaxWidth = true;
                return;
            }
            if (words[end].length() + width + end - start > maxWidth) break;
            width += words[end].length();
            end++;
        }
        int blankCount = maxWidth - width, wordCount = end - start;
        String word = "";

        for (int j = 0; j < wordCount; j++) {
            int wordWidth = words[start + j].length();
            if (wordCount == 1) wordWidth += blankCount;
            else if (end == words.length) {
                if (j == wordCount - 1) wordWidth = maxWidth - width + wordWidth - wordCount + 1;
                else wordWidth++;
            } else {
                if (j != wordCount - 1) {
                    wordWidth += blankCount / (wordCount - 1);
                    if (blankCount % (wordCount - 1) > j) wordWidth++;
                }
            }
            if (wordWidth > 0)
                word += String.format("%1$-" + wordWidth + "s", words[start + j]);
        }

        result.add(word);

        fullJustify(words, maxWidth, end);
    }


    @Test
    public void test() {
        fullJustify(new String[]{"1234567891123", "b", "c", "b"}, 14).stream().forEach(s -> System.out.println("|" + s + "|"));
    }
}
